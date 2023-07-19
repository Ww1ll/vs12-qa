
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(
                "Gandalf",
                "2514986532",
                new Contato[] {new Contato ( "Celular", "11 95820-2587", 2)},
                new Endereco[] {new Endereco(1, "Rua das flores", 58, "Sem complemento", "00548921","São Paulo", "São Paulo", "Brasil")}

        );



        Conta contaCliente1 = new Conta(cliente1, "254", 81, 1500);

        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1);


        contaCorrenteCliente1.setCliente(cliente1);


    //////////////////////////////////////////////////////////////////////////////////////////


        Cliente cliente2 = new Cliente(
                "Thorin",
                "3914986659",
                new Contato[] {new Contato ( "Celular", "51 2502-0654", 2)},
                new Endereco[] {new Endereco(2, "Rua da Mata", 37, "B", "00284978","Porto Alegre", "Rio Grande do Sul", "Brasil")}

        );


        Conta contaCliente2 = new Conta(cliente2, "2598", 58, 3000);

        ContaPoupanca contaPoupancaCliente2 = new ContaPoupanca(cliente2);


        contaPoupancaCliente2.setCliente(cliente2);


    ///////////////////////////////////////////////////////////////////////////////

        // Transferência entre clientes

        contaCorrenteCliente1.transferir(500.00, contaCliente2);

        contaCliente1.getSaldo();

        contaCliente2.getSaldo();


        contaCliente1.depositar(300.00);

        contaCorrenteCliente1.retornarSaldoComChequeEspecial(500, contaCliente1);

        contaCliente1.sacar(200);

        contaCliente1.getSaldo();


        contaPoupancaCliente2.creditarTaxa(contaCliente2);



    }
}