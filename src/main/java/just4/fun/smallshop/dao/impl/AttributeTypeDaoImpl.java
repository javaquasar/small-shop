package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.model.product.AttributeType;
import just4.fun.smallshop.dao.AttributeTypeDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 28.01.15.
 */
@Repository
public class AttributeTypeDaoImpl extends BaseHibernateRepository<AttributeType, Long>
        implements AttributeTypeDao {

    @Autowired
    public AttributeTypeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
