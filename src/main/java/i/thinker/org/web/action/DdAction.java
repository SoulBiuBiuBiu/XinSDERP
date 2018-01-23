package i.thinker.org.web.action;

import i.thinker.org.enity.Dd;

import com.opensymphony.xwork2.ModelDriven;
import i.thinker.org.service.DdService;
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

@Controller(value = "ddAction")
@Scope(value = "PROTOTYPE")
@Namespace("/dd")
@ParentPackage("XinSD")
public class DdAction extends BaseAction implements ModelDriven<Dd> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DdService service;
	private Dd dd;
	private int page;
	private int rows;
	private String sort;
	private String order;
	private Timestamp minTime;
	private Timestamp maxTime;

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
	DdAction(DdService ddService) {
		this.service = ddService;
	}

	final DetachedCriteria getDetachedCriteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(Dd.class);
		if(order==null&&sort==null){
			dc.addOrder(Order.desc("ddrq"));
		}
		else{
			if(order=="asc")
				dc.addOrder(Order.asc(sort));
			else
				dc.addOrder(Order.desc(sort));
		}
		if ((minTime!=null) && (maxTime!=null)) {
			dc.add(Restrictions.between("ddrq", minTime, maxTime));
		}
		if (dd != null) {
			dc.add(Restrictions.like("ddbh", dd.getDdbh()+"%"));
			dc.createCriteria("gk").add(Restrictions.like("dw", dd.getGk().getDw()+"%"));
		}
		return dc;
	}

	@Action(value = "deleteById", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String deleteById() {
		boolean status = true;
		String info = "删除成功";
		try {
			service.delete(dd.getId());
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
		service.update(dd);
		msg.put("info", info);
		return "success";
	}

	// 查 查询分页列表数据
	/**
	 * Dd_getPageBean 查询分页列表数据 parame;int currentPage;int rows;qx对象 {Integer
	 * qxid; Integer qxmz;}; retrun:pageBean;
	 * 
	 * @return
	 */
	@Action(value = "list", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String getPageBean() {
		PageBean pageBean = service.getPageBean(getDetachedCriteria(), page, rows);
		msg.put("total", pageBean.getTotalCount());

		List<Dd> list = (List<Dd>) pageBean.getList();

		for (int i = 0; i < list.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<a href='#' onclick=\"UpdateTabs('order','/XinSDERP/dd/getByModel?dd.id="
					+ list.get(i).getId().toString() + "','','iconfont icon-edit');\">编辑</a>&nbsp;&nbsp;");
			buffer.append("<a href='#' onclick=\"Data_Remove('/XinSDERP/dd/deleteById?dd.id="
					+ list.get(i).getId().toString() + "','Context_Data_List');\">删除</a>");
			list.get(i).setOperate(buffer.toString());
		}
		msg.put("rows", list);
		return "success";
	}

	@Action(value = "getByModel", results = { @Result(name = "success", location = "/App/Admin/Order/edit.jsp") })
	public String getByModel() {
		Dd model = service.getByModel(dd);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("dd", model);
		return "success";
	}

	public Dd getDd() {
		return dd;
	}

	public void setDd(Dd dd) {
		this.dd = dd;
	}

	public DdService getService() {
		return service;
	}

	public void setService(DdService service) {
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

	public void setModel(Dd dd) {
		this.dd = dd;
	}

	public void setDdService(DdService service) {
		this.service = service;
	}

	@Override
	public Dd getModel() {
		return dd;
	}
}
