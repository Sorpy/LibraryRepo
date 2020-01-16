package application.dataaccess.dao.orderdao;

import application.data.entity.Order;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class OrderDaoJPAImpl extends BaseDaoJPAImpl<Order,Long> implements OrderDao{
    @Override
    public Class<Order> getMyType() {
        return Order.class;
    }
}
