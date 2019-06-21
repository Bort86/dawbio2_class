/**
 * Práctica 1
 * M03 Programming - Java at proven.cat
 *
 * @author Pablo Rodriguez
 * @version 1.0 2019-05-08
 * 
 * 
 */
package spotproven;

import java.util.Scanner;

public class SpotProven {

    /**
     * @param args the command line arguments
     * prints the menu and loads functions
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        CancionDAO dao= new CancionDAO();
        int option;
        
        do{
            System.out.println("1. Insertar canción");
            System.out.println("2. Borrar canción");
            System.out.println("3. Listar canciones");
            System.out.println("4. Generar Lista aleatoria");
            System.out.println("5. Salir");
            option = lector.nextInt();
            
            switch(option){
                case 1:
                    dao.insertarCancion();
                    break;
                case 2:
                    dao.borrarCancion();
                    break;
                case 3:
                    dao.listarCanciones();
                    break;
                case 4:
                    dao.generarListaDinamica();
                    break;
                default:
                    System.out.println("Please, introduce a number between 1 and 5");
            }
        } while(option != 5);
    }
    
}
