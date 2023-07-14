import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String estado;
        int opcaoCidade = 0;

        System.out.println("Informe o estado: ");
        estado = entrada.next();

        if(estado.equals("SP") || estado.equals("São Paulo")){
            System.out.println("Escolha uma cidade: ");
            System.out.println("1- Campinas");
            System.out.println("2- Santos");
            System.out.println("3- Araraquara");
            opcaoCidade = entrada.nextInt();

            switch(opcaoCidade){
                case 1:
                    System.out.println(" --- Campinas --- ");
                    System.out.println("População: 1.1 milhão de habitantes");
                    System.out.println("Principal festa: Festival de cerveja artesanal");
                    System.out.println("IDH: 0.816");
                    break;
                case 2:
                    System.out.println(" --- Santos --- ");
                    System.out.println("População: 433.656 mil habitantes");
                    System.out.println("Principal festa: Nossa Senhora do Monte Serrat");
                    System.out.println("IDH: 0.840");
                    break;
                case 3:
                    System.out.println(" --- Araraquara --- ");
                    System.out.println("População: 238.339 mil habitantes");
                    System.out.println("Principal festa: Festa do Trabalhador");
                    System.out.println("IDH: 0.815");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

        if(estado.equals("RS") || estado.equals("Rio Grande do Sul")){
            System.out.println("Escolha uma cidade: ");
            System.out.println("1- Porto Alegre");
            System.out.println("2- Pelotas");
            System.out.println("3- Gramado");
            opcaoCidade = entrada.nextInt();

            switch(opcaoCidade){
                case 1:
                    System.out.println(" --- Porto Alegre --- ");
                    System.out.println("População: 1.5 milhão de habitantes");
                    System.out.println("Principal festa: Rock Fest");
                    System.out.println("IDH: 0.805");
                    break;
                case 2:
                    System.out.println(" --- Pelotas --- ");
                    System.out.println("População: 343.132 mil habitantes");
                    System.out.println("Principal festa: Feira Nacional do Doce");
                    System.out.println("IDH: 0.739");
                    break;
                case 3:
                    System.out.println(" --- Gramado --- ");
                    System.out.println("População: 36.555 mil habitantes");
                    System.out.println("Principal festa: Festa da Colônia");
                    System.out.println("IDH: 0.764");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

        if(estado.equals("MG") || estado.equals("Minas Gerais")){
            System.out.println("Escolha uma cidade: ");
            System.out.println("1- Belo Horizonte");
            System.out.println("2- Ouro Preto");
            System.out.println("3- Uberaba");
            opcaoCidade = entrada.nextInt();

            switch(opcaoCidade){
                case 1:
                    System.out.println(" --- Belo Horizonte --- ");
                    System.out.println("População: 2.7 milhão de habitantes");
                    System.out.println("Principal festa: Arraial de Belo Horizonte ");
                    System.out.println("IDH: 0.810");
                    break;
                case 2:
                    System.out.println(" --- Ouro Preto --- ");
                    System.out.println("População: 74.558 mil habitantes ");
                    System.out.println("Principal festa: Festa do Reinado");
                    System.out.println("IDH: 0.741");
                    break;
                case 3:
                    System.out.println(" --- Uberaba --- ");
                    System.out.println("População: 337.092  mil habitantes");
                    System.out.println("Principal festa: Festa do 13 de Maio");
                    System.out.println("IDH: 0.772");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

        entrada.close();
    }
}
