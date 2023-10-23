/*
 Navicat MySQL Data Transfer

 Source Server         : b
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : b

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 21/10/2023 18:27:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名(用于管理员登录)',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'a', 'a');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goodname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名字',
  `kind_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品种类,作为外键关联kind中的type',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `stock` int(10) NULL DEFAULT NULL COMMENT '库存，库存小于1自动下架',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`kind_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (3, '电脑', '电器', 8000.00, 100);

-- ----------------------------
-- Table structure for goods_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `goods_shopcar`;
CREATE TABLE `goods_shopcar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `amount` int(11) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_shopcar
-- ----------------------------
INSERT INTO `goods_shopcar` VALUES (4, 1, 1, 9);
INSERT INTO `goods_shopcar` VALUES (5, 1, 1, 6);
INSERT INTO `goods_shopcar` VALUES (6, 1, 1, 6);
INSERT INTO `goods_shopcar` VALUES (7, 1, 1, 7);
INSERT INTO `goods_shopcar` VALUES (8, 1, 1, 8);
INSERT INTO `goods_shopcar` VALUES (9, 1, 1, 8);
INSERT INTO `goods_shopcar` VALUES (10, 1, 1, 8);
INSERT INTO `goods_shopcar` VALUES (11, 1, 1, 8);
INSERT INTO `goods_shopcar` VALUES (12, 1, 1, 8);
INSERT INTO `goods_shopcar` VALUES (13, 1, 1, 0);
INSERT INTO `goods_shopcar` VALUES (14, 1, 1, 10);
INSERT INTO `goods_shopcar` VALUES (15, 1, 1, 0);

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品种类',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES (1, '日用品1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(10) NOT NULL COMMENT 'user表id',
  `amount` int(10) NULL DEFAULT NULL COMMENT '购买货物数量',
  `totalprice` double(10, 2) NULL DEFAULT NULL COMMENT '货物总价格',
  `good_price` double(10, 2) NULL DEFAULT NULL,
  `good_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 5, 114.50, 22.90, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` int(3) UNSIGNED ZEROFILL NOT NULL COMMENT '性别 0、男1、女',
  `savings` int(10) UNSIGNED ZEROFILL NOT NULL DEFAULT 0000000000 COMMENT '存款 ，默认0',
  `login_time` date NULL DEFAULT NULL COMMENT '登陆时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `phoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号',
  PRIMARY KEY (`id`, `savings`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '12', '123', '1234', 001, 0000000012, '2023-10-18', '2023-10-20 19:43:03', NULL);
INSERT INTO `user` VALUES (2, 'zhangsan', '123456', 'luq', 000, 0000000000, '2023-10-21', '2023-10-21 17:56:56', '13720974683');

SET FOREIGN_KEY_CHECKS = 1;
