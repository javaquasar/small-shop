package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zinchenko on 24.02.15.
 */
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<SubCategory> subCategories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
