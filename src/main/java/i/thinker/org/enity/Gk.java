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
 * Gk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gk", catalog = "xinsd")

public class Gk implements java.io.Serializable {

	// Fields

	private Integer id;
	private Bclb bclb;
	private String frdb;
	private String sh;
	private String dh;
	private String dw;
	private String dz;
	private String gkdh;
	private String gkdw;
	private String gkdz;
	private String gkxm;
	private Set<Dd> dds = new HashSet<Dd>(0);
	private String operate;

	// Constructors

	/** default constructor */
	public Gk() {
	}
	@Transient
	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	/** full constructor */
	public Gk(Bclb bclb, String frdb, String sh, String dh, String dw, String dz, String gkdh, String gkdw, String gkdz,
			String gkxm, Set<Dd> dds) {
		this.bclb = bclb;
		this.frdb = frdb;
		this.sh = sh;
		this.dh = dh;
		this.dw = dw;
		this.dz = dz;
		this.gkdh = gkdh;
		this.gkdw = gkdw;
		this.gkdz = gkdz;
		this.gkxm = gkxm;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bc_id")

	public Bclb getBclb() {
		return this.bclb;
	}

	public void setBclb(Bclb bclb) {
		this.bclb = bclb;
	}

	@Column(name = "frdb")

	public String getFrdb() {
		return this.frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	@Column(name = "sh", length = 45)

	public String getSh() {
		return this.sh;
	}

	public void setSh(String sh) {
		this.sh = sh;
	}

	@Column(name = "dh")

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "dw")

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	@Column(name = "dz")

	public String getDz() {
		return this.dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	@Column(name = "gkdh")

	public String getGkdh() {
		return this.gkdh;
	}

	public void setGkdh(String gkdh) {
		this.gkdh = gkdh;
	}

	@Column(name = "gkdw")

	public String getGkdw() {
		return this.gkdw;
	}

	public void setGkdw(String gkdw) {
		this.gkdw = gkdw;
	}

	@Column(name = "gkdz")

	public String getGkdz() {
		return this.gkdz;
	}

	public void setGkdz(String gkdz) {
		this.gkdz = gkdz;
	}

	@Column(name = "gkxm")

	public String getGkxm() {
		return this.gkxm;
	}

	public void setGkxm(String gkxm) {
		this.gkxm = gkxm;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gk")

	public Set<Dd> getDds() {
		return this.dds;
	}

	public void setDds(Set<Dd> dds) {
		this.dds = dds;
	}

}