public class Pessoa {
    public boolean ehMaiorDeIdade;
    private String nome;
    private String sobrenome;
    private int idade;
    private String whatsapp;
    private String mensagem;

    public Pessoa(){

    }
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;

    }

    public boolean isEhMaiorDeIdade() {
        return ehMaiorDeIdade;
    }

    public void setEhMaiorDeIdade(boolean ehMaiorDeIdade) {
        this.ehMaiorDeIdade = ehMaiorDeIdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    private void conversar(Pessoa pessoa){
        System.out.printf("%s conversou com %s", this.nome, nome);

    }

    private String retornarNomeCompleto(String nome, String sobrenome){
        return this.nome + this.sobrenome;

    }

    boolean ehMaiorDeIdade(){
        if (this.idade > 18){
            return true;
        } else{
            return false;
        }
    }

    void mandarWhatsApp(String mensagem){
        System.out.println(this.nome + " enviou: menssagem para " + Pessoa.this.nome);
    }

    public void setMandarWhatsApp(String mensagemQualquer) {
    }
}
