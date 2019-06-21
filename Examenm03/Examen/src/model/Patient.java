
package model;

/**
 *
 * @author Pablo Rodriguez
 */
public class Patient {

    private int idPaciente;
    private String nom;
    private String cognoms;
    private int edat;
    private String idDoctor;
    
    //Constructors
    public Patient() {
    }

    public Patient(int idPaciente, String nom, String cognoms, int edat, String idDoctor) {
        this.idPaciente = idPaciente;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.idDoctor = idDoctor;
    }
    
    //getters n setters

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }
    
    //equals and tostring

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "idPaciente=" + idPaciente + ", nom=" + nom + ", cognoms=" + cognoms + ", edat=" + edat + ", idDoctor=" + idDoctor + '}';
    }
    
    
    
    
}
