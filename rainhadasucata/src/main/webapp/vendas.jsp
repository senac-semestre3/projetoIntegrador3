
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

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>

        <!-- javascript da pagina -->
        <script src="dist/js/vendas.js" type="text/javascript"></script>

        <style>
            #btnProcuraProduto{
                background: transparent;
                border: none;
            }
            #btnProcuraProduto:focus{
                background: transparent;

            }
            #btnProcuraProduto:hover{
                color: #2ab7a9;
            }
            #inpNomeProduto{
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
            .toast.error{
                float: left;
                background: #f2dede;
                color: #843534;
                font-weight: 400;
                border: 1px solid #ebccd1;
                font-size: 1.4rem;
                top: 30px;
            }
            .toast.warning{
                float: left;
                background: #fcf8e3;
                color: #8a6d3b;
                font-weight: 400;
                border: 1px solid #faebcc;
                font-size: 1.4rem;
                top: 30px;
            }
            .toast.success{
                float: left;
                background: #dff0d8;
                color: #3c763d;
                font-weight: 400;
                border: 1px solid #d6e9c6;
                font-size: 1.4rem;
                top: 30px;
            }
            table.tabela-detalhes-venda td:nth-of-type(3){
                max-width: 120px;
                min-width: 120px;
            }
            table.tabela-detalhes-venda td:last-of-type{
                max-width: 50px;
            }
            table.tabela-detalhes-venda td:first-of-type{
                max-width: 90px;
            }
            .td-borda-vermelha{
                border-left: 1px solid red !important;
                border: solid red 1px;
            }
        </style>
        
    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">
                    <div class="main">
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
                                                <th>Cliente</th>
                                                <th>Vendedor</th>
                                                <th><i class="fa fa-credit-card fa-2x" aria-hidden="true"></i></th>
                                                <th>Data</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <td>${sessionScope.venda.cliente.nome}</td>
                                                <td>${sessionScope.venda.usuario.nome}</td>
                                                <td id="tdMetodoPagamento">

                                                    <input class="with-gap" name="metodo-pagamento" type="radio" id="debito" value="Debito"/>
                                                    <label for="debito" onclick="alteraTd(this)">Débito</label>

                                                    <input class="with-gap" name="metodo-pagamento" type="radio" id="credito" value="Crédito"/>
                                                    <label for="credito" onclick="alteraTd(this)">Crédito</label>

                                                    <input class="with-gap" name="metodo-pagamento" type="radio" id="dinheiro" value="Dinheiro"/>
                                                    <label for="dinheiro" onclick="alteraTd(this)">Dinheiro</label>

                                                </td>
                                                <td>${sessionScope.venda.data}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div><!--Fim .card-body -->
                            </div>
                        </div><!-- fim da linha-->
                        <div class="row">
                            <div class="right">
                                <button class="btn btn-cancelar waves-effect waves-light" type="button" data-target="modalCancelar">Cancelar
                                    <i class="fa fa-ban" aria-hidden="true"></i>
                                </button>
                                <a id="btnFaturar">
                                    <button class="btn btn-faturar waves-effect waves-light" type="button">Faturar
                                        <i class="fa fa-usd" aria-hidden="true"></i>
                                    </button>  
                                </a>
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
                                                    <input id="inpCodigoProduto" type="number" class="validate" min="0">
                                                    <label for="inpCodigoProduto">codigo</label>
                                                </div>
                                                <div class="input-field col s1">
                                                    <button id="btnProcuraProduto" type="button" name="action">
                                                        <i class="fa fa-search fa-2x" aria-hidden="true"></i>
                                                    </button>
                                                </div>
                                                <div class="input-field col s4">
                                                    <input disabled id="inpNomeProduto" type="text" class="validate">
                                                    <label for="inpNomeProduto">Produto</label>
                                                </div>

                                                <div class="input-field col offset-s1">
                                                    <button id="btnAdicionaProduto" class="btn waves-effect waves-light" type="button">Adicionar
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
                                                <c:forEach items="${sessionScope.itensVenda}" var="item">
                                                    <tr id="${item.produto.id}">
                                                        <td><c:out value="${item.produto.id}" /></td>
                                                        <td><c:out value="${item.produto.nome}" /></td>
                                                        <td>
                                                            <button onclick="quantidadeMenos(this)"><i class="fa fa-minus"></i></button>
                                                            <input type="number" value="${item.quantidade}" />
                                                            <button onclick="quantidadeMais(this)"><i class="fa fa-plus"></i></button>
                                                        </td>
                                                        <td>
                                                            <button onclick="removeItem(this)"><i class="fa fa-close"></i></button>
                                                        </td>
                                                        <td><c:out value="R$ ${item.produto.precoVenda}" /></td>
                                                        <td><c:out value="R$ ${item.subtotal}" /></td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td colspan="4"></td>
                                                    <td>Total: </td>
                                                    <td id="tdValorTotal">R$ ${sessionScope.venda.total}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Modal Structure -->
                        <div id="modalCancelar" class="modal">
                            <div class="modal-content">
                                <h4>Deseja realmente cancelar essa compra?</h4>
                            </div>
                            <div class="modal-footer">
                                <a href="VendaController?&acao=VendaCancelar" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Cancelar</a>
                                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">voltar</a>
                            </div>
                        </div>

                        <!-- Modal Structure -->
                        <div id="modalFaturar" class="modal">
                            <div class="modal-content">
                                <h4>Informações da Compra</h4>
                                <div class="row">
                                    <table class="tabela-detalhes-venda horizontal striped">
                                        <thead>
                                            <tr>
                                                <th>Cliente</th>
                                                <th>Método de Pagamento</th>
                                                <th>Data</th>
                                            </tr>
                                        </thead>

                                        <tbody>

                                            <tr>
                                                <td>${sessionScope.venda.cliente.nome}</td>
                                                <td>Débito</td>
                                                <td>${sessionScope.venda.data}</td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <th>Total </th>
                                                <td id="totalModal">R$ </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <table class="tabela-produtos horizontal striped">
                                        <thead>
                                            <tr>
                                                <th>Produto</th>
                                                <th>Quantidade</th>
                                                <th>Valor</th>
                                                <th>Subtotal</th>
                                            </tr>
                                        </thead>

                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <a href="ClienteController?&acao=ClienteListar&busca=" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Sair</a>
                                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
                            </div>
                        </div>

                    </div>
                </div><!-- Limite da programação -->
            </div>
        </div>
    </body>
</html>
