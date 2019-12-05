package application.business.converter.author;

import application.business.converter.BaseNamedResult;
import org.springframework.stereotype.Component;

@Component
public class AuthorResult extends BaseNamedResult {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
