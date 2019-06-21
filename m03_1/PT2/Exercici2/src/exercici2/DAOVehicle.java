package exercici2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pablo Rodriguez
 */
public class DAOVehicle {

    ArrayList<Vehicle> vehiculos = new ArrayList<Vehicle>();

    public DAOVehicle() {
        Coche coche = new Coche("coche", "Ford", "Fiesta", "V8", 1);
        Bicicleta bicicleta = new Bicicleta("bicicleta", "Marca2", "BMX", "motor2", 2);
        Tricicle tricicle = new Tricicle("tricicle", "MarcaTRicicle", "ModeloTricicle", "motor3", 3);

        this.vehiculos.add(coche);
        this.vehiculos.add(bicicleta);
        this.vehiculos.add(tricicle);

    }

    public void insertarVehicle() {
        Scanner lector = new Scanner(System.in);
        String opcion = "";
        System.out.println("Introduzca qué tipo de vehiculo quiere crear: coche, bicicleta o tricicle: ");
        opcion = lector.nextLine();
        System.out.println("Introduzca nombre: ");
        String nombre = lector.nextLine();
        System.out.println("Introduzca marca: ");
        String marca = lector.nextLine();
        System.out.println("Introduzca modelo: ");
        String modelo = lector.nextLine();
        System.out.println("Introduzca motor: ");
        String motor = lector.nextLine();
        System.out.println("Introduzca número de ejes");
        int ejes = lector.nextInt();

        switch (opcion) {
            case "coche":
                Vehicle coche = new Coche(nombre, marca, modelo, motor, ejes);
                this.vehiculos.add(coche);
                System.out.println("Añadido ok " + coche.toString());
                break;
            case "bicicleta":
                Vehicle bicicleta = new Bicicleta(nombre, marca, modelo, motor, ejes);
                this.vehiculos.add(bicicleta);
                System.out.println("Añadido ok " + bicicleta.toString());
                break;
            case "tricicle":
                Vehicle tricicle = new Tricicle(nombre, marca, modelo, motor, ejes);
                this.vehiculos.add(tricicle);
                System.out.println("Añadido ok " + tricicle.toString());
                break;
            default:
                System.out.println("Error al añadir");
                break;

        }

    }

    public void borrarVehicle() {
        Scanner lector = new Scanner(System.in);
        String nombre = "";
        String opcion = "";

        System.out.println("Introduzca el nombre del vehículo a borrar");
        nombre = lector.nextLine();

        System.out.println("Introduzca qué tipo de vehiculo quiere borrar: coche, bicicleta o tricicle: ");
        opcion= lector.nextLine();
        
        switch (opcion) {
            case "coche":
                Vehicle coche = new Coche(nombre);
                if(this.vehiculos.contains(coche)){
                    this.vehiculos.remove(coche);
                } else {
                    System.out.println("No hay ningún vehículo con ese nombre");
                }
                break;
            case "bicicleta":
                Vehicle bicicleta = new Bicicleta();
                if(this.vehiculos.contains(bicicleta)){
                    this.vehiculos.remove(bicicleta);
                } else {
                    System.out.println("No hay ningún vehículo con ese nombre");
                }
                break;
            case "tricicle":
                Vehicle tricicle = new Tricicle();
                if(this.vehiculos.contains(tricicle)){
                    this.vehiculos.remove(tricicle);
                } else {
                    System.out.println("No hay ningún vehículo con ese nombre");
                }
                break;
            default:
                System.out.println("Error al intentar borrar");
                break;

        }
    }

    public void listarVehicle() {
        for(Vehicle vehiculos: this.vehiculos){
            System.out.println(vehiculos.toString());
        }
    }

}
