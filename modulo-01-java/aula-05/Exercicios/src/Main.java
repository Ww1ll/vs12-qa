import java.util.*;

public class Main {
    public static void main(String[] args) {

        Soma somar = new Soma();

        Soma somar2 = new Soma();

        System.out.println("Soma: ");
        System.out.println(somar.calcula(58.2, 20.0));
        System.out.println(somar2.calcula(58.2, 20.0, 58.6));
        System.out.println();

        Subtracao subtrair = new Subtracao();

        Subtracao subtrair2 = new Subtracao();

        System.out.println("Subtração: ");
        System.out.println(subtrair.calcula(58.2, 20.0));
        System.out.println(subtrair2.calcula(58.2, 20.0, 58.6));
        System.out.println();

        Multiplicacao multiplicar = new Multiplicacao();

        Multiplicacao multiplicar2 = new Multiplicacao();

        System.out.println("Multiplicação: ");
        System.out.println(multiplicar.calcula(58.2, 20.0));
        System.out.println(multiplicar2.calcula(58.2, 20.0, 58.6));
        System.out.println();

        Divisao dividir = new Divisao();

        Divisao dividir2 = new Divisao();

        System.out.println("Divisão: ");
        System.out.println(dividir.calcula(58.2, 20.0));
        System.out.println(dividir2.calcula(58.2, 20.0, 58.6));
        System.out.println();




    }
}