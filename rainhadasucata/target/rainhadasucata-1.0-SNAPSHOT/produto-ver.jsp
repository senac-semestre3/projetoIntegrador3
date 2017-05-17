<%-- 
    Document   : produto-ver
    Created on : 23/04/2017, 17:52:55
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/tela-ver-dados.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <div class="main">
                        <!-- Programar aqui!! -->
                        <div class="row">
                            <button class="btn btn-editar-produto waves-effect waves-light right" type="button" name="action">Editar
                                <i class="fa fa-pencil"></i> 
                            </button>
                        </div>


                        <div class="row"><!-- INICIO DA LINHA -->
                            <div class="card"><!-- INICIO DO CARD -->


                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-barcode left"></i>
                                    <header>Informações do Produto</header>
                                </div>

                                <div class="corpo-card"><!-- INICIO DO CORPO DO CARD -->
                                    <ul class="collapsible popout" data-collapsible="accordion">
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">description</i><span>Descrição do Produto</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-produto-ver-descricao vertical striped">
                                                    <tr>
                                                        <th>Id</th>
                                                        <td>${produto.id}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <td>${produto.nome}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Marca</th>
                                                        <td>${produto.marca}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Descrição</th>
                                                        <td>${produto.descricao}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Situação</th>
                                                        <td>${produto.status}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header"><i class="fa fa-usd" aria-hidden="true"></i><span>Valores</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-contato vertical striped">
                                                    <tr>
                                                        <th>Preço de compra</th>
                                                        <td>${produto.precoCompra}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Margem de lucro</th>
                                                        <td>${produto.margemVenda}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Valor de Venda</th>
                                                        <td>${produto.precoVenda}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header active"><i class="material-icons">done_all</i><span>Estoque</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-endereco vertical striped">
                                                    <tr>
                                                        <th>Quantidade em Estoque</th>
                                                        <td>${produto.estoque}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Estoque mínimo</th>
                                                        <td>${produto.estoqueMinimo}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Status</th>
                                                        <td>${produto.status}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                    </ul>
                                </div> <!-- FIM DO CORPO DO CARD -->

                            </div><!--FIM DO CARD -->
                        </div><!-- FIM DA LINHA -->
                    </div><!-- FIM DO MAIN-->

                </div>
            </div>
        </div>
    </div>

    <!-- javascript das libs -->
    <script src="dist/js/lib.min.js" type="text/javascript"></script>
</body>
</html>

