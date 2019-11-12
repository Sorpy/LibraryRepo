package dataaccess.dao.orderdao;

import data.entity.Order;

import java.util.List;

public interface OrderDao {
    Order save(Order entity);
    List<Order> save(List<Order> entity);

    Order update(Order entity);
    List<Order> update(List<Order> entity);

    void delete(Long id);
    void delete(Order entity);
    void delete(List<Long> idList);

    List<Order> find();
    Order find(Long id);
}
