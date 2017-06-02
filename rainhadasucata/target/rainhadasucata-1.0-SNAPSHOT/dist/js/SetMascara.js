
jQuery(function ($) {

    //$("#data, #data1, #data2").setMask("99/99/9999");
    $("#cpf").setMask("999.999.999-99");
    $("#cnpj").setMask("99.999.999/9999-99");
    $("#cep").setMask("99999-999");
    $("#estoque-minimo, #estoque").setMask("99999");
    $("#telefone").setMask("(99) 9999-9999");
    $("#celular").setMask("(99) 99999-9999");
    //$("#margem").setMask("99.9");
    $("#valor-compra, #valor-venda").setMask({ mask : '99.999,999', type : 'reverse', defaultValue : '000' });

});



