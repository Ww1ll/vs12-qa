import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String codigo;
        float precoUnitario = 0;
        int quantidadeComprada = 0;
        float precoTotal = 0;



        System.out.println("Informe o código do produto: ");
        System.out.println("Os códigos disponíveis são: ");
        System.out.println("ABCD - XYPK - KLMP - QRST");
        codigo = entrada.next();

        System.out.println("Informe a quantidade comprada");
        quantidadeComprada = entrada.nextInt();

        if(codigo.equals("ABCD")){
            precoUnitario = 5.30f;
            precoTotal = precoUnitario * quantidadeComprada;

        } else if(codigo.equals("XYPK")){
            precoUnitario = 6.00f;
            precoTotal = precoUnitario * quantidadeComprada;

        } else if(codigo.equals("KLMP")){
            precoUnitario = 3.20f;
            precoTotal = precoUnitario * quantidadeComprada;

        } else if(codigo.equals("QRST")){
            precoUnitario = 2.50f;
            precoTotal = precoUnitario * quantidadeComprada;

        } else {
            System.out.println("Código de produto inválido");
        }

        System.out.println("O preço total do produto comprado é de: " + precoTotal);

        entrada.close();
    }
}
