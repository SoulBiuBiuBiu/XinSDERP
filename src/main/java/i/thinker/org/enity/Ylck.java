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
 * Ylck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ylck", catalog = "xinsd")

public class Ylck implements java.io.Serializable {

	// Fields

	private Long id;
	private String dh;
	private String gph;
	private String jh;
	private String ph;
	private Timestamp rq;
	private Long sl;
	private Long zl;
	private String wz;
	private Boolean bs;
	private String rlh;
	private Timestamp scrq;
	private String czy;
	private Integer yllbId;
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
	public Ylck() {
	}

	/** full constructor */
	public Ylck(String dh, String gph, String jh, String ph, Timestamp rq, Long sl, Long zl, String wz, Boolean bs,
			String rlh, Timestamp scrq, String czy, Integer yllbId, String bh) {
		this.dh = dh;
		this.gph = gph;
		this.jh = jh;
		this.ph = ph;
		this.rq = rq;
		this.sl = sl;
		this.zl = zl;
		this.wz = wz;
		this.bs = bs;
		this.rlh = rlh;
		this.scrq = scrq;
		this.czy = czy;
		this.yllbId = yllbId;
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

	@Column(name = "dh", length = 15)

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "gph")

	public String getGph() {
		return this.gph;
	}

	public void setGph(String gph) {
		this.gph = gph;
	}

	@Column(name = "jh")

	public String getJh() {
		return this.jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	@Column(name = "ph")

	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Column(name = "rq", length = 19)

	public Timestamp getRq() {
		return this.rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	@Column(name = "sl", precision = 15, scale = 0)

	public Long getSl() {
		return this.sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	@Column(name = "zl", precision = 15, scale = 0)

	public Long getZl() {
		return this.zl;
	}

	public void setZl(Long zl) {
		this.zl = zl;
	}

	@Column(name = "wz", length = 20)

	public String getWz() {
		return this.wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	@Column(name = "bs")

	public Boolean getBs() {
		return this.bs;
	}

	public void setBs(Boolean bs) {
		this.bs = bs;
	}

	@Column(name = "rlh")

	public String getRlh() {
		return this.rlh;
	}

	public void setRlh(String rlh) {
		this.rlh = rlh;
	}

	@Column(name = "scrq", length = 19)

	public Timestamp getScrq() {
		return this.scrq;
	}

	public void setScrq(Timestamp scrq) {
		this.scrq = scrq;
	}

	@Column(name = "czy", length = 20)

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	@Column(name = "yllb_id")

	public Integer getYllbId() {
		return this.yllbId;
	}

	public void setYllbId(Integer yllbId) {
		this.yllbId = yllbId;
	}

	@Column(name = "bh", length = 25)

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

}