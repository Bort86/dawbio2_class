package model.persistence;

import model.Friend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {

    private final String QUERY_FIND_BY_ID = "select * from friends where id=?";
    private final String QUERY_FIND_BY_PHONE = "select * from friends where phone=?";
    private final String QUERY_INSERT = "INSERT INTO friends (name, address, phone, age) VALUES (?, ?, ?, ?)";
    private final String QUERY_UPDATE = "UPDATE friends SET name=?, address=?, phone=?, age=? WHERE id=?";
    private final String QUERY_DELETE = "DELETE FROM friends WHERE id=?";
    
    public Friend findById(long id) throws ClassNotFoundException {
        Friend f = null;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
//                Statement st = conn.createStatement();
//                String findById ="select * from friends where id="+id;
//                ResultSet rs = st.executeQuery(findById);  
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_ID);
                st.setLong(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                f = resultsetToFriend(rs);
            }
        } catch (SQLException e) {
            f = null;
        }
        return f;
    }

    public List<Friend> findByPhone(String phone) throws ClassNotFoundException {
        List<Friend> result = new ArrayList<>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_PHONE);
                st.setString(1, phone);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Friend friend = new Friend();
                    friend.setName(res.getString("name"));
                    friend.setName(res.getString("address"));
                    friend.setPhone(res.getString("phone"));
                    friend.setAge(res.getInt("age"));

                    result.add(friend);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     * Insert()
     *
     * @param f
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int insert(Friend f) throws ClassNotFoundException, SQLException {

        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement(QUERY_INSERT);

                pst.setLong(1, f.getId());
                pst.setString(2, f.getName());
                pst.setString(3, f.getAddress());
                pst.setString(4, f.getPhone());
                pst.setInt(5, f.getAge());
                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;

        }

        return rowsAffected;
    }

    public int update(Friend f) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement(QUERY_UPDATE);

                pst.setString(1, f.getName());
                pst.setString(2, f.getAddress());
                pst.setString(3, f.getPhone());
                pst.setInt(4, f.getAge());
                pst.setLong(5, f.getId());
                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    public int delete(Friend f) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
               PreparedStatement pst = conn.prepareStatement(QUERY_DELETE);
               pst.setLong(1, f.getId());
               rowsAffected = pst.executeUpdate();
            }

        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    private Friend resultsetToFriend(ResultSet rs) throws SQLException {
        Friend f = null;
        long idf = rs.getLong("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        int age = rs.getInt("age");
        f = new Friend(idf, name, address, phone, age);
        return f;
    }

}//end of class
