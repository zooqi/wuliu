package org.lanqiao.wuliu.bean;

/**
 * 考勤表
 * 
 * @author 杨明静
 *
 */
public class Attent {
	private Integer attentId;
	private String attentDate;
	private double attentNum;
	private double attentReasonNum;
	private String attentReason;
	private double attentOverTimeNum;
	private double attentOverTimePay;
	private double attentBonus;
	private String attentRemark;
	private double empWage;
	private Emp emp;

	public Integer getAttentId() {
		return attentId;
	}

	public void setAttentId(Integer attentId) {
		this.attentId = attentId;
	}

	public String getAttentDate() {
		return attentDate;
	}

	public void setAttentDate(String attentDate) {
		this.attentDate = attentDate;
	}

	public double getAttentNum() {
		return attentNum;
	}

	public void setAttentNum(double attentNum) {
		this.attentNum = attentNum;
	}

	public double getAttentReasonNum() {
		return attentReasonNum;
	}

	public void setAttentReasonNum(double attentReasonNum) {
		this.attentReasonNum = attentReasonNum;
	}

	public String getAttentReason() {
		return attentReason;
	}

	public void setAttentReason(String attentReason) {
		this.attentReason = attentReason;
	}

	public double getAttentOverTimeNum() {
		return attentOverTimeNum;
	}

	public void setAttentOverTimeNum(double attentOverTimeNum) {
		this.attentOverTimeNum = attentOverTimeNum;
	}

	public double getAttentOverTimePay() {
		return attentOverTimePay;
	}

	public void setAttentOverTimePay(double attentOverTimePay) {
		this.attentOverTimePay = attentOverTimePay;
	}

	public double getAttentBonus() {
		return attentBonus;
	}

	public void setAttentBonus(double attentBonus) {
		this.attentBonus = attentBonus;
	}

	public String getAttentRemark() {
		return attentRemark;
	}

	public double getEmpWage() {
		return empWage;
	}

	public void setEmpWage(double empWage) {
		this.empWage = empWage;
	}

	public void setAttentRemark(String attentRemark) {
		this.attentRemark = attentRemark;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
