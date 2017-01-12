/*
Navicat MySQL Data Transfer

Source Server         : zooqi@debian
Source Server Version : 50553
Source Host           : debian:3306
Source Database       : baishun

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-01-12 16:36:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attent
-- ----------------------------
DROP TABLE IF EXISTS `attent`;
CREATE TABLE `attent` (
  `attentId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '考勤ID',
  `attentDate` varchar(255) DEFAULT NULL COMMENT '考勤日期',
  `attentNum` double(10,2) unsigned DEFAULT NULL COMMENT '出勤次数',
  `attentReasonNum` double(10,2) unsigned DEFAULT NULL COMMENT '请假次数',
  `attentReason` varchar(255) DEFAULT '' COMMENT '请假理由',
  `attentOverTimeNum` double(10,0) unsigned DEFAULT NULL COMMENT '加班次数',
  `attentOverTimePay` double(10,2) unsigned DEFAULT NULL COMMENT '加班费用',
  `attentBonus` double(10,2) unsigned DEFAULT NULL COMMENT '奖金',
  `empWage` double(10,0) unsigned DEFAULT NULL COMMENT '每月工资',
  `attentRemark` varchar(255) DEFAULT '' COMMENT '备注',
  `empId` int(11) unsigned DEFAULT NULL COMMENT '员工ID',
  PRIMARY KEY (`attentId`),
  KEY `attent_ibfk_1` (`empId`),
  CONSTRAINT `attent_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attent
-- ----------------------------

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工Id',
  `empNum` varchar(255) NOT NULL DEFAULT '' COMMENT '员工号',
  `empName` varchar(255) DEFAULT '' COMMENT '员工姓名',
  `empDepart` varchar(255) DEFAULT '' COMMENT '员工所在部门',
  `empPosition` varchar(255) DEFAULT '' COMMENT '员工职位',
  `empWage` double(10,2) unsigned DEFAULT NULL COMMENT '员工基本工资',
  `empDate` date DEFAULT NULL COMMENT '员工入职日期',
  `empEdu` varchar(255) DEFAULT '' COMMENT '员工学历',
  `empSex` varchar(255) DEFAULT '' COMMENT '员工性别',
  `empBorn` date DEFAULT NULL COMMENT '员工生日',
  `empPhone` varchar(255) DEFAULT '' COMMENT '员工电话',
  `empQQ` varchar(255) DEFAULT '' COMMENT '员工QQ',
  `empAddress` varchar(255) DEFAULT '' COMMENT '员工住址',
  `empHealth` varchar(255) DEFAULT '' COMMENT '员工健康状况',
  `empMarriage` varchar(255) DEFAULT '' COMMENT '员工婚姻情况',
  `empPasswd` varchar(255) DEFAULT '' COMMENT '员工系统密码',
  `empRemark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`empId`),
  UNIQUE KEY `empNum` (`empNum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'BS01001', '老板', '老板', '老板', '1000.00', '2016-08-07', '学士', '女', null, '13686757533', '1123084964', '广西桂林市七星区', '健康', '未婚', '1234', null);
INSERT INTO `emp` VALUES ('2', 'BS01002', '取货员', '取货员', '取货员', '2500.00', '2016-08-08', '大专', '女', null, '16377865899', '1283085164', '桂林市七星区花江', '健康', '未婚', '1234', null);
INSERT INTO `emp` VALUES ('3', 'BS01003', '会计', '会计', '会计', '5000.00', '2016-08-09', '研究生', '男', null, '', '', '', '健康', '未婚', '1234', null);

-- ----------------------------
-- Table structure for emp_fun
-- ----------------------------
DROP TABLE IF EXISTS `emp_fun`;
CREATE TABLE `emp_fun` (
  `empId` int(11) unsigned NOT NULL,
  `funId` int(11) unsigned NOT NULL,
  PRIMARY KEY (`empId`,`funId`),
  KEY `funId` (`funId`),
  CONSTRAINT `emp_fun_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON UPDATE CASCADE,
  CONSTRAINT `emp_fun_ibfk_2` FOREIGN KEY (`funId`) REFERENCES `fun` (`funId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_fun
-- ----------------------------
INSERT INTO `emp_fun` VALUES ('1', '1');
INSERT INTO `emp_fun` VALUES ('1', '2');
INSERT INTO `emp_fun` VALUES ('3', '2');
INSERT INTO `emp_fun` VALUES ('1', '3');
INSERT INTO `emp_fun` VALUES ('2', '3');
INSERT INTO `emp_fun` VALUES ('1', '4');
INSERT INTO `emp_fun` VALUES ('2', '4');
INSERT INTO `emp_fun` VALUES ('1', '5');
INSERT INTO `emp_fun` VALUES ('2', '5');
INSERT INTO `emp_fun` VALUES ('1', '6');
INSERT INTO `emp_fun` VALUES ('3', '6');
INSERT INTO `emp_fun` VALUES ('1', '7');
INSERT INTO `emp_fun` VALUES ('3', '7');
INSERT INTO `emp_fun` VALUES ('1', '8');
INSERT INTO `emp_fun` VALUES ('3', '8');
INSERT INTO `emp_fun` VALUES ('1', '9');
INSERT INTO `emp_fun` VALUES ('1', '10');

-- ----------------------------
-- Table structure for expent
-- ----------------------------
DROP TABLE IF EXISTS `expent`;
CREATE TABLE `expent` (
  `expId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '支出Id，主键',
  `expEmpNum` varchar(255) DEFAULT '' COMMENT '职工号',
  `expEmpName` varchar(255) DEFAULT '' COMMENT '员工姓名',
  `expFunction` varchar(255) DEFAULT '' COMMENT '支出用途',
  `expMoney` double(10,2) unsigned DEFAULT NULL COMMENT '支出金额',
  `expDate` date DEFAULT NULL COMMENT '支出日期',
  `expRemark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`expId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expent
-- ----------------------------

-- ----------------------------
-- Table structure for fun
-- ----------------------------
DROP TABLE IF EXISTS `fun`;
CREATE TABLE `fun` (
  `funId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '功能Id',
  `funURI` varchar(255) DEFAULT '' COMMENT '功能URI',
  `funName` varchar(255) DEFAULT '' COMMENT '功能名字',
  `menuId` int(11) unsigned DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`funId`),
  KEY `fun_ibfk_1` (`menuId`),
  CONSTRAINT `fun_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fun
-- ----------------------------
INSERT INTO `fun` VALUES ('1', 'empInfor.jsp', '员工管理', '1');
INSERT INTO `fun` VALUES ('2', 'attentInfor.jsp', '考勤管理', '1');
INSERT INTO `fun` VALUES ('3', 'deliver.jsp', '发货管理', '2');
INSERT INTO `fun` VALUES ('4', 'arrival.jsp', '到货管理', '2');
INSERT INTO `fun` VALUES ('5', 'traffic.jsp', '车流管理', '2');
INSERT INTO `fun` VALUES ('6', 'expent.jsp', '日常支出', '3');
INSERT INTO `fun` VALUES ('7', 'income.jsp', '业务收支', '3');
INSERT INTO `fun` VALUES ('8', 'money.jsp', '每月结余', '3');
INSERT INTO `fun` VALUES ('9', 'jurisdiction.jsp', '授予权限', '4');
INSERT INTO `fun` VALUES ('10', 'person.jsp', '个人信息', '5');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '物流ID',
  `goBank` varchar(255) DEFAULT '' COMMENT '货号',
  `goName` varchar(255) DEFAULT '' COMMENT '货品名称',
  `goPack` varchar(255) DEFAULT '' COMMENT '包装样式',
  `goNum` int(11) unsigned DEFAULT NULL COMMENT '货品数量',
  `goWeight` double(10,2) unsigned DEFAULT NULL COMMENT '货品重量',
  `goVolume` double(10,2) unsigned DEFAULT NULL COMMENT '货品体积',
  `goSendMan` varchar(255) DEFAULT '' COMMENT '发货人',
  `goSendPhone` varchar(255) DEFAULT '' COMMENT '发货人电话',
  `goSendAddress` varchar(255) DEFAULT '' COMMENT '发货人地址',
  `goForMan` varchar(255) DEFAULT '' COMMENT '收货人',
  `goForPhone` varchar(255) DEFAULT '' COMMENT '收货人电话',
  `goForAddress` varchar(255) DEFAULT '' COMMENT '收货人地址',
  `goGetWay` varchar(255) DEFAULT '' COMMENT '提货方式',
  `goPayWay` varchar(255) DEFAULT '' COMMENT '支付方式',
  `goPay` double(10,2) unsigned DEFAULT NULL COMMENT '支付金额',
  `goInsurancePay` double(10,2) unsigned DEFAULT NULL COMMENT '保价费',
  `goReplacePay` double(10,2) unsigned DEFAULT NULL COMMENT '代收货款',
  `goCommission` double(10,2) unsigned DEFAULT NULL COMMENT '回扣',
  `goDamagePay` double(10,2) unsigned DEFAULT NULL COMMENT '货款扣',
  `goTransitPay` double(10,2) unsigned DEFAULT NULL COMMENT '中转费',
  `goSiteEnd` varchar(255) DEFAULT '' COMMENT '货物终点站',
  `goRemark` varchar(255) DEFAULT '' COMMENT '备注信息',
  `goType` int(11) unsigned NOT NULL COMMENT '发到货类型，发：0；到：1',
  `logId` int(11) unsigned DEFAULT NULL COMMENT '物流ID',
  `goSmsStatus` int(11) unsigned DEFAULT NULL COMMENT '短信发送状态',
  PRIMARY KEY (`goId`),
  KEY `logId` (`logId`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`logId`) REFERENCES `logistics` (`logId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '物流ID',
  `logContractNum` varchar(255) DEFAULT '' COMMENT '合同编号',
  `logSendDate` date DEFAULT NULL COMMENT '车辆发车日期',
  `logSiteStart` varchar(255) DEFAULT '' COMMENT '始发站',
  `logSiteEnd` varchar(255) DEFAULT '' COMMENT '终点站',
  `logCarLicence` varchar(255) DEFAULT '' COMMENT '车牌号',
  `logCarDriver` varchar(255) DEFAULT '' COMMENT '随车司机姓名',
  `logCarPhone` varchar(255) DEFAULT '' COMMENT '司机电话',
  `logCarPay` double unsigned DEFAULT NULL COMMENT '货车费用',
  `logUnloadPay` double(10,2) unsigned DEFAULT NULL COMMENT '卸车费',
  `logPartner` varchar(255) DEFAULT '' COMMENT '客户公司名',
  `logType` int(11) unsigned NOT NULL COMMENT '车流类型，发：0；到：1',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `menuName` varchar(255) DEFAULT '' COMMENT '菜单名字',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '行政管理');
INSERT INTO `menu` VALUES ('2', '业务管理');
INSERT INTO `menu` VALUES ('3', '财务管理');
INSERT INTO `menu` VALUES ('4', '权限管理');
INSERT INTO `menu` VALUES ('5', '个人信息管理');
