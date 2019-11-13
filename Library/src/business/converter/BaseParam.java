package business.converter;

import business.converter.common.customannotation.SkipField;

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

