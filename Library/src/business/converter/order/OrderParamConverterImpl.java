package business.converter.order;

import data.entity.Order;
import dataaccess.dao.accountclientdao.AccountClientDao;
import dataaccess.dao.accountclientdao.AccountClientDaoImpl;
import dataaccess.dao.accountlibrariandao.AccountLibrarianDao;
import dataaccess.dao.accountlibrariandao.AccountLibrarianDaoImpl;
import dataaccess.dao.bookdao.BookDao;
import dataaccess.dao.bookdao.BookDaoImpl;

public class OrderParamConverterImpl implements OrderParamConverter{
    private AccountClientDao accountClientDao = new AccountClientDaoImpl();
    private AccountLibrarianDao accountLibrarianDao = new AccountLibrarianDaoImpl();
    private BookDao bookDao = new BookDaoImpl();



    @Override
    public Order convert(OrderParam param, Order oldEntity){
        Order entity = null;
        if(oldEntity!=null){
            entity = oldEntity;
        } else {
            entity = new Order();
            entity.setId(param.getId());
            entity.setCode(param.getCode());
        }
        entity.setName(param.getName());
        entity.setDescription(param.getDescription());
        entity.setAccountClient(accountClientDao.find(param.getAccountClientId()));
        entity.setAccountLibrarian(accountLibrarianDao.find(param.getAccountLibrarianId()));
        entity.setBook(bookDao.find(param.getBookId()));
        entity.setDate(param.getDate());
        return entity;
    }
}
