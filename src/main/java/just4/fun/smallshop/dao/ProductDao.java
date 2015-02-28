package just4.fun.smallshop.dao;

import just4.fun.smallshop.model.product.Product;
import zinjvi.repository.Repository;

import java.util.List;

/**
 * Created by zinchenko on 21.01.15.
 */
public interface ProductDao extends Repository<Product, Long> {

    List<Product> getBySubCategoryId(Long subCategoryId);

}
