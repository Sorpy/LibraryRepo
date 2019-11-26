package business.converter.order;

import business.converter.common.BaseResultConverter;
import data.entity.Order;

public interface OrderResultConverter extends BaseResultConverter<Order,OrderResult> {

    OrderResult convert(Order param);
}
