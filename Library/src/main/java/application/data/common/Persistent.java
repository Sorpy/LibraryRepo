package application.data.common;

import javax.persistence.*;

@MappedSuperclass
public abstract class Persistent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private byte active;

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
