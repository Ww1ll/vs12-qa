public interface Imovimentacao {


      default boolean sacar(double sacar){
        return true;
      }

    boolean sacar(double sacar, ContaCorrente contaCorrente);

    boolean depositar(double depositar);

    boolean transferir(Double transferir, Conta contaTransferida);



}
