package just4.fun.smallshop.services;

import just4.fun.smallshop.beans.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zinchenko on 18.01.15.
 */
@Service
// TODO | use interfaces
public class ProductService {

    // TODO | move to DAO
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
