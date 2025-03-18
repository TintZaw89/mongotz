package com.mongodbtz.mongotz;
import java.util.List;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/imdbMovie")
public class IMDbMovieController {
    @Autowired
    private IMDbMovieRepository imDbMovieRepository;

    private final MongoTemplate imdbTemplate;

    private static final Logger logger = LogManager.getLogger(IMDbMovieController.class);

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
        logger.info(imdbMovies);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByYearAndGenre")
    public ResponseEntity<List<IMDbMovie>> findMovieByYearAndGenre (@RequestParam(required = false,value="year") String year,
                                                                    @RequestParam(required = false,value="genre") String genre)
    {
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieRepository.findMovieByYearAndGenre(year,genre);
        logger.info(imdbMovies);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByYear/{year}")
    public ResponseEntity<List<IMDbMovie>> findMovieByYearLike(@PathVariable("year") String year){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieRepository.findMovieByYearLike(year);
        logger.info(imdbMovies);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByCast/{cast}")
    public ResponseEntity<List<IMDbMovie>> findMovieByCastLike(@PathVariable("cast") String cast){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieRepository.findMovieByCastLike(cast);
        logger.info(imdbMovies);
        return ResponseEntity.ok(imdbMovies);
    }
}
