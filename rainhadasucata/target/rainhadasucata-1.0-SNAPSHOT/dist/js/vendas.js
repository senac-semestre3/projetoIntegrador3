var inpCodigoProduto;
var inpNomeProduto;
var divProdutos;
var btnProcurar;
var btnAdicionaProduto;
var ValorTotalDoCarrinho = 0;
var metodoPagamento = "";

// Faz um request na servlet, obtem o produto e chama a função
// que adiciona a linha na tabela
function adicionaProduto() {

    if (inpCodigoProduto.value) {
        var xhr = new XMLHttpRequest();
        xhr.open("get", "CarrinhoController?acao=adicionar&id=" + inpCodigoProduto.value + "&quantidade=1");
        xhr.addEventListener("load", adicionaLinha);
        xhr.send();
    } else {
        $(inpCodigoProduto).addClass("invalid");
    }
}

// Adiciona a linha na tabela
function adicionaLinha(evt) {

    var obj = evt.target.responseText;

    try {

        var item = JSON.parse(obj);

        if (item.erro === "existe") {
            dialog("Produto ja estao no carrinho", "warning");

        } else if (item.estoque > 0) {
            criaLinha(evt);
            limpaBuscaProduto();
            dialog("Produto adicionado!!", "success");
        } else {
            dialog("Produto nao contem estoque!!", "warning");
            limpaBuscaProduto();
        }

    } catch (e) {
        //
    }
}

// Cria uma linha na tabela
function criaLinha(evt) {

    var obj = evt.target.responseText;

    var jsonProduto = JSON.parse(obj);
    var ultimaLinha = document.querySelector("table.tabela-produtos tbody tr:last-of-type");

    var tdId = '<td>' + jsonProduto.id + '</td>';
    var tdProduto = '<td>' + jsonProduto.nome + '</td>';

    // buttons e input 
    var btnMenos = '<button onclick="quantidadeMenos(this)"><i class="fa fa-minus"></i></button>';
    var input = '<input type="number" value="1" onchange="alteraQuantidadeDigitando(this)"/>';
    var btnMais = '<button onclick="quantidadeMais(this)"><i class="fa fa-plus"></i></button>';
    var btnRemover = '<button onclick="removeItem(this)"><i class="fa fa-close"></i></button>';

    var tdQtd = '<td>' + btnMenos + input + btnMais + '</td>';
    var tdAcao = '<td>' + btnRemover + '</td>';
    var tdValor = '<td> R$ ' + jsonProduto.precoVenda + '</td>';
    var tdSubtotal = '<td> R$ ' + jsonProduto.subtotal + '</td>';

    // aqui adiciono todas as tds
    var tr = '<tr id="linha' + jsonProduto.id + '">' + tdId + tdProduto + tdQtd + tdAcao + tdValor + tdSubtotal + '</tr>';

    // insere a linha
    ultimaLinha.insertAdjacentHTML('beforebegin', tr);
    calculaTotal();
}

// Essa função faz um request na servlet para trazer o produto pelo codigo
function obterProduto() {

    if (inpCodigoProduto.value) {
        var xhr = new XMLHttpRequest();
        xhr.open("get", "CarrinhoController?acao=procurar&id=" + inpCodigoProduto.value);
        xhr.addEventListener("load", listar);
        xhr.send();
    } else {
        $(inpCodigoProduto).addClass("invalid");
    }
}

// Mostrar o produto trazido da função obterProduto() no input nomeDoProduto
function listar(e) {

    var obj = e.target.responseText;
    var jsonProduto = JSON.parse(obj);

    if (jsonProduto.id !== 0) {
        document.querySelector("#inpNomeProduto").value = jsonProduto.nome;

        if (document.querySelector("#inpNomeProduto").value) {
            $('[for="inpNomeProduto"]').addClass("active");
            $(inpNomeProduto).addClass("valid");
            $(inpNomeProduto).removeClass("invalid");
        }

    } else {
        dialog("Id Inválido!!", "error");
        $(inpCodigoProduto).addClass("invalid");
    }
}

function apenasNumeros(str) {

    var id = str.replace(/[^0-9]/g, '');
    return parseInt(id);
}


// Diminui quantidade de itens de um determinado produto no carrinho
function quantidadeMenos(btn) {

    // pego o valor do campo - 1 pois so ira decrementar após fazer o request
    var input = btn.nextSibling;
    if (input.value == undefined) {
        input = btn.nextSibling.nextSibling;
    }
    var qtd = input.value - 1;

    if (qtd >= 1) {
        // pego a linha
        var tr = btn.parentNode.parentNode;
        var idTr = tr.getAttribute("id");

        // passo para a função que remove os caracteres eme 
        // devolve somente o id do produto
        var id = apenasNumeros(idTr);

        var xhr = new XMLHttpRequest();
        xhr.open("get", "CarrinhoController?acao=diminuir&id=" + id + "&quantidade=" + qtd);
        xhr.addEventListener("load", function (e) {

            var obj = e.target.responseText;
            var item = JSON.parse(obj);

            console.log(item);
            if (item.erro !== "quantidadeInvalida") {
                input.value--;
                var subtotal = tr.querySelector("td:last-of-type");
                subtotal.textContent = "R$ " + item.subtotal;
                calculaTotal();
            }
        });
        xhr.send();
    }
}
// Aumenta quantidade de itens de um determinado produto no carrinho
function quantidadeMais(btn) {
    // pego o valor do campo + 1 pois so ira decrementar apos fazer o request
    var input = btn.previousSibling;
    if (input.value == undefined) {
        input = btn.previousSibling.previousSibling;
    }
    var qtd = parseInt(input.value) + 1;

    if (qtd >= 1) {
        // pego o id da linha
        var tr = btn.parentNode.parentNode;
        var idTr = tr.getAttribute("id");

        // passo para a função que remove os caracteres eme 
        // devolve somente o id do produto
        var id = apenasNumeros(idTr);

        var xhr = new XMLHttpRequest();
        xhr.open("get", "CarrinhoController?acao=aumentar&id=" + id + "&quantidade=" + qtd);
        xhr.addEventListener("load", function (e) {

            var obj = e.target.responseText;

            try {

                var item = JSON.parse(obj);

                if (item.erro !== "quantidadeExcede") {
                    input.value++;
                    var subtotal = tr.querySelector("td:last-of-type");
                    subtotal.textContent = "R$ " + item.subtotal;
                    calculaTotal();
                } else {
                    dialog("Esse produto contem " + item.estoque + " em estoque!", "warning");
                }

            } catch (e) {
                //
            }
        });
        xhr.send();
    }
}

// Limpa o input de buscar o código do produto
// Limpa o input que carrega o nome do produto encontrado
// e remove as classes necessárias para que o input volte no estado original
function limpaBuscaProduto() {
    $(inpCodigoProduto).val("");
    $(inpNomeProduto).val("");
    $(inpCodigoProduto).removeClass("action");
    $(inpCodigoProduto).removeClass("valid");
    $(inpNomeProduto).removeClass("action");
    $(inpNomeProduto).removeClass("valid");
    $('[for="inpCodigoProduto"]').removeClass("active");
    $('[for="inpNomeProduto"]').removeClass("active");
}

// Remove linha do carrinho
function removeItem(btn) {
//    $(btn).closest("tr").remove();

    // pego a linha
    var tr = btn.parentNode.parentNode;
    var idTr = tr.getAttribute("id");

    // passo para a função que remove os caracteres eme 
    // devolve somente o id do produto
    var id = apenasNumeros(idTr);

    var xhr = new XMLHttpRequest();
    xhr.open("get", "CarrinhoController?acao=remover&id=" + id);

    xhr.addEventListener("load", function (e) {
        console.log(e);
        var obj = e.target.responseText;
        try {

            var item = JSON.parse(obj);
            console.log(item);
            if (item.erro !== "naoRemovido") {
                var pai = tr.parentNode;
                pai.removeChild(tr);
                calculaTotal();
            }

        } catch (e) {
            //
        }

    });
    xhr.send();
}

// Se alguem colocar o valor zero no input, ele volta para o valor 1
function quantidadeInvalida() {
    $('td input[type="number"').focusout(function () {
        if ($(this).val() <= 0) {
            $(this).val(1);
        }
    });
}

// Método que manda mensagens para a aplicação
function dialog(msg, alerta) {

    switch (alerta) {
        case "success":
            Materialize.toast(msg, 3000, alerta);
            break;
        case "warning":
            Materialize.toast(msg, 4000, alerta);
            break;
        case "error":
            Materialize.toast(msg, 3000, alerta);
            break;
    }
}

function calculaTotal() {

    td = document.querySelectorAll(".tabela-produtos tbody tr td:last-of-type");

    var total = 0.0;

    for (var i = 0; i < td.length - 1; i++) {
        var aux = td[i].innerText;
        var valor = parseFloat(aux.replace(/[^0-9\.]+/g, ''));
        total += valor;
    }
    console.log(total);
    var tdTotal = document.querySelector("#tdValorTotal");

    tdTotal.innerText = "R$ " + total;
    ValorTotalDoCarrinho = total;
}

// Carrega alguns buttons necessários para executar determinadas funções na página
function iniciar() {

    inpCodigoProduto = document.querySelector("#inpCodigoProduto");
    inpNomeProduto = document.querySelector("#inpNomeProduto");

    document.querySelector("#btnProcuraProduto").addEventListener("click", obterProduto);
    document.querySelector("#btnAdicionaProduto").addEventListener("click", adicionaProduto);
    document.querySelector("#btnFaturar").addEventListener("click", verificaMetodoPagamento);
    $('#modalCancelar').modal();
    //$('#modalFaturar').modal();
}

function alteraTd(lbl){
    metodoPagamento = lbl.getAttribute("for");
    var td = document.querySelector("#tdMetodoPagamento");
    td.removeAttribute("class");
    
}
function verificaMetodoPagamento() {

    var input = document.querySelectorAll('input[name="metodo-pagamento"]');
    var flag = false;

    for (var i = 0; i < input.length; i++) {
        if (input[i].checked) {
            flag = true;
        }
    }

    if (!flag) {
        var td = document.querySelector("#tdMetodoPagamento");
        td.setAttribute("class", "td-borda-vermelha");
        window.location = "#container-main";
        dialog("Selecione uma forma de pagamento!", "warning");
    } else {
        if (ValorTotalDoCarrinho > 0) {
            var btn = document.querySelector("#btnFaturar");
                    btn.setAttribute("href", "VendaController?acao=VendaFaturar&metodoPagamento="+metodoPagamento);
        }else{
            dialog("Nenhum item no carrinho!", "warning");
        }
    }

}




function alteraQuantidadeDigitando(input) {
    var qtd = parseInt(input.value);

    if (qtd < 1) {
        qtd = 1;
    }
    // pego o id da linha
    var tr = input.parentNode.parentNode;
    var idTr = tr.getAttribute("id");

    // passo para a função que remove os caracteres eme 
    // devolve somente o id do produto
    var id = apenasNumeros(idTr);
    var xhr = new XMLHttpRequest();
    xhr.open("get", "CarrinhoController?acao=aumentar&id=" + id + "&quantidade=" + qtd);
    xhr.addEventListener("load", function (e) {

        var obj = e.target.responseText;

        try {

            var item = JSON.parse(obj);

            if (item.erro !== "quantidadeExcede") {
                var subtotal = tr.querySelector("td:last-of-type");
                subtotal.textContent = "R$ " + item.subtotal;
                calculaTotal();
            } else {
                dialog("Esse produto contem " + item.estoque + " em estoque!", "warning");
                input.value = item.estoque;
                console.log(item.subtotal);
                var subtotal = tr.querySelector("td:last-of-type");
                subtotal.textContent = "R$ " + item.subtotal;
            }

        } catch (e) {
            //
        }
    });
    xhr.send();

}

function sairVenda(li) {
    console.log(li);
}

// Quando é carregado a pagina chama a função iniciar
window.addEventListener("load", iniciar);