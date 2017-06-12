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
        <link href="dist/css/tela-cadastro.css" rel="stylesheet" type="text/css"/>

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

                                    <!-- INICIO DO FORM-->
                                    <form action="ProdutoController" method="get" id="form">
                                        <input type="hidden" name="acao" value="ProdutoAdicionar" />
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="input-field col s5 offset-s1">
                                                    <input id="nome" type="text" class="validate obrigatorio" name="nome" required="required">
                                                    <label for="nome">* Nome do produto</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="marca" type="text" class="validate" name="marca">
                                                    <label for="marca">Marca</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s10 offset-s1">
                                                    <textarea id="descricao" class="materialize-textarea" name="descricao"></textarea>
                                                    <label for="descricao">Descrição</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s3 offset-s1">
                                                    <input id="valorCompra" type="text" class="validate" name="valor-compra">
                                                    <label for="valor-compra">Valor de compra</label>
                                                </div>
                                                <div class="input-field col s3 offset-s1">
                                                    <input id="valorVenda" type="text" class="validate obrigatorio" name="valor-venda" required="required">
                                                    <label for="valor-venda">* Valor de venda</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s3 offset-s1">
                                                    <input id="estoque" type="number" class="validate obrigatorio" name="estoque" required="required">
                                                    <label for="estoque">* Quantidade em estoque</label>
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
                                        </div>

                                        <!-- botões -->
                                        <div class="row">
                                            <div class="btn-finalizar-cadastro right">
                                                <button id="btnCancelar" class="btn btn-cancelar waves-effect waves-light" type="button" data-target="modalCancelar">
                                                    Cancelar
                                                    <i class="fa fa-ban" aria-hidden="true"></i>
                                                </button>

                                                <button id="btnSalvar" class="btn btn-adicionar waves-effect waves-light" type="button">Salvar
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

        <!-- Modal Structure -->
        <div id="modalCancelar" class="modal">
            <div class="modal-content">
                <h4>Deseja realmente sair?</h4>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Voltar à edição</a>
                <a href="ProdutoController?&acao=ProdutoListar" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Sair</a>
            </div>
        </div>

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
        <script src="dist/js/jquery.mask.min.js" type="text/javascript"></script>

        <!-- javascript da página -->
        <script src="dist/js/DataMaterialize.js" type="text/javascript"></script>
        <script src="dist/js/SetMascara.js" type="text/javascript"></script>
        <script src="dist/js/Produto.js" type="text/javascript"></script>
        <script src="dist/js/EventosComum.js" type="text/javascript"></script>
    </body>
</html>

