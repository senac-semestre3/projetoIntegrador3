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
                            <div id="erro" style="display: none">
                                <h5></h5>
                            </div>
                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Cadastro de usuário</header>
                                </div>

                                <div class="corpo-card">
                                    <form method="get" action="UsuarioController" id="form">
                                        
                                        <input type="hidden" name="acao" value="UsuarioAdicionar"/>
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
                                                    <input id="nome" type="text" class="validate obrigatorio" name="nome" data-length="80" maxlength="80">
                                                    <label for="nome">* Nome</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cpf" type="text" class="validate obrigatorio" name="cpf">
                                                    <label for="cpf">* CPF</label>
                                                </div>
                                                <div class="box-data col s4 offset-s1">
                                                    <label for="data-nascimento" class="active">* Data de Nascimento</label>
                                                    <input type="date" class="datepicker data-nascimento obrigatorio" name="data-nascimento">
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col offset-s1">
                                                    <input class="with-gap" name="sexo" type="radio" id="masculino" value="M" checked="checked"/>
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
                                                    <input id="telefone" type="text" class="validate obrigatorio" name="telefone">
                                                    <label for="telefone">* Telefone</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="celular" type="text" class="validate" name="celular">
                                                    <label for="celular">Celular</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="email" type="email" class="validate obrigatorio" name="email" data-length="80" maxlength="80">
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
                                                    <input id="cep" type="text" class="validate obrigatorio" name="cep">
                                                    <label for="cep">* CEP</label>
                                                </div>                          
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="logradouro" type="text" class="validate obrigatorio" name="logradouro" data-length="70" maxlength="70">
                                                    <label for="logradouro">* Logradouro</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="numero" type="text" class="validate" name="numero" data-length="20" maxlength="20">
                                                    <label for="numero">Número</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="bairro" type="text" class="validate obrigatorio" name="bairro" data-length="50" maxlength="50">
                                                    <label for="bairro">* Bairro</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cidade" type="text" class="validate obrigatorio" name="cidade" data-length="50" maxlength="50">
                                                    <label for="cidade">* Cidade</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <select name="estado">
                                                        <option value=""></option>
                                                        <option value="AC">AC</option>
                                                        <option value="AL">AL</option>
                                                        <option value="AM">AM</option>
                                                        <option value="AP">AP</option>
                                                        <option value="BA">BA</option>
                                                        <option value="CE">CE</option>
                                                        <option value="DF">DF</option>
                                                        <option value="ES">ES</option>
                                                        <option value="GO">GO</option>
                                                        <option value="MA">MA</option>
                                                        <option value="MG">MG</option>
                                                        <option value="MS">MS</option>
                                                        <option value="MT">MT</option>
                                                        <option value="PA">PA</option>
                                                        <option value="PB">PB</option>
                                                        <option value="PE">PE</option>
                                                        <option value="PI">PI</option>
                                                        <option value="PR">PR</option>
                                                        <option value="RJ">RJ</option>
                                                        <option value="RN">RN</option>
                                                        <option value="RS">RS</option>
                                                        <option value="RO">RO</option>
                                                        <option value="RR">RR</option>
                                                        <option value="SC">SC</option>
                                                        <option value="SE">SE</option>
                                                        <option value="SP">SP</option>
                                                        <option value="TO">TO</option>
                                                    </select>
                                                    <label>* Estado</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <textarea id="complemento" type="text" class="materialize-textarea" name="complemento" data-length="200" maxlength="200"></textarea>
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
                                                    <input id="usuario" type="text" class="validate obrigatorio" name="usuario-nome" maxlength="80" maxlength="50" value="${sessionScope.usuarioAdicionar.nomeUsuario}">
                                                    <label for="usuario">* Usuário</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="senha" type="password" class="validate obrigatorio" name="usuario-senha" maxlength="20">
                                                    <label for="senha">* Senha</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <select name="permissao">
                                                        <option value="" disabled selected> </option>
                                                        <option value="1">Matriz</option>
                                                        <option value="2">Produto</option>
                                                        <option value="3">Administrador</option>
                                                    </select>
                                                    <label>* Nivel de Permissão</label>
                                                </div>

                                                <div class="input-field col s4 offset-s1">
                                                    <select name="loja">
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
                                            <div id="finalizaUsuario" class="btn-finalizar-cadastro right">

                                                <button id="btnCancelar" class="btn btn-cancelar waves-effect waves-light" type="button" data-target="modalCancelar">
                                                    Cancelar
                                                    <i class="fa fa-ban" aria-hidden="true"></i>
                                                </button>

                                                <button id="btnSalvar" class="btn btn-adicionar waves-effect waves-light" type="button">Salvar
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


        <!-- Modal Structure -->
        <div id="modalCancelar" class="modal">
            <div class="modal-content">
                <h4>Deseja realmente sair?</h4>
            </div>
            <div class="modal-footer">
                <a href="usuarios.jsp" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Sair</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
            </div>
        </div>

        <!-- Javascript da lib -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
        <script src="dist/js/mascaras.js" type="text/javascript"></script>

        <!-- Javascript da página -->
        <script src="dist/js/DataMaterialize.js" type="text/javascript"></script>
        <script src="dist/js/SetMascara.js" type="text/javascript"></script>
        <script src="dist/js/ValidadorComum.js" type="text/javascript"></script>
        <script src="dist/js/BuscaCep.js" type="text/javascript"></script>
    </body>
</html>