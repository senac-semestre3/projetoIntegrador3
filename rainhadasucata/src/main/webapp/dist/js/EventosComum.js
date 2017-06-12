
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


window.addEventListener("load", iniciar);

function iniciar() {
    document.querySelector("#btnSalvar").addEventListener("click", validaCampo);

    // verificacao ao sair do campo
    document.querySelector("#cpf").addEventListener("blur", testaCpf);
    document.querySelector("#telefone").addEventListener("blur", verificaTelefone);
    document.querySelector("#celular").addEventListener("blur", verificaCelular);
    document.querySelector("#cep").addEventListener("blur", verificaCep);
    //document.querySelector('div.select-estado div input').addEventListener("blur", verificaEstado);

    // verificacao ao clicar
    document.querySelector("#nome").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#cpf").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#telefone").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#celular").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#cep").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#logradouro").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#bairro").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#cidade").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#estado").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    
    document.querySelector("#estado").addEventListener("change", function () {
        removeInvalido(this);
    }, false);
    
    $('select#estado.inicialized').click(function (){
        console.log($(this).val());
        if ($(this).val() == "") {
            adicionaClasse(this, "invalid");
            removeClasse(this, "valid");
        }else{
            adicionaClasse(this, "valid");
            removeClasse(this, "invalid");
        }
    });

}


function validaCampo() {

    // verifica se tem algum campo no documento com a classe "invalid"
    // se sim chama o método de rolar a pagina para o topo
    if (document.querySelector(".invalid") && !estaPreenchido()) {
        scroll();
        dialog("Existem campos não preenchidos e outros com formato inválido!!", "error");

        // chama o método para verificar se os campos obrigatorios estão preenchidos
        // se sim submete a pagina, se não chama o método de rolar a pagina para o topo
    } else if (!estaPreenchido()) {
        scroll();
        dialog("Alguns campos obrigatórios não foram preenchidos", "error");
    } else if(document.querySelector(".invalid")){
        dialog("Existem campos com formato inválido", "error");
    }else {
        document.getElementById("form").submit();
    }
}


// se o campo telefone tiver menos de 14 caracteres mostra o erro
function verificaTelefone() {

    var inpTelefone = document.querySelector("#telefone");
    var num = inpTelefone.value;

    // o telefone é obrigatorio, então verifico se o campo tem 14 digitos
    if (num.length < 14) {
        adicionaClasse(inpTelefone, "invalid");
        removeClasse(inpTelefone, "valid");
        dialog("Telefone formato inválido!", "error");
    }
}

// se o campo celular tiver algum caracter ele faz a validação, porém não é obrigatorio
function verificaCelular() {

    var inpCelular = document.querySelector("#celular");
    var num = inpCelular.value;

    // celular não é obrigatorio, por isso fiz a validação assim,
    // se acaso estiver preenchido, verifica se tem 15 digitos
    if (num !== "" && num.length < 15) {
        adicionaClasse(inpCelular, "invalid");
        removeClasse(inpCelular, "valid");
        dialog("Celular formato inválido!", "warning");
    }
}

// quando sair do campo verifica se o cep é valido, conforme a logica escrita
function verificaCep() {
    var inpCep = document.querySelector("#cep");
    var num = inpCep.value.replace(/[^0-9]/g, '');

    console.log(num);
    if (num.length < 8) {

        adicionaClasse(inpCep, "invalid");
        removeClasse(inpCep, "valid");
        dialog("cep falta caracteres!", "error");
    } else {
        buscaCep(num);
    }
}

// verifica se o estado foi selecionado

function verificaEstado(){
    var estado = document.querySelector('div.select-estado div ul li');
    console.log(estado);
    if (estado.classList.contains("active")) {
        adicionaClasse(estado, "invalid");
        removeClasse(estado, "valid");
    }
}
// adiciona classe no input, ambos devem ser passados por parametro
function adicionaClasse(inp, classe) {
    inp.classList.add(classe);
}

// remove a classe do input, ambos devem ser passados por parametro
function removeClasse(inp, classe) {
    inp.classList.remove(classe);
}

// remove a classe inválida do input passado
function removeInvalido(inp) {
    if (inp.classList.contains("invalid")) {
        inp.classList.remove("invalid");
    }
}

// verifica se os campos obrigatórios estão preenchidos
// retorna true se preenchido;
function estaPreenchido() {
    var obrigatorio = document.querySelectorAll(".obrigatorio");
    var flag = true;
    for (var i = 0; i < obrigatorio.length; i++) {

        // com o regex dei um trim no campo para tirar os espaços
        if (obrigatorio[i].value.replace(/^\s+|\s+$/g, "") === "") {
            adicionaClasse(obrigatorio[i], "invalid");
            flag = false;
        }
    }
     //variaveis{
    var estado = $('div.select-estado div select');
    var select = document.querySelector('div.select-estado div input');
    if (estado.val() == "") {
        flag = false;
        adicionaClasse(select, "invalid");
        removeClasse(select, "valid");
    }
    if (flag) {
        return true;
    } else {
        return false;
    }
}

// rola a pagina para o topo
function scroll() {
    $('html, body').animate({scrollTop: 20}, 'slow');
}

// busca o cep
function buscaCep(valor) {

    var xhr = new XMLHttpRequest();
    xhr.open("get", "ConsultaCep?cep=" + valor);
    console.log("ConsultaCep?cep=" + valor);
    xhr.addEventListener("load", retornar);
    xhr.send();
}

// preenche os campos logradouro, bairro, cidade, estado com os valores do retorno
function retornar(evt) {
    var obj = evt.target.responseText;
    console.log(evt);
    obj = JSON.parse(obj);

    document.getElementsByName("logradouro")[0].value = obj.logradouro;
    document.getElementsByName("bairro")[0].value = obj.bairro;
    document.getElementsByName("cidade")[0].value = obj.cidade;

    $("[name='estado']").val(obj.estado);
    // re-initialize material-select
    $("[name='estado']").material_select();

    if (document.querySelector("[name='logradouro']").value) {
        $('[for="logradouro"]').addClass("active");
        $('[name="logradouro"]').addClass("valid");
    }
    if (document.querySelector("[name='bairro']").value) {
        $('[for="bairro"]').addClass("active");
        $('[name="bairro"]').addClass("valid");
    }
    if (document.querySelector("[name='cidade']").value) {
        $('[for="cidade"]').addClass("active");
        $('[name="cidade"]').addClass("valid");
    }
    if (document.querySelector("[name='estado']").value) {
        $('[for="estado"]').addClass("active");
        $('div.select-estado div input').addClass("valid");
    }
}

// chama a classe que verifica se o cpf é valido
function testaCpf() {
    var cpf = document.querySelector("#cpf");
    
    // chama o método que verifica se o cpf é valido
    // se o cpf for inválido remove a classe "valid" que faz o input ficar verde
    // e adiciona a classe "invalid" que faz o input ficar vermelho
    if (!verificaCpf(cpf)) {
        adicionaClasse(cpf, "invalid");
        removeClasse(cpf, "valid");
        console.log(cpf);
    }
}
// função que verifica se o cpf é inválido
function verificaCpf(cpf) {
    var strCpf = cpf.value;
    var Soma;
    var Resto;
    var strCpf = strCpf.replace(/[\.-]/g, "");

    Soma = 0;
    if (strCpf === "00000000000" || strCpf === "11111111111" || strCpf === "22222222222" ||
            strCpf === "33333333333" || strCpf === "44444444444" || strCpf === "55555555555" ||
            strCpf === "66666666666" || strCpf === "77777777777" || strCpf === "88888888888" ||
            strCpf === "99999999999") {
        return false;
    }


    for (i = 1; i <= 9; i++) {
        Soma = Soma + parseInt(strCpf.substring(i - 1, i)) * (11 - i);
    }

    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11)) {
        Resto = 0;
    }

    if (Resto !== parseInt(strCpf.substring(9, 10))) {
        return false;
    }

    Soma = 0;
    for (i = 1; i <= 10; i++) {
        Soma = Soma + parseInt(strCpf.substring(i - 1, i)) * (12 - i);
    }

    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11)) {
        Resto = 0;
    }
    if (Resto !== parseInt(strCpf.substring(10, 11))) {
        return false;
    }

    return true;
}
// Ao clicar no botão cancelar aciona o modal que pergunta se o usuario quer realmente sair
$('#modalCancelar').modal();