package dataaccess.dao.orderdao;

import data.entity.Order;
import dataaccess.dao.accountclientdao.AccountClientData;
import dataaccess.dao.accountlibrariandao.AccountLibrarianData;
import dataaccess.dao.bookdao.BookData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderData {
    public static List<Order> orders = new ArrayList<>();
    public static Map<Long,Order> orderMap;

    static{
        Order order1 = new Order();
        order1.setDate(null);
        order1.setBook(BookData.books.get(0));
        order1.setAccountLibrarian(AccountLibrarianData.accountLibrarians.get(0));
        order1.setAccountClient(AccountClientData.accountClients.get(0));
        order1.setCode("AKP78966654541s");
        order1.setDescription("asdasd");
        order1.setName("asdasdasd");
        order1.setId((long)0);

        orders.add(order1);
        orderMap = orders
                .stream()
                .collect(Collectors.toMap(Order::getId, item->item));
    }
}
