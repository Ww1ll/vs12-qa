public class Exercicio4 {
    public static void main(String[] args) {
        int valorA = 10;
        int valorB = 20;
        int variavelAuxiliar = 0;

        variavelAuxiliar = valorA;
        valorA = valorB;
        valorB = variavelAuxiliar;

        System.out.println("Os valores que ficaram armazenados foram: ");
        System.out.println(" Variável A: " + valorA);
        System.out.println(" Variável B: " + valorB);
    }
}
