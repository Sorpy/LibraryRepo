package business.converter.author;

import business.converter.BaseNamedResult;

public class AuthorResult extends BaseNamedResult {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
