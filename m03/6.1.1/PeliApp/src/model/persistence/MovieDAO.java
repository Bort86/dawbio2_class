package model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Movie;
import model.Screen;

/**
 *
 * @author Pablo Rodriguez
 */
public class MovieDAO {

    private final String QUERY_FIND_BY_GENRE = "select * from movies where genre like ?";
    private final String QUERY_FIND_BY_AGE = "select * from movies where age like?";
    private final String QUERY_INSERT = "INSERT INTO movies (title, length, country, genre, age, rating, sinopsis) VALUES (?, ?, ?, ?,? ,? ,?)";
    private final String QUERY_UPDATE = "UPDATE movies SET title=?, length=?, country=?, genre=?, age=?, rating=?, sinopsis=? WHERE id=?";
    private final String QUERY_DELETE = "DELETE FROM movies WHERE id=?";
    private final String QUERY_LIST = "select * FROM movies";
    private final String QUERY_FIND_BY_ID = "select * FROM movies where id=?";
    private final String QUERY_LIST_SCREEN = "select * FROM sales";
    private final String QUERY_FIND_SCREEN = "select * FROM sales where idPelicula=?";
    private final String QUERY_FIND_SCREEN_ID = "select * FROM sales where idSala=?";
    private final String QUERY_UPDATE_SCREEN = "UPDATE sales SET idPelicula=? WHERE idSala=?";

    public int insert(Movie m) throws ClassNotFoundException {
        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement(QUERY_INSERT);

                pst.setString(1, m.getTitle());
                pst.setInt(2, m.getLength());
                pst.setString(3, m.getCountry());
                pst.setString(4, m.getGenre());
                pst.setInt(5, m.getAge());
                pst.setDouble(6, m.getRating());
                pst.setString(7, m.getSinopsis());

                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;

        }

        return rowsAffected;
    }

    public int delete(Movie m) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(QUERY_DELETE);
                pst.setLong(1, m.getId());
                rowsAffected = pst.executeUpdate();
            }

        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    public int update(Movie m) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement(QUERY_UPDATE);

                pst.setString(1, m.getTitle());
                pst.setInt(2, m.getLength());
                pst.setString(3, m.getCountry());
                pst.setString(4, m.getGenre());
                pst.setInt(5, m.getAge());
                pst.setDouble(6, m.getRating());
                pst.setString(7, m.getSinopsis());
                pst.setInt(8, m.getId());

                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    public List<Movie> listAll() throws SQLException, ClassNotFoundException {
        List<Movie> result = new ArrayList<>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_LIST);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Movie movie = new Movie();
                    movie.setId(res.getInt("id"));
                    movie.setTitle(res.getString("title"));
                    movie.setLength(res.getInt("length"));
                    movie.setCountry(res.getString("country"));
                    movie.setGenre(res.getString("genre"));
                    movie.setAge(res.getInt("age"));
                    movie.setRating(res.getDouble("rating"));
                    movie.setSinopsis(res.getString("sinopsis"));

                    result.add(movie);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public List<Movie> findByGenre(String genre) throws ClassNotFoundException {
        List<Movie> result = new ArrayList<>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_GENRE);
                st.setString(1, "%" + genre + "%");
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Movie movie = new Movie();
                    movie.setId(res.getInt("id"));
                    movie.setTitle(res.getString("title"));
                    movie.setLength(res.getInt("length"));
                    movie.setCountry(res.getString("country"));
                    movie.setGenre(res.getString("genre"));
                    movie.setAge(res.getInt("age"));
                    movie.setRating(res.getDouble("rating"));
                    movie.setSinopsis(res.getString("sinopsis"));

                    result.add(movie);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public List<Movie> findByAge(String age) throws ClassNotFoundException {
        List<Movie> result = new ArrayList<>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_AGE);
                st.setString(1, "%" + age + "%");
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Movie movie = new Movie();
                    movie.setId(res.getInt("id"));
                    movie.setTitle(res.getString("title"));
                    movie.setLength(res.getInt("length"));
                    movie.setCountry(res.getString("country"));
                    movie.setGenre(res.getString("genre"));
                    movie.setAge(res.getInt("age"));
                    movie.setRating(res.getDouble("rating"));
                    movie.setSinopsis(res.getString("sinopsis"));

                    result.add(movie);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public Movie findById(int id) throws ClassNotFoundException {
        Movie m = null;

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
                m = resultsetToFriend(rs);
            }
        } catch (SQLException e) {
            m = null;
        }
        return m;
    }

    private Movie resultsetToFriend(ResultSet rs) throws SQLException {
        Movie m = null;
        int id = rs.getInt("id");
        String title = rs.getString("title");
        int length = rs.getInt("length");
        String country = rs.getString("country");
        String genre = rs.getString("genre");
        int age = rs.getInt("age");
        double rating = rs.getDouble("rating");
        String sinopsis = rs.getString("sinopsis");
        m = new Movie(id, title, length, country, genre, age, rating, sinopsis);
        return m;
    }

    public List<Screen> findScreenByMovie(String id) throws ClassNotFoundException {
        List<Screen> result = new ArrayList<>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_SCREEN);
                st.setString(1, id);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Screen screen = new Screen();
                    Movie movie = new Movie();
                    screen.setIdSala(res.getInt("idSala"));
                    movie = this.findById(res.getInt("idPelicula"));
                    screen.setMovie(movie);
                    screen.setNumButques(res.getInt("numButaques"));
                    result.add(screen);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public List<Screen> listAllScreen() throws SQLException, ClassNotFoundException {
        List<Screen> result = new ArrayList<>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_LIST_SCREEN);
                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Screen screen = new Screen();
                    Movie movie = new Movie();
                    screen.setIdSala(res.getInt("idSala"));
                    int id = res.getInt("idPelicula");
                    if (id == 0) {
                        screen.setMovie(movie);
                    } else {
                        movie = this.findById(res.getInt("idPelicula"));
                        screen.setMovie(movie);
                    }
                    screen.setNumButques(res.getInt("numButaques"));
                    result.add(screen);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    public Screen findScreenById(String id) throws ClassNotFoundException {
        Screen s = null;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_SCREEN_ID);
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                s = resultsetToScreen(rs);
            }
        } catch (SQLException e) {
            s = null;
        }
        return s;
    }

    private Screen resultsetToScreen(ResultSet rs) throws SQLException, ClassNotFoundException {
        Screen m = null;
        int idSala = rs.getInt("idSala");
        int idPelicula = rs.getInt("idPelicula");
        int numButaques = rs.getInt("numButaques");
        Movie movie = new Movie();
        movie = this.findById(idPelicula);
        m = new Screen(idSala, movie, numButaques);
        return m;
    }

    public int updateScreen(Screen s) throws ClassNotFoundException {
        int rowsAffected = 0;
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(QUERY_UPDATE_SCREEN);
                pst.setInt(1, s.getMovie().getId());
                pst.setInt(2, s.getIdSala());
                rowsAffected = pst.executeUpdate();
            }
        } catch (SQLException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

}
