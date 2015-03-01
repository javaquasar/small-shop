package just4.fun.smallshop.dao.impl;

import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.dao.ProductDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
