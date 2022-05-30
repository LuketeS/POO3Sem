package view;

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

            per.getNome(nome);

            PessoasDAO pD = new PessoasDAO();
            pD.inserePessoa(pessoa);
            System.out.println("\nCarro inserido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
