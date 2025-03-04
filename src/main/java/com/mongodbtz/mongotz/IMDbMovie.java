package com.mongodbtz.mongotz;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("ImdbMovies")

public class IMDbMovie {
    @Id
    private String ImdbId;
    private String name;
    private String year;
    @Field(value = "runtime")
    private String runTime;
    private String [] genre;
    private String ratingValue;
    @Field(value="summary_text")
    private String summaryText;
    private String ratingCount;
    private Object director;
    private Object [] cast;

    public IMDbMovie(String name, String year, String runTime, String[] genre, String ratingValue, String summaryText, String ratingCount, Object director, Object[] cast) {
        super();
        this.name = name;
        this.year = year;
        this.runTime = runTime;
        this.genre = genre;
        this.ratingValue = ratingValue;
        this.summaryText = summaryText;
        this.ratingCount = ratingCount;
        this.director = director;
        this.cast = cast;
    }

    public String getImdbId() {
        return ImdbId;
    }

    public void setImdbId(String imdbId) {
        ImdbId = imdbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Object getDirector() {
        return director;
    }

    public void setDirector(Object director) {
        this.director = director;
    }

    public Object[] getCast() {
        return cast;
    }

    public void setCast(Object[] cast) {
        this.cast = cast;
    }
}
