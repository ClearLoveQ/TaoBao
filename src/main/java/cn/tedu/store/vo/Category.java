package cn.tedu.store.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类值对象
 * @author soft01
 *
 */
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int parentId;
	private String name;
	private int isParent;
	private int status;
	private int sortOrder;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Category() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Category(int id, int parentId, String name, int isParent, int status, int sortOrder, Date createdTime,
			Date modifiedTime, String createdUser, String modifiedUser) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.isParent = isParent;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + id;
		result = prime * result + isParent;
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + parentId;
		result = prime * result + sortOrder;
		result = prime * result + status;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (id != other.id)
			return false;
		if (isParent != other.isParent)
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId != other.parentId)
			return false;
		if (sortOrder != other.sortOrder)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", isParent=" + isParent
				+ ", status=" + status + ", sortOrder=" + sortOrder + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
	
}
