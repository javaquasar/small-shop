package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.api.dto.ProductSearchDto;
import just4.fun.smallshop.model.Test;
import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.dao.ProductDao;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.repository.impl.BaseHibernateRepository;

import java.util.List;

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

    @Override
    public List<Product> getBySubCategoryId(Long subCategoryId) {
        return getSession()
                .createQuery("from Product p where p.subCategory.id = :subCategoryId")
                .setLong("subCategoryId", subCategoryId)
                .list();
    }

    @Override
    public List<Product> getBySubCategoryIdAndAttrValueId(Long subCategoryId, Long attributeValueId) {
        return getSession()
                .createQuery("select p from Product p join p.attributes as attribute " +
                        "where p.subCategory.id = :subCategoryId and " +
                        "attribute.id = :attributeValueId")
                .setLong("subCategoryId", subCategoryId)
                .setLong("attributeValueId", attributeValueId)
                .list();
    }

    @Override
    public List<Product> findByIds(List<Long> ids) {
        return getSession().createQuery("from Product p where p.id in (:ids)")
                .setParameterList("ids", ids)
                .list();
    }

    @Override
    public List<Product> search(ProductSearchDto productSearchDto) {
        FullTextSession session = Search.getFullTextSession(getSession());

        QueryBuilder b = session.getSearchFactory()
                .buildQueryBuilder().forEntity(Product.class).get();

        org.apache.lucene.search.Query luceneQuery =
                b.keyword()
                        .onField("name").boostedTo(3)
                        .matching(productSearchDto.getQuery())
                        .createQuery();
        List<Product> result = session.createFullTextQuery(luceneQuery).list();
        return result;
    }

    @Transactional
    public Test add(String name) {
        Test test = new Test();
        test.setName(name);
        getSession().save(test);
        return test;
    }

}
