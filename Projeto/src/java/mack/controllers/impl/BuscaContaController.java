/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.controllers.impl;

/**
 *
 * @author 31206018
 */
import mack.controllers.AbstractController;
import banco.dao.api.ContaDaoInterface;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.ContaDaoRelacional;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dominio.Conta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class BuscaContaController extends AbstractController {

    @Override
    public void execute() {
        try {
            int nroConta = Integer.parseInt(this.getRequest().getParameter("numero_conta"));
            ConexaoInterface conexao;
            conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
            ContaDaoInterface dao;
            dao = new ContaDaoRelacional(conexao);
            Conta c = dao.buscarPeloNumero(nroConta);
            this.setReturnPage("/listaContaBuscada.jsp");
            this.getRequest().setAttribute("conta_buscada", c);
        } catch (Exception e) {
            Logger.getLogger(ListaContasController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

}
