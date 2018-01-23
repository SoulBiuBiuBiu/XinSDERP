package i.thinker.org.enity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Bom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bom", catalog = "xinsd")

public class Bom implements java.io.Serializable {

	// Fields

	private BomId id;
	private Mjlb mjlb;
	private Cplb cplb;
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
	public Bom() {
	}

	/** minimal constructor */
	public Bom(BomId id) {
		this.id = id;
	}

	/** full constructor */
	public Bom(BomId id, Mjlb mjlb, Cplb cplb) {
		this.id = id;
		this.mjlb = mjlb;
		this.cplb = cplb;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cplId", column = @Column(name = "cpl_id") ),
			@AttributeOverride(name = "mjId", column = @Column(name = "mj_id") ),
			@AttributeOverride(name = "sl", column = @Column(name = "sl", length = 10) ) })

	public BomId getId() {
		return this.id;
	}

	public void setId(BomId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mj_id", insertable = false, updatable = false)

	public Mjlb getMjlb() {
		return this.mjlb;
	}

	public void setMjlb(Mjlb mjlb) {
		this.mjlb = mjlb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpl_id", insertable = false, updatable = false)

	public Cplb getCplb() {
		return this.cplb;
	}

	public void setCplb(Cplb cplb) {
		this.cplb = cplb;
	}

}