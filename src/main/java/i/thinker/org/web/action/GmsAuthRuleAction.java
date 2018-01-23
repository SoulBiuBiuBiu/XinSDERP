package i.thinker.org.web.action;

import i.thinker.org.enity.GmsAuthRule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import i.thinker.org.service.GmsAuthRuleService;
import i.thinker.org.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller(value = "gmsauthruleAction")
@Scope(value = "PROTOTYPE")
@Namespace("/gmsauthrule")
@ParentPackage("XinSD")
public class GmsAuthRuleAction extends BaseAction implements ModelDriven<GmsAuthRule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GmsAuthRuleService service;
	private GmsAuthRule gmsauthrule;
	private int page;
	private int rows;
	private String sort;
	private String order;
	private Timestamp minTime;
	private Timestamp maxTime;
	private Integer pid;
	private List<GmsAuthRule> list;
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	
	
	public List<GmsAuthRule> getList() {
		return list;
	}

	public void setList(List<GmsAuthRule> list) {
		this.list = list;
	}

	public Timestamp getMinTime() {
		return minTime;
	}

	public void setMinTime(Timestamp minTime) {
		this.minTime = minTime;
	}

	public Timestamp getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Timestamp maxTime) {
		this.maxTime = maxTime;
	}

	@Autowired
	GmsAuthRuleAction(GmsAuthRuleService gmsauthruleService) {
		this.service = gmsauthruleService;
	}

	final DetachedCriteria getDetachedCriteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(GmsAuthRule.class);
		
		return dc;
	}
	
	
    @Action(value = "listMenu", results = { @Result(name = "success", location = "/index.jsp") })
   	public String listMenu() throws Exception {
    	GmsAuthRule g=new GmsAuthRule();
    	g.setPid(0);
    	List<GmsAuthRule> list = service.getListByModel(g);
    	
    	
    	ActionContext.getContext().put("menulist", list);
    	
   		return SUCCESS;
   	}
    @Action(value = "listMenuByPid", results = { @Result(type="json",name = "success",params={"root","list"}) })
   	public String listMenuByPid() throws Exception {
    	GmsAuthRule g=new GmsAuthRule();
//    	Object object = ActionContext.getContext().get("pid");
    	g.setPid(pid);
    	g.setIsHide("0");
    	this.list = service.getListByModel(g);
   		return SUCCESS;
   	}
	

	@Action(value = "deleteById", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String deleteById() {
		boolean status = true;
		String info = "删除成功";
		try {
			service.delete(gmsauthrule.getId());
		} catch (Exception e) {
			info = "删除失败";
			status = false;
		}

		msg.put("info", info);
		msg.put("status", status);
		return "success";
	}

	// 改
	/**
	 * update 保存或者更新对象 parame;{"id":12}; retrun:null;
	 * 
	 * @return
	 */
	@Action(value = "update", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String update() {
		String info = "成功";
		try {

		} catch (Exception e) {
			info = "失败";
		}
		service.update(gmsauthrule);
		msg.put("info", info);
		return "success";
	}

	// 查 查询分页列表数据
	/**
	 * GmsAuthRule_getPageBean 查询分页列表数据 parame;int currentPage;int rows;qx对象 {Integer
	 * qxid; Integer qxmz;}; retrun:pageBean;
	 * 
	 * @return
	 */
	@Action(value = "list", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String getPageBean() {
		PageBean pageBean = service.getPageBean(getDetachedCriteria(), page, rows);
		msg.put("total", pageBean.getTotalCount());

		List<GmsAuthRule> list = (List<GmsAuthRule>) pageBean.getList();

		for (int i = 0; i < list.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<a href='#' onclick=\"UpdateTabs('order','/XinSDERP/gmsauthrule/getByModel?gmsauthrule.id="
					+ list.get(i).getId().toString() + "','','iconfont icon-edit');\">编辑</a>&nbsp;&nbsp;");
			buffer.append("<a href='#' onclick=\"Data_Remove('/XinSDERP/gmsauthrule/deleteById?gmsauthrule.id="
					+ list.get(i).getId().toString() + "','Context_Data_List');\">删除</a>");
			list.get(i).setOperate(buffer.toString());
		}
		msg.put("rows", list);
		return "success";
	}

	@Action(value = "getByModel", results = { @Result(name = "success", location = "/App/Admin/Order/edit.jsp") })
	public String getByModel() {
		GmsAuthRule model = service.getByModel(gmsauthrule);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("gmsauthrule", model);
		return "success";
	}

	public GmsAuthRule getGmsAuthRule() {
		return gmsauthrule;
	}

	public void setGmsAuthRule(GmsAuthRule gmsauthrule) {
		this.gmsauthrule = gmsauthrule;
	}

	public GmsAuthRuleService getService() {
		return service;
	}

	public void setService(GmsAuthRuleService service) {
		this.service = service;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setModel(GmsAuthRule gmsauthrule) {
		this.gmsauthrule = gmsauthrule;
	}

	public void setGmsAuthRuleService(GmsAuthRuleService service) {
		this.service = service;
	}

	@Override
	public GmsAuthRule getModel() {
		return gmsauthrule;
	}
}
