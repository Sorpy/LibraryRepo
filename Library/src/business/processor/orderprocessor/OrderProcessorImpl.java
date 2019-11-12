package business.processor.orderprocessor;

import business.converter.order.*;
import data.entity.Order;
import dataaccess.dao.orderdao.OrderDao;
import dataaccess.dao.orderdao.OrderDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessorImpl implements OrderProcessor{
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderParamConverter orderParamConverter = new OrderParamConverterImpl();
    private OrderResultConverter orderResultConverter = new OrderResultConverterImpl();

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
