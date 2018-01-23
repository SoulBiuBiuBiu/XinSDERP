
package i.thinker.org.service.impl;
import i.thinker.org.enity.Bcck;
import i.thinker.org.service.BcckService;
import i.thinker.org.dao.BcckDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("bcckService")
public class BcckServiceImpl extends BaseServiceImpl<Bcck> implements BcckService {
    @Autowired
    BcckServiceImpl(BcckDao bcckDao){
            super.baseDao=bcckDao;
    }
}
