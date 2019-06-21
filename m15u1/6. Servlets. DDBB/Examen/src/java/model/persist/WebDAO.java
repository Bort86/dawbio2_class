/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Web;

/**
 *
 * @author Pablo Rodriguez
 */
public class WebDAO {

    private final Properties queries;
    private static String PROPS_FILE;
    private static DBConnect dataSource;

    public WebDAO(String ruta) throws IOException, ClassNotFoundException {
        queries = new Properties();
        PROPS_FILE = ruta + "/web_queries.properties";
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

    public List<Web> findAll() {
        List<Web> list = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
                Statement st = conn.createStatement();) {
            ResultSet res = st.executeQuery(getQuery("FIND_ALL"));
            while (res.next()) {
                Web web = new Web();
                web.setCode(res.getString("code"));
                web.setDate(res.getDate("publication_date"));
                web.setTitle(res.getString("title"));
                web.setUrl(res.getString("url"));
                list.add(web);
            }
            res.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            list = new ArrayList<>();
        }

        return list;
    }
}
