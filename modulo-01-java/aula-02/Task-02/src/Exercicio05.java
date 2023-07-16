import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {

        float[][] precoProdutos = new float[10][3];
        String[] produtos = {
                "Açúcar", "Café", "leite", "Chocolate", "Pão",
                "Tuperware", "Amaciante", "Macarrão", "Sabonete", "Arroz"
        };
        String[] mercado = {"Mercado 1", "Mercado 2", "Mercado 3"};
        float precoUnitarioProduto = 0;
        float mercadoBarato = 0;

        Scanner entrada = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            for (int j = 0; j<3; j++ ){
                System.out.println(mercado[j] + ": ");
                System.out.println("Informe o valor do produto " + produtos[i] + ": ");
                precoUnitarioProduto = entrada.nextFloat();
                precoProdutos[i][j] = precoUnitarioProduto;
            }

        }

        float[] mediaPrecos = new float[3];

        float menorMedia = mediaPrecos[0];

        for (int j=0; j<3; j++){
            float somaPrecos = 0;

            for (int i = 0; i<10; i++){
                somaPrecos += precoProdutos[i][j];
            }
            mediaPrecos[j] = somaPrecos/10;
        }

        for (int j = 0; j<3; j++){
            if (mediaPrecos[j] < menorMedia){
                menorMedia = mediaPrecos[j];
                mercadoBarato = j;
            }
        }

        System.out.println("O mercado mais barato é o: " + mercadoBarato);

        entrada.close();
    }

}
