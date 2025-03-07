package com.mongodbtz.mongotz;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("ImdbMovies")
public class IMDbMovie {

    @Getter
    protected static class Cast {
        private final String name;
        public Cast(String name) {
            this.name = name;
        }
    }

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
    @Field(value="director.name")
    private String director;
    @Field(value="cast")
    private ArrayList<Cast> cast;
}
