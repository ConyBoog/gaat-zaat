/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : platform-gateway

 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 10/09/2017 18:50:58 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_items`
-- ----------------------------
DROP TABLE IF EXISTS `user_items`;
CREATE TABLE `user_items` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(200) NOT NULL,
  `item_id` varchar(64) NOT NULL,
  `purchased_date` datetime NOT NULL,
  `expiry_date` datetime NOT NULL,
  `item_status` varchar(20) NOT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
