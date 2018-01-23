
package i.thinker.org.service.impl;
import i.thinker.org.enity.GmsAuthGroup;
import i.thinker.org.service.GmsAuthGroupService;
import i.thinker.org.dao.GmsAuthGroupDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("gmsauthgroupService")
public class GmsAuthGroupServiceImpl extends BaseServiceImpl<GmsAuthGroup> implements GmsAuthGroupService {
    @Autowired
    GmsAuthGroupServiceImpl(GmsAuthGroupDao gmsauthgroupDao){
            super.baseDao=gmsauthgroupDao;
    }
}
