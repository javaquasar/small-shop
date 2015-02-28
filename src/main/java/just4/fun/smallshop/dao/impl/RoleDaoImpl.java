package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.dao.RoleDao;
import just4.fun.smallshop.model.identity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 28.02.15.
 */
@Repository
public class RoleDaoImpl extends BaseHibernateRepository<Role, Long> implements RoleDao{

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
