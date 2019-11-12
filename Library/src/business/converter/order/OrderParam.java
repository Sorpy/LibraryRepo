package business.converter.order;

import business.converter.BaseNamedParam;
import data.entity.AccountClient;
import data.entity.AccountLibrarian;
import data.entity.Book;

import java.util.Date;

public class OrderParam  extends BaseNamedParam {
    private Date date;
    private Long accountClientId;
    private Long accountLibrarianId;
    private Long bookId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAccountClientId() {
        return accountClientId;
    }

    public void setAccountClientId(Long accountClientId) {
        this.accountClientId = accountClientId;
    }

    public Long getAccountLibrarianId() {
        return accountLibrarianId;
    }

    public void setAccountLibrarianId(Long accountLibrarianId) {
        this.accountLibrarianId = accountLibrarianId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
