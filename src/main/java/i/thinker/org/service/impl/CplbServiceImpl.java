
package i.thinker.org.service.impl;
import i.thinker.org.enity.Cplb;
import i.thinker.org.service.CplbService;
import i.thinker.org.dao.CplbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("cplbService")
public class CplbServiceImpl extends BaseServiceImpl<Cplb> implements CplbService {
    @Autowired
    CplbServiceImpl(CplbDao cplbDao){
            super.baseDao=cplbDao;
    }
}
