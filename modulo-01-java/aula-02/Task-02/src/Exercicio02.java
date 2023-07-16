import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numeroAProcurar = 0;
        int numeroInformado = 0;
        int numeroASerEncontrado = 0;


        System.out.println("Informe um número a ser adivinhado: ");
        numeroInformado = entrada.nextInt();
        numeroAProcurar =  numeroInformado;

        do {
            System.out.println("Tente adivinhar o número: ");
            numeroASerEncontrado = entrada.nextInt();

            if (numeroASerEncontrado < numeroInformado){
                System.out.println("O número a ser encontrado é maior do que você digitou. ");
            } else if (numeroASerEncontrado > numeroInformado){
                System.out.println("O número a ser encontrado é menor do que você digitou. ");
            }

        }while(numeroInformado != numeroASerEncontrado);

        entrada.close();
    }
}
