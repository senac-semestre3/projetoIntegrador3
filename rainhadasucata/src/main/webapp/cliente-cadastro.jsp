<%-- 
    Document   : cliente-cadastro
    Created on : 21/04/2017, 23:48:43
    Author     : augusto.palencar1
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
        <link href="dist/css/cliente-cadastro.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <%@include file="comum.jsp" %>
        <div class="row">
            <div  class="col s10 offset-s2">
                <div id="container-main">

                    <div class="main">


                        <div class="row">
                            <div class="btn-finalizar-cadastro right">
                                <button class="btn btn-cancelar waves-effect waves-light" type="button" name="action">Cancelar
                                    <i class="fa fa-ban" aria-hidden="true"></i>
                                </button>

                                <button class="btn btn-adicionar waves-effect waves-light" type="button" name="action">Adicionar
                                    <i class="fa fa-check" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>

                        <div class="row">

                            <div class="card">
                                <div class="cabecalho cabecalho-informacoes">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Cadastro de Clientes</header>                                    
                                </div>  
                            </div>

                            <div class="row">                            
                                <div class="dados cliente">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Dados Pessoais</header>  

                                    <div id="nome" class="input-field col s4 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Nome...</label>
                                    </div>

                                    <div id="sobrenome" class="input-field col s4 offset-s0">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Sobrenome...</label>
                                    </div>

                                    <div id="cpf" class="cpf cnpj input-field col s8 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">CPF/CNPJ...</label>
                                    </div>

                                    <div id="nome" class="input-field col s4 offset-s1"> 

                                        <input name="sexo" type="radio" id="masculino" value="Masculino" />
                                        <label for="masculino">Masculino</label>
                                        <input name="sexo" type="radio" id="feminino" value="Feminino" />
                                        <label for="feminino">Feminino</label>
                                    </div>
                                </div>  
                            </div>
                            <div class="row">                            
                                <div class="dados cliente contato offset-s1">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Contato</header>  

                                    <div id="telefone" class="input-field col s4 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Telefone...</label>
                                    </div>

                                    <div id="celular" class="input-field col s4 offset-s0">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Celular...</label>
                                    </div>

                                    <div id="email" class="input-field col s8 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Email...</label>
                                    </div>                                
                                </div>
                            </div>
                            <div class="row">                            
                                <div class="dados cliente endereco">
                                    <i class="fa fa-user-o left" aria-hidden="true"></i>
                                    <header>Endereço</header>  

                                    <div id="cep" class="input-field col s4 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">CEP...</label>
                                    </div>

                                    <div id="logradouro" class="input-field col s4 offset-s0">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Logradouro...</label>
                                    </div>

                                    <div id="numero" class="input-field col s4 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Número...</label>
                                    </div>

                                    <div id="bairro" class="input-field col s4 offset-s0">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Bairro...</label>
                                    </div>

                                    <div id="cidade" class="input-field col s4 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Cidade...</label>
                                    </div>

                                    <select class="browser-default input-field col s4 offset-s0" >
                                        <option value="" disabled selected >Estado</option>
                                        <option value="1">Option 1</option>
                                        <option value="2">Option 2</option>
                                        <option value="3">Option 3</option>
                                    </select>

                                    <div id="complemento" class="input-field col s8 offset-s1">                                    
                                        <input id="icon_prefix" type="text" class="validate">
                                        <label for="icon_prefix">Complemento...</label>
                                    </div>

                                </div>
                            </div>
                        </div> 
                    </div> 
                </div> 
            </div> 
        </div> 


    </div>
</body>
</html>

