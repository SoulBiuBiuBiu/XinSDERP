
package i.thinker.org.service.impl;
import i.thinker.org.enity.Bclb;
import i.thinker.org.service.BclbService;
import i.thinker.org.dao.BclbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("bclbService")
public class BclbServiceImpl extends BaseServiceImpl<Bclb> implements BclbService {
    @Autowired
    BclbServiceImpl(BclbDao bclbDao){
            super.baseDao=bclbDao;
    }
}
