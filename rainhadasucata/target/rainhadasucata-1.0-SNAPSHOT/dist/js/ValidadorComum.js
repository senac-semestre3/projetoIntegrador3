/// VARIAVEIS GLOBAIS///

// variaveis de texto
var txtCamposObrigatorios = "Alguns campos obrigatórios não foram preenchidos";
var txtCamposInvalido = "Campos com formato inválido";

//campos do formulário
var cpf = document.querySelector("#cpf");
var celular = document.querySelector("#celular");
var telefone = document.querySelector("#telefone");
var cep = document.querySelector("#cep");


// recebe o campo com id cpf
// adiciona um evento de ao sair do campo chama um método
cpf.addEventListener("blur", testaCpf);
function testaCpf() {

    // chama o método que verifica se o cpf é valido
    // se o cpf for inválido remove a classe "valid" que faz o input ficar verde
    // e adiciona a classe "invalid" que faz o input ficar vermelho
    if (!verificaCpf()) {
        $(cpf).removeClass("valid");
        $(cpf).addClass("invalid");
    }
}

// função que verifica se o cpf é inválido
function verificaCpf() {
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

// Ao clicar no botão "btnSalvar"
$("#btnSalvar").click(function () {

    var pagina = $('.btn-finalizar-cadastro').attr('id');


    // verifica se tem algum campo no documento com a classe "invalid"
    // se sim chama o método de rolar a pagina para o topo
    if (document.querySelector(".invalid")) {
        scroll();
        textoErro(txtCamposInvalido);
        mostrarErro();


        // chama o método para verificar se os campos obrigatorios estão preenchidos
        // se sim submete a pagina, se não chama o método de rolar a pagina para o topo

    } else if (!estaPreenchido()) {
        scroll();
        textoErro(txtCamposObrigatorios);
        mostrarErro();
    } else {
//        if (pagina === "finalizaCliente") {
//            console.log("ClienteFinalizado");
//        } else if (pagina === "finalizaUsuario"){
//            console.log("UsuarioFinalizado");
//        }
        document.getElementById("form").submit();
    }

    // verifica se os campos obrigatórios estão preenchidos
    // retorna true se preenchido;
    function estaPreenchido() {
        var obrigatorio = document.querySelectorAll(".obrigatorio");

        for (var i = 0; i < obrigatorio.length; i++) {

            // com o regex dei um trim no campo para tirar os espaços
            if (obrigatorio[i].value.replace(/^\s+|\s+$/g, "") === "") {
                return false;
            }
        }
        return true;
    }
});


// Ao clicar no botão cancelar aciona o modal que pergunta se o usuario quer realmente sair
$('#modalCancelar').modal();

// rola a pagina para o topo
function scroll() {
    $('html, body').animate({scrollTop: 20}, 'slow');
}

// função que mostra a div de erro que fica no topo da pagina
function mostrarErro() {
    document.getElementById("erro").style.display = 'block';
}

// função que seta um texto na div de erro
function textoErro(texto) {
    var h5 = document.querySelector("#erro h5");

    h5.innerHTML = texto;
}


///*****************************************************************************************
//
//
//

/// valida telefone /////
telefone.addEventListener("blur", verificaTelefone);

function verificaTelefone() {
    var num = document.querySelector("#telefone").value;

    // o telefone é obrigatorio, então verifico se o campo tem 14 digitos
    if (num.length < 14) {
        $(telefone).removeClass("valid");
        $(telefone).addClass("invalid");
    }
}

// Ao clicar no campo com id telefone remove a clase "invalid", para que o campo deixe de ser vermelho
$(telefone).click(function () {
    $(this).removeClass("invalid");
});

/// valida celular/////
celular.addEventListener("blur", verificaCelular);

function verificaCelular() {
    var num = document.querySelector("#celular").value;

    // celular não é obrigatorio, por isso fiz a validação assim,
    // se acaso estiver preenchido, verifica se tem 15 digitos
    if (num !== "") {
        if (num.length < 15) {
            $(celular).removeClass("valid");
            $(celular).addClass("invalid");
        }
    }

}

/// valida cep/////
cep.addEventListener("blur", verificaCep);

function verificaCep() {
    var num = document.querySelector("#cep").value;

    if (num.length < 9) {
        $(cep).removeClass("valid");
        $(cep).addClass("invalid");
    }
}

// Ao clicar no campo com id "cpf" remove a clase "invalid", para que o campo deixe de ser vermelho
$(cpf).click(function () {
    $(this).removeClass("invalid");
});

// Ao clicar no campo com id "telefone" remove a clase "invalid", para que o campo deixe de ser vermelho
$(telefone).click(function () {
    $(this).removeClass("invalid");
});


// Ao clicar no campo com id "celular" remove a clase "invalid", para que o campo deixe de ser vermelho
$(celular).click(function () {
    $(this).removeClass("invalid");
});

// Ao clicar no campo com id "cep" remove a clase "invalid", para que o campo deixe de ser vermelho
$(cep).click(function () {
    $(this).removeClass("invalid");
});