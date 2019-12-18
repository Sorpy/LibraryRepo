package application.dataaccess.dao.orderdao;

import application.data.entity.Order;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface OrderDao extends BaseDao<Order, Long> {
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
