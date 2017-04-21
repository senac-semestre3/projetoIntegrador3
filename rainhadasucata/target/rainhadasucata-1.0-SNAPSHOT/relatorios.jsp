<%-- 
    Document   : relatorios
    Created on : 14/04/2017, 17:29:40
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorios</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/relatorios.css" rel="stylesheet" type="text/css"/>


    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <!-- Programar aqui!! -->

                    <div class="main">
                        <!-- Gera Relatório -->
                        <div class="row">

                            <!-- RELATÓRIO RÁPIDO -->
                            <div class="card col s4">

                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-usd left" aria-hidden="true"></i>
                                    <header>Relatório Rápido</header>
                                </div>

                                <div class="corpo-card">
                                    <div class="row">
                                        <button class="btn todas-vendas waves-effect waves-light" type="button" name="action">
                                            <i class="fa fa-tags" aria-hidden="true"></i>  
                                        </button>
                                    </div>
                                    <div class="row">
                                        <div class="input-field">
                                            <select>

                                                <option value="" disabled selected>Buscar por todas as lojas</option>
                                                <option value="1">Matriz</option>
                                                <option value="2">Rio de Janeiro</option>
                                                <option value="3">Salvador</option>
                                            </select>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field">
                                            <select>

                                                <option value="" disabled selected>Buscar por vendedor</option>
                                                <option value="1">Augusto</option>
                                                <option value="2">Everton</option>
                                                <option value="3">Fabio</option>
                                            </select>

                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- RELATÓRIO CUSTOMIZAVEL -->
                            <div class="card col s6 offset-s2">

                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-wrench left" aria-hidden="true"></i>
                                    <header>Relatório Customizado</header>
                                </div>

                                <div class="corpo-card">
                                    <div class="row">
                                        <div class="box-data col s5">
                                            <label for="data-inicial" class="active">Data inicial</label>
                                            <input type="date" class="datepicker data-inicial">
                                        </div>

                                        <div class="box-data  col s5 offset-s2">
                                            <label for="data-final" class="active">Data final</label>
                                            <input type="date" class="datepicker data-final">
                                        </div>
                                    </div>
                                    <div class="input-field">
                                        <input id="cliente" type="text" class="validate">
                                        <label for="cliente">Cliente</label>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <select>

                                                <option value="" disabled selected>Buscar por vendedor</option>
                                                <option value="1">Augusto</option>
                                                <option value="2">Everton</option>
                                                <option value="3">Fabio</option>
                                            </select>
                                        </div>
                                        <div class="input-field col s5 offset-s1">
                                            <select>

                                                <option value="" disabled selected>Buscar por loja</option>
                                                <option value="1">Matriz</option>
                                                <option value="2">Rio de Janeiro</option>
                                                <option value="3">Salvador</option>
                                                <option value="3">Salvador</option>
                                                <option value="3">Salvador</option>
                                            </select>
                                        </div>
                                        <button class="btn busca-customizada waves-effect waves-light col s12" type="button" name="procurar">
                                            <i class="fa fa-search" aria-hidden="true"></i>  
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <!-- Tabela valor total de vendas -->
                        <div class="row">
                            <div class="card">

                                <div class="cabecalho cabecalho-carrinho">
                                    <i class="fa fa-usd left" aria-hidden="true"></i>

                                    <header>Valor Total das Vendas</header>
                                </div>

                                <div class="corpo-card">
                                    <div class="row">
                                        <table class="tabela-valor-total striped">
                                            <thead>
                                                <tr>
                                                    <th>Data inicial</th>
                                                    <th>Data final</th>
                                                    <th>Crédito</th>
                                                    <th>Débito</th>
                                                    <th>Dinheiro</th>
                                                    <th>Ação</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <tr>
                                                    <td>19/02/2016</td>
                                                    <td>22/02/2017</td>
                                                    <td>R$ 1000,00</td>
                                                    <td>R$ 1100,00</td>
                                                    <td>R$ 400,00</td>
                                                    <td rowspan="2">
                                                        <button class="btn-gerar-pdf waves-effect waves-light">
                                                            <i class="fa fa-file-pdf-o fa-4x" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>Total: </th>
                                                    <td colspan="3"></td>
                                                    <td>R$ 2500,00</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Tabela todas as vendas -->
                        <div class="row">
                            <div class="card">

                                <div class="cabecalho cabecalho-carrinho">
                                    <i class="fa fa-file-text-o left" aria-hidden="true"></i>

                                    <header>Todas as Vendas</header>
                                </div>

                                <div class="corpo-card">
                                    <div class="row">
                                        <table class="tabela-valor-total striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Cliente</th>
                                                    <th>Valor</th>
                                                    <th>Data</th>
                                                    <th>Método de Pagamento</th>
                                                    <th>Ação</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <tr>
                                                    <td>52</td>
                                                    <td>Willian Marques Vieira</td>
                                                    <td>R$ 100,00</td>
                                                    <td>22/02/2017</td>
                                                    <td>Débito</td>
                                                    <td>
                                                        <button class="btn-ver waves-effect waves-light">
                                                            <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>57</td>
                                                    <td>Everton Roberto de Oliveira</td>
                                                    <td>R$ 300,00</td>
                                                    <td>22/02/2017</td>
                                                    <td>Cŕedito</td>
                                                    <td>
                                                        <button class="btn-ver waves-effect waves-light">
                                                            <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>61</td>
                                                    <td>Fabio Junior</td>
                                                    <td>R$ 150,00</td>
                                                    <td>22/02/2017</td>
                                                    <td>Dinheiro</td>
                                                    <td>
                                                        <button class="btn-ver waves-effect waves-light">
                                                            <i class="fa fa-eye fa-2x" aria-hidden="true"></i>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

        <!-- javascript da pagina -->
        <script src="dist/js/materialize.js" type="text/javascript"></script>
    </body>
</html>

