package com.mongodbtz.mongotz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class IMDbMovieRepositoryImpl {
    //@Autowired
    private IMDbMovieRepository imDbMovieRepository;

    public List<IMDbMovie> SortedByFieldAsc() {
        return imDbMovieRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
