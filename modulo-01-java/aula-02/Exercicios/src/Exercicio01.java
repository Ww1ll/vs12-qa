public class Exercicio01 {
    public static void main(String[] args) {
        int[] valores = {20, 30, 40};
        int soma = 0;
        int media = 0;

        for(int i = 0; i< valores.length; i++){
            soma += valores[i];
        }

        media = soma/3;

        System.out.println(" A soma é: " + soma);
        System.out.println(" A média é: " + media);
    }
}
