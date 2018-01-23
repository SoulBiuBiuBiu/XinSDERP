
package i.thinker.org.service.impl;
import i.thinker.org.enity.Dd;
import i.thinker.org.service.DdService;
import i.thinker.org.dao.DdDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("ddService")
public class DdServiceImpl extends BaseServiceImpl<Dd> implements DdService {
    @Autowired
    DdServiceImpl(DdDao ddDao){
            super.baseDao=ddDao;
    }
}
