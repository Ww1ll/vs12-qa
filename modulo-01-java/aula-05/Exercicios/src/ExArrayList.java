import java.util.ArrayList;

public class ExArrayList {
    public static void main(String[] args) {
        //Array list

        ArrayList<String> listaNomes = new ArrayList<>();

        listaNomes.add("Maria");
        listaNomes.add("Joao");
        listaNomes.add("Pedro");


        System.out.println("Primeiro nome da lista: " + listaNomes.get(1));
        System.out.println("Penúltimo nome da lista: " + listaNomes.get(0));

        listaNomes.remove(2);

        System.out.println("Todos os nomes da lista: ");
        for (Object nomes : listaNomes){
            System.out.println(nomes);
        }

        System.out.println("Quantidade de nomes da lista: " + listaNomes.size());

        System.out.println();
    }
}
