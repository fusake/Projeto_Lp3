<%-- 
    Document   : listaContaBuscada
    Created on : 14/09/2017, 21:11:16
    Author     : 31206018
--%>

<%@page import="banco.dominio.Conta" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Lista Conta Buscada</title>
    </head>
    <body>
        <h1>Conta Localizada:</h1>
        <%
            Conta c =(Conta)request.getAttribute("conta_buscada");
        %>
        <table>
            <tr>
                <td>Numero da Conta:<%=c.getNumero()%></td>
                <td>Saldo:<%=c.getSaldo()%></td>
            </tr>
        </table>
            <a href="index.html">Voltar</a>
    </body>
</html>
