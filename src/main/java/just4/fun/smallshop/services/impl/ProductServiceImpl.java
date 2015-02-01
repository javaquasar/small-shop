package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.model.Product;
import just4.fun.smallshop.dao.ProductDao;
import just4.fun.smallshop.model.Test;
import just4.fun.smallshop.services.ProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 23.01.15.
 */
@Service
public class ProductServiceImpl extends BaseService<Product, Long> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductDao repository) {
        super(repository);
    }

    @Autowired
    SessionFactory sessionFactory;

}
