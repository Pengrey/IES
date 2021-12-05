package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUOTES_TBL")

public class Quote {

    @Id
    @GeneratedValue
    private int id;
    private String quote;

    @ManyToOne
    Movie movie;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }

    public String getQuote(){
        return quote;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String toString() {
        return "Movie: " + getId() + 
               ", quote: " + getQuote() +
               ", movie: " + getMovie();
    }
}
