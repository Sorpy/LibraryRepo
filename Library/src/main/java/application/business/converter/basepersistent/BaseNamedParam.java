package application.business.converter.basepersistent;

import application.business.converter.common.customannotation.Track;

public class BaseNamedParam extends BaseParam{
    @Track(ignore =false,source = "code",destination = "code")
    private String code;
    private String name;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
