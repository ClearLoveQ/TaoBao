package cn.tedu.store.bean;

import java.io.Serializable;

/**
 * 区域实体类
 * @author soft01
 *
 */
public class Area implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String areaCode;
	private String areaName;
	public Area() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Area(int id, String areaCode, String areaName) {
		super();
		this.id = id;
		this.areaCode = areaCode;
		this.areaName = areaName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
		result = prime * result + id;
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
		Area other = (Area) obj;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", areaCode=" + areaCode + ", areaName=" + areaName + "]";
	}
	
}
