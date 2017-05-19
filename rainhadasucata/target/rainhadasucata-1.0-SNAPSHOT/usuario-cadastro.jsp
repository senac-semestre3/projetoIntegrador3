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
                                    <form method="post" action="usuario-cadastrar">

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
                                                    <input id="nome" type="text" class="validate" name="nome" required="required">
                                                    <label for="nome">* Nome</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cpf" type="text" class="validate" name="cpf" required="required">
                                                    <label for="cpf">* CPF</label>
                                                </div>
                                                <div class="box-data col s4 offset-s1">
                                                    <label for="data-nascimento" class="active">* Data de Nascimento</label>
                                                    <input type="date" class="datepicker data-nascimento" name="data-nascimento" required="required">
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
                                                    <input id="telefone" type="text" class="validate" name="telefone" required="required">
                                                    <label for="telefone">* Telefone</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="celular" type="text" class="validate" name="celular">
                                                    <label for="celular">Celular</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="email" type="email" class="validate" name="email" required="required">
                                                    <label for="email">* E-mail</label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- dados de endereço -->
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-map-marker fa-2x left" aria-hidden="true"></i>
                                                    <label>Endereço</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cep" type="text" class="validate" name="cep" required="required">
                                                    <label for="cep">* CEP</label>
                                                </div>                          
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="logradouro" type="text" class="validate" name="logradouro" required="required">
                                                    <label for="logradouro">* Logradouro</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="numero" type="text" class="validate" name="numero">
                                                    <label for="numero">Número</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="bairro" type="text" class="validate" name="bairro" required="required">
                                                    <label for="bairro">* Bairro</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cidade" type="text" class="validate" name="cidade" required="required">
                                                    <label for="cidade">* Cidade</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <select name="estado" required="required">
                                                        <option value="" disabled selected> </option>
                                                        <option value="">São Paulo</option>
                                                        <option value="">Rio de Janeiro</option>
                                                        <option value="">Salvador</option>
                                                    </select>
                                                    <label>* Estado</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="complemento" type="text" class="validate" name="complemento">
                                                    <label for="complemento">Complemento</label>
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
                                                    <input id="usuario" type="text" class="validate" name="usuario-nome" required="required">
                                                    <label for="usuario">* Usuário</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="senha" type="password" class="validate" name="usuario-senha" required="required">
                                                    <label for="senha">* Senha</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <select name="permissao" required="required">
                                                        <option value="" disabled selected> </option>
                                                        <option value="1">Matriz</option>
                                                        <option value="2">Produto</option>
                                                        <option value="3">Administrador</option>
                                                    </select>
                                                    <label>* Nivel de Permissão</label>
                                                </div>

                                                <div class="input-field col s4 offset-s1">
                                                    <select name="lojas" required="required">
                                                        <option value="" disabled selected> </option>
                                                        <option value="1">Matriz</option>
                                                        <option value="2">Produto</option>
                                                        <option value="3">Administrador</option>
                                                    </select>
                                                    <label>* Loja</label>
                                                </div>

                                            </div>
                                            <div class="row">
                                                <div class="col offset-s1">
                                                    <input type="checkbox"  id="status" name="status"/>
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
        <script src="dist/js/mascaras.js" type="text/javascript"></script>

        <!-- Javascript da página -->
        <script src="dist/js/DataMaterialize.js" type="text/javascript"></script>
        <script src="dist/js/SetMascara.js" type="text/javascript"></script>
    </body>
</html>
