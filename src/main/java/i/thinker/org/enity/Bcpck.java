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
 * Bcpck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bcpck", catalog = "xinsd")

public class Bcpck implements java.io.Serializable {

	// Fields

	private Long id;
	private String bcplh;
	private Double bcpqzz;
	private Boolean bs;
	private Long zl;
	private Long sl;
	private Timestamp rq;
	private String wz;
	private String dh;
	private String bcptb;
	private String bcpth;
	private String bcpzz;
	private String czy;
	private Integer bcplbId;
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
	public Bcpck() {
	}

	/** full constructor */
	public Bcpck(String bcplh, Double bcpqzz, Boolean bs, Long zl, Long sl, Timestamp rq, String wz, String dh,
			String bcptb, String bcpth, String bcpzz, String czy, Integer bcplbId) {
		this.bcplh = bcplh;
		this.bcpqzz = bcpqzz;
		this.bs = bs;
		this.zl = zl;
		this.sl = sl;
		this.rq = rq;
		this.wz = wz;
		this.dh = dh;
		this.bcptb = bcptb;
		this.bcpth = bcpth;
		this.bcpzz = bcpzz;
		this.czy = czy;
		this.bcplbId = bcplbId;
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

	@Column(name = "bcplh")

	public String getBcplh() {
		return this.bcplh;
	}

	public void setBcplh(String bcplh) {
		this.bcplh = bcplh;
	}

	@Column(name = "bcpqzz", precision = 22, scale = 0)

	public Double getBcpqzz() {
		return this.bcpqzz;
	}

	public void setBcpqzz(Double bcpqzz) {
		this.bcpqzz = bcpqzz;
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

	@Column(name = "bcptb")

	public String getBcptb() {
		return this.bcptb;
	}

	public void setBcptb(String bcptb) {
		this.bcptb = bcptb;
	}

	@Column(name = "bcpth")

	public String getBcpth() {
		return this.bcpth;
	}

	public void setBcpth(String bcpth) {
		this.bcpth = bcpth;
	}

	@Column(name = "bcpzz")

	public String getBcpzz() {
		return this.bcpzz;
	}

	public void setBcpzz(String bcpzz) {
		this.bcpzz = bcpzz;
	}

	@Column(name = "czy", length = 20)

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	@Column(name = "bcplb_id")

	public Integer getBcplbId() {
		return this.bcplbId;
	}

	public void setBcplbId(Integer bcplbId) {
		this.bcplbId = bcplbId;
	}

}