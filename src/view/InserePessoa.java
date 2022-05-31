package view;

import conexao.PessoasDAO;
import elementos.Pessoa;
import java.util.Scanner;


public class InserePessoa {

    public void InsereCarro() {

        try {

            Scanner sc = new Scanner(System.in);
            Pessoa per = new Pessoa();
            //

            System.out.println("\n---  INSIRA OS DADOS DO CARRO  ---");

            System.out.print("\nInforme o Fabricante: ");
            String nome = sc.nextLine().toUpperCase();

            per.setNome(nome);

            PessoasDAO pD = new PessoasDAO();
            pD.inserePessoa(per);
            
            System.out.println("Foi suave");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
