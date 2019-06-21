/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotproven;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bort
 */
public class CancionDAO {
    // properties of CancionDAO: a list of pre-loaded songs.
    // I decided to create a new method, a constructor for dao, so i can
    // load some songs to the array

    ArrayList<Cancion> canciones = new ArrayList<Cancion>();

    // constructor, iit will load 5 songs at the start of the program
    public CancionDAO() {

        Cancion cancion = new Cancion();
        for (int i = 1; i < 6; i++) {
            cancion.setClave(Integer.toString(i));
            cancion.setInterprete("Interprete" + i);
            cancion.setAutor("Autor" + i);
            cancion.setAlbum("Album" + i);
            cancion.setDuracion(i + 30);
            this.canciones.add(cancion);
        }

    }
    /**
     * This method will ask for data for a new song, confirm if its not already
     * in the list, then add it. If it exists already, it will not add a new one
     */
    public void insertarCancion() {
        Cancion new_cancion = new Cancion();
        Scanner lector = new Scanner(System.in);

        System.out.println("Introduzca clave de la canción: ");
        new_cancion.setClave(lector.nextLine());

        System.out.println("Introduzca interprete: ");
        new_cancion.setInterprete(lector.nextLine());

        System.out.println("Introduzca autor: ");
        new_cancion.setAutor(lector.nextLine());

        System.out.println("Introduzca album: ");
        new_cancion.setAlbum(lector.nextLine());

        System.out.println("Introduzca duracion: ");
        new_cancion.setDuracion(lector.nextInt());

        if (this.canciones.contains(new_cancion)) {
            System.out.println("Error: la clave ya existe.");
        } else {
            this.canciones.add(new_cancion);
            System.out.println("Canción agregada correctamente");
        }
    }

    /**
     * method to erase a song. It will confirm it exists by "clave", if not, 
     * prints an error message
     */
    public void borrarCancion() {
        Cancion erase_cancion = new Cancion();
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca la clave de la canción a borrar");
        erase_cancion.setClave(lector.nextLine());

        if (this.canciones.contains(erase_cancion)) {
            this.canciones.remove(erase_cancion);
            System.out.println("Canción borrada");
        } else {
            System.out.println("No existe ninguna canción con esa clave");
        }
    }

    /**
     * method to print all songs available
     */
    public void listarCanciones() {
        for (Cancion cancion : this.canciones) {
            System.out.println(cancion.toString());
        }
    }

    /**
     * method to shuffle a list all songs
     */
    public void generarListaDinamica() {
        if (this.canciones.size() < 5) {
            System.out.println("No hay suficientes canciones");
        } else {
            int indice;
            for (int i = 0; i < 5; i++) {
                Random rnd = new Random();
                indice = rnd.nextInt(5);
                System.out.println(this.canciones.get(indice).toString());
            }

        }

    }

}
