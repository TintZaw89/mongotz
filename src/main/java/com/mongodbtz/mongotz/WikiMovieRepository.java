package com.mongodbtz.mongotz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WikiMovieRepository extends MongoRepository<WikiMovie,String>{
    @Query("{title:'?0'}")
    List<WikiMovie> findItemByTitle(String title);

    @Query("{year:?0}")
    List<WikiMovie> findItemByYear(Integer year);

    @Query("{ genres: ['?0'] }")
    List<WikiMovie> findItemByGenres(String genres);
}
