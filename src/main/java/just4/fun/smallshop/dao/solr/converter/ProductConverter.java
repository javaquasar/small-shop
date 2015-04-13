package just4.fun.smallshop.dao.solr.converter;

import just4.fun.smallshop.dao.solr.SolrConverter;
import just4.fun.smallshop.model.product.Category;
import just4.fun.smallshop.model.product.Product;
import org.apache.solr.common.SolrInputDocument;

/**
 * Created by zinchenko on 11.04.15.
 */
public class ProductConverter implements SolrConverter<Product> {
    @Override
    public void convert(Product entity, SolrInputDocument document) {
        document.addField("id", entity.getId());
        document.addField("title", entity.getTitle());
    }
}
