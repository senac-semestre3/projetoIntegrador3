///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
////#valor-venda
////#margem
////#valor-compra
//
//$('#margem').keydown(function (){
//   var margem = $('#margem').val()/100;
//   var valorCompra = $('#valor-compra').val();
//   
//   var aux = margem * valorCompra;
//   var valorVenda = valorCompra + aux;
//   console.log(valorVenda);
//});


window.addEventListener("load", iniciarProduto);

function iniciarProduto(){
    // verificacao ao sair do campo
    document.querySelector("#nome").addEventListener("blur", verificaNome);
    document.querySelector("#estoque").addEventListener("blur", verificaEstoque);
    document.querySelector("#valorVenda").addEventListener("blur", verificaValor);
    
    $('#valorVenda, #valorCompra').mask('000.000.000,00', {reverse: true});
}

function verificaEstoque(){
    var inpEstoque = document.querySelector("#estoque");
    var valor = inpEstoque.value;
    
    if(valor == ""){
        adicionaClasse(inpEstoque, "invalid");
        removeClasse(inpEstoque, "valid");
        dialog("Estoque não definido", "error");
    }
}

function verificaValor(){
    var inpVenda = document.querySelector("#valorVenda");
    var valor = inpVenda.value;
    
    if (valor == "") {
        adicionaClasse(inpVenda, "invalid");
        removeClasse(inpVenda, "valid");
        dialog("Estoque não definido", "error");
    }
}
