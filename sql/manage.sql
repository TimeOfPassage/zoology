/*
Navicat MySQL Data Transfer

Source Server         : manage
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-12-25 15:06:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_system_department
-- ----------------------------
DROP TABLE IF EXISTS `t_system_department`;
CREATE TABLE `t_system_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(50) NOT NULL COMMENT '部门名称',
  `depDesc` varchar(255) DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_department
-- ----------------------------
INSERT INTO `t_system_department` VALUES ('1', '项目管理部', '分管项目任务');
INSERT INTO `t_system_department` VALUES ('2', '技术研发部', '进行技术研发');

-- ----------------------------
-- Table structure for t_system_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_system_privilege`;
CREATE TABLE `t_system_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT '0' COMMENT '父菜单id,一级菜单默认为0',
  `icon` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '状态: 0：未启用 1：已启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_privilege
-- ----------------------------
INSERT INTO `t_system_privilege` VALUES ('1', '系统管理', 'id=form&method=form_list', '0', 'fa fa-bar-chart-o fa-fw', '1');
INSERT INTO `t_system_privilege` VALUES ('2', '用户管理', 'id=form&method=form_list', '1', 'fa fa-bar-chart-o fa-fw', '1');
INSERT INTO `t_system_privilege` VALUES ('3', '角色管理', 'id=form&method=form_list', '1', 'fa fa-bar-chart-o fa-fw', '1');
INSERT INTO `t_system_privilege` VALUES ('4', '权限管理', 'www.tmall.comid=form&method=form_list', '1', 'fa fa-bar-chart-o fa-fw', '1');
INSERT INTO `t_system_privilege` VALUES ('5', '部门管理', 'id=form&method=form_list', '1', 'fa fa-bar-chart-o fa-fw', '1');

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', '一级管理组');
INSERT INTO `t_system_role` VALUES ('2', '二级管理组');
INSERT INTO `t_system_role` VALUES ('3', '三级管理组');
INSERT INTO `t_system_role` VALUES ('4', '四级管理组');
INSERT INTO `t_system_role` VALUES ('5', '五级管理组');

-- ----------------------------
-- Table structure for t_system_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role_privilege`;
CREATE TABLE `t_system_role_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `privilegeId` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  KEY `fk_p_privilegeId` (`privilegeId`),
  CONSTRAINT `fk_p_privilegeId` FOREIGN KEY (`privilegeId`) REFERENCES `t_system_privilege` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_p_roleId` FOREIGN KEY (`roleId`) REFERENCES `t_system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role_privilege
-- ----------------------------
INSERT INTO `t_system_role_privilege` VALUES ('1', '1', '1');
INSERT INTO `t_system_role_privilege` VALUES ('2', '1', '2');
INSERT INTO `t_system_role_privilege` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `pasword` varchar(255) NOT NULL DEFAULT '123456' COMMENT '密码，应存储加密后的密码，做test故明文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1', '张三', '123456');
INSERT INTO `t_system_user` VALUES ('2', '李四', '123456');
INSERT INTO `t_system_user` VALUES ('3', '王五', '123456');
INSERT INTO `t_system_user` VALUES ('4', '刘大壮', '123456');

-- ----------------------------
-- Table structure for t_system_user_department
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_department`;
CREATE TABLE `t_system_user_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `deptId` int(11) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  KEY `fk_u_d_userId` (`userId`),
  KEY `fk_u_d_deptId` (`deptId`),
  CONSTRAINT `fk_u_d_deptId` FOREIGN KEY (`deptId`) REFERENCES `t_system_department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_u_d_userId` FOREIGN KEY (`userId`) REFERENCES `t_system_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user_department
-- ----------------------------
INSERT INTO `t_system_user_department` VALUES ('1', '1', '1');
INSERT INTO `t_system_user_department` VALUES ('2', '2', '2');
INSERT INTO `t_system_user_department` VALUES ('3', '3', '2');
INSERT INTO `t_system_user_department` VALUES ('4', '4', '2');

-- ----------------------------
-- Table structure for t_system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_role`;
CREATE TABLE `t_system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `fk_userId` (`userId`),
  KEY `fk_roleId` (`roleId`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`roleId`) REFERENCES `t_system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `t_system_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user_role
-- ----------------------------
INSERT INTO `t_system_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_system_user_role` VALUES ('2', '2', '2');
