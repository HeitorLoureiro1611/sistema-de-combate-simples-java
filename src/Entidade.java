public abstract class Entidade {

    protected double vida;
    protected double ataque;


    public Entidade(double vida, double ataque) {
        this.vida = vida;
        this.ataque = ataque;
    }

    public double atacar(Entidade alvo, double quantDano) {
        System.out.println(this.getClass().getSimpleName() + " Atacou, deu "+ quantDano +" De dano");
        alvo.receberDano(quantDano);
        return quantDano;
    }

    public void receberDano(double ataque){
        setVida(getVida() - ataque);
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

}