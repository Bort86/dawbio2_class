package exercici1;

/**
 *
 * @author Pablo Rodriguez
 */
public class Cub implements Figura3D{
    private int costat;

    public Cub() {
    }

    public Cub(int costat) {
        this.costat = costat;
    }

    public int getCostat() {
        return costat;
    }

    public void setCostat(int costat) {
        this.costat = costat;
    }

    @Override
    public String volum() {
        return "Volumen = " + Math.pow(this.costat, 3);
    }
    
    
}
