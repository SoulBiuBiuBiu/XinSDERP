
package i.thinker.org.service.impl;
import i.thinker.org.enity.GmsUser;
import i.thinker.org.service.GmsUserService;
import i.thinker.org.dao.GmsUserDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("gmsuserService")
public class GmsUserServiceImpl extends BaseServiceImpl<GmsUser> implements GmsUserService {
    @Autowired
    GmsUserServiceImpl(GmsUserDao gmsuserDao){
            super.baseDao=gmsuserDao;
    }
}
