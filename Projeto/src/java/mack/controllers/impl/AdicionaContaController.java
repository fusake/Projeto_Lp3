/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.controllers.impl;

/**
 *
 * @author Vini Sakihara
 */
import mack.controllers.AbstractController;
import banco.dao.api.ContaDaoInterface;
import banco.dao.impl.relacional.ContaDaoRelacional;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dominio.Conta;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
import java.util.logging.Level;

public class AdicionaContaController extends AbstractController {

    @Override
    public void execute() {
        try{
            int numero_conta = Integer.parseInt(this.getRequest().getParameter("numero_conta"));
            BigDecimal saldo = new BigDecimal(this.getRequest().getParameter("saldo"));
            ConexaoInterface conexao;
            conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
            ContaDaoInterface dao;
            dao = new ContaDaoRelacional(conexao);
            Conta c = new Conta(numero_conta, saldo);
            dao.adicionar(c);
            this.setReturnPage("/adicionaConta.jsp");
            this.getRequest().setAttribute("conta_adicionada", c);
        }catch(Exception e){
            
        }
    }

}
