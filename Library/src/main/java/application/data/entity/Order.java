package application.data.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Order extends PersistentNamed {
    private Date date;
    private Account accountClient;
    private Account accountLibrarian;
    private Book book;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccountClient() {
        return accountClient;
    }

    public void setAccount(Account accountClient) {
        this.accountClient = accountClient;
    }

    public Account getAccountLibrarian() {
        return accountLibrarian;
    }

    public void setAccountLibrarian(Account accountLibrarian) {
        this.accountLibrarian = accountLibrarian;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
