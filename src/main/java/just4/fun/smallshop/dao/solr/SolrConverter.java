package just4.fun.smallshop.dao.solr;

import org.apache.solr.common.SolrInputDocument;

/**
 * Created by zinchenko on 11.04.15.
 */
public interface SolrConverter<T> {

    void convert(T entity, SolrInputDocument document);

}
