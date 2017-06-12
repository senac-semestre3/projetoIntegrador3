window.addEventListener("load", iniciarUsuario);


function iniciarUsuario(){
    
}

//function buscarLoja(){
//    var xhr = new XMLHttpRequest();
//    xhr.open("get", "ListarLojasJson");
//    xhr.addEventListener("load", listarLoja);
//    xhr.send();
//}
//
//function listarLoja(evt){
//    var select = document.querySelector("select[name='loja']");
//    
//    var obj = evt.target.responseText;
//    var loja = JSON.parse(obj);
//    
//    for (var i = 0; i < loja.length; i++) {
//        var option = createElement("option");
//        option.setAttribute("id", loja.id);
//        option.textContent = loja.nome;
//        select.appendChild(option);
//    }
//    
//    
//}