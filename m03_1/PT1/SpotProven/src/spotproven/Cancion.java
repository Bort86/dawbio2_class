/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotproven;

/**
 *
 * @author bort
 */
public class Cancion {
    // Properties
    private String clave;
    private String interprete;
    private String autor;
    private String album;
    private int duracion;
    
    // Constructors

    public Cancion(String clave, String interprete, String autor, String album, int duracion) {
        this.clave = clave;
        this.interprete = interprete;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
    }

    public Cancion() {
    }

    public Cancion(String clave) {
        this.clave = clave;
    }
    
    // getterns & setters

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion{" + "clave=" + clave + ", interprete=" + interprete +
                ", autor=" + autor + ", album=" + album + ", duracion=" + duracion + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        
        String clave1 = this.clave;
        String clave2 = ((Cancion)obj).clave;
        
        return (clave1.equals(clave2));
    }
    
    
}
