
package i.thinker.org.service.impl;
import i.thinker.org.enity.Mjlb;
import i.thinker.org.service.MjlbService;
import i.thinker.org.dao.MjlbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("mjlbService")
public class MjlbServiceImpl extends BaseServiceImpl<Mjlb> implements MjlbService {
    @Autowired
    MjlbServiceImpl(MjlbDao mjlbDao){
            super.baseDao=mjlbDao;
    }
}
