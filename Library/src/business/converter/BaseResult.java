package business.converter;

import business.converter.common.customannotation.SkipField;

public class BaseResult {
    @SkipField
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
