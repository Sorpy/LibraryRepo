package business.converter;

import business.converter.common.SkipField;

public class BaseParam {
    @SkipField
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

