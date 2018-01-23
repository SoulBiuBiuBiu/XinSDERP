package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * DdCplbId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class DdCplbId implements java.io.Serializable {

	// Fields

	private Integer ddsId;
	private Integer cplbsId;
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
	public DdCplbId() {
	}

	/** full constructor */
	public DdCplbId(Integer ddsId, Integer cplbsId) {
		this.ddsId = ddsId;
		this.cplbsId = cplbsId;
	}

	// Property accessors

	@Column(name = "dds_id", nullable = false)

	public Integer getDdsId() {
		return this.ddsId;
	}

	public void setDdsId(Integer ddsId) {
		this.ddsId = ddsId;
	}

	@Column(name = "cplbs_id", nullable = false)

	public Integer getCplbsId() {
		return this.cplbsId;
	}

	public void setCplbsId(Integer cplbsId) {
		this.cplbsId = cplbsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DdCplbId))
			return false;
		DdCplbId castOther = (DdCplbId) other;

		return ((this.getDdsId() == castOther.getDdsId()) || (this.getDdsId() != null && castOther.getDdsId() != null
				&& this.getDdsId().equals(castOther.getDdsId())))
				&& ((this.getCplbsId() == castOther.getCplbsId()) || (this.getCplbsId() != null
						&& castOther.getCplbsId() != null && this.getCplbsId().equals(castOther.getCplbsId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDdsId() == null ? 0 : this.getDdsId().hashCode());
		result = 37 * result + (getCplbsId() == null ? 0 : this.getCplbsId().hashCode());
		return result;
	}

}