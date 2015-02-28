package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.dao.ProductDao;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.service.impl.BaseService;

import java.util.List;

/**
 * Created by zinchenko on 23.01.15.
 */
@Service
public class ProductServiceImpl extends BaseService<Product, Long> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao repository) {
        super(repository);
    }

    @Override
    public List<Product> getBySubCategoryId(Long subCategoryId) {
        return productDao.getBySubCategoryId(subCategoryId);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
