package conexao;

import elementos.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    public List<Pessoa> obterListaDePessoas() throws SQLException {
        try {
       
            Conexao con = new Conexao();
            con.getConexao(); 

            String sql = "select * from tb_pessoa;";

           
            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

           
            List<Pessoa> listaDePessoa;
            listaDePessoa = new ArrayList<>();

   
            while (resultado.next()) {
                Pessoa per = new Pessoa(); 

                per.setId(resultado.getInt("idPessoa")); 
                per.setNome(resultado.getString("nome")); 

       
                listaDePessoa.add(per);
            }

            resultado.close();
            comando.close();
            con.getConexao().close();

            return listaDePessoa;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void inserePessoa(Pessoa per) {
        
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO tb_pessoa"
                    + "(nome) VALUES (?)";

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, per.getNome());


            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    per.setId(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
    }

}
