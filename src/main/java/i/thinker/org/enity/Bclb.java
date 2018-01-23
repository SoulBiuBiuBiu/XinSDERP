package i.thinker.org.enity;

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

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;

/**
 * Bclb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bclb", catalog = "xinsd")

public class Bclb implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dw dw;
	private String bcgg;
	private String bcmz;
	private Integer rl;
	
	private Set<Dd> dds = new HashSet<Dd>(0);
	private Set<Bcck> bccks = new HashSet<Bcck>(0);
	private Set<Gk> gks = new HashSet<Gk>(0);
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
	public Bclb() {
	}

	/** full constructor */
	public Bclb(Dw dw, String bcgg, String bcmz, Integer rl, Set<Dd> dds, Set<Bcck> bccks, Set<Bcck> bccks_1,
			Set<Gk> gks) {
		this.dw = dw;
		this.bcgg = bcgg;
		this.bcmz = bcmz;
		this.rl = rl;
		this.dds = dds;
		this.bccks = bccks;
		this.gks = gks;
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
	@JoinColumn(name = "dw_id")

	public Dw getDw() {
		return this.dw;
	}

	public void setDw(Dw dw) {
		this.dw = dw;
	}

	@Column(name = "bcgg")

	public String getBcgg() {
		return this.bcgg;
	}

	public void setBcgg(String bcgg) {
		this.bcgg = bcgg;
	}

	@Column(name = "bcmz")

	public String getBcmz() {
		return this.bcmz;
	}

	public void setBcmz(String bcmz) {
		this.bcmz = bcmz;
	}

	@Column(name = "rl")

	public Integer getRl() {
		return this.rl;
	}

	public void setRl(Integer rl) {
		this.rl = rl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bclb")

	public Set<Dd> getDds() {
		return this.dds;
	}

	public void setDds(Set<Dd> dds) {
		this.dds = dds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bclb")

	public Set<Bcck> getBccks() {
		return this.bccks;
	}

	public void setBccks(Set<Bcck> bccks) {
		this.bccks = bccks;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bclb")

	public Set<Gk> getGks() {
		return this.gks;
	}

	public void setGks(Set<Gk> gks) {
		this.gks = gks;
	}

}