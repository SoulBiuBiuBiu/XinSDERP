
package i.thinker.org.service.impl;
import i.thinker.org.enity.T;
import i.thinker.org.service.TService;
import i.thinker.org.dao.TDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("tService")
public class TServiceImpl extends BaseServiceImpl<T> implements TService {
    @Autowired
    TServiceImpl(TDao tDao){
            super.baseDao=tDao;
    }
}
