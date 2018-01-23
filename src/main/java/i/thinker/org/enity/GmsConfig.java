package i.thinker.org.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * GmsConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gms_config", catalog = "xinsd", uniqueConstraints = @UniqueConstraint(columnNames = "name") )

public class GmsConfig implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Short type;
	private String title;
	private Short group;
	private String extra;
	private String remark;
	private Integer createTime;
	private Integer updateTime;
	private Integer status;
	private String value;
	private Integer sort;
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
	public GmsConfig() {
	}

	/** minimal constructor */
	public GmsConfig(String name, Short type, String title, Short group, String extra, String remark,
			Integer createTime, Integer updateTime, Integer status, Integer sort) {
		this.name = name;
		this.type = type;
		this.title = title;
		this.group = group;
		this.extra = extra;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.sort = sort;
	}

	/** full constructor */
	public GmsConfig(String name, Short type, String title, Short group, String extra, String remark,
			Integer createTime, Integer updateTime, Integer status, String value, Integer sort) {
		this.name = name;
		this.type = type;
		this.title = title;
		this.group = group;
		this.extra = extra;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.value = value;
		this.sort = sort;
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

	@Column(name = "name", unique = true, nullable = false, length = 30)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false)

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "title", nullable = false, length = 50)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "group", nullable = false)

	public Short getGroup() {
		return this.group;
	}

	public void setGroup(Short group) {
		this.group = group;
	}

	@Column(name = "extra", nullable = false)

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Column(name = "remark", nullable = false, length = 100)

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "create_time", nullable = false)

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", nullable = false)

	public Integer getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status", nullable = false)

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "value", length = 65535)

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "sort", nullable = false)

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}