public abstract class Entidade {

    protected double vida;
    protected double ataque;

    protected boolean defendendo = false;

    public Entidade(double vida, double ataque) {
        this.vida = vida;
        this.ataque = ataque;
    }

    public double atacar(Entidade alvo, double quantDano) {
        System.out.println(this.getClass().getSimpleName() + " Atacou, deu "+ quantDano +" De dano");
        alvo.receberDano(quantDano);
        return quantDano;
    }

    public void receberDano(double dano){
        if (defendendo){
            dano /= 2;
        }
        setVida(getVida() - dano);
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }

}