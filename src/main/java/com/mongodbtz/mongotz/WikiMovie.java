package com.mongodbtz.mongotz;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("WikiMovies")
public class WikiMovie {
    @Id
    private String _id;
    private String title;
    private Integer year;
    private String[] cast;
    private String[] genres;

    public WikiMovie(String title, Integer year, String[] cast, String[] genres) {
        super();
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
    }

    public String getMovieId() {
        return _id;
    }
}