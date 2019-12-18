package application.business.processor.orderprocessor;

import application.business.converter.order.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Order;
import application.dataaccess.dao.orderdao.OrderDao;
import application.dataaccess.dao.orderdao.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderProcessorImpl extends BaseProcessorImpl<OrderParam,Order, OrderResult, Long, OrderDao, OrderParamConverter,OrderResultConverter>
        implements OrderProcessor{

}
