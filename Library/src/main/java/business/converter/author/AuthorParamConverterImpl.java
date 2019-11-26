package business.converter.author;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Author;

public class AuthorParamConverterImpl extends BaseParamConverterImpl<AuthorParam,Author> implements AuthorParamConverter{

    @Override
    public Author convert(AuthorParam param, Author oldEntity){
        Author entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())&& param.getUnicode().equals(oldEntity.getCode())){
                entity = oldEntity;
            }
            else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            entity = new Author();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        return entity;
    }

    @Override
    public Author convertSpecific(AuthorParam param, Author entity) {
        return null;
    }
}
