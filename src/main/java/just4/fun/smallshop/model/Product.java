package just4.fun.smallshop.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ProductAttribute> productAttributes;

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public Product setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        //TODO
        return true;
    }

    @Override
    public int hashCode() {
        //TODO
        return 0;
    }
}
