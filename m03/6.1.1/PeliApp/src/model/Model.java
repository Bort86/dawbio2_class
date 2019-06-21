package model;

import model.persistence.MovieDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Rodriguez
 */
public class Model {
    
    public int addMovie ( Movie m ) throws ClassNotFoundException, SQLException {
        
        MovieDAO pd = new MovieDAO();
        int result = pd.insert(m);
        return result;
    }
    
    public int deleteMovie ( Movie m ) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        int result = pd.delete(m);
        return result;
    }
    
    public int updateMovie ( Movie m ) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        int result = pd.update(m);
        return result;
    }
    
    public List<Movie> listAll() throws SQLException, ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        List<Movie> result = pd.listAll();
        return result;
    }
    
    public List<Movie> findByGenre ( String genre ) throws ClassNotFoundException {
        
        MovieDAO pd = new MovieDAO();
        List<Movie> result = pd.findByGenre(genre);
        return result;
    }
    
    public List<Movie> findByAge ( String age ) throws ClassNotFoundException {
        
        MovieDAO pd = new MovieDAO();
        List<Movie> result = pd.findByAge(age);
        return result;
    }

    public Movie findById(int id) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        return pd.findById(id);
    }

    public List<Screen> listScreenAll() throws SQLException, ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        List<Screen> result = pd.listAllScreen();
        return result;
    }

    public List<Screen> findScreenByMovie(String id) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        List<Screen> result = pd.findScreenByMovie(id);
        return result;
    }

    public Screen findScreenById(String id) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        return pd.findScreenById(id);
    }

    public int updateScreen(Screen s) throws ClassNotFoundException {
        MovieDAO pd = new MovieDAO();
        int result = pd.updateScreen(s);
        return result;
    }

}
