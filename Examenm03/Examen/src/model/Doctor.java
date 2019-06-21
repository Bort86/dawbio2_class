package model;

/**
 *
 * @author Pablo Rodriguez
 */
public class Doctor {
    private String idDoctor;
    private String nom;
    private String especialitat;
    
    // Constructors

    public Doctor() {
    }

    public Doctor(String idDoctor, String nom, String especialitat) {
        this.idDoctor = idDoctor;
        this.nom = nom;
        this.especialitat = especialitat;
    }
    
    // getters n setters

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
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
        final Doctor other = (Doctor) obj;
        if (this.idDoctor != other.idDoctor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doctor{" + "idDoctor=" + idDoctor + ", nom=" + nom + ", especialitat=" + especialitat + '}';
    }
    
}
