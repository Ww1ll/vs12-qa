public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    String mensagem;

    public void conversar(Pessoa pessoa){
        System.out.printf("%s conversou com %s", this.nome, nome);

    }

    public String retornarNomeCompleto(String nome, String sobrenome){
        return this.nome + this.sobrenome;

    }

    public boolean ehMaiorDeIdade(){
        if (this.idade > 18){
            return true;
        } else{
            return false;
        }
    }

    public void mandarWhatsApp(String mensagem){
        System.out.println(this.nome + " enviou: menssagem para " + Pessoa.this.nome);
    }
}
