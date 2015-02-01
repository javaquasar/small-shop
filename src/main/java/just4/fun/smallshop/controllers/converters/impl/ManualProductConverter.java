package just4.fun.smallshop.controllers.converters.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import just4.fun.smallshop.controllers.admin.forms.ProductForm;
import just4.fun.smallshop.controllers.converters.ProductConverter;
import just4.fun.smallshop.model.AttributeType;
import just4.fun.smallshop.model.Product;
import just4.fun.smallshop.model.ProductAttribute;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Transformer;
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
        List<ProductAttribute> attributes = extractAttributes(productForm.getAttributes(), product);
        product.setProductAttributes(attributes);
        return product;
    }

    private List<ProductAttribute> extractAttributes(List<ProductForm.AttributeFormData> attributeFormDatas, final Product product) {
        //TODO | try to use utils
        List<ProductAttribute> productAttributes = new ArrayList<ProductAttribute>();
        for (ProductForm.AttributeFormData attributeFormData: attributeFormDatas) {
            ProductAttribute attribute = new ProductAttribute();
            attribute.setId(attributeFormData.getId());
            attribute.setAttributeType(new AttributeType(attributeFormData.getAttributeTypeId()));
            attribute.setStringValue(attributeFormData.getValue());
            attribute.setProduct(product);
            productAttributes.add(attribute);
        }
        return productAttributes;

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
        productForm.setAttributes(extractAttributes(product.getProductAttributes()));
        return productForm;
    }

    private List<ProductForm.AttributeFormData> extractAttributes(List<ProductAttribute> attributes) {
        return Lists.transform(attributes, new Function<ProductAttribute, ProductForm.AttributeFormData>() {
            @Override
            public ProductForm.AttributeFormData apply(ProductAttribute attribute) {
                ProductForm.AttributeFormData attributeFormData = new ProductForm.AttributeFormData();
                attributeFormData.setId(attribute.getId());
                attributeFormData.setValue(attribute.getValueAsString());
                attributeFormData.setAttributeTypeId(attribute.getAttributeType().getId());
                return attributeFormData;
            }
        });
    }

}
