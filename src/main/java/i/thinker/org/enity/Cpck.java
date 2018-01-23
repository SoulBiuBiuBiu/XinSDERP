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
 * Cpck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cpck", catalog = "xinsd")

public class Cpck implements java.io.Serializable {

	// Fields

	private Integer id;
	private Cplb cplb;
	private Integer cpsl;
	private String cpth;
	private Double cpzl;
	private Timestamp rkrq;
	private Boolean bs;
	private String czy;
	private String dh;
	private Timestamp rq;
	private Long sl;
	private String wz;
	private Long zl;
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
	public Cpck() {
	}

	/** full constructor */
	public Cpck(Cplb cplb, Integer cpsl, String cpth, Double cpzl, Timestamp rkrq, Boolean bs, String czy, String dh,
			Timestamp rq, Long sl, String wz, Long zl) {
		this.cplb = cplb;
		this.cpsl = cpsl;
		this.cpth = cpth;
		this.cpzl = cpzl;
		this.rkrq = rkrq;
		this.bs = bs;
		this.czy = czy;
		this.dh = dh;
		this.rq = rq;
		this.sl = sl;
		this.wz = wz;
		this.zl = zl;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpid")

	public Cplb getCplb() {
		return this.cplb;
	}

	public void setCplb(Cplb cplb) {
		this.cplb = cplb;
	}

	@Column(name = "cpsl")

	public Integer getCpsl() {
		return this.cpsl;
	}

	public void setCpsl(Integer cpsl) {
		this.cpsl = cpsl;
	}

	@Column(name = "cpth")

	public String getCpth() {
		return this.cpth;
	}

	public void setCpth(String cpth) {
		this.cpth = cpth;
	}

	@Column(name = "cpzl", precision = 22, scale = 0)

	public Double getCpzl() {
		return this.cpzl;
	}

	public void setCpzl(Double cpzl) {
		this.cpzl = cpzl;
	}

	@Column(name = "rkrq", length = 19)

	public Timestamp getRkrq() {
		return this.rkrq;
	}

	public void setRkrq(Timestamp rkrq) {
		this.rkrq = rkrq;
	}

	@Column(name = "bs")

	public Boolean getBs() {
		return this.bs;
	}

	public void setBs(Boolean bs) {
		this.bs = bs;
	}

	@Column(name = "czy", length = 20)

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	@Column(name = "dh", length = 15)

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "rq", length = 19)

	public Timestamp getRq() {
		return this.rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	@Column(name = "sl")

	public Long getSl() {
		return this.sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	@Column(name = "wz", length = 20)

	public String getWz() {
		return this.wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	@Column(name = "zl")

	public Long getZl() {
		return this.zl;
	}

	public void setZl(Long zl) {
		this.zl = zl;
	}

}