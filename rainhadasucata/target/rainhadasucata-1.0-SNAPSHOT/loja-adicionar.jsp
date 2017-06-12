
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Loja</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/comum.css" rel="stylesheet" type="text/css"/>
        <link href="dist/css/tela-cadastro.css" rel="stylesheet" type="text/css"/>

        <style>

        </style>

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
                                    <i class="fa fa-home left" aria-hidden="true"></i>
                                    <header>Nova Loja</header>
                                </div>

                                <div class="corpo-card">
                                    <form method="get" action="LojaController" id="form">

                                        <input type="hidden" name="acao" value="LojaAdicionar" />
                                        <!-- Razão Social -->
                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-home fa-2x left" aria-hidden="true"></i>
                                                    <label>Razão Social</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="nome" type="text" class="validate obrigatorio" name="nome" data-length="80" maxlength="80">
                                                    <label for="nome">* Nome Fantasia</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cnpj" type="text" class="validate obrigatorio" name="cnpj">
                                                    <label for="cnpj">* CNPJ</label>
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
                                                    <label for="telefone">* Telefone Principal</label>
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

                                            <!-- Preloader -->
                                            <div id="loaderImage"></div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cep" type="text" class="validate obrigatorio" name="cep">
                                                    <label for="cep">* CEP</label>
                                                </div>                          
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s9 offset-s1">
                                                    <input id="logradouro" type="text" class="validate obrigatorio" name="logradouro" data-length="70" maxlength="70" value="${param.logradouro}">
                                                    <label for="logradouro">* Logradouro</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="numero" type="text" class="validate" name="numero" data-length="20" maxlength="20">
                                                    <label for="numero">Número</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="bairro" type="text" class="validate obrigatorio" name="bairro" data-length="50" maxlength="50" value="${param.bairro}">
                                                    <label for="bairro">* Bairro</label>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="input-field col s4 offset-s1">
                                                    <input id="cidade" type="text" class="validate obrigatorio" name="cidade" data-length="50" maxlength="50" value="${param.cidade}">
                                                    <label for="cidade">* Cidade</label>
                                                </div>
                                                <div class="input-field col s4 offset-s1 select-estado">
                                                    <select name="estado" id="estado">
                                                        <option value="">Selecione</option>
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
                                        </div>
                                                                                <!-- botoes -->
                                        <div class="row">
                                            <div id="finalizaLoja" class="btn-finalizar-cadastro right">

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
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Voltar ao cadastro</a>
                <a href="LojaController?&acao=LojaListar&busca=" class="modal-action modal-close waves-effect waves-green btn-flat" id="sair">Sair</a> 
            </div>
        </div>

        <!-- Javascript da lib -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
        <script src="dist/js/mascaras.js" type="text/javascript"></script>

        <!-- Javascript da página -->
        <script src="dist/js/SetMascara.js" type="text/javascript"></script>
        <script src="dist/js/EventosComum.js" type="text/javascript"></script>
        <script src="dist/js/Loja.js" type="text/javascript"></script>
        <script src="dist/js/Endereco.js" type="text/javascript"></script>
        <script src="dist/js/Contato.js" type="text/javascript"></script>
        
    </body>
</html>
