<%-- 
    Document   : ver-produtos
    Created on : 19/04/2017, 13:10:39
    Author     : DANILO&PAULA
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="dist/css/produto-ver.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <!-- Programar aqui!! -->
                    <div class="main">
                        <div class="row">
                            <button class="btn waves-effect waves-light right" type="button" name="action">Editar
                                <i class="fa fa-pencil" aria-hidden="true"></i>  
                            </button>   
                        </div><!-- fim -->

                        <!-- Dados produtos -->
                        <div class="row">
                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-barcode left" aria-hidden="true"></i>
                                    <header>Produto</header>
                                </div>
                                <div class="corpo-card">
 
                                    <div class="row">
                                    <div class="legenda legenda-produtos">
                                        <i class="fa fa-barcode left" aria-hidden="true"></i>                 
                                        <legend>Produto</legend>
                                    </div></div>


                                    <table class="striped">
                                        <thead>
                                        <tbody>
                                            <tr>
                                                <th>Codigo:</th>
                                                <td>001</td>
                                            </tr>
                                            <tr>
                                                <th>Nome:</th>
                                                <td>Cilindro mestre do freio</td>
                                            </tr>
                                            <tr>
                                                <th>Marca:</th>
                                                <td>Shell</td>
                                            </tr>
                                            <tr>
                                                <th>Descricao:</th>
                                                <td> Cilindro mestre do freio - Bosch - Gol/Parati/Saveiro/Santana/Quantum 92/ - Versailles/Royale - cada (unidade)</td>
                                            </tr>
                                            <tr>
                                                <th>Preco Compra:</th>
                                                <td>R$870,00</td>
                                            </tr>
                                            <tr>
                                                <th>Preco Venda:</th>
                                                <td>R$1000,50</td>
                                            </tr>
                                            <tr>
                                                <th>Margem Venda:</th>
                                                <td>15%</td>
                                            </tr>
                                            <tr>
                                                <th>Estoque:</th>
                                                <td>20</td>
                                            </tr>
                                            <tr>
                                                <th>Estoque Minimo:</th>
                                                <td>05</td>
                                            </tr>
                                            <tr>
                                                <th>Status:</th>
                                                <td>50%</td>
                                            </tr>
                                        </tbody>
                                        </thead>
                                    </table>
                                </div> 
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
