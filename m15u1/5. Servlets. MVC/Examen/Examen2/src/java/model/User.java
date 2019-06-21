/**
 * Modeliza al Usuario a través de dos entradas: nombre de usuario
 * y la contraseña
 * @author Pablo Rodriguez
 * @version 1.0 2019/01/15
 */
package model;

/**
 *
 * @author Pablo Rodriguez
 */
public class User {
    //atributos
    private String username;
    private String password;
    private String rang;

    public User(String username, String password, String rang) {
        this.username = username;
        this.password = password;
        this.rang = rang;
    }

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    

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

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }
    
    
    
    public String toString(){
        return "\n" + this.username + ":" + this.password + ":" + this.rang + ":";
    }
    
}
