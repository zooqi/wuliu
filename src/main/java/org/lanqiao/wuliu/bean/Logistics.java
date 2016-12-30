package org.lanqiao.wuliu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 物流单
 * 
 * @author 杨明静
 *
 */
/**
 * @author zooqi
 *
 */
public class Logistics implements Serializable {

	private Integer logId;
	private String logContractNum;
	private Date logSendDate;
	private String logSiteStart;
	private String logSiteEnd;
	private String logCarLicence;
	private String logCarDriver;
	private String logCarPhone;
	private Double logCarPay;
	private Double logUnloadPay;
	private String logPartner;
	private Integer logType;
	private static final long serialVersionUID = 988100447712821205L;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogContractNum() {
		return logContractNum;
	}

	public void setLogContractNum(String logContractNum) {
		this.logContractNum = logContractNum;
	}

	public Date getLogSendDate() {
		return logSendDate;
	}

	public void setLogSendDate(Date logSendDate) {
		this.logSendDate = logSendDate;
	}

	public String getLogSiteStart() {
		return logSiteStart;
	}

	public void setLogSiteStart(String logSiteStart) {
		this.logSiteStart = logSiteStart;
	}

	public String getLogSiteEnd() {
		return logSiteEnd;
	}

	public void setLogSiteEnd(String logSiteEnd) {
		this.logSiteEnd = logSiteEnd;
	}

	public String getLogCarLicence() {
		return logCarLicence;
	}

	public void setLogCarLicence(String logCarLicence) {
		this.logCarLicence = logCarLicence;
	}

	public String getLogCarDriver() {
		return logCarDriver;
	}

	public void setLogCarDriver(String logCarDriver) {
		this.logCarDriver = logCarDriver;
	}

	public String getLogCarPhone() {
		return logCarPhone;
	}

	public void setLogCarPhone(String logCarPhone) {
		this.logCarPhone = logCarPhone;
	}

	public Double getLogCarPay() {
		return logCarPay;
	}

	public void setLogCarPay(Double logCarPay) {
		this.logCarPay = logCarPay;
	}

	public Double getLogUnloadPay() {
		return logUnloadPay;
	}

	public void setLogUnloadPay(Double logUnloadPay) {
		this.logUnloadPay = logUnloadPay;
	}

	public String getLogPartner() {
		return logPartner;
	}

	public void setLogPartner(String logPartner) {
		this.logPartner = logPartner;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

}
