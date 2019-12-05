package application.business.converter.author;

import application.business.converter.BaseNamedParam;
import org.springframework.stereotype.Component;

@Component
public class AuthorParam  extends BaseNamedParam {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
