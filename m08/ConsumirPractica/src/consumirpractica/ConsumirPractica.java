/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirpractica;

import java.util.Scanner;

/**
 *
 * @author Pablo Rodriguez
 */
public class ConsumirPractica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String frase = "";
        Scanner reader = new Scanner(System.in); 
        System.out.println("Introduce una frase: ");
        frase = reader.nextLine();
        System.out.println("La frase '" + frase + "' tiene "+ numParaules(frase) +" palabras y "+ numLletres(frase) +" letras");
        
    }

    private static int numLletres(java.lang.String numLletres) {
        webservice.WebServicePractica_Service service = new webservice.WebServicePractica_Service();
        webservice.WebServicePractica port = service.getWebServicePracticaPort();
        return port.numLletres(numLletres);
    }

    private static int numParaules(java.lang.String numParaules) {
        webservice.WebServicePractica_Service service = new webservice.WebServicePractica_Service();
        webservice.WebServicePractica port = service.getWebServicePracticaPort();
        return port.numParaules(numParaules);
    }
    
}
