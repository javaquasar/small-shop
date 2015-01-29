package just4.fun.smallshop.controllers.admin.forms;

import just4.fun.smallshop.model.AttributeType;

import java.util.List;

/**
 * Created by zinchenko on 28.01.15.
 */
public class ProductForm {

    private String title;

    private List<AttributeFormData> attributes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AttributeFormData> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeFormData> attributes) {
        this.attributes = attributes;
    }

    public static class AttributeFormData {

        private String value;

        private Long attributeTypeId;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getAttributeTypeId() {
            return attributeTypeId;
        }

        public void setAttributeTypeId(Long attributeTypeId) {
            this.attributeTypeId = attributeTypeId;
        }
    }

}

