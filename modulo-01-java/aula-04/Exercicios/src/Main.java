
public class Main {
    public static void main(String[] args) {

      Pessoa pessoa1 = new Pessoa("William", 23);

      pessoa1.isEhMaiorDeIdade();

      Pessoa pessoa2 = new Pessoa("Pedro", 15);

        System.out.println(pessoa2.ehMaiorDeIdade());

        pessoa2.mandarWhatsApp("Mensagem qualquer dois");


        pessoa2.setMensagem("Enviar mensagem");
        pessoa2.getMensagem();


        Animal tom = new Animal("Tom");

        Gato gato = new Gato();

      System.out.println("O " + tom.getNome() + " faz um som de " + gato.mia());



    }
}