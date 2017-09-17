<%-- 
    Document   : adicionaTitular
    Created on : 17/09/2017, 01:19:15
    Author     : Vini Sakihara
--%>
<%@page import="banco.dominio.Titular" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Titular</title>
    </head>
    <body>
        <% Titular t = (Titular)request.getAttribute("titular");
        %>
        <h1>Titular Adicionada!</h1>
        <p>Numero do Titular:<%=t.getNumero()%></p>        
        <p>Nome:<%=t.getNome()%></p>
        <p>RG:<%=t.getRg()%></p>
        <p>CPF:<%=t.getCpf()%></p>
        <a href="index.html">Voltar</a>
    </body>
</html>
