package just4.fun.smallshop.model;

import javax.persistence.Column;

/**
 * Created by Vitaliy_Zinchenko on 30.01.2015.
 */

public abstract class BaseEntity {

    @Column(name = "id", columnDefinition = "serial")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
