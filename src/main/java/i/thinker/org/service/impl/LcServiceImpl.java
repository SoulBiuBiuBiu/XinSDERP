
package i.thinker.org.service.impl;
import i.thinker.org.enity.Lc;
import i.thinker.org.service.LcService;
import i.thinker.org.dao.LcDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("lcService")
public class LcServiceImpl extends BaseServiceImpl<Lc> implements LcService {
    @Autowired
    LcServiceImpl(LcDao lcDao){
            super.baseDao=lcDao;
    }
}
