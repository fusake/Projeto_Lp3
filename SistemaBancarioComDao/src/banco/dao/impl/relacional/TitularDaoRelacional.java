/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao.impl.relacional;

/**
 *
 * @author 31206018
 */
import banco.dao.api.TitularDaoInterface;
import banco.dominio.Conta;
import banco.dominio.Titular;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TitularDaoRelacional implements TitularDaoInterface {

    private ConexaoInterface conexao;

    public TitularDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Titular> listarTudo() {
        List<Titular> titulares;
        titulares = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT nro_titular, nome, rg, cpf FROM titulares";
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                long n = resultados.getLong("nro_titular");
                String nome = resultados.getString("nome");
                String rg = resultados.getString("rg");
                String cpf = resultados.getString("cpf");
                Titular t = new Titular(n, nome, rg, cpf);
                titulares.add(t);

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return titulares;

    }

}
