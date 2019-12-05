package application.business.processor.genreprocessor;

import application.business.converter.genre.GenreParam;
import application.business.converter.genre.GenreResult;

import java.util.List;

public interface GenreProcessor {
    GenreResult create(GenreParam param);
    List<GenreResult> create(List<GenreParam> param);

    void update(Long id,GenreParam param);
    void update(List<GenreParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    GenreResult find(Long id);
    List<GenreResult> find();
}
