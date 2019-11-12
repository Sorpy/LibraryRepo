package business.converter.order;

import data.entity.Order;

public interface OrderParamConverter {
    Order convert(OrderParam param, Order oldEntity);
}
