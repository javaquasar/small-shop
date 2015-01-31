package just4.fun.smallshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_attribute")
public class ProductAttribute extends BaseEntity {

    @Column(name = "numeric_value")
    private Integer numericValue;

    @Column(name = "string_value")
    private String stringValue;


    @ManyToOne(optional = false)
    @JoinColumn(name = "attribute_type_id")
    private AttributeType attributeType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    public String getValueAsString() {
        if(attributeType.getType() == AttributeValueType.NUMBER) {
            return numericValue.toString();
        } else if (attributeType.getType() == AttributeValueType.STRING) {
            return stringValue;
        }
        throw new IllegalStateException("The product attribute value should match with type");
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }
}
