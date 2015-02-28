package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.dao.RoleDao;
import just4.fun.smallshop.model.identity.Role;
import just4.fun.smallshop.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.repository.Repository;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 28.02.15.
 */
@Service
public class RoleServiceImpl extends BaseService<Role, Long> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDao repository) {
        super(repository);
    }
}
