package model.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import model.Patient;
import model.User;

public class UserDAO {

    private final Properties queries;
    private static String PROPS_FILE;
    private static DBConnect dataSource;

    public UserDAO(String ruta) throws IOException, ClassNotFoundException {
        queries = new Properties();
        PROPS_FILE = ruta + "/user_queries.properties";
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
    
    public String findOne(User user) {
        String result = null;
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement st = conn.prepareStatement(getQuery("FIND")); )
        {
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            ResultSet res = st.executeQuery();
            while (res.next()){
                user.setRol(res.getString("rol"));
            }
            result = user.getRol();
                       
        } catch (SQLException e) {
            result = null;
        }

        return result;
    }

    /**
     * insertUser
     * Insert an user object into database
     * @param user
     * @return int rowsAffected = 0 if errors, 1 if ok
     */
    public int insertUser(User user) {
        int rowsAffected = 0;
        
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("INSERT")); )
        {
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRol());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        
        return rowsAffected;
    }
    
    /**
     * findRepeated
     * It will search for a user by its name
     * @param username
     * @return true if repeated, false if not
     */
    public boolean findRepeated(String username) {
        boolean result = true;
        User userCheck = new User();
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement st = conn.prepareStatement(getQuery("FINDREPE")); )
        {
            st.setString(1, username);
            ResultSet res = st.executeQuery();
            while (res.next()){
                userCheck.setUsername(res.getString("nom"));
            }
            if (userCheck.getUsername()==null){
               result = false;
            }
                       
        } catch (SQLException e) {
            return result;
        }
        return result;
    }

    
    /*    
   
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
