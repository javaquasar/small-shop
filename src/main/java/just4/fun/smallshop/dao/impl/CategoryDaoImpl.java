package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.dao.CategoryDao;
import just4.fun.smallshop.model.product.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 23.01.15.
 */
@Repository
public class CategoryDaoImpl extends BaseHibernateRepository<Category, Long>
        implements CategoryDao {

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
