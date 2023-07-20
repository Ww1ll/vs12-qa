import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExMap {
    public static void main(String[] args) {

        // Map
        //put(chave, valor);
        //remove(chave);
        //get(chave);
        Scanner entrada = new Scanner(System.in);

        Map<String,String> documento = new HashMap<>();

        String nome;
        String cpf;

        System.out.println("Informe o nome e CPF: ");
        nome = entrada.nextLine();
        cpf = entrada.nextLine();

        documento.put(nome, cpf);

        System.out.println("Informe o nome e CPF: ");
        nome = entrada.nextLine();
        cpf = entrada.nextLine();

        documento.put(nome, cpf);

        System.out.println("Informe o nome e CPF: ");
        nome = entrada.nextLine();
        cpf = entrada.nextLine();

        documento.put(nome, cpf);

        System.out.println("Consultar CPF: ");
        cpf = entrada.nextLine();

        if (documento.containsValue(cpf)){
            documento.remove(nome);
        } else {
            System.out.println("CPF não existe");
        }

        System.out.println(documento);



        entrada.close();
    }

}
