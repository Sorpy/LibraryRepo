package application.data.entity;

import org.springframework.stereotype.Component;

@Component
public class Persistent {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
