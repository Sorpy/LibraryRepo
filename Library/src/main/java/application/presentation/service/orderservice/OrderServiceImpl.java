package application.presentation.service.orderservice;

import application.business.converter.order.OrderParam;
import application.business.converter.order.OrderResult;
import application.business.processor.orderprocessor.OrderProcessor;
import application.presentation.service.common.BaseServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class OrderServiceImpl
        extends BaseServiceImpl<OrderParam,OrderResult,Long,OrderProcessor>
        implements OrderService{

}
