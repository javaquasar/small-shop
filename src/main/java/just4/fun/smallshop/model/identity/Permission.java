package just4.fun.smallshop.model.identity;

import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zinchenko on 27.02.15.
 */
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    private String key;

    private String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
