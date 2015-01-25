package just4.fun.smallshop.beans;

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
    private AttributeValueType type;

}
