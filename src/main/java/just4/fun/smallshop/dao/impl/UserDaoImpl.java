package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.dao.UserDao;
import just4.fun.smallshop.model.identity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 28.02.15.
 */
@Repository
public class UserDaoImpl extends BaseHibernateRepository<User, Long> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
