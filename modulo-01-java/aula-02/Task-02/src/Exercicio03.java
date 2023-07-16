import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nome = " ";
        String nomeMaiorJogador = " ";
        float altura = 0;
        float alturaMaior = 0;
        int peso = 0;
        int pesoMaior = 0;
        int idade = 0;
        int idadeMaior = 0;
        int jogadoresCadastrados = 0;
        float mediaAlturasJogadores = 0;
        float somaAlturas = 0;


        System.out.println(" ------ Cadastro Jogador ------ ");

        do {

            System.out.println("Informe o nome do jogador: ");
            nome = entrada.nextLine();


            if (!nome.equals("SAIR")){

                System.out.println("Informe a altura do jogador: ");
                altura = entrada.nextFloat();

                somaAlturas += altura;

                System.out.println("Informe a idade do jogador: ");
                idade = entrada.nextInt();

                System.out.println("Informe o peso do jogador: ");
                peso = entrada.nextInt();
                entrada.nextLine();


                if (peso != 0 || altura != 0 || nome != " "){
                    jogadoresCadastrados++;

                    if (altura > alturaMaior){
                        alturaMaior = altura;
                        nomeMaiorJogador = nome;
                    }

                    if (idade > idadeMaior){
                        idadeMaior = idade;
                        nomeMaiorJogador = nome;
                    }

                    if(peso > pesoMaior){
                        pesoMaior = peso;
                        nomeMaiorJogador = nome;
                    }

                }

                mediaAlturasJogadores = somaAlturas/jogadoresCadastrados;

                System.out.println("A quantidade de jogadores cadastrados é: " + jogadoresCadastrados);
                System.out.println("A altura do maior jogador é: " + alturaMaior);
                System.out.println("O jogador mais velho é: " + nomeMaiorJogador);
                System.out.println("O jogador mais pesado é: " + nomeMaiorJogador);
                System.out.println("A média das alturas dos jogadores é: " + mediaAlturasJogadores);

            }


        } while(!nome.equals("SAIR"));



        entrada.close();
    }
}
