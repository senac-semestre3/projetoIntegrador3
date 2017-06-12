
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


window.addEventListener("load", iniciarComum);

function iniciarComum() {
    
    document.querySelector("#btnSalvar").addEventListener("click", validaCampo);

    // verificacao ao sair do campo
    document.querySelector("#nome").addEventListener("blur", verificaNome);

    // verificacao ao clicar
    document.querySelector("#nome").addEventListener("click", function () {
        removeInvalido(this);
    }, false);

}

// verifica se existe algum campo com class invalid
// chama tambem a funcao que verifica se esta preenchido os campos obrigatorios
// se tudo estiver ok submete o formulário
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

// faz validação no nome, verifica se tiver apenas espacos ele da erro no campo
function verificaNome(){
    var inpNome = document.querySelector("#nome");
    var nome = inpNome.value.trim();
    
    if (nome == "") {
        adicionaClasse(inpNome, "invalid");
        removeClasse(inpNome, "valid");
        dialog("Nome não preenchido!", "error");
        inpNome.value = "";
    }else{
        removeEspacos(inpNome);   
    }
}


// adiciona classe no input, ambos devem ser passados por parametro

// adiciona a classe passada no elemento passado
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


// Ao clicar no botão cancelar aciona o modal que pergunta se o 
// usuario quer realmente sair
$('#modalCancelar').modal();

// remove espacos do input passado
function removeEspacos(input){
    var valor = input.value.trim();
    input.value = valor;
}