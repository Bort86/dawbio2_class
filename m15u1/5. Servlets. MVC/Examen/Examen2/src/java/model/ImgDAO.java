/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Rodriguez
 */
public class ImgDAO {

    private DataBase d;

    public ImgDAO() {

    }

    public ImgDAO(String ruta) {

        d = new DataBase(ruta + "/files/alergies.txt");

    }
    
    public List<Image> printAll(){
        List<String> all = new ArrayList();
        List<Image> list_image = new ArrayList();
        all = d.listAllLines();
        
        for (String s : all) {
            String[] pieces = s.split(":");
            Image img = new Image ("<img src='img/"+ pieces[0] +".jpg/>", pieces[1]);
            list_image.add(img);
        }
        
        return list_image;
    }
}
