import java.util.Scanner;
import java.util.Stack;

public class ExPilha {
    public static void main(String[] args) {

        // Stack - Pilhas

        Scanner entrada = new Scanner(System.in);

        Stack<Integer> pilha = new Stack<>();

        int numero = 0;

        for (int i = 0; i<15; i++){
            System.out.println("Informe um número: ");
            numero = entrada.nextInt();

            if(numero %2 == 0){
                pilha.push(numero);

            } else {
                pilha.pop();
            }
        }

        if (!pilha.empty()){
            System.out.println("Elementos da pilha " + pilha.size());
        }

        pilha.add(1);

        entrada.close();
    }
}
