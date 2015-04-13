package just4.fun.smallshop.dao.solr.converter;

import just4.fun.smallshop.dao.solr.SolrConverter;
import just4.fun.smallshop.model.product.Category;
import org.apache.solr.common.SolrInputDocument;

/**
 * Created by zinchenko on 11.04.15.
 */
public class CategoryConverter implements SolrConverter {
    @Override
    public void convert(Object entity, SolrInputDocument document) {
        Category category = (Category) entity;
        document.addField("id", category.getId());
        document.addField("title", category.getTitle());
    }
}
