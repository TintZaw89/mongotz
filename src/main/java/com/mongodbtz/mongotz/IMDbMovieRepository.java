package com.mongodbtz.mongotz;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;
public interface IMDbMovieRepository extends MongoRepository<IMDbMovie,String>{
    @Query("{ year: ?0, genre: ?1 }")
    List<IMDbMovie> findMovieByYearAndGenre(String year,String genre);

    @Query(value = "{ 'year' : ?0 }", sort = "{ 'name' : 1 }")
    List<IMDbMovie> findMovieByYear(String year);

    @Query(value= "{ name : { $regex : ?0, $options: 'i' } }", sort = "{ 'name' : 1 }")
    List<IMDbMovie> findMovieByTitle(String name);

    @Query(value= "{ 'cast.name' : { $regex : ?0, $options: 'i' } }", sort = "{ 'name' : 1 }")
    List<IMDbMovie> findMovieByCastName(String cast);

    List<IMDbMovie> findMovieByGenre(String genre);

    @Query(sort = "{ 'name' : 1 }")
    List<IMDbMovie> findMovieByDirectorLike(String director);

    @Query("{'_id' : ?0}")
    @Update("{ '$set' : { 'summary_text' : ?1 } }")
    void findMovieByImdbId(String _id, String summaryText);

}
