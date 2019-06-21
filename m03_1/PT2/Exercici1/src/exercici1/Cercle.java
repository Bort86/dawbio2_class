package exercici1;

/**
 *
 * @author Pablo Rodriguez
 */
public class Cercle implements Figura2D{
    
    private int radi;
    
    //Constructors

    public Cercle() {
    }

    public Cercle(int radi) {
        this.radi = radi;
    }

    //Getterns n setters

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    @Override
    public String area() {
        return "Area = " + Math.PI*Math.pow(this.radi, 2);
    }

    @Override
    public String perímetre() {
        return "Perímetro = " + Math.PI*2*(this.radi);
    }
    
}
