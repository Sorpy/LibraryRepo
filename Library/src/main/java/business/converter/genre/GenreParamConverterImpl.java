package business.converter.genre;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Genre;

public class GenreParamConverterImpl extends BaseParamConverterImpl<GenreParam,Genre> implements GenreParamConverter {

    @Override
    public Genre convert(GenreParam param, Genre oldEntity) {
        Genre entity = null;
        if (oldEntity != null) {
            if (param.getId().equals(oldEntity.getId()) && param.getUnicode().equals(oldEntity.getCode())) {
                entity = oldEntity;
            } else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        } else {
            entity = new Genre();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        return entity;
    }

    @Override
    public Genre convertSpecific(GenreParam param, Genre entity) {
        return null;
    }
}