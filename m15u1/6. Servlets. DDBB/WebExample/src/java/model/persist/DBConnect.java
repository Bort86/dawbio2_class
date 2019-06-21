package model.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Paso 1. Cargar el driver (Class.forname())
//Paso 2. Llamar a la conexión(DriverManager)
//Paso 3. Mandar consultas: Statement (Directa); 
//          PreparedStatement (Preparada); CallableStatement(Procedural) 
public final class DBConnect {

    // attributes
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BD_URL = "jdbc:mysql://localhost/friendship";
    private static final String USUARI = "provenusr";
    private static final String PASSWORD = "Provenpass1.";

    private static DBConnect instance = null;
    
    private DBConnect() { //ojo, el constructor es privado
        try {
            Class.forName(DRIVER); // cargar el driver
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    //modelo singleton: se intenta instanciar solo una vez la conexión para
    //no tener que crear varios objetos de conexión abiertos a la vez

    /**
     * <strong>getInstance()</strong>
     * gets an unique instance of DBConnect.
     *
     * @return an instance of DBConnect.
     */
    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    /**
     * <strong>getConnection()</strong>
     * establishes a connection to the database.
     *
     * @return Connection to database.
     * @throws SQLException if connection error occurs.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(BD_URL, USUARI, PASSWORD);
    }

}
