<%-- 
    Document   : clientes
    Created on : 19/04/2017, 20:24:33
    Author     : fabio.jrezequiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="dist/css/clientes.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <div class="main">
                        <!-- Programar aqui!! -->
                        <div class="row">
                            <form class="col s12">
                                <div> 
                                    <div class="col s3">
                                        <button class="btn waves-effect waves-light" type="button" name="action">Adicionar
                                            <i class="fa fa-plus" aria-hidden="true"></i> 
                                        </button>
                                    </div>
                                    <div class="rigth col s9">
                                        <div class="input-field col s8 left offset-s2">
                                            <input id="icon_prefix" type="text" class="validate">
                                            <label for="icon_prefix">Procurar...</label>
                                        </div>
                                        <div class="btn-procurar">
                                            <button class="btn waves-effect waves-light" type="button" name="action">
                                                <i class="material-icons">search</i>  
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div><!-- fim da linha -->

                        <div class="row">
                            <div class="card">

                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header> Clientes</header>

                                </div>

                                <div class="corpo-card">
                                    <table class="striped">
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
                                            <tr>
                                                <td>1</td>  
                                                <td>Everton Roberto de Oliveira</td>
                                                <td>111.111.111-11</td>
                                                <td>(11)5555-5555</td>
                                                <td>everton_roliveira@outlook.com</td>
                                                <td>
                                                    <button class="btn waves-effect waves-light btn-ver" type="submit" name="action">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-editar" type="submit" name="action">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-apagar" type="submit" name="action">
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Fabio Ribeiro</td>
                                                <td>222.222.222-22</td>
                                                <td>(11)5555-6666</td>
                                                <td>fabio@live.com</td>
                                                <td>
                                                    <button class="btn waves-effect waves-light btn-ver" type="submit" name="action">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-editar" type="submit" name="action">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-apagar" type="submit" name="action">
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div><!--Fim .card-body -->
                        </div>
                    </div><!-- fim da linha-->

                </div>
            </div>
        </div>    
    </body>
</html>
