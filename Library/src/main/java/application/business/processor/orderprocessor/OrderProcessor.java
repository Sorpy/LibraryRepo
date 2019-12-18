package application.business.processor.orderprocessor;

import application.business.converter.order.OrderParam;
import application.business.converter.order.OrderResult;
import application.business.processor.common.BaseProcessor;

import java.util.List;

public interface OrderProcessor extends BaseProcessor<OrderParam, OrderResult,Long> {

}
