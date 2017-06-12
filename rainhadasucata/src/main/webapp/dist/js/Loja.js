window.addEventListener("load", iniciarLoja);

function iniciarLoja(){
    document.querySelector("#cnpj").addEventListener("blur", verificaCnpj);
}


function verificaCnpj(){
    var inpCnpj = document.querySelector("#cnpj");
    var cnpj = inpCnpj.value;
    
    if (cnpj < 18) {
        adicionaClasse(inpCnpj, "invalid");
        removeClasse(inpCnpj, "valid");
        dialog("Cnpj inválido!", "error");
    }
}