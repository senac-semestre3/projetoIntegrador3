/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function iniciar(){
   atualizarLista();
}

function atualizarLista(){
    listaService = new XMLHttpRequest();
    listaService.open("get", "ServletListarTodosClientes");
    //listaService.addEventListener("load",listar);
    //listaService.send();
}


window.addEventListener("load",iniciar);

