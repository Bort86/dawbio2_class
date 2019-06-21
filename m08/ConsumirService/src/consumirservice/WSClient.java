/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumirservice;

import com.cdyne.ws.DocumentSummary;
import com.cdyne.ws.Words;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Rodriguez
 */
public class WSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(hello("Pep"));
        
        List<Words> result = new ArrayList<>();
        
        DocumentSummary docsum = checkTextBodyV2("The wurld ist wronge");
        result = docsum.getMisspelledWord();
        
        System.out.println("Result: ");
        for (Words word : result) {
            System.out.println(word.getWord());
        }
    }

    private static DocumentSummary checkTextBodyV2(java.lang.String bodyText) {
        com.cdyne.ws.Check service = new com.cdyne.ws.Check();
        com.cdyne.ws.CheckSoap port = service.getCheckSoap();
        return port.checkTextBodyV2(bodyText);
    }

    private static String hello(java.lang.String name) {
        cat.proven.ws.NewWebService_Service service = new cat.proven.ws.NewWebService_Service();
        cat.proven.ws.NewWebService port = service.getNewWebServicePort();
        return port.hello(name);
    }

}
