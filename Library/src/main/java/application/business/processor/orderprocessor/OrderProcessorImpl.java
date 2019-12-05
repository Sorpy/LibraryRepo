package application.business.processor.orderprocessor;

import application.business.converter.order.*;
import application.data.entity.Order;
import application.dataaccess.dao.orderdao.OrderDao;
import application.dataaccess.dao.orderdao.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderProcessorImpl implements OrderProcessor{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderParamConverter orderParamConverter;
    @Autowired
    private OrderResultConverter orderResultConverter;

    @Override
    public OrderResult create(OrderParam param) {
        return orderResultConverter
                .convert(orderDao
                        .save(orderParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<OrderResult> create(List<OrderParam> param) {
        List<Order> orders = new ArrayList<>();
        List<OrderResult> orderResults = new ArrayList<>();

        param.forEach(orderParam -> orders
                .add(orderParamConverter
                        .convert(orderParam,null)));
        orderDao.save(orders);
        orders.forEach(order -> orderResults
                .add(orderResultConverter
                        .convert(order)));

        return orderResults;
    }

    @Override
    public void update(Long id, OrderParam param) {
        Order oldEntity = orderDao.find(id);
        if (oldEntity!=null){
            orderDao.update(orderParamConverter
                    .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<OrderParam> param) {
        List<Order> orders = new ArrayList<>();
        param.forEach(orderParam -> orders
                .add(orderParamConverter
                        .convert(orderParam,null)));
        orderDao.update(orders);
    }

    @Override
    public void delete(Long id) {
        orderDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        orderDao.delete(idList);
    }

    @Override
    public OrderResult find(Long id) {
        return orderResultConverter
                .convert(orderDao
                        .find(id));
    }

    @Override
    public List<OrderResult> find() {
        List<OrderResult> orderResults = new ArrayList<>();
        orderDao.find()
                .forEach(order -> orderResults
                        .add(orderResultConverter
                                .convert(order)));
        return orderResults;
    }
}
