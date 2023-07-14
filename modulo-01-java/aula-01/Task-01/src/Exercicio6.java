import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);

        float totalEleitores = 0;
        float votosValidos = 0;
        float votosBrancos = 0;
        float votosNulos = 0;
        float votosValidosPercentual;
        float votosBrancosPercentual;
        float votosNulosPercentual;

        System.out.println("Informe o total de eleitores: ");
        totalEleitores = entrada.nextFloat();

        System.out.println("Informe o número de votos válidos: ");
        votosValidos = entrada.nextFloat();

        System.out.println("Informe o número de votos brancos: ");
        votosBrancos = entrada.nextFloat();

        System.out.println("Informe o número de votos nulos: ");
        votosNulos = entrada.nextFloat();


        votosValidosPercentual = votosValidos / totalEleitores * 100;
        votosBrancosPercentual = votosBrancos / totalEleitores * 100;
        votosNulosPercentual = votosNulos / totalEleitores * 100;

        System.out.println("Os votos válidos representam " + votosValidosPercentual + "%" + " do total de eleitores");
        System.out.println("Os votos brancos representam " + votosBrancosPercentual + "%" + " do total de eleitores");
        System.out.println("Os votos nulos representam " + votosNulosPercentual + "%" + " do total de eleitores");

        entrada.close();
    }
}
