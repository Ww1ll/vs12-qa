import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int horaInicio = 0;
        int minutoInicio = 0;
        int horaFim = 0;
        int minutoFim = 0;
        int diferencaHora = 0;
        int diferencaMinuto = 0;

        System.out.println("Informar a hora de início do jogo: ");
        horaInicio = entrada.nextInt();

        System.out.println("Informar os minutos do início do jogo");
        minutoInicio = entrada.nextInt();

        System.out.println("Informar a hora do fim do jogo: ");
        horaFim = entrada.nextInt();

        System.out.println("Informar os minutos do fim do jogo");
        minutoFim = entrada.nextInt();

        if(horaFim < horaInicio){
            horaFim += 24;
        }

        if(minutoFim < minutoInicio){
            minutoFim += 60;
        }

        diferencaHora = horaFim - horaInicio;
        diferencaMinuto = minutoFim - minutoInicio;

        if (diferencaHora > 24){
            System.out.println("Duração de tempo de jogo inválida");
        }

        System.out.println("O tempo de duração do jogo foi de " + diferencaHora + ":" + diferencaMinuto + ".");


        entrada.close();

    }
}
