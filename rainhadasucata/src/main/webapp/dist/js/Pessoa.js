window.addEventListener("load", iniciarPessoa);

function iniciarPessoa() {
    // eventos ao sair do campo
    document.querySelector("#cpf").addEventListener("blur", testaCpf);
    document.querySelector("#celular").addEventListener("blur", verificaCelular);

// eventos de click
    document.querySelector("#cpf").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
    document.querySelector("#celular").addEventListener("click", function () {
        removeInvalido(this);
    }, false);


}


// chama a funcao que verifica se o cpf é valido
function testaCpf() {
    var cpf = document.querySelector("#cpf");

    // chama o método que verifica se o cpf é valido
    // se o cpf for inválido remove a classe "valid" que faz o input ficar verde
    // e adiciona a classe "invalid" que faz o input ficar vermelho
    if (!verificaCpf(cpf)) {
        adicionaClasse(cpf, "invalid");
        removeClasse(cpf, "valid");
        dialog("Cpf inválido!", "error");
    }
}

// função que verifica se o cpf é válido
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

