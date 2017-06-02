
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>

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
                            <a href="ClienteController?id=${cliente.id}&acao=ClienteObter&pagina=cliente-editar">
                                <button class="btn btn-editar-cliente waves-effect waves-light right" type="button">Editar
                                    <i class="fa fa-pencil"></i> 
                                </button>
                            </a>
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
                                                        <td>${cliente.id}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Nome</th>
                                                        <td>${cliente.nome}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cpf</th>
                                                        <td>${cliente.cpf}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Data de nascimento</th>
                                                        <td>${cliente.dataNascimento}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Sexo</th>
                                                        <td>${cliente.sexo}</td>
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
                                                        <td>${cliente.telefone}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Celular</th>
                                                        <td>${cliente.celular}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>E-mail</th>
                                                        <td>${cliente.email}</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="collapsible-header active"><i class="material-icons">location_on</i><span>Dados de Endereço</span></div>
                                            <div class="collapsible-body">
                                                <table class="tabela-cliente-ver-endereco vertical striped">
                                                    <tr>
                                                        <th>Logradouro</th>
                                                        <td>${cliente.logradouro}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Número</th>
                                                        <td>${cliente.numero}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Bairro</th>
                                                        <td>${cliente.bairro}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Cidade</th>
                                                        <td>${cliente.cidade}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Estado</th>
                                                        <td>${cliente.estado}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Complemento</th>
                                                        <td>${cliente.complemento}</td>
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