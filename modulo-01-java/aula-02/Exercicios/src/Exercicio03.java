import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] valores = new int[3];
        int media = 0;

        for (int i = 0; i < 3; i++){
            System.out.println("Informe um número");
            valores[i] = entrada.nextInt();
        }

        media = valores[0] + valores[1] + valores[2] / 3;

        System.out.println("A média dos valores é: " + media);
        entrada.close();
    }
}
