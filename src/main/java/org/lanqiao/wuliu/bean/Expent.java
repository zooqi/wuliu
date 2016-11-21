package org.lanqiao.wuliu.bean;

import java.util.Date;

/**
 * 支出表
 * 
 * @author 杨明静
 *
 */
public class Expent {
	private Integer expId;
	private String expFunction;
	private Double expMoney;
	private Date expDate;
	private String expRemark;
	private Emp emp;

	public Integer getExpId() {
		return expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public String getExpFunction() {
		return expFunction;
	}

	public void setExpFunction(String expFunction) {
		this.expFunction = expFunction;
	}

	public Double getExpMoney() {
		return expMoney;
	}

	public void setExpMoney(Double expMoney) {
		this.expMoney = expMoney;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getExpRemark() {
		return expRemark;
	}

	public void setExpRemark(String expRemark) {
		this.expRemark = expRemark;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
