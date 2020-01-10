package application.business.processor.orderprocessor;

import application.business.converter.order.OrderParam;
import application.business.converter.order.OrderParamConverter;
import application.business.converter.order.OrderResult;
import application.business.converter.order.OrderResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Order;
import application.dataaccess.dao.orderdao.OrderDao;
import org.springframework.stereotype.Component;
@Component
public class OrderProcessorImpl extends BaseProcessorImpl<OrderParam,Order, OrderResult, Long, OrderDao, OrderParamConverter,OrderResultConverter>
        implements OrderProcessor{

    @Override
    public Long getPK(OrderParam ent) {
        return  ent.getId();

    }
}
