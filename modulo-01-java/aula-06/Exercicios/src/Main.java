import java.util.function.Function;

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


        Calculo multiplicacaoPorDez2 = new Calculo() {
            @Override
            public int calcular(int a, int b) {
                return a * 10;
            }
        };

        CalculoRaizQuadrada raizQuadrada2 = new CalculoRaizQuadrada() {
            @Override
            public Double raiz(Double a) {
                return Math.sqrt(a);
            }
        };

        Function<Double, Double> multiplicacaoPorDez = a -> a * 10;
        Function<Double, Double> raizQuadrada = b -> Math.sqrt(b);

        Function<Double, Double> multiplicacaoPorDezThenRaizQuadrada = raizQuadrada.compose(multiplicacaoPorDez);
        System.out.println(multiplicacaoPorDezThenRaizQuadrada.apply(5.87));

        Function<Double, Double> RaizQuadradaThenmultiplicacaoPorDez = multiplicacaoPorDez.compose(raizQuadrada);
        System.out.println(RaizQuadradaThenmultiplicacaoPorDez.apply(5.87));



    }
}