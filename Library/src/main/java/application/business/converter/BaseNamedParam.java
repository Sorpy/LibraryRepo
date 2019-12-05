package application.business.converter;

import application.business.converter.common.customannotation.Track;

public class BaseNamedParam extends BaseParam{
    @Track(ignore =false,source = "unicode",destination = "code")
    private String unicode;
    private String name;
    private String description;

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
