import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[][] matriz = {{2, 6},{5, 8}};
        int somaPrimeiraLinha = 0;
        int somaSegundaLinha = 0;
        int somaTotal = 0;
        int diferencaLinhas = 0;

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                somaPrimeiraLinha += matriz[i][0];
                somaSegundaLinha += matriz[0][j];
                somaTotal += matriz[i][j];

            }
        }

        diferencaLinhas = somaPrimeiraLinha - somaSegundaLinha;

        System.out.println("A soma da primeira linha é: " + somaPrimeiraLinha);
        System.out.println("A soma da segunda linha é: " + somaSegundaLinha);
        System.out.println("A diferença entre a primeira e a segunda linha é: " + diferencaLinhas);
        System.out.println("A soma total é de: " + somaTotal);

        entrada.close();
    }
}
