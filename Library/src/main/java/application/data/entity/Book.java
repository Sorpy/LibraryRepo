package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Book extends PersistentNamed {
    @Column
    private String bookName;
    @OneToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;
    @OneToOne
    @JoinColumn(name = "genre_id",nullable = false)
    private Genre genre;
    @OneToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;
    @Column
    private int year;
    @Column
    private double price;
    @OneToOne
    @JoinColumn(name = "bookStatus_id",nullable = false)
    private BookStatus bookStatus;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

}
