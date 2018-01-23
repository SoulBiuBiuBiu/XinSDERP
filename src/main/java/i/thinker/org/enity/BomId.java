package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BomId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class BomId implements java.io.Serializable {

	// Fields

	private Integer cplId;
	private Integer mjId;
	private String sl;

	// Constructors

	/** default constructor */
	public BomId() {
	}

	/** full constructor */
	public BomId(Integer cplId, Integer mjId, String sl) {
		this.cplId = cplId;
		this.mjId = mjId;
		this.sl = sl;
	}

	// Property accessors

	@Column(name = "cpl_id")

	public Integer getCplId() {
		return this.cplId;
	}

	public void setCplId(Integer cplId) {
		this.cplId = cplId;
	}

	@Column(name = "mj_id")

	public Integer getMjId() {
		return this.mjId;
	}

	public void setMjId(Integer mjId) {
		this.mjId = mjId;
	}

	@Column(name = "sl", length = 10)

	public String getSl() {
		return this.sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BomId))
			return false;
		BomId castOther = (BomId) other;

		return ((this.getCplId() == castOther.getCplId()) || (this.getCplId() != null && castOther.getCplId() != null
				&& this.getCplId().equals(castOther.getCplId())))
				&& ((this.getMjId() == castOther.getMjId()) || (this.getMjId() != null && castOther.getMjId() != null
						&& this.getMjId().equals(castOther.getMjId())))
				&& ((this.getSl() == castOther.getSl()) || (this.getSl() != null && castOther.getSl() != null
						&& this.getSl().equals(castOther.getSl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCplId() == null ? 0 : this.getCplId().hashCode());
		result = 37 * result + (getMjId() == null ? 0 : this.getMjId().hashCode());
		result = 37 * result + (getSl() == null ? 0 : this.getSl().hashCode());
		return result;
	}

}