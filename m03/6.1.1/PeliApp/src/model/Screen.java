/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pablo Rodriguez
 */
public class Screen {
    private int idSala;
    private Movie movie;
    private int numButques;
    
    //Constructors

    public Screen() {
    }

    public Screen(int idSala, Movie movie, int numButques) {
        this.idSala = idSala;
        this.movie = movie;
        this.numButques = numButques;
    }
    
    // getters n setters

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getNumButques() {
        return numButques;
    }

    public void setNumButques(int numButques) {
        this.numButques = numButques;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Screen other = (Screen) obj;
        if (this.idSala != other.idSala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Screen{" + "idSala=" + idSala + ", movie=" + movie.getTitle() + ", numButques=" + numButques + '}';
    }
 
}