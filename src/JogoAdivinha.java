import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinha {

    public static void main(String[] args) {

        ArrayList<Integer> listaNumerosCertos  = new ArrayList<>();
        ArrayList<Integer> listaNumerosErrados = new ArrayList<>();

        Random random  = new Random();

        boolean continuar = true;
        int pontuacao     = 0;

        int numeroAleatorio = random.nextInt(10);
        int numeroUsuario   = 0;

        while (continuar) {

            System.out.println("Digite 'jogar' para adivinhar o número ou 'sair' para sair: ");
            String resposta = new Scanner(System.in).nextLine();
            if (resposta.equalsIgnoreCase("jogar")) {
                System.out.println("Digite um número:");
                numeroUsuario = new Scanner(System.in).nextInt();
                if (numeroAleatorio == numeroUsuario) {
                    pontuacao = pontuacao + 10;
                    continuar = false;

                    listaNumerosCertos.add(numeroUsuario);

                    System.out.println("Pontuação do jogador = " + pontuacao);
                } else if (numeroUsuario + 1 == numeroAleatorio || numeroUsuario - 1 == numeroAleatorio) {
                    pontuacao = pontuacao + 5;
                    System.out.println("Pontuação do jogador = " + pontuacao);

                    listaNumerosErrados.add(numeroUsuario);
                } else if ( numeroUsuario != numeroAleatorio){
                    listaNumerosErrados.add(numeroUsuario);
                }
            } else if (resposta.equalsIgnoreCase("sair")){
                System.out.println("Pontuação final do jogador = "+pontuacao);
                continuar = false;
            }
        }

        System.out.println("\nLISTA DE NUMEROS INCORRETOS:");
        for (int numErrado : listaNumerosErrados){
            System.out.println(numErrado);
        }

        System.out.println("\nLISTA DE NUMEROS CERTOS:");
        for (int numCerto : listaNumerosCertos){
            System.out.println(numCerto);
        }
    }
}
