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
 * GmsUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gms_user", catalog = "xinsd", uniqueConstraints = @UniqueConstraint(columnNames = "username") )

public class GmsUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String nickname;
	private String password;
	private Integer groupId;
	private Integer createTime;
	private Integer updateTime;
	private String logip;
	private Integer logdatetime;
	private String remark;
	private Integer status;
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
	public GmsUser() {
	}

	/** minimal constructor */
	public GmsUser(String username, String password, Integer createTime, Integer updateTime, Integer logdatetime) {
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.logdatetime = logdatetime;
	}

	/** full constructor */
	public GmsUser(String username, String nickname, String password, Integer groupId, Integer createTime,
			Integer updateTime, String logip, Integer logdatetime, String remark, Integer status) {
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.groupId = groupId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.logip = logip;
		this.logdatetime = logdatetime;
		this.remark = remark;
		this.status = status;
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

	@Column(name = "username", unique = true, nullable = false, length = 32)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "nickname", length = 120)

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "password", nullable = false, length = 64)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "group_id")

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	@Column(name = "logip", length = 20)

	public String getLogip() {
		return this.logip;
	}

	public void setLogip(String logip) {
		this.logip = logip;
	}

	@Column(name = "logdatetime", nullable = false)

	public Integer getLogdatetime() {
		return this.logdatetime;
	}

	public void setLogdatetime(Integer logdatetime) {
		this.logdatetime = logdatetime;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}