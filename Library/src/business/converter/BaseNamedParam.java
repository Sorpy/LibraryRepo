package business.converter;

import business.converter.common.customannotation.SkipField;

public class BaseNamedParam extends BaseParam{
    @SkipField
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
