package i.thinker.org.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import i.thinker.org.service.BaseService;


import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class BaseAction extends ActionSupport{

    Map<String, Object> msg = new HashMap<String, Object>();

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }

    
}
