public class Mago extends Entidade implements CuraMagica, HabilidadeMagica{

    public Mago(double vida, double ataque) {
        super(vida, ataque);
    }

    @Override
    public void curaDivina() {
        System.out.println("Conseguiu curar 20 de vida");
        setVida(getVida() + 20);
    }

    @Override
    public double bolaDeFogo(Entidade alvo, double dano) {
        System.out.println("Usou bola de fogo, deu o dobro de dano");
        atacar(alvo, dano*2);
        return dano;
    }
}