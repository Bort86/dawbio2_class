package model;

/**Modeliza al Usuario a través de dos entradas: nombre de usuario
 * y la contraseña
 *@author alumne
 *@version 1.0, 2019/01/15
 */
public class User {
    
//atributos 
    private String username;
    private String password;

//constructor/es

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
//accesores: getters + setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //podrían interesarnos más métodos generales
    public String toString(){
        return "\n"+this.username+":"+this.password+":";
    }
    
}
