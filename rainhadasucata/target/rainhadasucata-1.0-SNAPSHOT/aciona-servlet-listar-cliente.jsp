<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
  IMPORTAÇÃO DA BIBLIOTECA PARA USAR AS TAGS DA JSTL,
  PARA PERMITIR DESENVOLVER LÓGICA NA GERAÇÃO DO
  HTML DE SAÍDA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Agenda de contatos</title>
        <link rel="stylesheet" href="estilos.css" />
    </head>
    <body >



        <form  id="listar-clientes" action="servlet-listar-clientes" method="post">
            <input type="hidden" name="0" value="0" style="display:hidden" />
        </form>  
        
        
        
        <script type="text/javascript">
            function submitForm()
            {
                document.forms['listar-clientes'].submit()
            }
            window.onload = submitForm;
        </script>
    </body>
</html>