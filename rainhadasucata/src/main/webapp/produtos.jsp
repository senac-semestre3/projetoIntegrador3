<%-- 
    Document   : produto
    Created on : 13/04/2017, 21:04:35
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/tela-chamada.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <!-- btn e txt -->
                    <!-- inicio da linha -->
                    <div class="row box-topo-tela-chamada">
                        <div class="col s12">
                            <div class="col s5 box-btn-adicionar">
                                <a href="produto-cadastro.jsp">
                                    <button class="btn btn-adicionar-cliente waves-effect waves-light" type="button" name="btn-adicionar">
                                        Adicionar
                                        <i class="fa fa-plus" aria-hidden="true"></i> 
                                    </button>
                                </a>
                            </div>
                            <div class="col s6">
                                <form>
                                    <div class="input-field">
                                        <input id="txt-cliente-procurar" type="text" class="validate">
                                        <label for="txt-cliente-procurar">Produto...</label>
                                        <button class="btn-procurar waves-effect waves-light right" type="button" name="btn-procurar-cliente">
                                            <i class="fa fa-search fa-2x" aria-hidden="true"></i> 
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="row"><!-- inicio da linha -->
                        <div class="card">
                            <div class="cabecalho cabecalho-informacoes">
                                <i class="fa fa-barcode left" aria-hidden="true"></i>
                                <header> Produtos</header>

                            </div>

                            <div class="corpo-card">
                                <table class="tabela-produtos horizontal striped">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nome</th>
                                            <th>Valor de Venda</th>
                                            <th>Estoque</th>
                                            <th>Status</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                      <c:forEach items="${listaProdutos}" var="produto">
                                            <form action="servlet-produto-ver" method="get">
                                                <tr>
                                                <input type="hidden" name="id" value="${produto.id}" />
                                                    <td><c:out value="${produto.id}" /></td>
                                                    <td><c:out value="${produto.nome}" /></td>
                                                    <td><c:out value="${produto.precoVenda}" /></td>
                                                    <td><c:out value="${produto.estoque}" /></td>
                                                    <td><c:out value="${produto.status}" /></td>

                                                    <td>
                                                        <!--<input type="submit">-->
                                                        <button class="waves-effect waves-teal btn-ver tooltipped" data-position="left" data-delay="50" data-tooltip="detalhes do cliente" type="submit" name="btn-ver">
                                                            <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                        </button
                                                        </a>
                                                        <button class="waves-effect waves-light btn-editar tooltipped" data-position="bottom" data-delay="50" data-tooltip="editar cliente" type="submit" name="btn-editar">
                                                            <i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
                                                        </button>
                                                        <button class="waves-effect waves-light btn-deletar tooltipped" data-position="top" data-delay="50" data-tooltip="deletar cliente" type="submit" name="btn-deletar">
                                                            <i class="fa fa-trash-o fa-2x" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </form>
                                        </c:forEach> 
                                           
                                    </tbody>
                                </table>
                            </div>
                        </div><!--Fim .card -->
                    </div><!-- fim da linha -->
                </div><!-- fim do main-->
            </div>
        </div>

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
    </body>
</html>
