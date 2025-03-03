package com.mongodbtz.mongotz;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/wikiMovie")
public class WikiMoviesController {
    @Autowired
    private WikiMovieRepository wikiMovieRepo;

    // Save method is predefine method in Mongo Repository
    // with this method we will save user in our database
    @PostMapping("/addMovie")
    public WikiMovie addMovie(@RequestBody WikiMovie movie) {
        return wikiMovieRepo.save(movie);
    }

    // findAll method is predefine method in Mongo Repository
    // with this method we will all user that is save in our database
    @GetMapping("/getAllMovies")
    public List<WikiMovie> getAllMovies(){
        return wikiMovieRepo.findAll();
    }

    @GetMapping("/getMovieByTitle/{title}")
    public ResponseEntity<List<WikiMovie>> findItemByTitle(@PathVariable("title") String title){
        List<WikiMovie> wikiMovies;
        wikiMovies = wikiMovieRepo.findItemByTitle(title);
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
}
