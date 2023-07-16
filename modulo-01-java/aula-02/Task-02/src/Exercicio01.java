import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String nomeProduto;
        double valorProduto;
        int[] listaProdutos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double novoValorProduto = 0;
        double qtdProdutos = 0;

        DecimalFormat formatoDecimal = new DecimalFormat("#,##0.00");

        System.out.println("Informe o nome do produto: ");
        nomeProduto = entrada.nextLine();

        System.out.println("Informe o valor do produto: ");
        valorProduto = entrada.nextFloat();

        System.out.println("Produto.: " + nomeProduto);
        System.out.println("Preço R$.: " + valorProduto);
        System.out.println("Promoção: " + nomeProduto);
        System.out.println("------------------------");


        novoValorProduto = valorProduto - ( valorProduto * 0.05d);

        for(int i = 0; i<10; i++){

            qtdProdutos = listaProdutos[i] * novoValorProduto;
            System.out.println(listaProdutos[i] + " x " + formatoDecimal.format(novoValorProduto) + " = " + formatoDecimal.format(qtdProdutos));
            novoValorProduto = novoValorProduto - ( valorProduto * 0.05d);
        }

        entrada.close();
    }
}
