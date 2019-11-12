package business.converter.genre;

import data.entity.Genre;

public class GenreParamConverterImpl implements GenreParamConverter {

    @Override
    public Genre convert(GenreParam param, Genre oldEntity) {
        Genre entity = null;
        if (oldEntity != null) {
            entity = oldEntity;
        } else {
            entity = new Genre();
            entity.setCode(param.getCode());
            entity.setId(param.getId());
        }
        entity.setName(param.getName());
        entity.setDescription(param.getDescription());
        return entity;
    }
}
