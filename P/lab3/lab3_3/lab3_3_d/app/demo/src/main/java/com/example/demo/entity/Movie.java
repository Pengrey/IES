package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVIES_TBL")
public class Movie {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int year;
    @OneToMany(mappedBy="movie")
    private List<Quote> quotes;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public String toString() {
        return "Movie: " + getId() + 
               ", title: " + getTitle() +
               ", year: " + getYear();
    }
}
