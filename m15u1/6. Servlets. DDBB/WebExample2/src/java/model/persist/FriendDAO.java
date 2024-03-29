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

import model.Friend;

public class FriendDAO {

    private final Properties queries;
    private static String PROPS_FILE;
    private static DBConnect dataSource;

    public FriendDAO(String ruta) throws IOException, ClassNotFoundException {
        queries = new Properties();
        PROPS_FILE = ruta + "/friend_queries.properties";
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

    public int insert(Friend friend) {
        int rowsAffected = 0;
        
        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("INSERT")); )
        {
            pst.setString(1, friend.getPhone());
            pst.setString(2, friend.getName());
            pst.setInt(3, friend.getAge());
            pst.setString(4, friend.getCategoryId());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        
        return rowsAffected;
    }

    public Collection<Friend> findAll() {
        Collection<Friend> list = new ArrayList<>();
        
        try ( Connection conn = dataSource.getConnection();
              Statement st = conn.createStatement(); )
        {
            ResultSet res = st.executeQuery(getQuery("FIND_ALL"));
            while (res.next()) {
                Friend friend = new Friend();
                friend.setFriendID(res.getInt("id"));
                friend.setCategoryId(res.getString("description"));
                friend.setName(res.getString("name"));
                friend.setPhone(res.getString("phone"));
                friend.setAge(res.getInt("age"));
                
                list.add(friend);
            }
        } catch (SQLException e) {
            list = new ArrayList<>();
        }
        
        return list;
    }

    public Collection<Friend> findOne(Friend friend) {
        Collection<Friend> list = new ArrayList<>();

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement st = conn.prepareStatement(getQuery("FIND_ONE")); )
        {
            st.setInt(1, friend.getFriendID());
            ResultSet res = st.executeQuery();
            // TODO
            // list = recorrem res i l'afegim a list            
        } catch (SQLException e) {
            list = new ArrayList<>();
        }

        return list;
    }

    public int delete(Friend friend) {
        int rowsAffected;

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("DELETE")); )
        {
            pst.setInt(1, friend.getFriendID());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = -2;
        }

        return rowsAffected;
    }

    public int modify(Friend friend) {
       int rowsAffected;

        try ( Connection conn = dataSource.getConnection();
              PreparedStatement pst = conn.prepareStatement(getQuery("UPDATE")); )
        {
            pst.setString(1, friend.getName());
            pst.setString(2, friend.getPhone());
            pst.setInt(3, friend.getAge());
            pst.setString(4, friend.getCategoryId());
            pst.setInt(5, friend.getFriendID());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

}
