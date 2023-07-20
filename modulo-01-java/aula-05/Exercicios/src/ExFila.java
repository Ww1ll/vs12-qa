import java.util.LinkedList;
import java.util.Queue;

public class ExFila {
    public static void main(String[] args) {
        //Queue - Filas

        System.out.println("Sistema de senhas: ");

        Queue<Integer> senhas = new LinkedList<>();

        senhas.add(001);
        senhas.add(002);
        senhas.add(003);
        senhas.add(004);
        senhas.add(005);

        System.out.println(senhas.size() + " pessoas entraram na fila");

        senhas.poll();
        senhas.poll();

        System.out.println("Restam " + senhas.size() + " na fila.");

        senhas.poll();

        senhas.add(006);
        senhas.add(007);
        senhas.add(8);

        System.out.println("Restam " + senhas.size() + " na fila.");

        senhas.poll();
        senhas.poll();
        senhas.poll();

        System.out.println(" As senhas da fila são: ");

        for (Object valores : senhas){
            System.out.println(valores);
        }
    }
}
