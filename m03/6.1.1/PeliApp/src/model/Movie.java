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
public class Movie {
    private int id;
    private String title;
    private int length ;
    private String country;
    private String genre;
    private int age;
    private double rating;
    private String sinopsis;
    
    // Constructors
    public Movie(){
        
    }

    public Movie(int id, String title, int length, String country, String genre, int age, double rating, String sinopsis) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.country = country;
        this.genre = genre;
        this.age = age;
        this.rating = rating;
        this.sinopsis = sinopsis;
    }

    public Movie(String title, int length, String country, String genre, int age, double rating, String sinopsis) {
        this.title = title;
        this.length = length;
        this.country = country;
        this.genre = genre;
        this.age = age;
        this.rating = rating;
        this.sinopsis = sinopsis;
    }
  
    public Movie(int id) {
        this.id = id;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
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
        final Movie other = (Movie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", length=" + length + ", country=" + country + ", genre=" + genre + ", age=" + age + ", rating=" + rating + ", sinopsis=" + sinopsis;
    }
}
