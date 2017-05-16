<%-- 
    Document   : usuario-ver
    Created on : 24/04/2017, 22:59:04
    Author     : everton
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário</title>

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
                            <button class="btn btn-editar-cliente waves-effect waves-light right" type="button" name="action">Editar
                                <i class="fa fa-pencil"></i> 
                            </button>
                        </div>


                        <div class="row"><!-- INICIO DA LINHA -->
                            <div class="card"><!-- INICIO DO CARD -->


                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left"></i>
                                    <header>Informações do Usuário</header>
                                </div>

                                <div class="corpo-card"><!-- INICIO DO CORPO DO CARD -->
                                    <ul class="collapsible popout" data-collapsible="accordion">
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">person_pin</i><span>Dados Pessoais</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-dados-pessoais vertical striped">
                                                    <tr>
                                                        <th>Id</th>
                                                        <td>52</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <td>Everton Roberto de Oliveira</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cpf</th>
                                                        <td>411.439.358-70</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Data de Nascimento</th>
                                                        <td>02/04/1993</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Sexo</th>
                                                        <td>Masculino</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">call</i><span>Dados de Contato</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-contato vertical striped">
                                                    <tr>
                                                        <th>Telefone</th>
                                                        <td>(11) 5515-2677</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Celular</th>
                                                        <td>(11) 95166-9431</td>
                                                    </tr>
                                                    <tr>
                                                        <th>E-mail</th>
                                                        <td>everton_roliveira@outlook.com</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header active"><i class="material-icons">lock</i><span>Dados de Acesso</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-endereco vertical striped">
                                                    <tr>
                                                        <th>Usuário</th>
                                                        <td>everton.roliveira2</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Senha</th>
                                                        <td>*****************</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Permissão</th>
                                                        <td>Administrador</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Status</th>
                                                        <td>Ativo</td>
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
