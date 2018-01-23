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

import org.hibernate.annotations.GenericGenerator;

/**
 * Cplb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cplb", catalog = "xinsd")

public class Cplb implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dw dw;
	private String gg;
	private String mz;
	private String xh;
	private Set<Bom> boms = new HashSet<Bom>(0);
	private Set<Cpck> cpcks = new HashSet<Cpck>(0);
	private Set<Cpck> cpcks_1 = new HashSet<Cpck>(0);
	private Set<Cpck> cpcks_2 = new HashSet<Cpck>(0);
	private Set<DdCplb> ddCplbs = new HashSet<DdCplb>(0);
	private Set<Bom> boms_1 = new HashSet<Bom>(0);
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
	public Cplb() {
	}

	/** full constructor */
	public Cplb(Dw dw, String gg, String mz, String xh, Set<Bom> boms, Set<Cpck> cpcks, Set<Cpck> cpcks_1,
			Set<Cpck> cpcks_2, Set<DdCplb> ddCplbs, Set<Bom> boms_1) {
		this.dw = dw;
		this.gg = gg;
		this.mz = mz;
		this.xh = xh;
		this.boms = boms;
		this.cpcks = cpcks;
		this.cpcks_1 = cpcks_1;
		this.cpcks_2 = cpcks_2;
		this.ddCplbs = ddCplbs;
		this.boms_1 = boms_1;
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

	@Column(name = "gg")

	public String getGg() {
		return this.gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	@Column(name = "mz")

	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	@Column(name = "xh")

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<Bom> getBoms() {
		return this.boms;
	}

	public void setBoms(Set<Bom> boms) {
		this.boms = boms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<Cpck> getCpcks() {
		return this.cpcks;
	}

	public void setCpcks(Set<Cpck> cpcks) {
		this.cpcks = cpcks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<Cpck> getCpcks_1() {
		return this.cpcks_1;
	}

	public void setCpcks_1(Set<Cpck> cpcks_1) {
		this.cpcks_1 = cpcks_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<Cpck> getCpcks_2() {
		return this.cpcks_2;
	}

	public void setCpcks_2(Set<Cpck> cpcks_2) {
		this.cpcks_2 = cpcks_2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<DdCplb> getDdCplbs() {
		return this.ddCplbs;
	}

	public void setDdCplbs(Set<DdCplb> ddCplbs) {
		this.ddCplbs = ddCplbs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cplb")

	public Set<Bom> getBoms_1() {
		return this.boms_1;
	}

	public void setBoms_1(Set<Bom> boms_1) {
		this.boms_1 = boms_1;
	}

}