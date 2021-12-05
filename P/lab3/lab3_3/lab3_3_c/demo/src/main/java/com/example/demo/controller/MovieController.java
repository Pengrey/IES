package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("")
@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }

    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        return service.saveMovies(movies);
    }

    @GetMapping("/shows")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }

    @GetMapping("/movieById/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping("/movie/{title}")
    public Movie findMovieByTitle(@PathVariable String title) {
        return service.getMovieByTitle(title);
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie) {
        return service.updateMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id) {
        return service.deleteMovie(id);
    }
}
