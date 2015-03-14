package just4.fun.smallshop.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bson.types.ObjectId;

/**
 * Created by zinchenko on 03.01.15.
 */
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.addMixInAnnotations(Object.class, JacksonMixIn.class);
    }
}
