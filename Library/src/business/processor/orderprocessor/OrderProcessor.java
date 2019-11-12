package business.processor.orderprocessor;

import business.converter.order.OrderParam;
import business.converter.order.OrderResult;

import java.util.List;

public interface OrderProcessor {
    OrderResult create(OrderParam param);
    List<OrderResult> create(List<OrderParam> param);

    void update(Long id,OrderParam param);
    void update(List<OrderParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    OrderResult find(Long id);
    List<OrderResult> find();
}
