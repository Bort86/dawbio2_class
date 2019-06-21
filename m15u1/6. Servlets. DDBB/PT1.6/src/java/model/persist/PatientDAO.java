package model.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import model.Patient;

public class PatientDAO {

    private final Properties queries;
    private static String PROPS_FILE;
    private static DBConnect dataSource;

    public PatientDAO(String ruta) throws IOException, ClassNotFoundException {
        queries = new Properties();
        PROPS_FILE = ruta + "/osteoporosi_queries.properties";
        queries.load(new FileInputStream(PROPS_FILE));

        dataSource = DBConnect.getInstance();
    }

    public String getQuery(String queryName) {
        return queries.getProperty(queryName);
    }

    /**
     * <strong>getDataSource()</strong>
     *
     * @return object to connect to database.
     */
    public static DBConnect getDataSource() {
        return dataSource;
    }

    /**
     * findAll: executes Find All query
     * @return  a list of Patients
     */
    public Collection<Patient> findAll() {
        Collection<Patient> list = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
                Statement st = conn.createStatement();) {
            ResultSet res = st.executeQuery(getQuery("FIND_ALL"));
            while (res.next()) {
                Patient patient = new Patient();
                patient.setIdRegistre(res.getInt("idRegistre"));
                patient.setEdat(res.getInt("edat"));
                patient.setGrupEdat(res.getString("grupEdat"));
                patient.setPes(res.getInt("pes"));
                patient.setTalla(res.getInt("talla"));
                patient.setImc(res.getDouble("IMC"));
                patient.setClassificacio(res.getString("classificació"));
                patient.setMenarquia(res.getInt("menarquia"));
                patient.setMenopausia(res.getString("menopausia"));
                patient.setTipusMenopausia(res.getString("tipusMenopausia"));

                list.add(patient);
            }
        } catch (SQLException e) {
            list = new ArrayList<>();
        }

        return list;
    }

    /**
     * filterPatient: it will filter patient's attributes
     * @param filt_patient
     * @return a set of patients with the selected attributes
     */
    public Collection<Patient> filterPatient(Patient filt_patient) {
        Collection<Patient> result = new ArrayList<>();
        // dejar el query de find con un ? justo después del where
        // y preparar un concatenado de strings aquí
        
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement st = conn.prepareStatement(getQuery("FIND")); )
        {
            st.setString(1, filt_patient.getClassificacio());
            st.setString(2, filt_patient.getMenopausia());
            st.setString(3, filt_patient.getTipusMenopausia());
            
            ResultSet res = st.executeQuery();
            while(res.next()){
                Patient patient = new Patient();
                patient.setIdRegistre(res.getInt("idRegistre"));
                patient.setEdat(res.getInt("edat"));
                patient.setGrupEdat(res.getString("grupEdat"));
                patient.setPes(res.getInt("pes"));
                patient.setTalla(res.getInt("talla"));
                patient.setImc(res.getDouble("IMC"));
                patient.setClassificacio(res.getString("classificació"));
                patient.setMenarquia(res.getInt("menarquia"));
                patient.setMenopausia(res.getString("menopausia"));
                patient.setTipusMenopausia(res.getString("tipusMenopausia"));

                result.add(patient);
            }
            
        } catch (SQLException e) {
            result = new ArrayList<>();
        }
        
        return result;
    }

    /**
     * insertPatient: receives the new patient's params
     * @param patient
     * @return number of rows affected in the database after the insert
     */
    public int insertPatient(Patient patient) {
        int rowsAffected = 0;
        
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("INSERT")); )
        {
            pst.setInt(1, patient.getEdat());
            pst.setString(2, patient.getGrupEdat());
            pst.setInt(3, patient.getPes());
            pst.setInt(4, patient.getTalla());
            pst.setDouble(5, patient.getImc());
            pst.setString(6, patient.getClassificacio());
            pst.setInt(7, patient.getMenarquia());
            pst.setString(8, patient.getMenopausia());
            pst.setString(9, patient.getTipusMenopausia());
            
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        
        return rowsAffected;
    }

    
    /*
    public Collection<Patient> findOne(Patient patient) {
        Collection<Patient> list = new ArrayList<>();

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement st = conn.prepareStatement(getQuery("FIND_ONE")); )
        {
            st.setInt(1, Patient.getFriendID());
            ResultSet res = st.executeQuery();
            // TODO
            // list = recorrem res i l'afegim a list            
        } catch (SQLException e) {
            list = new ArrayList<>();
        }

        return list;
    }
    
   
    public int delete(Patient patient) {
        int rowsAffected;

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("DELETE")); )
        {
            pst.setInt(1, patient.getFriendID());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = -2;
        }

        return rowsAffected;
    }

    
    public int modify(Patient patient) {
       int rowsAffected;

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("UPDATE")); )
        {
            pst.setString(1, patient.getName());
            pst.setString(2, patient.getPhone());
            pst.setInt(3, patient.getAge());
            pst.setString(4, patient.getCategoryId());
            pst.setInt(5, patient.getFriendID());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }
     */
}
