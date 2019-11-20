package business.converter.order;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Order;
import dataaccess.dao.accountdao.AccountDao;
import dataaccess.dao.accountdao.AccountDaoImpl;
import dataaccess.dao.bookdao.BookDao;
import dataaccess.dao.bookdao.BookDaoImpl;

public class OrderParamConverterImpl extends BaseParamConverterImpl<OrderParam,Order> implements OrderParamConverter{
    private AccountDao accountDao = new AccountDaoImpl();
    private BookDao bookDao = new BookDaoImpl();



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
