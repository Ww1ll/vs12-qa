import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        float salarioAtual = 0;
        float salarioNovo = 0;
        float diferencaSalario = 0;
        String cargo;

        System.out.println("Informe o seu cargo: ");
        cargo = entrada.next();
        System.out.println("Informe o seu salário atual");
        salarioAtual = entrada.nextFloat();

        if(cargo.equals("Gerente")){
            salarioNovo = salarioAtual + (salarioAtual * 0.1f);

        } else if(cargo.equals("Engenheiro")){
            salarioNovo = salarioAtual + (salarioAtual * 0.2f);

        } else if(cargo.equals("Técnico")){
            salarioNovo = salarioAtual + (salarioAtual * 0.3f);

        } else {
            salarioNovo = salarioAtual + (salarioAtual * 0.4f);
        }

        diferencaSalario = salarioNovo - salarioAtual;

        System.out.println("O novo salário é: " + salarioNovo + " o antigo é: " + salarioAtual + " e a diferença é de: " + diferencaSalario);

        entrada.close();

    }
}
