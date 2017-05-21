<%-- 
    Document   : clientes
    Created on : 19/04/2017, 20:24:33
    Author     : fabio.jrezequiel
--%>

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
                                    <a href="cliente-cadastro.jsp">
                                        <button class="btn btn-adicionar-cliente waves-effect waves-light" type="button" name="btn-adicionar">Adicionar
                                            <i class="fa fa-plus" aria-hidden="true"></i> 
                                        </button>
                                    </a>
                                </div>
                                <div class="col s6">
                                    <form>
                                        <div class="input-field">
                                            <input id="txt-cliente-procurar" type="text" class="validate">
                                            <label for="txt-cliente-procurar">Cliente...</label>
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
                                                <th>ClienteOk</th>
                                                <th>Ação</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <!--1-->
                                        <input type="hidden" id="clienteok" name="clienteok" value="${sessionScope.clienteok}">

                                        <h2><c:out value="${sessionScope.clienteok}" /></h2> 
                                        <c:remove scope="session" var="clienteok" />

                                        <c:forEach items="${listaContatos}" var="contato">
                                            <form action="servlet-cliente-ver" method="get">
                                                <tr>
                                                    <!-- Esse input serve para o botão pegar o id-->
                                                <input type="hidden" name="id" value="${contato.id}">
                                                <td><c:out value="${contato.id}" /></td>
                                                <td><c:out value="${contato.nome}" /></td>
                                                <td><c:out value="${contato.cpfCnpj}" /></td>
                                                <td><c:out value="${contato.telefone}" /></td>
                                                <td><c:out value="${contato.email}" /></td>
                                                <td>
                                                    <!--                                                        <input type="submit">-->
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
                                        <!--1-->

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
        <script type="text/javascript">
            function submitForm()
            {

                var a = document.getElementById("clienteok").value;
                if (a == "1") {
                    alert(a);
                } else if (a == "0") {
                    alert("Erro");
                }
            }
            window.onload = submitForm;
        </script>
    </body>
</html>
