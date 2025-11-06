package com.mongodbtz.mongotz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface IMDbMovieRepository extends MongoRepository<IMDbMovie,String>{
    @Query("{ year: ?0, genre: ?1 }")
    List<IMDbMovie> findMovieByYearAndGenre(String year,String genre);

    List<IMDbMovie> findMovieByYearLike(String year);

    List<IMDbMovie> findMovieByCastName(Object cast);

    List<IMDbMovie> findMovieByGenre(String genre);

    List<IMDbMovie> findMovieByDirectorLike(String director);
}
