package just4.fun.smallshop.dao.solr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zinchenko on 11.04.15.
 */
@Target(value={ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SolrConverterType {

    public String core();

    public Class<? extends SolrConverter> converter();

}
