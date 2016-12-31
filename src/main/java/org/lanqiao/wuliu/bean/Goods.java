package org.lanqiao.wuliu.bean;

import java.io.Serializable;

/**
 * 物流表
 * 
 * @author 杨明静
 *
 */
public class Goods implements Serializable {

	private Integer goId;
	private String goBank;
	private String goName;
	private String goPack;
	private Integer goNum;
	private Double goWeight;
	private Double goVolume;
	private String goSendMan;
	private String goSendPhone;
	private String goSendAddress;
	private String goForMan;
	private String goForPhone;
	private String goForAddress;
	private String goGetWay;
	private String goPayWay;
	private Double goPay;
	private Double goInsurancePay;
	private Double goReplacePay;
	private Double goCommission;
	private Double goDamagePay;
	private Double goTransitPay;
	private String goSiteEnd;
	private String goRemark;
	private Integer goType;
	private Integer goSmsStatus;
	private Logistics logistics;
	private static final long serialVersionUID = 3578834615726369308L;

	public Integer getGoId() {
		return goId;
	}

	public void setGoId(Integer goId) {
		this.goId = goId;
	}

	public String getGoBank() {
		return goBank;
	}

	public void setGoBank(String goBank) {
		this.goBank = goBank;
	}

	public String getGoName() {
		return goName;
	}

	public void setGoName(String goName) {
		this.goName = goName;
	}

	public String getGoPack() {
		return goPack;
	}

	public void setGoPack(String goPack) {
		this.goPack = goPack;
	}

	public Integer getGoNum() {
		return goNum;
	}

	public void setGoNum(Integer goNum) {
		this.goNum = goNum;
	}

	public Double getGoWeight() {
		return goWeight;
	}

	public void setGoWeight(Double goWeight) {
		this.goWeight = goWeight;
	}

	public Double getGoVolume() {
		return goVolume;
	}

	public void setGoVolume(Double goVolume) {
		this.goVolume = goVolume;
	}

	public String getGoSendMan() {
		return goSendMan;
	}

	public void setGoSendMan(String goSendMan) {
		this.goSendMan = goSendMan;
	}

	public String getGoSendPhone() {
		return goSendPhone;
	}

	public void setGoSendPhone(String goSendPhone) {
		this.goSendPhone = goSendPhone;
	}

	public String getGoSendAddress() {
		return goSendAddress;
	}

	public void setGoSendAddress(String goSendAddress) {
		this.goSendAddress = goSendAddress;
	}

	public String getGoForMan() {
		return goForMan;
	}

	public void setGoForMan(String goForMan) {
		this.goForMan = goForMan;
	}

	public String getGoForPhone() {
		return goForPhone;
	}

	public void setGoForPhone(String goForPhone) {
		this.goForPhone = goForPhone;
	}

	public String getGoForAddress() {
		return goForAddress;
	}

	public void setGoForAddress(String goForAddress) {
		this.goForAddress = goForAddress;
	}

	public String getGoGetWay() {
		return goGetWay;
	}

	public void setGoGetWay(String goGetWay) {
		this.goGetWay = goGetWay;
	}

	public String getGoPayWay() {
		return goPayWay;
	}

	public void setGoPayWay(String goPayWay) {
		this.goPayWay = goPayWay;
	}

	public Double getGoPay() {
		return goPay;
	}

	public void setGoPay(Double goPay) {
		this.goPay = goPay;
	}

	public Double getGoInsurancePay() {
		return goInsurancePay;
	}

	public void setGoInsurancePay(Double goInsurancePay) {
		this.goInsurancePay = goInsurancePay;
	}

	public Double getGoReplacePay() {
		return goReplacePay;
	}

	public void setGoReplacePay(Double goReplacePay) {
		this.goReplacePay = goReplacePay;
	}

	public Double getGoCommission() {
		return goCommission;
	}

	public void setGoCommission(Double goCommission) {
		this.goCommission = goCommission;
	}

	public Double getGoDamagePay() {
		return goDamagePay;
	}

	public void setGoDamagePay(Double goDamagePay) {
		this.goDamagePay = goDamagePay;
	}

	public Double getGoTransitPay() {
		return goTransitPay;
	}

	public void setGoTransitPay(Double goTransitPay) {
		this.goTransitPay = goTransitPay;
	}

	public String getGoSiteEnd() {
		return goSiteEnd;
	}

	public void setGoSiteEnd(String goSiteEnd) {
		this.goSiteEnd = goSiteEnd;
	}

	public String getGoRemark() {
		return goRemark;
	}

	public void setGoRemark(String goRemark) {
		this.goRemark = goRemark;
	}

	public Integer getGoType() {
		return goType;
	}

	public void setGoType(Integer goType) {
		this.goType = goType;
	}

	public Integer getGoSmsStatus() {
		return goSmsStatus;
	}

	public void setGoSmsStatus(Integer goSmsStatus) {
		this.goSmsStatus = goSmsStatus;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

}
