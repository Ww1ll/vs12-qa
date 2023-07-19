public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos= new Endereco[2];


    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos){
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

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos(){
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos){
        this.enderecos = enderecos;
    }

    public void imprimirContatos(){
                System.out.println(this.contatos[0].getTipoEndereco());
                System.out.println(this.contatos[0].getDescricao());
                System.out.println(this.contatos[0].getTelefone());

    }

    public void imprimirEnderecos(){
            System.out.println(this.enderecos[0].getTipoEndereco());
            System.out.println(this.enderecos[0].getCep());
            System.out.println(this.enderecos[0].getComplemento());
            System.out.println(this.enderecos[0].getLogradouro());
            System.out.println(this.enderecos[0].getNumero());
            System.out.println(this.enderecos[0].getCidade());
            System.out.println(this.enderecos[0].getEstado());
            System.out.println(this.enderecos[0].getPais());

    }

    public void imprimirCliente(){
        System.out.println("Cliente: " + nome + " CPF: " + cpf);

    }

}
