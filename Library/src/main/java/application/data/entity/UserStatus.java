package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity
public class UserStatus extends PersistentNamed {
    @Id
    public Long getId() {
        return super.getId();
    }
}
