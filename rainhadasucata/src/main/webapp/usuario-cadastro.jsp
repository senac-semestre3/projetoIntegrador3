<%-- 
    Document   : usuario-cadastro
    Created on : 24/04/2017, 19:44:57
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuário</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/tela-cadastro.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <!-- Programar aqui!! -->

                    <div class="main">
                        <div class="row">
                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Cadastro de usuário</header>
                                </div>

                                <div class="corpo-card">
                                    <form method="post" action="subm">
                                        
                                        <!-- dados pessoais -->
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-user-circle fa-2x left" aria-hidden="true"></i>
                                                    <label>Dados Pessoais</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="nome" type="text" class="validate" name="nome">
                                                    <label for="nome">Nome</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="sobrenome" type="text" class="validate" name="sobrenome">
                                                    <label for="sobrenome">Sobrenome</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cpf" type="text" class="validate" name="cpf">
                                                    <label for="cpf">CPF</label>
                                                </div>
                                                <div class="box-data col s4 offset-s1">
                                                    <label for="data-nascimento" class="active">Data de Nascimento</label>
                                                    <input type="date" class="datepicker data-nascimento" name="data-nascimento">
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col offset-s1">
                                                    <input class="with-gap" name="sexo" type="radio" id="masculino" value="M"/>
                                                    <label for="masculino">Masculino</label>

                                                    <input class="with-gap" name="sexo" type="radio" id="feminino" value="F"/>
                                                    <label for="feminino">Feminino</label>
                                                </div>
                                            </div>
                                        </div>


                                        <!-- contato -->
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-phone-square fa-2x left" aria-hidden="true"></i>
                                                    <label>Contato</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="telefone" type="text" class="validate" name="telefone">
                                                    <label for="telefone">Telefone</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="celular" type="text" class="validate" name="celular">
                                                    <label for="celular">Celular</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="email" type="email" class="validate" name="email">
                                                    <label for="email">E-mail</label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- dados de acesso -->
                                        <div class="row">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-lock fa-2x left" aria-hidden="true"></i>
                                                    <label>Dados de Acesso</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="usuario" type="text" class="validate" name="usuario">
                                                    <label for="usuario">Usuário</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="senha" type="password" class="validate" name="senha">
                                                    <label for="senha">Senha</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <select name="permissao">
                                                        <option value="" disabled selected> </option>
                                                        <option value="">Matriz</option>
                                                        <option value="">Produto</option>
                                                        <option value="">Administrador</option>
                                                    </select>
                                                    <label>Nivel de Permissão</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col offset-s1">
                                                    <input type="checkbox" id="status" name="status"/>
                                                    <label for="status">Usuário Ativo</label>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        
                                        <!-- botoes -->
                                        <div class="row">
                                            <div class="btn-finalizar-cadastro right">
                                                <a href="usuarios.jsp">
                                                    <button class="btn btn-cancelar waves-effect waves-light" type="button" name="action">
                                                        Cancelar
                                                        <i class="fa fa-ban" aria-hidden="true"></i>
                                                    </button>
                                                </a>

                                                <button class="btn btn-adicionar waves-effect waves-light" type="submit" name="action">Salvar
                                                    <i class="fa fa-floppy-o" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>   
                </div> 
            </div>
        </div>

        <!-- Javascript da lib -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>

        <!-- Javascript da página -->
        <script src="dist/js/usuario.js" type="text/javascript"></script>
    </body>
</html>
