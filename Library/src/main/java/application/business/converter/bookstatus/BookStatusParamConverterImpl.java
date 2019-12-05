package application.business.converter.bookstatus;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookStatusParamConverterImpl extends BaseParamConverterImpl<BookStatusParam,BookStatus> implements BookStatusParamConverter {


        @Override
        public BookStatus convert(BookStatusParam param, BookStatus oldEntity) {
            BookStatus entity = null;
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
                entity = new BookStatus();
                entity.setId(param.getId());
                //entity.setCode(param.getUnicode());
            }
            entity = convertStandart(param, entity);
            return entity;
        }

    @Override
    public BookStatus convertSpecific(BookStatusParam param, BookStatus entity) {
        return null;
    }
}
