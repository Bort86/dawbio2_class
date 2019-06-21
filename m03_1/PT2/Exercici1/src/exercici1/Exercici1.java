package exercici1;

/**
 *
 * @author Pablo Rodriguez
 */
public class Exercici1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quadrat quadrat = new Quadrat(4);
        Cercle cercle = new Cercle(4);
        Cub cub = new Cub(4);
        Esfera esfera = new Esfera(4);
        
        System.out.println(quadrat.area());
        System.out.println(quadrat.perímetre());
        System.out.println(cercle.area());
        System.out.println(cercle.perímetre());
        
        System.out.println(cub.volum());
        System.out.println(esfera.volum());
    }
    
}
