/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Category;

/**
 *
 * @author Pablo Rodriguez
 */
public class CategoryDAO {

    private static DBConnect db;
    private final Properties queries;

    public CategoryDAO(String ruta) throws FileNotFoundException, IOException {
        queries = new Properties();
        queries.load(new FileInputStream(ruta + "/categories_queries.properties"));
        db = DBConnect.getInstance(); //es como llamar al constructor de DBConnect
    }

    public String getQuery(String queryName) {
        return queries.getProperty(queryName);
    }

    public List<Category> listAll() throws SQLException {
        List<Category> lista = new ArrayList<>();
        //Connection conn=null;
        //Statement st;
        try (
                Connection conn = db.getConnection();
                Statement st = conn.createStatement();) {
            //conn=db.getConnection();
            //st =  conn.createStatement();
            ResultSet rs = st.executeQuery(getQuery("FIND_ALL"));
            while (rs.next()) {
                Category cat = new Category(rs.getInt("id_category"), rs.getString("description"));
                lista.add(cat);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }

        return lista;
    }

    public int insert(Category cat) {
        int rowsAffected;

        try (Connection conn = db.getConnection();
                PreparedStatement pst = conn.prepareStatement(getQuery("INSERT"));) {
            pst.setString(1, cat.getDescription());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }

        return rowsAffected;
    }
}
