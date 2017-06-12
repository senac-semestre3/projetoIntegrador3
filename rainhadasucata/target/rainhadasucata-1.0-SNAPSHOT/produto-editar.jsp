
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Produto</title>

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
                                    <header>Edição do Produto</header>
                                </div>

                                <div class="corpo-card">

                                    <!-- INICIO DO FORM-->
                                    <form action="ProdutoController" method="post" id="form">
                                        
                                        <input type="hidden" name="id" value="${produto.id}" />
                                        <input type="hidden" name="acao" value="ProdutoEditar" />
                                        
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="input-field col s5 offset-s1">
                                                    <input value="${produto.nome}" id="nome" type="text" class="validate" name="nome" required="required">
                                                    <label for="nome">* Nome do produto</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input value="${produto.marca}" id="marca" type="text" class="validate" name="marca">
                                                    <label for="marca">Marca</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s10 offset-s1">
                                                    <textarea id="descricao" class="materialize-textarea" name="descricao">${produto.descricao}</textarea>
                                                    <label for="descricao">Descrição</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s3 offset-s1">
                                                    <input value="${produto.precoCompra}" id="valor-compra" type="text" class="validate" name="valor-compra">
                                                    <label for="valor-compra">Valor de compra</label>
                                                </div>
                                                <div class="input-field col s3 offset-s1">
                                                    <input value="${produto.precoVenda}" id="valor-venda" type="text" class="validate" name="valor-venda" required="required">
                                                    <label for="valor-venda">* Valor de venda</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s3 offset-s1">
                                                    <input value="${produto.estoque}" id="estoque" type="number" class="validate" name="estoque" required="required">
                                                    <label for="estoque">* Quantidade em estoque</label>
                                                </div>
                                                <div class="input-field col s3 offset-s1">
                                                    <input value="${produto.estoqueMinimo}" id="estoque-minimo" type="number" class="validate" name="estoque-minimo">
                                                    <label for="estoque-minimo">Estoque mínimo</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <c:choose>
                                                    <c:when test="${produto.status == 1}">
                                                        <div class="col offset-s1">
                                                            <input type="checkbox"  id="status" name="status" checked/>
                                                            <label for="status">Usuário Ativo</label>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="col offset-s1">
                                                            <input type="checkbox"  id="status" name="status"/>
                                                            <label for="status">Usuário Ativo</label>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
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
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Voltar ao cadastro</a>
                <a href="ProdutoController?&acao=ProdutoListar" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Cancelar</a>
            </div>
        </div>

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
        <script src="dist/js/mascaras.js" type="text/javascript"></script>
        <script src="dist/js/SetMascara.js" type="text/javascript"></script>
        <script src="dist/js/Produto.js" type="text/javascript"></script>
        <script src="dist/js/EventosComum.js" type="text/javascript"></script>
    </body>
</html>

