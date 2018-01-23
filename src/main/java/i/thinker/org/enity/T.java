package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * T entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t", catalog = "xinsd")

public class T implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tm;
	private String zt;
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
	public T() {
	}

	/** full constructor */
	public T(String tm, String zt) {
		this.tm = tm;
		this.zt = zt;
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

	@Column(name = "tm", length = 20)

	public String getTm() {
		return this.tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	@Column(name = "zt", length = 20)

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

}