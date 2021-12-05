package com.example.demo.controller;

import com.example.demo.entity.Quote;
import com.example.demo.service.MovieService;
import com.example.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    private QuoteService service;
    private MovieService movieservice;

    @PostMapping("/addQuote")
    public Quote addQuote(@RequestBody Quote quote) {
        return service.saveQuote(quote);
    }

    @PostMapping("/addQuotes")
    public List<Quote> addQuotes(@RequestBody List<Quote> quotes) {
        return service.saveQuotes(quotes);
    }

	@GetMapping("/quotes")
	public Quote quote(@RequestParam(value = "show", defaultValue = "Default value") String id) {
        Integer id_int = Integer.parseInt(id);
        List<Quote> quotes = movieservice.findQuotesByMovie(movieservice.getMovieById(id_int));
        int size = quotes.size();
        int index = (int) (Math.random() * size);
		return quotes.get(index);
    }

    @GetMapping("/allQuotes")
    public List<Quote> findAllQuotes() {
        return service.getQuotes();
    }

    @GetMapping("/quoteById/{id}")
    public Quote findQuoteById(@PathVariable int id) {
        return service.getQuoteById(id);
    }

    @GetMapping("/quote")
    public Quote findQuoteByTitle() {
        List<Quote> quotes = service.getQuotes();
        int size = quotes.size();
        int index = (int) (Math.random() * size);
        return quotes.get(index);
    }

    @PutMapping("/updateQuote")
    public Quote updateQuote(@RequestBody Quote quote) {
        return service.updateQuote(quote);
    }

    @DeleteMapping("/deleteQuote/{id}")
    public String deleteQuote(@PathVariable int id) {
        return service.deleteQuote(id);
    }
}
