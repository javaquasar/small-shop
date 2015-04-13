package just4.fun.smallshop.dao.solr;

import just4.fun.smallshop.services.UnexpectedServiceException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.hibernate.EmptyInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zinchenko on 11.04.15.
 */
public class SolrHibernateInterceptor extends EmptyInterceptor  {

    private String baseUrl;

    private SessionFactory sessionFactory;

    private Map<Class, SolrEntityMetaData> converters = new HashMap<Class, SolrEntityMetaData>();

    public void init() {
        for(String entityClassName : sessionFactory.getAllClassMetadata().keySet()) {
            try {
                Class entityClass = Class.forName(entityClassName);
                SolrConverterType converterType = (SolrConverterType) entityClass.getAnnotation(SolrConverterType.class);
                if(converterType == null) {
                    continue;
                }
                SolrEntityMetaData metaData = new SolrEntityMetaData();
                metaData.converter = converterType.converter().newInstance();
                metaData.solrClient = new HttpSolrClient(baseUrl + converterType.core());
                converters.put(entityClass, metaData);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(
                        MessageFormat.format("Hibernate maps {0} class which was not loaded", entityClassName),
                        e);
            } catch (InstantiationException e) {
                throw new RuntimeException("Error during initializing solr entity", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error during initializing solr entity", e);
            }
        }

    }

    private static class SolrEntityMetaData {
        public SolrConverter converter;
        public SolrClient solrClient;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        Class entityClass = entity.getClass();
        SolrEntityMetaData metaData = converters.get(entityClass);
        if(metaData == null) {
            //TODO add log
            return false;
        }
        SolrInputDocument document = new SolrInputDocument();
        try {
            metaData.converter.convert(entity, document);
            UpdateResponse response = metaData.solrClient.add(document);
            metaData.solrClient.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpSolrClient.RemoteSolrException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        //TODO add log
        return false;

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
