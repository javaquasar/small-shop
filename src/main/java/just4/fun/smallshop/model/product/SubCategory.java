package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zinchenko on 24.02.15.
 */
@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity {

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "sub_category_attribute_type",
        joinColumns = @JoinColumn(name = "sub_category_id"),
        inverseJoinColumns = @JoinColumn(name = "attribute_type_id")
    )
    private List<AttributeType> attributeTypes;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<AttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(List<AttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }
}
