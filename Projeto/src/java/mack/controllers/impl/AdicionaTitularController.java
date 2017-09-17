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
import banco.dao.api.TitularDaoInterface;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.TitularDaoRelacional;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dominio.Titular;
import java.math.BigDecimal; 
public class AdicionaTitularController extends AbstractController{

    @Override
    public void execute() {
        try{
            ConexaoInterface conexao;
            conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
            TitularDaoInterface dao;
            dao = new TitularDaoRelacional(conexao);
            int numero = Integer.parseInt(this.getRequest().getParameter("numero"));
            String nome = this.getRequest().getParameter("nome");
            String rg = this.getRequest().getParameter("rg");
            String cpf = this.getRequest().getParameter("cpf");
            Titular t = new Titular(numero, nome, rg, cpf);
            dao.adicionar(t);
            this.setReturnPage("/adicionaTitular.jsp");
            this.getRequest().setAttribute("titular", t);
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
    
}
