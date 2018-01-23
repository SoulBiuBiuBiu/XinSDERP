package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Bcplb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bcplb", catalog = "xinsd")

public class Bcplb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bcpcz;
	private String bcpgg;
	private Integer bcplx;
	private String bcpmz;
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
	public Bcplb() {
	}

	/** full constructor */
	public Bcplb(String bcpcz, String bcpgg, Integer bcplx, String bcpmz, Integer dwId) {
		this.bcpcz = bcpcz;
		this.bcpgg = bcpgg;
		this.bcplx = bcplx;
		this.bcpmz = bcpmz;
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

	@Column(name = "bcpcz")

	public String getBcpcz() {
		return this.bcpcz;
	}

	public void setBcpcz(String bcpcz) {
		this.bcpcz = bcpcz;
	}

	@Column(name = "bcpgg")

	public String getBcpgg() {
		return this.bcpgg;
	}

	public void setBcpgg(String bcpgg) {
		this.bcpgg = bcpgg;
	}

	@Column(name = "bcplx")

	public Integer getBcplx() {
		return this.bcplx;
	}

	public void setBcplx(Integer bcplx) {
		this.bcplx = bcplx;
	}

	@Column(name = "bcpmz")

	public String getBcpmz() {
		return this.bcpmz;
	}

	public void setBcpmz(String bcpmz) {
		this.bcpmz = bcpmz;
	}

	@Column(name = "dw_id")

	public Integer getDwId() {
		return this.dwId;
	}

	public void setDwId(Integer dwId) {
		this.dwId = dwId;
	}

}