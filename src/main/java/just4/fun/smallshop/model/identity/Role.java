package just4.fun.smallshop.model.identity;

import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by zinchenko on 27.02.15.
 */
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    private String title;

    @ManyToMany
    @JoinTable(name = "role_permission")
    private List<Permission> permissions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
