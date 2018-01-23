package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * GmsAuthRule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gms_auth_rule", catalog = "xinsd")

public class GmsAuthRule implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer pid;
	private String name;
	private String title;
	private String icon;
	private String type;
	private String isHide;
	private String status;
	private Short sort;
	private String condition;
	private String url;
	private String text;
	private String operate;

	// Constructors
	@Transient
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	/** default constructor */
	public GmsAuthRule() {
	}

	/** full constructor */
	public GmsAuthRule(Integer pid, String name, String title, String icon, String type, String isHide, String status,
			Short sort, String condition, String url, String text) {
		this.pid = pid;
		this.name = name;
		this.title = title;
		this.icon = icon;
		this.type = type;
		this.isHide = isHide;
		this.status = status;
		this.sort = sort;
		this.condition = condition;
		this.url = url;
		this.text = text;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pid")

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "name", length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title", length = 100)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "icon", length = 30)

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "type", length = 1)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "is_hide", length = 1)

	public String getIsHide() {
		return this.isHide;
	}

	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}

	@Column(name = "status", length = 1)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "sort")

	public Short getSort() {
		return this.sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	@Column(name = "condition", length = 40)

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Column(name = "url")

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "text")

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}