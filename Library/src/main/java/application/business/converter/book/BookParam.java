package application.business.converter.book;

import application.business.converter.basepersistent.BaseNamedParam;
import org.springframework.stereotype.Component;

@Component
public class BookParam  extends BaseNamedParam {
    private String bookName;
    private Long authorId;
    private Long genreId;
    private Long departmentId;
    private int year;
    private double price;
    private Long bookStatusId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getBookStatusId() {
        return bookStatusId;
    }

    public void setBookStatusId(Long bookStatusId) {
        this.bookStatusId = bookStatusId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

}
