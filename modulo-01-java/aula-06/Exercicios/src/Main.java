import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Calculo multiplicacao = new Calculo() {
            @Override
            public int calcular(int a, int b) {
                return a * b;
            }
        };

        Calculo soma = new Calculo() {
            @Override
            public int calcular(int a, int b) {
                return a + b;
            }
        };

        

    }
}