import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        float[][] matrizNotas = new float[5][4];
        int matricula = 0;
        int matriculaNotaMaior = 0;
        float mediaProvas = 0;
        float mediaTrabalhos = 0;
        float maiorNotaFinal = 0;
        float mediaNotasFinais = 0;

        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < 5; i++){

            for (int j = 0; j < 4; j++){
                System.out.println("Informe a matrícula: ");
                matricula = entrada.nextInt();
                matrizNotas[i][0] = matricula;

                System.out.println("Informe a média final: ");
                mediaProvas = entrada.nextFloat();
                matrizNotas[i][1] = mediaProvas;

                System.out.println("Informe a média dos trabalhos: ");
                mediaTrabalhos = entrada.nextFloat();
                matrizNotas[i][2] = mediaTrabalhos;

                matrizNotas[i][3] = (mediaProvas * 0.6f + mediaTrabalhos * 0.4f);

                if(matrizNotas[i][3] > maiorNotaFinal){
                    maiorNotaFinal = matrizNotas[i][3];
                    matriculaNotaMaior = matricula;
                }

            }

        }

        mediaNotasFinais = matrizNotas[0][3] + matrizNotas[1][3] + matrizNotas[2][3] + matrizNotas[3][3] + matrizNotas[4][3]/5;

        System.out.println("A matrícula que teve a maior nota foi a: " + matriculaNotaMaior);
        System.out.println("A média das notas finais foram de: " + mediaNotasFinais);

        entrada.close();
    }
}
