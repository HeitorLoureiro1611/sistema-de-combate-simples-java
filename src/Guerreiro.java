public class Guerreiro extends Entidade implements Defender, HabilidadeEspecial{

    public Guerreiro(double vida, double ataque) {
        super(vida, ataque);
    }

    @Override
    public void levantarEscudo() {
        System.out.println("Levantou o escudo!!\nDano reduzido pela metade");
        setDefendendo(true);
    }

    @Override
    public double ataqueDoDiabo(Entidade alvo, double dano) {
        System.out.println("Usou o ataque do Diabo deu o dobro de dano");
        atacar(alvo, dano*2);
        return dano;
    }
}