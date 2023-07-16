import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        int[] numeros = {2, 10, 5, 8, 6, 1, 56, 89, 71, 87};
        int numeroUsuario = 0;
        int numeroNoVetor = 0;
        int numerosMenores = 0;
        int numerosMaiores = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe um número: ");
        numeroUsuario = entrada.nextInt();

        for (int i = 0; i<=9; i++){
            if ( numeroUsuario == numeros[i]){
                numeroNoVetor++;
            }

            if (numeroUsuario > numeros[i]){
                numerosMenores++;
            }

            if (numeroUsuario < numeros[i]){
                numerosMaiores++;
            }
        }

        System.out.println("O número informado existe " + numeroNoVetor + " vezes no vetor");
        System.out.println("Existem " + numerosMenores + " menores que o digitado");
        System.out.println("Existem " + numerosMaiores + " maiores que o digitado");

        entrada.close();
    }
}
