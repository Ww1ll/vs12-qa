
public class Main {
    public static void main(String[] args) {

      Pessoa pessoa1 = new Pessoa();

      pessoa1.nome = "Joao";
      pessoa1.sobrenome = "Silva";
      pessoa1.retornarNomeCompleto("Joao", "Silva");
      pessoa1.whatsapp = " 119589471";
      pessoa1.idade = 15;
      System.out.println(pessoa1.ehMaiorDeIdade());
      pessoa1.mandarWhatsApp("Mensagem qualquer");

      Pessoa pessoa2 = new Pessoa();

        pessoa2.nome = "Pedro";
        pessoa2.sobrenome = "Santos";
        pessoa2.retornarNomeCompleto("Pedro", "Santos");
        pessoa2.whatsapp = " 1195894561";
        pessoa2.idade = 23;
        System.out.println(pessoa2.ehMaiorDeIdade());
        pessoa2.mandarWhatsApp("Mensagem qualquer dois");
        pessoa2.conversar(pessoa1);

    }
}