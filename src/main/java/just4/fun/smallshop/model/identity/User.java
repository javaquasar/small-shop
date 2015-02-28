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
@Table(name = "user_info")
public class User extends BaseEntity {

    private String email;

    @ManyToMany
    @JoinTable(name = "user_permission")
    private List<Permission> permissions;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
