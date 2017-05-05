/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50157
Source Host           : localhost:3306
Source Database       : springboot_mapper_myself

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2017-05-04 18:30:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `state` varchar(32) DEFAULT NULL COMMENT '说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京', '首都', '2017-05-04 17:13:29', null);
INSERT INTO `city` VALUES ('2', '上海', '魔都', '2017-05-04 17:13:50', null);
INSERT INTO `city` VALUES ('3', '合肥', '雾都', '2017-05-04 17:14:07', null);
INSERT INTO `city` VALUES ('4', '固始', '老家', '2017-05-04 17:14:19', null);
INSERT INTO `city` VALUES ('9', '固始', '老家', '2017-05-04 18:29:36', null);
