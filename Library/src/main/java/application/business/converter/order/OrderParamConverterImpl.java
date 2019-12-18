package application.business.converter.order;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Order;
import application.dataaccess.dao.accountdao.AccountDao;
import application.dataaccess.dao.bookdao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderParamConverterImpl extends BaseParamConverterImpl<OrderParam,Order> implements OrderParamConverter{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private BookDao bookDao;



    @Override
    public void convertSpecific(OrderParam param, Order entity) {
        entity.setAccount(accountDao.find(param.getAccountClientId()));
        entity.setAccountLibrarian(accountDao.find(param.getAccountLibrarianId()));
        entity.setBook(bookDao.find(param.getBookId()));
    }

    @Override
    public Order getEntity(OrderParam param) {
        Order order = new Order();
        order.setCode(param.getCode());
        order.setId(param.getId());
        return null;
    }
}
