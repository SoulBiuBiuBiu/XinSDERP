
package i.thinker.org.service.impl;
import i.thinker.org.enity.Bcpck;
import i.thinker.org.service.BcpckService;
import i.thinker.org.dao.BcpckDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("bcpckService")
public class BcpckServiceImpl extends BaseServiceImpl<Bcpck> implements BcpckService {
    @Autowired
    BcpckServiceImpl(BcpckDao bcpckDao){
            super.baseDao=bcpckDao;
    }
}
