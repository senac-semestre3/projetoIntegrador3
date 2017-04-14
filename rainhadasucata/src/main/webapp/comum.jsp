<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Rainha da Sucata</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <!-- CSS -->
    <link type="text/css" rel="stylesheet" href="dist/css/comum.css">

    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="dist/css/plugins.css"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
      
    <div class="row">

      <div class="col s12">
          <nav class="topo">
            <div class="nav-wrapper">
              <div class="logo col s8">
                <a href="#!"></a>
              </div>
              <div class="right">
                <button class="btn btn-sair waves-effect waves-light"><i class="fa fa-power-off" aria-hidden="true"></i></button>
              </div>

            </div>
          </nav>
      </div>
    </div>
    <div class="row">
      <div class="container-menu-lateral col s2 m3 l2">
        <div class="container-perfil">
            <img src="dist/imagens/avatar.png" alt="" class="circle img-avatar">
          <p><span>Nome do Perfil</span></p>
        </div>
        <div class="divider"></div>
        
        <ul class="menu">
          <li class="btn-menu"><a href="#"><i class="fa fa-tachometer" aria-hidden="true"></i>Dashboard</a></li>
          <li class="btn-menu"><a href="#"><i class="fa fa-user-o" aria-hidden="true"></i>Clientes</a></li>
          <li class="btn-menu"><a href="#"><i class="fa fa-barcode" aria-hidden="true"></i>Produtos</a></li>
          <li class="btn-menu"><a href="#"><i class="fa fa-usd" aria-hidden="true"></i>Vendas</a></li>
          <li class="btn-menu"><a href="#"><i class="fa fa-line-chart" aria-hidden="true"></i>Relatórios</a></li>
          <li class="btn-menu"><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="fa fa-cogs" aria-hidden="true"></i>Configurações <i class="fa fa-chevron-right right" aria-hidden="true"></i></a></li>
        </ul>






      </div>
      <div class="col s10 m9 l10 push-s2 push-m3 push-l2">
        <div id="main">
          
        </div>
      </div>
    </div>









    <!--Import jQuery depois materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
  </body>
</html>