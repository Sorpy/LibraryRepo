package business.converter;

import business.converter.common.SkipField;

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
