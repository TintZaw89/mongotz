package com.mongodbtz.mongotz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImDbMovieService {
    private final IMDbMovieRepository imDbMovieRepository;

    public ImDbMovieService(IMDbMovieRepository imDbMovieRepository) {
        this.imDbMovieRepository = imDbMovieRepository;
    }

    public List<IMDbMovie> findMovieByYearAndGenre(String year,String genre) {
        return imDbMovieRepository.findMovieByYearAndGenre(year,genre);
    }


}
