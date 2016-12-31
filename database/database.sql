/*
Navicat MySQL Data Transfer

Source Server         : zooqi@debian
Source Server Version : 50552
Source Host           : debian:3306
Source Database       : baishun

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2016-12-31 12:21:21
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attent
-- ----------------------------
INSERT INTO `attent` VALUES ('1', '2016-03', '0.00', '0.00', '发烧', '5', '500.00', '100.00', '100', '', '1');
INSERT INTO `attent` VALUES ('2', '2015-05', '1.00', '0.00', '发烧', '100', '10.00', '100.00', '0', '生病了', '2');
INSERT INTO `attent` VALUES ('3', '2016-01', '11.00', '3.00', '', '50', '2.00', '50.00', null, '', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'BS01001', '张三', '秘书部', '老板', '1000.00', '2016-08-07', '学士', '女', null, '13687753833', '1183085964', '广西桂林市七星区', '健康', '离异', '1234', null);
INSERT INTO `emp` VALUES ('2', 'BS02001', '李四', '财务部', '普通员工', '800.00', '2016-08-07', '本科', '女', null, '13654453833', '118308594', '广东广州市', '健康', '已婚', '123456', null);
INSERT INTO `emp` VALUES ('3', '005', '刘二', '市场部', '经理', '12345.00', null, '博士', '', null, '', '', '', '', '', '1234', null);
INSERT INTO `emp` VALUES ('4', '012', '大黄', '财务部', '普通员工', '1200.00', '2016-08-07', '研究生', '女', null, '13687735833', '', '广西桂林市七星区', '健康', '   ', '1234', null);
INSERT INTO `emp` VALUES ('5', 'BS01002', '大佬', '秘书室', '老板助理', '2500.00', '2016-08-08', '大专', '女', null, '16377865899', '1183085964', '桂林市七星区花江', '健康', '未婚', '1234', null);
INSERT INTO `emp` VALUES ('6', 'BS03002', '张根生', '销售部', '经理', '5000.00', '2016-08-09', '研究生', '男', null, '', '', '', '健康', '未婚', '1234', null);

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
INSERT INTO `emp_fun` VALUES ('2', '1');
INSERT INTO `emp_fun` VALUES ('3', '1');
INSERT INTO `emp_fun` VALUES ('1', '2');
INSERT INTO `emp_fun` VALUES ('2', '2');
INSERT INTO `emp_fun` VALUES ('1', '3');
INSERT INTO `emp_fun` VALUES ('1', '4');

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `roleId` int(11) unsigned NOT NULL COMMENT '角色Id，主键',
  `empId` int(11) unsigned NOT NULL COMMENT '员工Id，主键',
  PRIMARY KEY (`roleId`,`empId`),
  KEY `emp_role_ibfk_2` (`empId`),
  CONSTRAINT `emp_role_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON UPDATE CASCADE,
  CONSTRAINT `emp_role_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES ('1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expent
-- ----------------------------
INSERT INTO `expent` VALUES ('1', 'BS01001', '张三', '外卖', '150.00', '2016-12-03', '');
INSERT INTO `expent` VALUES ('2', 'BS01001', '张三', '临时工', '250.00', '2016-11-01', '');
INSERT INTO `expent` VALUES ('3', 'BS01001', '张三', '外卖', '60.00', '2016-10-01', '');
INSERT INTO `expent` VALUES ('4', 'BS01001', '张三', '餐具', '120.00', '2016-03-01', '');
INSERT INTO `expent` VALUES ('5', 'BS01001', '张三', '搬运工', '500.00', '2016-06-01', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'HYC2105', '桌面等', '', '58', '0.00', '2.50', '', '13793895796', '', '', '18577358707', '', '自提', '到付', '440.00', '0.00', '0.00', '0.00', '0.00', '0.00', '桂林', '', '1', '1', null);
INSERT INTO `goods` VALUES ('2', 'HYC2060', '厨具', '麻袋', '104', '1.10', '2.20', '王兴明', '15762156741', '桂电', '刘雄杰', '13307733339', '中国', '送货', '到付', '3.30', '4.40', '5.50', '6.60', '7.70', '8.80', '桂林', '', '1', '2', null);
INSERT INTO `goods` VALUES ('3', 'HYC3', '电脑', '', '56', null, '5.60', '六六', '15762156741', '', '张三', '13307733339', null, '送货', '到付', '1150.00', null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `goods` VALUES ('4', 'HYC236', '南瓜', '', '100', null, '2.66', '赵六', '', '', '', '', '', '', '已付', '3500.00', null, null, '500.00', '400.00', null, '', '', '0', '1', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('1', 'DYC182', '2016-07-11', '山东', '桂林', '鲁', '侯怀学', '15864839998', null, null, '淄博永昶物流有限公司', '1');
INSERT INTO `logistics` VALUES ('2', 'GZ201607-0019', '2016-07-05', '桂林', '桂林', '桂', '罗欢', '13597135772', null, null, '广州明联嘉源公司', '0');
INSERT INTO `logistics` VALUES ('3', 'BMW', '2016-12-24', '桂林', '赣州', '赣B 4827', '朱启晖', '13138384833', '6.5', null, '养猪场', '0');
INSERT INTO `logistics` VALUES ('4', 'UWP', '2016-12-25', '桂林', '南康', '赣B 4827', '朱爷', '13138384833', '6.5', null, '肥佬', '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `menuFather` int(11) unsigned DEFAULT NULL COMMENT '菜单父Id',
  `menuName` varchar(255) DEFAULT '' COMMENT '菜单名字',
  PRIMARY KEY (`menuId`),
  KEY `menu_ibfk_1` (`menuFather`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`menuFather`) REFERENCES `menu` (`menuId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, '行政管理');
INSERT INTO `menu` VALUES ('2', null, '业务管理');
INSERT INTO `menu` VALUES ('3', null, '财务管理');
INSERT INTO `menu` VALUES ('4', null, '权限管理');
INSERT INTO `menu` VALUES ('5', null, '个人信息管理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `roleName` varchar(255) DEFAULT '' COMMENT '角色名字',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `roleId` int(11) unsigned NOT NULL COMMENT '角色Id',
  `menuId` int(11) unsigned NOT NULL COMMENT '菜单Id',
  PRIMARY KEY (`roleId`,`menuId`),
  KEY `role_menu_ibfk_2` (`menuId`),
  CONSTRAINT `role_menu_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON UPDATE CASCADE,
  CONSTRAINT `role_menu_ibfk_2` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1');
INSERT INTO `role_menu` VALUES ('1', '2');
INSERT INTO `role_menu` VALUES ('1', '3');
INSERT INTO `role_menu` VALUES ('1', '4');
INSERT INTO `role_menu` VALUES ('1', '5');
