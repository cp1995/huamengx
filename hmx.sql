/*
 Navicat Premium Data Transfer

 Source Server         : hmx
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 114.55.104.155:3306
 Source Schema         : hmx

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 12/06/2020 14:54:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '华蒙星', '2020-05-27 13:44:32', 1);
INSERT INTO `area` VALUES (10, '测试园区', '2020-06-11 11:19:40', 1);
INSERT INTO `area` VALUES (11, '测试园区2', '2020-06-11 17:00:10', 1);
INSERT INTO `area` VALUES (12, '343', '2020-06-11 17:23:22', -1);
INSERT INTO `area` VALUES (13, '华蒙星第一幼儿园', '2020-06-11 17:43:06', 1);

-- ----------------------------
-- Table structure for avg
-- ----------------------------
DROP TABLE IF EXISTS `avg`;
CREATE TABLE `avg`  (
  `id` bigint(20) NOT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `age` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hight_avg` double(6, 1) NULL DEFAULT NULL COMMENT '身高平均值',
  `limb_avg` double(6, 1) NULL DEFAULT NULL COMMENT '上肢平均值',
  `legs_avg` double(6, 1) NULL DEFAULT NULL COMMENT '下肢平均值',
  `coordinate_avg` double(6, 1) NULL DEFAULT NULL COMMENT '协调性平均值',
  `balance_avg` double(6, 1) NULL DEFAULT NULL COMMENT '平衡性平均值',
  `flexibility_avg` double(6, 1) NULL DEFAULT NULL COMMENT '柔韧性平均值',
  `sensitive_avg` double(6, 1) NULL DEFAULT NULL COMMENT '灵敏性平均值',
  `racket_avg` int(6) NULL DEFAULT NULL COMMENT '拍球平均值',
  `pass_avg` int(6) NULL DEFAULT NULL COMMENT '传球平均值',
  `shoot_avg` int(6) NULL DEFAULT NULL COMMENT '投篮平均值',
  `bmi_avg` double(6, 2) NULL DEFAULT NULL COMMENT 'bmi平均值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of avg
-- ----------------------------
INSERT INTO `avg` VALUES (1, 1, '3', 97.4, 3.0, 50.0, 11.1, 13.7, 10.1, 9.6, 17, 3, 3, 15.62);
INSERT INTO `avg` VALUES (2, 1, '3.5', 100.1, 3.5, 61.0, 9.7, 12.2, 10.0, 8.7, 44, 4, 5, 15.44);
INSERT INTO `avg` VALUES (3, 1, '4', 103.7, 4.0, 72.0, 8.1, 9.4, 9.9, 8.1, 59, 3, 3, 15.46);
INSERT INTO `avg` VALUES (4, 1, '4.5', 106.5, 5.0, 80.0, 7.3, 7.9, 9.4, 7.6, 79, 4, 5, 15.40);
INSERT INTO `avg` VALUES (5, 1, '5', 109.9, 6.0, 87.0, 6.6, 6.5, 9.2, 7.3, 84, 4, 3, 15.52);
INSERT INTO `avg` VALUES (6, 1, '5.5', 112.4, 6.5, 96.0, 6.2, 5.6, 9.2, 7.0, 104, 5, 4, 15.42);
INSERT INTO `avg` VALUES (7, 1, '6', 115.5, 8.0, 102.0, 5.6, 4.5, 8.7, 6.5, 119, 4, 4, 15.55);
INSERT INTO `avg` VALUES (8, 2, '3', 96.3, 2.5, 47.0, 11.6, 14.0, 11.4, 9.9, 17, 3, 3, 15.36);
INSERT INTO `avg` VALUES (9, 2, '3.5', 99.3, 3.0, 57.0, 9.8, 12.3, 11.4, 9.2, 44, 4, 5, 15.53);
INSERT INTO `avg` VALUES (10, 2, '4', 102.7, 3.5, 66.0, 8.4, 10.2, 11.4, 8.5, 59, 3, 3, 15.43);
INSERT INTO `avg` VALUES (11, 2, '4.5', 105.5, 3.5, 74.0, 7.6, 8.5, 11.4, 7.8, 79, 4, 5, 15.23);
INSERT INTO `avg` VALUES (12, 2, '5', 108.5, 5.0, 81.0, 6.8, 7.0, 11.4, 7.6, 84, 4, 3, 15.33);
INSERT INTO `avg` VALUES (13, 2, '5.5', 111.3, 5.5, 88.0, 6.3, 6.2, 11.3, 7.3, 104, 5, 4, 15.45);
INSERT INTO `avg` VALUES (14, 2, '6', 114.3, 5.5, 93.0, 5.7, 5.2, 11.2, 6.8, 119, 4, 4, 15.62);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `sport_id` bigint(64) NULL DEFAULT NULL COMMENT '场次id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL COMMENT '1男2女',
  `birthday` datetime(0) NULL DEFAULT NULL,
  `age` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `parent_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家长姓名',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `school` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `height` double(10, 1) NULL DEFAULT NULL COMMENT '身高',
  `height_score` int(1) NULL DEFAULT NULL COMMENT '身高得分',
  `weight` double(10, 1) NULL DEFAULT NULL COMMENT '体重',
  `ibm` double(10, 2) NULL DEFAULT NULL COMMENT 'IBM',
  `ibm_score` int(1) NULL DEFAULT NULL COMMENT 'IBM得分',
  `f_height` double(10, 1) NULL DEFAULT NULL COMMENT '父亲身高',
  `m_height` double(10, 1) NULL DEFAULT NULL COMMENT '母亲身高',
  `result_height` double(10, 1) NULL DEFAULT NULL COMMENT '预测身高',
  `legs` int(10) NULL DEFAULT NULL COMMENT '下肢',
  `legs_score` int(1) NULL DEFAULT NULL COMMENT '下肢成绩',
  `limb_score` int(1) NULL DEFAULT NULL COMMENT '上肢得分',
  `coordinate` double(10, 1) NULL DEFAULT NULL COMMENT '协调性',
  `coordinate_score` int(1) NULL DEFAULT NULL COMMENT '协调性得分',
  `balance` double(10, 1) NULL DEFAULT NULL COMMENT '平衡性',
  `balance_score` int(1) NULL DEFAULT NULL COMMENT '平衡性得分',
  `flexibility` double(10, 1) NULL DEFAULT NULL COMMENT '柔韧性',
  `flexibility_score` int(1) NULL DEFAULT NULL COMMENT '柔韧性得分',
  `sensitives` double(10, 1) NULL DEFAULT NULL COMMENT '灵敏性',
  `sensitive_score` int(1) NULL DEFAULT NULL COMMENT '灵敏性得分',
  `racket` int(10) NULL DEFAULT NULL COMMENT '拍球',
  `racket_score` int(1) NULL DEFAULT NULL COMMENT '拍球得分',
  `pass` int(10) NULL DEFAULT NULL COMMENT '传球',
  `pass_score` int(1) NULL DEFAULT NULL COMMENT '传球得分',
  `shoot` int(10) NULL DEFAULT NULL COMMENT '投篮',
  `shoot_score` int(1) NULL DEFAULT NULL COMMENT '投篮得分',
  `sz_limb` double(10, 0) NULL DEFAULT NULL COMMENT '上肢',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (11, 6, '熊熊', 1, '2015-07-01 00:00:00', '4.5', '熊爸', '13666666666', '幼儿园', NULL, '2020-06-11 15:28:26', 117.3, 5, 22.6, 16.43, 3, 183.6, 165.1, 180.4, 113, 5, 5, 5.2, 5, 6.1, 4, 11.3, 4, 6.5, 5, 92, 5, 7, 5, 7, 5, 8, '测试园区录入员');
INSERT INTO `item` VALUES (12, 6, '小赵', 2, '2016-02-01 00:00:00', '4', '赵赵', '19633333333', '幼儿园', NULL, '2020-06-11 16:31:02', 113.2, 5, 21.2, 16.54, 1, 179.2, 164.3, 168.7, 105, 5, 5, 5.2, 5, 5.9, 4, 12.3, 3, 6.3, 5, 90, 5, 6, 5, 6, 5, 7, '测试园区录入员');
INSERT INTO `item` VALUES (14, 8, '张三', 1, '2017-03-01 00:00:00', '3', '崽崽', '18733333333', '小学', NULL, '2020-06-11 17:02:54', 110.3, 5, 19.2, 15.78, 5, 183.3, 164.5, 180.1, 7, 0, 5, 7.0, 4, 7.0, 4, 7.0, 2, 6.1, 5, 90, 5, 6, 5, 6, 5, 7, '测试园区2园长');
INSERT INTO `item` VALUES (15, 10, '李叉叉', 1, '2017-06-01 00:00:00', '3', '李某某', '13923232323', '华蒙星第一幼儿园园园园', NULL, '2020-06-11 17:55:02', 130.0, 5, 30.0, 17.75, 1, 170.0, 160.0, 173.3, 90, 5, 3, 10.0, 3, 30.0, 2, 50.0, 5, 50.0, 0, 80, 5, 80, 5, 30, 5, 3, '华蒙星第一园长');
INSERT INTO `item` VALUES (16, 6, '启明', 1, '2017-06-01 00:00:00', '3', '启明', '13333333333', '测试园区', NULL, '2020-06-11 21:59:23', 111.0, 5, 111.0, 90.09, 1, 111.0, 111.0, 135.6, 111, 5, 5, 1.0, 5, 1.0, 5, 1.0, 0, 1.0, 5, 1, 0, 1, 1, 1, 1, 111, '测试园区录入员');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间/提交时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `role` int(1) NULL DEFAULT NULL COMMENT '1管理员2录入员3园区管理员',
  `area_id` bigint(20) NULL DEFAULT NULL COMMENT '所属园区',
  `state` int(1) NULL DEFAULT NULL COMMENT '-1删除 1正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNI_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'huamengx', 'b31c6bb381021f86fc4d8141ba6b8bdd9ea46775', '18927530', '2019-09-30 11:26:33', '2020-06-11 16:43:26', 1, 1, 1);
INSERT INTO `member` VALUES (6, '测试园区园长', '10470c3b4b1fed12c3baac014be15fac67c6e815', '18000000000', '2020-06-11 11:20:11', '2020-06-11 11:20:11', 3, 10, 1);
INSERT INTO `member` VALUES (7, 'cs', '4ddbeb6864e7ebb8630fff9fb8b7d1e95955e7e7', '13333333333', '2020-06-11 11:21:51', '2020-06-12 11:41:16', 2, 10, 1);
INSERT INTO `member` VALUES (8, '测试园区录入员', '10470c3b4b1fed12c3baac014be15fac67c6e815', '13200000000', '2020-06-11 11:22:45', '2020-06-11 11:22:45', 2, 10, 1);
INSERT INTO `member` VALUES (9, 'cs2', '4ddbeb6864e7ebb8630fff9fb8b7d1e95955e7e7', '13333333333', '2020-06-11 11:23:27', '2020-06-11 11:23:27', 2, 10, 1);
INSERT INTO `member` VALUES (10, '测试园区2园长', '10470c3b4b1fed12c3baac014be15fac67c6e815', '14699999999', '2020-06-11 17:00:54', '2020-06-11 17:00:54', 3, 11, 1);
INSERT INTO `member` VALUES (11, '测试园区2录入员', '10470c3b4b1fed12c3baac014be15fac67c6e815', '14699999999', '2020-06-11 17:01:18', '2020-06-11 17:01:18', 2, 11, 1);
INSERT INTO `member` VALUES (12, '华蒙星第一园长', 'adcd7048512e64b48da55b027577886ee5a36350', '12313131313', '2020-06-11 17:44:04', '2020-06-12 09:59:20', 3, 13, 1);
INSERT INTO `member` VALUES (13, '华蒙星老师', 'adcd7048512e64b48da55b027577886ee5a36350', '12312121212', '2020-06-11 17:44:52', '2020-06-11 17:44:52', 2, 13, 1);

-- ----------------------------
-- Table structure for member_login_record
-- ----------------------------
DROP TABLE IF EXISTS `member_login_record`;
CREATE TABLE `member_login_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) NOT NULL,
  `login_time` datetime(0) NOT NULL COMMENT '登陆时间',
  `user_type` int(2) NOT NULL COMMENT ' 1会员用户2后台用户',
  `login_type` int(2) NOT NULL COMMENT '登陆来源1 web,2 admin,3 android,4 ios,5 mini',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1863 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户登录记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member_login_record
-- ----------------------------
INSERT INTO `member_login_record` VALUES (1, 1, '2019-11-26 19:36:36', 1, 0);
INSERT INTO `member_login_record` VALUES (2, 2, '2019-11-27 08:55:36', 2, 0);
INSERT INTO `member_login_record` VALUES (3, 2, '2019-11-27 09:51:08', 2, 0);
INSERT INTO `member_login_record` VALUES (4, 1, '2019-11-27 10:06:50', 1, 1);
INSERT INTO `member_login_record` VALUES (5, 1, '2019-11-27 10:14:03', 1, 0);
INSERT INTO `member_login_record` VALUES (6, 1, '2019-11-27 10:18:36', 1, 0);
INSERT INTO `member_login_record` VALUES (7, 1, '2019-11-27 10:28:32', 1, 2);
INSERT INTO `member_login_record` VALUES (8, 1, '2019-11-27 10:31:19', 1, 1);
INSERT INTO `member_login_record` VALUES (9, 1, '2019-11-27 10:44:31', 1, 1);
INSERT INTO `member_login_record` VALUES (10, 2, '2019-11-27 10:45:42', 2, 0);
INSERT INTO `member_login_record` VALUES (11, 1, '2019-11-27 10:58:31', 1, 1);
INSERT INTO `member_login_record` VALUES (12, 2, '2019-11-27 10:59:59', 2, 0);
INSERT INTO `member_login_record` VALUES (13, 1, '2019-11-27 11:07:34', 1, 0);
INSERT INTO `member_login_record` VALUES (14, 2, '2019-11-27 11:11:00', 2, 0);
INSERT INTO `member_login_record` VALUES (15, 1, '2019-11-27 11:24:46', 1, 0);
INSERT INTO `member_login_record` VALUES (16, 1, '2019-11-27 14:01:19', 1, 1);
INSERT INTO `member_login_record` VALUES (17, 1, '2019-11-27 14:07:42', 1, 1);
INSERT INTO `member_login_record` VALUES (18, 1, '2019-11-27 14:10:48', 1, 1);
INSERT INTO `member_login_record` VALUES (19, 1, '2019-11-27 14:12:52', 1, 1);
INSERT INTO `member_login_record` VALUES (20, 1, '2019-11-27 14:20:02', 1, 1);
INSERT INTO `member_login_record` VALUES (21, 1, '2019-11-27 14:55:30', 1, 1);
INSERT INTO `member_login_record` VALUES (22, 2, '2019-11-27 15:05:40', 2, 0);
INSERT INTO `member_login_record` VALUES (23, 2, '2019-11-27 15:14:07', 2, 0);
INSERT INTO `member_login_record` VALUES (24, 2, '2019-11-27 15:20:10', 2, 0);
INSERT INTO `member_login_record` VALUES (25, 2, '2019-11-27 15:35:25', 2, 0);
INSERT INTO `member_login_record` VALUES (26, 2, '2019-11-27 15:42:14', 2, 0);
INSERT INTO `member_login_record` VALUES (27, 2, '2019-11-27 15:50:28', 2, 0);
INSERT INTO `member_login_record` VALUES (28, 1, '2019-11-27 16:04:43', 1, 1);
INSERT INTO `member_login_record` VALUES (29, 1, '2019-11-27 16:15:42', 1, 1);
INSERT INTO `member_login_record` VALUES (30, 1, '2019-11-27 16:20:22', 1, 2);
INSERT INTO `member_login_record` VALUES (31, 13, '2019-11-27 16:33:37', 2, 0);
INSERT INTO `member_login_record` VALUES (32, 2, '2019-11-27 17:02:07', 2, 0);
INSERT INTO `member_login_record` VALUES (33, 2, '2019-11-27 17:05:57', 2, 0);
INSERT INTO `member_login_record` VALUES (34, 1, '2019-11-27 17:50:25', 1, 1);
INSERT INTO `member_login_record` VALUES (35, 1, '2019-11-27 17:59:43', 1, 1);
INSERT INTO `member_login_record` VALUES (36, 1, '2019-11-27 18:06:52', 1, 1);
INSERT INTO `member_login_record` VALUES (37, 1, '2019-11-27 18:11:38', 1, 1);
INSERT INTO `member_login_record` VALUES (38, 1, '2019-11-27 18:12:30', 1, 1);
INSERT INTO `member_login_record` VALUES (39, 1, '2019-11-27 18:21:47', 1, 1);
INSERT INTO `member_login_record` VALUES (40, 1, '2019-11-27 19:07:40', 1, 1);
INSERT INTO `member_login_record` VALUES (41, 2, '2019-11-27 19:43:20', 2, 0);
INSERT INTO `member_login_record` VALUES (42, 2, '2019-11-27 19:58:58', 2, 0);
INSERT INTO `member_login_record` VALUES (43, 2, '2019-11-28 09:01:20', 2, 0);
INSERT INTO `member_login_record` VALUES (44, 2, '2019-11-28 09:08:12', 2, 0);
INSERT INTO `member_login_record` VALUES (45, 1, '2019-11-28 09:10:12', 1, 2);
INSERT INTO `member_login_record` VALUES (46, 2, '2019-11-28 09:17:28', 2, 0);
INSERT INTO `member_login_record` VALUES (47, 1, '2019-11-28 09:23:51', 1, 1);
INSERT INTO `member_login_record` VALUES (48, 2, '2019-11-28 09:31:57', 2, 0);
INSERT INTO `member_login_record` VALUES (49, 2, '2019-11-28 10:19:36', 2, 0);
INSERT INTO `member_login_record` VALUES (50, 2, '2019-11-28 10:23:51', 2, 0);
INSERT INTO `member_login_record` VALUES (51, 2, '2019-11-28 10:25:45', 2, 0);
INSERT INTO `member_login_record` VALUES (52, 1, '2019-11-28 10:32:47', 1, 0);
INSERT INTO `member_login_record` VALUES (53, 1, '2019-11-28 10:58:29', 1, 0);
INSERT INTO `member_login_record` VALUES (54, 1, '2019-11-28 11:05:24', 1, 0);
INSERT INTO `member_login_record` VALUES (55, 1, '2019-11-28 11:06:01', 1, 0);
INSERT INTO `member_login_record` VALUES (56, 2, '2019-11-28 11:08:45', 2, 0);
INSERT INTO `member_login_record` VALUES (57, 1, '2019-11-28 11:09:35', 1, 0);
INSERT INTO `member_login_record` VALUES (58, 2, '2019-11-28 11:12:00', 2, 0);
INSERT INTO `member_login_record` VALUES (59, 2, '2019-11-28 11:14:04', 2, 0);
INSERT INTO `member_login_record` VALUES (60, 2, '2019-11-28 11:16:24', 2, 0);
INSERT INTO `member_login_record` VALUES (61, 2, '2019-11-28 11:16:50', 2, 0);
INSERT INTO `member_login_record` VALUES (62, 2, '2019-11-28 11:29:25', 2, 0);
INSERT INTO `member_login_record` VALUES (63, 1, '2019-11-28 11:29:53', 1, 2);
INSERT INTO `member_login_record` VALUES (64, 1, '2019-11-28 14:15:08', 1, 1);
INSERT INTO `member_login_record` VALUES (65, 1, '2019-11-28 14:16:11', 1, 0);
INSERT INTO `member_login_record` VALUES (66, 2, '2019-11-28 14:16:21', 2, 0);
INSERT INTO `member_login_record` VALUES (67, 1, '2019-11-28 14:18:42', 1, 0);
INSERT INTO `member_login_record` VALUES (68, 59, '2019-11-28 14:45:05', 1, 0);
INSERT INTO `member_login_record` VALUES (69, 2, '2019-11-28 14:48:18', 2, 0);
INSERT INTO `member_login_record` VALUES (70, 1, '2019-11-28 14:56:04', 1, 1);
INSERT INTO `member_login_record` VALUES (71, 52, '2019-11-28 15:09:37', 1, 0);
INSERT INTO `member_login_record` VALUES (72, 2, '2019-11-28 15:15:05', 2, 0);
INSERT INTO `member_login_record` VALUES (73, 52, '2019-11-28 15:15:10', 1, 2);
INSERT INTO `member_login_record` VALUES (74, 2, '2019-11-28 15:17:55', 2, 0);
INSERT INTO `member_login_record` VALUES (75, 2, '2019-11-28 15:28:33', 2, 0);
INSERT INTO `member_login_record` VALUES (76, 1, '2019-11-28 15:41:32', 1, 1);
INSERT INTO `member_login_record` VALUES (77, 1, '2019-11-28 15:44:14', 1, 1);
INSERT INTO `member_login_record` VALUES (78, 1, '2019-11-28 15:49:56', 1, 0);
INSERT INTO `member_login_record` VALUES (79, 1, '2019-11-28 15:56:12', 1, 1);
INSERT INTO `member_login_record` VALUES (80, 1, '2019-11-28 15:58:31', 1, 0);
INSERT INTO `member_login_record` VALUES (81, 2, '2019-11-28 16:01:04', 2, 0);
INSERT INTO `member_login_record` VALUES (82, 2, '2019-11-28 16:07:49', 2, 0);
INSERT INTO `member_login_record` VALUES (83, 59, '2019-11-28 16:25:20', 1, 0);
INSERT INTO `member_login_record` VALUES (84, 2, '2019-11-28 16:25:46', 2, 0);
INSERT INTO `member_login_record` VALUES (85, 2, '2019-11-28 16:31:02', 2, 0);
INSERT INTO `member_login_record` VALUES (86, 20, '2019-11-28 16:32:53', 2, 0);
INSERT INTO `member_login_record` VALUES (87, 1, '2019-11-28 16:45:49', 1, 0);
INSERT INTO `member_login_record` VALUES (88, 1, '2019-11-28 16:46:14', 1, 0);
INSERT INTO `member_login_record` VALUES (89, 1, '2019-11-28 16:48:33', 1, 0);
INSERT INTO `member_login_record` VALUES (90, 2, '2019-11-28 16:50:15', 2, 0);
INSERT INTO `member_login_record` VALUES (91, 2, '2019-11-28 16:58:55', 2, 0);
INSERT INTO `member_login_record` VALUES (92, 1, '2019-11-28 17:11:11', 1, 1);
INSERT INTO `member_login_record` VALUES (93, 2, '2019-11-28 17:29:07', 2, 0);
INSERT INTO `member_login_record` VALUES (94, 1, '2019-11-28 17:30:52', 1, 1);
INSERT INTO `member_login_record` VALUES (95, 60, '2019-11-28 18:56:59', 1, 2);
INSERT INTO `member_login_record` VALUES (96, 52, '2019-11-28 19:08:02', 1, 2);
INSERT INTO `member_login_record` VALUES (97, 1, '2019-11-28 19:21:16', 1, 0);
INSERT INTO `member_login_record` VALUES (98, 1, '2019-11-28 19:37:19', 1, 0);
INSERT INTO `member_login_record` VALUES (99, 1, '2019-11-28 19:42:27', 1, 0);
INSERT INTO `member_login_record` VALUES (100, 1, '2019-11-28 19:55:53', 1, 0);
INSERT INTO `member_login_record` VALUES (101, 2, '2019-11-28 20:02:42', 2, 0);
INSERT INTO `member_login_record` VALUES (102, 1, '2019-11-28 20:05:46', 1, 0);
INSERT INTO `member_login_record` VALUES (103, 1, '2019-11-28 20:07:41', 1, 0);
INSERT INTO `member_login_record` VALUES (104, 1, '2019-11-28 20:09:04', 1, 0);
INSERT INTO `member_login_record` VALUES (105, 2, '2019-11-28 20:09:51', 2, 0);
INSERT INTO `member_login_record` VALUES (106, 1, '2019-11-28 20:10:12', 1, 0);
INSERT INTO `member_login_record` VALUES (107, 1, '2019-11-28 20:13:55', 1, 0);
INSERT INTO `member_login_record` VALUES (108, 1, '2019-11-29 08:36:59', 1, 0);
INSERT INTO `member_login_record` VALUES (109, 1, '2019-11-29 08:39:35', 1, 0);
INSERT INTO `member_login_record` VALUES (110, 1, '2019-11-29 08:42:48', 1, 1);
INSERT INTO `member_login_record` VALUES (111, 2, '2019-11-29 08:44:04', 2, 0);
INSERT INTO `member_login_record` VALUES (112, 2, '2019-11-29 08:47:57', 2, 0);
INSERT INTO `member_login_record` VALUES (113, 2, '2019-11-29 08:48:49', 2, 0);
INSERT INTO `member_login_record` VALUES (114, 60, '2019-11-29 09:01:16', 1, 2);
INSERT INTO `member_login_record` VALUES (115, 2, '2019-11-29 09:12:38', 2, 0);
INSERT INTO `member_login_record` VALUES (116, 52, '2019-11-29 09:17:41', 1, 2);
INSERT INTO `member_login_record` VALUES (117, 59, '2019-11-29 09:21:20', 1, 0);
INSERT INTO `member_login_record` VALUES (118, 1, '2019-11-29 09:24:08', 1, 1);
INSERT INTO `member_login_record` VALUES (119, 2, '2019-11-29 09:28:21', 2, 0);
INSERT INTO `member_login_record` VALUES (120, 1, '2019-11-29 09:29:56', 1, 1);
INSERT INTO `member_login_record` VALUES (121, 1, '2019-11-29 09:34:15', 1, 1);
INSERT INTO `member_login_record` VALUES (122, 59, '2019-11-29 09:40:17', 1, 0);
INSERT INTO `member_login_record` VALUES (123, 1, '2019-11-29 09:48:16', 1, 0);
INSERT INTO `member_login_record` VALUES (124, 1, '2019-11-29 10:00:49', 1, 0);
INSERT INTO `member_login_record` VALUES (125, 2, '2019-11-29 10:26:21', 2, 0);
INSERT INTO `member_login_record` VALUES (126, 2, '2019-11-29 10:29:27', 2, 0);
INSERT INTO `member_login_record` VALUES (127, 2, '2019-11-29 10:35:34', 2, 0);
INSERT INTO `member_login_record` VALUES (128, 2, '2019-11-29 10:42:49', 2, 0);
INSERT INTO `member_login_record` VALUES (129, 2, '2019-11-29 10:46:48', 2, 0);
INSERT INTO `member_login_record` VALUES (130, 2, '2019-11-29 10:48:21', 2, 0);
INSERT INTO `member_login_record` VALUES (131, 2, '2019-11-29 10:49:19', 2, 0);
INSERT INTO `member_login_record` VALUES (132, 62, '2019-11-29 10:50:43', 1, 0);
INSERT INTO `member_login_record` VALUES (133, 1, '2019-11-29 10:55:57', 1, 0);
INSERT INTO `member_login_record` VALUES (134, 2, '2019-11-29 10:57:20', 2, 0);
INSERT INTO `member_login_record` VALUES (135, 2, '2019-11-29 10:59:29', 2, 0);
INSERT INTO `member_login_record` VALUES (136, 40, '2019-11-29 11:01:09', 1, 0);
INSERT INTO `member_login_record` VALUES (137, 20, '2019-11-29 11:03:33', 2, 0);
INSERT INTO `member_login_record` VALUES (138, 63, '2019-11-29 11:38:04', 1, 0);
INSERT INTO `member_login_record` VALUES (139, 2, '2019-11-29 11:43:03', 2, 0);
INSERT INTO `member_login_record` VALUES (140, 2, '2019-11-29 11:47:26', 2, 0);
INSERT INTO `member_login_record` VALUES (141, 2, '2019-11-29 11:50:49', 2, 0);
INSERT INTO `member_login_record` VALUES (142, 64, '2019-11-29 11:53:08', 1, 0);
INSERT INTO `member_login_record` VALUES (143, 1, '2019-11-29 11:53:29', 1, 0);
INSERT INTO `member_login_record` VALUES (144, 64, '2019-11-29 12:07:29', 1, 0);
INSERT INTO `member_login_record` VALUES (145, 2, '2019-11-29 14:01:05', 2, 0);
INSERT INTO `member_login_record` VALUES (146, 1, '2019-11-29 14:02:56', 1, 0);
INSERT INTO `member_login_record` VALUES (147, 2, '2019-11-29 14:14:01', 2, 0);
INSERT INTO `member_login_record` VALUES (148, 64, '2019-11-29 14:14:18', 1, 0);
INSERT INTO `member_login_record` VALUES (149, 1, '2019-11-29 14:14:35', 1, 0);
INSERT INTO `member_login_record` VALUES (150, 52, '2019-11-29 14:16:43', 1, 0);
INSERT INTO `member_login_record` VALUES (151, 1, '2019-11-29 14:21:04', 1, 0);
INSERT INTO `member_login_record` VALUES (152, 2, '2019-11-29 14:22:11', 2, 0);
INSERT INTO `member_login_record` VALUES (153, 2, '2019-11-29 14:30:07', 2, 0);
INSERT INTO `member_login_record` VALUES (154, 64, '2019-11-29 14:33:50', 1, 0);
INSERT INTO `member_login_record` VALUES (155, 64, '2019-11-29 14:35:37', 1, 0);
INSERT INTO `member_login_record` VALUES (156, 59, '2019-11-29 14:49:06', 1, 0);
INSERT INTO `member_login_record` VALUES (157, 1, '2019-11-29 15:00:11', 1, 1);
INSERT INTO `member_login_record` VALUES (158, 62, '2019-11-29 15:01:05', 1, 0);
INSERT INTO `member_login_record` VALUES (159, 62, '2019-11-29 15:05:55', 1, 0);
INSERT INTO `member_login_record` VALUES (160, 62, '2019-11-29 15:16:20', 1, 0);
INSERT INTO `member_login_record` VALUES (161, 1, '2019-11-29 15:16:29', 1, 0);
INSERT INTO `member_login_record` VALUES (162, 62, '2019-11-29 15:19:35', 1, 0);
INSERT INTO `member_login_record` VALUES (163, 2, '2019-11-29 15:22:23', 2, 0);
INSERT INTO `member_login_record` VALUES (164, 1, '2019-11-29 15:24:53', 1, 0);
INSERT INTO `member_login_record` VALUES (165, 2, '2019-11-29 15:25:34', 2, 0);
INSERT INTO `member_login_record` VALUES (166, 2, '2019-11-29 15:26:27', 2, 0);
INSERT INTO `member_login_record` VALUES (167, 1, '2019-11-29 15:27:50', 1, 0);
INSERT INTO `member_login_record` VALUES (168, 2, '2019-11-29 15:49:28', 2, 0);
INSERT INTO `member_login_record` VALUES (169, 1, '2019-11-29 15:51:42', 1, 1);
INSERT INTO `member_login_record` VALUES (170, 2, '2019-11-29 15:53:51', 2, 0);
INSERT INTO `member_login_record` VALUES (171, 20, '2019-11-29 16:15:20', 2, 0);
INSERT INTO `member_login_record` VALUES (172, 1, '2019-11-29 16:33:13', 1, 0);
INSERT INTO `member_login_record` VALUES (173, 1, '2019-11-29 16:46:36', 1, 0);
INSERT INTO `member_login_record` VALUES (174, 2, '2019-11-29 16:55:46', 2, 0);
INSERT INTO `member_login_record` VALUES (175, 59, '2019-11-29 17:05:01', 1, 0);
INSERT INTO `member_login_record` VALUES (176, 2, '2019-11-29 17:05:27', 2, 0);
INSERT INTO `member_login_record` VALUES (177, 2, '2019-11-29 17:06:05', 2, 0);
INSERT INTO `member_login_record` VALUES (178, 1, '2019-11-29 17:07:42', 1, 0);
INSERT INTO `member_login_record` VALUES (179, 60, '2019-11-29 17:14:50', 1, 2);
INSERT INTO `member_login_record` VALUES (180, 1, '2019-11-29 17:30:22', 1, 1);
INSERT INTO `member_login_record` VALUES (181, 1, '2019-11-29 17:39:17', 1, 1);
INSERT INTO `member_login_record` VALUES (182, 2, '2019-11-29 17:46:17', 2, 0);
INSERT INTO `member_login_record` VALUES (183, 2, '2019-11-29 17:52:12', 2, 0);
INSERT INTO `member_login_record` VALUES (184, 2, '2019-11-29 17:57:05', 2, 0);
INSERT INTO `member_login_record` VALUES (185, 20, '2019-11-29 18:07:18', 2, 0);
INSERT INTO `member_login_record` VALUES (186, 2, '2019-11-29 18:12:21', 2, 0);
INSERT INTO `member_login_record` VALUES (187, 2, '2019-11-30 10:20:00', 2, 0);
INSERT INTO `member_login_record` VALUES (188, 2, '2019-11-30 10:23:48', 2, 0);
INSERT INTO `member_login_record` VALUES (189, 65, '2019-11-30 10:32:17', 1, 0);
INSERT INTO `member_login_record` VALUES (190, 65, '2019-11-30 10:33:08', 1, 0);
INSERT INTO `member_login_record` VALUES (191, 2, '2019-11-30 10:42:29', 2, 0);
INSERT INTO `member_login_record` VALUES (192, 2, '2019-11-30 10:44:46', 2, 0);
INSERT INTO `member_login_record` VALUES (193, 2, '2019-11-30 10:45:36', 2, 0);
INSERT INTO `member_login_record` VALUES (194, 62, '2019-11-30 10:47:27', 1, 0);
INSERT INTO `member_login_record` VALUES (195, 40, '2019-11-30 10:59:38', 1, 0);
INSERT INTO `member_login_record` VALUES (196, 1, '2019-11-30 11:01:31', 1, 0);
INSERT INTO `member_login_record` VALUES (197, 2, '2019-11-30 11:18:39', 2, 0);
INSERT INTO `member_login_record` VALUES (198, 64, '2019-11-30 11:39:46', 1, 0);
INSERT INTO `member_login_record` VALUES (199, 1, '2019-11-30 11:44:18', 1, 0);
INSERT INTO `member_login_record` VALUES (200, 66, '2019-11-30 12:10:17', 1, 0);
INSERT INTO `member_login_record` VALUES (201, 66, '2019-11-30 12:34:28', 1, 0);
INSERT INTO `member_login_record` VALUES (202, 1, '2019-11-30 12:40:29', 1, 0);
INSERT INTO `member_login_record` VALUES (203, 2, '2019-11-30 14:16:10', 2, 0);
INSERT INTO `member_login_record` VALUES (204, 2, '2019-11-30 14:19:19', 2, 0);
INSERT INTO `member_login_record` VALUES (205, 2, '2019-11-30 14:38:20', 2, 0);
INSERT INTO `member_login_record` VALUES (206, 2, '2019-11-30 14:58:35', 2, 0);
INSERT INTO `member_login_record` VALUES (207, 2, '2019-11-30 15:30:32', 2, 0);
INSERT INTO `member_login_record` VALUES (208, 2, '2019-11-30 16:12:46', 2, 0);
INSERT INTO `member_login_record` VALUES (209, 1, '2019-11-30 16:33:40', 1, 0);
INSERT INTO `member_login_record` VALUES (210, 1, '2019-11-30 16:43:01', 1, 0);
INSERT INTO `member_login_record` VALUES (211, 40, '2019-11-30 16:45:04', 1, 0);
INSERT INTO `member_login_record` VALUES (212, 2, '2019-11-30 16:45:22', 2, 0);
INSERT INTO `member_login_record` VALUES (213, 1, '2019-11-30 17:01:54', 1, 0);
INSERT INTO `member_login_record` VALUES (214, 1, '2019-11-30 17:12:13', 1, 0);
INSERT INTO `member_login_record` VALUES (215, 2, '2019-11-30 17:34:25', 2, 0);
INSERT INTO `member_login_record` VALUES (216, 2, '2019-12-01 14:02:43', 2, 0);
INSERT INTO `member_login_record` VALUES (217, 2, '2019-12-01 15:06:03', 2, 0);
INSERT INTO `member_login_record` VALUES (218, 35, '2019-12-01 15:56:39', 1, 0);
INSERT INTO `member_login_record` VALUES (219, 2, '2019-12-01 16:28:52', 2, 0);
INSERT INTO `member_login_record` VALUES (220, 2, '2019-12-01 16:32:53', 2, 0);
INSERT INTO `member_login_record` VALUES (221, 2, '2019-12-01 16:55:24', 2, 0);
INSERT INTO `member_login_record` VALUES (222, 1, '2019-12-02 08:09:11', 1, 0);
INSERT INTO `member_login_record` VALUES (223, 1, '2019-12-02 08:32:02', 1, 0);
INSERT INTO `member_login_record` VALUES (224, 52, '2019-12-02 09:01:28', 1, 2);
INSERT INTO `member_login_record` VALUES (225, 60, '2019-12-02 09:04:55', 1, 2);
INSERT INTO `member_login_record` VALUES (226, 35, '2019-12-02 09:05:32', 1, 0);
INSERT INTO `member_login_record` VALUES (227, 2, '2019-12-02 09:08:42', 2, 0);
INSERT INTO `member_login_record` VALUES (228, 2, '2019-12-02 09:12:56', 2, 0);
INSERT INTO `member_login_record` VALUES (229, 49, '2019-12-02 09:22:28', 1, 0);
INSERT INTO `member_login_record` VALUES (230, 2, '2019-12-02 09:24:24', 2, 0);
INSERT INTO `member_login_record` VALUES (231, 60, '2019-12-02 09:29:05', 1, 2);
INSERT INTO `member_login_record` VALUES (232, 41, '2019-12-02 09:30:52', 1, 0);
INSERT INTO `member_login_record` VALUES (233, 2, '2019-12-02 09:32:01', 2, 0);
INSERT INTO `member_login_record` VALUES (234, 66, '2019-12-02 09:32:17', 1, 0);
INSERT INTO `member_login_record` VALUES (235, 60, '2019-12-02 09:32:56', 1, 2);
INSERT INTO `member_login_record` VALUES (236, 2, '2019-12-02 09:33:09', 2, 0);
INSERT INTO `member_login_record` VALUES (237, 2, '2019-12-02 09:34:49', 2, 0);
INSERT INTO `member_login_record` VALUES (238, 1, '2019-12-02 09:35:43', 1, 0);
INSERT INTO `member_login_record` VALUES (239, 2, '2019-12-02 09:37:27', 2, 0);
INSERT INTO `member_login_record` VALUES (240, 52, '2019-12-02 09:38:51', 1, 2);
INSERT INTO `member_login_record` VALUES (241, 52, '2019-12-02 09:41:09', 1, 0);
INSERT INTO `member_login_record` VALUES (242, 1, '2019-12-02 09:42:50', 1, 0);
INSERT INTO `member_login_record` VALUES (243, 2, '2019-12-02 09:46:18', 2, 0);
INSERT INTO `member_login_record` VALUES (244, 2, '2019-12-02 09:52:25', 2, 0);
INSERT INTO `member_login_record` VALUES (245, 1, '2019-12-02 09:54:46', 1, 0);
INSERT INTO `member_login_record` VALUES (246, 2, '2019-12-02 09:56:41', 2, 0);
INSERT INTO `member_login_record` VALUES (247, 1, '2019-12-02 09:58:17', 1, 1);
INSERT INTO `member_login_record` VALUES (248, 52, '2019-12-02 09:59:26', 1, 0);
INSERT INTO `member_login_record` VALUES (249, 2, '2019-12-02 10:01:17', 2, 0);
INSERT INTO `member_login_record` VALUES (250, 2, '2019-12-02 10:04:03', 2, 0);
INSERT INTO `member_login_record` VALUES (251, 2, '2019-12-02 10:12:44', 2, 0);
INSERT INTO `member_login_record` VALUES (252, 2, '2019-12-02 10:16:15', 2, 0);
INSERT INTO `member_login_record` VALUES (253, 2, '2019-12-02 10:18:22', 2, 0);
INSERT INTO `member_login_record` VALUES (254, 2, '2019-12-02 10:20:04', 2, 0);
INSERT INTO `member_login_record` VALUES (255, 2, '2019-12-02 10:20:00', 2, 0);
INSERT INTO `member_login_record` VALUES (256, 2, '2019-12-02 10:31:03', 2, 0);
INSERT INTO `member_login_record` VALUES (257, 2, '2019-12-02 10:40:01', 2, 0);
INSERT INTO `member_login_record` VALUES (258, 2, '2019-12-02 11:10:20', 2, 0);
INSERT INTO `member_login_record` VALUES (259, 2, '2019-12-02 11:24:44', 2, 0);
INSERT INTO `member_login_record` VALUES (260, 60, '2019-12-02 11:39:06', 1, 2);
INSERT INTO `member_login_record` VALUES (261, 1, '2019-12-02 11:42:56', 1, 0);
INSERT INTO `member_login_record` VALUES (262, 1, '2019-12-02 11:43:05', 1, 0);
INSERT INTO `member_login_record` VALUES (263, 60, '2019-12-02 11:45:06', 1, 2);
INSERT INTO `member_login_record` VALUES (264, 60, '2019-12-02 11:47:19', 1, 2);
INSERT INTO `member_login_record` VALUES (265, 52, '2019-12-02 11:55:38', 1, 1);
INSERT INTO `member_login_record` VALUES (266, 20, '2019-12-02 12:22:14', 2, 0);
INSERT INTO `member_login_record` VALUES (267, 2, '2019-12-02 13:38:29', 2, 0);
INSERT INTO `member_login_record` VALUES (268, 1, '2019-12-02 14:04:54', 1, 1);
INSERT INTO `member_login_record` VALUES (269, 20, '2019-12-02 14:04:56', 2, 0);
INSERT INTO `member_login_record` VALUES (270, 1, '2019-12-02 14:08:24', 1, 1);
INSERT INTO `member_login_record` VALUES (271, 2, '2019-12-02 14:09:00', 2, 0);
INSERT INTO `member_login_record` VALUES (272, 60, '2019-12-02 14:09:13', 1, 2);
INSERT INTO `member_login_record` VALUES (273, 52, '2019-12-02 14:10:38', 1, 1);
INSERT INTO `member_login_record` VALUES (274, 59, '2019-12-02 14:11:16', 1, 1);
INSERT INTO `member_login_record` VALUES (275, 2, '2019-12-02 14:15:23', 2, 0);
INSERT INTO `member_login_record` VALUES (276, 2, '2019-12-02 14:15:51', 2, 0);
INSERT INTO `member_login_record` VALUES (277, 2, '2019-12-02 14:16:36', 2, 0);
INSERT INTO `member_login_record` VALUES (278, 2, '2019-12-02 14:17:31', 2, 0);
INSERT INTO `member_login_record` VALUES (279, 2, '2019-12-02 14:19:47', 2, 0);
INSERT INTO `member_login_record` VALUES (280, 2, '2019-12-02 14:21:10', 2, 0);
INSERT INTO `member_login_record` VALUES (281, 2, '2019-12-02 14:27:03', 2, 0);
INSERT INTO `member_login_record` VALUES (282, 2, '2019-12-02 14:26:37', 2, 0);
INSERT INTO `member_login_record` VALUES (283, 35, '2019-12-02 14:28:14', 1, 1);
INSERT INTO `member_login_record` VALUES (284, 2, '2019-12-02 14:29:47', 2, 0);
INSERT INTO `member_login_record` VALUES (285, 59, '2019-12-02 14:43:25', 1, 1);
INSERT INTO `member_login_record` VALUES (286, 2, '2019-12-02 14:44:02', 2, 0);
INSERT INTO `member_login_record` VALUES (287, 2, '2019-12-02 14:48:34', 2, 0);
INSERT INTO `member_login_record` VALUES (288, 1, '2019-12-02 14:50:26', 1, 1);
INSERT INTO `member_login_record` VALUES (289, 2, '2019-12-02 14:57:09', 2, 0);
INSERT INTO `member_login_record` VALUES (290, 52, '2019-12-02 15:01:08', 1, 1);
INSERT INTO `member_login_record` VALUES (291, 66, '2019-12-02 15:09:16', 1, 1);
INSERT INTO `member_login_record` VALUES (292, 60, '2019-12-02 15:15:12', 1, 2);
INSERT INTO `member_login_record` VALUES (293, 52, '2019-12-02 15:20:34', 1, 0);
INSERT INTO `member_login_record` VALUES (294, 1, '2019-12-02 15:22:48', 1, 1);
INSERT INTO `member_login_record` VALUES (295, 1, '2019-12-02 15:23:09', 1, 1);
INSERT INTO `member_login_record` VALUES (296, 2, '2019-12-02 15:35:36', 2, 0);
INSERT INTO `member_login_record` VALUES (297, 52, '2019-12-02 15:38:23', 1, 1);
INSERT INTO `member_login_record` VALUES (298, 1, '2019-12-02 16:14:30', 1, 1);
INSERT INTO `member_login_record` VALUES (299, 2, '2019-12-02 16:36:24', 2, 0);
INSERT INTO `member_login_record` VALUES (300, 2, '2019-12-02 16:48:38', 2, 0);
INSERT INTO `member_login_record` VALUES (301, 66, '2019-12-02 16:52:01', 1, 1);
INSERT INTO `member_login_record` VALUES (302, 1, '2019-12-02 16:53:07', 1, 1);
INSERT INTO `member_login_record` VALUES (303, 1, '2019-12-02 16:53:59', 1, 1);
INSERT INTO `member_login_record` VALUES (304, 66, '2019-12-02 16:58:32', 1, 1);
INSERT INTO `member_login_record` VALUES (305, 1, '2019-12-02 17:11:35', 1, 0);
INSERT INTO `member_login_record` VALUES (306, 2, '2019-12-02 17:13:23', 2, 0);
INSERT INTO `member_login_record` VALUES (307, 2, '2019-12-02 17:13:59', 2, 0);
INSERT INTO `member_login_record` VALUES (308, 1, '2019-12-02 17:42:53', 1, 1);
INSERT INTO `member_login_record` VALUES (309, 2, '2019-12-02 18:25:17', 2, 0);
INSERT INTO `member_login_record` VALUES (310, 1, '2019-12-02 18:41:26', 1, 1);
INSERT INTO `member_login_record` VALUES (311, 1, '2019-12-02 18:55:02', 1, 1);
INSERT INTO `member_login_record` VALUES (312, 52, '2019-12-02 19:00:22', 1, 1);
INSERT INTO `member_login_record` VALUES (313, 52, '2019-12-02 19:00:22', 1, 1);
INSERT INTO `member_login_record` VALUES (314, 52, '2019-12-02 19:00:28', 1, 2);
INSERT INTO `member_login_record` VALUES (315, 52, '2019-12-02 19:01:43', 1, 1);
INSERT INTO `member_login_record` VALUES (316, 52, '2019-12-02 19:03:11', 1, 1);
INSERT INTO `member_login_record` VALUES (317, 1, '2019-12-02 19:14:44', 1, 1);
INSERT INTO `member_login_record` VALUES (318, 1, '2019-12-02 19:15:46', 1, 1);
INSERT INTO `member_login_record` VALUES (319, 2, '2019-12-02 19:21:12', 2, 0);
INSERT INTO `member_login_record` VALUES (320, 2, '2019-12-02 19:30:06', 2, 0);
INSERT INTO `member_login_record` VALUES (321, 2, '2019-12-02 19:32:10', 2, 0);
INSERT INTO `member_login_record` VALUES (322, 2, '2019-12-02 20:03:43', 2, 0);
INSERT INTO `member_login_record` VALUES (323, 2, '2019-12-02 20:24:18', 2, 0);
INSERT INTO `member_login_record` VALUES (324, 2, '2019-12-03 08:23:08', 2, 0);
INSERT INTO `member_login_record` VALUES (325, 1, '2019-12-03 08:36:46', 1, 1);
INSERT INTO `member_login_record` VALUES (326, 1, '2019-12-03 08:36:52', 1, 1);
INSERT INTO `member_login_record` VALUES (327, 1, '2019-12-03 08:36:57', 1, 1);
INSERT INTO `member_login_record` VALUES (328, 2, '2019-12-03 08:45:16', 2, 0);
INSERT INTO `member_login_record` VALUES (329, 1, '2019-12-03 08:49:25', 1, 1);
INSERT INTO `member_login_record` VALUES (330, 2, '2019-12-03 08:50:23', 2, 0);
INSERT INTO `member_login_record` VALUES (331, 2, '2019-12-03 09:00:19', 2, 0);
INSERT INTO `member_login_record` VALUES (332, 2, '2019-12-03 09:05:16', 2, 0);
INSERT INTO `member_login_record` VALUES (333, 66, '2019-12-03 09:05:13', 1, 1);
INSERT INTO `member_login_record` VALUES (334, 2, '2019-12-03 09:08:21', 2, 0);
INSERT INTO `member_login_record` VALUES (335, 2, '2019-12-03 09:15:00', 2, 0);
INSERT INTO `member_login_record` VALUES (336, 2, '2019-12-03 09:17:45', 2, 0);
INSERT INTO `member_login_record` VALUES (337, 2, '2019-12-03 09:26:03', 2, 0);
INSERT INTO `member_login_record` VALUES (338, 60, '2019-12-03 09:26:51', 1, 2);
INSERT INTO `member_login_record` VALUES (339, 52, '2019-12-03 09:27:42', 1, 2);
INSERT INTO `member_login_record` VALUES (340, 1, '2019-12-03 09:33:49', 1, 1);
INSERT INTO `member_login_record` VALUES (341, 2, '2019-12-03 09:42:48', 2, 0);
INSERT INTO `member_login_record` VALUES (342, 2, '2019-12-03 09:47:04', 2, 0);
INSERT INTO `member_login_record` VALUES (343, 59, '2019-12-03 09:48:01', 1, 1);
INSERT INTO `member_login_record` VALUES (344, 1, '2019-12-03 09:53:31', 1, 1);
INSERT INTO `member_login_record` VALUES (345, 59, '2019-12-03 10:01:13', 1, 1);
INSERT INTO `member_login_record` VALUES (346, 1, '2019-12-03 10:06:35', 1, 1);
INSERT INTO `member_login_record` VALUES (347, 59, '2019-12-03 10:14:24', 1, 1);
INSERT INTO `member_login_record` VALUES (348, 1, '2019-12-03 10:19:06', 1, 1);
INSERT INTO `member_login_record` VALUES (349, 20, '2019-12-03 10:35:58', 2, 0);
INSERT INTO `member_login_record` VALUES (350, 2, '2019-12-03 10:36:51', 2, 0);
INSERT INTO `member_login_record` VALUES (351, 1, '2019-12-03 10:39:45', 1, 1);
INSERT INTO `member_login_record` VALUES (352, 2, '2019-12-03 10:41:51', 2, 0);
INSERT INTO `member_login_record` VALUES (353, 66, '2019-12-03 10:43:22', 1, 1);
INSERT INTO `member_login_record` VALUES (354, 2, '2019-12-03 10:51:13', 2, 0);
INSERT INTO `member_login_record` VALUES (355, 35, '2019-12-03 10:55:40', 1, 1);
INSERT INTO `member_login_record` VALUES (356, 1, '2019-12-03 11:02:12', 1, 1);
INSERT INTO `member_login_record` VALUES (357, 52, '2019-12-03 11:25:12', 1, 1);
INSERT INTO `member_login_record` VALUES (358, 70, '2019-12-03 11:25:08', 1, 1);
INSERT INTO `member_login_record` VALUES (359, 1, '2019-12-03 11:28:41', 1, 1);
INSERT INTO `member_login_record` VALUES (360, 1, '2019-12-03 11:37:27', 1, 1);
INSERT INTO `member_login_record` VALUES (361, 2, '2019-12-03 11:57:44', 2, 0);
INSERT INTO `member_login_record` VALUES (362, 1, '2019-12-03 11:59:08', 1, 1);
INSERT INTO `member_login_record` VALUES (363, 2, '2019-12-03 14:17:46', 2, 0);
INSERT INTO `member_login_record` VALUES (364, 1, '2019-12-03 14:20:12', 1, 1);
INSERT INTO `member_login_record` VALUES (365, 1, '2019-12-03 14:25:10', 1, 1);
INSERT INTO `member_login_record` VALUES (366, 1, '2019-12-03 14:33:08', 1, 1);
INSERT INTO `member_login_record` VALUES (367, 52, '2019-12-03 14:34:21', 1, 2);
INSERT INTO `member_login_record` VALUES (368, 2, '2019-12-03 14:35:39', 2, 0);
INSERT INTO `member_login_record` VALUES (369, 2, '2019-12-03 14:36:15', 2, 0);
INSERT INTO `member_login_record` VALUES (370, 1, '2019-12-03 14:58:44', 1, 1);
INSERT INTO `member_login_record` VALUES (371, 2, '2019-12-03 15:03:12', 2, 0);
INSERT INTO `member_login_record` VALUES (372, 1, '2019-12-03 15:05:37', 1, 1);
INSERT INTO `member_login_record` VALUES (373, 2, '2019-12-03 15:07:48', 2, 0);
INSERT INTO `member_login_record` VALUES (374, 1, '2019-12-03 15:16:31', 1, 1);
INSERT INTO `member_login_record` VALUES (375, 2, '2019-12-03 15:18:08', 2, 0);
INSERT INTO `member_login_record` VALUES (376, 1, '2019-12-03 15:24:37', 1, 1);
INSERT INTO `member_login_record` VALUES (377, 2, '2019-12-03 15:28:12', 2, 0);
INSERT INTO `member_login_record` VALUES (378, 2, '2019-12-03 15:31:07', 2, 0);
INSERT INTO `member_login_record` VALUES (379, 1, '2019-12-03 15:33:30', 1, 1);
INSERT INTO `member_login_record` VALUES (380, 59, '2019-12-03 15:36:52', 1, 1);
INSERT INTO `member_login_record` VALUES (381, 66, '2019-12-03 15:37:14', 1, 1);
INSERT INTO `member_login_record` VALUES (382, 2, '2019-12-03 15:43:00', 2, 0);
INSERT INTO `member_login_record` VALUES (383, 52, '2019-12-03 15:48:53', 1, 1);
INSERT INTO `member_login_record` VALUES (384, 1, '2019-12-03 16:20:26', 1, 1);
INSERT INTO `member_login_record` VALUES (385, 1, '2019-12-03 16:28:23', 1, 1);
INSERT INTO `member_login_record` VALUES (386, 66, '2019-12-03 16:30:35', 1, 1);
INSERT INTO `member_login_record` VALUES (387, 52, '2019-12-03 16:30:51', 1, 1);
INSERT INTO `member_login_record` VALUES (388, 52, '2019-12-03 16:59:54', 1, 1);
INSERT INTO `member_login_record` VALUES (389, 2, '2019-12-03 17:03:01', 2, 0);
INSERT INTO `member_login_record` VALUES (390, 2, '2019-12-03 17:03:31', 2, 0);
INSERT INTO `member_login_record` VALUES (391, 71, '2019-12-03 17:11:25', 1, 1);
INSERT INTO `member_login_record` VALUES (392, 1, '2019-12-03 17:11:30', 1, 1);
INSERT INTO `member_login_record` VALUES (393, 2, '2019-12-03 17:17:31', 2, 0);
INSERT INTO `member_login_record` VALUES (394, 1, '2019-12-03 17:17:31', 1, 1);
INSERT INTO `member_login_record` VALUES (395, 1, '2019-12-03 18:12:40', 1, 1);
INSERT INTO `member_login_record` VALUES (396, 1, '2019-12-03 18:19:52', 1, 1);
INSERT INTO `member_login_record` VALUES (397, 2, '2019-12-03 18:20:25', 2, 0);
INSERT INTO `member_login_record` VALUES (398, 59, '2019-12-03 18:25:32', 1, 1);
INSERT INTO `member_login_record` VALUES (399, 2, '2019-12-03 18:37:38', 2, 0);
INSERT INTO `member_login_record` VALUES (400, 2, '2019-12-03 18:38:14', 2, 0);
INSERT INTO `member_login_record` VALUES (401, 35, '2019-12-03 18:39:24', 2, 0);
INSERT INTO `member_login_record` VALUES (402, 2, '2019-12-03 19:05:14', 2, 0);
INSERT INTO `member_login_record` VALUES (403, 1, '2019-12-03 19:22:39', 1, 1);
INSERT INTO `member_login_record` VALUES (404, 1, '2019-12-03 19:43:34', 1, 1);
INSERT INTO `member_login_record` VALUES (405, 2, '2019-12-03 19:47:43', 2, 0);
INSERT INTO `member_login_record` VALUES (406, 2, '2019-12-04 08:11:30', 2, 0);
INSERT INTO `member_login_record` VALUES (407, 20, '2019-12-04 08:36:25', 2, 0);
INSERT INTO `member_login_record` VALUES (408, 2, '2019-12-04 08:39:19', 2, 0);
INSERT INTO `member_login_record` VALUES (409, 2, '2019-12-04 08:45:33', 2, 0);
INSERT INTO `member_login_record` VALUES (410, 1, '2019-12-04 08:45:41', 1, 1);
INSERT INTO `member_login_record` VALUES (411, 59, '2019-12-04 08:52:42', 1, 1);
INSERT INTO `member_login_record` VALUES (412, 2, '2019-12-04 08:58:30', 2, 0);
INSERT INTO `member_login_record` VALUES (413, 71, '2019-12-04 09:00:50', 1, 1);
INSERT INTO `member_login_record` VALUES (414, 2, '2019-12-04 09:02:45', 2, 0);
INSERT INTO `member_login_record` VALUES (415, 1, '2019-12-04 09:12:07', 1, 1);
INSERT INTO `member_login_record` VALUES (416, 2, '2019-12-04 09:16:06', 2, 0);
INSERT INTO `member_login_record` VALUES (417, 2, '2019-12-04 09:16:45', 2, 0);
INSERT INTO `member_login_record` VALUES (418, 52, '2019-12-04 09:17:11', 1, 1);
INSERT INTO `member_login_record` VALUES (419, 1, '2019-12-04 09:23:37', 1, 1);
INSERT INTO `member_login_record` VALUES (420, 72, '2019-12-04 09:29:32', 1, 1);
INSERT INTO `member_login_record` VALUES (421, 75, '2019-12-04 09:38:46', 1, 1);
INSERT INTO `member_login_record` VALUES (422, 2, '2019-12-04 09:49:13', 2, 0);
INSERT INTO `member_login_record` VALUES (423, 1, '2019-12-04 09:50:01', 1, 1);
INSERT INTO `member_login_record` VALUES (424, 1, '2019-12-04 09:51:54', 1, 1);
INSERT INTO `member_login_record` VALUES (425, 52, '2019-12-04 09:52:40', 1, 1);
INSERT INTO `member_login_record` VALUES (426, 1, '2019-12-04 09:57:33', 1, 1);
INSERT INTO `member_login_record` VALUES (427, 76, '2019-12-04 10:03:12', 1, 1);
INSERT INTO `member_login_record` VALUES (428, 1, '2019-12-04 10:08:08', 1, 1);
INSERT INTO `member_login_record` VALUES (429, 2, '2019-12-04 10:08:17', 2, 0);
INSERT INTO `member_login_record` VALUES (430, 2, '2019-12-04 10:15:03', 2, 0);
INSERT INTO `member_login_record` VALUES (431, 2, '2019-12-04 10:15:13', 2, 0);
INSERT INTO `member_login_record` VALUES (432, 1, '2019-12-04 10:15:59', 1, 1);
INSERT INTO `member_login_record` VALUES (433, 2, '2019-12-04 10:18:00', 2, 0);
INSERT INTO `member_login_record` VALUES (434, 1, '2019-12-04 10:26:20', 1, 1);
INSERT INTO `member_login_record` VALUES (435, 71, '2019-12-04 10:30:25', 1, 1);
INSERT INTO `member_login_record` VALUES (436, 35, '2019-12-04 10:38:47', 1, 1);
INSERT INTO `member_login_record` VALUES (437, 2, '2019-12-04 11:18:01', 2, 0);
INSERT INTO `member_login_record` VALUES (438, 2, '2019-12-04 11:37:51', 2, 0);
INSERT INTO `member_login_record` VALUES (439, 2, '2019-12-04 11:42:04', 2, 0);
INSERT INTO `member_login_record` VALUES (440, 71, '2019-12-04 11:43:40', 1, 1);
INSERT INTO `member_login_record` VALUES (441, 1, '2019-12-04 11:43:52', 1, 1);
INSERT INTO `member_login_record` VALUES (442, 52, '2019-12-04 11:56:02', 1, 1);
INSERT INTO `member_login_record` VALUES (443, 1, '2019-12-04 11:58:44', 1, 1);
INSERT INTO `member_login_record` VALUES (444, 1, '2019-12-04 14:09:32', 1, 1);
INSERT INTO `member_login_record` VALUES (445, 1, '2019-12-04 14:10:26', 1, 1);
INSERT INTO `member_login_record` VALUES (446, 1, '2019-12-04 14:12:13', 1, 1);
INSERT INTO `member_login_record` VALUES (447, 71, '2019-12-04 14:18:28', 1, 1);
INSERT INTO `member_login_record` VALUES (448, 2, '2019-12-04 14:25:04', 2, 0);
INSERT INTO `member_login_record` VALUES (449, 1, '2019-12-04 14:33:40', 1, 1);
INSERT INTO `member_login_record` VALUES (450, 71, '2019-12-04 14:37:48', 1, 1);
INSERT INTO `member_login_record` VALUES (451, 1, '2019-12-04 14:38:27', 1, 1);
INSERT INTO `member_login_record` VALUES (452, 52, '2019-12-04 14:41:01', 1, 1);
INSERT INTO `member_login_record` VALUES (453, 1, '2019-12-04 14:43:03', 1, 1);
INSERT INTO `member_login_record` VALUES (454, 1, '2019-12-04 14:43:06', 1, 1);
INSERT INTO `member_login_record` VALUES (455, 80, '2019-12-04 14:46:53', 1, 1);
INSERT INTO `member_login_record` VALUES (456, 1, '2019-12-04 14:47:36', 1, 1);
INSERT INTO `member_login_record` VALUES (457, 52, '2019-12-04 14:48:48', 1, 1);
INSERT INTO `member_login_record` VALUES (458, 1, '2019-12-04 14:54:09', 1, 1);
INSERT INTO `member_login_record` VALUES (459, 71, '2019-12-04 14:56:53', 1, 1);
INSERT INTO `member_login_record` VALUES (460, 71, '2019-12-04 14:57:35', 1, 1);
INSERT INTO `member_login_record` VALUES (461, 1, '2019-12-04 14:58:56', 1, 1);
INSERT INTO `member_login_record` VALUES (462, 2, '2019-12-04 15:02:04', 2, 0);
INSERT INTO `member_login_record` VALUES (463, 1, '2019-12-04 15:04:33', 1, 1);
INSERT INTO `member_login_record` VALUES (464, 2, '2019-12-04 15:06:57', 2, 0);
INSERT INTO `member_login_record` VALUES (465, 52, '2019-12-04 15:08:28', 1, 1);
INSERT INTO `member_login_record` VALUES (466, 81, '2019-12-04 15:11:19', 1, 1);
INSERT INTO `member_login_record` VALUES (467, 71, '2019-12-04 15:20:19', 1, 1);
INSERT INTO `member_login_record` VALUES (468, 1, '2019-12-04 15:21:56', 1, 1);
INSERT INTO `member_login_record` VALUES (469, 1, '2019-12-04 15:31:55', 1, 1);
INSERT INTO `member_login_record` VALUES (470, 52, '2019-12-04 15:36:18', 1, 1);
INSERT INTO `member_login_record` VALUES (471, 1, '2019-12-04 15:42:52', 1, 1);
INSERT INTO `member_login_record` VALUES (472, 52, '2019-12-04 15:46:17', 1, 1);
INSERT INTO `member_login_record` VALUES (473, 52, '2019-12-04 15:59:49', 1, 1);
INSERT INTO `member_login_record` VALUES (474, 52, '2019-12-04 16:01:18', 1, 1);
INSERT INTO `member_login_record` VALUES (475, 1, '2019-12-04 16:22:13', 1, 1);
INSERT INTO `member_login_record` VALUES (476, 2, '2019-12-04 16:26:45', 2, 0);
INSERT INTO `member_login_record` VALUES (477, 1, '2019-12-04 17:07:44', 1, 1);
INSERT INTO `member_login_record` VALUES (478, 2, '2019-12-04 17:08:41', 2, 0);
INSERT INTO `member_login_record` VALUES (479, 1, '2019-12-04 17:42:25', 1, 1);
INSERT INTO `member_login_record` VALUES (480, 2, '2019-12-04 17:48:55', 2, 0);
INSERT INTO `member_login_record` VALUES (481, 52, '2019-12-04 17:52:34', 1, 2);
INSERT INTO `member_login_record` VALUES (482, 71, '2019-12-04 18:37:57', 1, 1);
INSERT INTO `member_login_record` VALUES (483, 2, '2019-12-04 18:44:59', 2, 0);
INSERT INTO `member_login_record` VALUES (484, 52, '2019-12-04 18:46:25', 1, 1);
INSERT INTO `member_login_record` VALUES (485, 2, '2019-12-04 18:49:37', 2, 0);
INSERT INTO `member_login_record` VALUES (486, 1, '2019-12-04 19:18:40', 1, 1);
INSERT INTO `member_login_record` VALUES (487, 1, '2019-12-04 19:18:46', 1, 1);
INSERT INTO `member_login_record` VALUES (488, 1, '2019-12-04 19:19:03', 1, 1);
INSERT INTO `member_login_record` VALUES (489, 1, '2019-12-04 19:28:04', 1, 1);
INSERT INTO `member_login_record` VALUES (490, 2, '2019-12-04 19:32:33', 2, 0);
INSERT INTO `member_login_record` VALUES (491, 52, '2019-12-04 19:33:51', 1, 1);
INSERT INTO `member_login_record` VALUES (492, 2, '2019-12-04 19:34:27', 2, 0);
INSERT INTO `member_login_record` VALUES (493, 52, '2019-12-04 19:35:25', 1, 1);
INSERT INTO `member_login_record` VALUES (494, 2, '2019-12-04 19:39:33', 2, 0);
INSERT INTO `member_login_record` VALUES (495, 1, '2019-12-04 20:00:16', 1, 1);
INSERT INTO `member_login_record` VALUES (496, 1, '2019-12-04 20:02:36', 1, 1);
INSERT INTO `member_login_record` VALUES (497, 52, '2019-12-04 20:02:37', 1, 1);
INSERT INTO `member_login_record` VALUES (498, 52, '2019-12-04 20:03:03', 1, 1);
INSERT INTO `member_login_record` VALUES (499, 52, '2019-12-04 20:03:46', 1, 1);
INSERT INTO `member_login_record` VALUES (500, 1, '2019-12-04 20:15:53', 1, 1);
INSERT INTO `member_login_record` VALUES (501, 1, '2019-12-04 20:20:26', 1, 1);
INSERT INTO `member_login_record` VALUES (502, 2, '2019-12-05 08:34:41', 2, 0);
INSERT INTO `member_login_record` VALUES (503, 1, '2019-12-05 08:43:43', 1, 1);
INSERT INTO `member_login_record` VALUES (504, 52, '2019-12-05 08:47:35', 1, 1);
INSERT INTO `member_login_record` VALUES (505, 71, '2019-12-05 08:48:00', 1, 1);
INSERT INTO `member_login_record` VALUES (506, 1, '2019-12-05 08:49:37', 1, 1);
INSERT INTO `member_login_record` VALUES (507, 1, '2019-12-05 08:50:25', 1, 1);
INSERT INTO `member_login_record` VALUES (508, 52, '2019-12-05 08:50:52', 1, 1);
INSERT INTO `member_login_record` VALUES (509, 2, '2019-12-05 08:52:45', 2, 0);
INSERT INTO `member_login_record` VALUES (510, 1, '2019-12-05 08:53:50', 1, 1);
INSERT INTO `member_login_record` VALUES (511, 2, '2019-12-05 08:54:01', 2, 0);
INSERT INTO `member_login_record` VALUES (512, 1, '2019-12-05 08:57:01', 1, 1);
INSERT INTO `member_login_record` VALUES (513, 2, '2019-12-05 08:57:59', 2, 0);
INSERT INTO `member_login_record` VALUES (514, 1, '2019-12-05 08:58:36', 1, 1);
INSERT INTO `member_login_record` VALUES (515, 1, '2019-12-05 08:59:07', 1, 1);
INSERT INTO `member_login_record` VALUES (516, 59, '2019-12-05 09:00:39', 1, 1);
INSERT INTO `member_login_record` VALUES (517, 2, '2019-12-05 09:01:51', 2, 0);
INSERT INTO `member_login_record` VALUES (518, 2, '2019-12-05 09:03:35', 2, 0);
INSERT INTO `member_login_record` VALUES (519, 1, '2019-12-05 09:03:04', 1, 1);
INSERT INTO `member_login_record` VALUES (520, 2, '2019-12-05 09:06:18', 2, 0);
INSERT INTO `member_login_record` VALUES (521, 1, '2019-12-05 09:10:13', 1, 1);
INSERT INTO `member_login_record` VALUES (522, 1, '2019-12-05 09:23:28', 1, 1);
INSERT INTO `member_login_record` VALUES (523, 1, '2019-12-05 09:24:16', 1, 1);
INSERT INTO `member_login_record` VALUES (524, 52, '2019-12-05 09:32:20', 1, 1);
INSERT INTO `member_login_record` VALUES (525, 52, '2019-12-05 09:32:56', 1, 1);
INSERT INTO `member_login_record` VALUES (526, 52, '2019-12-05 09:33:28', 1, 1);
INSERT INTO `member_login_record` VALUES (527, 2, '2019-12-05 09:36:21', 2, 0);
INSERT INTO `member_login_record` VALUES (528, 48, '2019-12-05 09:42:49', 1, 1);
INSERT INTO `member_login_record` VALUES (529, 71, '2019-12-05 09:49:45', 1, 1);
INSERT INTO `member_login_record` VALUES (530, 82, '2019-12-05 09:53:15', 1, 1);
INSERT INTO `member_login_record` VALUES (531, 1, '2019-12-05 09:56:01', 1, 1);
INSERT INTO `member_login_record` VALUES (532, 72, '2019-12-05 09:56:15', 1, 1);
INSERT INTO `member_login_record` VALUES (533, 83, '2019-12-05 10:00:03', 1, 1);
INSERT INTO `member_login_record` VALUES (534, 82, '2019-12-05 10:00:33', 1, 1);
INSERT INTO `member_login_record` VALUES (535, 1, '2019-12-05 10:11:21', 1, 1);
INSERT INTO `member_login_record` VALUES (536, 72, '2019-12-05 10:19:06', 1, 1);
INSERT INTO `member_login_record` VALUES (537, 2, '2019-12-05 10:33:13', 2, 0);
INSERT INTO `member_login_record` VALUES (538, 2, '2019-12-05 10:36:06', 2, 0);
INSERT INTO `member_login_record` VALUES (539, 2, '2019-12-05 10:47:10', 2, 0);
INSERT INTO `member_login_record` VALUES (540, 2, '2019-12-05 10:50:39', 2, 0);
INSERT INTO `member_login_record` VALUES (541, 2, '2019-12-05 11:00:01', 2, 0);
INSERT INTO `member_login_record` VALUES (542, 2, '2019-12-05 11:00:33', 2, 0);
INSERT INTO `member_login_record` VALUES (543, 52, '2019-12-05 11:17:12', 1, 1);
INSERT INTO `member_login_record` VALUES (544, 2, '2019-12-05 11:24:10', 2, 0);
INSERT INTO `member_login_record` VALUES (545, 52, '2019-12-05 11:26:59', 1, 1);
INSERT INTO `member_login_record` VALUES (546, 1, '2019-12-05 11:29:57', 1, 1);
INSERT INTO `member_login_record` VALUES (547, 1, '2019-12-05 11:31:24', 1, 1);
INSERT INTO `member_login_record` VALUES (548, 1, '2019-12-05 11:32:00', 1, 1);
INSERT INTO `member_login_record` VALUES (549, 71, '2019-12-05 14:05:25', 1, 1);
INSERT INTO `member_login_record` VALUES (550, 1, '2019-12-05 14:20:22', 1, 1);
INSERT INTO `member_login_record` VALUES (551, 2, '2019-12-05 14:34:14', 2, 0);
INSERT INTO `member_login_record` VALUES (552, 2, '2019-12-05 14:36:03', 2, 0);
INSERT INTO `member_login_record` VALUES (553, 2, '2019-12-05 14:50:19', 2, 0);
INSERT INTO `member_login_record` VALUES (554, 52, '2019-12-05 14:55:14', 1, 1);
INSERT INTO `member_login_record` VALUES (555, 82, '2019-12-05 14:57:29', 1, 1);
INSERT INTO `member_login_record` VALUES (556, 52, '2019-12-05 14:58:26', 1, 1);
INSERT INTO `member_login_record` VALUES (557, 72, '2019-12-05 15:07:30', 1, 1);
INSERT INTO `member_login_record` VALUES (558, 1, '2019-12-05 15:09:00', 1, 1);
INSERT INTO `member_login_record` VALUES (559, 35, '2019-12-05 15:10:33', 2, 0);
INSERT INTO `member_login_record` VALUES (560, 80, '2019-12-05 15:12:10', 1, 1);
INSERT INTO `member_login_record` VALUES (561, 52, '2019-12-05 15:17:21', 1, 1);
INSERT INTO `member_login_record` VALUES (562, 83, '2019-12-05 15:20:05', 1, 1);
INSERT INTO `member_login_record` VALUES (563, 80, '2019-12-05 15:21:37', 1, 1);
INSERT INTO `member_login_record` VALUES (564, 35, '2019-12-05 15:30:33', 2, 0);
INSERT INTO `member_login_record` VALUES (565, 1, '2019-12-05 15:30:48', 1, 1);
INSERT INTO `member_login_record` VALUES (566, 35, '2019-12-05 15:35:17', 2, 0);
INSERT INTO `member_login_record` VALUES (567, 2, '2019-12-05 15:37:03', 2, 0);
INSERT INTO `member_login_record` VALUES (568, 83, '2019-12-05 15:39:08', 1, 1);
INSERT INTO `member_login_record` VALUES (569, 1, '2019-12-05 15:39:55', 1, 1);
INSERT INTO `member_login_record` VALUES (570, 35, '2019-12-05 15:42:34', 2, 0);
INSERT INTO `member_login_record` VALUES (571, 71, '2019-12-05 15:43:20', 1, 1);
INSERT INTO `member_login_record` VALUES (572, 35, '2019-12-05 15:55:33', 2, 0);
INSERT INTO `member_login_record` VALUES (573, 83, '2019-12-05 15:56:50', 1, 1);
INSERT INTO `member_login_record` VALUES (574, 2, '2019-12-05 16:02:06', 2, 0);
INSERT INTO `member_login_record` VALUES (575, 2, '2019-12-05 16:05:08', 2, 0);
INSERT INTO `member_login_record` VALUES (576, 85, '2019-12-05 16:08:40', 1, 1);
INSERT INTO `member_login_record` VALUES (577, 85, '2019-12-05 16:16:54', 1, 1);
INSERT INTO `member_login_record` VALUES (578, 52, '2019-12-05 16:18:06', 1, 1);
INSERT INTO `member_login_record` VALUES (579, 1, '2019-12-05 16:18:29', 1, 1);
INSERT INTO `member_login_record` VALUES (580, 52, '2019-12-05 16:19:10', 1, 1);
INSERT INTO `member_login_record` VALUES (581, 2, '2019-12-05 16:21:17', 2, 0);
INSERT INTO `member_login_record` VALUES (582, 2, '2019-12-05 16:21:24', 2, 0);
INSERT INTO `member_login_record` VALUES (583, 82, '2019-12-05 16:24:02', 1, 1);
INSERT INTO `member_login_record` VALUES (584, 1, '2019-12-05 16:29:52', 1, 1);
INSERT INTO `member_login_record` VALUES (585, 2, '2019-12-05 16:35:11', 2, 0);
INSERT INTO `member_login_record` VALUES (586, 80, '2019-12-05 16:38:06', 1, 1);
INSERT INTO `member_login_record` VALUES (587, 52, '2019-12-05 16:40:32', 1, 1);
INSERT INTO `member_login_record` VALUES (588, 71, '2019-12-05 16:45:08', 1, 1);
INSERT INTO `member_login_record` VALUES (589, 2, '2019-12-05 16:49:57', 2, 0);
INSERT INTO `member_login_record` VALUES (590, 2, '2019-12-05 16:51:47', 2, 0);
INSERT INTO `member_login_record` VALUES (591, 2, '2019-12-05 16:52:15', 2, 0);
INSERT INTO `member_login_record` VALUES (592, 52, '2019-12-05 16:53:09', 1, 1);
INSERT INTO `member_login_record` VALUES (593, 2, '2019-12-05 16:53:13', 2, 0);
INSERT INTO `member_login_record` VALUES (594, 35, '2019-12-05 17:00:48', 2, 0);
INSERT INTO `member_login_record` VALUES (595, 52, '2019-12-05 17:02:04', 1, 1);
INSERT INTO `member_login_record` VALUES (596, 80, '2019-12-05 17:02:40', 1, 1);
INSERT INTO `member_login_record` VALUES (597, 35, '2019-12-05 17:08:32', 2, 0);
INSERT INTO `member_login_record` VALUES (598, 2, '2019-12-05 17:23:16', 2, 0);
INSERT INTO `member_login_record` VALUES (599, 81, '2019-12-05 17:23:39', 1, 1);
INSERT INTO `member_login_record` VALUES (600, 2, '2019-12-05 17:23:57', 2, 0);
INSERT INTO `member_login_record` VALUES (601, 2, '2019-12-05 17:25:11', 2, 0);
INSERT INTO `member_login_record` VALUES (602, 20, '2019-12-05 17:32:00', 2, 0);
INSERT INTO `member_login_record` VALUES (603, 20, '2019-12-05 17:32:21', 2, 0);
INSERT INTO `member_login_record` VALUES (604, 80, '2019-12-05 17:34:58', 1, 1);
INSERT INTO `member_login_record` VALUES (605, 80, '2019-12-05 17:35:40', 1, 1);
INSERT INTO `member_login_record` VALUES (606, 80, '2019-12-05 17:36:59', 1, 1);
INSERT INTO `member_login_record` VALUES (607, 80, '2019-12-05 17:38:52', 1, 1);
INSERT INTO `member_login_record` VALUES (608, 52, '2019-12-05 17:40:12', 1, 1);
INSERT INTO `member_login_record` VALUES (609, 2, '2019-12-05 17:42:14', 2, 0);
INSERT INTO `member_login_record` VALUES (610, 82, '2019-12-05 17:55:26', 1, 1);
INSERT INTO `member_login_record` VALUES (611, 82, '2019-12-05 17:57:20', 1, 1);
INSERT INTO `member_login_record` VALUES (612, 2, '2019-12-05 17:58:59', 2, 0);
INSERT INTO `member_login_record` VALUES (613, 82, '2019-12-05 18:03:00', 1, 1);
INSERT INTO `member_login_record` VALUES (614, 35, '2019-12-05 18:07:19', 1, 1);
INSERT INTO `member_login_record` VALUES (615, 1, '2019-12-05 18:13:15', 1, 1);
INSERT INTO `member_login_record` VALUES (616, 49, '2019-12-05 18:15:13', 1, 1);
INSERT INTO `member_login_record` VALUES (617, 2, '2019-12-05 18:17:55', 2, 0);
INSERT INTO `member_login_record` VALUES (618, 49, '2019-12-05 18:19:09', 1, 1);
INSERT INTO `member_login_record` VALUES (619, 49, '2019-12-05 18:19:27', 1, 1);
INSERT INTO `member_login_record` VALUES (620, 2, '2019-12-05 18:28:53', 2, 0);
INSERT INTO `member_login_record` VALUES (621, 49, '2019-12-05 18:39:16', 1, 1);
INSERT INTO `member_login_record` VALUES (622, 2, '2019-12-05 18:56:00', 2, 0);
INSERT INTO `member_login_record` VALUES (623, 2, '2019-12-05 19:03:17', 2, 0);
INSERT INTO `member_login_record` VALUES (624, 20, '2019-12-05 19:10:22', 2, 0);
INSERT INTO `member_login_record` VALUES (625, 49, '2019-12-05 19:18:15', 1, 1);
INSERT INTO `member_login_record` VALUES (626, 2, '2019-12-05 19:22:16', 2, 0);
INSERT INTO `member_login_record` VALUES (627, 49, '2019-12-05 19:28:07', 1, 4);
INSERT INTO `member_login_record` VALUES (628, 2, '2019-12-05 19:29:01', 2, 0);
INSERT INTO `member_login_record` VALUES (629, 2, '2019-12-05 19:29:07', 2, 0);
INSERT INTO `member_login_record` VALUES (630, 2, '2019-12-05 19:29:13', 2, 0);
INSERT INTO `member_login_record` VALUES (631, 49, '2019-12-05 19:35:05', 1, 3);
INSERT INTO `member_login_record` VALUES (632, 49, '2019-12-05 19:37:39', 1, 4);
INSERT INTO `member_login_record` VALUES (633, 2, '2019-12-06 08:17:41', 2, 0);
INSERT INTO `member_login_record` VALUES (634, 20, '2019-12-06 08:24:39', 2, 0);
INSERT INTO `member_login_record` VALUES (635, 52, '2019-12-06 08:34:31', 1, 1);
INSERT INTO `member_login_record` VALUES (636, 2, '2019-12-06 08:36:26', 2, 0);
INSERT INTO `member_login_record` VALUES (637, 1, '2019-12-06 08:47:59', 1, 1);
INSERT INTO `member_login_record` VALUES (638, 1, '2019-12-06 08:48:29', 1, 1);
INSERT INTO `member_login_record` VALUES (639, 2, '2019-12-06 09:04:45', 2, 0);
INSERT INTO `member_login_record` VALUES (640, 2, '2019-12-06 09:12:06', 2, 0);
INSERT INTO `member_login_record` VALUES (641, 35, '2019-12-06 09:17:36', 2, 0);
INSERT INTO `member_login_record` VALUES (642, 2, '2019-12-06 09:28:40', 2, 0);
INSERT INTO `member_login_record` VALUES (643, 1, '2019-12-06 09:30:40', 1, 4);
INSERT INTO `member_login_record` VALUES (644, 49, '2019-12-06 09:32:11', 1, 4);
INSERT INTO `member_login_record` VALUES (645, 49, '2019-12-06 09:37:24', 1, 4);
INSERT INTO `member_login_record` VALUES (646, 1, '2019-12-06 09:50:28', 1, 1);
INSERT INTO `member_login_record` VALUES (647, 35, '2019-12-06 10:06:35', 1, 1);
INSERT INTO `member_login_record` VALUES (648, 1, '2019-12-06 10:08:02', 1, 4);
INSERT INTO `member_login_record` VALUES (649, 1, '2019-12-06 10:09:22', 1, 3);
INSERT INTO `member_login_record` VALUES (650, 1, '2019-12-06 10:12:04', 1, 3);
INSERT INTO `member_login_record` VALUES (651, 1, '2019-12-06 10:17:16', 1, 1);
INSERT INTO `member_login_record` VALUES (652, 1, '2019-12-06 10:17:16', 1, 3);
INSERT INTO `member_login_record` VALUES (653, 52, '2019-12-06 10:18:34', 1, 1);
INSERT INTO `member_login_record` VALUES (654, 52, '2019-12-06 10:18:40', 1, 1);
INSERT INTO `member_login_record` VALUES (655, 1, '2019-12-06 10:21:15', 1, 3);
INSERT INTO `member_login_record` VALUES (656, 1, '2019-12-06 10:22:06', 1, 1);
INSERT INTO `member_login_record` VALUES (657, 35, '2019-12-06 10:25:18', 1, 4);
INSERT INTO `member_login_record` VALUES (658, 35, '2019-12-06 10:26:04', 1, 4);
INSERT INTO `member_login_record` VALUES (659, 35, '2019-12-06 10:26:28', 1, 4);
INSERT INTO `member_login_record` VALUES (660, 49, '2019-12-06 10:29:01', 1, 1);
INSERT INTO `member_login_record` VALUES (661, 1, '2019-12-06 10:32:49', 1, 4);
INSERT INTO `member_login_record` VALUES (662, 35, '2019-12-06 10:33:15', 1, 4);
INSERT INTO `member_login_record` VALUES (663, 35, '2019-12-06 10:35:06', 1, 3);
INSERT INTO `member_login_record` VALUES (664, 1, '2019-12-06 10:41:15', 1, 1);
INSERT INTO `member_login_record` VALUES (665, 2, '2019-12-06 10:41:55', 2, 0);
INSERT INTO `member_login_record` VALUES (666, 1, '2019-12-06 10:44:05', 1, 1);
INSERT INTO `member_login_record` VALUES (667, 52, '2019-12-06 10:46:20', 1, 1);
INSERT INTO `member_login_record` VALUES (668, 2, '2019-12-06 10:46:54', 2, 0);
INSERT INTO `member_login_record` VALUES (669, 2, '2019-12-06 10:50:12', 2, 0);
INSERT INTO `member_login_record` VALUES (670, 52, '2019-12-06 10:58:50', 1, 3);
INSERT INTO `member_login_record` VALUES (671, 83, '2019-12-06 11:01:43', 1, 1);
INSERT INTO `member_login_record` VALUES (672, 52, '2019-12-06 11:15:42', 1, 3);
INSERT INTO `member_login_record` VALUES (673, 49, '2019-12-06 11:16:27', 1, 4);
INSERT INTO `member_login_record` VALUES (674, 35, '2019-12-06 11:19:56', 2, 0);
INSERT INTO `member_login_record` VALUES (675, 2, '2019-12-06 11:20:35', 2, 0);
INSERT INTO `member_login_record` VALUES (676, 35, '2019-12-06 11:21:54', 2, 0);
INSERT INTO `member_login_record` VALUES (677, 1, '2019-12-06 11:22:47', 1, 1);
INSERT INTO `member_login_record` VALUES (678, 35, '2019-12-06 11:25:15', 2, 0);
INSERT INTO `member_login_record` VALUES (679, 35, '2019-12-06 11:26:21', 2, 0);
INSERT INTO `member_login_record` VALUES (680, 2, '2019-12-06 11:57:09', 2, 0);
INSERT INTO `member_login_record` VALUES (681, 2, '2019-12-06 11:59:02', 2, 0);
INSERT INTO `member_login_record` VALUES (682, 2, '2019-12-06 14:13:55', 2, 0);
INSERT INTO `member_login_record` VALUES (683, 2, '2019-12-06 14:19:49', 2, 0);
INSERT INTO `member_login_record` VALUES (684, 59, '2019-12-06 14:23:31', 1, 1);
INSERT INTO `member_login_record` VALUES (685, 52, '2019-12-06 14:28:05', 1, 4);
INSERT INTO `member_login_record` VALUES (686, 2, '2019-12-06 14:29:23', 2, 0);
INSERT INTO `member_login_record` VALUES (687, 2, '2019-12-06 14:34:06', 2, 0);
INSERT INTO `member_login_record` VALUES (688, 2, '2019-12-06 14:34:53', 2, 0);
INSERT INTO `member_login_record` VALUES (689, 2, '2019-12-06 14:35:42', 2, 0);
INSERT INTO `member_login_record` VALUES (690, 81, '2019-12-06 14:37:02', 1, 3);
INSERT INTO `member_login_record` VALUES (691, 2, '2019-12-06 14:43:35', 2, 0);
INSERT INTO `member_login_record` VALUES (692, 1, '2019-12-06 14:46:57', 1, 4);
INSERT INTO `member_login_record` VALUES (693, 49, '2019-12-06 14:50:28', 1, 4);
INSERT INTO `member_login_record` VALUES (694, 2, '2019-12-06 14:59:55', 2, 0);
INSERT INTO `member_login_record` VALUES (695, 2, '2019-12-06 15:03:22', 2, 0);
INSERT INTO `member_login_record` VALUES (696, 1, '2019-12-06 15:07:15', 1, 1);
INSERT INTO `member_login_record` VALUES (697, 80, '2019-12-06 15:09:33', 1, 1);
INSERT INTO `member_login_record` VALUES (698, 2, '2019-12-06 15:10:15', 2, 0);
INSERT INTO `member_login_record` VALUES (699, 1, '2019-12-06 15:10:19', 1, 1);
INSERT INTO `member_login_record` VALUES (700, 49, '2019-12-06 15:10:55', 1, 1);
INSERT INTO `member_login_record` VALUES (701, 2, '2019-12-06 15:12:03', 2, 0);
INSERT INTO `member_login_record` VALUES (702, 41, '2019-12-06 15:12:04', 1, 1);
INSERT INTO `member_login_record` VALUES (703, 2, '2019-12-06 15:17:25', 2, 0);
INSERT INTO `member_login_record` VALUES (704, 41, '2019-12-06 15:19:25', 1, 4);
INSERT INTO `member_login_record` VALUES (705, 49, '2019-12-06 15:19:45', 1, 4);
INSERT INTO `member_login_record` VALUES (706, 52, '2019-12-06 15:24:47', 1, 1);
INSERT INTO `member_login_record` VALUES (707, 41, '2019-12-06 15:27:26', 1, 4);
INSERT INTO `member_login_record` VALUES (708, 20, '2019-12-06 15:28:22', 2, 0);
INSERT INTO `member_login_record` VALUES (709, 2, '2019-12-06 15:29:16', 2, 0);
INSERT INTO `member_login_record` VALUES (710, 52, '2019-12-06 15:31:43', 1, 3);
INSERT INTO `member_login_record` VALUES (711, 42, '2019-12-06 15:33:29', 2, 0);
INSERT INTO `member_login_record` VALUES (712, 2, '2019-12-06 15:34:09', 2, 0);
INSERT INTO `member_login_record` VALUES (713, 2, '2019-12-06 15:37:35', 2, 0);
INSERT INTO `member_login_record` VALUES (714, 42, '2019-12-06 15:52:04', 2, 0);
INSERT INTO `member_login_record` VALUES (715, 42, '2019-12-06 15:53:14', 2, 0);
INSERT INTO `member_login_record` VALUES (716, 52, '2019-12-06 15:53:16', 1, 3);
INSERT INTO `member_login_record` VALUES (717, 2, '2019-12-06 15:53:26', 2, 0);
INSERT INTO `member_login_record` VALUES (718, 2, '2019-12-06 15:53:40', 2, 0);
INSERT INTO `member_login_record` VALUES (719, 42, '2019-12-06 15:53:58', 2, 0);
INSERT INTO `member_login_record` VALUES (720, 42, '2019-12-06 15:54:29', 2, 0);
INSERT INTO `member_login_record` VALUES (721, 2, '2019-12-06 15:54:50', 2, 0);
INSERT INTO `member_login_record` VALUES (722, 1, '2019-12-06 15:55:59', 1, 4);
INSERT INTO `member_login_record` VALUES (723, 1, '2019-12-06 16:02:52', 1, 1);
INSERT INTO `member_login_record` VALUES (724, 1, '2019-12-06 16:07:59', 1, 1);
INSERT INTO `member_login_record` VALUES (725, 2, '2019-12-06 16:27:28', 2, 0);
INSERT INTO `member_login_record` VALUES (726, 2, '2019-12-06 16:29:05', 2, 0);
INSERT INTO `member_login_record` VALUES (727, 2, '2019-12-06 16:30:45', 2, 0);
INSERT INTO `member_login_record` VALUES (728, 2, '2019-12-06 16:33:10', 2, 0);
INSERT INTO `member_login_record` VALUES (729, 13, '2019-12-06 16:43:17', 2, 0);
INSERT INTO `member_login_record` VALUES (730, 41, '2019-12-06 16:46:21', 1, 4);
INSERT INTO `member_login_record` VALUES (731, 41, '2019-12-06 16:48:59', 1, 3);
INSERT INTO `member_login_record` VALUES (732, 1, '2019-12-06 16:58:36', 1, 4);
INSERT INTO `member_login_record` VALUES (733, 49, '2019-12-06 16:59:18', 1, 4);
INSERT INTO `member_login_record` VALUES (734, 49, '2019-12-06 17:01:06', 1, 4);
INSERT INTO `member_login_record` VALUES (735, 41, '2019-12-06 17:03:30', 1, 4);
INSERT INTO `member_login_record` VALUES (736, 49, '2019-12-06 17:05:45', 1, 3);
INSERT INTO `member_login_record` VALUES (737, 59, '2019-12-06 17:06:16', 1, 1);
INSERT INTO `member_login_record` VALUES (738, 1, '2019-12-06 17:09:09', 1, 1);
INSERT INTO `member_login_record` VALUES (739, 41, '2019-12-06 17:16:51', 1, 3);
INSERT INTO `member_login_record` VALUES (740, 52, '2019-12-06 17:18:02', 1, 4);
INSERT INTO `member_login_record` VALUES (741, 2, '2019-12-06 17:19:08', 2, 0);
INSERT INTO `member_login_record` VALUES (742, 1, '2019-12-06 17:20:32', 1, 4);
INSERT INTO `member_login_record` VALUES (743, 52, '2019-12-06 17:23:05', 1, 4);
INSERT INTO `member_login_record` VALUES (744, 52, '2019-12-06 17:23:39', 1, 4);
INSERT INTO `member_login_record` VALUES (745, 1, '2019-12-06 17:25:42', 1, 1);
INSERT INTO `member_login_record` VALUES (746, 52, '2019-12-06 17:26:45', 1, 1);
INSERT INTO `member_login_record` VALUES (747, 52, '2019-12-06 17:26:50', 1, 1);
INSERT INTO `member_login_record` VALUES (748, 1, '2019-12-06 17:26:58', 1, 4);
INSERT INTO `member_login_record` VALUES (749, 1, '2019-12-06 17:28:29', 1, 4);
INSERT INTO `member_login_record` VALUES (750, 2, '2019-12-06 17:29:54', 2, 0);
INSERT INTO `member_login_record` VALUES (751, 49, '2019-12-06 17:30:48', 1, 4);
INSERT INTO `member_login_record` VALUES (752, 49, '2019-12-06 17:56:54', 1, 3);
INSERT INTO `member_login_record` VALUES (753, 91, '2019-12-06 18:03:05', 1, 1);
INSERT INTO `member_login_record` VALUES (754, 52, '2019-12-06 18:13:47', 1, 1);
INSERT INTO `member_login_record` VALUES (755, 1, '2019-12-06 18:18:17', 1, 1);
INSERT INTO `member_login_record` VALUES (756, 41, '2019-12-06 18:20:30', 1, 3);
INSERT INTO `member_login_record` VALUES (757, 1, '2019-12-06 18:30:09', 1, 3);
INSERT INTO `member_login_record` VALUES (758, 1, '2019-12-06 18:34:31', 1, 4);
INSERT INTO `member_login_record` VALUES (759, 2, '2019-12-07 10:01:44', 2, 0);
INSERT INTO `member_login_record` VALUES (760, 1, '2019-12-07 10:18:59', 1, 3);
INSERT INTO `member_login_record` VALUES (761, 2, '2019-12-07 10:21:04', 2, 0);
INSERT INTO `member_login_record` VALUES (762, 1, '2019-12-07 10:22:27', 1, 1);
INSERT INTO `member_login_record` VALUES (763, 2, '2019-12-07 10:24:36', 2, 0);
INSERT INTO `member_login_record` VALUES (764, 2, '2019-12-07 10:27:05', 2, 0);
INSERT INTO `member_login_record` VALUES (765, 59, '2019-12-07 10:38:03', 1, 1);
INSERT INTO `member_login_record` VALUES (766, 2, '2019-12-07 10:44:41', 2, 0);
INSERT INTO `member_login_record` VALUES (767, 2, '2019-12-07 10:54:42', 2, 0);
INSERT INTO `member_login_record` VALUES (768, 2, '2019-12-07 10:56:06', 2, 0);
INSERT INTO `member_login_record` VALUES (769, 91, '2019-12-07 10:59:00', 1, 1);
INSERT INTO `member_login_record` VALUES (770, 2, '2019-12-07 10:59:26', 2, 0);
INSERT INTO `member_login_record` VALUES (771, 2, '2019-12-07 11:00:29', 2, 0);
INSERT INTO `member_login_record` VALUES (772, 2, '2019-12-07 11:03:54', 2, 0);
INSERT INTO `member_login_record` VALUES (773, 2, '2019-12-07 11:05:25', 2, 0);
INSERT INTO `member_login_record` VALUES (774, 2, '2019-12-07 11:11:47', 2, 0);
INSERT INTO `member_login_record` VALUES (775, 71, '2019-12-07 11:14:17', 1, 1);
INSERT INTO `member_login_record` VALUES (776, 71, '2019-12-07 11:20:12', 1, 1);
INSERT INTO `member_login_record` VALUES (777, 2, '2019-12-07 11:20:14', 2, 0);
INSERT INTO `member_login_record` VALUES (778, 92, '2019-12-07 11:23:00', 1, 1);
INSERT INTO `member_login_record` VALUES (779, 35, '2019-12-07 11:42:00', 1, 1);
INSERT INTO `member_login_record` VALUES (780, 95, '2019-12-07 12:07:20', 1, 1);
INSERT INTO `member_login_record` VALUES (781, 2, '2019-12-07 13:16:17', 2, 0);
INSERT INTO `member_login_record` VALUES (782, 13, '2019-12-07 14:11:46', 2, 0);
INSERT INTO `member_login_record` VALUES (783, 52, '2019-12-07 14:15:31', 1, 1);
INSERT INTO `member_login_record` VALUES (784, 1, '2019-12-07 14:16:54', 1, 1);
INSERT INTO `member_login_record` VALUES (785, 95, '2019-12-07 14:17:42', 1, 1);
INSERT INTO `member_login_record` VALUES (786, 2, '2019-12-07 14:20:25', 2, 0);
INSERT INTO `member_login_record` VALUES (787, 83, '2019-12-07 14:21:38', 1, 1);
INSERT INTO `member_login_record` VALUES (788, 95, '2019-12-07 14:21:08', 1, 1);
INSERT INTO `member_login_record` VALUES (789, 83, '2019-12-07 14:26:00', 1, 1);
INSERT INTO `member_login_record` VALUES (790, 2, '2019-12-07 14:31:05', 2, 0);
INSERT INTO `member_login_record` VALUES (791, 1, '2019-12-07 14:32:31', 1, 4);
INSERT INTO `member_login_record` VALUES (792, 49, '2019-12-07 14:34:41', 1, 4);
INSERT INTO `member_login_record` VALUES (793, 95, '2019-12-07 14:38:37', 1, 1);
INSERT INTO `member_login_record` VALUES (794, 2, '2019-12-07 14:39:54', 2, 0);
INSERT INTO `member_login_record` VALUES (795, 2, '2019-12-07 14:42:04', 2, 0);
INSERT INTO `member_login_record` VALUES (796, 85, '2019-12-07 14:48:02', 1, 1);
INSERT INTO `member_login_record` VALUES (797, 35, '2019-12-07 14:48:56', 1, 1);
INSERT INTO `member_login_record` VALUES (798, 85, '2019-12-07 14:55:10', 1, 1);
INSERT INTO `member_login_record` VALUES (799, 52, '2019-12-07 15:06:28', 1, 1);
INSERT INTO `member_login_record` VALUES (800, 98, '2019-12-07 15:07:08', 1, 1);
INSERT INTO `member_login_record` VALUES (801, 99, '2019-12-07 15:09:32', 1, 1);
INSERT INTO `member_login_record` VALUES (802, 71, '2019-12-07 15:11:39', 1, 1);
INSERT INTO `member_login_record` VALUES (803, 71, '2019-12-07 15:12:19', 1, 1);
INSERT INTO `member_login_record` VALUES (804, 1, '2019-12-07 15:20:36', 1, 4);
INSERT INTO `member_login_record` VALUES (805, 49, '2019-12-07 15:21:32', 1, 3);
INSERT INTO `member_login_record` VALUES (806, 13, '2019-12-07 15:22:36', 2, 0);
INSERT INTO `member_login_record` VALUES (807, 49, '2019-12-07 15:25:34', 1, 4);
INSERT INTO `member_login_record` VALUES (808, 2, '2019-12-07 15:42:26', 2, 0);
INSERT INTO `member_login_record` VALUES (809, 2, '2019-12-07 15:44:18', 2, 0);
INSERT INTO `member_login_record` VALUES (810, 52, '2019-12-07 15:48:54', 1, 4);
INSERT INTO `member_login_record` VALUES (811, 71, '2019-12-07 15:49:44', 1, 1);
INSERT INTO `member_login_record` VALUES (812, 2, '2019-12-07 15:54:45', 2, 0);
INSERT INTO `member_login_record` VALUES (813, 2, '2019-12-07 15:55:50', 2, 0);
INSERT INTO `member_login_record` VALUES (814, 98, '2019-12-07 16:00:56', 1, 1);
INSERT INTO `member_login_record` VALUES (815, 1, '2019-12-07 16:09:21', 1, 1);
INSERT INTO `member_login_record` VALUES (816, 35, '2019-12-07 16:11:03', 1, 3);
INSERT INTO `member_login_record` VALUES (817, 2, '2019-12-07 16:15:13', 2, 0);
INSERT INTO `member_login_record` VALUES (818, 1, '2019-12-07 16:28:11', 1, 4);
INSERT INTO `member_login_record` VALUES (819, 41, '2019-12-07 16:32:28', 1, 3);
INSERT INTO `member_login_record` VALUES (820, 1, '2019-12-07 16:32:33', 1, 1);
INSERT INTO `member_login_record` VALUES (821, 1, '2019-12-07 16:33:26', 1, 1);
INSERT INTO `member_login_record` VALUES (822, 41, '2019-12-07 16:36:45', 1, 3);
INSERT INTO `member_login_record` VALUES (823, 59, '2019-12-07 16:48:30', 1, 1);
INSERT INTO `member_login_record` VALUES (824, 40, '2019-12-07 16:50:02', 1, 1);
INSERT INTO `member_login_record` VALUES (825, 2, '2019-12-07 16:54:54', 2, 0);
INSERT INTO `member_login_record` VALUES (826, 1, '2019-12-07 16:57:35', 1, 4);
INSERT INTO `member_login_record` VALUES (827, 13, '2019-12-07 17:03:51', 2, 0);
INSERT INTO `member_login_record` VALUES (828, 13, '2019-12-07 17:05:52', 2, 0);
INSERT INTO `member_login_record` VALUES (829, 1, '2019-12-07 17:06:01', 1, 1);
INSERT INTO `member_login_record` VALUES (830, 29, '2019-12-07 17:11:08', 2, 0);
INSERT INTO `member_login_record` VALUES (831, 71, '2019-12-07 17:12:44', 1, 3);
INSERT INTO `member_login_record` VALUES (832, 99, '2019-12-07 17:19:42', 1, 3);
INSERT INTO `member_login_record` VALUES (833, 2, '2019-12-07 17:32:57', 2, 0);
INSERT INTO `member_login_record` VALUES (834, 80, '2019-12-07 17:36:03', 1, 4);
INSERT INTO `member_login_record` VALUES (835, 45, '2019-12-07 17:37:01', 2, 0);
INSERT INTO `member_login_record` VALUES (836, 2, '2019-12-07 18:00:10', 2, 0);
INSERT INTO `member_login_record` VALUES (837, 1, '2019-12-07 18:17:07', 1, 1);
INSERT INTO `member_login_record` VALUES (838, 40, '2019-12-07 18:19:30', 1, 1);
INSERT INTO `member_login_record` VALUES (839, 100, '2019-12-07 18:20:20', 1, 4);
INSERT INTO `member_login_record` VALUES (840, 2, '2019-12-09 08:24:08', 2, 0);
INSERT INTO `member_login_record` VALUES (841, 2, '2019-12-09 08:26:55', 2, 0);
INSERT INTO `member_login_record` VALUES (842, 2, '2019-12-09 08:40:26', 2, 0);
INSERT INTO `member_login_record` VALUES (843, 2, '2019-12-09 08:48:34', 2, 0);
INSERT INTO `member_login_record` VALUES (844, 2, '2019-12-09 08:56:25', 2, 0);
INSERT INTO `member_login_record` VALUES (845, 2, '2019-12-09 09:02:53', 2, 0);
INSERT INTO `member_login_record` VALUES (846, 1, '2019-12-09 09:03:29', 1, 1);
INSERT INTO `member_login_record` VALUES (847, 83, '2019-12-09 09:04:06', 1, 1);
INSERT INTO `member_login_record` VALUES (848, 2, '2019-12-09 09:05:47', 2, 0);
INSERT INTO `member_login_record` VALUES (849, 2, '2019-12-09 09:06:43', 2, 0);
INSERT INTO `member_login_record` VALUES (850, 2, '2019-12-09 09:07:08', 2, 0);
INSERT INTO `member_login_record` VALUES (851, 101, '2019-12-09 09:08:02', 1, 1);
INSERT INTO `member_login_record` VALUES (852, 71, '2019-12-09 09:11:54', 1, 1);
INSERT INTO `member_login_record` VALUES (853, 2, '2019-12-09 09:30:04', 2, 0);
INSERT INTO `member_login_record` VALUES (854, 2, '2019-12-09 09:29:36', 2, 0);
INSERT INTO `member_login_record` VALUES (855, 83, '2019-12-09 09:29:38', 1, 1);
INSERT INTO `member_login_record` VALUES (856, 91, '2019-12-09 09:31:29', 1, 1);
INSERT INTO `member_login_record` VALUES (857, 2, '2019-12-09 09:33:27', 2, 0);
INSERT INTO `member_login_record` VALUES (858, 2, '2019-12-09 09:38:47', 2, 0);
INSERT INTO `member_login_record` VALUES (859, 1, '2019-12-09 09:39:46', 1, 4);
INSERT INTO `member_login_record` VALUES (860, 91, '2019-12-09 09:40:24', 1, 4);
INSERT INTO `member_login_record` VALUES (861, 80, '2019-12-09 09:41:47', 1, 1);
INSERT INTO `member_login_record` VALUES (862, 80, '2019-12-09 09:41:47', 1, 1);
INSERT INTO `member_login_record` VALUES (863, 2, '2019-12-09 09:45:34', 2, 0);
INSERT INTO `member_login_record` VALUES (864, 1, '2019-12-09 09:46:43', 1, 3);
INSERT INTO `member_login_record` VALUES (865, 1, '2019-12-09 09:47:34', 1, 3);
INSERT INTO `member_login_record` VALUES (866, 52, '2019-12-09 09:50:11', 1, 1);
INSERT INTO `member_login_record` VALUES (867, 1, '2019-12-09 09:53:22', 1, 1);
INSERT INTO `member_login_record` VALUES (868, 2, '2019-12-09 09:58:54', 2, 0);
INSERT INTO `member_login_record` VALUES (869, 52, '2019-12-09 10:01:34', 1, 1);
INSERT INTO `member_login_record` VALUES (870, 1, '2019-12-09 10:07:30', 1, 4);
INSERT INTO `member_login_record` VALUES (871, 1, '2019-12-09 10:11:17', 1, 3);
INSERT INTO `member_login_record` VALUES (872, 2, '2019-12-09 10:19:37', 2, 0);
INSERT INTO `member_login_record` VALUES (873, 2, '2019-12-09 10:23:24', 2, 0);
INSERT INTO `member_login_record` VALUES (874, 2, '2019-12-09 10:39:10', 2, 0);
INSERT INTO `member_login_record` VALUES (875, 2, '2019-12-09 10:40:52', 2, 0);
INSERT INTO `member_login_record` VALUES (876, 2, '2019-12-09 10:50:00', 2, 0);
INSERT INTO `member_login_record` VALUES (877, 2, '2019-12-09 10:50:03', 2, 0);
INSERT INTO `member_login_record` VALUES (878, 102, '2019-12-09 11:07:17', 1, 1);
INSERT INTO `member_login_record` VALUES (879, 83, '2019-12-09 11:11:23', 1, 1);
INSERT INTO `member_login_record` VALUES (880, 13, '2019-12-09 11:15:48', 2, 0);
INSERT INTO `member_login_record` VALUES (881, 2, '2019-12-09 11:21:33', 2, 0);
INSERT INTO `member_login_record` VALUES (882, 91, '2019-12-09 11:37:23', 1, 4);
INSERT INTO `member_login_record` VALUES (883, 2, '2019-12-09 11:44:55', 2, 0);
INSERT INTO `member_login_record` VALUES (884, 2, '2019-12-09 11:48:48', 2, 0);
INSERT INTO `member_login_record` VALUES (885, 2, '2019-12-09 11:49:33', 2, 0);
INSERT INTO `member_login_record` VALUES (886, 2, '2019-12-09 11:51:02', 2, 0);
INSERT INTO `member_login_record` VALUES (887, 13, '2019-12-09 11:52:42', 2, 0);
INSERT INTO `member_login_record` VALUES (888, 2, '2019-12-09 11:51:52', 2, 0);
INSERT INTO `member_login_record` VALUES (889, 13, '2019-12-09 11:54:45', 2, 0);
INSERT INTO `member_login_record` VALUES (890, 2, '2019-12-09 13:03:55', 2, 0);
INSERT INTO `member_login_record` VALUES (891, 2, '2019-12-09 14:07:59', 2, 0);
INSERT INTO `member_login_record` VALUES (892, 71, '2019-12-09 14:20:59', 1, 1);
INSERT INTO `member_login_record` VALUES (893, 20, '2019-12-09 14:25:41', 2, 0);
INSERT INTO `member_login_record` VALUES (894, 2, '2019-12-09 14:40:14', 2, 0);
INSERT INTO `member_login_record` VALUES (895, 2, '2019-12-09 14:47:19', 2, 0);
INSERT INTO `member_login_record` VALUES (896, 83, '2019-12-09 14:49:50', 1, 1);
INSERT INTO `member_login_record` VALUES (897, 1, '2019-12-09 15:06:28', 1, 1);
INSERT INTO `member_login_record` VALUES (898, 2, '2019-12-09 15:10:44', 2, 0);
INSERT INTO `member_login_record` VALUES (899, 1, '2019-12-09 15:15:05', 1, 1);
INSERT INTO `member_login_record` VALUES (900, 1, '2019-12-09 15:15:14', 1, 1);
INSERT INTO `member_login_record` VALUES (901, 1, '2019-12-09 15:15:16', 1, 1);
INSERT INTO `member_login_record` VALUES (902, 1, '2019-12-09 15:15:17', 1, 1);
INSERT INTO `member_login_record` VALUES (903, 1, '2019-12-09 15:15:17', 1, 1);
INSERT INTO `member_login_record` VALUES (904, 1, '2019-12-09 15:15:18', 1, 1);
INSERT INTO `member_login_record` VALUES (905, 1, '2019-12-09 15:15:19', 1, 1);
INSERT INTO `member_login_record` VALUES (906, 1, '2019-12-09 15:15:19', 1, 1);
INSERT INTO `member_login_record` VALUES (907, 1, '2019-12-09 15:15:19', 1, 1);
INSERT INTO `member_login_record` VALUES (908, 1, '2019-12-09 15:15:19', 1, 1);
INSERT INTO `member_login_record` VALUES (909, 1, '2019-12-09 15:15:19', 1, 1);
INSERT INTO `member_login_record` VALUES (910, 1, '2019-12-09 15:15:20', 1, 1);
INSERT INTO `member_login_record` VALUES (911, 1, '2019-12-09 15:15:20', 1, 1);
INSERT INTO `member_login_record` VALUES (912, 1, '2019-12-09 15:15:20', 1, 1);
INSERT INTO `member_login_record` VALUES (913, 1, '2019-12-09 15:15:21', 1, 1);
INSERT INTO `member_login_record` VALUES (914, 1, '2019-12-09 15:15:23', 1, 1);
INSERT INTO `member_login_record` VALUES (915, 2, '2019-12-09 15:25:54', 2, 0);
INSERT INTO `member_login_record` VALUES (916, 32, '2019-12-09 15:27:54', 2, 0);
INSERT INTO `member_login_record` VALUES (917, 2, '2019-12-09 15:30:39', 2, 0);
INSERT INTO `member_login_record` VALUES (918, 106, '2019-12-09 15:39:31', 1, 1);
INSERT INTO `member_login_record` VALUES (919, 2, '2019-12-09 15:43:30', 2, 0);
INSERT INTO `member_login_record` VALUES (920, 99, '2019-12-09 16:05:32', 1, 1);
INSERT INTO `member_login_record` VALUES (921, 101, '2019-12-09 16:07:45', 1, 1);
INSERT INTO `member_login_record` VALUES (922, 2, '2019-12-09 16:08:45', 2, 0);
INSERT INTO `member_login_record` VALUES (923, 2, '2019-12-09 16:17:00', 2, 0);
INSERT INTO `member_login_record` VALUES (924, 2, '2019-12-09 16:17:56', 2, 0);
INSERT INTO `member_login_record` VALUES (925, 102, '2019-12-09 16:25:33', 1, 1);
INSERT INTO `member_login_record` VALUES (926, 83, '2019-12-09 16:30:20', 1, 1);
INSERT INTO `member_login_record` VALUES (927, 108, '2019-12-09 16:31:59', 1, 1);
INSERT INTO `member_login_record` VALUES (928, 102, '2019-12-09 16:36:05', 1, 1);
INSERT INTO `member_login_record` VALUES (929, 108, '2019-12-09 16:43:03', 1, 3);
INSERT INTO `member_login_record` VALUES (930, 1, '2019-12-09 16:54:53', 1, 1);
INSERT INTO `member_login_record` VALUES (931, 2, '2019-12-09 17:03:10', 2, 0);
INSERT INTO `member_login_record` VALUES (932, 52, '2019-12-09 17:05:21', 1, 1);
INSERT INTO `member_login_record` VALUES (933, 2, '2019-12-09 17:26:51', 2, 0);
INSERT INTO `member_login_record` VALUES (934, 2, '2019-12-09 17:31:31', 2, 0);
INSERT INTO `member_login_record` VALUES (935, 2, '2019-12-09 17:51:37', 2, 0);
INSERT INTO `member_login_record` VALUES (936, 2, '2019-12-09 18:42:59', 2, 0);
INSERT INTO `member_login_record` VALUES (937, 1, '2019-12-09 18:56:50', 1, 4);
INSERT INTO `member_login_record` VALUES (938, 1, '2019-12-09 18:57:54', 1, 4);
INSERT INTO `member_login_record` VALUES (939, 1, '2019-12-09 18:59:38', 1, 1);
INSERT INTO `member_login_record` VALUES (940, 41, '2019-12-09 19:00:07', 1, 1);
INSERT INTO `member_login_record` VALUES (941, 102, '2019-12-09 19:05:26', 1, 1);
INSERT INTO `member_login_record` VALUES (942, 102, '2019-12-09 19:07:18', 1, 1);
INSERT INTO `member_login_record` VALUES (943, 1, '2019-12-09 19:37:53', 1, 1);
INSERT INTO `member_login_record` VALUES (944, 52, '2019-12-09 19:38:47', 1, 1);
INSERT INTO `member_login_record` VALUES (945, 52, '2019-12-09 19:39:50', 1, 1);
INSERT INTO `member_login_record` VALUES (946, 59, '2019-12-09 19:48:36', 1, 1);
INSERT INTO `member_login_record` VALUES (947, 1, '2019-12-09 20:00:20', 1, 1);
INSERT INTO `member_login_record` VALUES (948, 2, '2019-12-09 20:02:54', 2, 0);
INSERT INTO `member_login_record` VALUES (949, 52, '2019-12-09 20:04:21', 1, 1);
INSERT INTO `member_login_record` VALUES (950, 101, '2019-12-09 20:05:19', 1, 1);
INSERT INTO `member_login_record` VALUES (951, 102, '2019-12-09 20:14:40', 1, 1);
INSERT INTO `member_login_record` VALUES (952, 1, '2019-12-09 20:21:53', 1, 1);
INSERT INTO `member_login_record` VALUES (953, 52, '2019-12-10 08:14:01', 1, 1);
INSERT INTO `member_login_record` VALUES (954, 2, '2019-12-10 08:23:37', 2, 0);
INSERT INTO `member_login_record` VALUES (955, 2, '2019-12-10 08:33:06', 2, 0);
INSERT INTO `member_login_record` VALUES (956, 2, '2019-12-10 08:35:14', 2, 0);
INSERT INTO `member_login_record` VALUES (957, 52, '2019-12-10 08:36:52', 1, 1);
INSERT INTO `member_login_record` VALUES (958, 52, '2019-12-10 08:52:32', 1, 1);
INSERT INTO `member_login_record` VALUES (959, 41, '2019-12-10 08:52:13', 1, 1);
INSERT INTO `member_login_record` VALUES (960, 2, '2019-12-10 08:53:19', 2, 0);
INSERT INTO `member_login_record` VALUES (961, 2, '2019-12-10 09:21:42', 2, 0);
INSERT INTO `member_login_record` VALUES (962, 71, '2019-12-10 09:26:01', 1, 1);
INSERT INTO `member_login_record` VALUES (963, 2, '2019-12-10 09:28:26', 2, 0);
INSERT INTO `member_login_record` VALUES (964, 71, '2019-12-10 09:31:30', 1, 1);
INSERT INTO `member_login_record` VALUES (965, 2, '2019-12-10 09:36:48', 2, 0);
INSERT INTO `member_login_record` VALUES (966, 91, '2019-12-10 09:44:05', 1, 4);
INSERT INTO `member_login_record` VALUES (967, 2, '2019-12-10 09:45:25', 2, 0);
INSERT INTO `member_login_record` VALUES (968, 80, '2019-12-10 09:47:07', 1, 1);
INSERT INTO `member_login_record` VALUES (969, 80, '2019-12-10 09:47:07', 1, 1);
INSERT INTO `member_login_record` VALUES (970, 2, '2019-12-10 09:47:24', 2, 0);
INSERT INTO `member_login_record` VALUES (971, 2, '2019-12-10 09:47:58', 2, 0);
INSERT INTO `member_login_record` VALUES (972, 1, '2019-12-10 09:48:12', 1, 1);
INSERT INTO `member_login_record` VALUES (973, 2, '2019-12-10 10:02:29', 2, 0);
INSERT INTO `member_login_record` VALUES (974, 1, '2019-12-10 10:26:29', 1, 4);
INSERT INTO `member_login_record` VALUES (975, 2, '2019-12-10 10:30:04', 2, 0);
INSERT INTO `member_login_record` VALUES (976, 94, '2019-12-10 10:31:08', 1, 4);
INSERT INTO `member_login_record` VALUES (977, 2, '2019-12-10 10:32:36', 2, 0);
INSERT INTO `member_login_record` VALUES (978, 52, '2019-12-10 10:32:41', 1, 4);
INSERT INTO `member_login_record` VALUES (979, 94, '2019-12-10 10:42:21', 1, 1);
INSERT INTO `member_login_record` VALUES (980, 52, '2019-12-10 10:42:40', 1, 4);
INSERT INTO `member_login_record` VALUES (981, 2, '2019-12-10 10:43:34', 2, 0);
INSERT INTO `member_login_record` VALUES (982, 2, '2019-12-10 10:52:08', 2, 0);
INSERT INTO `member_login_record` VALUES (983, 2, '2019-12-10 10:56:14', 2, 0);
INSERT INTO `member_login_record` VALUES (984, 2, '2019-12-10 11:02:24', 2, 0);
INSERT INTO `member_login_record` VALUES (985, 2, '2019-12-10 11:03:44', 2, 0);
INSERT INTO `member_login_record` VALUES (986, 2, '2019-12-10 11:04:41', 2, 0);
INSERT INTO `member_login_record` VALUES (987, 2, '2019-12-10 11:09:09', 2, 0);
INSERT INTO `member_login_record` VALUES (988, 41, '2019-12-10 11:27:36', 1, 4);
INSERT INTO `member_login_record` VALUES (989, 102, '2019-12-10 11:32:56', 1, 1);
INSERT INTO `member_login_record` VALUES (990, 1, '2019-12-10 11:40:18', 1, 1);
INSERT INTO `member_login_record` VALUES (991, 102, '2019-12-10 11:42:56', 1, 1);
INSERT INTO `member_login_record` VALUES (992, 102, '2019-12-10 11:43:30', 1, 1);
INSERT INTO `member_login_record` VALUES (993, 1, '2019-12-10 11:55:25', 1, 4);
INSERT INTO `member_login_record` VALUES (994, 42, '2019-12-10 14:02:03', 2, 0);
INSERT INTO `member_login_record` VALUES (995, 2, '2019-12-10 14:04:21', 2, 0);
INSERT INTO `member_login_record` VALUES (996, 94, '2019-12-10 14:04:46', 1, 1);
INSERT INTO `member_login_record` VALUES (997, 2, '2019-12-10 14:05:04', 2, 0);
INSERT INTO `member_login_record` VALUES (998, 42, '2019-12-10 14:05:28', 2, 0);
INSERT INTO `member_login_record` VALUES (999, 2, '2019-12-10 14:06:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1000, 82, '2019-12-10 14:08:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1001, 52, '2019-12-10 14:08:37', 1, 1);
INSERT INTO `member_login_record` VALUES (1002, 2, '2019-12-10 14:08:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1003, 52, '2019-12-10 14:09:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1004, 2, '2019-12-10 14:12:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1005, 34, '2019-12-10 14:13:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1006, 34, '2019-12-10 14:18:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1007, 2, '2019-12-10 14:19:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1008, 34, '2019-12-10 14:22:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1009, 2, '2019-12-10 14:23:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1010, 2, '2019-12-10 14:25:28', 2, 0);
INSERT INTO `member_login_record` VALUES (1011, 34, '2019-12-10 14:26:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1012, 2, '2019-12-10 14:34:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1013, 34, '2019-12-10 14:39:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1014, 2, '2019-12-10 14:44:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1015, 2, '2019-12-10 14:44:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1016, 2, '2019-12-10 14:45:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1017, 34, '2019-12-10 14:54:35', 2, 0);
INSERT INTO `member_login_record` VALUES (1018, 2, '2019-12-10 14:55:25', 2, 0);
INSERT INTO `member_login_record` VALUES (1019, 2, '2019-12-10 14:58:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1020, 34, '2019-12-10 15:01:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1021, 2, '2019-12-10 15:02:27', 2, 0);
INSERT INTO `member_login_record` VALUES (1022, 2, '2019-12-10 15:03:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1023, 2, '2019-12-10 15:05:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1024, 33, '2019-12-10 15:05:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1025, 34, '2019-12-10 15:11:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1026, 2, '2019-12-10 15:12:01', 2, 0);
INSERT INTO `member_login_record` VALUES (1027, 33, '2019-12-10 15:13:48', 2, 0);
INSERT INTO `member_login_record` VALUES (1028, 13, '2019-12-10 15:17:01', 2, 0);
INSERT INTO `member_login_record` VALUES (1029, 34, '2019-12-10 15:17:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1030, 2, '2019-12-10 15:18:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1031, 2, '2019-12-10 15:20:43', 2, 0);
INSERT INTO `member_login_record` VALUES (1032, 2, '2019-12-10 15:22:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1033, 1, '2019-12-10 15:22:42', 1, 4);
INSERT INTO `member_login_record` VALUES (1034, 2, '2019-12-10 15:41:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1035, 99, '2019-12-10 15:55:18', 1, 3);
INSERT INTO `member_login_record` VALUES (1036, 1, '2019-12-10 16:00:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1037, 91, '2019-12-10 16:11:19', 1, 1);
INSERT INTO `member_login_record` VALUES (1038, 20, '2019-12-10 16:11:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1039, 111, '2019-12-10 16:18:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1040, 2, '2019-12-10 16:19:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1041, 1, '2019-12-10 16:22:26', 1, 1);
INSERT INTO `member_login_record` VALUES (1042, 2, '2019-12-10 16:25:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1043, 71, '2019-12-10 16:31:56', 1, 1);
INSERT INTO `member_login_record` VALUES (1044, 42, '2019-12-10 16:36:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1045, 2, '2019-12-10 16:37:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1046, 42, '2019-12-10 16:47:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1047, 42, '2019-12-10 16:49:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1048, 42, '2019-12-10 16:51:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1049, 42, '2019-12-10 16:58:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1050, 42, '2019-12-10 16:59:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1051, 42, '2019-12-10 17:00:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1052, 112, '2019-12-10 17:19:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1053, 2, '2019-12-10 17:27:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1054, 2, '2019-12-10 17:29:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1055, 2, '2019-12-10 17:51:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1056, 91, '2019-12-10 17:52:01', 1, 4);
INSERT INTO `member_login_record` VALUES (1057, 80, '2019-12-10 18:01:17', 1, 4);
INSERT INTO `member_login_record` VALUES (1058, 2, '2019-12-10 18:28:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1059, 2, '2019-12-10 18:28:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1060, 2, '2019-12-10 18:38:25', 2, 0);
INSERT INTO `member_login_record` VALUES (1061, 52, '2019-12-10 18:44:29', 1, 4);
INSERT INTO `member_login_record` VALUES (1062, 52, '2019-12-10 18:44:35', 1, 4);
INSERT INTO `member_login_record` VALUES (1063, 1, '2019-12-10 18:56:14', 1, 4);
INSERT INTO `member_login_record` VALUES (1064, 1, '2019-12-10 19:25:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1065, 2, '2019-12-10 19:41:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1066, 1, '2019-12-10 19:41:40', 1, 4);
INSERT INTO `member_login_record` VALUES (1067, 1, '2019-12-10 19:53:09', 1, 4);
INSERT INTO `member_login_record` VALUES (1068, 1, '2019-12-10 19:53:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1069, 52, '2019-12-11 08:31:55', 1, 1);
INSERT INTO `member_login_record` VALUES (1070, 1, '2019-12-11 08:32:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1071, 94, '2019-12-11 08:33:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1072, 1, '2019-12-11 08:34:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1073, 1, '2019-12-11 08:34:31', 1, 1);
INSERT INTO `member_login_record` VALUES (1074, 1, '2019-12-11 08:36:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1075, 2, '2019-12-11 08:41:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1076, 1, '2019-12-11 08:44:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1077, 2, '2019-12-11 08:48:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1078, 2, '2019-12-11 08:48:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1079, 1, '2019-12-11 08:50:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1080, 1, '2019-12-11 08:50:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1081, 2, '2019-12-11 09:01:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1082, 112, '2019-12-11 09:02:35', 1, 1);
INSERT INTO `member_login_record` VALUES (1083, 2, '2019-12-11 09:05:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1084, 2, '2019-12-11 09:07:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1085, 71, '2019-12-11 09:11:54', 1, 1);
INSERT INTO `member_login_record` VALUES (1086, 102, '2019-12-11 09:12:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1087, 1, '2019-12-11 09:13:50', 1, 1);
INSERT INTO `member_login_record` VALUES (1088, 1, '2019-12-11 09:14:35', 1, 1);
INSERT INTO `member_login_record` VALUES (1089, 2, '2019-12-11 09:17:28', 2, 0);
INSERT INTO `member_login_record` VALUES (1090, 1, '2019-12-11 09:20:28', 1, 1);
INSERT INTO `member_login_record` VALUES (1091, 1, '2019-12-11 09:22:37', 1, 4);
INSERT INTO `member_login_record` VALUES (1092, 1, '2019-12-11 09:24:11', 1, 4);
INSERT INTO `member_login_record` VALUES (1093, 80, '2019-12-11 09:30:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1094, 2, '2019-12-11 09:32:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1095, 1, '2019-12-11 09:41:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1096, 2, '2019-12-11 09:42:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1097, 1, '2019-12-11 09:43:21', 1, 4);
INSERT INTO `member_login_record` VALUES (1098, 2, '2019-12-11 09:44:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1099, 91, '2019-12-11 09:46:06', 1, 4);
INSERT INTO `member_login_record` VALUES (1100, 1, '2019-12-11 09:50:13', 1, 1);
INSERT INTO `member_login_record` VALUES (1101, 100, '2019-12-11 09:54:47', 1, 4);
INSERT INTO `member_login_record` VALUES (1102, 2, '2019-12-11 09:54:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1103, 100, '2019-12-11 09:57:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1104, 2, '2019-12-11 09:57:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1105, 2, '2019-12-11 09:58:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1106, 2, '2019-12-11 09:58:24', 2, 0);
INSERT INTO `member_login_record` VALUES (1107, 2, '2019-12-11 10:02:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1108, 41, '2019-12-11 10:03:25', 1, 1);
INSERT INTO `member_login_record` VALUES (1109, 2, '2019-12-11 10:07:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1110, 1, '2019-12-11 10:11:11', 1, 1);
INSERT INTO `member_login_record` VALUES (1111, 13, '2019-12-11 10:11:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1112, 1, '2019-12-11 10:12:39', 1, 1);
INSERT INTO `member_login_record` VALUES (1113, 2, '2019-12-11 10:16:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1114, 1, '2019-12-11 10:22:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1115, 2, '2019-12-11 10:29:55', 2, 0);
INSERT INTO `member_login_record` VALUES (1116, 1, '2019-12-11 10:55:08', 1, 3);
INSERT INTO `member_login_record` VALUES (1117, 100, '2019-12-11 11:01:30', 1, 4);
INSERT INTO `member_login_record` VALUES (1118, 2, '2019-12-11 11:05:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1119, 91, '2019-12-11 11:28:51', 1, 4);
INSERT INTO `member_login_record` VALUES (1120, 91, '2019-12-11 11:35:37', 1, 1);
INSERT INTO `member_login_record` VALUES (1121, 2, '2019-12-11 11:43:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1122, 102, '2019-12-11 11:51:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1123, 102, '2019-12-11 11:51:41', 1, 1);
INSERT INTO `member_login_record` VALUES (1124, 2, '2019-12-11 14:09:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1125, 2, '2019-12-11 14:10:04', 2, 0);
INSERT INTO `member_login_record` VALUES (1126, 1, '2019-12-11 14:14:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1127, 59, '2019-12-11 14:21:26', 1, 1);
INSERT INTO `member_login_record` VALUES (1128, 1, '2019-12-11 14:25:06', 1, 1);
INSERT INTO `member_login_record` VALUES (1129, 2, '2019-12-11 14:25:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1130, 2, '2019-12-11 14:26:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1131, 2, '2019-12-11 14:29:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1132, 2, '2019-12-11 14:31:03', 2, 0);
INSERT INTO `member_login_record` VALUES (1133, 2, '2019-12-11 14:32:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1134, 2, '2019-12-11 14:36:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1135, 2, '2019-12-11 14:36:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1136, 2, '2019-12-11 14:37:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1137, 2, '2019-12-11 14:39:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1138, 2, '2019-12-11 14:40:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1139, 94, '2019-12-11 14:54:03', 1, 3);
INSERT INTO `member_login_record` VALUES (1140, 94, '2019-12-11 14:54:31', 1, 4);
INSERT INTO `member_login_record` VALUES (1141, 1, '2019-12-11 15:00:38', 1, 4);
INSERT INTO `member_login_record` VALUES (1142, 1, '2019-12-11 15:05:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1143, 1, '2019-12-11 15:06:18', 1, 4);
INSERT INTO `member_login_record` VALUES (1144, 2, '2019-12-11 15:08:23', 2, 0);
INSERT INTO `member_login_record` VALUES (1145, 83, '2019-12-11 15:13:13', 1, 1);
INSERT INTO `member_login_record` VALUES (1146, 2, '2019-12-11 15:17:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1147, 2, '2019-12-11 15:22:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1148, 1, '2019-12-11 15:22:29', 1, 1);
INSERT INTO `member_login_record` VALUES (1149, 2, '2019-12-11 15:24:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1150, 71, '2019-12-11 15:27:50', 1, 1);
INSERT INTO `member_login_record` VALUES (1151, 2, '2019-12-11 15:28:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1152, 52, '2019-12-11 15:29:26', 1, 1);
INSERT INTO `member_login_record` VALUES (1153, 2, '2019-12-11 15:51:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1154, 1, '2019-12-11 16:22:16', 1, 1);
INSERT INTO `member_login_record` VALUES (1155, 1, '2019-12-11 16:30:02', 1, 1);
INSERT INTO `member_login_record` VALUES (1156, 108, '2019-12-11 16:33:01', 1, 3);
INSERT INTO `member_login_record` VALUES (1157, 1, '2019-12-11 16:39:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1158, 1, '2019-12-11 16:46:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1159, 71, '2019-12-11 16:54:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1160, 1, '2019-12-11 17:10:32', 1, 1);
INSERT INTO `member_login_record` VALUES (1161, 1, '2019-12-11 17:10:37', 1, 4);
INSERT INTO `member_login_record` VALUES (1162, 1, '2019-12-11 17:15:48', 1, 3);
INSERT INTO `member_login_record` VALUES (1163, 2, '2019-12-11 17:26:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1164, 2, '2019-12-11 17:27:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1165, 2, '2019-12-11 17:30:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1166, 2, '2019-12-11 17:32:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1167, 2, '2019-12-11 17:33:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1168, 1, '2019-12-11 17:35:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1169, 52, '2019-12-11 17:37:14', 1, 4);
INSERT INTO `member_login_record` VALUES (1170, 2, '2019-12-11 17:48:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1171, 1, '2019-12-11 17:47:26', 1, 1);
INSERT INTO `member_login_record` VALUES (1172, 42, '2019-12-11 18:04:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1173, 42, '2019-12-11 18:07:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1174, 42, '2019-12-11 18:19:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1175, 52, '2019-12-11 18:46:06', 1, 1);
INSERT INTO `member_login_record` VALUES (1176, 102, '2019-12-11 18:58:42', 1, 1);
INSERT INTO `member_login_record` VALUES (1177, 102, '2019-12-11 19:11:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1178, 113, '2019-12-11 19:22:09', 1, 1);
INSERT INTO `member_login_record` VALUES (1179, 113, '2019-12-11 19:24:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1180, 2, '2019-12-11 19:27:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1181, 2, '2019-12-11 19:33:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1182, 94, '2019-12-11 20:00:02', 1, 1);
INSERT INTO `member_login_record` VALUES (1183, 2, '2019-12-11 20:07:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1184, 2, '2019-12-11 20:11:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1185, 1, '2019-12-12 08:38:13', 1, 4);
INSERT INTO `member_login_record` VALUES (1186, 2, '2019-12-12 08:40:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1187, 2, '2019-12-12 08:50:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1188, 71, '2019-12-12 08:51:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1189, 1, '2019-12-12 08:54:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1190, 2, '2019-12-12 09:04:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1191, 2, '2019-12-12 09:10:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1192, 2, '2019-12-12 09:11:13', 2, 0);
INSERT INTO `member_login_record` VALUES (1193, 113, '2019-12-12 09:12:10', 1, 1);
INSERT INTO `member_login_record` VALUES (1194, 2, '2019-12-12 09:13:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1195, 2, '2019-12-12 09:26:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1196, 2, '2019-12-12 09:27:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1197, 1, '2019-12-12 09:30:06', 1, 4);
INSERT INTO `member_login_record` VALUES (1198, 1, '2019-12-12 09:30:17', 1, 1);
INSERT INTO `member_login_record` VALUES (1199, 2, '2019-12-12 09:31:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1200, 94, '2019-12-12 09:34:55', 1, 4);
INSERT INTO `member_login_record` VALUES (1201, 1, '2019-12-12 09:37:55', 1, 4);
INSERT INTO `member_login_record` VALUES (1202, 1, '2019-12-12 09:41:30', 1, 1);
INSERT INTO `member_login_record` VALUES (1203, 2, '2019-12-12 10:05:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1204, 1, '2019-12-12 10:29:10', 1, 1);
INSERT INTO `member_login_record` VALUES (1205, 2, '2019-12-12 10:30:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1206, 1, '2019-12-12 10:31:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1207, 2, '2019-12-12 10:33:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1208, 2, '2019-12-12 10:34:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1209, 1, '2019-12-12 10:40:06', 1, 1);
INSERT INTO `member_login_record` VALUES (1210, 2, '2019-12-12 10:45:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1211, 2, '2019-12-12 10:49:55', 2, 0);
INSERT INTO `member_login_record` VALUES (1212, 94, '2019-12-12 10:53:18', 1, 1);
INSERT INTO `member_login_record` VALUES (1213, 82, '2019-12-12 10:54:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1214, 2, '2019-12-12 11:01:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1215, 1, '2019-12-12 11:03:57', 1, 1);
INSERT INTO `member_login_record` VALUES (1216, 1, '2019-12-12 11:05:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1217, 2, '2019-12-12 11:18:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1218, 2, '2019-12-12 11:23:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1219, 1, '2019-12-12 11:24:43', 1, 1);
INSERT INTO `member_login_record` VALUES (1220, 2, '2019-12-12 11:25:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1221, 1, '2019-12-12 11:28:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1222, 2, '2019-12-12 11:36:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1223, 1, '2019-12-12 11:41:29', 1, 1);
INSERT INTO `member_login_record` VALUES (1224, 1, '2019-12-12 11:47:18', 1, 1);
INSERT INTO `member_login_record` VALUES (1225, 1, '2019-12-12 11:48:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1226, 2, '2019-12-12 11:49:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1227, 1, '2019-12-12 11:56:41', 1, 1);
INSERT INTO `member_login_record` VALUES (1228, 1, '2019-12-12 11:58:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1229, 1, '2019-12-12 11:59:41', 1, 1);
INSERT INTO `member_login_record` VALUES (1230, 1, '2019-12-12 12:49:14', 1, 1);
INSERT INTO `member_login_record` VALUES (1231, 1, '2019-12-12 14:03:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1232, 1, '2019-12-12 14:04:30', 1, 1);
INSERT INTO `member_login_record` VALUES (1233, 1, '2019-12-12 14:08:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1234, 1, '2019-12-12 14:11:10', 1, 1);
INSERT INTO `member_login_record` VALUES (1235, 1, '2019-12-12 14:11:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1236, 2, '2019-12-12 14:17:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1237, 2, '2019-12-12 14:20:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1238, 1, '2019-12-12 14:32:32', 1, 1);
INSERT INTO `member_login_record` VALUES (1239, 1, '2019-12-12 14:37:14', 1, 1);
INSERT INTO `member_login_record` VALUES (1240, 2, '2019-12-12 14:38:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1241, 2, '2019-12-12 14:41:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1242, 2, '2019-12-12 14:44:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1243, 1, '2019-12-12 14:48:21', 1, 1);
INSERT INTO `member_login_record` VALUES (1244, 52, '2019-12-12 14:53:20', 1, 4);
INSERT INTO `member_login_record` VALUES (1245, 91, '2019-12-12 14:56:00', 1, 1);
INSERT INTO `member_login_record` VALUES (1246, 2, '2019-12-12 14:56:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1247, 2, '2019-12-12 14:57:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1248, 1, '2019-12-12 15:06:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1249, 1, '2019-12-12 15:06:25', 1, 1);
INSERT INTO `member_login_record` VALUES (1250, 94, '2019-12-12 15:14:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1251, 1, '2019-12-12 15:15:27', 1, 4);
INSERT INTO `member_login_record` VALUES (1252, 94, '2019-12-12 15:16:07', 1, 3);
INSERT INTO `member_login_record` VALUES (1253, 1, '2019-12-12 15:16:09', 1, 4);
INSERT INTO `member_login_record` VALUES (1254, 94, '2019-12-12 15:17:38', 1, 4);
INSERT INTO `member_login_record` VALUES (1255, 2, '2019-12-12 15:19:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1256, 1, '2019-12-12 15:20:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1257, 2, '2019-12-12 15:28:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1258, 91, '2019-12-12 15:49:28', 1, 4);
INSERT INTO `member_login_record` VALUES (1259, 1, '2019-12-12 16:03:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1260, 94, '2019-12-12 16:05:33', 1, 3);
INSERT INTO `member_login_record` VALUES (1261, 2, '2019-12-12 16:05:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1262, 2, '2019-12-12 16:11:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1263, 71, '2019-12-12 16:17:06', 1, 4);
INSERT INTO `member_login_record` VALUES (1264, 52, '2019-12-12 16:20:58', 1, 4);
INSERT INTO `member_login_record` VALUES (1265, 1, '2019-12-12 16:40:27', 1, 4);
INSERT INTO `member_login_record` VALUES (1266, 2, '2019-12-12 16:42:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1267, 2, '2019-12-12 16:43:44', 2, 0);
INSERT INTO `member_login_record` VALUES (1268, 2, '2019-12-12 16:43:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1269, 113, '2019-12-12 16:45:47', 1, 1);
INSERT INTO `member_login_record` VALUES (1270, 2, '2019-12-12 16:47:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1271, 100, '2019-12-12 16:53:42', 1, 4);
INSERT INTO `member_login_record` VALUES (1272, 71, '2019-12-12 17:11:35', 1, 1);
INSERT INTO `member_login_record` VALUES (1273, 1, '2019-12-12 17:16:56', 1, 4);
INSERT INTO `member_login_record` VALUES (1274, 1, '2019-12-12 17:43:50', 1, 1);
INSERT INTO `member_login_record` VALUES (1275, 2, '2019-12-12 18:22:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1276, 2, '2019-12-12 18:23:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1277, 2, '2019-12-12 18:31:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1278, 2, '2019-12-13 08:45:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1279, 2, '2019-12-13 09:17:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1280, 2, '2019-12-13 09:19:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1281, 102, '2019-12-13 09:28:37', 1, 1);
INSERT INTO `member_login_record` VALUES (1282, 2, '2019-12-13 09:31:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1283, 1, '2019-12-13 09:43:34', 1, 4);
INSERT INTO `member_login_record` VALUES (1284, 1, '2019-12-13 09:43:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1285, 2, '2019-12-13 09:48:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1286, 71, '2019-12-13 09:55:32', 1, 4);
INSERT INTO `member_login_record` VALUES (1287, 2, '2019-12-13 10:01:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1288, 2, '2019-12-13 10:53:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1289, 91, '2019-12-13 10:57:54', 1, 1);
INSERT INTO `member_login_record` VALUES (1290, 100, '2019-12-13 10:58:19', 1, 1);
INSERT INTO `member_login_record` VALUES (1291, 1, '2019-12-13 11:02:57', 1, 4);
INSERT INTO `member_login_record` VALUES (1292, 2, '2019-12-13 11:03:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1293, 114, '2019-12-13 11:09:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1294, 111, '2019-12-13 11:09:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1295, 2, '2019-12-13 11:18:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1296, 113, '2019-12-13 11:20:06', 1, 1);
INSERT INTO `member_login_record` VALUES (1297, 2, '2019-12-13 11:20:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1298, 91, '2019-12-13 11:24:27', 1, 4);
INSERT INTO `member_login_record` VALUES (1299, 100, '2019-12-13 11:34:40', 1, 4);
INSERT INTO `member_login_record` VALUES (1300, 2, '2019-12-13 11:51:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1301, 2, '2019-12-13 12:17:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1302, 1, '2019-12-13 13:27:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1303, 52, '2019-12-13 13:30:13', 1, 4);
INSERT INTO `member_login_record` VALUES (1304, 2, '2019-12-13 14:08:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1305, 100, '2019-12-13 14:12:00', 1, 4);
INSERT INTO `member_login_record` VALUES (1306, 2, '2019-12-13 14:12:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1307, 2, '2019-12-13 14:12:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1308, 2, '2019-12-13 14:13:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1309, 2, '2019-12-13 14:20:27', 2, 0);
INSERT INTO `member_login_record` VALUES (1310, 2, '2019-12-13 14:37:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1311, 2, '2019-12-13 14:46:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1312, 60, '2019-12-13 14:48:33', 1, 2);
INSERT INTO `member_login_record` VALUES (1313, 52, '2019-12-13 14:49:12', 1, 2);
INSERT INTO `member_login_record` VALUES (1314, 2, '2019-12-13 14:59:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1315, 2, '2019-12-13 15:02:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1316, 2, '2019-12-13 15:06:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1317, 2, '2019-12-13 15:09:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1318, 1, '2019-12-13 15:09:33', 1, 1);
INSERT INTO `member_login_record` VALUES (1319, 1, '2019-12-13 15:09:52', 1, 4);
INSERT INTO `member_login_record` VALUES (1320, 2, '2019-12-13 15:10:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1321, 52, '2019-12-13 15:12:15', 1, 1);
INSERT INTO `member_login_record` VALUES (1322, 2, '2019-12-13 15:12:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1323, 2, '2019-12-13 15:14:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1324, 2, '2019-12-13 15:26:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1325, 2, '2019-12-13 15:29:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1326, 1, '2019-12-13 15:36:57', 1, 4);
INSERT INTO `member_login_record` VALUES (1327, 111, '2019-12-13 15:40:57', 1, 3);
INSERT INTO `member_login_record` VALUES (1328, 2, '2019-12-13 15:53:55', 2, 0);
INSERT INTO `member_login_record` VALUES (1329, 2, '2019-12-13 15:55:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1330, 112, '2019-12-13 15:57:06', 1, 1);
INSERT INTO `member_login_record` VALUES (1331, 115, '2019-12-13 16:07:28', 1, 1);
INSERT INTO `member_login_record` VALUES (1332, 2, '2019-12-13 16:10:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1333, 2, '2019-12-13 16:11:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1334, 2, '2019-12-13 16:21:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1335, 2, '2019-12-13 16:31:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1336, 111, '2019-12-13 16:31:54', 1, 1);
INSERT INTO `member_login_record` VALUES (1337, 100, '2019-12-13 16:33:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1338, 113, '2019-12-13 16:39:20', 1, 1);
INSERT INTO `member_login_record` VALUES (1339, 113, '2019-12-13 16:41:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1340, 91, '2019-12-13 16:45:15', 1, 4);
INSERT INTO `member_login_record` VALUES (1341, 47, '2019-12-13 16:49:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1342, 1, '2019-12-13 16:53:01', 1, 4);
INSERT INTO `member_login_record` VALUES (1343, 2, '2019-12-13 16:53:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1344, 1, '2019-12-13 16:59:10', 1, 4);
INSERT INTO `member_login_record` VALUES (1345, 47, '2019-12-13 16:59:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1346, 47, '2019-12-13 16:59:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1347, 102, '2019-12-13 16:59:57', 1, 1);
INSERT INTO `member_login_record` VALUES (1348, 2, '2019-12-13 17:00:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1349, 48, '2019-12-13 17:02:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1350, 47, '2019-12-13 17:04:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1351, 52, '2019-12-13 17:06:42', 1, 2);
INSERT INTO `member_login_record` VALUES (1352, 2, '2019-12-13 17:09:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1353, 34, '2019-12-13 17:10:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1354, 47, '2019-12-13 17:11:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1355, 49, '2019-12-13 17:12:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1356, 47, '2019-12-13 17:15:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1357, 2, '2019-12-13 17:16:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1358, 2, '2019-12-13 17:26:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1359, 1, '2019-12-13 17:29:42', 1, 1);
INSERT INTO `member_login_record` VALUES (1360, 1, '2019-12-13 17:29:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1361, 71, '2019-12-13 17:32:09', 1, 1);
INSERT INTO `member_login_record` VALUES (1362, 2, '2019-12-13 17:50:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1363, 2, '2019-12-13 17:56:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1364, 47, '2019-12-13 18:19:27', 2, 0);
INSERT INTO `member_login_record` VALUES (1365, 1, '2019-12-13 18:21:02', 1, 1);
INSERT INTO `member_login_record` VALUES (1366, 1, '2019-12-13 18:21:13', 1, 1);
INSERT INTO `member_login_record` VALUES (1367, 2, '2019-12-13 18:33:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1368, 2, '2019-12-14 10:47:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1369, 2, '2019-12-14 10:48:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1370, 2, '2019-12-14 16:27:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1371, 2, '2019-12-14 17:10:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1372, 2, '2019-12-16 08:37:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1373, 2, '2019-12-16 08:38:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1374, 2, '2019-12-16 09:00:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1375, 2, '2019-12-16 09:05:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1376, 1, '2019-12-16 09:15:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1377, 2, '2019-12-16 09:16:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1378, 2, '2019-12-16 09:20:15', 2, 0);
INSERT INTO `member_login_record` VALUES (1379, 2, '2019-12-16 09:20:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1380, 2, '2019-12-16 09:26:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1381, 2, '2019-12-16 09:29:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1382, 1, '2019-12-16 09:42:20', 1, 4);
INSERT INTO `member_login_record` VALUES (1383, 111, '2019-12-16 09:43:53', 1, 4);
INSERT INTO `member_login_record` VALUES (1384, 2, '2019-12-16 09:59:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1385, 52, '2019-12-16 09:59:26', 1, 2);
INSERT INTO `member_login_record` VALUES (1386, 52, '2019-12-16 10:03:28', 1, 2);
INSERT INTO `member_login_record` VALUES (1387, 2, '2019-12-16 10:06:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1388, 113, '2019-12-16 10:10:32', 1, 1);
INSERT INTO `member_login_record` VALUES (1389, 2, '2019-12-16 10:11:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1390, 52, '2019-12-16 10:20:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1391, 2, '2019-12-16 10:25:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1392, 2, '2019-12-16 10:28:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1393, 102, '2019-12-16 10:27:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1394, 2, '2019-12-16 10:29:55', 2, 0);
INSERT INTO `member_login_record` VALUES (1395, 2, '2019-12-16 10:30:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1396, 2, '2019-12-16 10:31:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1397, 2, '2019-12-16 10:33:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1398, 2, '2019-12-16 10:34:03', 2, 0);
INSERT INTO `member_login_record` VALUES (1399, 2, '2019-12-16 10:37:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1400, 2, '2019-12-16 10:41:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1401, 113, '2019-12-16 10:47:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1402, 52, '2019-12-16 10:58:25', 1, 2);
INSERT INTO `member_login_record` VALUES (1403, 2, '2019-12-16 10:58:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1404, 2, '2019-12-16 11:29:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1405, 2, '2019-12-16 11:34:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1406, 100, '2019-12-16 12:42:56', 1, 1);
INSERT INTO `member_login_record` VALUES (1407, 114, '2019-12-16 14:20:30', 1, 1);
INSERT INTO `member_login_record` VALUES (1408, 71, '2019-12-16 14:33:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1409, 2, '2019-12-16 14:34:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1410, 2, '2019-12-16 14:43:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1411, 2, '2019-12-16 14:52:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1412, 52, '2019-12-16 15:25:56', 1, 2);
INSERT INTO `member_login_record` VALUES (1413, 2, '2019-12-16 15:53:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1414, 52, '2019-12-16 15:56:05', 1, 2);
INSERT INTO `member_login_record` VALUES (1415, 2, '2019-12-16 16:02:27', 2, 0);
INSERT INTO `member_login_record` VALUES (1416, 52, '2019-12-16 16:10:37', 1, 2);
INSERT INTO `member_login_record` VALUES (1417, 100, '2019-12-16 16:18:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1418, 52, '2019-12-16 16:44:21', 1, 1);
INSERT INTO `member_login_record` VALUES (1419, 2, '2019-12-16 16:44:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1420, 2, '2019-12-16 16:46:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1421, 1, '2019-12-16 16:48:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1422, 52, '2019-12-16 16:54:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1423, 100, '2019-12-16 17:06:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1424, 2, '2019-12-16 17:12:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1425, 13, '2019-12-16 17:15:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1426, 100, '2019-12-16 17:28:15', 1, 4);
INSERT INTO `member_login_record` VALUES (1427, 2, '2019-12-16 17:32:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1428, 1, '2019-12-16 17:35:56', 1, 1);
INSERT INTO `member_login_record` VALUES (1429, 117, '2019-12-16 17:35:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1430, 13, '2019-12-16 17:39:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1431, 13, '2019-12-16 18:00:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1432, 2, '2019-12-17 08:47:13', 2, 0);
INSERT INTO `member_login_record` VALUES (1433, 2, '2019-12-17 08:47:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1434, 2, '2019-12-17 08:57:26', 2, 0);
INSERT INTO `member_login_record` VALUES (1435, 118, '2019-12-17 08:55:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1436, 2, '2019-12-17 08:58:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1437, 2, '2019-12-17 08:59:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1438, 2, '2019-12-17 09:03:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1439, 2, '2019-12-17 09:10:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1440, 2, '2019-12-17 09:12:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1441, 118, '2019-12-17 09:21:47', 1, 1);
INSERT INTO `member_login_record` VALUES (1442, 35, '2019-12-17 09:32:56', 1, 1);
INSERT INTO `member_login_record` VALUES (1443, 111, '2019-12-17 09:33:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1444, 2, '2019-12-17 09:41:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1445, 2, '2019-12-17 09:47:38', 2, 0);
INSERT INTO `member_login_record` VALUES (1446, 2, '2019-12-17 09:58:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1447, 122, '2019-12-17 10:21:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1448, 118, '2019-12-17 10:22:20', 1, 1);
INSERT INTO `member_login_record` VALUES (1449, 52, '2019-12-17 10:25:07', 1, 2);
INSERT INTO `member_login_record` VALUES (1450, 2, '2019-12-17 10:25:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1451, 118, '2019-12-17 10:28:09', 1, 1);
INSERT INTO `member_login_record` VALUES (1452, 111, '2019-12-17 10:30:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1453, 122, '2019-12-17 10:30:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1454, 2, '2019-12-17 10:40:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1455, 52, '2019-12-17 10:46:42', 1, 1);
INSERT INTO `member_login_record` VALUES (1456, 52, '2019-12-17 10:48:53', 1, 4);
INSERT INTO `member_login_record` VALUES (1457, 2, '2019-12-17 10:53:24', 2, 0);
INSERT INTO `member_login_record` VALUES (1458, 2, '2019-12-17 10:59:28', 2, 0);
INSERT INTO `member_login_record` VALUES (1459, 114, '2019-12-17 11:03:46', 1, 1);
INSERT INTO `member_login_record` VALUES (1460, 118, '2019-12-17 11:04:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1461, 118, '2019-12-17 11:08:15', 1, 4);
INSERT INTO `member_login_record` VALUES (1462, 41, '2019-12-17 11:11:37', 1, 1);
INSERT INTO `member_login_record` VALUES (1463, 41, '2019-12-17 11:21:34', 1, 4);
INSERT INTO `member_login_record` VALUES (1464, 2, '2019-12-17 11:22:01', 2, 0);
INSERT INTO `member_login_record` VALUES (1465, 100, '2019-12-17 11:26:22', 1, 4);
INSERT INTO `member_login_record` VALUES (1466, 111, '2019-12-17 11:29:53', 1, 4);
INSERT INTO `member_login_record` VALUES (1467, 91, '2019-12-17 11:38:28', 1, 4);
INSERT INTO `member_login_record` VALUES (1468, 1, '2019-12-17 11:46:20', 1, 3);
INSERT INTO `member_login_record` VALUES (1469, 41, '2019-12-17 11:53:18', 1, 4);
INSERT INTO `member_login_record` VALUES (1470, 71, '2019-12-17 11:55:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1471, 71, '2019-12-17 12:03:15', 1, 3);
INSERT INTO `member_login_record` VALUES (1472, 76, '2019-12-17 12:05:47', 1, 3);
INSERT INTO `member_login_record` VALUES (1473, 71, '2019-12-17 12:06:33', 1, 3);
INSERT INTO `member_login_record` VALUES (1474, 2, '2019-12-17 12:28:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1475, 91, '2019-12-17 14:13:56', 1, 3);
INSERT INTO `member_login_record` VALUES (1476, 91, '2019-12-17 14:20:57', 1, 1);
INSERT INTO `member_login_record` VALUES (1477, 2, '2019-12-17 14:23:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1478, 71, '2019-12-17 14:28:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1479, 1, '2019-12-17 14:35:45', 1, 4);
INSERT INTO `member_login_record` VALUES (1480, 52, '2019-12-17 14:36:13', 1, 4);
INSERT INTO `member_login_record` VALUES (1481, 115, '2019-12-17 14:39:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1482, 1, '2019-12-17 14:55:31', 1, 1);
INSERT INTO `member_login_record` VALUES (1483, 76, '2019-12-17 14:56:00', 1, 3);
INSERT INTO `member_login_record` VALUES (1484, 122, '2019-12-17 14:56:19', 1, 1);
INSERT INTO `member_login_record` VALUES (1485, 2, '2019-12-17 14:56:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1486, 1, '2019-12-17 14:57:00', 1, 4);
INSERT INTO `member_login_record` VALUES (1487, 41, '2019-12-17 15:01:53', 1, 3);
INSERT INTO `member_login_record` VALUES (1488, 1, '2019-12-17 15:06:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1489, 1, '2019-12-17 15:06:49', 1, 4);
INSERT INTO `member_login_record` VALUES (1490, 1, '2019-12-17 15:07:46', 1, 3);
INSERT INTO `member_login_record` VALUES (1491, 1, '2019-12-17 15:08:37', 1, 1);
INSERT INTO `member_login_record` VALUES (1492, 2, '2019-12-17 15:09:24', 2, 0);
INSERT INTO `member_login_record` VALUES (1493, 2, '2019-12-17 15:10:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1494, 1, '2019-12-17 15:10:17', 1, 4);
INSERT INTO `member_login_record` VALUES (1495, 2, '2019-12-17 15:10:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1496, 41, '2019-12-17 15:27:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1497, 71, '2019-12-17 15:59:48', 1, 3);
INSERT INTO `member_login_record` VALUES (1498, 1, '2019-12-17 16:05:32', 1, 4);
INSERT INTO `member_login_record` VALUES (1499, 2, '2019-12-17 16:23:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1500, 1, '2019-12-17 16:27:23', 1, 4);
INSERT INTO `member_login_record` VALUES (1501, 100, '2019-12-17 16:32:17', 1, 1);
INSERT INTO `member_login_record` VALUES (1502, 100, '2019-12-17 16:32:34', 1, 1);
INSERT INTO `member_login_record` VALUES (1503, 100, '2019-12-17 16:33:19', 1, 3);
INSERT INTO `member_login_record` VALUES (1504, 2, '2019-12-17 16:33:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1505, 35, '2019-12-17 16:36:50', 1, 1);
INSERT INTO `member_login_record` VALUES (1506, 35, '2019-12-17 16:38:57', 1, 4);
INSERT INTO `member_login_record` VALUES (1507, 100, '2019-12-17 16:46:15', 1, 1);
INSERT INTO `member_login_record` VALUES (1508, 1, '2019-12-17 16:56:30', 1, 1);
INSERT INTO `member_login_record` VALUES (1509, 122, '2019-12-17 16:58:53', 1, 4);
INSERT INTO `member_login_record` VALUES (1510, 122, '2019-12-17 17:01:19', 1, 1);
INSERT INTO `member_login_record` VALUES (1511, 2, '2019-12-17 17:13:18', 2, 0);
INSERT INTO `member_login_record` VALUES (1512, 2, '2019-12-17 17:20:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1513, 2, '2019-12-17 17:25:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1514, 2, '2019-12-17 17:25:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1515, 123, '2019-12-17 17:27:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1516, 2, '2019-12-17 17:39:46', 2, 0);
INSERT INTO `member_login_record` VALUES (1517, 13, '2019-12-17 18:02:01', 2, 0);
INSERT INTO `member_login_record` VALUES (1518, 13, '2019-12-17 18:04:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1519, 59, '2019-12-17 18:09:21', 1, 1);
INSERT INTO `member_login_record` VALUES (1520, 59, '2019-12-17 18:10:12', 1, 1);
INSERT INTO `member_login_record` VALUES (1521, 59, '2019-12-17 18:39:46', 1, 1);
INSERT INTO `member_login_record` VALUES (1522, 59, '2019-12-17 18:40:16', 1, 1);
INSERT INTO `member_login_record` VALUES (1523, 1, '2019-12-18 08:36:55', 1, 4);
INSERT INTO `member_login_record` VALUES (1524, 2, '2019-12-18 09:03:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1525, 1, '2019-12-18 09:27:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1526, 2, '2019-12-18 09:33:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1527, 2, '2019-12-18 09:33:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1528, 94, '2019-12-18 09:41:14', 1, 2);
INSERT INTO `member_login_record` VALUES (1529, 113, '2019-12-18 09:44:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1530, 2, '2019-12-18 09:46:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1531, 1, '2019-12-18 09:50:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1532, 1, '2019-12-18 09:51:52', 1, 1);
INSERT INTO `member_login_record` VALUES (1533, 2, '2019-12-18 09:56:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1534, 114, '2019-12-18 09:56:38', 1, 1);
INSERT INTO `member_login_record` VALUES (1535, 41, '2019-12-18 09:59:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1536, 91, '2019-12-18 10:00:04', 1, 3);
INSERT INTO `member_login_record` VALUES (1537, 124, '2019-12-18 10:23:57', 1, 1);
INSERT INTO `member_login_record` VALUES (1538, 1, '2019-12-18 10:31:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1539, 2, '2019-12-18 10:35:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1540, 2, '2019-12-18 10:37:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1541, 1, '2019-12-18 10:38:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1542, 2, '2019-12-18 10:40:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1543, 2, '2019-12-18 10:42:24', 2, 0);
INSERT INTO `member_login_record` VALUES (1544, 123, '2019-12-18 10:53:31', 1, 1);
INSERT INTO `member_login_record` VALUES (1545, 2, '2019-12-18 11:09:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1546, 2, '2019-12-18 11:11:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1547, 13, '2019-12-18 11:13:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1548, 2, '2019-12-18 11:13:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1549, 1, '2019-12-18 11:16:55', 1, 1);
INSERT INTO `member_login_record` VALUES (1550, 1, '2019-12-18 11:26:42', 1, 4);
INSERT INTO `member_login_record` VALUES (1551, 123, '2019-12-18 11:32:07', 1, 1);
INSERT INTO `member_login_record` VALUES (1552, 35, '2019-12-18 11:35:17', 1, 1);
INSERT INTO `member_login_record` VALUES (1553, 111, '2019-12-18 11:37:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1554, 111, '2019-12-18 11:39:14', 1, 1);
INSERT INTO `member_login_record` VALUES (1555, 108, '2019-12-18 11:39:35', 1, 1);
INSERT INTO `member_login_record` VALUES (1556, 52, '2019-12-18 11:39:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1557, 123, '2019-12-18 11:40:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1558, 1, '2019-12-18 11:45:31', 1, 1);
INSERT INTO `member_login_record` VALUES (1559, 123, '2019-12-18 11:46:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1560, 123, '2019-12-18 11:48:38', 1, 1);
INSERT INTO `member_login_record` VALUES (1561, 117, '2019-12-18 11:50:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1562, 117, '2019-12-18 11:50:56', 1, 4);
INSERT INTO `member_login_record` VALUES (1563, 123, '2019-12-18 11:52:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1564, 1, '2019-12-18 11:58:29', 1, 1);
INSERT INTO `member_login_record` VALUES (1565, 2, '2019-12-18 14:08:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1566, 1, '2019-12-18 14:20:35', 1, 1);
INSERT INTO `member_login_record` VALUES (1567, 2, '2019-12-18 14:36:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1568, 100, '2019-12-18 14:46:11', 1, 3);
INSERT INTO `member_login_record` VALUES (1569, 124, '2019-12-18 15:03:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1570, 118, '2019-12-18 15:23:41', 1, 3);
INSERT INTO `member_login_record` VALUES (1571, 124, '2019-12-18 15:28:59', 1, 4);
INSERT INTO `member_login_record` VALUES (1572, 1, '2019-12-18 15:34:37', 1, 4);
INSERT INTO `member_login_record` VALUES (1573, 123, '2019-12-18 15:37:52', 1, 3);
INSERT INTO `member_login_record` VALUES (1574, 91, '2019-12-18 15:38:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1575, 113, '2019-12-18 15:53:29', 1, 1);
INSERT INTO `member_login_record` VALUES (1576, 2, '2019-12-18 15:55:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1577, 2, '2019-12-18 15:56:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1578, 2, '2019-12-18 16:14:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1579, 13, '2019-12-18 16:14:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1580, 111, '2019-12-18 16:20:16', 1, 1);
INSERT INTO `member_login_record` VALUES (1581, 76, '2019-12-18 16:21:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1582, 1, '2019-12-18 16:22:11', 1, 1);
INSERT INTO `member_login_record` VALUES (1583, 92, '2019-12-18 16:22:39', 1, 1);
INSERT INTO `member_login_record` VALUES (1584, 92, '2019-12-18 16:24:56', 1, 3);
INSERT INTO `member_login_record` VALUES (1585, 1, '2019-12-18 16:35:01', 1, 4);
INSERT INTO `member_login_record` VALUES (1586, 80, '2019-12-18 16:48:24', 1, 4);
INSERT INTO `member_login_record` VALUES (1587, 100, '2019-12-18 16:50:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1588, 91, '2019-12-18 16:52:09', 1, 1);
INSERT INTO `member_login_record` VALUES (1589, 50, '2019-12-18 16:52:48', 2, 0);
INSERT INTO `member_login_record` VALUES (1590, 100, '2019-12-18 16:53:00', 1, 1);
INSERT INTO `member_login_record` VALUES (1591, 2, '2019-12-18 16:54:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1592, 60, '2019-12-18 17:00:24', 1, 3);
INSERT INTO `member_login_record` VALUES (1593, 2, '2019-12-18 17:13:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1594, 80, '2019-12-18 17:13:59', 1, 4);
INSERT INTO `member_login_record` VALUES (1595, 50, '2019-12-18 17:19:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1596, 102, '2019-12-18 17:41:50', 1, 1);
INSERT INTO `member_login_record` VALUES (1597, 52, '2019-12-18 17:59:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1598, 2, '2019-12-18 18:03:01', 2, 0);
INSERT INTO `member_login_record` VALUES (1599, 2, '2019-12-18 18:14:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1600, 1, '2019-12-18 18:22:57', 1, 4);
INSERT INTO `member_login_record` VALUES (1601, 49, '2019-12-18 18:27:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1602, 1, '2019-12-18 18:30:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1603, 2, '2019-12-18 18:40:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1604, 1, '2019-12-18 18:42:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1605, 1, '2019-12-18 18:53:08', 1, 1);
INSERT INTO `member_login_record` VALUES (1606, 2, '2019-12-18 19:07:55', 2, 0);
INSERT INTO `member_login_record` VALUES (1607, 2, '2019-12-18 19:16:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1608, 60, '2019-12-19 08:37:54', 1, 3);
INSERT INTO `member_login_record` VALUES (1609, 1, '2019-12-19 08:38:16', 1, 4);
INSERT INTO `member_login_record` VALUES (1610, 49, '2019-12-19 08:38:43', 1, 4);
INSERT INTO `member_login_record` VALUES (1611, 49, '2019-12-19 08:48:49', 1, 4);
INSERT INTO `member_login_record` VALUES (1612, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1613, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1614, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1615, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1616, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1617, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1618, 1, '2019-12-19 09:03:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1619, 1, '2019-12-19 09:04:29', 1, 1);
INSERT INTO `member_login_record` VALUES (1620, 112, '2019-12-19 09:07:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1621, 2, '2019-12-19 09:08:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1622, 102, '2019-12-19 09:08:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1623, 2, '2019-12-19 09:13:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1624, 50, '2019-12-19 09:15:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1625, 2, '2019-12-19 09:15:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1626, 2, '2019-12-19 09:17:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1627, 1, '2019-12-19 09:18:17', 1, 1);
INSERT INTO `member_login_record` VALUES (1628, 2, '2019-12-19 09:18:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1629, 100, '2019-12-19 09:21:32', 1, 1);
INSERT INTO `member_login_record` VALUES (1630, 2, '2019-12-19 09:29:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1631, 1, '2019-12-19 09:31:26', 1, 4);
INSERT INTO `member_login_record` VALUES (1632, 2, '2019-12-19 09:32:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1633, 2, '2019-12-19 09:32:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1634, 2, '2019-12-19 09:35:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1635, 52, '2019-12-19 09:37:09', 1, 4);
INSERT INTO `member_login_record` VALUES (1636, 52, '2019-12-19 09:38:07', 1, 1);
INSERT INTO `member_login_record` VALUES (1637, 52, '2019-12-19 09:39:02', 1, 4);
INSERT INTO `member_login_record` VALUES (1638, 113, '2019-12-19 09:39:12', 1, 1);
INSERT INTO `member_login_record` VALUES (1639, 1, '2019-12-19 09:39:55', 1, 1);
INSERT INTO `member_login_record` VALUES (1640, 1, '2019-12-19 09:42:37', 1, 4);
INSERT INTO `member_login_record` VALUES (1641, 80, '2019-12-19 09:50:31', 1, 4);
INSERT INTO `member_login_record` VALUES (1642, 80, '2019-12-19 09:55:12', 1, 4);
INSERT INTO `member_login_record` VALUES (1643, 2, '2019-12-19 09:59:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1644, 50, '2019-12-19 09:59:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1645, 2, '2019-12-19 10:02:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1646, 80, '2019-12-19 10:17:15', 1, 2);
INSERT INTO `member_login_record` VALUES (1647, 2, '2019-12-19 11:42:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1648, 41, '2019-12-19 11:59:32', 1, 4);
INSERT INTO `member_login_record` VALUES (1649, 113, '2019-12-19 12:01:12', 1, 1);
INSERT INTO `member_login_record` VALUES (1650, 2, '2019-12-19 14:06:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1651, 1, '2019-12-19 14:11:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1652, 2, '2019-12-19 14:14:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1653, 2, '2019-12-19 14:18:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1654, 49, '2019-12-19 14:26:38', 1, 4);
INSERT INTO `member_login_record` VALUES (1655, 2, '2019-12-19 14:26:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1656, 113, '2019-12-19 14:26:53', 1, 1);
INSERT INTO `member_login_record` VALUES (1657, 2, '2019-12-19 14:28:41', 2, 0);
INSERT INTO `member_login_record` VALUES (1658, 2, '2019-12-19 14:33:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1659, 2, '2019-12-19 14:34:43', 2, 0);
INSERT INTO `member_login_record` VALUES (1660, 113, '2019-12-19 14:38:16', 1, 1);
INSERT INTO `member_login_record` VALUES (1661, 13, '2019-12-19 14:58:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1662, 2, '2019-12-19 14:59:11', 2, 0);
INSERT INTO `member_login_record` VALUES (1663, 94, '2019-12-19 14:59:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1664, 102, '2019-12-19 15:02:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1665, 52, '2019-12-19 15:05:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1666, 113, '2019-12-19 15:11:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1667, 52, '2019-12-19 15:18:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1668, 2, '2019-12-19 15:19:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1669, 54, '2019-12-19 15:22:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1670, 112, '2019-12-19 15:30:38', 1, 1);
INSERT INTO `member_login_record` VALUES (1671, 52, '2019-12-19 15:42:48', 1, 3);
INSERT INTO `member_login_record` VALUES (1672, 41, '2019-12-19 15:47:26', 1, 1);
INSERT INTO `member_login_record` VALUES (1673, 52, '2019-12-19 15:54:32', 1, 3);
INSERT INTO `member_login_record` VALUES (1674, 80, '2019-12-19 15:57:01', 1, 3);
INSERT INTO `member_login_record` VALUES (1675, 60, '2019-12-19 15:57:41', 1, 3);
INSERT INTO `member_login_record` VALUES (1676, 52, '2019-12-19 16:00:58', 1, 3);
INSERT INTO `member_login_record` VALUES (1677, 2, '2019-12-19 16:33:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1678, 2, '2019-12-19 17:27:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1679, 1, '2019-12-19 17:35:24', 1, 4);
INSERT INTO `member_login_record` VALUES (1680, 2, '2019-12-19 18:03:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1681, 1, '2019-12-19 18:20:16', 1, 1);
INSERT INTO `member_login_record` VALUES (1682, 100, '2019-12-19 18:22:15', 1, 3);
INSERT INTO `member_login_record` VALUES (1683, 2, '2019-12-19 18:30:13', 2, 0);
INSERT INTO `member_login_record` VALUES (1684, 2, '2019-12-19 19:00:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1685, 2, '2019-12-19 19:19:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1686, 2, '2019-12-19 19:29:03', 2, 0);
INSERT INTO `member_login_record` VALUES (1687, 2, '2019-12-19 19:48:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1688, 2, '2019-12-20 08:47:25', 2, 0);
INSERT INTO `member_login_record` VALUES (1689, 2, '2019-12-20 08:55:57', 2, 0);
INSERT INTO `member_login_record` VALUES (1690, 2, '2019-12-20 09:02:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1691, 2, '2019-12-20 09:02:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1692, 2, '2019-12-20 09:07:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1693, 2, '2019-12-20 09:23:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1694, 2, '2019-12-20 09:26:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1695, 13, '2019-12-20 09:35:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1696, 113, '2019-12-20 09:41:52', 1, 1);
INSERT INTO `member_login_record` VALUES (1697, 2, '2019-12-20 09:42:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1698, 13, '2019-12-20 09:55:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1699, 2, '2019-12-20 09:57:00', 2, 0);
INSERT INTO `member_login_record` VALUES (1700, 2, '2019-12-20 10:20:03', 2, 0);
INSERT INTO `member_login_record` VALUES (1701, 50, '2019-12-20 10:31:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1702, 1, '2019-12-20 10:35:33', 1, 4);
INSERT INTO `member_login_record` VALUES (1703, 52, '2019-12-20 10:58:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1704, 52, '2019-12-20 11:02:15', 2, 0);
INSERT INTO `member_login_record` VALUES (1705, 2, '2019-12-20 11:06:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1706, 56, '2019-12-20 11:15:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1707, 2, '2019-12-20 11:39:21', 2, 0);
INSERT INTO `member_login_record` VALUES (1708, 2, '2019-12-20 11:44:58', 2, 0);
INSERT INTO `member_login_record` VALUES (1709, 41, '2019-12-20 11:44:59', 1, 4);
INSERT INTO `member_login_record` VALUES (1710, 41, '2019-12-20 11:47:04', 1, 1);
INSERT INTO `member_login_record` VALUES (1711, 2, '2019-12-20 11:47:25', 2, 0);
INSERT INTO `member_login_record` VALUES (1712, 41, '2019-12-20 11:51:17', 1, 4);
INSERT INTO `member_login_record` VALUES (1713, 2, '2019-12-20 11:55:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1714, 60, '2019-12-20 12:26:23', 1, 3);
INSERT INTO `member_login_record` VALUES (1715, 52, '2019-12-20 12:30:53', 1, 2);
INSERT INTO `member_login_record` VALUES (1716, 2, '2019-12-20 14:07:33', 2, 0);
INSERT INTO `member_login_record` VALUES (1717, 53, '2019-12-20 14:11:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1718, 50, '2019-12-20 14:15:48', 2, 0);
INSERT INTO `member_login_record` VALUES (1719, 53, '2019-12-20 14:17:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1720, 2, '2019-12-20 14:18:12', 2, 0);
INSERT INTO `member_login_record` VALUES (1721, 52, '2019-12-20 14:20:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1722, 50, '2019-12-20 14:20:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1723, 2, '2019-12-20 14:22:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1724, 53, '2019-12-20 14:23:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1725, 2, '2019-12-20 14:24:43', 2, 0);
INSERT INTO `member_login_record` VALUES (1726, 2, '2019-12-20 14:26:25', 2, 0);
INSERT INTO `member_login_record` VALUES (1727, 2, '2019-12-20 14:28:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1728, 2, '2019-12-20 14:28:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1729, 2, '2019-12-20 14:29:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1730, 2, '2019-12-20 14:29:20', 2, 0);
INSERT INTO `member_login_record` VALUES (1731, 2, '2019-12-20 14:32:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1732, 57, '2019-12-20 14:34:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1733, 2, '2019-12-20 14:34:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1734, 2, '2019-12-20 14:35:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1735, 113, '2019-12-20 14:35:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1736, 2, '2019-12-20 14:35:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1737, 57, '2019-12-20 14:36:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1738, 2, '2019-12-20 14:39:23', 2, 0);
INSERT INTO `member_login_record` VALUES (1739, 50, '2019-12-20 14:39:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1740, 114, '2019-12-20 14:40:32', 1, 2);
INSERT INTO `member_login_record` VALUES (1741, 50, '2019-12-20 14:44:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1742, 54, '2019-12-20 14:49:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1743, 55, '2019-12-20 14:51:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1744, 2, '2019-12-20 14:54:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1745, 50, '2019-12-20 14:57:56', 2, 0);
INSERT INTO `member_login_record` VALUES (1746, 50, '2019-12-20 14:58:48', 2, 0);
INSERT INTO `member_login_record` VALUES (1747, 83, '2019-12-20 14:59:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1748, 50, '2019-12-20 15:00:10', 2, 0);
INSERT INTO `member_login_record` VALUES (1749, 50, '2019-12-20 15:01:02', 2, 0);
INSERT INTO `member_login_record` VALUES (1750, 1, '2019-12-20 15:02:09', 1, 1);
INSERT INTO `member_login_record` VALUES (1751, 83, '2019-12-20 15:02:46', 1, 1);
INSERT INTO `member_login_record` VALUES (1752, 2, '2019-12-20 15:06:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1753, 83, '2019-12-20 15:08:22', 1, 1);
INSERT INTO `member_login_record` VALUES (1754, 114, '2019-12-20 15:10:09', 1, 2);
INSERT INTO `member_login_record` VALUES (1755, 2, '2019-12-20 15:13:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1756, 82, '2019-12-20 15:16:31', 1, 1);
INSERT INTO `member_login_record` VALUES (1757, 2, '2019-12-20 15:23:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1758, 102, '2019-12-20 15:27:43', 1, 1);
INSERT INTO `member_login_record` VALUES (1759, 100, '2019-12-20 15:31:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1760, 71, '2019-12-20 15:31:46', 1, 1);
INSERT INTO `member_login_record` VALUES (1761, 91, '2019-12-20 15:33:56', 1, 2);
INSERT INTO `member_login_record` VALUES (1762, 13, '2019-12-20 15:34:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1763, 2, '2019-12-20 15:38:59', 2, 0);
INSERT INTO `member_login_record` VALUES (1764, 35, '2019-12-20 15:45:07', 1, 1);
INSERT INTO `member_login_record` VALUES (1765, 113, '2019-12-20 15:49:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1766, 82, '2019-12-20 16:00:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1767, 106, '2019-12-20 16:01:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1768, 106, '2019-12-20 16:16:54', 1, 1);
INSERT INTO `member_login_record` VALUES (1769, 2, '2019-12-20 16:19:54', 2, 0);
INSERT INTO `member_login_record` VALUES (1770, 108, '2019-12-20 16:26:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1771, 123, '2019-12-20 16:26:51', 1, 1);
INSERT INTO `member_login_record` VALUES (1772, 99, '2019-12-20 16:28:04', 1, 1);
INSERT INTO `member_login_record` VALUES (1773, 118, '2019-12-20 16:28:24', 1, 1);
INSERT INTO `member_login_record` VALUES (1774, 99, '2019-12-20 16:28:43', 1, 1);
INSERT INTO `member_login_record` VALUES (1775, 111, '2019-12-20 16:29:42', 1, 1);
INSERT INTO `member_login_record` VALUES (1776, 112, '2019-12-20 16:35:40', 1, 1);
INSERT INTO `member_login_record` VALUES (1777, 100, '2019-12-20 16:41:31', 1, 3);
INSERT INTO `member_login_record` VALUES (1778, 111, '2019-12-20 16:43:03', 1, 3);
INSERT INTO `member_login_record` VALUES (1779, 2, '2019-12-20 16:45:16', 2, 0);
INSERT INTO `member_login_record` VALUES (1780, 1, '2019-12-20 16:48:14', 1, 1);
INSERT INTO `member_login_record` VALUES (1781, 2, '2019-12-20 16:56:23', 2, 0);
INSERT INTO `member_login_record` VALUES (1782, 105, '2019-12-20 17:02:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1783, 50, '2019-12-20 17:26:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1784, 2, '2019-12-20 17:30:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1785, 1, '2019-12-20 17:36:34', 1, 1);
INSERT INTO `member_login_record` VALUES (1786, 82, '2019-12-20 17:41:43', 1, 1);
INSERT INTO `member_login_record` VALUES (1787, 60, '2019-12-20 17:46:29', 1, 3);
INSERT INTO `member_login_record` VALUES (1788, 2, '2019-12-20 18:00:04', 2, 0);
INSERT INTO `member_login_record` VALUES (1789, 2, '2019-12-20 18:12:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1790, 91, '2019-12-20 18:13:37', 1, 3);
INSERT INTO `member_login_record` VALUES (1791, 91, '2019-12-20 18:25:09', 1, 4);
INSERT INTO `member_login_record` VALUES (1792, 80, '2019-12-20 18:33:11', 1, 4);
INSERT INTO `member_login_record` VALUES (1793, 113, '2019-12-21 10:09:27', 1, 1);
INSERT INTO `member_login_record` VALUES (1794, 13, '2019-12-21 10:29:24', 2, 0);
INSERT INTO `member_login_record` VALUES (1795, 2, '2019-12-21 10:35:49', 2, 0);
INSERT INTO `member_login_record` VALUES (1796, 59, '2019-12-21 10:45:44', 1, 1);
INSERT INTO `member_login_record` VALUES (1797, 115, '2019-12-21 10:46:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1798, 2, '2019-12-21 10:56:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1799, 59, '2019-12-21 11:02:59', 1, 1);
INSERT INTO `member_login_record` VALUES (1800, 2, '2019-12-21 11:16:08', 2, 0);
INSERT INTO `member_login_record` VALUES (1801, 2, '2019-12-21 11:30:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1802, 2, '2019-12-21 11:34:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1803, 1, '2019-12-21 12:10:01', 1, 1);
INSERT INTO `member_login_record` VALUES (1804, 111, '2019-12-21 12:27:52', 1, 1);
INSERT INTO `member_login_record` VALUES (1805, 111, '2019-12-21 12:36:20', 1, 3);
INSERT INTO `member_login_record` VALUES (1806, 1, '2019-12-21 14:21:36', 1, 4);
INSERT INTO `member_login_record` VALUES (1807, 1, '2019-12-21 14:26:38', 1, 3);
INSERT INTO `member_login_record` VALUES (1808, 113, '2019-12-21 14:31:36', 1, 1);
INSERT INTO `member_login_record` VALUES (1809, 113, '2019-12-21 14:34:45', 1, 1);
INSERT INTO `member_login_record` VALUES (1810, 52, '2019-12-21 14:35:05', 1, 1);
INSERT INTO `member_login_record` VALUES (1811, 2, '2019-12-21 14:38:03', 2, 0);
INSERT INTO `member_login_record` VALUES (1812, 1, '2019-12-21 14:58:20', 1, 1);
INSERT INTO `member_login_record` VALUES (1813, 82, '2019-12-21 14:58:23', 1, 1);
INSERT INTO `member_login_record` VALUES (1814, 111, '2019-12-21 15:00:04', 1, 1);
INSERT INTO `member_login_record` VALUES (1815, 59, '2019-12-21 15:25:58', 1, 1);
INSERT INTO `member_login_record` VALUES (1816, 52, '2019-12-21 15:32:35', 1, 4);
INSERT INTO `member_login_record` VALUES (1817, 59, '2019-12-21 15:43:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1818, 111, '2019-12-21 15:48:56', 1, 3);
INSERT INTO `member_login_record` VALUES (1819, 2, '2019-12-21 15:58:34', 2, 0);
INSERT INTO `member_login_record` VALUES (1820, 2, '2019-12-21 16:30:31', 2, 0);
INSERT INTO `member_login_record` VALUES (1821, 2, '2019-12-21 16:31:42', 2, 0);
INSERT INTO `member_login_record` VALUES (1822, 2, '2019-12-23 08:23:52', 2, 0);
INSERT INTO `member_login_record` VALUES (1823, 113, '2019-12-23 08:24:19', 1, 1);
INSERT INTO `member_login_record` VALUES (1824, 2, '2019-12-23 09:11:37', 2, 0);
INSERT INTO `member_login_record` VALUES (1825, 2, '2019-12-23 09:18:47', 2, 0);
INSERT INTO `member_login_record` VALUES (1826, 2, '2019-12-23 09:22:27', 2, 0);
INSERT INTO `member_login_record` VALUES (1827, 2, '2019-12-23 09:28:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1828, 2, '2019-12-23 09:33:46', 2, 0);
INSERT INTO `member_login_record` VALUES (1829, 2, '2019-12-23 09:36:19', 2, 0);
INSERT INTO `member_login_record` VALUES (1830, 82, '2019-12-23 09:36:54', 1, 1);
INSERT INTO `member_login_record` VALUES (1831, 13, '2019-12-23 09:44:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1832, 34, '2019-12-23 09:48:48', 2, 0);
INSERT INTO `member_login_record` VALUES (1833, 1, '2019-12-23 09:55:03', 1, 1);
INSERT INTO `member_login_record` VALUES (1834, 100, '2019-12-23 09:57:48', 1, 1);
INSERT INTO `member_login_record` VALUES (1835, 1, '2019-12-23 10:05:03', 1, 4);
INSERT INTO `member_login_record` VALUES (1836, 58, '2019-12-23 10:05:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1837, 56, '2019-12-23 10:06:14', 2, 0);
INSERT INTO `member_login_record` VALUES (1838, 13, '2019-12-23 10:06:28', 2, 0);
INSERT INTO `member_login_record` VALUES (1839, 106, '2019-12-23 10:06:47', 1, 1);
INSERT INTO `member_login_record` VALUES (1840, 114, '2019-12-23 10:06:59', 1, 4);
INSERT INTO `member_login_record` VALUES (1841, 58, '2019-12-23 10:08:07', 2, 0);
INSERT INTO `member_login_record` VALUES (1842, 58, '2019-12-23 10:09:22', 2, 0);
INSERT INTO `member_login_record` VALUES (1843, 53, '2019-12-23 10:10:36', 2, 0);
INSERT INTO `member_login_record` VALUES (1844, 58, '2019-12-23 10:11:09', 2, 0);
INSERT INTO `member_login_record` VALUES (1845, 58, '2019-12-23 10:12:30', 2, 0);
INSERT INTO `member_login_record` VALUES (1846, 58, '2019-12-23 10:13:29', 2, 0);
INSERT INTO `member_login_record` VALUES (1847, 55, '2019-12-23 10:13:40', 2, 0);
INSERT INTO `member_login_record` VALUES (1848, 2, '2019-12-23 10:13:51', 2, 0);
INSERT INTO `member_login_record` VALUES (1849, 13, '2019-12-23 10:14:15', 2, 0);
INSERT INTO `member_login_record` VALUES (1850, 2, '2019-12-23 10:14:45', 2, 0);
INSERT INTO `member_login_record` VALUES (1851, 56, '2019-12-23 10:16:17', 2, 0);
INSERT INTO `member_login_record` VALUES (1852, 58, '2019-12-23 10:16:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1853, 13, '2019-12-23 10:17:50', 2, 0);
INSERT INTO `member_login_record` VALUES (1854, 56, '2019-12-23 10:18:32', 2, 0);
INSERT INTO `member_login_record` VALUES (1855, 53, '2019-12-23 10:18:39', 2, 0);
INSERT INTO `member_login_record` VALUES (1856, 2, '2019-12-23 10:19:05', 2, 0);
INSERT INTO `member_login_record` VALUES (1857, 59, '2019-12-23 10:24:53', 2, 0);
INSERT INTO `member_login_record` VALUES (1858, 118, '2019-12-23 10:27:12', 1, 1);
INSERT INTO `member_login_record` VALUES (1859, 118, '2019-12-23 10:38:38', 1, 1);
INSERT INTO `member_login_record` VALUES (1860, 2, '2019-12-23 10:42:06', 2, 0);
INSERT INTO `member_login_record` VALUES (1861, 118, '2019-12-23 11:06:12', 1, 4);
INSERT INTO `member_login_record` VALUES (1862, 2, '2019-12-23 11:07:03', 2, 0);

-- ----------------------------
-- Table structure for sport
-- ----------------------------
DROP TABLE IF EXISTS `sport`;
CREATE TABLE `sport`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area_id` bigint(20) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sport
-- ----------------------------
INSERT INTO `sport` VALUES (6, '测试园区场次', 10, 1, '2020-06-11 00:00:00', '2020-06-11 23:59:59', '2020-06-11 14:42:39');
INSERT INTO `sport` VALUES (8, '测试园区2场次', 11, 1, '2020-06-11 00:00:00', '2020-06-12 23:59:59', '2020-06-11 17:01:43');
INSERT INTO `sport` VALUES (10, '6.12日招生场', 13, 1, '2020-06-11 00:00:00', '2020-06-13 23:59:59', '2020-06-11 17:49:33');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '键',
  `value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('evaluate_global_enable', 'true', '评论全局开关');
INSERT INTO `sys_config` VALUES ('hadoop_DFSMasterName', 'fs.defaultFS', NULL);
INSERT INTO `sys_config` VALUES ('hadoop_nameNodeURI', 'hdfs://10.18.97.150:9000/', NULL);
INSERT INTO `sys_config` VALUES ('huamengx', 'huamengxing123', 'b31c6bb381021f86fc4d8141ba6b8bdd9ea46775');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descs` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result_code` int(1) NULL DEFAULT NULL COMMENT '操作结果 0 成功  -1失败',
  `times` bigint(20) NULL DEFAULT 0 COMMENT '操作时长',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求url',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `oper_param` varchar(2555) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 242 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (2, '127.0.0.1', '删除园区', '执行成功', 0, 31, 'http://localhost:8080/dd-web/api/area/delete', 'cp', '2020-05-29 09:56:00', 1, '{\"id\":[\"5\"]}');
INSERT INTO `sys_log` VALUES (3, '127.0.0.1', '登录', '执行成功', 0, 94, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-29 15:23:20', NULL, '{\"password\":[\"123456\"],\"username\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (4, '127.0.0.1', '新增场次', '执行成功', 0, 27, 'http://localhost:8080/dd-web/api/sport/save', 'cp', '2020-05-29 15:23:45', 1, '{\"endTime\":[\"2020-06-29 16:30:30\"],\"name\":[\"场次1\"],\"startTime\":[\"2020-05-29 16:30:30\"],\"areaId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (5, '127.0.0.1', '登录', '输入的账号或密码错误', -1, 0, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-29 15:24:49', NULL, '{\"password\":[\"123456\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (6, '127.0.0.1', '登录', '输入的账号或密码错误', -1, 0, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-29 15:24:54', NULL, '{\"password\":[\"123456Aa\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (7, '127.0.0.1', '登录', '输入的账号或密码错误', -1, 0, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-29 15:24:56', NULL, '{\"password\":[\"123456Aa\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (8, '127.0.0.1', '登录', '执行成功', 0, 10, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-29 15:25:08', NULL, '{\"password\":[\"123456\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (9, '127.0.0.1', '登录', '执行成功', 0, 315, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-05-30 09:33:45', NULL, '{\"password\":[\"123456\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (10, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 09:45:01', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (11, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 09:46:42', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (12, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 09:52:39', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (13, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 10:01:01', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (14, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 10:23:01', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (15, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 10:25:07', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (16, '127.0.0.1', '新增小孩信息', '系统错误', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 10:28:02', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (17, '127.0.0.1', '新增小孩信息', '执行成功', 0, 71, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-05-30 10:35:02', 5, '{\"birth\":[\"2020-04\"],\"name\":[\"张三\"],\"parentName\":[\"张爸爸\"],\"sex\":[\"1\"],\"icon\":[\"1\"],\"id\":[\"\"],\"phone\":[\"122555555\"],\"school\":[\"德行幼儿园\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (18, '127.0.0.1', '登录', '输入的账号或密码错误', -1, 0, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-06-01 15:27:36', NULL, '{\"password\":[\"cp\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (19, '127.0.0.1', '登录', '执行成功', 0, 115, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-06-01 15:27:42', NULL, '{\"password\":[\"123456\"],\"username\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (20, '127.0.0.1', '登录', '执行成功', 0, 180, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-06-02 09:19:40', NULL, '{\"password\":[\"123456\"],\"username\":[\"用户2\"]}');
INSERT INTO `sys_log` VALUES (21, '127.0.0.1', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-06-02 09:28:34', 5, '{\"balance\":[\"6.3\"],\"birth\":[\"1995-06\"],\"coordinate\":[\"5.5\"],\"flexibility\":[\"11.2\"],\"height\":[\"117.0\"],\"legs\":[\"112\"],\"name\":[\"明明\"],\"parentName\":[\"刘明明\"],\"pass\":[\"7\"],\"phone\":[\"18011733974\"],\"racket\":[\"92\"],\"school\":[\"华蒙星幼儿园\"],\"sensitives\":[\"6.2\"],\"sex\":[\"1\"],\"shoot\":[\"7\"],\"szLimb\":[\"8.5\"],\"weight\":[\"20.1\"],\"FHeight\":[\"180.0\"],\"MHeight\":[\"165.3\"],\"icon\":[\"1\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (22, '127.0.0.1', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-06-02 09:28:56', 5, '{\"balance\":[\"6.3\"],\"birth\":[\"2005-06\"],\"coordinate\":[\"5.5\"],\"flexibility\":[\"11.2\"],\"height\":[\"117.0\"],\"legs\":[\"112\"],\"name\":[\"明明\"],\"parentName\":[\"刘明明\"],\"pass\":[\"7\"],\"phone\":[\"18011733974\"],\"racket\":[\"92\"],\"school\":[\"华蒙星幼儿园\"],\"sensitives\":[\"6.2\"],\"sex\":[\"1\"],\"shoot\":[\"7\"],\"szLimb\":[\"8.5\"],\"weight\":[\"20.1\"],\"FHeight\":[\"180.0\"],\"MHeight\":[\"165.3\"],\"icon\":[\"1\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (23, '127.0.0.1', '新增小孩信息', '执行成功', 0, 34, 'http://localhost:8080/dd-web/api/item/save', '用户2', '2020-06-02 09:29:06', 5, '{\"balance\":[\"6.3\"],\"birth\":[\"2015-06\"],\"coordinate\":[\"5.5\"],\"flexibility\":[\"11.2\"],\"height\":[\"117.0\"],\"legs\":[\"112\"],\"name\":[\"明明\"],\"parentName\":[\"刘明明\"],\"pass\":[\"7\"],\"phone\":[\"18011733974\"],\"racket\":[\"92\"],\"school\":[\"华蒙星幼儿园\"],\"sensitives\":[\"6.2\"],\"sex\":[\"1\"],\"shoot\":[\"7\"],\"szLimb\":[\"8.5\"],\"weight\":[\"20.1\"],\"FHeight\":[\"180.0\"],\"MHeight\":[\"165.3\"],\"icon\":[\"1\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (24, '121.10.41.149', '登录', '执行成功', 0, 576, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-05 14:16:23', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (25, '121.10.41.149', '用户导出', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:32:03', 1, '{\"name\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (26, '121.10.41.149', '用户导出', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:32:11', 1, '{\"name\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (27, '121.10.41.149', '用户导出', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:32:30', 1, '{}');
INSERT INTO `sys_log` VALUES (28, '121.10.41.149', '用户导出', '执行成功', 0, 216, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:32:43', 1, '{\"createBy\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (29, '121.10.41.149', '用户导出', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:33:40', 1, '{\"createBy\":[\"\"]}');
INSERT INTO `sys_log` VALUES (30, '121.10.41.149', '用户导出', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:33:55', 1, '{}');
INSERT INTO `sys_log` VALUES (31, '121.10.41.149', '用户导出', '执行成功', 0, 110, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:38:41', 1, '{}');
INSERT INTO `sys_log` VALUES (32, '121.10.41.149', '用户导出', '执行成功', 0, 35, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:39:29', 1, '{\"createBy\":[\"cp\"]}');
INSERT INTO `sys_log` VALUES (33, '121.10.41.149', '用户导出', '执行成功', 0, 85, 'http://114.55.104.155:8080/api/sysLog/export', 'admin', '2020-06-05 15:39:45', 1, '{\"createBy\":[\"\"]}');
INSERT INTO `sys_log` VALUES (34, '121.10.41.148', '登录', '执行成功', 0, 52, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-05 17:13:14', NULL, '{\"password\":[\"123456\"],\"username\":[\"录入员1\"]}');
INSERT INTO `sys_log` VALUES (35, '121.10.41.148', '导入', '执行成功', 0, 315, 'http://114.55.104.155:8080/api/item/import', '录入员1', '2020-06-05 17:14:12', 5, '{}');
INSERT INTO `sys_log` VALUES (36, '113.67.74.213', '登录', '执行成功', 0, 133, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-08 09:56:03', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (37, '113.67.74.213', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-08 10:08:44', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (38, '132.126.1.144', '登录', '该账号不存在', -1, 0, 'http://132.126.1.169:8080/dd-web/api/member/login', NULL, '2020-06-09 11:37:52', NULL, '{\"username\":[\"cp\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (39, '132.126.1.144', '登录', '该账号不存在', -1, 0, 'http://132.126.1.169:8080/dd-web/api/member/login', NULL, '2020-06-09 11:37:59', NULL, '{\"username\":[\"cp\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (40, '132.126.1.144', '登录', '执行成功', 0, 1651, 'http://132.126.1.169:8080/dd-web/api/member/login', NULL, '2020-06-09 11:38:46', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (41, '121.10.41.149', '登录', '执行成功', 0, 50, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 14:22:37', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (42, '132.126.1.144', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://132.126.1.169:8080/dd-web/api/item/save', '录入员1', '2020-06-09 14:49:40', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birthday\":[\"2020-06-30\"],\"parentName\":[\"1\"],\"phone\":[\"1\"],\"ibm\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"],\"birth\":[\"2020-06\"]}');
INSERT INTO `sys_log` VALUES (43, '132.126.1.144', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://132.126.1.169:8080/dd-web/api/item/save', '录入员1', '2020-06-09 14:50:06', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birthday\":[\"2020-06-30\"],\"parentName\":[\"1\"],\"phone\":[\"1\"],\"ibm\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"],\"birth\":[\"2005-06\"]}');
INSERT INTO `sys_log` VALUES (44, '132.126.1.144', '新增小孩信息', '系统错误', -1, 0, 'http://132.126.1.169:8080/dd-web/api/item/save', '录入员1', '2020-06-09 14:53:20', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birthday\":[\"2020-06-30\"],\"parentName\":[\"1\"],\"phone\":[\"1\"],\"ibm\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"],\"birth\":[\"2015-10\"]}');
INSERT INTO `sys_log` VALUES (45, '132.126.1.144', '新增小孩信息', '系统错误', -1, 0, 'http://132.126.1.169:8080/dd-web/api/item/save', '录入员1', '2020-06-09 14:53:32', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birthday\":[\"2020-06-30\"],\"parentName\":[\"1\"],\"phone\":[\"1\"],\"ibm\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"],\"birth\":[\"2015-10\"]}');
INSERT INTO `sys_log` VALUES (46, '121.10.41.149', '新增小孩信息', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/item/save', '录入员1', '2020-06-09 15:00:54', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2016-06\"],\"parentName\":[\"1\"],\"phone\":[\"1\"],\"ibm\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (47, '121.10.41.149', '新增小孩信息', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/item/save', '录入员1', '2020-06-09 15:11:11', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2016-06\"],\"parentName\":[\"1\"],\"phone\":[\"13333333333\"],\"ibm\":[\"16.21\"],\"legs\":[\"113\"],\"szLimb\":[\"8.5\"],\"coordinate\":[\"5.2\"],\"balance\":[\"6.1\"],\"flexibility\":[\"11.3\"],\"sensitives\":[\"6.4\"],\"racket\":[\"92\"],\"pass\":[\"7\"],\"shoot\":[\"7\"]}');
INSERT INTO `sys_log` VALUES (48, '121.10.41.148', '登录', '执行成功', 0, 72, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 15:16:07', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (49, '121.10.41.149', '新增小孩信息', '系统错误', -1, 0, 'http://114.55.104.155:8080/api/item/save', '录入员1', '2020-06-09 15:18:23', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2016-06\"],\"parentName\":[\"1\"],\"phone\":[\"13333333333\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (50, '121.10.41.149', '新增小孩信息', '执行成功', 0, 23, 'http://114.55.104.155:8080/api/item/save', '录入员1', '2020-06-09 15:21:29', 5, '{\"balance\":[\"1\"],\"birth\":[\"2015-06\"],\"coordinate\":[\"1\"],\"flexibility\":[\"1\"],\"height\":[\"1\"],\"legs\":[\"1\"],\"name\":[\"1\"],\"parentName\":[\"1\"],\"pass\":[\"1\"],\"phone\":[\"13422023329\"],\"racket\":[\"1\"],\"school\":[\"1\"],\"sensitives\":[\"1\"],\"sex\":[\"1\"],\"shoot\":[\"1\"],\"szLimb\":[\"1\"],\"weight\":[\"1\"],\"FHeight\":[\"1\"],\"MHeight\":[\"1\"],\"sportId\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (51, '121.10.41.149', '新增小孩信息', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/item/save', '录入员1', '2020-06-09 15:29:27', 5, '{\"sportId\":[\"1\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2016-06\"],\"parentName\":[\"1\"],\"phone\":[\"13333333333\"],\"height\":[\"1\"],\"weight\":[\"1\"],\"legs\":[\"1\"],\"szLimb\":[\"1\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (52, '121.10.41.149', '导入', '执行成功', 0, 979, 'http://114.55.104.155:8080/api/item/import', '录入员1', '2020-06-09 15:55:50', 5, '{}');
INSERT INTO `sys_log` VALUES (53, '121.10.41.149', '导入', '执行成功', 0, 84, 'http://114.55.104.155:8080/api/item/import', '录入员1', '2020-06-09 15:58:56', 5, '{}');
INSERT INTO `sys_log` VALUES (54, '121.10.41.149', '修改密码', '执行成功', 0, 53, 'http://114.55.104.155:8080/api/member/updatePassWord', '录入员1', '2020-06-09 17:19:52', 5, '{\"id\":[\"5\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (55, '121.10.41.149', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 17:20:17', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (56, '121.10.41.149', '登录', '执行成功', 0, 48, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 17:20:21', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (57, '121.10.41.149', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 17:24:00', NULL, '{\"username\":[\"admin\"],\"password\":[\"1234356\"]}');
INSERT INTO `sys_log` VALUES (58, '121.10.41.149', '登录', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 17:24:06', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (59, '61.144.159.146', '登录', '执行成功', 0, 75, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-09 22:51:18', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (60, '121.10.41.149', '登录', '执行成功', 0, 248, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 09:19:38', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (61, '121.10.41.149', '登录', '执行成功', 0, 318, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 11:00:40', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (62, '121.10.41.149', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 11:11:21', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (63, '121.10.41.149', '登录', '执行成功', 0, 19, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 14:59:29', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (64, '121.10.41.149', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:03:48', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (65, '121.10.41.148', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:04:47', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (66, '121.10.41.148', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:22:28', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (67, '121.10.41.148', '登录', '执行成功', 0, 74, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:23:15', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (68, '121.10.41.148', '登录', '执行成功', 0, 20, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:23:51', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (69, '121.10.41.149', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:28:03', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (70, '121.10.41.149', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:29:01', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (71, '14.24.128.33', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:31:47', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (72, '121.10.41.148', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:32:00', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe1/3\"]}');
INSERT INTO `sys_log` VALUES (73, '121.10.41.148', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:32:15', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe1/3\"]}');
INSERT INTO `sys_log` VALUES (74, '121.10.41.148', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:32:25', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (75, '59.42.236.207', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:42:02', NULL, '{\"username\":[\"1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (76, '59.42.236.207', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:42:16', NULL, '{\"username\":[\"1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (77, '59.42.236.207', '登录', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:43:25', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (78, '14.29.65.66', '登录', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:44:21', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (79, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:54:58', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (80, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:55:19', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (81, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:56:18', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (82, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 15:57:23', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (83, '183.50.98.76', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:00:49', NULL, '{\"username\":[\"15812313444\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (84, '183.50.98.76', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:00:52', NULL, '{\"username\":[\"15812313444\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (85, '183.50.98.76', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:01:06', NULL, '{\"username\":[\"13560521892\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (86, '183.50.98.76', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:01:09', NULL, '{\"username\":[\"13560521892\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (87, '59.42.236.207', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:05:34', NULL, '{\"username\":[\"18026330772\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (88, '121.10.41.148', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:19:49', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (89, '14.29.65.66', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '录入员1', '2020-06-10 16:20:59', 5, '{\"name\":[\"蓝蝶\"]}');
INSERT INTO `sys_log` VALUES (90, '14.29.65.66', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '录入员1', '2020-06-10 16:21:00', 5, '{\"name\":[\"蓝蝶\"]}');
INSERT INTO `sys_log` VALUES (91, '14.29.65.66', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '录入员1', '2020-06-10 16:21:01', 5, '{\"name\":[\"蓝蝶\"]}');
INSERT INTO `sys_log` VALUES (92, '121.10.41.148', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:21:07', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (93, '14.29.65.66', '登录', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:25:10', NULL, '{\"username\":[\"admin \"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (94, '14.29.65.66', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:40:36', NULL, '{\"username\":[\"damin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (95, '14.29.65.66', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:40:39', NULL, '{\"username\":[\"damin\"],\"password\":[\"12345\"]}');
INSERT INTO `sys_log` VALUES (96, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:42:04', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (97, '106.127.242.172', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 16:42:19', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (98, '61.144.159.149', '登录', '执行成功', 0, 106, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-10 23:55:59', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (99, '121.10.41.149', '登录', '执行成功', 0, 88, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 09:19:15', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (100, '121.10.41.148', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 10:22:27', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (101, '121.10.41.149', '登录', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 10:55:32', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (102, '121.10.41.149', '新增小孩信息', '超级管理员不能录入', -1, 0, 'http://114.55.104.155:8080/api/item/save', 'admin', '2020-06-11 11:12:02', 1, '{\"sportId\":[\"1\"],\"name\":[\"启明\"],\"sex\":[\"1\"],\"school\":[\"启明小学\"],\"birth\":[\"2017-06\"],\"parentName\":[\"启明\"],\"phone\":[\"13333333333\"],\"height\":[\"88\"],\"weight\":[\"28\"],\"FHeight\":[\"180\"],\"MHeight\":[\"160\"],\"legs\":[\"120\"],\"szLimb\":[\"250\"],\"coordinate\":[\"22\"],\"balance\":[\"25\"],\"flexibility\":[\"50\"],\"sensitives\":[\"18\"],\"racket\":[\"55\"],\"pass\":[\"50\"],\"shoot\":[\"10\"]}');
INSERT INTO `sys_log` VALUES (103, '121.10.41.149', '新增小孩信息', '超级管理员不能录入', -1, 0, 'http://114.55.104.155:8080/api/item/save', 'admin', '2020-06-11 11:12:10', 1, '{\"sportId\":[\"1\"],\"name\":[\"启明\"],\"sex\":[\"1\"],\"school\":[\"启明小学\"],\"birth\":[\"2017-06\"],\"parentName\":[\"启明\"],\"phone\":[\"13333333333\"],\"height\":[\"88\"],\"weight\":[\"28\"],\"FHeight\":[\"180\"],\"MHeight\":[\"160\"],\"legs\":[\"120\"],\"szLimb\":[\"250\"],\"coordinate\":[\"22\"],\"balance\":[\"25\"],\"flexibility\":[\"50\"],\"sensitives\":[\"18\"],\"racket\":[\"55\"],\"pass\":[\"50\"],\"shoot\":[\"10\"]}');
INSERT INTO `sys_log` VALUES (104, '121.10.41.149', '新增小孩信息', '超级管理员不能录入', -1, 0, 'http://114.55.104.155:8080/api/item/save', 'admin', '2020-06-11 11:12:16', 1, '{\"sportId\":[\"1\"],\"name\":[\"启明\"],\"sex\":[\"1\"],\"school\":[\"启明小学\"],\"birth\":[\"2017-06\"],\"parentName\":[\"启明\"],\"phone\":[\"13333333333\"],\"height\":[\"88\"],\"weight\":[\"28\"],\"FHeight\":[\"180\"],\"MHeight\":[\"160\"],\"legs\":[\"120\"],\"szLimb\":[\"250\"],\"coordinate\":[\"22\"],\"balance\":[\"25\"],\"flexibility\":[\"50\"],\"sensitives\":[\"18\"],\"racket\":[\"55\"],\"pass\":[\"50\"],\"shoot\":[\"10\"]}');
INSERT INTO `sys_log` VALUES (105, '121.10.41.148', '登录', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 11:19:25', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (106, '121.10.41.148', '新增园区', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/area/save', 'admin', '2020-06-11 11:19:40', 1, '{\"name\":[\"测试园区\"]}');
INSERT INTO `sys_log` VALUES (107, '121.10.41.148', '新增用户', '执行成功', 0, 50, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:20:11', 1, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"],\"phone\":[\"18000000000\"],\"areaId\":[\"10\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (108, '121.10.41.149', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 11:21:24', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (109, '121.10.41.149', '新增用户', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:21:51', 1, '{\"username\":[\"cs\"],\"password\":[\"qwe123\"],\"phone\":[\"13333333333\"],\"areaId\":[\"10\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (110, '121.10.41.148', '新增用户', '该园区已存在管理员', -1, 0, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:21:55', 1, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"],\"phone\":[\"15000000000\"],\"areaId\":[\"10\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (111, '121.10.41.148', '新增用户', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:22:45', 1, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"],\"phone\":[\"13200000000\"],\"areaId\":[\"10\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (112, '121.10.41.149', '新增用户', '该园区已存在管理员', -1, 0, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:23:21', 1, '{\"username\":[\"cs2\"],\"password\":[\"qwe123\"],\"phone\":[\"13333333333\"],\"areaId\":[\"10\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (113, '121.10.41.149', '新增用户', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/save', 'admin', '2020-06-11 11:23:27', 1, '{\"username\":[\"cs2\"],\"password\":[\"qwe123\"],\"phone\":[\"13333333333\"],\"areaId\":[\"10\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (114, '127.0.0.1', '登录', '执行成功', 0, 303, 'http://localhost:8080/dd-web/api/member/login', NULL, '2020-06-11 12:25:53', NULL, '{\"password\":[\"123456\"],\"username\":[\"测试园区园长\"]}');
INSERT INTO `sys_log` VALUES (115, '127.0.0.1', '新增场次', '执行成功', 0, 138, 'http://localhost:8080/dd-web/api/sport/save', '测试园区园长', '2020-06-11 12:27:07', 6, '{\"endTimes\":[\"2020-06-11\"],\"name\":[\"测试园区场次\"],\"startTimes\":[\"2020-06-11\"]}');
INSERT INTO `sys_log` VALUES (116, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:39:04', NULL, '{\"username\":[\"15289606706\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (117, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:39:43', NULL, '{\"username\":[\"18878258279\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (118, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:50:38', NULL, '{\"username\":[\"18077280189\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (119, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:51:35', NULL, '{\"username\":[\"18077280189\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (120, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:57:23', NULL, '{\"username\":[\"18077280189\"],\"password\":[\"12345678\"]}');
INSERT INTO `sys_log` VALUES (121, '171.109.167.83', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 12:57:37', NULL, '{\"username\":[\"18077280189\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (122, '121.10.41.149', '新增场次', '只有园长才能新建场次', -1, 0, 'http://114.55.104.155:8080/api/sport/save', 'admin', '2020-06-11 14:14:34', 1, '{\"name\":[\"测试\"],\"startTime\":[\"2020-06-29\"],\"endTime\":[\"2020-06-30\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-12\"]}');
INSERT INTO `sys_log` VALUES (123, '121.10.41.149', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:38:43', NULL, '{\"username\":[\"录入员1\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (124, '121.10.41.149', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:38:50', NULL, '{\"username\":[\"admin\"],\"password\":[\"qwe123\"]}');
INSERT INTO `sys_log` VALUES (125, '121.10.41.148', '新增场次', '只有园长才能新建场次', -1, 0, 'http://114.55.104.155:8080/api/sport/save', 'admin', '2020-06-11 14:42:12', 1, '{\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-11\"],\"name\":[\"测试园区\"]}');
INSERT INTO `sys_log` VALUES (126, '121.10.41.148', '登录', '执行成功', 0, 69, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:42:24', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (127, '121.10.41.148', '新增场次', '执行成功', 0, 120, 'http://114.55.104.155:8080/api/sport/save', '测试园区园长', '2020-06-11 14:42:39', 6, '{\"name\":[\"测试园区场次\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-11\"]}');
INSERT INTO `sys_log` VALUES (128, '121.10.41.149', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:44:07', NULL, '{\"username\":[\"测试园区区长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (129, '121.10.41.149', '登录', '执行成功', 0, 21, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:44:24', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (130, '121.10.41.149', '新增场次', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/sport/save', '测试园区园长', '2020-06-11 14:45:21', 6, '{\"name\":[\"测试\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-12\"]}');
INSERT INTO `sys_log` VALUES (131, '121.10.41.149', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 14:47:21', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (132, '106.17.47.46', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:16:52', NULL, '{\"username\":[\"15603064909\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (133, '106.17.47.46', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:16:56', NULL, '{\"username\":[\"15603064909\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (134, '106.17.47.46', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:16:57', NULL, '{\"username\":[\"15603064909\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (135, '106.17.47.46', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:17:07', NULL, '{\"username\":[\"15603064909\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (136, '121.10.41.148', '登录', '执行成功', 0, 68, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:20:15', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (137, '121.10.41.148', '登录', '执行成功', 0, 20, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:26:07', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (138, '121.10.41.148', '新增小孩信息', '执行成功', 0, 88, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 15:28:26', 8, '{\"sportId\":[\"6\"],\"name\":[\"熊熊\"],\"sex\":[\"1\"],\"school\":[\"幼儿园\"],\"birth\":[\"2015-07\"],\"parentName\":[\"熊爸\"],\"phone\":[\"13666666666\"],\"height\":[\"117.3\"],\"weight\":[\"22.6\"],\"FHeight\":[\"183.6\"],\"MHeight\":[\"165.1\"],\"legs\":[\"113\"],\"szLimb\":[\"8.5\"],\"coordinate\":[\"5.2\"],\"balance\":[\"6.1\"],\"flexibility\":[\"11.3\"],\"sensitives\":[\"6.5\"],\"racket\":[\"92\"],\"pass\":[\"7\"],\"shoot\":[\"7\"]}');
INSERT INTO `sys_log` VALUES (139, '121.10.41.148', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:29:02', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (140, '116.252.162.110', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:29:38', NULL, '{\"username\":[\"14745674897\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (141, '116.252.162.110', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:29:53', NULL, '{\"username\":[\"18341843432\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (142, '116.252.162.110', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 15:29:54', NULL, '{\"username\":[\"18341843432\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (143, '121.10.41.149', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:19:02', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (144, '59.42.236.207', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:23:21', NULL, '{\"username\":[\"admin\"],\"password\":[\"admin\"]}');
INSERT INTO `sys_log` VALUES (145, '121.10.41.148', '登录', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:29:26', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (146, '121.10.41.148', '新增小孩信息', '执行成功', 0, 22, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 16:31:02', 8, '{\"sportId\":[\"6\"],\"name\":[\"小赵\"],\"sex\":[\"2\"],\"school\":[\"幼儿园\"],\"birth\":[\"2016-02\"],\"parentName\":[\"赵赵\"],\"phone\":[\"19633333333\"],\"height\":[\"113.2\"],\"weight\":[\"21.2\"],\"FHeight\":[\"179.2\"],\"MHeight\":[\"164.3\"],\"legs\":[\"105\"],\"szLimb\":[\"7\"],\"coordinate\":[\"5.2\"],\"balance\":[\"5.9\"],\"flexibility\":[\"12.3\"],\"sensitives\":[\"6.3\"],\"racket\":[\"90\"],\"pass\":[\"6\"],\"shoot\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (147, '59.42.236.207', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:33:46', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (148, '171.109.180.201', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:35:04', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (149, '171.109.180.201', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:35:20', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (150, '121.10.41.148', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:43:13', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (151, '121.10.41.148', '修改密码', '执行成功', 0, 20, 'http://114.55.104.155:8080/api/member/updatePassWord', 'admin', '2020-06-11 16:43:26', 1, '{\"id\":[\"1\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (152, '121.10.41.148', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:44:39', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (153, '59.42.236.207', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 16:47:07', 8, '{\"sportId\":[\"6\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2020-06\"],\"parentName\":[\"10\"],\"phone\":[\"10\"],\"height\":[\"100\"],\"weight\":[\"50\"],\"FHeight\":[\"50\"],\"MHeight\":[\"50\"],\"legs\":[\"50\"],\"szLimb\":[\"50\"],\"coordinate\":[\"50\"],\"balance\":[\"50\"],\"flexibility\":[\"50\"],\"sensitives\":[\"50\"],\"racket\":[\"50\"],\"pass\":[\"50\"],\"shoot\":[\"50\"]}');
INSERT INTO `sys_log` VALUES (154, '59.42.236.207', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 16:48:07', 8, '{\"sportId\":[\"6\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2009-12\"],\"parentName\":[\"10\"],\"phone\":[\"10\"],\"height\":[\"100\"],\"weight\":[\"50\"],\"FHeight\":[\"50\"],\"MHeight\":[\"50\"],\"legs\":[\"50\"],\"szLimb\":[\"50\"],\"coordinate\":[\"50\"],\"balance\":[\"50\"],\"flexibility\":[\"50\"],\"sensitives\":[\"50\"],\"racket\":[\"50\"],\"pass\":[\"50\"],\"shoot\":[\"50\"]}');
INSERT INTO `sys_log` VALUES (155, '59.42.236.207', '新增小孩信息', '测试年龄不符合', -1, 0, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 16:48:28', 8, '{\"sportId\":[\"6\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2012-03\"],\"parentName\":[\"10\"],\"phone\":[\"10\"],\"height\":[\"100\"],\"weight\":[\"50\"],\"FHeight\":[\"50\"],\"MHeight\":[\"50\"],\"legs\":[\"50\"],\"szLimb\":[\"50\"],\"coordinate\":[\"50\"],\"balance\":[\"50\"],\"flexibility\":[\"50\"],\"sensitives\":[\"50\"],\"racket\":[\"50\"],\"pass\":[\"50\"],\"shoot\":[\"50\"]}');
INSERT INTO `sys_log` VALUES (156, '59.42.236.207', '新增小孩信息', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 16:48:48', 8, '{\"sportId\":[\"6\"],\"name\":[\"1\"],\"sex\":[\"1\"],\"school\":[\"1\"],\"birth\":[\"2016-03\"],\"parentName\":[\"10\"],\"phone\":[\"10\"],\"height\":[\"100\"],\"weight\":[\"50\"],\"FHeight\":[\"50\"],\"MHeight\":[\"50\"],\"legs\":[\"50\"],\"szLimb\":[\"50\"],\"coordinate\":[\"50\"],\"balance\":[\"50\"],\"flexibility\":[\"50\"],\"sensitives\":[\"50\"],\"racket\":[\"50\"],\"pass\":[\"50\"],\"shoot\":[\"50\"]}');
INSERT INTO `sys_log` VALUES (157, '171.109.180.201', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:52:49', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (158, '121.10.41.148', '登录', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:57:43', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (159, '121.10.41.148', '登录', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 16:59:39', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (160, '121.10.41.148', '新增场次', '只有园长才能新建场次', -1, 0, 'http://114.55.104.155:8080/api/sport/save', 'huamengx', '2020-06-11 16:59:57', 1, '{\"name\":[\"测试园区2\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-12\"]}');
INSERT INTO `sys_log` VALUES (161, '121.10.41.148', '新增园区', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/area/save', 'huamengx', '2020-06-11 17:00:10', 1, '{\"name\":[\"测试园区2\"]}');
INSERT INTO `sys_log` VALUES (162, '121.10.41.148', '新增用户', '执行成功', 0, 39, 'http://114.55.104.155:8080/api/member/save', 'huamengx', '2020-06-11 17:00:54', 1, '{\"username\":[\"测试园区2园长\"],\"password\":[\"123456\"],\"phone\":[\"14699999999\"],\"areaId\":[\"11\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (163, '121.10.41.148', '新增用户', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/save', 'huamengx', '2020-06-11 17:01:18', 1, '{\"username\":[\"测试园区2录入员\"],\"password\":[\"123456\"],\"phone\":[\"14699999999\"],\"areaId\":[\"11\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (164, '121.10.41.148', '登录', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:01:28', NULL, '{\"username\":[\"测试园区2园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (165, '121.10.41.148', '新增场次', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/sport/save', '测试园区2园长', '2020-06-11 17:01:43', 10, '{\"name\":[\"测试园区2场次\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-12\"]}');
INSERT INTO `sys_log` VALUES (166, '121.10.41.148', '新增小孩信息', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/item/save', '测试园区2园长', '2020-06-11 17:02:54', 10, '{\"sportId\":[\"8\"],\"name\":[\"张三\"],\"sex\":[\"1\"],\"school\":[\"小学\"],\"birth\":[\"2017-03\"],\"parentName\":[\"崽崽\"],\"phone\":[\"18733333333\"],\"height\":[\"110.3\"],\"weight\":[\"19.2\"],\"FHeight\":[\"183.3\"],\"MHeight\":[\"164.5\"],\"racket\":[\"90\"],\"pass\":[\"6\"],\"shoot\":[\"6\"],\"sensitives\":[\"6.1\"],\"flexibility\":[\"7\"],\"balance\":[\"7\"],\"coordinate\":[\"7\"],\"szLimb\":[\"7\"],\"legs\":[\"7\"]}');
INSERT INTO `sys_log` VALUES (167, '121.10.41.148', '用户导出', '执行成功', 0, 50, 'http://114.55.104.155:8080/api/member/export', '测试园区2园长', '2020-06-11 17:03:33', 10, '{}');
INSERT INTO `sys_log` VALUES (168, '121.10.41.149', '登录', '执行成功', 0, 10, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:05:53', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (169, '121.10.41.148', '用户导出', '执行成功', 0, 47, 'http://114.55.104.155:8080/api/member/export', '测试园区2园长', '2020-06-11 17:08:52', 10, '{}');
INSERT INTO `sys_log` VALUES (170, '121.10.41.148', '用户导出', '执行成功', 0, 47, 'http://114.55.104.155:8080/api/member/export', '测试园区2园长', '2020-06-11 17:09:01', 10, '{}');
INSERT INTO `sys_log` VALUES (171, '121.10.41.148', '登录', '执行成功', 0, 76, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:17:46', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (172, '121.10.41.148', '新增园区', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/area/save', 'huamengx', '2020-06-11 17:23:22', 1, '{\"name\":[\"343\"]}');
INSERT INTO `sys_log` VALUES (173, '121.10.41.148', '删除园区', '执行成功', 0, 24, 'http://114.55.104.155:8080/api/area/delete', 'huamengx', '2020-06-11 17:23:27', 1, '{\"id\":[\"12\"]}');
INSERT INTO `sys_log` VALUES (174, '121.10.41.148', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:24:43', NULL, '{\"username\":[\"测试园区2园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (175, '121.10.41.148', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '测试园区2园长', '2020-06-11 17:24:47', 10, '{\"name\":[\"wr\"]}');
INSERT INTO `sys_log` VALUES (176, '116.21.15.126', '登录', '执行成功', 0, 144, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:37:29', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (177, '121.10.41.148', '登录', '执行成功', 0, 25, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:37:51', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (178, '121.10.41.148', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:38:19', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (179, '116.21.15.126', '新增园区', '执行成功', 0, 11, 'http://114.55.104.155:8080/api/area/save', 'huamengx', '2020-06-11 17:43:06', 1, '{\"name\":[\"华蒙星第一幼儿园\"]}');
INSERT INTO `sys_log` VALUES (180, '116.21.15.126', '新增用户', '执行成功', 0, 47, 'http://114.55.104.155:8080/api/member/save', 'huamengx', '2020-06-11 17:44:04', 1, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"],\"phone\":[\"12313131313\"],\"areaId\":[\"13\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (181, '116.21.15.126', '新增用户', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/save', 'huamengx', '2020-06-11 17:44:52', 1, '{\"username\":[\"华蒙星老师\"],\"password\":[\"123\"],\"phone\":[\"12312121212\"],\"areaId\":[\"13\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (182, '116.21.15.126', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:45:40', NULL, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (183, '116.21.15.126', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '华蒙星第一园长', '2020-06-11 17:46:08', 12, '{\"name\":[\"华蒙星测试园\"]}');
INSERT INTO `sys_log` VALUES (184, '116.21.15.126', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '华蒙星第一园长', '2020-06-11 17:46:09', 12, '{\"name\":[\"华蒙星测试园\"]}');
INSERT INTO `sys_log` VALUES (185, '116.21.15.126', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '华蒙星第一园长', '2020-06-11 17:46:11', 12, '{\"name\":[\"华蒙星测试园\"]}');
INSERT INTO `sys_log` VALUES (186, '116.21.15.126', '新增园区', '暂无权限', -1, 0, 'http://114.55.104.155:8080/api/area/save', '华蒙星第一园长', '2020-06-11 17:46:18', 12, '{\"name\":[\"华蒙星测试园\"]}');
INSERT INTO `sys_log` VALUES (187, '121.10.41.149', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:48:38', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengx123\"]}');
INSERT INTO `sys_log` VALUES (188, '121.10.41.149', '登录', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:48:45', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (189, '116.21.15.126', '新增场次', '执行成功', 0, 22, 'http://114.55.104.155:8080/api/sport/save', '华蒙星第一园长', '2020-06-11 17:49:32', 12, '{\"name\":[\"6.12日招生场\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-13\"]}');
INSERT INTO `sys_log` VALUES (190, '116.21.15.126', '新增场次', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/sport/save', '华蒙星第一园长', '2020-06-11 17:49:33', 12, '{\"name\":[\"6.12日招生场\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-13\"]}');
INSERT INTO `sys_log` VALUES (191, '121.10.41.149', '登录', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 17:50:50', NULL, '{\"username\":[\"测试园区2园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (192, '116.21.15.126', '新增报告信息', '执行成功', 0, 138, 'http://114.55.104.155:8080/api/item/save', '华蒙星第一园长', '2020-06-11 17:55:02', 12, '{\"sportId\":[\"10\"],\"name\":[\"李叉叉\"],\"sex\":[\"1\"],\"school\":[\"华蒙星第一幼儿园园园园\"],\"birth\":[\"2017-06\"],\"parentName\":[\"李某某\"],\"phone\":[\"13923232323\"],\"height\":[\"130\"],\"weight\":[\"30\"],\"FHeight\":[\"170\"],\"MHeight\":[\"160\"],\"legs\":[\"90\"],\"szLimb\":[\"3\"],\"coordinate\":[\"10\"],\"balance\":[\"30\"],\"flexibility\":[\"50\"],\"sensitives\":[\"50\"],\"racket\":[\"80\"],\"pass\":[\"80\"],\"shoot\":[\"30\"]}');
INSERT INTO `sys_log` VALUES (193, '121.10.41.149', '公众号获取报告', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/item/getData', '测试园区录入员', '2020-06-11 18:03:13', 8, '{\"sportId\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (194, '121.10.41.148', '登录', '执行成功', 0, 629, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 18:15:50', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (195, '121.10.41.148', '登录', '执行成功', 0, 18, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 18:16:29', NULL, '{\"username\":[\"测试园区2园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (196, '121.10.41.148', '新增场次', '该场次名称已存在', -1, 0, 'http://114.55.104.155:8080/api/sport/save', '测试园区2园长', '2020-06-11 18:16:36', 10, '{\"name\":[\"6.12日招生场\"],\"startTimes\":[\"2020-06-11\"],\"endTimes\":[\"2020-06-11\"]}');
INSERT INTO `sys_log` VALUES (197, '61.144.159.149', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 21:53:28', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (198, '61.144.159.149', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 21:54:04', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (199, '61.144.159.149', '公众号获取报告', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/item/getData', '测试园区录入员', '2020-06-11 21:54:56', 8, '{\"sportId\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (200, '61.144.159.65', '新增报告信息', '执行成功', 0, 63, 'http://114.55.104.155:8080/api/item/save', '测试园区录入员', '2020-06-11 21:59:23', 8, '{\"school\":[\"测试园区\"],\"sportId\":[\"6\"],\"name\":[\"启明\"],\"sex\":[\"1\"],\"birth\":[\"2017-06\"],\"parentName\":[\"启明\"],\"phone\":[\"13333333333\"],\"height\":[\"111\"],\"weight\":[\"111\"],\"FHeight\":[\"111\"],\"MHeight\":[\"111\"],\"legs\":[\"111\"],\"szLimb\":[\"111\"],\"coordinate\":[\"1\"],\"balance\":[\"1\"],\"flexibility\":[\"1\"],\"sensitives\":[\"1\"],\"racket\":[\"1\"],\"pass\":[\"1\"],\"shoot\":[\"1\"]}');
INSERT INTO `sys_log` VALUES (201, '106.127.89.232', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 22:59:35', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (202, '106.127.89.232', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 22:59:36', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (203, '106.127.89.232', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 22:59:37', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (204, '106.127.89.232', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-11 22:59:41', NULL, '{\"username\":[\"15918876366\"],\"password\":[\"88888888\"]}');
INSERT INTO `sys_log` VALUES (205, '116.22.203.142', '登录', '执行成功', 0, 29, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:01:49', NULL, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (206, '116.22.203.142', '登录', '输入的账号或密码错误', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:03:02', NULL, '{\"username\":[\"华蒙星老师\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (207, '116.22.203.142', '登录', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:03:21', NULL, '{\"username\":[\"华蒙星老师\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (208, '121.10.41.149', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:14:22', NULL, '{\"username\":[\"admin\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (209, '121.10.41.149', '登录', '执行成功', 0, 12, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:14:33', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (210, '116.22.203.142', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:17:06', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (211, '116.22.203.142', '登录', '执行成功', 0, 16, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:23:51', NULL, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (212, '116.22.203.142', '登录', '执行成功', 0, 132, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:47:37', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (213, '116.22.203.142', '登录', '执行成功', 0, 19, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:47:56', NULL, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (214, '116.22.203.142', '修改资料', '执行成功', 0, 31, 'http://114.55.104.155:8080/api/member/update', '华蒙星第一园长', '2020-06-12 09:57:40', 12, '{\"id\":[\"12\"],\"username\":[\"华蒙星第一园长\"],\"phone\":[\"12313131313\"],\"areaId\":[\"13\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (215, '116.22.203.142', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:58:14', NULL, '{\"username\":[\"华蒙星第一园长\"],\"password\":[\"123\"]}');
INSERT INTO `sys_log` VALUES (216, '116.22.203.142', '登录', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 09:59:02', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (217, '116.22.203.142', '修改资料', '执行成功', 0, 26, 'http://114.55.104.155:8080/api/member/update', 'huamengx', '2020-06-12 09:59:20', 1, '{\"id\":[\"12\"],\"username\":[\"华蒙星第一园长\"],\"phone\":[\"12313131313\"],\"areaId\":[\"13\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (218, '121.10.41.149', '登录', '执行成功', 0, 15, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 10:20:08', NULL, '{\"username\":[\"测试园区录入员\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (219, '121.10.41.149', '公众号获取报告', '执行成功', 0, 21, 'http://114.55.104.155:8080/api/item/getData', '测试园区录入员', '2020-06-12 10:20:14', 8, '{\"sportId\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (220, '117.136.84.141', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 10:29:48', NULL, '{\"username\":[\"15187490614\"],\"password\":[\"zch200099\"]}');
INSERT INTO `sys_log` VALUES (221, '121.10.41.148', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 10:30:19', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (222, '121.10.41.148', '登录', '执行成功', 0, 14, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 10:31:20', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (223, '121.10.41.148', '登录', '执行成功', 0, 13, 'http://114.55.104.155:8080/api/member/login', NULL, '2020-06-12 10:54:04', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (224, '127.0.0.1', '登录', '执行成功', 0, 453, 'http://localhost:8080/dd-web/api/member/login', '测试园区园长', '2020-06-12 11:11:31', NULL, '{\"password\":[\"123456\"],\"username\":[\"测试园区园长\"]}');
INSERT INTO `sys_log` VALUES (225, '127.0.0.1', '登录', '执行成功', 0, 128, 'http://localhost:8080/dd-web/api/member/login', '测试园区园长', '2020-06-12 11:12:05', NULL, '{\"password\":[\"123456\"],\"username\":[\"测试园区园长\"]}');
INSERT INTO `sys_log` VALUES (226, '127.0.0.1', '登录', '执行成功', 0, 309, 'http://localhost:8080/dd-web/api/member/login', '测试园区园长', '2020-06-12 11:17:14', NULL, '{\"password\":[\"123456\"],\"username\":[\"测试园区园长\"]}');
INSERT INTO `sys_log` VALUES (227, '127.0.0.1', '登录', '执行成功', 0, 311, 'http://localhost:8080/dd-web/api/member/login', '测试园区园长', '2020-06-12 11:19:01', NULL, '{\"password\":[\"123456\"],\"username\":[\"测试园区园长\"]}');
INSERT INTO `sys_log` VALUES (228, '121.10.41.148', '登录', '执行成功', 0, 154, 'http://114.55.104.155:8080/api/member/login', 'huamengx', '2020-06-12 11:25:58', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (229, '121.10.41.148', '登录', '执行成功', 0, 17, 'http://114.55.104.155:8080/api/member/login', '测试园区园长', '2020-06-12 11:28:54', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (230, '121.10.41.149', '登录', '执行成功', 0, 20, 'http://114.55.104.155:8080/api/member/login', '测试园区园长', '2020-06-12 11:31:29', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (231, '121.10.41.149', '修改资料', '该园区已存在管理员', -1, 0, 'http://114.55.104.155:8080/api/member/update', '测试园区园长', '2020-06-12 11:33:47', 6, '{\"id\":[\"6\"],\"username\":[\"测试园区园长\"],\"phone\":[\"18000000000\"],\"areaId\":[\"10\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (232, '121.10.41.149', '修改资料', '该园区已存在管理员', -1, 0, 'http://114.55.104.155:8080/api/member/update', '测试园区园长', '2020-06-12 11:33:47', 6, '{\"id\":[\"6\"],\"username\":[\"测试园区园长\"],\"phone\":[\"18000000000\"],\"areaId\":[\"10\"],\"role\":[\"3\"]}');
INSERT INTO `sys_log` VALUES (233, '120.229.161.122', '登录', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/login', '17611734077', '2020-06-12 11:34:07', NULL, '{\"username\":[\"17611734077\"],\"password\":[\"734077\"]}');
INSERT INTO `sys_log` VALUES (234, '121.10.41.149', '修改资料', '该账号不存在', -1, 0, 'http://114.55.104.155:8080/api/member/update', '测试园区园长', '2020-06-12 11:34:16', 6, '{\"id\":[\"7\"],\"username\":[\"css\"],\"phone\":[\"13333333333\"],\"areaId\":[\"10\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (235, '121.10.41.148', '修改资料', '执行成功', 0, 27, 'http://114.55.104.155:8080/api/member/update', '测试园区园长', '2020-06-12 11:41:16', 6, '{\"id\":[\"7\"],\"username\":[\"cs\"],\"phone\":[\"13333333333\"],\"areaId\":[\"10\"],\"role\":[\"2\"]}');
INSERT INTO `sys_log` VALUES (236, '121.10.41.148', '登录', '执行成功', 0, 55, 'http://114.55.104.155:8080/api/member/login', 'huamengx', '2020-06-12 11:41:49', NULL, '{\"username\":[\"huamengx\"],\"password\":[\"huamengxing123\"]}');
INSERT INTO `sys_log` VALUES (237, '121.10.41.148', '登录', '执行成功', 0, 37, 'http://114.55.104.155:8080/api/member/login', '测试园区园长', '2020-06-12 14:48:38', NULL, '{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}');
INSERT INTO `sys_log` VALUES (238, '121.10.41.148', '公众号获取报告', '执行成功', 0, 10, 'http://114.55.104.155:8080/api/item/getData', '测试园区园长', '2020-06-12 14:48:42', 6, '{\"sportId\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (239, '121.10.41.148', '公众号获取报告', '执行成功', 0, 9, 'http://114.55.104.155:8080/api/item/getData', '测试园区园长', '2020-06-12 14:49:41', 6, '{\"sportId\":[\"6\"]}');
INSERT INTO `sys_log` VALUES (240, '121.10.41.148', '公众号获取报告', '执行成功', 0, 6, 'http://114.55.104.155:8080/api/item/getData', '测试园区园长', '2020-06-12 14:49:52', 6, '{\"sportId\":[\"6\"]}');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(64) NULL DEFAULT 0 COMMENT '父级菜单',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `icons` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int(2) NULL DEFAULT NULL COMMENT '排序',
  `category` int(2) NULL DEFAULT NULL COMMENT '菜单类型',
  `is_open` tinyint(1) NULL DEFAULT 1 COMMENT '是否打开新页面',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNI_MENU_CODE`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `group_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '系统管理员', 'sys', '系统', 1, '描述aaaa', '管理员', '2019-12-04 11:35:53');
INSERT INTO `sys_role` VALUES (2, 'op_operator', '操作员', 'op', '运营团队', 2, '运营团队操作员', '管理员', '2019-12-12 17:22:09');
INSERT INTO `sys_role` VALUES (3, 'op_auditor', '审核员', 'op', '运营团队', 3, '运营团队审核员', '管理员', '2019-12-12 17:25:53');
INSERT INTO `sys_role` VALUES (4, 'unit_leader', '负责人', 'unit', '文化单位', 4, '文化单位负责人', '管理员', '2019-12-23 10:15:42');
INSERT INTO `sys_role` VALUES (5, 'unit_operator', '操作员', 'unit', '文化单位', 5, '描述', '管理员', '2019-12-12 17:27:49');
INSERT INTO `sys_role` VALUES (6, 'unit_auditor', '审核员', 'unit', '文化单位', 6, '文化单位审核员', '管理员', '2019-12-12 17:28:51');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` bigint(64) NULL DEFAULT NULL COMMENT '菜单id',
  `role_id` bigint(64) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_sms
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms`;
CREATE TABLE `sys_sms`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送手机',
  `msg` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '返送内容',
  `status` int(5) NOT NULL COMMENT '发送状态（0-未发送，1-发送成功，2-发送失败）',
  `msg_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信批号',
  `code` int(5) NULL DEFAULT NULL COMMENT '返回编码',
  `info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返回信息',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `template_id` int(11) NULL DEFAULT NULL COMMENT '模板id',
  `template_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板描述',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `lock_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_template`;
CREATE TABLE `sys_sms_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板描述，见 SmsTemplateEnum，注意：新增模板请在代码中添加 编号和描述',
  `template` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '短信模块内容（参数用{0},{1},{2}代替）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信模板' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_sms_template
-- ----------------------------
INSERT INTO `sys_sms_template` VALUES (1, 'captcha', '验证码', '您的验证码是{0}，在15分钟内有效。如非本人操作，请忽略本短信。', '2019-10-26 17:06:45', 'adminy', '2019-10-28 10:56:17', 'adminy');

SET FOREIGN_KEY_CHECKS = 1;
