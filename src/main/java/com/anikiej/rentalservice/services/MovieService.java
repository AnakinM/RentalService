package com.anikiej.rentalservice.services;

import com.anikiej.rentalservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MovieService {
    private final RestTemplate restTemplate;

    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Movie> getMovie(Long id) {
        String url = String.format("http://localhost:8080/movies/%s", id);
        return Optional.ofNullable(restTemplate.getForObject(url, Movie.class));
    }

    public void returnMovie(Long id) {
        String url = String.format("http://localhost:8080/movies/%s/make-available", id);
        restTemplate.postForObject(url, null, String.class);
    }

    public void rentMovie(Long id) {
        String url = String.format("http://localhost:8080/movies/%s/rent", id);
        restTemplate.postForObject(url, null, String.class);
    }
}
