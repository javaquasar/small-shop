package just4.fun.smallshop.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import just4.fun.smallshop.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
public class Attribute extends BaseEntity {

    @Column(name = "numeric_value")
    private Integer numericValue;

    @Column(name = "string_value")
    private String stringValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "attribute_type_id")
    @JsonBackReference
    private AttributeType attributeType;

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

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }
}
