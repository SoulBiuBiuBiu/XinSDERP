package i.thinker.org.web.action;

import i.thinker.org.enity.Bcplb;

import com.opensymphony.xwork2.ModelDriven;
import i.thinker.org.service.BcplbService;
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

@Controller(value = "bcplbAction")
@Scope(value = "PROTOTYPE")
@Namespace("/bcplb")
@ParentPackage("XinSD")
public class BcplbAction extends BaseAction implements ModelDriven<Bcplb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BcplbService service;
	private Bcplb bcplb;
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
	BcplbAction(BcplbService bcplbService) {
		this.service = bcplbService;
	}

	final DetachedCriteria getDetachedCriteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(Bcplb.class);
		
		return dc;
	}

	@Action(value = "deleteById", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String deleteById() {
		boolean status = true;
		String info = "删除成功";
		try {
			service.delete(bcplb.getId());
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
		service.update(bcplb);
		msg.put("info", info);
		return "success";
	}

	// 查 查询分页列表数据
	/**
	 * Bcplb_getPageBean 查询分页列表数据 parame;int currentPage;int rows;qx对象 {Integer
	 * qxid; Integer qxmz;}; retrun:pageBean;
	 * 
	 * @return
	 */
	@Action(value = "list", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String getPageBean() {
		PageBean pageBean = service.getPageBean(getDetachedCriteria(), page, rows);
		msg.put("total", pageBean.getTotalCount());

		List<Bcplb> list = (List<Bcplb>) pageBean.getList();

		for (int i = 0; i < list.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<a href='#' onclick=\"UpdateTabs('order','/XinSDERP/bcplb/getByModel?bcplb.id="
					+ list.get(i).getId().toString() + "','','iconfont icon-edit');\">编辑</a>&nbsp;&nbsp;");
			buffer.append("<a href='#' onclick=\"Data_Remove('/XinSDERP/bcplb/deleteById?bcplb.id="
					+ list.get(i).getId().toString() + "','Context_Data_List');\">删除</a>");
			list.get(i).setOperate(buffer.toString());
		}
		msg.put("rows", list);
		return "success";
	}

	@Action(value = "getByModel", results = { @Result(name = "success", location = "/App/Admin/Order/edit.jsp") })
	public String getByModel() {
		Bcplb model = service.getByModel(bcplb);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bcplb", model);
		return "success";
	}

	public Bcplb getBcplb() {
		return bcplb;
	}

	public void setBcplb(Bcplb bcplb) {
		this.bcplb = bcplb;
	}

	public BcplbService getService() {
		return service;
	}

	public void setService(BcplbService service) {
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

	public void setModel(Bcplb bcplb) {
		this.bcplb = bcplb;
	}

	public void setBcplbService(BcplbService service) {
		this.service = service;
	}

	@Override
	public Bcplb getModel() {
		return bcplb;
	}
}
