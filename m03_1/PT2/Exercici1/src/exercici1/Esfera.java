package exercici1;

/**
 *
 * @author Pablo Rodriguez
 */
public class Esfera implements Figura3D{
    private int radi;

    public Esfera() {
    }

    public Esfera(int radi) {
        this.radi = radi;
    }

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    @Override
    public String volum() {
        return "Volumen = " + (4/3)*Math.PI*Math.pow(this.radi, 3) ;
    }
    
    
}
