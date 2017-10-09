/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : platform-gateway

 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 10/09/2017 18:51:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL DEFAULT 'uuid()',
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `login` varchar(255) NOT NULL DEFAULT '',
  `phone_number` varchar(50) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `identity_card_number` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `roles` varchar(100) DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('3e4f1e82-1a74-11e7-b05d-e889f636292b', '杨行', '$2a$10$XedBcs.zakBKdXhNyaxE4uyJyMTb5qyvO636buznJ2hovWD.k7772', 'conyboog', '18616757571', 'conyboog@163.com', 'MALE', '520102199002190014', '1990-02-19 00:00:00', '[\'USER\', \'ADMIN\']', '2017-09-29 15:42:59', '2017-10-08 18:21:32', b'0'), ('3e4f22ce-1a74-11e7-b05d-e889f636292b', '崔文婷', '123456', 'funkynana', '13764625967', 'seven@wiik.cn', 'FEMALE', '540102198807021524', '1988-07-02 00:00:00', '[\'USER\']', '2017-09-29 15:42:59', '2017-10-08 18:21:40', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
