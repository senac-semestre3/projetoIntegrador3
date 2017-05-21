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
      
    </head>
    <body >
 <c:remove scope="session" var="sessionusuario" />
 <%
    String redirectURL = "login.jsp";
    response.sendRedirect(redirectURL);
%>


    </body>
</html>