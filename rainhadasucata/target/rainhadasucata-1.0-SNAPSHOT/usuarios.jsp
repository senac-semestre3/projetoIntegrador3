
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>

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

                    <div class="main">
                        <!-- Programar aqui!! -->

                        <!-- btn e txt -->
                        <!-- inicio da linha -->
                        <div class="row box-topo-tela-chamada">
                            <div class="col s12">

                                <div class="col s5 box-btn-adicionar">
                                    <a href="usuario-adicionar.jsp">
                                        <button class="btn waves-effect waves-light" type="button" name="btn-adicionar">Adicionar
                                            <i class="fa fa-plus" aria-hidden="true"></i> 
                                        </button>
                                    </a>
                                </div>
                                <div class="col s6">
                                    <form method="get" action="UsuarioController">
                                        <!-- passar a acao para o controller listar-->
                                        <input type="hidden" name="acao" value="UsuarioListar" />
                                        <div class="input-field">
                                            <input id="txtBuscaUsuario" type="text" class="validate" name="busca">
                                            <label for="txtBuscaUsuario">Usuário...</label>
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
                                    <header> Usuários</header>

                                </div>

                                <div class="corpo-card">
                                    <table class="tabela-clientes horizontal striped">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Nome</th>
                                                <th>Cpf</th>
                                                <th>Telefone</th>
                                                <th>Permissão</th>
                                                <th>Ação</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${usuarios}" var="usuario">
                                            <tr>
                                                <form method="post" name="form">
                                                    <td><c:out value="${usuario.id}" /></td>
                                                    <td><c:out value="${usuario.nome}" /></td>
                                                    <td><c:out value="${usuario.cpf}" /></td>
                                                    <td><c:out value="${usuario.telefone}" /></td>
                                                    <td><c:out value="${usuario.idPermissao}" /></td>

                                                    <!-- Ver, Editar e Deletar cliente-->
                                                    <td id="btnAcao">
                                                        <a href="UsuarioController?id=${usuario.id}&acao=UsuarioObter&pagina=usuario-ver"
                                                           class="waves-effect waves-teal btn-ver tooltipped" data-position="left" data-delay="50" 
                                                                data-tooltip="detalhes do cliente" type="submit">
                                                            <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                        </a>
                                                        <a href="UsuarioController?id=${usuario.id}&acao=UsuarioObter&pagina=usuario-editar"
                                                            class="waves-effect waves-light btn-editar tooltipped" data-position="bottom" data-delay="50" 
                                                            data-tooltip="editar cliente" type="submit">
                                                            <i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
                                                        </a>
                                                        <a href="UsuarioController?id=${usuario.id}&acao=UsuarioDeletar"
                                                           class="waves-effect waves-light btn-deletar tooltipped" data-position="top" data-delay="50" 
                                                           data-tooltip="deletar cliente" type="submit">
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
    </body>
</html>

