package org.sid.jwtservice.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Movie {
    private String id;
    private String index;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String imDbRatingCount;
    private String description;
}
