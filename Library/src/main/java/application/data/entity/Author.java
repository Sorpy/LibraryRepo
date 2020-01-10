package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity
public class Author extends PersistentNamed {
    @Column
    private String authorName;
    @Id
    public Long getId() {
        return super.getId();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
