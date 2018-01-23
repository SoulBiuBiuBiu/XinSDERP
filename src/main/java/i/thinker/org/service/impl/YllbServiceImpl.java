
package i.thinker.org.service.impl;
import i.thinker.org.enity.Yllb;
import i.thinker.org.service.YllbService;
import i.thinker.org.dao.YllbDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("yllbService")
public class YllbServiceImpl extends BaseServiceImpl<Yllb> implements YllbService {
    @Autowired
    YllbServiceImpl(YllbDao yllbDao){
            super.baseDao=yllbDao;
    }
}
