package just4.fun.smallshop.dao.solr;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Created by zinchenko on 11.04.15.
 */
@Component
public class SessionAdvisor implements InitializingBean {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SolrHibernateInterceptor solrHibernateInterceptor;

    @Override
    public void afterPropertiesSet() throws Exception {
        solrHibernateInterceptor.setSessionFactory(sessionFactory);
        solrHibernateInterceptor.init();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
