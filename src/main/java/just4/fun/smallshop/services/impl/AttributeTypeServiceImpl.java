package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.model.product.AttributeType;
import just4.fun.smallshop.dao.AttributeTypeDao;
import just4.fun.smallshop.services.AttributeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.service.impl.BaseService;

import java.util.List;

/**
 * Created by zinchenko on 28.01.15.
 */
@Service
public class AttributeTypeServiceImpl extends BaseService<AttributeType, Long>
        implements AttributeTypeService {

    @Autowired
    private AttributeTypeDao attributeTypeDao;

    @Autowired
    public AttributeTypeServiceImpl(AttributeTypeDao repository) {
        super(repository);
    }

    @Override
    public List<AttributeType> findBySubCategoryId(Long subCategoryId) {
        return attributeTypeDao.findBySubCategoryId(subCategoryId);
    }
}
