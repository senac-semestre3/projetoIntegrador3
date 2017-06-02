
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

        <style>
            .input-normal{
                margin: 0 !important;
                height: 2rem !important;
            }
            select.input-normal{
                display: block;
                padding: 0 20px !important;
            }
            .td-numero{
                width: 100px;
            }

        </style>

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
                                <a href="produto-adicionar.jsp">
                                    <button class="btn btn-adicionar-cliente waves-effect waves-light" type="button" name="btn-adicionar">
                                        Adicionar
                                        <i class="fa fa-plus" aria-hidden="true"></i> 
                                    </button>
                                </a>
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
                                    <form action="ProdutoController">
                                        <input type="hidden" name="acao" value="ProdutoListar">
                                        <td class="td-numero">
                                            <input class="input-normal" type="number" name="buscaId">
                                        </td>
                                        <td> 
                                            <input class="input-normal" type="text" name="buscaNome">
                                        </td>
                                        <td>
                                            <input class="input-normal" type="text" name="buscaPrecoVenda">
                                        </td>
                                        <td class="td-numero">
                                            <input class="input-normal" type="number" name="buscaEstoque">
                                        </td>
                                        <td>
                                            <select name="buscaStatus" class="input-normal">
                                                <option value=""></option>
                                                <option value="on">Ativo</option>
                                                <option value="off">Inativo</option>
                                            </select>

                                        </td>
                                        <td>  
                                            <button class="btn-procurar waves-effect waves-teal btn-ver" type="submit">
                                                <i class="fa fa-search fa-2x" aria-hidden="true"></i> 
                                            </button>
                                        </td>
                                    </form>
                                    <c:forEach items="${produtos}" var="produto">
                                        <tr>
                                        <form method="post" name="form" action="ProdutoControler">
                                            <td><c:out value="${produto.id}" /></td>
                                            <td><c:out value="${produto.nome}" /></td>
                                            <td><c:out value="${produto.precoVenda}" /></td>
                                            <td><c:out value="${produto.estoque}" /></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${produto.status == 1}">
                                                        Ativo
                                                    </c:when>
                                                    <c:otherwise>
                                                        Inativo
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>

                                            <!-- Ver, Editar e Deletar produto-->
                                            <td id="btnAcao">
                                                <a  href="ProdutoController?id=${produto.id}&acao=ProdutoObter&pagina=produto-ver"
                                                    class="waves-effect waves-teal btn-ver tooltipped" data-position="left" 
                                                    data-delay="50" data-tooltip="detalhes da produto" type="submit">
                                                    <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                </a>

                                                <a  href="ProdutoController?id=${produto.id}&acao=ProdutoObter&pagina=produto-editar" 
                                                    class="waves-effect waves-light btn-editar tooltipped" data-position="bottom" 
                                                    data-delay="50" data-tooltip="editar produto" type="submit">
                                                    <i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
                                                </a>
                                                <a  href="ProdutoController?id=${produto.id}&acao=ProdutoDeletar" 
                                                    class="waves-effect waves-light btn-deletar tooltipped" data-position="top" 
                                                    data-delay="50" data-tooltip="deletar produto" type="submit">
                                                    <i class="fa fa-trash-o fa-2x" aria-hidden="true"></i>
                                                </a>
                                            </td>
                                        </form>
                                        </tr>
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
