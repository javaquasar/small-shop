package just4.fun.smallshop.model;

import javax.persistence.*;

@Entity
@Table(name = "attribute_type")
public class AttributeType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING) //TODO | try to don't save string
    private AttributeValueType type;

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
}
