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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zinjvi.repository.impl.BaseHibernateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Category> findAll() {
        Query query = getSession().createQuery("select c from Category c left join fetch c.subCategories");// where parent is null");
//        query.setCacheable(true);
//        query.setCacheRegion("allCategories");

        query.setResultTransformer(DistinctResultTransformer.INSTANCE);

        query.setResultTransformer(new BasicTransformerAdapter() {
            @Override
            public List transformList(List list) {
                List categories = new ArrayList();
                for (Object[] objects: (List<Object[]>) list) {
                    Category category = (Category) objects[0];
                    if(category.getParent() == null) {
                        categories.add(category);
                    }
                }
                return categories;
            }
        });
        List<Category> cats = query.list();
        return cats;
    }
}
