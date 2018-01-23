
package i.thinker.org.service.impl;
import i.thinker.org.enity.DdCplb;
import i.thinker.org.service.DdCplbService;
import i.thinker.org.dao.DdCplbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("ddcplbService")
public class DdCplbServiceImpl extends BaseServiceImpl<DdCplb> implements DdCplbService {
    @Autowired
    DdCplbServiceImpl(DdCplbDao ddcplbDao){
            super.baseDao=ddcplbDao;
    }
}
