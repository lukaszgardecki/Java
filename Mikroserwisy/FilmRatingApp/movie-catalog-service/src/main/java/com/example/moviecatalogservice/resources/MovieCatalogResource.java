package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;
    private final DiscoveryClient discoveryClient;

    public MovieCatalogResource(RestTemplate restTemplate, WebClient.Builder webClientBuilder, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
        this.discoveryClient = discoveryClient;
    }


    @RequestMapping("/{userId}")
    @CircuitBreaker(name = "ratingssss", fallbackMethod = "getFallbackCatalog")
    public CompletableFuture<List<CatalogItem>>  getCatalog(@PathVariable String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);


        return CompletableFuture.supplyAsync(() -> ratings.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

                        /*
                        Alternative WebClient way
                        Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
                        .retrieve().bodyToMono(Movie.class).block();
                        */
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .toList());
    }

    public CompletableFuture<List<CatalogItem>> getFallbackCatalog(String userId, Exception Exception) {
        return CompletableFuture.supplyAsync(()-> Arrays.asList(new CatalogItem("No movie", "", 0)));
    }
}
