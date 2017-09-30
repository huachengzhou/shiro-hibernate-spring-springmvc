/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : shiro_hibernate

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2017-09-30 13:47:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for privilege_role
-- ----------------------------
DROP TABLE IF EXISTS `privilege_role`;
CREATE TABLE `privilege_role` (
  `PID` int(11) NOT NULL,
  `RID` int(11) NOT NULL,
  PRIMARY KEY (`PID`,`RID`),
  KEY `FKevt3i7tp4nmidndq5csnm4kbu` (`RID`),
  CONSTRAINT `FKevt3i7tp4nmidndq5csnm4kbu` FOREIGN KEY (`RID`) REFERENCES `shiro_hibernate_role` (`RID`),
  CONSTRAINT `FKpphauenhtk86sad2s6vf72xje` FOREIGN KEY (`PID`) REFERENCES `shiro_hibernate_privilege` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of privilege_role
-- ----------------------------
INSERT INTO `privilege_role` VALUES ('1', '1');
INSERT INTO `privilege_role` VALUES ('2', '1');
INSERT INTO `privilege_role` VALUES ('3', '1');
INSERT INTO `privilege_role` VALUES ('4', '1');
INSERT INTO `privilege_role` VALUES ('2', '2');
INSERT INTO `privilege_role` VALUES ('1', '3');
INSERT INTO `privilege_role` VALUES ('2', '3');
INSERT INTO `privilege_role` VALUES ('4', '3');
INSERT INTO `privilege_role` VALUES ('2', '4');
INSERT INTO `privilege_role` VALUES ('3', '4');
INSERT INTO `privilege_role` VALUES ('1', '5');
INSERT INTO `privilege_role` VALUES ('3', '5');
INSERT INTO `privilege_role` VALUES ('3', '6');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `RID` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  PRIMARY KEY (`RID`,`UID`),
  KEY `FKpj47l5mw4t1xfwkovd4p2e9cx` (`UID`),
  CONSTRAINT `FK9srs9ly968j18td2tf8lmjuyo` FOREIGN KEY (`RID`) REFERENCES `shiro_hibernate_role` (`RID`),
  CONSTRAINT `FKpj47l5mw4t1xfwkovd4p2e9cx` FOREIGN KEY (`UID`) REFERENCES `shiro_hibernate_user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '1');
INSERT INTO `role_user` VALUES ('2', '2');
INSERT INTO `role_user` VALUES ('3', '3');
INSERT INTO `role_user` VALUES ('2', '5');
INSERT INTO `role_user` VALUES ('3', '5');
INSERT INTO `role_user` VALUES ('3', '6');
INSERT INTO `role_user` VALUES ('2', '7');

-- ----------------------------
-- Table structure for shiro_hibernate_info
-- ----------------------------
DROP TABLE IF EXISTS `shiro_hibernate_info`;
CREATE TABLE `shiro_hibernate_info` (
  `INFO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `USER` int(11) DEFAULT NULL,
  PRIMARY KEY (`INFO_ID`),
  KEY `FK1qx9lkl9wq3dl2xcmvyeuuntv` (`USER`),
  CONSTRAINT `FK1qx9lkl9wq3dl2xcmvyeuuntv` FOREIGN KEY (`USER`) REFERENCES `shiro_hibernate_user` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_info
-- ----------------------------
INSERT INTO `shiro_hibernate_info` VALUES ('1', '今天天气很好啊!', '2');
INSERT INTO `shiro_hibernate_info` VALUES ('3', '星星点点', '1');
INSERT INTO `shiro_hibernate_info` VALUES ('4', '点点滴滴', '1');
INSERT INTO `shiro_hibernate_info` VALUES ('5', '蓝天白云', '1');
INSERT INTO `shiro_hibernate_info` VALUES ('6', '水月洞天', '1');
INSERT INTO `shiro_hibernate_info` VALUES ('7', '郁闷中!', '5');
INSERT INTO `shiro_hibernate_info` VALUES ('8', '心情不好啊!', '3');
INSERT INTO `shiro_hibernate_info` VALUES ('9', '我也心情不好', '5');

-- ----------------------------
-- Table structure for shiro_hibernate_privilege
-- ----------------------------
DROP TABLE IF EXISTS `shiro_hibernate_privilege`;
CREATE TABLE `shiro_hibernate_privilege` (
  `PID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_privilege
-- ----------------------------
INSERT INTO `shiro_hibernate_privilege` VALUES ('1', 'user:save');
INSERT INTO `shiro_hibernate_privilege` VALUES ('2', 'user:select');
INSERT INTO `shiro_hibernate_privilege` VALUES ('3', 'user:remove');
INSERT INTO `shiro_hibernate_privilege` VALUES ('4', 'user:edit');

-- ----------------------------
-- Table structure for shiro_hibernate_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_hibernate_role`;
CREATE TABLE `shiro_hibernate_role` (
  `RID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `AVAILABLE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`RID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_role
-- ----------------------------
INSERT INTO `shiro_hibernate_role` VALUES ('1', 'admin', '管理员', '');
INSERT INTO `shiro_hibernate_role` VALUES ('2', 'student', '学生', '');
INSERT INTO `shiro_hibernate_role` VALUES ('3', 'teacher', '老师', '');
INSERT INTO `shiro_hibernate_role` VALUES ('4', 'jiaowuzhuren', '教务主任', '');
INSERT INTO `shiro_hibernate_role` VALUES ('5', 'xiaozhang', '校长', '');
INSERT INTO `shiro_hibernate_role` VALUES ('6', 'shizhang', '市长', '\0');

-- ----------------------------
-- Table structure for shiro_hibernate_user
-- ----------------------------
DROP TABLE IF EXISTS `shiro_hibernate_user`;
CREATE TABLE `shiro_hibernate_user` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `ORGANIZATIONID` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SALT` varchar(255) DEFAULT NULL,
  `LOCKED` bit(1) DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_user
-- ----------------------------
INSERT INTO `shiro_hibernate_user` VALUES ('1', '中石化', 'root', 'MTIzNDU2ZDNhZjQzZWItY2RlOS00MWM5MDVn', 'd3af43eb-cde9-41c905g', '');
INSERT INTO `shiro_hibernate_user` VALUES ('2', '花旗银行', 'alice', 'MTIzNDU2MGRmLWFhZWQtZWQ5ZDM3MWM5MDVm', '0df-aaed-ed9d371c905f', '');
INSERT INTO `shiro_hibernate_user` VALUES ('3', '汇丰银行', 'blake', 'MTIzNDU2YjQzLWE2ZGEtNmMyNGY0MDUyNzc5', 'b43-a6da-6c24f4052779', '');
INSERT INTO `shiro_hibernate_user` VALUES ('5', '海洋公园', 'lee', 'MTIzNDU2ODE0LWI3NTAtNDBhZGIwZThiYmIw', '814-b750-40adb0e8bbb0', '');
INSERT INTO `shiro_hibernate_user` VALUES ('6', 'xxxx企业', 'bob', 'ODg1OS0xYTJlLTk2YzYtOGNkYjY0NDY4YzQ4', 'a2e-96c6-8cdb64468c48', '\0');
INSERT INTO `shiro_hibernate_user` VALUES ('7', '波音公司', 'asfd', 'NDM1NjdmZjItOWRlOS1kNmRmNmZkMGQ1OTM=', 'ff2-9de9-d6df6fd0d593', '\0');
