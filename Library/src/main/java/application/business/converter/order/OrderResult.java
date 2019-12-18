package application.business.converter.order;

import application.business.converter.basepersistent.BaseNamedResult;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class OrderResult extends BaseNamedResult {
    private Date date;
    private Long accountClientId;
    private String accountClientName;
    private Long accountLibrarianId;
    private String accountLibrarianName;
    private Long bookId;
    private String bookName;


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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAccountClientName() {
        return accountClientName;
    }

    public void setAccountClientName(String accountClientName) {
        this.accountClientName = accountClientName;
    }

    public String getAccountLibrarianName() {
        return accountLibrarianName;
    }

    public void setAccountLibrarianName(String accountLibrarianName) {
        this.accountLibrarianName = accountLibrarianName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


