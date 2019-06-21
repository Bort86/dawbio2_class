/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author alumne
 */
public class Validation {
    public static boolean minimSize(String value, int mySize){
        
        boolean flag=false;
        
        if(value.length()>=mySize) flag=true;
        
        return flag;
         
    }
    
}
