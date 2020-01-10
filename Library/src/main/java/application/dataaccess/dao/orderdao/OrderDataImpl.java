package application.dataaccess.dao.orderdao;

import application.data.entity.Order;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class OrderDataImpl extends BaseStorageImpl<Long, Order> implements OrderData {
    @Override
    public File getPath() {
        return new File(".\\src\\main\\java\\application\\database\\OrderJSON");
    }

    @Override
    public Long getPK(Order order) {
        return order.getId();
    }

}
