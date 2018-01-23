
package i.thinker.org.service.impl;
import i.thinker.org.enity.Bom;
import i.thinker.org.service.BomService;
import i.thinker.org.dao.BomDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("bomService")
public class BomServiceImpl extends BaseServiceImpl<Bom> implements BomService {
    @Autowired
    BomServiceImpl(BomDao bomDao){
            super.baseDao=bomDao;
    }
}
