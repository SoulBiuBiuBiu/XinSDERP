package i.thinker.org.web.action;

import i.thinker.org.enity.GmsUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import i.thinker.org.service.GmsUserService;
import i.thinker.org.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller(value = "gmsuserAction")
@Scope(value = "PROTOTYPE")
@Namespace("/gmsuser")
@ParentPackage("XinSD")
public class GmsUserAction extends BaseAction implements ModelDriven<GmsUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GmsUserService service;
	private GmsUser gmsuser;
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
	GmsUserAction(GmsUserService gmsuserService) {
		this.service = gmsuserService;
	}

	final DetachedCriteria getDetachedCriteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(GmsUser.class);
		
		return dc;
	}
	
	@Action(value = "loginout", results = { @Result(name = "success", location = "/App/Admin/Public/login.jsp") })
	public String loginout() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		session.remove("password");
		
		return "success";
	}

	

	@Action(value = "login", results = { @Result(name = "success", location = "/App/Admin/Public/success.jsp") })
	public String login() throws Exception {
		String error = "";
		int waittime = 5;
		// HttpServletRequest request = ServletActionContext.getRequest();
		// String userName = request.getParameter("username");
		// String passWord = request.getParameter("password");
		String jumpUrl = "/XinSDERP/App/Admin/Public/login.jsp";

		GmsUser u = service.getByModel(gmsuser);
		ActionContext context = ActionContext.getContext();
		if (u == null) {
			error = "用户名不存在";
		} else {
			String a = gmsuser.getPassword();
			a = a.trim();
			String b = u.getPassword();
			b = b.trim();
			if (a.equals(b)) {
				jumpUrl = "/XinSDERP/gmsauthrule/listMenu";
				error = "登录成功";
				Map<String, Object> session = context.getSession();
				session.put("username", u.getUsername());
				session.put("password", u.getPassword());
			} else {
				error = "密码错误";
			}
		}

		context.put("waittime", waittime);
		context.put("error", error);
		context.put("jumpUrl", jumpUrl);

		return "success";
	}


	@Action(value = "deleteById", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String deleteById() {
		boolean status = true;
		String info = "删除成功";
		try {
			service.delete(gmsuser.getId());
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
		service.update(gmsuser);
		msg.put("info", info);
		return "success";
	}

	// 查 查询分页列表数据
	/**
	 * GmsUser_getPageBean 查询分页列表数据 parame;int currentPage;int rows;qx对象 {Integer
	 * qxid; Integer qxmz;}; retrun:pageBean;
	 * 
	 * @return
	 */
	@Action(value = "list", results = { @Result(type = "json", name = "success", params = { "root", "msg" }) })
	public String getPageBean() {
		PageBean pageBean = service.getPageBean(getDetachedCriteria(), page, rows);
		msg.put("total", pageBean.getTotalCount());

		List<GmsUser> list = (List<GmsUser>) pageBean.getList();

		for (int i = 0; i < list.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<a href='#' onclick=\"UpdateTabs('order','/XinSDERP/gmsuser/getByModel?gmsuser.id="
					+ list.get(i).getId().toString() + "','','iconfont icon-edit');\">编辑</a>&nbsp;&nbsp;");
			buffer.append("<a href='#' onclick=\"Data_Remove('/XinSDERP/gmsuser/deleteById?gmsuser.id="
					+ list.get(i).getId().toString() + "','Context_Data_List');\">删除</a>");
			list.get(i).setOperate(buffer.toString());
		}
		msg.put("rows", list);
		return "success";
	}

	@Action(value = "getByModel", results = { @Result(name = "success", location = "/App/Admin/Order/edit.jsp") })
	public String getByModel() {
		GmsUser model = service.getByModel(gmsuser);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("gmsuser", model);
		return "success";
	}

	public GmsUser getGmsUser() {
		return gmsuser;
	}

	public void setGmsUser(GmsUser gmsuser) {
		this.gmsuser = gmsuser;
	}

	public GmsUserService getService() {
		return service;
	}

	public void setService(GmsUserService service) {
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

	public void setModel(GmsUser gmsuser) {
		this.gmsuser = gmsuser;
	}

	public void setGmsUserService(GmsUserService service) {
		this.service = service;
	}

	@Override
	public GmsUser getModel() {
		return gmsuser;
	}
}
