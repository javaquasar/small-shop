package just4.fun.smallshop.services;

import just4.fun.smallshop.model.product.AttributeType;
import zinjvi.service.Service;

import java.util.List;

/**
 * Created by zinchenko on 28.01.15.
 */
public interface AttributeTypeService extends Service<AttributeType, Long> {

    List<AttributeType> findBySubCategoryId(Long subCategoryId);

}
