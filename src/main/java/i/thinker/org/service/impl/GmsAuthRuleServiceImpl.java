
package i.thinker.org.service.impl;
import i.thinker.org.enity.GmsAuthRule;
import i.thinker.org.service.GmsAuthRuleService;
import i.thinker.org.dao.GmsAuthRuleDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service("gmsauthruleService")
public class GmsAuthRuleServiceImpl extends BaseServiceImpl<GmsAuthRule> implements GmsAuthRuleService {
    @Autowired
    GmsAuthRuleServiceImpl(GmsAuthRuleDao gmsauthruleDao){
            super.baseDao=gmsauthruleDao;
    }
}
