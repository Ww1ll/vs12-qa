public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos= new Endereco[2];

    public void imprimirContatos(){
        for (int i = 0; i<2; i++){
                System.out.println(this.contatos[0].tipoEndereco);
                System.out.println(this.contatos[0].descricao);
                System.out.println(this.contatos[0].telefone);
        }
    }

    public void imprimirEnderecos(){
        for (int i = 0; i<2; i++){
            System.out.println(this.enderecos[0].tipoEndereco);
            System.out.println(this.enderecos[0].cep);
            System.out.println(this.enderecos[0].complemento);
            System.out.println(this.enderecos[0].logradouro);
            System.out.println(this.enderecos[0].numero);
            System.out.println(this.enderecos[0].cidade);
            System.out.println(this.enderecos[0].estado);
            System.out.println(this.enderecos[0].pais);
        }
    }

    public void imprimirCliente(){
        System.out.println("Cliente: " + nome + " CPF: " + cpf);

    }

}
