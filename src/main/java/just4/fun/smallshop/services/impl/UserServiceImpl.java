package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.model.identity.User;
import just4.fun.smallshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zinjvi.repository.Repository;
import zinjvi.service.impl.BaseService;

/**
 * Created by zinchenko on 28.02.15.
 */
@Service
public class UserServiceImpl extends BaseService<User, Long> implements UserService {

    @Autowired
    public UserServiceImpl(Repository<User, Long> repository) {
        super(repository);
    }
}
