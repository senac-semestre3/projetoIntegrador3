//
//var campoCep = document.getElementById("cep");
//
//campoCep.addEventListener("change", function () {
//    if (campoCep.value.length >= 9) {
//        buscaCep(campoCep.value);
//    }
//});
//
//function buscaCep(valor) {
//
//    var xhr = new XMLHttpRequest();
//    xhr.open("get", "ConsultaCep?cep=" + valor);
//    console.log("ConsultaCep?cep=" + valor);
//    xhr.addEventListener("load", retornar);
//    xhr.send();
//}
//
//function retornar(evt) {
//    var obj = evt.target.responseText;
//    console.log(evt);
//    obj = JSON.parse(obj);
//    document.getElementsByName("logradouro")[0].value = obj.logradouro;
//    document.getElementsByName("bairro")[0].value = obj.bairro;
//    document.getElementsByName("cidade")[0].value = obj.cidade;
//
//    $("[name='estado']").val(obj.estado);
//    // re-initialize material-select
//    $("[name='estado']").material_select();
//
//    if (document.querySelector("[name='logradouro']").value) {
//        $('[for="logradouro"]').addClass("active");
//        $('[name="logradouro"]').addClass("valid");
//    }
//    if (document.querySelector("[name='bairro']").value) {
//        $('[for="bairro"]').addClass("active");
//        $('[name="bairro"]').addClass("valid");
//    }
//    if (document.querySelector("[name='cidade']").value) {
//        $('[for="cidade"]').addClass("active");
//        $('[name="cidade"]').addClass("valid");
//    }
//    if (document.querySelector("[name='estado']").value) {
//        $('[for="cidade"]').addClass("active");
//        $('[name="cidade"]').addClass("valid");
//    }
//
//}
