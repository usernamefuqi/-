/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : electronic_material

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 15/08/2022 09:37:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员登录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for all_gains
-- ----------------------------
DROP TABLE IF EXISTS `all_gains`;
CREATE TABLE `all_gains`  (
  `gain_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物资领取id',
  `staff_id` bigint(20) NULL DEFAULT NULL COMMENT '领取人id',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '领取物资id',
  `gain_time` datetime(0) NULL DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`gain_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '所有领取记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of all_gains
-- ----------------------------
INSERT INTO `all_gains` VALUES (1, 1, 1, '2022-08-14 20:35:41');
INSERT INTO `all_gains` VALUES (2, 1, 2, '2022-08-14 20:35:43');
INSERT INTO `all_gains` VALUES (3, 1, 3, '2022-08-14 20:35:44');
INSERT INTO `all_gains` VALUES (4, 1, 4, '2022-08-14 20:35:46');
INSERT INTO `all_gains` VALUES (5, 1, 5, '2022-08-14 20:35:48');

-- ----------------------------
-- Table structure for entry_regist
-- ----------------------------
DROP TABLE IF EXISTS `entry_regist`;
CREATE TABLE `entry_regist`  (
  `staff_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '职工id',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职工姓名',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `entry_time` date NULL DEFAULT NULL COMMENT '入职时间',
  PRIMARY KEY (`staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入职登记信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entry_regist
-- ----------------------------
INSERT INTO `entry_regist` VALUES (1, '张三', b'1', 22, '12345678910', '江西南昌', '2022-08-14');
INSERT INTO `entry_regist` VALUES (2, '李四', b'0', 32, '21312321312', '江西九江', '2022-08-14');
INSERT INTO `entry_regist` VALUES (3, 'ad', b'0', 21, '13212', '123', '2022-08-14');

-- ----------------------------
-- Table structure for gain_goods
-- ----------------------------
DROP TABLE IF EXISTS `gain_goods`;
CREATE TABLE `gain_goods`  (
  `gain_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物资领取id',
  `staff_id` bigint(20) NULL DEFAULT NULL COMMENT '领取人id',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '领取物资id',
  `gain_time` datetime(0) NULL DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`gain_id`) USING BTREE,
  INDEX `staff_id`(`staff_id`) USING BTREE,
  CONSTRAINT `gain_goods_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `entry_regist` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资领取信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gain_goods
-- ----------------------------
INSERT INTO `gain_goods` VALUES (1, 1, 1, '2022-08-14 20:35:41');
INSERT INTO `gain_goods` VALUES (4, 1, 4, '2022-08-14 20:35:46');
INSERT INTO `gain_goods` VALUES (5, 1, 5, '2022-08-14 20:35:48');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物资id',
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物资名称',
  `goods_price` double(10, 1) NULL DEFAULT NULL COMMENT '物资价格',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '电脑', 5000.0);
INSERT INTO `goods` VALUES (2, '笔记本', 10000.0);
INSERT INTO `goods` VALUES (3, 'pad', 12000.0);
INSERT INTO `goods` VALUES (4, '手机', 3000.0);
INSERT INTO `goods` VALUES (5, 'CPU', 1000.0);
INSERT INTO `goods` VALUES (7, '键盘', 80.0);
INSERT INTO `goods` VALUES (8, '鼠标', 30.0);

-- ----------------------------
-- Table structure for leave_office
-- ----------------------------
DROP TABLE IF EXISTS `leave_office`;
CREATE TABLE `leave_office`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '离职id',
  `staff_id` bigint(20) NULL DEFAULT NULL COMMENT '离职人id',
  `leave_time` date NULL DEFAULT NULL COMMENT '离职时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `staff_id`(`staff_id`) USING BTREE,
  CONSTRAINT `leave_office_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `entry_regist` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '离职信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leave_office
-- ----------------------------
INSERT INTO `leave_office` VALUES (1, 3, '2022-08-14');

-- ----------------------------
-- Table structure for pay_goods
-- ----------------------------
DROP TABLE IF EXISTS `pay_goods`;
CREATE TABLE `pay_goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '赔偿记录id',
  `staff_id` bigint(20) NULL DEFAULT NULL COMMENT '赔偿人id',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '赔偿物资id',
  `pay_price` double(10, 1) NULL DEFAULT NULL COMMENT '赔偿金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '赔偿信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_goods
-- ----------------------------
INSERT INTO `pay_goods` VALUES (1, 1, 2, 10000.0);

-- ----------------------------
-- Table structure for return_goods
-- ----------------------------
DROP TABLE IF EXISTS `return_goods`;
CREATE TABLE `return_goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交付id',
  `staff_id` bigint(20) NULL DEFAULT NULL COMMENT '交付人id',
  `gain_id` bigint(20) NULL DEFAULT NULL COMMENT '物资领取id',
  `return_time` datetime(0) NULL DEFAULT NULL COMMENT '交付时间',
  `return_flag` bit(1) NULL DEFAULT b'0' COMMENT '交付标记（0为未交付，1为交付，默认为0）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资交付信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_goods
-- ----------------------------
INSERT INTO `return_goods` VALUES (1, 1, 1, NULL, b'0');
INSERT INTO `return_goods` VALUES (2, 1, 2, NULL, b'0');
INSERT INTO `return_goods` VALUES (3, 1, 3, '2022-08-14 20:36:09', b'1');
INSERT INTO `return_goods` VALUES (4, 1, 4, NULL, b'0');
INSERT INTO `return_goods` VALUES (5, 1, 5, NULL, b'0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '1234');
INSERT INTO `user` VALUES (2, '李四', '123456');

-- ----------------------------
-- Table structure for user_regist
-- ----------------------------
DROP TABLE IF EXISTS `user_regist`;
CREATE TABLE `user_regist`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '账号表id',
  `regist_id` bigint(20) NULL DEFAULT NULL COMMENT '入职人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `regist_id`(`regist_id`) USING BTREE,
  CONSTRAINT `user_regist_ibfk_1` FOREIGN KEY (`regist_id`) REFERENCES `entry_regist` (`staff_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入职用户登录关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_regist
-- ----------------------------
INSERT INTO `user_regist` VALUES (1, 1, 1);
INSERT INTO `user_regist` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
