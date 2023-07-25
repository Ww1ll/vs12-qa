package br.com.dccompany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe conta")
class ContaTest {


    Cliente cliente1 = new Cliente();

    Cliente cliente2 = new Cliente();
    Conta contaCliente1 = new Conta(cliente1, "254", 81, 1500.0);

    Conta contaCliente2 = new Conta(cliente2, "200", 56, 3000.0);

    ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "254", 81, 1500.0);

    ContaPoupanca contaPoupancaCliente1 = new ContaPoupanca(cliente1, "254", 81, 1500.0);

    ContaPagamento contaPagamentoCliente = new ContaPagamento(cliente2, "200", 56, 3000.0);

    @Test
    @DisplayName("deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso")
    void sacarContaCorrenteESaldo() {


        boolean valorSaque = contaCorrenteCliente1.sacar(300.0);
        Assertions.assertEquals(true, valorSaque);

        double saldoConta = contaCorrenteCliente1.getSaldo();

        Assertions.assertEquals(1200.0, saldoConta);

    }


    @Test
    @DisplayName("deveTestarSaqueContaCorrenteSemSaldo")
    void sacarContaCorrenteSemSaldo() {

        boolean valorSaque = contaCorrenteCliente1.sacar(8000.0);

        Assertions.assertEquals(false, valorSaque);

        }

    @DisplayName("deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso")
    @Test
    void sacarContaPoupancaESaldo() {

        contaPoupancaCliente1.creditarTaxa(contaCliente1);

        boolean saquePoupanca = contaPoupancaCliente1.sacar(500.0);
        Assertions.assertEquals(true, saquePoupanca);

        double saldoConta = contaPoupancaCliente1.getSaldo();
        Assertions.assertEquals(1000.0, saldoConta);

    }

    @DisplayName("deveTestarSaqueContaPoupancaSemSaldo")
    @Test
    void sacarContaPoupancaSemSaldo() {
        boolean saquePoupanca = contaPoupancaCliente1.sacar(8000.0);

        Assertions.assertEquals(false, saquePoupanca);

    }

    @DisplayName("deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso")
    @Test
    void sacarContaPagamentoESaldo() {

        boolean saqueContaPagamento = contaPagamentoCliente.sacar(500.0, contaPagamentoCliente);
        Assertions.assertEquals(true, saqueContaPagamento);

        double saldoContaPagamento = contaPagamentoCliente.getSaldo();
        Assertions.assertEquals(2495.75, saldoContaPagamento);


    }

    @DisplayName("deveTestarSaqueContaPagamentoSemSaldo")
    @Test
    void sacarContaPagamentoSemSaldo(){
        boolean saqueContaPagamento = contaPagamentoCliente.sacar(5000.0, contaPagamentoCliente);

        Assertions.assertEquals(false, saqueContaPagamento);
    }

    @DisplayName("deveTestarTransferenciaEVerificarSaldoComSucesso")
    @Test
    void transferenciaESaldo(){
        boolean transferencia = contaCliente1.transferir(500.0, contaCliente2);

        Assertions.assertEquals(true, transferencia);

        double saldoAtual = contaCliente1.getSaldo();
        Assertions.assertEquals(1000.0, saldoAtual);

    }

    @DisplayName("deveTestarTransferenciaSemSaldo")
    @Test
    void transferenciaSemSaldo(){
        boolean transferencia = contaCliente1.transferir(90000.0, contaCliente2);
        Assertions.assertEquals(false, transferencia);



    }

    @DisplayName("deveTestarDepositoEVerificarSaldoComSucesso")
    @Test
    void depositoESaldo(){

        boolean deposito = contaCliente2.depositar(5000.0);

        Assertions.assertEquals(true, deposito);

        double saldoAtual = contaCliente2.getSaldo();

        Assertions.assertEquals(8000.0, saldoAtual);

    }

    @DisplayName("deveTestarDepositoNegativo\n")
    @Test
    void depositoNegativo(){

        boolean deposito = contaCliente1.depositar(-53.0);

        Assertions.assertEquals(false, deposito);

    }

}