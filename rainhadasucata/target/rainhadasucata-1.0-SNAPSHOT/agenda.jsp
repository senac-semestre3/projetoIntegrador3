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
<!--
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Data nascimento</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${listaContatos}" var="contato">
                <tr>
                    <td><c:out value="${contato.id}" /></td>
                    <td><c:out value="${contato.nome}" /></td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="entrada">Incluir novo contato</a></p>-->

        <form  id="form" action="agenda" method="get">
            <input type="hidden" name="something" value="something" style="display:hidden" />
        </form>  
        <script type="text/javascript">
            function submitForm()
            {
                document.forms['form'].submit()
            }
            window.onload = submitForm;
        </script>
    </body>
</html>