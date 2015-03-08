package just4.fun.smallshop.services;

import just4.fun.smallshop.api.dto.ProductSearchDto;
import just4.fun.smallshop.model.product.Product;
import zinjvi.service.Service;

import java.util.List;

/**
 * Created by zinchenko on 18.01.15.
 */
public interface ProductService extends Service<Product, Long> {

    List<Product> getBySubCategoryId(Long subCategoryId);

    List<Product> getBySubCategoryIdAndAttrValueId(Long subCategoryId, Long attributeValueId);

    List<Product> findByIds(List<Long> ids);

    List<Product> search(ProductSearchDto productSearchDto);

}
