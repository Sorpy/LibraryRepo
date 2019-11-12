package business.converter.bookstatus;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.BookStatus;

public class BookStatusParamConverterImpl extends BaseParamConverterImpl<BookStatusParam,BookStatus> implements BookStatusParamConverter {


        @Override
        public BookStatus convert(BookStatusParam param, BookStatus oldEntity){
            BookStatus entity = null;
            if(oldEntity!=null)
            {
                if(param.getId().equals(oldEntity.getId())&& param.getCode().equals(oldEntity.getCode())){
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
                entity = new BookStatus();
                entity.setId(param.getId());
                entity.setCode(param.getCode());
            }
            entity = convertStandart(param,entity);
            return entity;
        }

    @Override
    public BookStatus convertSpecific(BookStatusParam param, BookStatus entity) {
        return null;
    }
}
