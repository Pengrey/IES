package com.example.demo.service;

import com.example.demo.entity.Quote;
import com.example.demo.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository repository;

    public Quote saveQuote(Quote Quote) {
        return repository.save(Quote);
    }

    public List<Quote> saveQuotes(List<Quote> Quotes) {
        return repository.saveAll(Quotes);
    }

    public List<Quote> getQuotes() {
        return repository.findAll();
    }

    public Quote getQuoteById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteQuote(int id) {
        repository.deleteById(id);
        return "Quote removed !! " + id;
    }

    public Quote updateQuote(Quote Quote) {
        Quote existingQuote = repository.findById(Quote.getId()).orElse(null);
        existingQuote.setQuote(Quote.getQuote());
        existingQuote.setMovie(Quote.getMovie());
        return repository.save(existingQuote);
    }
}
