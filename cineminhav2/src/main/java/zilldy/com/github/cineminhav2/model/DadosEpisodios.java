package zilldy.com.github.cineminhav2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Episode")Integer numeroEp,
                             @JsonAlias("imdbRating")String avaliacao,
                             @JsonAlias("Released")String dataLancamento) {
}
