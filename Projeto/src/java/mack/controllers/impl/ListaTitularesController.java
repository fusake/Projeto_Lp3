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
import banco.dominio.Titular;
import banco.dao.api.TitularDaoInterface;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dao.impl.relacional.TitularDaoRelacional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
public class ListaTitularesController extends AbstractController{

    @Override
    public void execute() {
        try{
            ConexaoInterface conexao;
            conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
            TitularDaoInterface dao;
            dao = new TitularDaoRelacional(conexao);
            List<Titular> titulares = dao.listarTudo();
            this.setReturnPage("/listaTitulares.jsp");
            this.getRequest().setAttribute("lista_titulares", titulares);
        }catch(Exception e){
            e.printStackTrace();
            
        }    
    }
    
}
