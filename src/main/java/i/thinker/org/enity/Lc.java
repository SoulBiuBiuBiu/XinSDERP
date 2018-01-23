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
 * Lc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lc", catalog = "xinsd")

public class Lc implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mc;
	private Set<Dd> dds = new HashSet<Dd>(0);
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
	public Lc() {
	}

	/** full constructor */
	public Lc(String mc, Set<Dd> dds) {
		this.mc = mc;
		this.dds = dds;
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

	@Column(name = "mc", length = 45)

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lc")

	public Set<Dd> getDds() {
		return this.dds;
	}

	public void setDds(Set<Dd> dds) {
		this.dds = dds;
	}

}