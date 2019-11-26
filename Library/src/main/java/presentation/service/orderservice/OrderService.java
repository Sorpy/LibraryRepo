package presentation.service.orderservice;

import business.converter.order.OrderParam;
import data.common.APIResponse;

import java.util.List;

public interface OrderService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(OrderParam param);
    APIResponse create(List<OrderParam> param);

    APIResponse update(long id, OrderParam param);
    APIResponse update(List<OrderParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(OrderParam param);
    void validateParameters(List<OrderParam> param);
}
