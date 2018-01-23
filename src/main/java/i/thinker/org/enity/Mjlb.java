package i.thinker.org.enity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * Mjlb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mjlb", catalog = "xinsd")

public class Mjlb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mc;
	private String cllx;
	private Integer sm;
	private Integer dwId;
	private Set<Bom> boms = new HashSet<Bom>(0);
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
	public Mjlb() {
	}

	/** full constructor */
	public Mjlb(String mc, String cllx, Integer sm, Integer dwId, Set<Bom> boms, Set<Bom> boms_1) {
		this.mc = mc;
		this.cllx = cllx;
		this.sm = sm;
		this.dwId = dwId;
		this.boms = boms;
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

	@Column(name = "mc")

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@Column(name = "cllx")

	public String getCllx() {
		return this.cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	@Column(name = "sm")

	public Integer getSm() {
		return this.sm;
	}

	public void setSm(Integer sm) {
		this.sm = sm;
	}

	@Column(name = "dw_id")

	public Integer getDwId() {
		return this.dwId;
	}

	public void setDwId(Integer dwId) {
		this.dwId = dwId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mjlb")

	public Set<Bom> getBoms() {
		return this.boms;
	}

	public void setBoms(Set<Bom> boms) {
		this.boms = boms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mjlb")

	public Set<Bom> getBoms_1() {
		return this.boms_1;
	}

	public void setBoms_1(Set<Bom> boms_1) {
		this.boms_1 = boms_1;
	}

}