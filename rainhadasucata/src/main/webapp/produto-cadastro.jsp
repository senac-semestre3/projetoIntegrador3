<%-- 
    Document   : produto-cadastro
    Created on : 20/04/2017, 02:56:58
    Author     : DANILO&PAULA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/produto-cadastro.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <!-- Programar aqui!! -->
                    
                    <div class="main">     

                        <div class="row">
                           
                            <button class="btn btn-adicionar waves-effect waves-light right" type="button" name="action">Adicionar
                                <i class="fa fa-check" aria-hidden="true"></i>
                            </button>
                             <button class="btn btn-cancelar waves-effect waves-light right" type="button" name="action">Cancelar
                                <i class="fa fa-ban" aria-hidden="true"></i>
                            </button>
                        </div>

                        <div class="row">
                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-barcode left" aria-hidden="true"></i>
                                    <header>Cadastro de Produto</header>
                                </div>

                                <div id="id-produto" class="input-field col s4">
                                    <i class="material-icons prefix fa fa-barcode"></i>
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Código</label>
                                </div>

                                <div id="nome" class="input-field col s8">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Produto</label>
                                </div>

                                <div id="marca" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Marca</label>
                                </div>

                                <div id="descricao" class="input-field col s8">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Descricao</label>
                                </div>

                                <div id="preco-compra" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Preco de Compra</label>
                                </div>

                                <div id="preco-venda" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Preco de Venda</label>
                                </div>

                                <div id="margem-venda" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Margem de Venda</label>
                                </div>

                                <div id="estoque" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Estoque</label>
                                </div>

                                <div id="estoque-minimo" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Estoque Minimo</label>
                                </div>

                                <div id="status" class="input-field col s4">
                                    <input id="icon_prefix" type="text" class="validate">
                                    <label for="icon_prefix">Status</label>
                                </div>
                            </div>
                        </div>   
                    </div> 
                </div>
            </div>
    </body>
</html>

