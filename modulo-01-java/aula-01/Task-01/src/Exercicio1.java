import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("---------- Questão 01 ----------");

        Scanner entrada =  new Scanner(System.in);

        String nome;
        int idade;
        String cidade;
        String estado;

        System.out.println("Informe o seu nome: ");
        nome = entrada.nextLine();

        System.out.println("Informe a sua idade: ");
        idade = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Informe a sua cidade: ");
        cidade = entrada.nextLine();

        System.out.println("Informe o seu estado: ");
        estado = entrada.nextLine();

        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + ".");

        entrada.close();

    }
}
