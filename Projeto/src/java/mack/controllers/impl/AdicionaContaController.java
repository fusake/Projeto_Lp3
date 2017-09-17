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
        }catch(Exception e){
            
        }
    }

}
