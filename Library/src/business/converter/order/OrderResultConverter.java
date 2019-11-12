package business.converter.order;

import data.entity.Order;

public interface OrderResultConverter {

    OrderResult convert(Order param);
}
