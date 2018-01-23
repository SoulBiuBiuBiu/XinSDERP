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
 * DdCplb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dd_cplb", catalog = "xinsd")

public class DdCplb implements java.io.Serializable {

	// Fields

	private DdCplbId id;
	private Cplb cplb;
	private Dd dd;
	private Integer sl;
	private Long bj;
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
	public DdCplb() {
	}

	/** minimal constructor */
	public DdCplb(DdCplbId id, Cplb cplb, Dd dd) {
		this.id = id;
		this.cplb = cplb;
		this.dd = dd;
	}

	/** full constructor */
	public DdCplb(DdCplbId id, Cplb cplb, Dd dd, Integer sl, Long bj) {
		this.id = id;
		this.cplb = cplb;
		this.dd = dd;
		this.sl = sl;
		this.bj = bj;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "ddsId", column = @Column(name = "dds_id", nullable = false) ),
			@AttributeOverride(name = "cplbsId", column = @Column(name = "cplbs_id", nullable = false) ) })

	public DdCplbId getId() {
		return this.id;
	}

	public void setId(DdCplbId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cplbs_id", nullable = false, insertable = false, updatable = false)

	public Cplb getCplb() {
		return this.cplb;
	}

	public void setCplb(Cplb cplb) {
		this.cplb = cplb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dds_id", nullable = false, insertable = false, updatable = false)

	public Dd getDd() {
		return this.dd;
	}

	public void setDd(Dd dd) {
		this.dd = dd;
	}

	@Column(name = "sl")

	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	@Column(name = "bj", precision = 10, scale = 0)

	public Long getBj() {
		return this.bj;
	}

	public void setBj(Long bj) {
		this.bj = bj;
	}

}