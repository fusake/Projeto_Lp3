/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoweb.controllers.impl;

/**
 *
 * @author 31206018
 */
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bancoweb.controllers.AbstractController;
import banco.dominio.Conta;
import java.math.BigDecimal;

public class IndexController extends AbstractController {
    
    @Override
    public void Execute() {
        try {
            List contas = new ArrayList<Conta>();
            contas.add(new Conta(126, BigDecimal.ZERO.valueOf(1000)));
            contas.add(new Conta(127, BigDecimal.ZERO.valueOf(500)));
            this.setReturnPage("/index.jsp");
            this.getRequest().setAttribute("lista_contas", contas);
        } catch (Exception e) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
