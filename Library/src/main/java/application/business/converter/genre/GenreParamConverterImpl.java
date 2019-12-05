package application.business.converter.genre;

import application.data.entity.Genre;
import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class GenreParamConverterImpl extends BaseParamConverterImpl<GenreParam, Genre> implements GenreParamConverter {

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