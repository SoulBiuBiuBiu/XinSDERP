package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * GmsAuthGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gms_auth_group", catalog = "xinsd")

public class GmsAuthGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short pid;
	private String title;
	private Integer status;
	private String rules;
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
	public GmsAuthGroup() {
	}

	/** minimal constructor */
	public GmsAuthGroup(Integer status) {
		this.status = status;
	}

	/** full constructor */
	public GmsAuthGroup(Short pid, String title, Integer status, String rules) {
		this.pid = pid;
		this.title = title;
		this.status = status;
		this.rules = rules;
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

	public Short getPid() {
		return this.pid;
	}

	public void setPid(Short pid) {
		this.pid = pid;
	}

	@Column(name = "title", length = 100)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "status", nullable = false)

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "rules", length = 65535)

	public String getRules() {
		return this.rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

}