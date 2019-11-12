package business.converter.author;

import business.converter.BaseNamedParam;

public class AuthorParam  extends BaseNamedParam {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
