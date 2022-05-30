package conexao;

import elementos.Pessoa;
import negocio.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    // Método para retornar lista de carros, como todos os carros
    public List<Pessoa> obterListaDePessoas() throws SQLException {
        try {
            //Conecta ao banco de dados por meio da classe de conexão
            Conexao con = new Conexao();
            con.getConexao(); //Obtendo a conexão

            // Comando SQL na base = tabela de carros
            String sql = "select * from tb_carros;";

            //Executa a query (comando SQL)
            /*PreparedStatement é usado para criar um objeto que representa a instrução SQL
            que será executada, sendo que é invocado através do objeto Connection .*/
            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            //Prepara a lista de carros para retornar
            List<Pessoa> listaDePessoa;
            listaDePessoa = new ArrayList<>();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Pessoa per = new Pessoa(); //Criando uma instância, novo carro na memória

                per.setId(resultado.getInt("idPessoa")); // Define ID do carro;

                // Insere o carro na lista Local
                ListagemPessoa.add(per);
            }

            // Após terminar, fecha a conexão
            resultado.close();
            comando.close();
            con.getConexao().close();

            // Retorna a lista de carros
            return listaDePessoa;
        } catch (SQLException e) { //Caso dê alguma exceção
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
            sql += "INSERT INTO tb_carros"
                    + "(fabricante) VALUES (?)";

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
