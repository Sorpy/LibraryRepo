package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity
public class AccountStatus extends PersistentNamed {
    @Id
    @Column(name = "id")
    public Long getId() {
        return super.getId();
    }
}
