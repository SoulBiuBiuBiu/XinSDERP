package i.thinker.org.enity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Dm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dm", catalog = "xinsd")

public class Dm implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pid;
	private String dm;
	private String mc;
	private String type;
	private String czybh;
	private String bmbh;
	private String jbbh;
	private Date czsj;
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
	public Dm() {
	}

	/** full constructor */
	public Dm(String pid, String dm, String mc, String type, String czybh, String bmbh, String jbbh, Date czsj) {
		this.pid = pid;
		this.dm = dm;
		this.mc = mc;
		this.type = type;
		this.czybh = czybh;
		this.bmbh = bmbh;
		this.jbbh = jbbh;
		this.czsj = czsj;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "ID", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PID", length = 40)

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "DM", length = 10)

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	@Column(name = "MC", length = 40)

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@Column(name = "TYPE", length = 20)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "CZYBH", length = 20)

	public String getCzybh() {
		return this.czybh;
	}

	public void setCzybh(String czybh) {
		this.czybh = czybh;
	}

	@Column(name = "BMBH", length = 20)

	public String getBmbh() {
		return this.bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name = "JBBH", length = 20)

	public String getJbbh() {
		return this.jbbh;
	}

	public void setJbbh(String jbbh) {
		this.jbbh = jbbh;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CZSJ", length = 10)

	public Date getCzsj() {
		return this.czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

}