
package i.thinker.org.service.impl;
import i.thinker.org.enity.Bcplb;
import i.thinker.org.service.BcplbService;
import i.thinker.org.dao.BcplbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("bcplbService")
public class BcplbServiceImpl extends BaseServiceImpl<Bcplb> implements BcplbService {
    @Autowired
    BcplbServiceImpl(BcplbDao bcplbDao){
            super.baseDao=bcplbDao;
    }
}
