
window.addEventListener("load", iniciarEndereco);


function iniciarEndereco() {

    // envento ao sair do campo
    document.querySelector("#cep").addEventListener("blur", verificaCep);

    // evento ao clicar
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
    
//    $('select#estado.inicialized').click(function () {
//        console.log($(this).val());
//        if ($(this).val() == "") {
//            adicionaClasse(this, "invalid");
//            removeClasse(this, "valid");
//        } else {
//            adicionaClasse(this, "valid");
//            removeClasse(this, "invalid");
//        }
//    });
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
    
    var estado = document.querySelector('div.select-estado div input');
    
    $("[name='estado']").val(obj.estado);
    // re-initialize material-select
    $("[name='estado']").material_select();

    if (document.querySelector("[name='logradouro']").value) {
        $('[for="logradouro"]').addClass("active");
        $('[name="logradouro"]').addClass("valid");
        removeClasse(document.querySelector("[name='logradouro']"), "invalid");
    }
    if (document.querySelector("[name='bairro']").value) {
        $('[for="bairro"]').addClass("active");
        $('[name="bairro"]').addClass("valid");
        removeClasse(document.querySelector("[name='bairro']"), "invalid");
    }
    if (document.querySelector("[name='cidade']").value) {
        $('[for="cidade"]').addClass("active");
        $('[name="cidade"]').addClass("valid");
        removeClasse(document.querySelector("[name='cidade']"), "invalid");
    }
    if (document.querySelector("[name='estado']").value) {
        $('[for="estado"]').addClass("active");
        $('div.select-estado div input').addClass("valid");
        
    }
}