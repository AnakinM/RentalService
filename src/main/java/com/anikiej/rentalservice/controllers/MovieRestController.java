package com.anikiej.rentalservice.controllers;

import com.anikiej.rentalservice.models.Movie;
import com.anikiej.rentalservice.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        try {
            return movieService.getMovie(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            System.err.println("Error fetching movie: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        try {
            movieService.returnMovie(id);
            return ResponseEntity.noContent().build();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            System.err.println("Error returning movie: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        try {
            movieService.rentMovie(id);
            return ResponseEntity.noContent().build();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            System.err.println("Error renting movie: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
