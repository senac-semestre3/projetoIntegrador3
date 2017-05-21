<%-- 
    Document   : cliente
    Created on : 13/04/2017, 20:13:47
    Author     : everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                  <input type="hidden" id="${sessionScope.session-usuario-n-encontrado}" value="${sessionScope.session-usuario-n-encontrado}" >
                <form action="ServletLogin" method="post">
                     <div class="row">
                         <div class="input-field">
                             <i class="small material-icons prefix" aria-hidden="true">perm_identity</i>
                             <input id="email" type="text" class="validate" name="nome" >
                             <label for="email">Usuário</label>
                         </div>
                     </div>
                     <div class="row">
                         <div class="input-field">
                             <i class="small material-icons prefix" aria-hidden="true">lock_outline</i>
                             <input id="password" type="password" class="validate" name="senha">
                             <label for="password">Senha</label>
                         </div>
                     </div>
                    <button type="submit" class="waves-effect waves-light btn-large">Login</button>
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
      <script type="text/javascript">
            function submitForm()
            {

                var a = document.getElementById("session-usuario-n-encontrado").value;
                if (a == "0") {
                    alert("Usuario nao encpontrado");
                } else if (a == "1") {
                    alert("Erro");
                }
            }
            window.onload = submitForm;
        </script>
</body>
</html>
