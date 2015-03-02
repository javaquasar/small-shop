package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.dao.OrderDao;
import just4.fun.smallshop.model.order.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

/**
 * Created by zinchenko on 02.03.15.
 */
@Repository
public class OrderDaoImpl extends BaseHibernateRepository<Order, Long> implements OrderDao {

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
