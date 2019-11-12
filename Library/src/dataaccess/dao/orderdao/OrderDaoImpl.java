package dataaccess.dao.orderdao;

import data.entity.Order;

import java.util.List;

import static dataaccess.dao.orderdao.OrderData.*;

public class OrderDaoImpl implements OrderDao{
    @Override
    public Order save(Order entity) {
        orderMap.putIfAbsent(entity.getId(), entity);
        orders.add(entity);

        return entity;
    }

    @Override
    public List<Order> save (List<Order> entity) {
        orders.addAll(entity);
        return entity;
    }

    @Override
    public Order update(Order entity) {
        delete(entity.getId());
        orders.add(entity);
        return entity;
    }

    @Override
    public List<Order> update(List<Order> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Order removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Order entity) {
        orders.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Order> find() {
        return orders;
    }

    @Override
    public Order find(Long id) {
        return orders
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
