public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(2/0);
        } catch (ArithmeticException e){
            System.err.println(e.getMessage());
        }
    }
}
