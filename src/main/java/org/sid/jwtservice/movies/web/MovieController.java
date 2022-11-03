package org.sid.jwtservice.movies.web;


import org.sid.jwtservice.movies.dto.Movie;
import org.sid.jwtservice.movies.dto.MovieDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {
    @GetMapping(path="/movies")
    @PostAuthorize("hasAuthority('ADMIN')")
    Flux<MovieDto> listMovies() {
        WebClient webClient = WebClient.create("https://imdb-api.com/en/API/IMDbList/k_9vg7s2y7");

        return webClient.get()
                .uri("/ls004285275")
                .retrieve()
                .bodyToFlux(MovieDto.class);
    }
}
