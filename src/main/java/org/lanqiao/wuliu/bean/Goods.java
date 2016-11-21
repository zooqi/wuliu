package org.lanqiao.wuliu.bean;

/**
 * 物流表
 * 
 * @author 杨明静
 *
 */
public class Goods {
	private Integer goId;
	private String goBank;
	private String goName;
	private Integer goNum;
	private String goPack;
	private double goweight;
	private double goVolume;
	private String goSendMan;
	private String goSendPhone;
	private String goSendAddress;
	private String goForMan;
	private String goForPhone;
	private String goForAddress;
	private String goGetWay;
	private String goPayWay;
	private double goPay;
	private double goInsurancePay;
	private double goReplacePay;
	private double goCommission;
	private double goDamagePay;
	private double goTransitPay;
	private String goSiteEnd;
	private String goRemark;
	private Logistics logistics;
	private House house;

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
	
	public Integer getGoNum() {
		return goNum;
	}

	public void setGoNum(Integer goNum) {
		this.goNum = goNum;
	}

	public double getGoweight() {
		return goweight;
	}

	public void setGoweight(double goweight) {
		this.goweight = goweight;
	}

	public double getGoVolume() {
		return goVolume;
	}

	public void setGoVolume(double goVolume) {
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

	public double getGoPay() {
		return goPay;
	}

	public void setGoPay(double goPay) {
		this.goPay = goPay;
	}

	public double getGoReplacePay() {
		return goReplacePay;
	}

	public void setGoReplacePay(double goReplacePay) {
		this.goReplacePay = goReplacePay;
	}

	public double getGoCommission() {
		return goCommission;
	}

	public void setGoCommission(double goCommission) {
		this.goCommission = goCommission;
	}

	public double getGoDamagePay() {
		return goDamagePay;
	}

	public void setGoDamagePay(double goDamagePay) {
		this.goDamagePay = goDamagePay;
	}

	public double getGoTransitPay() {
		return goTransitPay;
	}

	public void setGoTransitPay(double goTransitPay) {
		this.goTransitPay = goTransitPay;
	}

	public String getGoRemark() {
		return goRemark;
	}

	public void setGoRemark(String goRemark) {
		this.goRemark = goRemark;
	}

	public String getGoPack() {
		return goPack;
	}

	public void setGoPack(String goPack) {
		this.goPack = goPack;
	}

	public String getGoSendAddress() {
		return goSendAddress;
	}

	public void setGoSendAddress(String goSendAddress) {
		this.goSendAddress = goSendAddress;
	}

	public String getGoForAddress() {
		return goForAddress;
	}

	public void setGoForAddress(String goForAddress) {
		this.goForAddress = goForAddress;
	}

	public double getGoInsurancePay() {
		return goInsurancePay;
	}

	public void setGoInsurancePay(double goInsurancePay) {
		this.goInsurancePay = goInsurancePay;
	}

	public String getGoSiteEnd() {
		return goSiteEnd;
	}

	public void setGoSiteEnd(String goSiteEnd) {
		this.goSiteEnd = goSiteEnd;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
}