<%-- 
    Document   : adicionaConta
    Created on : 16/09/2017, 22:25:16
    Author     : Vini Sakihara
--%>
<%@page import="banco.dominio.Conta" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conta Adicionada</title>
    </head>
    <body>
        <h1>Conta Adicionada!</h1>
        <% Conta c = (Conta)request.getAttribute("conta_adicionada");
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
