package model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBConnects
 * Loads jdbc driver, db connection properties and the getConnection class
 * @author Pablo Rodriguez
 */
public class DBConnect {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BD_URL = "jdbc:mysql://127.0.0.1/hospital";
    private static final String USUARI = "provenusr";
    private static final String PASSWORD = "Provenpass1.";

    public DBConnect() throws ClassNotFoundException {
        Class.forName(this.DRIVER);       
    }
    
    /**
     * 
     * @return a connection 
     * @throws SQLException if a connection error occurs
     */
    public Connection getConnection() throws SQLException {
        Connection conn=DriverManager.getConnection(BD_URL, USUARI, PASSWORD);
        return conn;
    }
}
