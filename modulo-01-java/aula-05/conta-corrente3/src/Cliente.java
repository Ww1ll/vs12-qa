import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();


    public Cliente(){

    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public String getNome(){
        return nome;
    }

    public void SetNome(String nome){
         this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos(){
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos){
        this.enderecos = enderecos;
    }


    public void imprimirContatos(){
            for (Object listaContatos : contatos){
                System.out.println(listaContatos);
            }

    }

    public void imprimirEnderecos(){

        for (Object listaEnderecos : enderecos){
            System.out.println(listaEnderecos);
        }

    }

    public void imprimirCliente(){
        System.out.println("Cliente: " + nome + " CPF: " + cpf);

    }

}
