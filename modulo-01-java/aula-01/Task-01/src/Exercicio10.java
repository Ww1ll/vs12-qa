import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numeroIdentificacao = 0;
        float nota1 = 0;
        float nota2 = 0;
        float nota3 = 0;
        float mediaExercicios = 0;
        float mediaAproveitamento = 0;

        System.out.println("Informe o número de identificação do aluno");
        numeroIdentificacao = entrada.nextInt();

        System.out.println("Informe a primeira nota: ");
        nota1 = entrada.nextFloat();

        System.out.println("Informe a segunda nota: ");
        nota2 = entrada.nextFloat();

        System.out.println("Informe a terceira nota: ");
        nota3 = entrada.nextFloat();

        mediaExercicios = (1 + 2 + 3) / 3;

        mediaAproveitamento = (nota1 + nota2 * 2 + nota3 * 3 + mediaExercicios)/7;

        System.out.println("O número de identificação do aluno é: " + numeroIdentificacao);
        System.out.println("Suas notas foram: " + nota1 + " , " + nota2 + " , " + nota3 );
        System.out.println("A média dos exercícios foram: " + mediaExercicios);
        System.out.println("A média de aproveitamento foi: " + mediaAproveitamento);

        if( mediaAproveitamento <= 9.0  || mediaAproveitamento >= 6.0){
            System.out.println("APROVADO");

        } else if ( mediaAproveitamento < 6.0 ){
            System.out.println("REPROVADO");
        }

        entrada.close();
    }

}
