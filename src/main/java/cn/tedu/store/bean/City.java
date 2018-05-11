package cn.tedu.store.bean;

import java.io.Serializable;

/**
 * 城市实体类
 * @author soft01
 *
 */
public class City implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String cityCode;
	private String cityName;
	public City() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public City(int id, String cityCode, String cityName) {
		super();
		this.id = id;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
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
		City other = (City) obj;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", cityCode=" + cityCode + ", cityName=" + cityName + "]";
	}
	
	
}
