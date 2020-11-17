/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/11/2020 00:22:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `order_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单时间',
  `order_status` smallint(0) NULL DEFAULT NULL COMMENT '订单支付状态',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单号',
  `product_id` bigint(0) NULL DEFAULT NULL COMMENT '商品id',
  `product_num` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  `product_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `payment_id` bigint(0) NULL DEFAULT NULL COMMENT '支付流水号',
  `payment_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '支付金额',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单号',
  `payment_type` int(0) NULL DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `product_classify` int(0) NULL DEFAULT NULL COMMENT '商品分类',
  `production_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产地',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
