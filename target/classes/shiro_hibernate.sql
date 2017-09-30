/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : shiro_hibernate

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2017-09-28 09:30:49
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
  CONSTRAINT `FKpphauenhtk86sad2s6vf72xje` FOREIGN KEY (`PID`) REFERENCES `shiro_hibernate_privilege` (`PID`),
  CONSTRAINT `FKevt3i7tp4nmidndq5csnm4kbu` FOREIGN KEY (`RID`) REFERENCES `shiro_hibernate_role` (`RID`)
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_info
-- ----------------------------
INSERT INTO `shiro_hibernate_info` VALUES ('1', '今天天气很好啊!', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_role
-- ----------------------------
INSERT INTO `shiro_hibernate_role` VALUES ('1', 'admin', '管理员', '');
INSERT INTO `shiro_hibernate_role` VALUES ('2', 'student', '学生', '');
INSERT INTO `shiro_hibernate_role` VALUES ('3', 'teacher', '老师', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiro_hibernate_user
-- ----------------------------
INSERT INTO `shiro_hibernate_user` VALUES ('1', '中石化', 'root', '123456', 'd3af43eb-cde9-4', '');
INSERT INTO `shiro_hibernate_user` VALUES ('2', '花旗银行', 'alice', '123456', '0df-aaed-ed9d371c905f', '');
INSERT INTO `shiro_hibernate_user` VALUES ('3', '汇丰银行', 'blake', '123456', 'b43-a6da-6c24f4052779', '');
