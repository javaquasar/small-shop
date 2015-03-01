package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attribute_type")
public class AttributeType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING) //TODO | try don't save string
    private AttributeValueType type;

    @OneToMany(mappedBy = "attributeType")
    @JsonManagedReference
    private List<Attribute> attributes;

    public AttributeType() {
    }

    public AttributeType(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public AttributeType setName(String name) {
        this.name = name;
        return this;
    }

    public AttributeValueType getType() {
        return type;
    }

    public AttributeType setType(AttributeValueType type) {
        this.type = type;
        return this;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
