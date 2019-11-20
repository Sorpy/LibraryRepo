package business.converter.order;

import business.converter.common.BaseParamConverter;
import data.entity.Order;

public interface OrderParamConverter extends BaseParamConverter<OrderParam,Order> {
    Order convert(OrderParam param, Order oldEntity);
}
