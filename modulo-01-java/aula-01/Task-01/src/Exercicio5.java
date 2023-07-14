import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        float base = 0;
        float altura = 0;
        float areaRetangulo = 0;

        System.out.println("Cálculo da área do retângulo: ");

        System.out.println("Informe a base: ");
        base = entrada.nextFloat();

        System.out.println("Informe a base: ");
        altura = entrada.nextFloat();

        areaRetangulo = base * altura;

        System.out.println("A área do retângulo é: " + areaRetangulo);


        entrada.close();
    }
}
