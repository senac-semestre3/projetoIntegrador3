
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/vendas.css" rel="stylesheet" type="text/css"/>

        <style>
            #procuraProduto{
                background: transparent;
                border: none;
            }
            #procuraProduto:focus{
                background: transparent;

            }
            #procuraProduto:hover{
                color: #2ab7a9;
            }
            #txtNomeProduto{
                color: #092340;
            }
            td input[type="number"]{
                margin: 0;
                width: 80px;
                height: 1.5rem;
                border: none;
                text-align: center !important;
            }
            td input[type="number"]:focus{
                box-shadow: none !important;
            }
            td input[type=number]::-webkit-inner-spin-button { 
                -webkit-appearance: none;
            }
        </style>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">
                    <div class="main">
                        <!-- Programar aqui!! -->

                        <div class="row box-topo-tela-chamada">
                            <div class="col s12">
                                <div class="col s5">
                                    <form>
                                        <div class="input-field">
                                            <i class="material-icons prefix">account_circle</i>
                                            <input id="icon_prefix" type="text" class="validate" name="cliente">
                                            <label for="icon_prefix">Cliente</label>
                                            <button class="btn-procurar waves-effect waves-light right" type="submit">
                                                <i class="fa fa-search fa-2x" aria-hidden="true"></i> 
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <div class="col s5 box-btn-adicionar offset-s1">
                                    <button class="btn btn-adicionar-cliente waves-effect waves-light" type="button" name="btn-adicionar">Adicionar
                                        <i class="fa fa-plus" aria-hidden="true"></i> 
                                    </button>
                                </div>
                            </div>
                        </div>

                        <!-- Detalhes da compra -->
                        <div class="row">
                            <div class="card">

                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="material-icons left">assignment</i>
                                    <header>Detalhes da Venda</header>
                                </div>

                                <div class="corpo-card">
                                    <table class="tabela-detalhes-venda horizontal striped">
                                        <thead>
                                            <tr>
                                                <th>Id da venda</th>
                                                <th>Cliente</th>
                                                <th>Vendedor</th>
                                                <th>Método de Pagamento</th>
                                                <th>Data</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <td>52</td>
                                                <td>${cliente.nome}</td>
                                                <td>Willian Marques</td>
                                                <td></td>
                                                <td>14/04/2017</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <div class="meios-pagamento">
                                        <div class="circulo">
                                            <i class="fa fa-credit-card " aria-hidden="true"></i>
                                        </div>
                                        <div class="pagamento">
                                            <input class="with-gap metodo-pagamento" name="metodo-pagamento" type="radio" id="debito" value="Debito"/>
                                            <label for="debito">Débito</label>

                                            <input class="with-gap metodo-pagamento" name="metodo-pagamento" type="radio" id="credito" value="Crédito"/>
                                            <label for="credito">Crédito</label>

                                            <input class="with-gap metodo-pagamento" name="metodo-pagamento" type="radio" id="dinheiro" value="Dinheiro"/>
                                            <label for="dinheiro">Dinheiro</label>
                                        </div>
                                    </div>

                                </div><!--Fim .card-body -->
                            </div>
                        </div><!-- fim da linha-->
                        <div class="row">
                            <div class="right">
                                <button class="btn btn-cancelar waves-effect waves-light" type="button" name="action">Cancelar
                                    <i class="fa fa-ban" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-faturar waves-effect waves-light" type="button" name="action">Faturar
                                    <i class="fa fa-usd" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>

                        <!-- Carrinho -->
                        <div class="row">
                            <div class="card">

                                <div class="cabecalho cabecalho-carrinho">
                                    <i class="fa fa-cart-plus left" aria-hidden="true"></i>
                                    <!--<i class="material-icons prefix left">shopping_cart</i>-->

                                    <header>Carrinho</header>
                                </div>

                                <div class="corpo-card">
                                    <div class="row">
                                        <form class="col s12">
                                            <div class="row">
                                                <div class="input-field col s3">
                                                    <i class="material-icons prefix fa fa-barcode"></i>
                                                    <input id="txtCodigoProduto" type="number" class="textCodigoProduto validate" min="0">
                                                    <label for="txtCodigoProduto">codigo</label>
                                                </div>
                                                <div class="input-field col s1">
                                                    <button id="procuraProduto" type="button" name="action">
                                                        <i class="fa fa-search fa-2x" aria-hidden="true"></i>
                                                    </button>
                                                </div>
                                                <div class="input-field col s4">
                                                    <input disabled id="txtNomeProduto" type="text" class="validate">
                                                    <label for="txtNomeProduto">Produto</label>
                                                </div>

                                                <div class="input-field col offset-s1">
                                                    <button id="btnAdicionarProduto" class="btn btn-adicionar-carrinho waves-effect waves-light" type="button">Adicionar
                                                        <i class="fa fa-plus" aria-hidden="true"></i> 
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                        <table class="tabela-produtos horizontal striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Produto</th>
                                                    <th>Quantidade</th>
                                                    <th>Ação</th>
                                                    <th>Valor</th>
                                                    <th>Subtotal</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <tr>
                                                    <td colspan="4"></td>
                                                    <td>Total: </td>
                                                    <td id="tdValorTotal">R$ 0,00</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div><!-- Limite da programação -->
            </div>
        </div>
    </div>

    <!-- javascript das libs -->
    <script src="dist/js/lib.min.js" type="text/javascript"></script>

    <!-- javascript da pagina -->
    <script src="dist/js/vendas.js" type="text/javascript"></script>
</body>
</html>
