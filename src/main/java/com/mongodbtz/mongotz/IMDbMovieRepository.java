package com.mongodbtz.mongotz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface IMDbMovieRepository extends MongoRepository<IMDbMovie,String>{
    @Query("{ year: ?0, genres: ?1 }")
    List<IMDbMovie> findMovieByYearAndGenre(String year,String genres);
}
