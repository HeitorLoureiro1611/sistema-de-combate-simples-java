public class Guerreiro extends Entidade implements Defender, HabilidadeEspecial{

    public Guerreiro(double vida, double ataque) {
        super(vida, ataque);
    }

    @Override
    public void levantarEscudo(double dano) {
        System.out.println("Se defendeu com escudo, reduziu " + dano/2 + " de dano");
        receberDano(dano/2);
    }

    @Override
    public double ataqueDoDiabo(Entidade alvo, double dano) {
        System.out.println("Usou o ataque do Diabo deu o dobro de dano");
        atacar(alvo, dano*2);
        return dano;
    }
}