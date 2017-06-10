<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Rainha da Sucata</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="dist/css/plugins.css"/>

        <!-- CSS -->
        <link type="text/css" rel="stylesheet" href="dist/css/comum.css">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>

        <!-- Topo -->
        <div class="row">
            <div class="col s12">
                <nav class="topo">
                    <div class="nav-wrapper">
                        <div class="logo col s8">
                            <a href="#!"></a>
                        </div>
                        <div class="right">
                            <a href="servletSair">
                                <button class="btn btn-sair waves-effect waves-light"><i class="fa fa-power-off" aria-hidden="true"></i></button>
                            </a>
                        </div>

                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="container-menu-lateral col s2 m3 l2 ">

                <!-- Container Perfil -->
                <div class="container-perfil">
                    <img src="dist/imagens/avatar.png" alt="" class="circle img-avatar">
                    <p><span>Olá  ${sessionScope.sessionusuario.nome}</span></p>
                </div>
                <div class="divider"></div>

                <!-- Menu -->
                <ul class="collapsible">
                    <li class="btn-menu"><a href="#" class="collapsible-header waves-effect waves-light"><i class="fa fa-tachometer" aria-hidden="true"></i>Dashboard</a></li>
                    <li class="btn-menu"><a href="ClienteController?&acao=ClienteListar&busca=" class="collapsible-header waves-effect waves-light"><i class="fa fa-user-o" aria-hidden="true"></i>Clientes</a></li>
                    <li class="btn-menu"><a href="ProdutoController?&acao=ProdutoListar" class="collapsible-header waves-effect waves-light"><i class="fa fa-barcode" aria-hidden="true"></i>Produtos</a></li>
                    <li class="btn-menu"><a href="vendas.jsp" class="collapsible-header waves-effect waves-light"><i class="fa fa-usd" aria-hidden="true"></i>Vendas</a></li>
                    <li class="btn-menu"><a href="relatorios.jsp" class="collapsible-header waves-effect waves-light"><i class="fa fa-line-chart" aria-hidden="true"></i>Relatórios</a></li>
                    <ul class="collapsible">
                        <li class="btn-menu"><a class="collapsible-header waves-effect waves-light"><i class="fa fa-cogs" aria-hidden="true"></i> Configurações</a>
                            <div class="collapsible-body" style="display: none;">
                                <ul>
                                    <li><a href="UsuarioController?&acao=UsuarioListar&busca=" class="collapsible-header waves-effect waves-light">Usuário</a>
                                    </li>
                                    <li><a href="permissoes.jsp" class="collapsible-header waves-effect waves-light">Permissão</a>
                                    </li>
                                    <li><a href="LojaController?&acao=LojaListar&busca=" class="collapsible-header waves-effect waves-light">Loja</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </ul>
            </div>
        </div>
    </body>
</html>