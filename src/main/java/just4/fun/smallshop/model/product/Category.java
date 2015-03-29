package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import just4.fun.smallshop.model.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by zinchenko on 24.02.15.
 */
@Entity
@Table(name = "category")
//@Cache(region="common", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {

    @Id
    @GeneratedValue(generator = "category_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_id_generator", sequenceName = "category_id_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Category> subCategories;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Category parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

}
