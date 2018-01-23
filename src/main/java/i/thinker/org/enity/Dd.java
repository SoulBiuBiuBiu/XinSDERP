package i.thinker.org.enity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Dd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dd", catalog = "xinsd")

public class Dd implements java.io.Serializable {

	// Fields

	private Integer id;
	private Bclb bclb;
	private Gk gk;
	private String ddbh;
	private Timestamp ddrq;
	private Timestamp dhrq;
	private String bz;
	private BigDecimal je;
	private Timestamp jq;
	private String jsfsid;
	private Integer userId;
	private Set<DdCplb> ddCplbs = new HashSet<DdCplb>(0);
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
	public Dd() {
	}

	/** full constructor */
	public Dd(Bclb bclb, Gk gk, Lc lc, String ddbh, Timestamp ddrq, Timestamp dhrq, String bz, BigDecimal je,
			Timestamp jq, String jsfsid, Integer userId, Set<DdCplb> ddCplbs) {
		this.bclb = bclb;
		this.gk = gk;
		
		this.ddbh = ddbh;
		this.ddrq = ddrq;
		this.dhrq = dhrq;
		this.bz = bz;
		this.je = je;
		this.jq = jq;
		this.jsfsid = jsfsid;
		this.userId = userId;
		this.ddCplbs = ddCplbs;
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
	@JoinColumn(name = "bc_id")

	public Bclb getBclb() {
		return this.bclb;
	}

	public void setBclb(Bclb bclb) {
		this.bclb = bclb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gk_id")

	public Gk getGk() {
		return this.gk;
	}

	public void setGk(Gk gk) {
		this.gk = gk;
	}


	@Column(name = "ddbh")

	public String getDdbh() {
		return this.ddbh;
	}

	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}

	@Column(name = "ddrq", length = 19)

	public Timestamp getDdrq() {
		return this.ddrq;
	}

	public void setDdrq(Timestamp ddrq) {
		this.ddrq = ddrq;
	}

	@Column(name = "dhrq", length = 19)

	public Timestamp getDhrq() {
		return this.dhrq;
	}

	public void setDhrq(Timestamp dhrq) {
		this.dhrq = dhrq;
	}

	@Column(name = "bz", length = 50)

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "je", precision = 20, scale = 0)

	public BigDecimal getJe() {
		return this.je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	@Column(name = "jq", length = 19)

	public Timestamp getJq() {
		return this.jq;
	}

	public void setJq(Timestamp jq) {
		this.jq = jq;
	}

	@Column(name = "jsfsid", length = 50)

	public String getJsfsid() {
		return this.jsfsid;
	}

	public void setJsfsid(String jsfsid) {
		this.jsfsid = jsfsid;
	}

	@Column(name = "user_id")

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dd")

	public Set<DdCplb> getDdCplbs() {
		return this.ddCplbs;
	}

	public void setDdCplbs(Set<DdCplb> ddCplbs) {
		this.ddCplbs = ddCplbs;
	}

}