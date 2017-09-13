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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import banco.dominio.Conta;
import java.math.BigDecimal;

public class ListaContasController extends AbstractController {

    @Override
    public void execute() {
        try {
            List contas = new ArrayList<Conta>();
            contas.add(new Conta(123, BigDecimal.valueOf(1000)));
            contas.add(new Conta(124, BigDecimal.valueOf(500)));
            this.setReturnPage("/listaContas.jsp");
            this.getRequest().setAttribute("lista_contas", contas);

        } catch (Exception e) {
            Logger.getLogger(ListaContasController.class.getName()).log(Level.SEVERE, null, e);

        }
    }

}
