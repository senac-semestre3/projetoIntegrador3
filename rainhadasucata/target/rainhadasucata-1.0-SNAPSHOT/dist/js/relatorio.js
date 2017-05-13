/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*$(document).ready(function(){
 // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
 $('#btn52').click(function (){
 $('#modal-ver-venda').modal('open');
 });
 
 });
 */
$(document).ready(function () {
    // lista
    $('select').material_select();

    // data
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 10 // Creates a dropdown of 15 years to control year
    });

    $('#modal-ver-venda').modal();

});
