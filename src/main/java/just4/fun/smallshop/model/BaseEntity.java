package just4.fun.smallshop.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Vitaliy_Zinchenko on 30.01.2015.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    protected Long id;

    protected BaseEntity() {
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
