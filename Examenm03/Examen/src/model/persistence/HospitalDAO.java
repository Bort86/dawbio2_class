package model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Doctor;
import model.Patient;

/**
 * HospitalDAO
 * Main DB layer, it will acces database
 * @author Pablo Rodriguez
 */
public class HospitalDAO {
    
    //List of all queries
    private final String QUERY_FIND_BY_NAME = "select * from pacientes where nom=?";
    private final String QUERY_INSERT = "INSERT INTO pacientes (idPaciente, nom, cognoms, edat, idDoctor) VALUES (?, ?, ?, ?, ?)";
    private final String QUERY_FIND_BY_ID = "select * FROM pacientes where idPaciente=?";
    private final String QUERY_DELETE = "DELETE FROM pacientes WHERE idPaciente=?";
    private final String QUERY_LIST = "select * FROM doctores";
    private final String QUERY_FIND_BY_DOC = "select * FROM pacientes where idDoctor=?";

    public List<Patient> findByName(String name) throws ClassNotFoundException {
        List<Patient> result = new ArrayList<>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_NAME);
                st.setString(1,name);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Patient patient = new Patient();
                    patient.setIdPaciente(res.getInt("idPaciente"));
                    patient.setNom(res.getString("nom"));
                    patient.setCognoms(res.getString("cognoms"));
                    patient.setEdat(res.getInt("edat"));
                    patient.setIdDoctor(res.getString("idDoctor"));

                    result.add(patient);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public int insert(Patient p) throws ClassNotFoundException {
        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement(QUERY_INSERT);

                pst.setInt(1, p.getIdPaciente());
                pst.setString(2, p.getNom());
                pst.setString(3, p.getCognoms());
                pst.setInt(4, p.getEdat());
                pst.setString(5, p.getIdDoctor());

                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;

        }

        return rowsAffected;
    }

    public Patient findById(int id) throws ClassNotFoundException {
        Patient p = null;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_ID);
                st.setLong(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                p = resultsetToPatient(rs);
            }
        } catch (SQLException e) {
            p = null;
        }
        return p;
    }

    private Patient resultsetToPatient(ResultSet rs) throws SQLException {
        Patient p = null;
        int idPaciente = rs.getInt("idPaciente");
        String nom = rs.getString("nom");
        String cognoms = rs.getString("cognoms");
        int edat = rs.getInt("edat");
        String idDoctor = rs.getString("idDoctor");
        p = new Patient(idPaciente, nom, cognoms, edat, idDoctor);
        return p;
    }

    public int delete(Patient p) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(QUERY_DELETE);
                pst.setLong(1, p.getIdPaciente());
                rowsAffected = pst.executeUpdate();
            }

        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    public List<Doctor> listAll() throws ClassNotFoundException {
        List<Doctor> result = new ArrayList<>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_LIST);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setIdDoctor(res.getString("idDoctor"));
                    doctor.setNom(res.getString("nom"));
                    doctor.setEspecialitat(res.getString("especialitat"));
                    
                    result.add(doctor);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public List<Patient> findPatbyDoc(String id) throws ClassNotFoundException {
        List<Patient> result = new ArrayList<>();
        
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null){
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_DOC);
                st.setString(1, id);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Patient patient = new Patient();
                    patient.setIdPaciente(res.getInt("idPaciente"));
                    patient.setNom(res.getString("nom"));
                    patient.setCognoms(res.getString("cognoms"));
                    patient.setEdat(res.getInt("edat"));
                    patient.setIdDoctor(res.getString("idDoctor"));
                    
                    result.add(patient);                            
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }
    
}
