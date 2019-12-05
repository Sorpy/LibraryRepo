package application.dataaccess.dao.orderdao;

import application.data.entity.Order;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderDaoImpl implements OrderDao{
    @Override
    public Order save(Order entity) {
        OrderData.orderMap.putIfAbsent(entity.getId(), entity);
        OrderData.orders.add(entity);
        BaseStorage.saveToDataSource();
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
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(Order entity) {
        OrderData.orderMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Order> find() {
        return new ArrayList<>(OrderData.orderMap.values());
    }

    @Override
    public Order find(Long id) {
        return new ArrayList<>(OrderData.orderMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
