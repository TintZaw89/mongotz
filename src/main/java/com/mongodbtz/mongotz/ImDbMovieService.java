package com.mongodbtz.mongotz;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@Service
public class ImDbMovieService {
    private final IMDbMovieRepository imDbMovieRepository;

    private static final Logger logger = LogManager.getLogger(IMDbMovieController.class);

    public ImDbMovieService(IMDbMovieRepository imDbMovieRepository) {
        this.imDbMovieRepository = imDbMovieRepository;
    }

    public List<IMDbMovie> findMovieByYearAndGenre(String year,String genre) {
        return imDbMovieRepository.findMovieByYearAndGenre(year,genre);
    }

    @Cacheable(value = "cache_min_1", key = "#name")
    public List<IMDbMovie> findMovieByTitle(String name) {
        List<IMDbMovie> imDbMovies = imDbMovieRepository.findMovieByTitle(name);
        logger.info(imDbMovies);
        return imDbMovies;
    }

    @Cacheable(value = "cache_min_1", key = "#year")
    public List<IMDbMovie> findMovieByYear(String year) {
        List<IMDbMovie> imDbMovies = imDbMovieRepository.findMovieByYear(year);
        logger.info(imDbMovies);
        return imDbMovies;
    }

    @Cacheable(value = "cache_min_1", key = "#genre")
    public List<IMDbMovie> findMovieByGenre(String genre) {
        List<IMDbMovie> imDbMovies = imDbMovieRepository.findMovieByGenre(genre);
        logger.info(imDbMovies);
        return imDbMovies;
    }

    @Cacheable(value = "cache_min_1", key = "#director")
    public List<IMDbMovie> findMovieByDirector(String director) {
        List<IMDbMovie> imDbMovies = imDbMovieRepository.findMovieByDirectorLike(director);
        logger.info(imDbMovies);
        return imDbMovies;
    }

    @Cacheable(value = "cache_min_1", key = "#cast")
    public List<IMDbMovie> findMovieByCast(String cast) {
        List<IMDbMovie> imDbMovies = imDbMovieRepository.findMovieByCastName(cast);
        logger.info(imDbMovies);
        return imDbMovies;
    }
}
