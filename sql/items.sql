/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : platform-gateway

 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 10/09/2017 18:50:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` bigint(20) NOT NULL,
  `item_name` varchar(200) NOT NULL,
  `item_type` varchar(30) NOT NULL,
  `item_price` double(10,2) NOT NULL,
  `creator` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
