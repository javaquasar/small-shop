package just4.fun.smallshop.controllers.converters.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import just4.fun.smallshop.controllers.admin.forms.ProductForm;
import just4.fun.smallshop.controllers.converters.ProductConverter;
import just4.fun.smallshop.model.product.Attribute;
import just4.fun.smallshop.model.product.AttributeType;
import just4.fun.smallshop.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 01.02.15.
 */
@Component
public class ManualProductConverter implements ProductConverter {
    @Override
    public Product formToModel(ProductForm productForm) {
        Product product = new Product();
        product.setId(productForm.getId());
        product.setName(productForm.getTitle());
        List<Attribute> attributes = extractAttributes(productForm.getAttributes(), product);
        product.setAttributes(attributes);
        return product;
    }

    private List<Attribute> extractAttributes(List<ProductForm.AttributeFormData> attributeFormDatas, final Product product) {
        //TODO | try to use utils
        List<Attribute> attributes = new ArrayList<Attribute>();
        for (ProductForm.AttributeFormData attributeFormData: attributeFormDatas) {
            Attribute attribute = new Attribute();
            attribute.setId(attributeFormData.getId());
            attribute.setAttributeType(new AttributeType(attributeFormData.getAttributeTypeId()));
            attribute.setStringValue(attributeFormData.getValue());
//            attribute.setProduct(product);
            attributes.add(attribute);
        }
        return attributes;

//        return Lists.transform(attributeFormDatas, new Function<ProductForm.AttributeFormData, ProductAttribute>() {
//            @Override
//            public ProductAttribute apply(ProductForm.AttributeFormData attributeFormData) {
//                ProductAttribute attribute = new ProductAttribute();
//                attribute.setId(attributeFormData.getId());
//                attribute.setAttributeType(new AttributeType(attributeFormData.getAttributeTypeId()));
//                attribute.setStringValue(attributeFormData.getValue());
//                attribute.setProduct(product);
//                return attribute;
//            }
//        });
    }

    @Override
    public ProductForm modelToForm(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setTitle(product.getName());
        productForm.setAttributes(extractAttributes(product.getAttributes()));
        return productForm;
    }

    private List<ProductForm.AttributeFormData> extractAttributes(List<Attribute> attributes) {
        return Lists.transform(attributes, new Function<Attribute, ProductForm.AttributeFormData>() {
            @Override
            public ProductForm.AttributeFormData apply(Attribute attribute) {
                ProductForm.AttributeFormData attributeFormData = new ProductForm.AttributeFormData();
                attributeFormData.setId(attribute.getId());
                attributeFormData.setValue(attribute.getValueAsString());
                attributeFormData.setAttributeTypeId(attribute.getAttributeType().getId());
                return attributeFormData;
            }
        });
    }

}
