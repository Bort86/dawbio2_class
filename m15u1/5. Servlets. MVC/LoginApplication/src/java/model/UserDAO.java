package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Profes de DAW M07
 */
public class UserDAO {
    
    //atributo que es un objeto de DataBase
    private DataBase d;

    public UserDAO(){
       
    }
    
    public UserDAO(String ruta){
       
        d=new DataBase(ruta+"/files/users.txt");
            
    }
   
   //retorna un boleà en funció si l'usuari hi és o no a l'aplicació   
    public boolean findOne(User u){
       boolean flag=false;
       
       List<String> all=new ArrayList();
       all=d.listAllLines();
       
       for(String s : all){
            String[] pieces=s.split(":");
            if(pieces[0].equals(u.getUsername()) && pieces[1].equals(u.getPassword())){
                flag=true;
                break;
            }
      }
       
       
       return flag;
    }

    public int addUser(User u) {
        
        int inserted;
        //Paso 1: comprueba que u.getUsername() sea único
        if(findUsername(u.getUsername())){
            inserted=-1;//ya existe el usuario
        }else{
            //es cuando inserto
            inserted=d.insertToFile(u.toString());//0->problemas, 1-> ok
        }
        
        return inserted;
    }

    private boolean findUsername(String username) {
        boolean flag=false;
       
       List<String> all=new ArrayList();
       all=d.listAllLines();
       
       for(String s : all){
            String[] pieces=s.split(":");
            if(pieces[0].equals(username) ){
                flag=true;
                break;
            }
        }
       
       
       return flag;
        
     }
    
}

