package i.thinker.org.enity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Bcck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bcck", catalog = "xinsd")

public class Bcck implements java.io.Serializable {

	// Fields

	private Long id;
	private Bclb bclb;
	private Boolean bs;
	private Long zl;
	private Long sl;
	private Timestamp rq;
	private String dh;
	private String wz;
	private String czy;
	private String bh;
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
	public Bcck() {
	}

	/** full constructor */
	public Bcck(Bclb bclb, Boolean bs, Long zl, Long sl, Timestamp rq, String dh, String wz, String czy, String bh) {
		this.bclb = bclb;
		this.bs = bs;
		this.zl = zl;
		this.sl = sl;
		this.rq = rq;
		this.dh = dh;
		this.wz = wz;
		this.czy = czy;
		this.bh = bh;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bc_id")

	public Bclb getBclb() {
		return this.bclb;
	}

	public void setBclb(Bclb bclb) {
		this.bclb = bclb;
	}

	@Column(name = "bs")

	public Boolean getBs() {
		return this.bs;
	}

	public void setBs(Boolean bs) {
		this.bs = bs;
	}

	@Column(name = "zl", precision = 15, scale = 0)

	public Long getZl() {
		return this.zl;
	}

	public void setZl(Long zl) {
		this.zl = zl;
	}

	@Column(name = "sl", precision = 15, scale = 0)

	public Long getSl() {
		return this.sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	@Column(name = "rq", length = 19)

	public Timestamp getRq() {
		return this.rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	@Column(name = "dh", length = 15)

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "wz", length = 20)

	public String getWz() {
		return this.wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	@Column(name = "czy", length = 20)

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	@Column(name = "bh")

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

}