package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
@Component
public class Order extends PersistentNamed {
    @Column
    private Date date;
    @OneToOne
    @JoinColumn(name = "accountClient_id")
    private Account accountClient;
    @OneToOne
    @JoinColumn(name = "accountLibrarian_id")
    private Account accountLibrarian;
    @OneToOne
    @JoinColumn(name = "book_id")
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
