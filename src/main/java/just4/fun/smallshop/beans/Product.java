package just4.fun.smallshop.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product", indexes = {

})
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductAttribute> productAttributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
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
