package business.converter.order;

import data.entity.Order;

public class OrderResultConverterImpl implements OrderResultConverter {
    @Override
    public OrderResult convert(Order param) {
        OrderResult orderResult = new OrderResult();
        orderResult.setCode(param.getCode());
        orderResult.setName(param.getName());
        orderResult.setDescription(param.getDescription());
        orderResult.setId(param.getId());
        orderResult.setAccountClientId(param.getAccountClient().getId());
        orderResult.setAccountLibrarianId(param.getAccountLibrarian().getId());
        orderResult.setBookId(param.getBook().getId());
        orderResult.setAccountClientName(param.getAccountClient().getFirstName() + " " + param.getAccountClient().getLastName());
        orderResult.setAccountLibrarianName(param.getAccountLibrarian().getFirstName() + " " + param.getAccountLibrarian().getLastName());
        orderResult.setBookName(param.getBook().getBookName());
        orderResult.setDate(param.getDate());
        return orderResult;
    }
}
