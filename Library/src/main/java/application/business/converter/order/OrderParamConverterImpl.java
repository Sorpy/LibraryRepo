package application.business.converter.order;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Order;
import application.dataaccess.dao.accountdao.AccountDao;
import application.dataaccess.dao.accountdao.AccountDaoImpl;
import application.dataaccess.dao.bookdao.BookDao;
import application.dataaccess.dao.bookdao.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderParamConverterImpl extends BaseParamConverterImpl<OrderParam,Order> implements OrderParamConverter{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private BookDao bookDao;



    @Override
    public Order convert(OrderParam param, Order oldEntity) {
        Order entity = null;
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
            entity = new Order();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        entity = convertSpecific(param,entity);
        return entity;
    }

    @Override
    public Order convertSpecific(OrderParam param, Order entity) {
        entity.setAccount(accountDao.find(param.getAccountClientId()));
        entity.setAccountLibrarian(accountDao.find(param.getAccountLibrarianId()));
        entity.setBook(bookDao.find(param.getBookId()));
        return entity;
    }
}
