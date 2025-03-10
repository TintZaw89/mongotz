package com.mongodbtz.mongotz;

import java.util.List;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.mongodb.core.MongoTemplate;

@RestController
@RequestMapping("/api/wikiMovie")
public class WikiMoviesController {
    @Autowired
    private WikiMovieRepository wikiMovieRepo;
    private final MongoTemplate mongoTemplate;

    public WikiMoviesController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/addMovie")
    public WikiMovie addMovie(@RequestBody WikiMovie movie) {
        return wikiMovieRepo.save(movie);
    }

    @GetMapping("/getAllMovies")
    public List<WikiMovie> getAllMovies(){
        return wikiMovieRepo.findAll();
    }

    @GetMapping("/getMovieByTitle/{title}")
    public ResponseEntity<List<WikiMovie>> findItemByTitle(@PathVariable("title") String title){
        List<WikiMovie> wikiMovies;
        String stringRegex = "{ title : { $regex : '" + title + "' } }";
        BasicQuery basicQuery = new BasicQuery(stringRegex);
        wikiMovies = mongoTemplate.find(basicQuery, com.mongodbtz.mongotz.WikiMovie.class);
        System.out.println(wikiMovies);
        //wikiMovies = wikiMovieRepo.findItemByTitle(title);
        return ResponseEntity.ok(wikiMovies);
    }

    @GetMapping("/getMovieByYear/{year}")
    public ResponseEntity<List<WikiMovie>> findItemByYear(@PathVariable("year") Integer year){
        List<WikiMovie> wikiMovies;
        wikiMovies = wikiMovieRepo.findItemByYear(year);
        return ResponseEntity.ok(wikiMovies);
    }

    @GetMapping("/getMovieByGenres/{genres}")
    public ResponseEntity<List<WikiMovie>> findItemByGenres(@PathVariable("genres") String genres){
        List<WikiMovie> wikiMovies;
        wikiMovies = wikiMovieRepo.findItemByGenres(genres);
        return ResponseEntity.ok(wikiMovies);
    }

    @GetMapping("/getMovieByCast/{cast}")
    public ResponseEntity<List<WikiMovie>> findItemByCast(@PathVariable("cast") String cast){
        List<WikiMovie> wikiMovies;
        wikiMovies = wikiMovieRepo.findItemByCast(cast);
        return ResponseEntity.ok(wikiMovies);
    }

    @GetMapping("/getMovieByYearAndGenres")
    public ResponseEntity<List<WikiMovie>> findMovieByYearAndGenres
            (@RequestParam(required = false,value="year") Integer year,
             @RequestParam(required = false,value="genres") String genres){
        List<WikiMovie> wikiMovies;
        wikiMovies = wikiMovieRepo.findMovieByYearAndGenres(year,genres);
        return ResponseEntity.ok(wikiMovies);
    }
}
