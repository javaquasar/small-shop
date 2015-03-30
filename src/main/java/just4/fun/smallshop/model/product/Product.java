package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import just4.fun.smallshop.model.BaseEntity;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product")
@Indexed
@Analyzer(impl = org.apache.lucene.analysis.standard.StandardAnalyzer.class)
public class Product {

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    @DocumentId
    private Long id;

    @Column(name = "name")
    @Field(store = Store.YES)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_attribute")
    private List<Attribute> attributes;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Product setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        //TODO and fo all entities
        return true;
    }

    @Override
    public int hashCode() {
        //TODO
        return 0;
    }
}
