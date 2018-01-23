
package i.thinker.org.service.impl;
import i.thinker.org.enity.Dw;
import i.thinker.org.service.DwService;
import i.thinker.org.dao.DwDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("dwService")
public class DwServiceImpl extends BaseServiceImpl<Dw> implements DwService {
    @Autowired
    DwServiceImpl(DwDao dwDao){
            super.baseDao=dwDao;
    }
}
