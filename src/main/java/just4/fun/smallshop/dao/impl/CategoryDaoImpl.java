package just4.fun.smallshop.dao.impl;

import com.sun.javafx.geom.AreaOp;
import just4.fun.smallshop.dao.CategoryDao;
import just4.fun.smallshop.model.product.Category;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.BasicTransformerAdapter;
import org.hibernate.transform.DistinctResultTransformer;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

import java.util.*;

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

    @Override
    @Cacheable("categories")
    public List<Category> findAll() {
        Query query = getSession().createQuery("select c from Category c left join fetch c.subCategories");// where parent is null");
//        query.setCacheable(true);
//        query.setCacheRegion("allCategories");

        query.setResultTransformer(DistinctResultTransformer.INSTANCE);

        query.setResultTransformer(new BasicTransformerAdapter() {
            @Override
            public List transformList(List list) {
                List categories = new ArrayList();
                for (Object[] objects: (List<Object[]>) distinct(list)) {
                    Category category = (Category) objects[0];
                    if(category.getParent() == null) {
                        categories.add(category);
                    }
                }
                return categories;
            }

            private List distinct(List list) {
                List result = new ArrayList( list.size() );
                Set distinct = new HashSet();
                for ( int i = 0; i < list.size(); i++ ) {
                    Object entity = list.get( i );
                    Object entityObject = ((Object[])entity)[0];
                    if ( distinct.add(entityObject) ) {
                        result.add( entity );
                    }
                }
                return result;
            }

        });
        List<Category> cats = query.list();
        return cats;
    }
}
