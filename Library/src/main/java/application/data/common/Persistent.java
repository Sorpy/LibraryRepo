package application.data.common;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;

@Component
public abstract class Persistent {
    @Id
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
