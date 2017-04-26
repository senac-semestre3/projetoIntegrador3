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
                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-barcode left" aria-hidden="true"></i>
                                    <header>Cadastrar Produto</header>
                                </div>

                                <div class="corpo-card">
                                    <form method="">
                                        <div class="row">
                                            <div class="input-field col s5 offset-s1">
                                                <input id="nome-produto" type="text" class="validate" name="nome">
                                                <label for="nome-produto">Nome do produto</label>
                                            </div>
                                            <div class="input-field col s4 offset-s1">
                                                <input id="marca" type="text" class="validate" name="marca">
                                                <label for="marca">Marca</label>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="input-field col s10 offset-s1">
                                                <textarea id="descricao-produto" class="materialize-textarea" name="descricao"></textarea>
                                                <label for="descricao-produto">Descrição</label>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="input-field col s3 offset-s1">
                                                <input id="preco-compra" type="text" class="validate" name="preco-compra">
                                                <label for="preco-compra">Peço de compra</label>
                                            </div>
                                            <div class="input-field col s2 offset-s1">
                                                <input id="margem" type="text" class="validate" name="margem-lucro">
                                                <label for="margem">Margem de lucro</label>
                                            </div>
                                            <div class="input-field col s3 offset-s1">
                                                <input id="preco-venda" type="text" class="validate" name="valor-venda">
                                                <label for="preco-venda">Valor de venda</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s3 offset-s1">
                                                <input id="estoque" type="number" class="validate" name="estoque">
                                                <label for="estoque">Quantidade em estoque</label>
                                            </div>
                                            <div class="input-field col s3 offset-s1">
                                                <input id="estoque-minimo" type="number" class="validate" name="estoque-minimo">
                                                <label for="estoque-minimo">Estoque mínimo</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col offset-s1">
                                                <input type="checkbox" id="status" name="status"/>
                                                <label for="status">Produto Ativo</label>
                                            </div>
                                        </div>

                                        <!-- botões -->
                                        <div class="row">
                                            <div class="btn-finalizar-cadastro right">
                                                <a href="produtos.jsp">
                                                    <button class="btn btn-cancelar waves-effect waves-light" type="button">
                                                        Cancelar
                                                        <i class="fa fa-ban" aria-hidden="true"></i>
                                                    </button>
                                                </a>

                                                <button class="btn btn-adicionar waves-effect waves-light" type="submit">Salvar
                                                    <i class="fa fa-floppy-o" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>   
                </div> 
            </div>
        </div>

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
    </body>
</html>

