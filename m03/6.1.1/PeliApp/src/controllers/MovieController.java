package controllers;

import java.sql.SQLException;
import java.util.List;
import views.MovieView;
import model.Model;
import model.Movie;
import model.Screen;

/**
 *
 * @author Pablo Rodriguez
 */
public class MovieController {

    private final Model model;
    private MovieView view;

    public MovieController(Model model) throws ClassNotFoundException, SQLException {
        this.model = model;
        this.view = new MovieView(this, model);
        view.display();
    }

    public void exitApplication() {
        System.exit(0);
    }

    public void executeAction(String action) throws ClassNotFoundException, SQLException {
        switch (action) {
            case "exit":
                exitApplication();
                break;
            case "add_movie":
                addMovie();
                break;
            case "delete_movie":
                deleteMovie();
                break;
            case "update_movie":
                updateMovie();
                break;
            case "list_all":
                listAll();
                break;
            case "find_by_genre":
                findByGenre();
                break;
            case "find_by_age":
                findByAge();
                break;
            case "list_screen":
                listScreen();
                break;
            case "list_movie":
                listScreenByMovie();
                break;
            case "update_screen":
                updateScreen();
                break;
            default:
                view.showMessage("Wrong option");
                break;
        }
    }

    private void listScreen() {
        try {
            List<Screen> s = model.listScreenAll();
            if (s != null) {
                for (Screen screen : s) {
                    view.showScreenForm(screen);
                }
            } else {
                view.showMessage("There are no screens");
            }
        } catch (Exception e) {
            view.showMessage("Error reading db: " + e.getMessage());
        }
    }

    private void listScreenByMovie() throws ClassNotFoundException {
        try {
            String id = view.showInputDialog("Input movie id:");
            List<Screen> s = model.findScreenByMovie(id);
            if (s != null) {
                for (Screen screen : s) {
                    view.showScreenForm(screen);
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading id: " + nfe.getMessage());
        }
    }

    private void updateScreen() {
        try {
            String id = view.showInputDialog("Input id of screen to update:");
            Screen s = model.findScreenById(id);
            if (s != null) {
                int id_movie = Integer.parseInt(view.showInputDialog("Input new id movie:"));
                Movie movie = new Movie();
                if (id_movie == 0) {
                    movie.setId(0);
                } else { 
                    movie = model.findById(id_movie);
                }
                if (movie != null) {
                    s.setMovie(movie);
                    int resultUpdate = model.updateScreen(s);
                    if (resultUpdate != 0) {
                        view.showMessage("Screen updated ok");
                    } else {
                        view.showMessage("Screen not updated");
                    }
                } else {
                    view.showMessage("Movie not found");
                }
            } else {
                view.showMessage("Screen not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }

    private void listAll() {
        try {
            List<Movie> m = model.listAll();
            if (m != null) {
                for (Movie movie : m) {
                    view.showMovieForm(movie);
                }
            } else {
                view.showMessage("There are no movies");
            }
        } catch (Exception e) {
            view.showMessage("Error reading db: " + e.getMessage());
        }
    }

    private void addMovie() throws ClassNotFoundException, SQLException {
        try {

            String title = view.showInputDialog("Input title:");
            int length = Integer.parseInt(view.showInputDialog("Input length:"));
            String country = view.showInputDialog("Input country:");
            String genre = view.showInputDialog("Input genre:");
            int age = Integer.parseInt(view.showInputDialog("Input age:"));
            double rating = Double.parseDouble(view.showInputDialog("Input rating:"));;
            String sinopsis = view.showInputDialog("Input sinopsis:");

            Movie m = new Movie(title, length, country, genre, age, rating, sinopsis);

            int result_insert = model.addMovie(m);
            if (result_insert != 0) {
                view.showMessage("Movie inserted");
            } else {
                view.showMessage("Movie not inserted");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error :" + nfe.getMessage());
        }
    }

    private void deleteMovie() {
        try {
            int id = Integer.parseInt(view.showInputDialog("Input id to delete:"));
            Movie m = model.findById(id);
            if (m != null) {
                int resultDelete = model.deleteMovie(m);
                if (resultDelete != 0) {
                    view.showMessage("Movie deleted ok");
                } else {
                    view.showMessage("Movie not deleted");
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }

    private void updateMovie() {
        try {
            int id = Integer.parseInt(view.showInputDialog("Input id to search:"));
            Movie m = model.findById(id);
            if (m != null) {
                String title = view.showInputDialog("Input new title:");
                int length = Integer.parseInt(view.showInputDialog("Input new length:"));
                String country = view.showInputDialog("Input new country:");
                String genre = view.showInputDialog("Input new genre:");
                int age = Integer.parseInt(view.showInputDialog("Input new age:"));
                double rating = Double.parseDouble(view.showInputDialog("Input new rating:"));;
                String sinopsis = view.showInputDialog("Input new sinopsis:");

                m.setTitle(title);
                m.setLength(length);
                m.setCountry(country);
                m.setGenre(genre);
                m.setAge(age);
                m.setRating(rating);
                m.setSinopsis(sinopsis);

                int resultUpdate = model.updateMovie(m);
                if (resultUpdate != 0) {
                    view.showMessage("Movie updated ok");
                } else {
                    view.showMessage("Movie not updated");
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }

    private void findByGenre() throws ClassNotFoundException {
        try {
            String genre = view.showInputDialog("Input genre:");
            List<Movie> m = model.findByGenre(genre);
            if (m != null) {
                for (Movie movie : m) {
                    view.showMovieForm(movie);
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading genre: " + nfe.getMessage());
        }
    }

    private void findByAge() throws ClassNotFoundException {
        try {
            String age = view.showInputDialog("Input age:");
            List<Movie> m = model.findByAge(age);
            if (m != null) {
                for (Movie movie : m) {
                    view.showMovieForm(movie);
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading id: " + nfe.getMessage());
        }
    }

}
