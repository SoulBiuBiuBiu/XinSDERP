
package i.thinker.org.service.impl;
import i.thinker.org.enity.Cpck;
import i.thinker.org.service.CpckService;
import i.thinker.org.dao.CpckDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("cpckService")
public class CpckServiceImpl extends BaseServiceImpl<Cpck> implements CpckService {
    @Autowired
    CpckServiceImpl(CpckDao cpckDao){
            super.baseDao=cpckDao;
    }
}
