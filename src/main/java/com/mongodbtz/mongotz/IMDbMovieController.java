package com.mongodbtz.mongotz;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/imdbMovie")
public class IMDbMovieController {
    @Autowired
    private IMDbMovieRepository imDbMovieRepository;

    @Autowired
    private ImDbMovieService imDbMovieService; //private IMDbMovie imDbMovie;

    private final MongoTemplate imdbTemplate;

    private static final Logger logger = LogManager.getLogger(IMDbMovieController.class);

    public IMDbMovieController(MongoTemplate imdbTemplate) {
        this.imdbTemplate = imdbTemplate;
    }

    @PostMapping("/addMovie")
    public IMDbMovie addMovie(@RequestBody IMDbMovie movie) {
        return imDbMovieRepository.save(movie);
    }

    @PutMapping("/updateMovie/{_id}")
    public ResponseEntity<String> updateIMDbMovie(@PathVariable String _id,@RequestBody IMDbMovieSummaryDto summaryText){
        imDbMovieRepository.findMovieByImdbId(_id, summaryText.getSummaryText());
        return ResponseEntity.ok("Update Successfully Successfully");
    }

    @GetMapping("/getAllMovies")
    public List<IMDbMovie> getAllMovies(){
        return imDbMovieRepository.findAll();
    }
    
    @GetMapping("/getMovie/{_id}")
    public Optional<IMDbMovie> getMovieById(@PathVariable("_id") String _id) {
        return imDbMovieRepository.findById(_id);
    }

    @GetMapping("/getMovieByTitle/{name}")
    public ResponseEntity<List<IMDbMovie>> findItemByTitle(@PathVariable("name") String name){
        List<IMDbMovie> imdbMovies;
        //String stringRegex = "{ name : { $regex : '" + name + "', $options: 'i' } }";
        //BasicQuery basicQuery = new BasicQuery(stringRegex);
        //imdbMovies = imdbTemplate.find(basicQuery, IMDbMovie.class);
        imdbMovies = imDbMovieService.findMovieByTitle(name);
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
        imdbMovies = imDbMovieService.findMovieByYear(year);
        return ResponseEntity.ok(imdbMovies);
    }


    @GetMapping("/getMovieByGenre/{genre}")
    public ResponseEntity<List<IMDbMovie>> findMovieByGenre(@PathVariable("genre") String genre){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieService.findMovieByGenre(genre);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByDirector/{director}")
    public ResponseEntity<List<IMDbMovie>> findMovieByDirector(@PathVariable("director") String director){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieService.findMovieByDirector(director);
        return ResponseEntity.ok(imdbMovies);
    }

    @GetMapping("/getMovieByCast/{cast}")
    public ResponseEntity<List<IMDbMovie>> findMovieByCastLike(@PathVariable("cast") String cast){
        List<IMDbMovie> imdbMovies;
        imdbMovies = imDbMovieService.findMovieByCast(cast);
        return ResponseEntity.ok(imdbMovies);
    }

}
