package business.converter;

import business.converter.common.customannotation.Track;

public class BaseResult {
    @Track
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
