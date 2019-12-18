package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

@Component
public class Author extends PersistentNamed {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
