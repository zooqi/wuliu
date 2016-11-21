/*
Navicat MySQL Data Transfer

Source Server         : debian
Source Server Version : 50552
Source Host           : debian:3306
Source Database       : baishun

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2016-11-20 23:00:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attent
-- ----------------------------
DROP TABLE IF EXISTS `attent`;
CREATE TABLE `attent` (
  `attentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤Id，主键',
  `attentDate` date DEFAULT NULL COMMENT '考勤日期',
  `attentNum` double(10,2) DEFAULT NULL COMMENT '出勤次数',
  `attentReasonNum` double(10,2) DEFAULT NULL COMMENT '请假次数',
  `attentReason` varchar(255) DEFAULT NULL COMMENT '请假理由',
  `attentOverTimeNum` double(10,0) DEFAULT NULL COMMENT '加班次数',
  `attentOverTimePay` double(10,2) DEFAULT NULL COMMENT '加班费用',
  `attentBonus` double(10,2) DEFAULT NULL COMMENT '奖金',
  `attentRemark` varchar(255) DEFAULT NULL COMMENT '备注',
  `empId` int(11) DEFAULT NULL COMMENT 'Emp外键',
  PRIMARY KEY (`attentId`),
  KEY `attent_ibfk_1` (`empId`),
  CONSTRAINT `attent_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attent
-- ----------------------------
INSERT INTO `attent` VALUES ('6', '2016-08-08', '0.00', '0.00', null, '0', '0.00', '0.00', null, '5');
INSERT INTO `attent` VALUES ('7', '2016-08-07', '0.00', '0.00', null, '0', '0.00', '0.00', null, '5');
INSERT INTO `attent` VALUES ('8', '2016-08-02', '0.00', '0.00', null, '0', '0.00', '0.00', null, '5');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empId` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工Id',
  `empNum` varchar(255) NOT NULL COMMENT '员工号',
  `empName` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `empDepart` varchar(255) DEFAULT NULL COMMENT '员工所在部门',
  `empPosition` varchar(255) DEFAULT NULL COMMENT '员工职位',
  `empWage` double(10,2) DEFAULT NULL COMMENT '员工基本工资',
  `empDate` date DEFAULT NULL COMMENT '员工入职日期',
  `empEdu` varchar(255) DEFAULT NULL COMMENT '员工学历',
  `empSex` varchar(255) DEFAULT NULL COMMENT '员工性别',
  `empBorn` date DEFAULT NULL COMMENT '员工生日',
  `empPhone` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `empQQ` varchar(255) DEFAULT NULL COMMENT '员工QQ',
  `empAddress` varchar(255) DEFAULT NULL COMMENT '员工住址',
  `empHealth` varchar(255) DEFAULT '' COMMENT '员工健康状况',
  `empMarriage` varchar(255) DEFAULT '' COMMENT '员工婚姻情况',
  `empPasswd` varchar(255) DEFAULT NULL COMMENT '员工系统密码',
  `empRemark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`empId`),
  UNIQUE KEY `empNum` (`empNum`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'BS01001', '张三', '秘书部', '老板', '1000.00', '2016-08-07', '学士', '女', null, '13687753833', '1183085964', '广西桂林市七星区', '亚健康', '离异', '1234', null);
INSERT INTO `emp` VALUES ('2', 'BS02001', '李四', '财务部', '普通员工', '800.00', '2016-08-07', '本科', '女', null, '13654453833', '118308594', '广东广州市', '健康', '已婚', '123456', null);
INSERT INTO `emp` VALUES ('5', '005', '刘二', '市场部', '经理', '12345.00', null, '博士', '', null, '', '', '', '', '', '1234', null);
INSERT INTO `emp` VALUES ('12', '012', '大黄', '财务部', '普通员工', '1200.00', '2016-08-07', '研究生', '女', null, '13687735833', '', '广西桂林市七星区', '健康', '   ', '1234', null);
INSERT INTO `emp` VALUES ('18', 'BS01002', '大佬', '秘书室', '老板助理', '2500.00', '2016-08-08', '大专', '女', null, '16377865899', '1183085964', '桂林市七星区花江', '健康', '未婚', '1234', null);
INSERT INTO `emp` VALUES ('26', 'BS03002', '张根生', '销售部', '经理', '5000.00', '2016-08-09', '研究生', '男', null, '', '', '', '健康', '未婚', '1234', null);

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `roleId` int(11) NOT NULL COMMENT '角色Id，主键',
  `empId` int(11) NOT NULL COMMENT '员工Id，主键',
  PRIMARY KEY (`roleId`,`empId`),
  KEY `emp_role_ibfk_2` (`empId`),
  CONSTRAINT `emp_role_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `emp_role_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `expId` int(11) NOT NULL AUTO_INCREMENT COMMENT '支出Id，主键',
  `expFunction` varchar(255) DEFAULT NULL COMMENT '支出用途',
  `expMoney` double(10,2) DEFAULT NULL COMMENT '支出金额',
  `expDate` date DEFAULT NULL COMMENT '支出日期',
  `expRemark` varchar(255) DEFAULT NULL COMMENT '备注',
  `empId` int(11) DEFAULT NULL COMMENT '员工Id,外键',
  PRIMARY KEY (`expId`),
  KEY `expent_ibfk_1` (`empId`),
  CONSTRAINT `expent_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expent
-- ----------------------------

-- ----------------------------
-- Table structure for fun
-- ----------------------------
DROP TABLE IF EXISTS `fun`;
CREATE TABLE `fun` (
  `funId` int(11) NOT NULL AUTO_INCREMENT COMMENT '功能Id',
  `funURI` varchar(255) DEFAULT NULL COMMENT '功能URI',
  `funName` varchar(255) DEFAULT NULL COMMENT '功能名字',
  `menuId` int(11) DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`funId`),
  KEY `fun_ibfk_1` (`menuId`),
  CONSTRAINT `fun_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fun
-- ----------------------------
INSERT INTO `fun` VALUES ('1', 'empInfor.jsp', '员工管理', '1');
INSERT INTO `fun` VALUES ('2', 'attentInfor.jsp', '考勤管理', '1');
INSERT INTO `fun` VALUES ('3', 'deliverGoods.jsp', '发货管理', '2');
INSERT INTO `fun` VALUES ('4', 'arriveGoods.jsp', '到货管理', '2');
INSERT INTO `fun` VALUES ('5', 'jurisdiction.jsp', '授予权限', '4');
INSERT INTO `fun` VALUES ('6', 'expend.jsp', '支出管理', '3');
INSERT INTO `fun` VALUES ('7', 'profit.jsp', '利润查询', '3');
INSERT INTO `fun` VALUES ('8', 'person.jsp', '个人查询', '5');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goId` int(11) NOT NULL AUTO_INCREMENT COMMENT '物流ID',
  `goBank` varchar(255) DEFAULT '' COMMENT '货号',
  `goName` varchar(255) DEFAULT '' COMMENT '货品名称',
  `goPack` varchar(255) DEFAULT '' COMMENT '包装样式',
  `goNum` int(11) DEFAULT NULL COMMENT '货品数量',
  `goWeight` double(10,2) DEFAULT NULL COMMENT '货品重量',
  `goVolume` double(10,2) DEFAULT NULL COMMENT '货品体积',
  `goSendMan` varchar(255) DEFAULT NULL COMMENT '发货人',
  `goSendPhone` varchar(255) DEFAULT NULL COMMENT '发货人电话',
  `goSendAddress` varchar(255) DEFAULT NULL,
  `goForMan` varchar(255) DEFAULT NULL COMMENT '收货人',
  `goForPhone` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `goForAddress` varchar(255) DEFAULT NULL,
  `goGetWay` varchar(255) DEFAULT NULL COMMENT '提货方式',
  `goPayWay` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `goPay` double(10,2) DEFAULT NULL COMMENT '支付金额',
  `goInsurancePay` double(10,2) DEFAULT NULL COMMENT '保价费',
  `goReplacePay` double(10,2) DEFAULT NULL COMMENT '代收货款',
  `goCommission` double(10,2) DEFAULT NULL COMMENT '回扣',
  `goDamagePay` double(10,2) DEFAULT NULL COMMENT '货款扣',
  `goTransitPay` double(10,2) DEFAULT NULL COMMENT '中转费',
  `goSiteEnd` varchar(255) DEFAULT NULL COMMENT '货物终点站',
  `goRemark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `houseId` int(11) DEFAULT NULL,
  `logId` int(11) DEFAULT NULL,
  PRIMARY KEY (`goId`),
  KEY `goNum` (`goNum`),
  KEY `goods_ibfk_3` (`houseId`),
  KEY `logId` (`logId`),
  CONSTRAINT `goods_ibfk_3` FOREIGN KEY (`houseId`) REFERENCES `house` (`houseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_4` FOREIGN KEY (`logId`) REFERENCES `logistics` (`logId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'HYC2105', '桌面等', null, '58', null, '2.50', null, '13793895796', null, null, '18577358707', null, '自提', '到付', '440.00', null, null, null, null, null, '桂林', null, null, '1');
INSERT INTO `goods` VALUES ('2', 'HYC2060', '厨具', null, '104', null, '8.50', '王兴明', '15762156741', null, '刘雄杰', '13307733339', null, '送货', '到付', '1190.00', null, null, null, null, null, '桂林', null, null, '2');
INSERT INTO `goods` VALUES ('3', 'HYC3', '电脑', null, '56', null, null, '六六', '15762156741', null, '张三', '13307733339', null, '送货', '到付', '1150.00', null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `houseId` int(15) NOT NULL AUTO_INCREMENT COMMENT '仓库Id',
  `houseNum` varchar(255) DEFAULT NULL COMMENT '仓库数量',
  `houseArrDate` date DEFAULT NULL COMMENT '登记入库时间',
  `houseRemark` varchar(255) DEFAULT NULL COMMENT '仓库备注',
  `goId` int(11) DEFAULT NULL COMMENT '货品Id',
  PRIMARY KEY (`houseId`),
  KEY `house_ibfk_2` (`goId`),
  CONSTRAINT `house_ibfk_2` FOREIGN KEY (`goId`) REFERENCES `goods` (`goId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logId` int(11) NOT NULL AUTO_INCREMENT COMMENT '物流Id',
  `logContractNum` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `logSendDate` date DEFAULT NULL COMMENT '车辆发车日期',
  `logSiteStart` varchar(255) DEFAULT NULL COMMENT '初始站',
  `logSiteEnd` varchar(255) DEFAULT NULL COMMENT '到站',
  `logCarLicence` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `logCarDriver` varchar(255) DEFAULT NULL COMMENT '随车司机姓名',
  `logCarPhone` varchar(255) DEFAULT NULL COMMENT '司机电话',
  `logCarPay` double DEFAULT NULL COMMENT '货车费用',
  `logPartner` varchar(255) DEFAULT NULL COMMENT '客户公司名',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('1', 'DYC182', '2016-07-11', '桂林', '桂林', '鲁', '侯怀学', '15864839998', null, '淄博永昶物流有限公司');
INSERT INTO `logistics` VALUES ('2', 'GZ201607-0019', '2016-07-05', '桂林', '桂林', '桂', '罗欢', '13597135772', null, '广州明联嘉源公司');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `menuFather` int(10) DEFAULT NULL COMMENT '菜单父Id',
  `menuName` varchar(255) DEFAULT NULL COMMENT '菜单名字',
  PRIMARY KEY (`menuId`),
  KEY `menu_ibfk_1` (`menuFather`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`menuFather`) REFERENCES `menu` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `roleName` varchar(255) DEFAULT NULL COMMENT '角色名字',
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
  `roleId` int(11) NOT NULL COMMENT '角色Id',
  `menuId` int(11) NOT NULL COMMENT '菜单Id',
  PRIMARY KEY (`roleId`,`menuId`),
  KEY `role_menu_ibfk_2` (`menuId`),
  CONSTRAINT `role_menu_ibfk_2` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_menu_ibfk_3` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1');
INSERT INTO `role_menu` VALUES ('1', '2');
INSERT INTO `role_menu` VALUES ('1', '3');
INSERT INTO `role_menu` VALUES ('1', '4');
INSERT INTO `role_menu` VALUES ('1', '5');
