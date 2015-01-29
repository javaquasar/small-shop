package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.model.Product;
import just4.fun.smallshop.dao.ProductDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 23.01.15.
 */
@Repository
public class ProductDaoImpl extends BaseHibernateRepository<Product, Long>
        implements ProductDao {

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
