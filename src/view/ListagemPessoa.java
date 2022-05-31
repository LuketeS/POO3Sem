package view;
//Importar classes necessárias

import conexao.PessoasDAO;
import elementos.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;




public class ListagemPessoa {
    // Método para listar todos os carros

    public void listaTodasPessoas() throws SQLException {

        // Cria uma instância de CarrosDAO na memória
        PessoasDAO pessoa = new PessoasDAO();

        // Gera a lista de carros localmente, que será preenchida
        List<Pessoa> listaDePessoas;
        listaDePessoas = new ArrayList<>();
        //

        // Pega (obtém) a lista de carros através do objeto
        listaDePessoas = pessoa.obterListaDePessoas();

        // Inicia a impressão dos dados dos carros do banco
        System.out.println("\nID\t|\tNome");
        System.out.println("----\t|\t-----");

        for (Pessoa pessoaLocal : listaDePessoas) { // Iterator: Para cada carro na lista de carros...
            System.out.print(pessoaLocal.getId() + "\t|\t");
            System.out.print(pessoaLocal.getNome());
            System.out.println("\n");
        }
    }
}
