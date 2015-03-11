package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.IndexService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zinchenko on 09.03.15.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long index() {
        Long size = 0L;
        size += index(Product.class);
        return size;
    }

    @Override
    public Long index(Class entityClass) {
        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        List list = session.createCriteria(entityClass).list();
        for(Object entity: list) {
            fullTextSession.index(entity);
        }
        fullTextSession.flushToIndexes();
        return Long.valueOf(list.size());
    }
}
