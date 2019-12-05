package application.business.converter.order;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderResultConverterImpl extends BaseResultConverterImpl<Order,OrderResult> implements OrderResultConverter {
    @Override
    public OrderResult convert(Order param) {
        OrderResult orderResult = new OrderResult();
        convertStandart(param,orderResult);
        convertSpecific(param,orderResult);
        return orderResult;
    }

    @Override
    public OrderResult convertSpecific(Order entity, OrderResult result) {
        result.setAccountClientId(entity.getAccountClient().getId());
        result.setAccountLibrarianId(entity.getAccountLibrarian().getId());
        result.setBookId(entity.getBook().getId());
        result.setAccountClientName(entity.getAccountClient().getFirstName() + " " + entity.getAccountClient().getLastName());
        result.setAccountLibrarianName(entity.getAccountLibrarian().getFirstName() + " " + entity.getAccountLibrarian().getLastName());
        result.setBookName(entity.getBook().getBookName());
        return result;
    }
}
