package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Quote;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;
    private QuoteRepository quoteRepository;

    public Movie saveMovie(Movie Movie) {
        return repository.save(Movie);
    }

    public List<Movie> saveMovies(List<Movie> Movies) {
        return repository.saveAll(Movies);
    }

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Movie getMovieByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Quote> findQuotesByMovie(Movie movie){
        return quoteRepository.findByMovie(movie);
    }

    public String deleteMovie(int id) {
        repository.deleteById(id);
        return "Movie removed !! " + id;
    }

    public Movie updateMovie(Movie Movie) {
        Movie existingMovie = repository.findById(Movie.getId()).orElse(null);
        existingMovie.setTitle(Movie.getTitle());
        existingMovie.setYear(Movie.getYear());
        return repository.save(existingMovie);
    }
}
