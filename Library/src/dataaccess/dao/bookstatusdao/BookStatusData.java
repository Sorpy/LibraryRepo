package dataaccess.dao.bookstatusdao;

import data.entity.BookStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStatusData {

    public static List<BookStatus> bookStatuses = new ArrayList<>();
    public static Map<Long,BookStatus> bookStatusMap;
    static {
        BookStatus bookStatus1 = new BookStatus();
        bookStatus1.setCode("AKP3s");
        bookStatus1.setDescription("This is an active client account");
        bookStatus1.setName("ActiveClientStatus");
        bookStatus1.setId((long) 1);

        BookStatus bookStatus2 = new BookStatus();
        bookStatus2.setCode("AKP77s");
        bookStatus2.setDescription("This is an inactive client account");
        bookStatus2.setName("InactiveClientStatus");
        bookStatus2.setId((long) 2);

        bookStatuses.add(bookStatus1);
        bookStatuses.add(bookStatus2);

        bookStatusMap = bookStatuses
                .stream()
                .collect(Collectors.toMap(BookStatus::getId, item->item));
    }
}
