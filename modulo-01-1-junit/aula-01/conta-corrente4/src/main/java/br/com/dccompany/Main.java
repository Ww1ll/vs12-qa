package br.com.dccompany;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Endereco> enderecosCliente1 = new ArrayList<>();
        enderecosCliente1.add(new Endereco(1, "Rua das flores", 58, "Sem complemento","00548921", "São Paulo", "São Paulo", "Brasil"));

        ArrayList<Contato> contatosCliente1 = new ArrayList<>();
        contatosCliente1.add(new Contato("Celular", "11 95820-2587", 2));

        Cliente cliente1 = new Cliente(
                "Gandalf",
                "2514986532",
                contatosCliente1,
                enderecosCliente1
        );

        Conta contaCliente1 = new Conta(cliente1, "254", 81, 1500);

        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "254", 81, 1500);


        contaCorrenteCliente1.setCliente(cliente1);

        ContaPagamento contaPagamento1 = new ContaPagamento(cliente1, "254", 81, 1500);

        contaPagamento1.setCliente(cliente1);


        //////////////////////////////////////////////////////////////////////////////////////////

        ArrayList<Endereco> enderecosCliente2 = new ArrayList<>();
        enderecosCliente2.add(new Endereco(2,"Rua da Mata", 37, "B", "00284978", "Porto Alegre", "Rio Grande do Sul", "Brasil"));

        ArrayList<Contato> contatosCliente2 = new ArrayList<>();
        contatosCliente1.add(new Contato("Celular", "51 2502-0654", 2));

        Cliente cliente2 = new Cliente(
                "Thorin",
                "3914986659",
                contatosCliente2,
                enderecosCliente2

        );


        Conta contaCliente2 = new Conta(cliente2, "2598", 58, 3000);

        ContaPoupanca contaPoupancaCliente2 = new ContaPoupanca(cliente2, "2598", 58, 3000);


        contaPoupancaCliente2.setCliente(cliente2);


        ///////////////////////////////////////////////////////////////////////////////


        // Transferência entre clientes

        contaCorrenteCliente1.transferir(500.00, contaPoupancaCliente2);


        System.out.println(contaCorrenteCliente1.getSaldo());

        System.out.println(contaPoupancaCliente2.getSaldo());


        contaPoupancaCliente2.transferir(50.00, contaPagamento1);

        //depósito

        contaPagamento1.depositar(1000.00);

        contaCorrenteCliente1.depositar(800);

        contaPoupancaCliente2.depositar(900);


        //saque

        contaPagamento1.sacar(800, contaPagamento1);

        contaCorrenteCliente1.sacar(300, contaCorrenteCliente1);

        contaPoupancaCliente2.sacar(200);


        contaCliente1.depositar(300.00);

        contaCorrenteCliente1.retornarSaldoComChequeEspecial(500, contaCliente1);

        contaCliente1.sacar(200);


        contaPoupancaCliente2.creditarTaxa(contaCliente2);

        System.out.println(contaPoupancaCliente2.getSaldo());
        System.out.println(contaPagamento1.getSaldo());
        System.out.println(contaCorrenteCliente1.getSaldo());


        System.out.println("Endereço: ");
        cliente1.imprimirEnderecos();

        System.out.println("Contatos: ");
        cliente1.imprimirContatos();

        System.out.println("===================");
        cliente1.imprimirCliente();
        System.out.println("Agência: " + contaCliente1.getAgencia());
        System.out.println("Numero: " + contaCliente1.getNumeroConta());
        System.out.println("Saldo Conta Corrente: " + contaCorrenteCliente1.getSaldo());
        System.out.println("Saldo Conta Pagamento: " + contaPagamento1.getSaldo());


    }
}