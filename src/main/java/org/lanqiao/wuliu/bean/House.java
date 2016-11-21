package org.lanqiao.wuliu.bean;

import java.util.Date;

/**
 * 仓库表
 * @author 杨明静
 *
 */
public class House {
	private Integer houseId;
	private String houseNum;
	private Date houseArrDate;
	private String houseRemark;
	private Integer goId;
	private Integer carId;

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public Date getHouseArrDate() {
		return houseArrDate;
	}

	public void setHouseArrDate(Date houseArrDate) {
		this.houseArrDate = houseArrDate;
	}

	public String getHouseRemark() {
		return houseRemark;
	}

	public void setHouseRemark(String houseRemark) {
		this.houseRemark = houseRemark;
	}

	public Integer getGoId() {
		return goId;
	}

	public void setGoId(Integer goId) {
		this.goId = goId;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}
}
