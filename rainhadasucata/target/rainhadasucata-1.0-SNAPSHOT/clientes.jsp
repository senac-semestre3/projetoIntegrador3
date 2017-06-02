
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/tela-chamada.css" rel="stylesheet" type="text/css"/>

    </head>
    <body >
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <div class="main">
                        <!-- Programar aqui!! -->

                        <!-- btn e txt -->
                        <!-- inicio da linha -->
                        <div class="row box-topo-tela-chamada">
                            <div class="col s12">
                                <div class="col s5 box-btn-adicionar">
                                    <a href="cliente-adicionar.jsp">
                                        <button class="btn waves-effect waves-light" type="button">Adicionar
                                            <i class="fa fa-plus" aria-hidden="true"></i> 
                                        </button>
                                    </a>
                                </div>
                                <div class="col s6">
                                    <form action="ClienteController">
                                        <!-- passar a acao para o controller listar-->
                                        <input type="hidden" name="acao" value="ClienteListar" />
                                        <div class="input-field">
                                            <input id="txtBuscaCliente" type="text" class="validate" name="busca">
                                            <label for="txtBuscaCliente">Cliente...</label>

                                            <button class="btn-procurar waves-effect waves-light right" type="submit">
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
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header> Clientes</header>
                                </div>
                                <div class="corpo-card">
                                    <table class="tabela-clientes horizontal striped">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Nome</th>
                                                <th>Cpf ou Cnpj</th>
                                                <th>Telefone</th>
                                                <th>E-mail</th>
                                                <th>Ação</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${clientes}" var="cliente">
                                                <tr>
                                                    <form method="post" name="form">

                                                        <td><c:out value="${cliente.id}" /></td>
                                                        <td><c:out value="${cliente.nome}" /></td>
                                                        <td><c:out value="${cliente.cpf}" /></td>
                                                        <td><c:out value="${cliente.telefone}" /></td>
                                                        <td><c:out value="${cliente.email}" /></td>

                                                        <!-- Ver, Editar e Deletar cliente-->
                                                        <td id="btnAcao">
                                                            <a  href="ClienteController?id=${cliente.id}&acao=ClienteObter&pagina=cliente-ver"
                                                                class="waves-effect waves-teal btn-ver tooltipped" data-position="left" 
                                                                data-delay="50" data-tooltip="detalhes do cliente" type="submit">
                                                                <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                            </a>

                                                            <a  href="ClienteController?id=${cliente.id}&acao=ClienteObter&pagina=cliente-editar" 
                                                                class="waves-effect waves-light btn-editar tooltipped" data-position="bottom" 
                                                                data-delay="50" data-tooltip="editar cliente" type="submit">
                                                                <i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
                                                            </a>
                                                            <a  href="ClienteController?id=${cliente.id}&acao=ClienteDeletar" 
                                                                class="waves-effect waves-light btn-deletar tooltipped" data-position="top" 
                                                                data-delay="50" data-tooltip="deletar cliente" type="submit">
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
        </div>

        
        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
        <script src="dist/js/Cliente.js" type="text/javascript"></script>
    </body>
</html>
