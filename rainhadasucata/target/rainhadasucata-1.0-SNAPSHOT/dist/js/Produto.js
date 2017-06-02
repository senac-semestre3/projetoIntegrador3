/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//#valor-venda
//#margem
//#valor-compra

$('#margem').keydown(function (){
   var margem = $('#margem').val()/100;
   var valorCompra = $('#valor-compra').val();
   
   var aux = margem * valorCompra;
   var valorVenda = valorCompra + aux;
   console.log(valorVenda);
});
