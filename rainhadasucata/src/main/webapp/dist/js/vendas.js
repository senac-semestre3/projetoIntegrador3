
window.addEventListener("click", function () {
    var table = document.querySelector('table.tabela-detalhes-venda');
    td = table.querySelector("tbody tr td:nth-child(4)");
    var metodoPagamento = document.querySelectorAll('input[name="metodo-pagamento"]');
    for (var i = 0; i < metodoPagamento.length; i++) {
        if (metodoPagamento[i].checked) {
            td.innerHTML = metodoPagamento[i].value;
        }
    }
});

var jsonProduto;
var txtCodigo;
var txtProduto;
var divProdutos;
var btnProcurar;
var btnAdicionarProduto;
var btnRemover;
var listaProdutos = [];

btnProcurar = document.querySelector("#procuraProduto");
txtCodigo = document.querySelector("input.textCodigoProduto");
txtProduto = document.querySelector("#txtNomeProduto");
divProdutos = document.querySelector("#listaProdutos");
btnAdicionarProduto = document.querySelector("#btnAdicionarProduto");
btnRemover = document.querySelector("#btnRemover");

//chamadas de funcoes
btnProcurar.addEventListener("click", atualizarLista);
btnAdicionarProduto.addEventListener("click", insereLinhaNaTbl);

function atualizarLista() {
    if (txtCodigo.value) {
        var xhr = new XMLHttpRequest();
        xhr.open("get", "vendaTeste?busca=" + txtCodigo.value);
        xhr.addEventListener("load", listar);
        xhr.send();
    } else {
        $(txtCodigo).addClass("invalid");
    }
}


//mostrar o produto no input produto
function listar(e) {
    var obj = e.target.responseText;

    jsonProduto = JSON.parse(obj);
    document.querySelector("#txtNomeProduto").value = jsonProduto.nome;

    if (document.querySelector("#txtNomeProduto").value) {
        $('[for="txtNomeProduto"]').addClass("active");
        $(txtProduto).addClass("valid");
        $(txtProduto).removeClass("invalid");
    }

}

// quando o botão adicionar é clicado

function insereLinhaNaTbl() {
    var ref = document.querySelector("table.tabela-produtos tbody tr:last-of-type");

    var produto = new Produto(jsonProduto.id,
            jsonProduto.nome,
            jsonProduto.precoVenda,
            jsonProduto.estoque);

    if (txtProduto.value) {

        if (!existeNoCarrinho(jsonProduto.id)) {

            listaProdutos.push(produto);

            var htmlNovo =
                    '<tr id="linha' + jsonProduto.id + '">\n\
                    <td>' + jsonProduto.id + '</td>\n\
                    <td>' + jsonProduto.nome + '</td>\n\
                    <td><button onclick="quantidadeMenos()" class="btn-menos-qtd">\n\
                        <i class="fa fa-minus" aria-hidden="true"></i>\n\
                    </button>\n\
                    <input type="number" value="1" onchange="quantidadeInvalida()" />\n\
                    <button onclick="quantidadeMais()">\n\
                        <i class="fa fa-plus" aria-hidden="true"></i>\n\
                    </button></td>\n\
                    <td>\n\
                        <button id="btnRemover' + jsonProduto.id + '" class="btn-remover" type="button" onclick="removerElementoDoCarrinho()">\n\
                            <i class="fa fa-times" aria-hidden="true"></i>\n\
                        </button>\n\
                    </td>\n\
                    <td>' + jsonProduto.precoVenda + '</td>\n\
                    <td>' + jsonProduto.precoVenda + '</td>\n\
                </tr>';
            var tr = document.createElement('tr');
            ref.insertAdjacentHTML('beforebegin', htmlNovo);
            $(txtCodigo).val("");
            $(txtProduto).val("");
            $(txtCodigo).removeClass("action");
            $(txtCodigo).removeClass("valid");
            $(txtProduto).removeClass("action");
            $(txtProduto).removeClass("valid");
            $('[for="txtNomeProduto"]').removeClass("active");
            $('[for="txtCodigoProduto"]').removeClass("active");
        } else {
            alert("Já contem esse produto no carrinho!");
        }

    } else {
        $(txtProduto).addClass("invalid");
        if (!txtCodigo.value) {
            $(txtCodigo).addClass("invalid");
        }
    }

}

function removerElementoDoCarrinho() {
    var btn = $(this).attr('id').val();
    console.log(btn);

}

function existeNoCarrinho(id) {

    for (var i = 0; i < listaProdutos.length; i++) {

        return listaProdutos[i].id === id;
    }
}

function Produto(id, nome, precoVenda, estoque) {
    this.id = id;
    this.nome = nome;
    this.precoVenda = precoVenda;
    this.estoque = estoque;
}


function calculaSubtotal() {
    
}

function quantidadeInvalida() {
    $('td input[type="number"').focusout(function () {
        if($(this).val() <= 0){
            $(this).val(1);
        }
    });
}


// diminui quantidade
function quantidadeMenos() {

}

// aumenta quantidade
function quantidadeMais() {
    
}