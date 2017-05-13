/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("click", function(){
    var table = document.querySelector('table.tabela-detalhes-venda');
    td = table.querySelector("tbody tr td:nth-child(4)");
    var metodoPagamento = document.querySelectorAll('input[name="metodo-pagamento"]');
    for (var i = 0; i < metodoPagamento.length; i++) {
        if (metodoPagamento[i].checked) {
           td.innerHTML = metodoPagamento[i].value;
        }
    }
});





