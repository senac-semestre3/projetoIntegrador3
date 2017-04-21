<%-- 
    Document   : cliente-ver
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
        <link href="dist/css/cliente-ver.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <div class="main">
                        <!-- Programar aqui!! -->
                        <div class="row">
                            <div class="input-field col s5 offset-s1">
                                <button class="btn waves-effect waves-light" type="button" name="action">Adicionar
                                    <i class="fa fa-check" aria-hidden="true"></i>  
                                </button>
                            </div>

                            <div class="input-field col s5">
                                <i class="material-icons prefix right">search</i>
                                <input id="icon_prefix" type="text" class="validate">
                                <label for="icon_prefix">First Name</label>
                            </div>
                        </div>


                        <div class="row">
                            <div class="card">


                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="material-icons left">assignment</i>
                                    <header>Detalhes da Venda</header>
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
                                                    <i class="small material-icons">visibility</i>
                                                    <i class="tyne material-icons">mode_edit</i>
                                                    <i class="tyne material-icons">delete</i>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Willian Marques</td>
                                                <td>222.222.222-22</td>
                                                <td>(11)5555-6666</td>
                                                <td>willian@gmail.com</td>
                                                <td>

                                                    <button class="btn waves-effect waves-light btn-ver" type="submit" name="action">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-editar" type="submit" name="action">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </button>
                                                    <button class="btn waves-effect waves-light btn-ver" type="submit" name="action">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
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
    </div>
</body>
</html>