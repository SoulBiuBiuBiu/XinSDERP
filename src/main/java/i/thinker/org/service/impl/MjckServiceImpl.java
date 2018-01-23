
package i.thinker.org.service.impl;
import i.thinker.org.enity.Mjck;
import i.thinker.org.service.MjckService;
import i.thinker.org.dao.MjckDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("mjckService")
public class MjckServiceImpl extends BaseServiceImpl<Mjck> implements MjckService {
    @Autowired
    MjckServiceImpl(MjckDao mjckDao){
            super.baseDao=mjckDao;
    }
}
