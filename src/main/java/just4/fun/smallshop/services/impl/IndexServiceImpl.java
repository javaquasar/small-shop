package just4.fun.smallshop.services.impl;

import com.sun.javafx.binding.StringFormatter;
import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.IndexService;
import just4.fun.smallshop.services.UnexpectedServiceException;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.annotations.Indexed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 09.03.15.
 */
@Service
public class IndexServiceImpl implements IndexService {

    //TODO move to property
    public static final int BATCH_SIZE = 2;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long index() {
        Long totalSize = 0L;
        for(Class classToIndex: getClassesToIndex()) {
            totalSize += index(classToIndex);
        }
        return totalSize;
    }

    @Override
    public Long index(Class entityClass) {
        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        ScrollableResults scrollableResults = session.createCriteria(entityClass).scroll();
        long i = 0;
        while (scrollableResults.next()) {
            i++;
            fullTextSession.index(scrollableResults.get(0));
            if(i % BATCH_SIZE == 0) {
                fullTextSession.flushToIndexes();
                fullTextSession.clear();
            }
        }
        return i;
    }

    private List<Class> getClassesToIndex() {
        List<Class> classesToIndex = new ArrayList<Class>();
        for(String entityClassName : sessionFactory.getAllClassMetadata().keySet()) {
            Class entityClass = null;
            try {
                entityClass = Class.forName(entityClassName);
            } catch (ClassNotFoundException e) {
                throw new UnexpectedServiceException(
                        MessageFormat.format("Hibernate maps {0} class which was not loaded", entityClassName),
                        e);
            }
            if(entityClass.getAnnotation(Indexed.class) != null) {
                classesToIndex.add(entityClass);
            }
        }
        return classesToIndex;
    }

}
