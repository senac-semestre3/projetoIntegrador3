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
                            <button class="btn btn-editar-cliente waves-effect waves-light right" type="button" name="action">Editar
                                <i class="material-icons">mode_edit</i> 
                            </button>
                        </div>


                        <div class="row"><!-- INICIO DA LINHA -->
                            <div class="card"><!-- INICIO DO CARD -->


                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left"></i>
                                    <header>Informações do Cliente</header>
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
                                                        <th>Cpf/Cnpj</th>
                                                        <td>411.439.358-70</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Sexo</th>
                                                        <td>Masculino</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header"><i class="material-icons">email</i><span>Dados de Contato</span></div>
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
                                            <div class="collapsible-header"><i class="material-icons">location_on</i><span>Dados de Endereço</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-endereco vertical striped">
                                                    <tr>
                                                        <th>Logradouro</th>
                                                        <td>Rua Hélio Jacy Gouveia</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Número</th>
                                                        <td>42</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Bairro</th>
                                                        <td>Jardim São Francisco</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cidade</th>
                                                        <td>São Paulo</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Estado</th>
                                                        <td>SP</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Complemento</th>
                                                        <td>Casa 4</td>
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
</body>
</html>