package just4.fun.smallshop.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by zinchenko on 14.03.15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class JacksonMixIn {
}
