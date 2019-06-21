package exercici2;

/**
 *
 * @author Pablo Rodriguez
 */
public abstract class Vehicle {
    private String marca;
    private String model;
    private String motor;
    private int ruedas;
    private int ejes;

    public Vehicle() {
    }

    public Vehicle(String marca, String model, String motor, int ejes) {
        this.marca = marca;
        this.model = model;
        this.motor = motor;
        this.ejes = ejes;
    }

    
    public Vehicle(String marca, String model, String motor, int ruedas, int ejes) {
        this.marca = marca;
        this.model = model;
        this.motor = motor;
        this.ruedas = ruedas;
        this.ejes = ejes;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "marca=" + marca + ", model=" + model + ", motor=" + motor + ", ruedas=" + ruedas + ", ejes=" + ejes + '}';
    }
    
    
    
    public abstract void endavant();
    
    public abstract void aturar();
    
    public abstract void girar();
}
