/*
Navicat MySQL Data Transfer

Source Server         : 10.7.48.25
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lcl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-18 16:56:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `login_name` varchar(32) NOT NULL COMMENT '登录账号',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'e5dbf06ca9c311e89fc6902b3497d169', 'admin', 'admin');
INSERT INTO `tb_user` VALUES ('2', 'c6f80bd698524691b26805a5dda216e6', 'lcl', '123456');
INSERT INTO `tb_user` VALUES ('3', '97e0e4867ff14bd795b2f2ec5bbaea9f', 'lcl1', '123456');
INSERT INTO `tb_user` VALUES ('4', 'f64c01f0667745bca42407b29f8e22b4', 'lcl2', '123456');
INSERT INTO `tb_user` VALUES ('5', 'd1362b2cc3254f4785790a6e8abf419f', 'lcl3', '123456');
INSERT INTO `tb_user` VALUES ('6', '1e021e378f1e478e89d7b073d0aa1948', '张三', '123456');
INSERT INTO `tb_user` VALUES ('7', '006ef064bc744dc3a7073ce4eb364636', '张三', '123456');
INSERT INTO `tb_user` VALUES ('8', '8d0ec56837d54c859c25f5d95e37fdee', '张三', '123456');
INSERT INTO `tb_user` VALUES ('9', '9b75bdbe4e914752855ec6a8e89df02e', '李四', '123456');
