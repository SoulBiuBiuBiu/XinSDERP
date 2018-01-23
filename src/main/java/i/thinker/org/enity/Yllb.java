package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Yllb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yllb", catalog = "xinsd")

public class Yllb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ylcz;
	private String ylgg;
	private String ylmz;
	private Integer dwId;
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
	public Yllb() {
	}

	/** full constructor */
	public Yllb(String ylcz, String ylgg, String ylmz, Integer dwId) {
		this.ylcz = ylcz;
		this.ylgg = ylgg;
		this.ylmz = ylmz;
		this.dwId = dwId;
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

	@Column(name = "ylcz")

	public String getYlcz() {
		return this.ylcz;
	}

	public void setYlcz(String ylcz) {
		this.ylcz = ylcz;
	}

	@Column(name = "ylgg")

	public String getYlgg() {
		return this.ylgg;
	}

	public void setYlgg(String ylgg) {
		this.ylgg = ylgg;
	}

	@Column(name = "ylmz")

	public String getYlmz() {
		return this.ylmz;
	}

	public void setYlmz(String ylmz) {
		this.ylmz = ylmz;
	}

	@Column(name = "dw_id")

	public Integer getDwId() {
		return this.dwId;
	}

	public void setDwId(Integer dwId) {
		this.dwId = dwId;
	}

}