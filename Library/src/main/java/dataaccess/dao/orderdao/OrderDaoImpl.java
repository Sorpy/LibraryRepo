package dataaccess.dao.orderdao;

import data.entity.Order;

import java.util.ArrayList;
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
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public Order update(Order entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Order> update(List<Order> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Order removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Order entity) {
        orderMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Order> find() {
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public Order find(Long id) {
        return new ArrayList<>(orderMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
