package com.mongodbtz.mongotz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;
public interface IMDbMovieRepository extends MongoRepository<IMDbMovie,String>{
    @Query("{ year: ?0, genre: ?1 }")
    List<IMDbMovie> findMovieByYearAndGenre(String year,String genre);

    List<IMDbMovie> findMovieByYear(String year);

    List<IMDbMovie> findMovieByCastNameLike(Object cast);

    List<IMDbMovie> findMovieByGenre(String genre);

    List<IMDbMovie> findMovieByDirectorLike(String director);

    @Query("{'_id' : ?0}")
    @Update("{ '$set' : { 'summary_text' : ?1 } }")
    void findMovieByImdbId(String _id, String summaryText);

}
