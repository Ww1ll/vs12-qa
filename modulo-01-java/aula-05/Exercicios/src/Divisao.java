public class Divisao implements OperacaoMatematica{

    Double a = 0.0;
    Double b = 0.0;

    Double c = 0.0;

    public Divisao(){

    }

    public Divisao(Double a, Double b){
        this.a = a;
        this.b = b;
    }
    public Divisao(Double a, Double b, Double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public Double calcula(Double a, Double b){
        return a / b;
    }

    @Override
    public Double calcula(Double a, Double b, Double c) {
        return a + b + c;
    }
}
