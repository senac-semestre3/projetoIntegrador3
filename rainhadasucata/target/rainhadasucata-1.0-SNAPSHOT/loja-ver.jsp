
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loja</title>

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
                            <a href="LojaController?id=${loja.id}&acao=LojaObter&pagina=loja-editar">
                                <button class="btn btn-editar-loja waves-effect waves-light right" type="button">Editar
                                    <i class="fa fa-pencil"></i> 
                                </button>
                            </a>
                        </div>


                        <div class="row"><!-- INICIO DA LINHA -->
                            <div class="card"><!-- INICIO DO CARD -->


                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-home left"></i>
                                    <header>Informações da Loja</header>
                                </div>

                                <div class="corpo-card"><!-- INICIO DO CORPO DO CARD -->
                                    <ul class="collapsible popout" data-collapsible="accordion">
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">person_pin</i><span>Razão Social</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-loja-ver-razao vertical striped">
                                                    <tr>
                                                        <th>Id</th>
                                                        <td>${loja.id}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <td>${loja.nome}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cnpj</th>
                                                        <td>${loja.cnpj}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">email</i><span>Dados de Contato</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-loja-ver-contato vertical striped">
                                                    <tr>
                                                        <th>Telefone</th>
                                                        <td>${loja.telefone}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>E-mail</th>
                                                        <td>${loja.email}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header active"><i class="material-icons">location_on</i><span>Dados de Endereço</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-loja-ver-endereco vertical striped">
                                                    <tr>
                                                        <th>Logradouro</th>
                                                        <td>${loja.logradouro}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Número</th>
                                                        <td>${loja.numero}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Bairro</th>
                                                        <td>${loja.bairro}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cidade</th>
                                                        <td>${loja.cidade}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Estado</th>
                                                        <td>${loja.estado}</td>
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