package org.sid.jwtservice.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data @AllArgsConstructor @NoArgsConstructor
public class MovieDto {
    private List<Movie> items;
}
