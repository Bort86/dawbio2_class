/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pablo Rodriguez
 */
@WebService(serviceName = "WebServicePractica")
public class WebServicePractica {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "numParaules")
    public int numParaules(@WebParam(name = "numParaules") String txt) {
        String [] words = txt.split("\\s+");
        return words.length;
    }
    
    @WebMethod(operationName = "numLletres")
    public int numLletres(@WebParam(name = "numLletres") String txt) {
        String [] words = txt.split("\\s+");
        int result =0;
        for (String word : words){
            result += word.length();
        }
        return result;
    }
}
