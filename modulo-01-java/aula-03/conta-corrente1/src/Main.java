
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();

        cliente1.nome = "Gandalf";
        cliente1.cpf = "2514986532";

        ContaCorrente contaCliente1 = new ContaCorrente();

        contaCliente1.cliente = cliente1;

        contaCliente1.agencia = 81;
        contaCliente1.numeroConta = "2541";
        contaCliente1.saldo = 1500;


        Endereco enderecoCliente1 = new Endereco();


        enderecoCliente1.tipoEndereco = 1;
        enderecoCliente1.logradouro = "Rua das flores";
        enderecoCliente1.numero = 58;
        enderecoCliente1.complemento = "Sem complemento";
        enderecoCliente1.cidade = "São Paulo";
        enderecoCliente1.estado = "São Paulo";
        enderecoCliente1.pais = "Brasil";


        Contato contatoCliente1 = new Contato();

        cliente1.contatos[0] = contatoCliente1;

        contatoCliente1.tipoEndereco = 1;
        contatoCliente1.descricao = "Celular";
        contatoCliente1.telefone = "8524-0220";



    //////////////////////////////////////////////////////////////////////////////////////////


        Cliente cliente2 = new Cliente();
        cliente2.nome = "Thorin";
        cliente2.cpf = "3914986659";

        ContaCorrente contaCliente2 = new ContaCorrente();

        contaCliente2.cliente = cliente2;

        contaCliente2.agencia = 58;
        contaCliente2.numeroConta = "2598";
        contaCliente2.saldo = 3000;


        Endereco enderecoCliente2 = new Endereco();

        enderecoCliente2.tipoEndereco = 2;
        enderecoCliente2.logradouro = "Rua da mata";
        enderecoCliente2.numero = 37;
        enderecoCliente2.complemento = "B";
        enderecoCliente2.cidade = "Porto Alegre";
        enderecoCliente2.estado = "Rio Grande do Sul";
        enderecoCliente2.pais = "Brasil";

        Contato contatoCliente2 = new Contato();

        cliente2.contatos[1] = contatoCliente2;

        contatoCliente2.tipoEndereco = 2;
        contatoCliente2.descricao = "Celular";
        contatoCliente2.telefone = "51 2502-0654";



    ///////////////////////////////////////////////////////////////////////////////

        // Transferência entre clientes
        contaCliente1.transferir(500.00, contaCliente2);

        contaCliente1.imprimirContaCorrente();
        contaCliente2.imprimirContaCorrente();


        contaCliente1.depositar(300.00);
        contaCliente1.retornarSaldoComChequeEspecial(500);
        contaCliente1.sacar(200);

        contaCliente1.imprimirContaCorrente();

        System.out.println();
        System.out.println();


        enderecoCliente1.imprimirEndereco();

        contatoCliente1.imprimirContato();

        cliente1.imprimirCliente();

    }
}