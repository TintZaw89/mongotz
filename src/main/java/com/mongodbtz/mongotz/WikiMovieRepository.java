package com.mongodbtz.mongotz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WikiMovieRepository extends MongoRepository<WikiMovie,Integer>{

    @Query(value="{title: { $regex: /\\b?0\\b/ }}")
    List<WikiMovie> findItemByTitle(String regexTitle);

    @Query("{year:?0}")
    List<WikiMovie> findItemByYear(Integer year);

    @Query("{ genres: ['?0'] }")
    List<WikiMovie> findItemByGenres(String genres);

    @Query("{ cast: ['?0'] }")
    List<WikiMovie> findItemByCast(String cast);

    @Query("{ year: ?0, genres: ?1 }")
    List<WikiMovie> findMovieByYearAndGenres(Integer year,String genres);
}
