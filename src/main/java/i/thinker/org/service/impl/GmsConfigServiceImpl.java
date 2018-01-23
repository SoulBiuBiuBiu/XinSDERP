
package i.thinker.org.service.impl;
import i.thinker.org.enity.GmsConfig;
import i.thinker.org.service.GmsConfigService;
import i.thinker.org.dao.GmsConfigDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("gmsconfigService")
public class GmsConfigServiceImpl extends BaseServiceImpl<GmsConfig> implements GmsConfigService {
    @Autowired
    GmsConfigServiceImpl(GmsConfigDao gmsconfigDao){
            super.baseDao=gmsconfigDao;
    }
}
