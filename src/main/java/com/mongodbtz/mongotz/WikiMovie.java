package com.mongodbtz.mongotz;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("WikiMovies")
public class WikiMovie {
    @Id
    private String _id;
    private String title;
    private Integer year;
    private String [] cast;
    private String [] genres;

    public WikiMovie(String title, Integer year,String[] cast,String[] genres) {
        super();
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
    }
    public String getMovieId() {
        return _id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
