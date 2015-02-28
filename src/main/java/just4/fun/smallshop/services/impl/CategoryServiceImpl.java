package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.dao.CategoryDao;
import just4.fun.smallshop.model.product.Category;
import just4.fun.smallshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 23.01.15.
 */
@Service
public class CategoryServiceImpl extends BaseService<Category, Long> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryDao repository) {
        super(repository);
    }

}
