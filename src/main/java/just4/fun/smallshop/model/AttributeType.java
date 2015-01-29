package just4.fun.smallshop.model;

import javax.persistence.*;

@Entity
@Table(name = "attribute_type")
public class AttributeType {

    @Id
    @Column(name = "attribute_type_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_type_generator")
    @SequenceGenerator(name = "attribute_type_generator", sequenceName = "attribute_type_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private AttributeValueType type;

    public AttributeType() {
    }

    public AttributeType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public AttributeType setId(Long id) {
        this.id = id;
        return this;
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
