import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();

        Entidade jogador = null;
        Entidade maquina = null;
        SistemaDeBatalha batalha;

        int escolhaJogador = 0;

        System.out.println("===Combate RPG===\n");

        System.out.println("Escolha seu Personagem:");
        System.out.println("[1]Guerreiro [2]Mago");

        int escolhaMaquina = gerador.nextInt(1, 3);

        if (escolhaMaquina == 1) {
            maquina = new Guerreiro(150, 10);
        } else if (escolhaMaquina == 2) {
            maquina = new Mago(100, 15);
        }

        while (escolhaJogador < 1 || escolhaJogador > 2) {
            escolhaJogador = sc.nextInt();
            if (escolhaJogador == 1) {
                System.out.println("Guerreiro escolhido\n");
                jogador = new Guerreiro(150, 10);
            } else if (escolhaJogador == 2) {
                System.out.println("Mago escolhido\n");
                jogador = new Mago(100, 15);
            } else {
                System.out.println("Escolha inválida");
            }
        }

        System.out.println("Iniciando combate");

        batalha = new SistemaDeBatalha(jogador, maquina);
        batalha.iniciarBatalha();

        sc.close();
    }
}
