<%-- 
    Document   : resposta
    Created on : 31/03/2017, 22:13:22
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
   
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      <h2>Produto cadastrado</h2>
      <h2>Produto <c:out value="${sessionScope.novoContato}" /></h2>
      <a href="${sessionScope.url}"> Voltar</a>
      
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoContato" />
</html>
