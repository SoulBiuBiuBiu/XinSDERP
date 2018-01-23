package i.thinker.org.enity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Mjck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mjck", catalog = "xinsd")

public class Mjck implements java.io.Serializable {

	// Fields

	private Long id;
	private Boolean bs;
	private Long zl;
	private Long sl;
	private Timestamp rq;
	private String wz;
	private String dh;
	private Integer mjsm;
	private String mjzt;
	private String czy;
	private Integer mjlbId;
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
	public Mjck() {
	}

	/** full constructor */
	public Mjck(Boolean bs, Long zl, Long sl, Timestamp rq, String wz, String dh, Integer mjsm, String mjzt, String czy,
			Integer mjlbId) {
		this.bs = bs;
		this.zl = zl;
		this.sl = sl;
		this.rq = rq;
		this.wz = wz;
		this.dh = dh;
		this.mjsm = mjsm;
		this.mjzt = mjzt;
		this.czy = czy;
		this.mjlbId = mjlbId;
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

	@Column(name = "wz", length = 20)

	public String getWz() {
		return this.wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	@Column(name = "dh", length = 15)

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "mjsm")

	public Integer getMjsm() {
		return this.mjsm;
	}

	public void setMjsm(Integer mjsm) {
		this.mjsm = mjsm;
	}

	@Column(name = "mjzt")

	public String getMjzt() {
		return this.mjzt;
	}

	public void setMjzt(String mjzt) {
		this.mjzt = mjzt;
	}

	@Column(name = "czy", length = 20)

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	@Column(name = "mjlb_id")

	public Integer getMjlbId() {
		return this.mjlbId;
	}

	public void setMjlbId(Integer mjlbId) {
		this.mjlbId = mjlbId;
	}

}