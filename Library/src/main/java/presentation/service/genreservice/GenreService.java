package presentation.service.genreservice;

import business.converter.genre.GenreParam;
import data.common.APIResponse;

import java.util.List;

public interface GenreService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(GenreParam param);
    APIResponse create(List<GenreParam> param);

    APIResponse update(long id, GenreParam param);
    APIResponse update(List<GenreParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(GenreParam param);
    void validateParameters(List<GenreParam> param);
}
