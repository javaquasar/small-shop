package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import just4.fun.smallshop.dao.solr.SolrConverterType;
import just4.fun.smallshop.dao.solr.converter.CategoryConverter;
import just4.fun.smallshop.dao.solr.converter.ProductConverter;
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
@SolrConverterType(core = "product", converter = ProductConverter.class)
public class Product {

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "product_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq")
    @DocumentId
    private Long id;

    @Column(name = "title")
    @Field(store = Store.YES)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_attribute")
    private List<Attribute> attributes;

    @ManyToMany
    @JoinTable(name = "category_product")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments;

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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Product setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
