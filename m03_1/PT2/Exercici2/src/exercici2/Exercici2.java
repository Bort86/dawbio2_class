package exercici2;

import java.util.Scanner;

/**
 *
 * @author Pablo Rodriguez
 */
public class Exercici2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        DAOVehicle dao= new DAOVehicle();
        int option;
        
        do{
            System.out.println("1. Insertar vehiculo");
            System.out.println("2. Borrar vehiculo");
            System.out.println("3. Listar vehiculos");
            System.out.println("4. Salir");
            option = lector.nextInt();
            
            switch(option){
                case 1:
                    dao.insertarVehicle();
                    break;
                case 2:
                    dao.borrarVehicle();
                    break;
                case 3:
                    dao.listarVehicle();
                    break;
                default:
                    System.out.println("Please, introduce a number between 1 and 4");
            }
        } while(option != 4);
    }
    
}
