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
 * Dw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dw", catalog = "xinsd")

public class Dw implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mc;
	private Set<Bclb> bclbs = new HashSet<Bclb>(0);
	private Set<Cplb> cplbs = new HashSet<Cplb>(0);
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
	public Dw() {
	}

	/** full constructor */
	public Dw(String mc, Set<Bclb> bclbs, Set<Cplb> cplbs) {
		this.mc = mc;
		this.bclbs = bclbs;
		this.cplbs = cplbs;
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

	@Column(name = "mc", length = 20)

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dw")

	public Set<Bclb> getBclbs() {
		return this.bclbs;
	}

	public void setBclbs(Set<Bclb> bclbs) {
		this.bclbs = bclbs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dw")

	public Set<Cplb> getCplbs() {
		return this.cplbs;
	}

	public void setCplbs(Set<Cplb> cplbs) {
		this.cplbs = cplbs;
	}

}