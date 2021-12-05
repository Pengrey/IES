package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Quote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote,Integer> {
    List<Quote> findByMovie(Movie movie);
}
