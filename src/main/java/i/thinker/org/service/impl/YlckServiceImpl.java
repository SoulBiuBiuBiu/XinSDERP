
package i.thinker.org.service.impl;
import i.thinker.org.enity.Ylck;
import i.thinker.org.service.YlckService;
import i.thinker.org.dao.YlckDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("ylckService")
public class YlckServiceImpl extends BaseServiceImpl<Ylck> implements YlckService {
    @Autowired
    YlckServiceImpl(YlckDao ylckDao){
            super.baseDao=ylckDao;
    }
}
