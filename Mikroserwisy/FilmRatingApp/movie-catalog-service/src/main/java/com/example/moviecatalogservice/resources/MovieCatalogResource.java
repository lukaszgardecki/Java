package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.UserRating;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

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
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);


                    return new CatalogItem(movie.getName(), "Desc", rating.getRating());
                })
                .toList();
    }
}
