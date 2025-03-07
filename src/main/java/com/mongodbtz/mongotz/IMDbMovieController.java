package com.mongodbtz.mongotz;
import java.util.List;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.mongodb.core.MongoTemplate;

@RestController
@RequestMapping("/api/imdbMovie")
public class IMDbMovieController {
    @Autowired
    private IMDbMovieRepository imDbMovieRepository;

    private final MongoTemplate imdbTemplate;

    public IMDbMovieController(MongoTemplate imdbTemplate) {
        this.imdbTemplate = imdbTemplate;
    }

    @PostMapping("/addMovie")
    public IMDbMovie addMovie(@RequestBody IMDbMovie movie) {
        return imDbMovieRepository.save(movie);
    }

    @GetMapping("/getAllMovies")
    public List<IMDbMovie> getAllMovies(){
        return imDbMovieRepository.findAll();
    }

    @GetMapping("/getMovieByTitle/{name}")
    public ResponseEntity<List<IMDbMovie>> findItemByTitle(@PathVariable("name") String name){
        List<IMDbMovie> imdbMovies;
        String stringRegex = "{ name : { $regex : '" + name + "' } }";
        BasicQuery basicQuery = new BasicQuery(stringRegex);
        imdbMovies = imdbTemplate.find(basicQuery, IMDbMovie.class);
        System.out.println(imdbMovies);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByYearAndGenre")
    public ResponseEntity<List<IMDbMovie>> findMovieByYearAndGenre (@RequestParam(required = false,value="year") String year,
                                                                    @RequestParam(required = false,value="genre") String genre)
    {
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieRepository.findMovieByYearAndGenre(year,genre);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByYear/{year}")
    public ResponseEntity<List<IMDbMovie>> findMovieByYearLike(@PathVariable("year") String year){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieRepository.findMovieByYearLike(year);
        return ResponseEntity.ok(imdbMovies);
    }
}
