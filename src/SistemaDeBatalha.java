import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SistemaDeBatalha {

    private final Entidade jogador;
    private final Entidade maquina;
    double dano;

    public SistemaDeBatalha(Entidade jogador, Entidade maquina) {
        this.jogador = jogador;
        this.maquina = maquina;
    }

    public void turnoMaquina(){
        Random random = new Random();

        ArrayList<Integer> acoesDisponiveis = new ArrayList<>();
        acoesDisponiveis.add(1);
        if (maquina instanceof Defender) {
            acoesDisponiveis.add(2); // Levantar Escudo
        }
        if (maquina instanceof HabilidadeEspecial) {
            acoesDisponiveis.add(3); // Ataque do Diabo
        }
        if (maquina instanceof CuraMagica) {
            acoesDisponiveis.add(4); // Cura Divina
        }
        if (maquina instanceof HabilidadeMagica) {
            acoesDisponiveis.add(5); // Bola de Fogo
        }

        int indiceDaLista = random.nextInt(acoesDisponiveis.size());
        int acao = acoesDisponiveis.get(indiceDaLista);

        switch (acao){
            case 1:
                System.out.println("A maquina escolheu ataque basico");
                dano = maquina.atacar(jogador, maquina.getAtaque());
                break;
            case 2:
                System.out.println("A maquina escolheu levantar escudo");
                if (maquina instanceof Defender) {
                    ((Defender) maquina).levantarEscudo();
                }
                break;
            case 3:
                System.out.println("A maquina escolheu ataque do diabo");
                if (maquina instanceof HabilidadeEspecial) {
                    dano = ((HabilidadeEspecial) maquina).ataqueDoDiabo(jogador, maquina.getAtaque());
                }
                break;
            case 4:
                System.out.println("A maquina escolheu cura");
                if (maquina instanceof CuraMagica) {
                    ((CuraMagica) maquina).curaDivina();
                }
                break;
            case 5:
                System.out.println("A maquina escolheu bola de fogo");
                if (maquina instanceof HabilidadeMagica) {
                    dano = ((HabilidadeMagica) maquina).bolaDeFogo(jogador, maquina.getAtaque());
                }
                break;
        }
    }

    public void iniciarBatalha() {
        Scanner sc = new Scanner(System.in);


        while (jogador.getVida() > 0 && maquina.getVida() > 0) {

            System.out.println("========Vida========");
            System.out.println("Vida do jogador: " + jogador.getVida());
            System.out.println("======================");
            System.out.println("Vida da maquina: " + maquina.getVida());
            System.out.println("======================");
            System.out.println("\n");

            int escolha;
            System.out.println("Ações:\n" +
                    "[1] Ataque Basico");
            if (jogador instanceof HabilidadeEspecial) {

                System.out.println("[2] Defesa");
                System.out.println("[3] Ataque especial(Ataque do Diabo)");
            } else {

                System.out.println("[4] Cura");
                System.out.println("[5] Magia especial");
            }
            System.out.println("Escolha sua ação: ");

            escolha = sc.nextInt();
            System.out.println("\n");
            System.out.println("======================================");


            switch (escolha) {

                case 1:
                    dano = jogador.atacar(maquina, jogador.getAtaque());
                    break;
                case 2:
                    if (jogador instanceof Defender) {
                        ((Defender) jogador).levantarEscudo();
                    } else {
                        System.out.println("Falhou");
                    }
                    break;
                case 3:
                    if (jogador instanceof HabilidadeEspecial) {
                        dano = ((HabilidadeEspecial) jogador).ataqueDoDiabo(maquina, jogador.getAtaque());
                    } else {
                        System.out.println("Falhou");
                    }
                    break;
                case 4:
                    if (jogador instanceof CuraMagica) {
                        ((CuraMagica) jogador).curaDivina();
                    } else {
                        System.out.println("Falhou");
                    }
                    break;
                case 5:
                    if (jogador instanceof HabilidadeMagica) {
                        dano = ((HabilidadeMagica) jogador).bolaDeFogo(maquina, jogador.getAtaque());
                    } else {
                        System.out.println("Falhou");
                    }
                    break;
                default:
                    System.out.println("Escolha invalida");
            }
            System.out.println("======================================");
            System.out.println("\n");

            System.out.println("=============Turno da Maquina=============");
            turnoMaquina();
            System.out.println("======================================");
            System.out.println("\n");


            //checagem de condição de vitoria
            if (maquina.getVida() <= 0){
                System.out.println("O jogador venceu!!!!");
            } else if (jogador.getVida() <= 0){
                System.out.println("A maquina venceu :p");
            }
        }
        sc.close();
    }

    public Entidade getJogardor() {
        return jogador;
    }

    public Entidade getMaquina() {
        return maquina;
    }
}