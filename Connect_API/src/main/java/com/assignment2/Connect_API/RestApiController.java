package com.assignment2.Connect_API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/movie/popular")
    public Object getMovies() {
        try {
            //replace url
            String url = "https://api.themoviedb.org/3/movie/popular?api_key=da6eed9fbc0c11298c0e198a7a0e1807";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //The response from the above API is a JSON Array, which we loop through.
            for (JsonNode rt : root) {

                System.out.println(rt);
            }

            return root;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /movie";
        }

    }

    @GetMapping("/movie/{name}")
    public Object getMovieByName(@PathVariable String name) {
        try {

            //replace url
            String url = String.format("https://api.themoviedb.org/3/search/movie?query=%s&api_key=da6eed9fbc0c11298c0e198a7a0e1807", name);


            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //The response from the above API is a JSON Array, which we loop through.
            for (JsonNode rt : root) {

                System.out.println(rt);
            }

            return root;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in //movie/{name}";
        }

    }



    @GetMapping("/movie/images")
    public Object getMovieByLanguage() {
        try {

            //replace url
            String url = "https://api.themoviedb.org/3/movie/550/images?language=en-US&include_image_language=en,null&api_key=da6eed9fbc0c11298c0e198a7a0e1807";


            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //The response from the above API is a JSON Array, which we loop through.
            for (JsonNode rt : root) {

                System.out.println(rt);
            }

            return root;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in //movie/{language}";
        }

    }
}
























