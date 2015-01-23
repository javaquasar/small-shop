package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.beans.Product;
import just4.fun.smallshop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.repository.Repository;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 23.01.15.
 */
@Service
public class ProductService extends BaseService<Product, Long> {

    @Autowired
    public ProductService(ProductDao repository) {
        super(repository);
    }

}
