
window.addEventListener("load", iniciarContato);


function iniciarContato() {

    document.querySelector("#telefone").addEventListener("blur", verificaTelefone);
    document.querySelector("#email").addEventListener("blur", verificaEmail);

    // evento de click
    document.querySelector("#telefone").addEventListener("click", function () {
        removeInvalido(this);
    }, false);
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

// função que remove todos os espacos do email
function verificaEmail(){
    var inpEmail = document.querySelector("#email");
    var email = inpEmail.value.trim();
    
    if (email == "") {
        adicionaClasse(inpEmail, "invalid");
        removeClasse(inpEmail, "valid");
        dialog("E-mail não preenchido!", "error");
        inpEmail.value = "";
    }else{
        removeEspacos(inpEmail);   
    }
}