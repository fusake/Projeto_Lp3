/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoweb;

import banco.dao.api.ContaDaoInterface;
import banco.dao.impl.relacional.BancoDaoException;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.ContaDaoRelacional;
import banco.dao.impl.relacional.javadb.ConexaoException;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dominio.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author 31206018
 */

public class ListarContasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConexaoInterface conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        boolean conexaoEstabelicida = false;
        ContaDaoInterface dao = null;
        try {
            dao = new ContaDaoRelacional(conexao);
            conexaoEstabelicida = true;
        } catch (ConexaoException e) {
            conexaoEstabelicida = false;
        } catch (BancoDaoException ex) {
            conexaoEstabelicida = false;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Contas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Todas as Contas</h1>");
            if (conexaoEstabelicida) {
                List<Conta> contas;
                try {
                    contas = dao.listarTudo();
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>Número</th><th>Saldo</th>");
                    out.println("</tr>");
                    for (Conta c : contas) {
                        out.println("<tr>");
                        out.println("<td>" + c.getNumero() + "</td>");
                        out.println("<td>" + c.getSaldo() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } catch (BancoDaoException ex) {
                    out.println("<p>Erro na Operação!</p>");
                }
            } else {
                out.println("<p>Infelizmente o sistema está fora do ar!</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
