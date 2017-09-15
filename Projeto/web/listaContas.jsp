<%-- 
    Document   : index
    Created on : 05/09/2017, 20:48:28
    Author     : 31206018
--%>

<%@page import="banco.dominio.Conta" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contas: </h1>
        <%
            List<Conta> contas =
            (List<Conta>)request.getAttribute("lista_contas");
        %>
        <% if (contas.size()>0){ %>
        <table>
            <% for (Conta c : contas) {%>
            <tr>
                <td><%=c.getNumero() %></td>
                <td><%=c.getSaldo() %></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <a href="index.html">Voltar</a>
    </body>
</html>
