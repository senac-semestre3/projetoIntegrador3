<%-- 
    Document   : cliente
    Created on : 13/04/2017, 20:13:47
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rainha da Sucata</title>

        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- CSS Materialize e Font-Awersome -->
        <link href="dist/css/plugins.css" rel="stylesheet" type="text/css"/>

        <!-- CSS da pagina -->
        <link href="dist/css/login.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>
        <div class="container-main">
            <img src="dist/imagens/fundo-login-mascara.jpg" alt="" class="fundo"/>
            <div class="box-inputs">
                 <div class="logo">
                     <img src="dist/imagens/logo.png" alt=""/>
                 </div>
                 <form>
                     <div class="row">
                         <div class="input-field">
                             <i class="small material-icons prefix" aria-hidden="true">perm_identity</i>
                             <input id="email" type="email" class="validate">
                             <label for="email">Usuário</label>
                         </div>
                     </div>
                     <div class="row">
                         <div class="input-field">
                             <i class="small material-icons prefix" aria-hidden="true">lock_outline</i>
                             <input id="password" type="password" class="validate">
                             <label for="password">Senha</label>
                         </div>
                     </div>
                     <button class="waves-effect waves-light btn-large">Login</button>
                 </form>
                 <div class="row">
                     <p><a href="#">Esqueci minha senha</a></p>
                 </div>
             </div>
        </div>
    </div>
</div>

<!-- javascript das libs -->
<script src="dist/js/lib.min.js" type="text/javascript"></script>

</body>
</html>
