package view;

import conexao.PessoasDAO;
import elementos.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;




public class ListagemPessoa {
   

    public void listaTodasPessoas() throws SQLException {


        PessoasDAO pessoa = new PessoasDAO();

        
        List<Pessoa> listaDePessoas;
        listaDePessoas = new ArrayList<>();
   

 
        listaDePessoas = pessoa.obterListaDePessoas();

     
        System.out.println("\nID\t|\tNome");
        System.out.println("----\t|\t-----");

        for (Pessoa pessoaLocal : listaDePessoas) { 
            System.out.print(pessoaLocal.getId() + "\t|\t");
            System.out.print(pessoaLocal.getNome()+ "\t|\t");
            System.out.println("\n");
        }
    }
}
