package com.mongodbtz.mongotz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class IMDbMovieRepositoryImpl {
    @Autowired
    MongoTemplate mongoTemplate;
    public void updateImdbMovie(String name, float newQuantity) {
    }
}
