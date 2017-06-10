<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de permissão</title>

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
                                    <i class="fa fa-lock left" aria-hidden="true"></i>
                                    <header>Cadastrar Permissão</header>
                                </div>

                                <div class="corpo-card">
                                    <form method="">

                                        <div class="row bloco-dados">
                                            <div class="row">
                                                <div class="input-field col s6 offset-s1">
                                                    <input id="nome-produto" type="text" class="validate" name="nome">
                                                    <label for="nome-produto">Nome da permissão</label>
                                                </div>
                                                <div class="col offset-s1">
                                                    <input type="checkbox" id="status" name="status"/>
                                                    <label for="status" class="status">Permissão Ativa</label>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- niveis de permissão -->
                                        <div class="row">
                                            <div class="row">
                                                <div class="topo-descricao left">
                                                    <i class="fa fa-lock fa-2x left" aria-hidden="true"></i>
                                                    <label>Niveis de permissão</label>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row bloco-dados">
                                            <table class="tabela-produtos horizontal striped">
                                                <thead>
                                                    <tr>
                                                        <th>Clientes</th>
                                                        <th>Produtos</th>
                                                        <th>Venda</th>
                                                        <th>Usuários</th>
                                                        <th>Permissões</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" id="inserir-cliente" name="inserir-cliente"/>
                                                            <label for="inserir-cliente">Inserir cliente</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="inserir-produto" name="inserir-produto"/>
                                                            <label for="inserir-produto">Inserir produto</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="inserir-venda" name="inserir-venda"/>
                                                            <label for="inserir-venda">Inserir venda</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="inserir-usuario" name="inserir-usuario"/>
                                                            <label for="inserir-usuario">Inserir usuário</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="inserir-permissao" name="inserir-permissao"/>
                                                            <label for="inserir-permissao">Inserir permissão</label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" id="alterar-status-cliente" name="alterar-status-cliente"/>
                                                            <label for="alterar-status-cliente">Alterar status cliente</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="alterar-status-produto" name="alterar-status-produto"/>
                                                            <label for="alterar-status-produto">Alterar status prosuto</label>
                                                        </td>
                                                        <td>

                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="alterar-status-usuario" name="alterar-status-usuario"/>
                                                            <label for="alterar-status-usuario">Alterar status usuário</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="alterar-status-permissao" name="alterar-permissao"/>
                                                            <label for="alterar-status-permissao">Alterar status permissão</label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" id="ver-cliente" name="ver-cliente"/>
                                                            <label for="ver-cliente">Ver cliente</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="ver-produto" name="ver-produto"/>
                                                            <label for="ver-produto">Ver produto</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="ver-vendas" name="ver-vendas"/>
                                                            <label for="ver-vendas">Ver vendas</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="ver-usuario" name="ver-usuario"/>
                                                            <label for="ver-usuario">Ver usuário</label>
                                                        </td>
                                                        <td>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" id="editar-cliente" name="editar-cliente"/>
                                                            <label for="editar-cliente">Editar cliente</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="editar-produto" name="editar-produto"/>
                                                            <label for="editar-produto">Editar produto</label>
                                                        </td>
                                                        <td>

                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="editar-usuario" name="editar-usuario"/>
                                                            <label for="editar-usuario">Editar usuário</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="editar-permissao" name="editar-permissao"/>
                                                            <label for="editar-permissao">Editar permissão</label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" id="deletar-cliente" name="deletar-cliente"/>
                                                            <label for="deletar-cliente">Deletar cliente</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="deletar-produto" name="deletar-produto"/>
                                                            <label for="deletar-produto">Deletar produto</label>
                                                        </td>
                                                        <td>

                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="deletar-usuario" name="deletar-usuario"/>
                                                            <label for="deletar-usuario">Deletar usuario</label>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" id="deletar-permissao" name="deletar-permissao"/>
                                                            <label for="deletar-permissao">Deletar permissão</label>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- botões -->
                                        <div class="row">
                                            <div class="btn-finalizar-cadastro right">
                                                <a href="permissoes.jsp">
                                                    <button class="btn btn-cancelar waves-effect waves-light" type="button">
                                                        Cancelar
                                                        <i class="fa fa-ban" aria-hidden="true"></i>
                                                    </button>
                                                </a>

                                                <button class="btn btn-adicionar waves-effect waves-light" type="submit">Salvar
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

        <!-- javascript das libs -->
        <script src="dist/js/lib.min.js" type="text/javascript"></script>
    </body>
</html>
