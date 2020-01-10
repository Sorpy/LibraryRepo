package application.dataaccess.dao.orderdao;

import application.data.entity.Order;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class OrderDaoImpl extends BaseDaoFileImpl<Order, Long, OrderDataImpl>implements OrderDao{

    @Override
    public Long getPK(Order order) {
        return order.getId();
    }
}
