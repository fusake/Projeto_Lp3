<%-- 
    Document   : listaTitulares
    Created on : 16/09/2017, 23:05:40
    Author     : Vini Sakihara
--%>
<%@page import="banco.dominio.Titular" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Titulares</title>
    </head>
    <body>
        <h1>Lista de Titulares!:</h1>
        <%List<Titular> titulares = (List<Titular>) request.getAttribute("lista_titulares");
        %>
        <% if (titulares.size() > 0) {%>
        <table>
            <%for (Titular t : titulares) {%>
            <tr>
                <td>Numero:<%=t.getNumero()%></td>
                <td>Nome:<%=t.getNome()%></td>
                <td>RG:<%=t.getRg()%></td>
                <td>CPF:<%=t.getCpf()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <a href="index.html">Voltar</a>
    </body>
</html>
