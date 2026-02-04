package com.mongodbtz.mongotz;

import org.springframework.data.domain.Sort;
import java.util.List;

public class IMDbMovieRepositoryImpl {
    private IMDbMovieRepository imDbMovieRepository;

    public List<IMDbMovie> SortedByFieldAsc() {
        return imDbMovieRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
