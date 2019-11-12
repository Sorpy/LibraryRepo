package data.entity;

import java.util.Date;

public class Order extends PersistentNamed {
    private Date date;
    private AccountClient accountClient;
    private AccountLibrarian accountLibrarian;
    private Book book;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AccountClient getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    public AccountLibrarian getAccountLibrarian() {
        return accountLibrarian;
    }

    public void setAccountLibrarian(AccountLibrarian accountLibrarian) {
        this.accountLibrarian = accountLibrarian;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
