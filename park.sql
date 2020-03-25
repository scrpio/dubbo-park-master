/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : park

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-03-25 14:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(45) DEFAULT NULL COMMENT '部门名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('1', '技术部', '3', null);
INSERT INTO `tb_dept` VALUES ('2', '营销部', '1', null);
INSERT INTO `tb_dept` VALUES ('3', '人事部', '2', null);
INSERT INTO `tb_dept` VALUES ('5', '财务部', '4', 'test');

-- ----------------------------
-- Table structure for tb_dict
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict`;
CREATE TABLE `tb_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '1扩展词 0停用词',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_dict
-- ----------------------------
INSERT INTO `tb_dict` VALUES ('1', '账号状态', 'account_status', '0:启用, 1:冻结, 2:已删除', '1');
INSERT INTO `tb_dict` VALUES ('2', '性别', 'sex', '0:女, 1:男', '1');
INSERT INTO `tb_dict` VALUES ('3', '教育程度', 'education', 'primary:小学, junior:初中, high:高中, university:大学', '0');
INSERT INTO `tb_dict` VALUES ('4', '文章发布', 'blog_status', '0:草稿, 1:发布', '0');

-- ----------------------------
-- Table structure for tb_garage
-- ----------------------------
DROP TABLE IF EXISTS `tb_garage`;
CREATE TABLE `tb_garage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '车库名称',
  `telephone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `manager` varchar(50) DEFAULT NULL COMMENT '负责人',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `sum` int(11) DEFAULT NULL COMMENT '车位总数',
  `rows` int(11) DEFAULT NULL COMMENT '行',
  `cols` int(11) DEFAULT NULL COMMENT '列',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '单价',
  `img` varchar(1000) DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_garage
-- ----------------------------
INSERT INTO `tb_garage` VALUES ('1', '智汇Park立体停车库', '11111111', '未知', '23.12463', '113.36199', '广东省广州市天河区元岗大道310号', '48', '6', '8', '5.00', null, '2019-12-17 15:53:32');
INSERT INTO `tb_garage` VALUES ('2', '智能停车库测试1', '11111111', '未知', '23.12247', '113.36148', '广东省广州市天河区黄埔大道南员村二横路口', '10', '2', '5', '6.00', null, '2019-12-19 10:49:58');
INSERT INTO `tb_garage` VALUES ('3', '智能停车库测试2', '11111111', '未知', '23.12507', '113.36042', '广东省广州市天河区黄埔大道中179号', '30', '3', '10', '5.00', null, '2019-12-19 10:51:40');
INSERT INTO `tb_garage` VALUES ('4', '智能停车库测试3', '11111111', '未知', '23.126749', '113.350493', '广东省广州市天河区黄埔大道西613号', '15', '5', '3', '8.00', null, '2019-12-19 10:53:03');
INSERT INTO `tb_garage` VALUES ('5', '智能停车库测试4', '11111111', '未知', '23.12869', '113.3617', '广东省广州市天河区东方三路逸都商城首层', '48', '6', '8', '7.00', null, '2019-12-19 10:54:52');
INSERT INTO `tb_garage` VALUES ('6', '智能停车库测试5', '11111111', '暂无', '23.52463', '113.96199', '暂无', '42', '7', '6', '6.00', null, '2020-03-18 09:31:22');
INSERT INTO `tb_garage` VALUES ('7', '智能停车库测试6', '11111111', '暂无', '24.12463', '112.36199', '暂无', '16', '2', '8', '5.00', null, '2020-03-18 09:33:20');

-- ----------------------------
-- Table structure for tb_garage_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_garage_car`;
CREATE TABLE `tb_garage_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(50) DEFAULT NULL COMMENT '车位编号',
  `status` int(11) DEFAULT '0' COMMENT '状态(0：空闲；1：使用)',
  `garage_id` bigint(20) DEFAULT NULL COMMENT '所属车库ID',
  `garage_name` varchar(50) DEFAULT NULL COMMENT '所属车库',
  `rows` int(11) DEFAULT NULL COMMENT '行',
  `cols` int(11) DEFAULT NULL COMMENT '列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=465 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_garage_car
-- ----------------------------
INSERT INTO `tb_garage_car` VALUES ('1', 'A1', '0', '1', '智汇Park立体停车库', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('2', 'A2', '0', '1', '智汇Park立体停车库', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('3', 'A3', '0', '1', '智汇Park立体停车库', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('4', 'A4', '0', '1', '智汇Park立体停车库', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('5', 'A5', '0', '1', '智汇Park立体停车库', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('6', 'A6', '0', '1', '智汇Park立体停车库', '1', '6');
INSERT INTO `tb_garage_car` VALUES ('7', 'A7', '0', '1', '智汇Park立体停车库', '1', '7');
INSERT INTO `tb_garage_car` VALUES ('8', 'A8', '0', '1', '智汇Park立体停车库', '1', '8');
INSERT INTO `tb_garage_car` VALUES ('9', 'B1', '0', '1', '智汇Park立体停车库', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('10', 'B2', '0', '1', '智汇Park立体停车库', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('11', 'B3', '0', '1', '智汇Park立体停车库', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('12', 'B4', '0', '1', '智汇Park立体停车库', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('13', 'B5', '0', '1', '智汇Park立体停车库', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('14', 'B6', '0', '1', '智汇Park立体停车库', '2', '6');
INSERT INTO `tb_garage_car` VALUES ('15', 'B7', '0', '1', '智汇Park立体停车库', '2', '7');
INSERT INTO `tb_garage_car` VALUES ('16', 'B8', '0', '1', '智汇Park立体停车库', '2', '8');
INSERT INTO `tb_garage_car` VALUES ('17', 'C1', '0', '1', '智汇Park立体停车库', '3', '1');
INSERT INTO `tb_garage_car` VALUES ('18', 'C2', '0', '1', '智汇Park立体停车库', '3', '2');
INSERT INTO `tb_garage_car` VALUES ('19', 'C3', '0', '1', '智汇Park立体停车库', '3', '3');
INSERT INTO `tb_garage_car` VALUES ('20', 'C4', '0', '1', '智汇Park立体停车库', '3', '4');
INSERT INTO `tb_garage_car` VALUES ('21', 'C5', '0', '1', '智汇Park立体停车库', '3', '5');
INSERT INTO `tb_garage_car` VALUES ('22', 'C6', '0', '1', '智汇Park立体停车库', '3', '6');
INSERT INTO `tb_garage_car` VALUES ('23', 'C7', '0', '1', '智汇Park立体停车库', '3', '7');
INSERT INTO `tb_garage_car` VALUES ('24', 'C8', '0', '1', '智汇Park立体停车库', '3', '8');
INSERT INTO `tb_garage_car` VALUES ('25', 'D1', '0', '1', '智汇Park立体停车库', '4', '1');
INSERT INTO `tb_garage_car` VALUES ('26', 'D2', '0', '1', '智汇Park立体停车库', '4', '2');
INSERT INTO `tb_garage_car` VALUES ('27', 'D3', '0', '1', '智汇Park立体停车库', '4', '3');
INSERT INTO `tb_garage_car` VALUES ('28', 'D4', '0', '1', '智汇Park立体停车库', '4', '4');
INSERT INTO `tb_garage_car` VALUES ('29', 'D5', '0', '1', '智汇Park立体停车库', '4', '5');
INSERT INTO `tb_garage_car` VALUES ('30', 'D6', '0', '1', '智汇Park立体停车库', '4', '6');
INSERT INTO `tb_garage_car` VALUES ('31', 'D7', '0', '1', '智汇Park立体停车库', '4', '7');
INSERT INTO `tb_garage_car` VALUES ('32', 'D8', '0', '1', '智汇Park立体停车库', '4', '8');
INSERT INTO `tb_garage_car` VALUES ('33', 'E1', '0', '1', '智汇Park立体停车库', '5', '1');
INSERT INTO `tb_garage_car` VALUES ('34', 'E2', '0', '1', '智汇Park立体停车库', '5', '2');
INSERT INTO `tb_garage_car` VALUES ('35', 'E3', '0', '1', '智汇Park立体停车库', '5', '3');
INSERT INTO `tb_garage_car` VALUES ('36', 'E4', '0', '1', '智汇Park立体停车库', '5', '4');
INSERT INTO `tb_garage_car` VALUES ('37', 'E5', '0', '1', '智汇Park立体停车库', '5', '5');
INSERT INTO `tb_garage_car` VALUES ('38', 'E6', '0', '1', '智汇Park立体停车库', '5', '6');
INSERT INTO `tb_garage_car` VALUES ('39', 'E7', '0', '1', '智汇Park立体停车库', '5', '7');
INSERT INTO `tb_garage_car` VALUES ('40', 'E8', '0', '1', '智汇Park立体停车库', '5', '8');
INSERT INTO `tb_garage_car` VALUES ('41', 'F1', '0', '1', '智汇Park立体停车库', '6', '1');
INSERT INTO `tb_garage_car` VALUES ('42', 'F2', '0', '1', '智汇Park立体停车库', '6', '2');
INSERT INTO `tb_garage_car` VALUES ('43', 'F3', '0', '1', '智汇Park立体停车库', '6', '3');
INSERT INTO `tb_garage_car` VALUES ('44', 'F4', '0', '1', '智汇Park立体停车库', '6', '4');
INSERT INTO `tb_garage_car` VALUES ('45', 'F5', '0', '1', '智汇Park立体停车库', '6', '5');
INSERT INTO `tb_garage_car` VALUES ('46', 'F6', '0', '1', '智汇Park立体停车库', '6', '6');
INSERT INTO `tb_garage_car` VALUES ('47', 'F7', '0', '1', '智汇Park立体停车库', '6', '7');
INSERT INTO `tb_garage_car` VALUES ('48', 'F8', '0', '1', '智汇Park立体停车库', '6', '8');
INSERT INTO `tb_garage_car` VALUES ('304', 'A1', '0', '2', '智能停车库测试1', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('305', 'A2', '0', '2', '智能停车库测试1', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('306', 'A3', '0', '2', '智能停车库测试1', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('307', 'A4', '0', '2', '智能停车库测试1', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('308', 'A5', '0', '2', '智能停车库测试1', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('309', 'B1', '0', '2', '智能停车库测试1', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('310', 'B2', '0', '2', '智能停车库测试1', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('311', 'B3', '0', '2', '智能停车库测试1', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('312', 'B4', '0', '2', '智能停车库测试1', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('313', 'B5', '0', '2', '智能停车库测试1', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('314', 'A1', '0', '3', '智能停车库测试2', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('315', 'A2', '0', '3', '智能停车库测试2', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('316', 'A3', '0', '3', '智能停车库测试2', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('317', 'A4', '0', '3', '智能停车库测试2', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('318', 'A5', '0', '3', '智能停车库测试2', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('319', 'A6', '0', '3', '智能停车库测试2', '1', '6');
INSERT INTO `tb_garage_car` VALUES ('320', 'A7', '0', '3', '智能停车库测试2', '1', '7');
INSERT INTO `tb_garage_car` VALUES ('321', 'A8', '0', '3', '智能停车库测试2', '1', '8');
INSERT INTO `tb_garage_car` VALUES ('322', 'A9', '0', '3', '智能停车库测试2', '1', '9');
INSERT INTO `tb_garage_car` VALUES ('323', 'A10', '0', '3', '智能停车库测试2', '1', '10');
INSERT INTO `tb_garage_car` VALUES ('324', 'B1', '0', '3', '智能停车库测试2', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('325', 'B2', '0', '3', '智能停车库测试2', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('326', 'B3', '0', '3', '智能停车库测试2', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('327', 'B4', '0', '3', '智能停车库测试2', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('328', 'B5', '0', '3', '智能停车库测试2', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('329', 'B6', '0', '3', '智能停车库测试2', '2', '6');
INSERT INTO `tb_garage_car` VALUES ('330', 'B7', '0', '3', '智能停车库测试2', '2', '7');
INSERT INTO `tb_garage_car` VALUES ('331', 'B8', '0', '3', '智能停车库测试2', '2', '8');
INSERT INTO `tb_garage_car` VALUES ('332', 'B9', '0', '3', '智能停车库测试2', '2', '9');
INSERT INTO `tb_garage_car` VALUES ('333', 'B10', '0', '3', '智能停车库测试2', '2', '10');
INSERT INTO `tb_garage_car` VALUES ('334', 'C1', '0', '3', '智能停车库测试2', '3', '1');
INSERT INTO `tb_garage_car` VALUES ('335', 'C2', '0', '3', '智能停车库测试2', '3', '2');
INSERT INTO `tb_garage_car` VALUES ('336', 'C3', '0', '3', '智能停车库测试2', '3', '3');
INSERT INTO `tb_garage_car` VALUES ('337', 'C4', '0', '3', '智能停车库测试2', '3', '4');
INSERT INTO `tb_garage_car` VALUES ('338', 'C5', '0', '3', '智能停车库测试2', '3', '5');
INSERT INTO `tb_garage_car` VALUES ('339', 'C6', '0', '3', '智能停车库测试2', '3', '6');
INSERT INTO `tb_garage_car` VALUES ('340', 'C7', '0', '3', '智能停车库测试2', '3', '7');
INSERT INTO `tb_garage_car` VALUES ('341', 'C8', '0', '3', '智能停车库测试2', '3', '8');
INSERT INTO `tb_garage_car` VALUES ('342', 'C9', '0', '3', '智能停车库测试2', '3', '9');
INSERT INTO `tb_garage_car` VALUES ('343', 'C10', '0', '3', '智能停车库测试2', '3', '10');
INSERT INTO `tb_garage_car` VALUES ('344', 'A1', '0', '4', '智能停车库测试3', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('345', 'A2', '0', '4', '智能停车库测试3', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('346', 'A3', '0', '4', '智能停车库测试3', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('347', 'B1', '0', '4', '智能停车库测试3', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('348', 'B2', '0', '4', '智能停车库测试3', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('349', 'B3', '0', '4', '智能停车库测试3', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('350', 'C1', '0', '4', '智能停车库测试3', '3', '1');
INSERT INTO `tb_garage_car` VALUES ('351', 'C2', '0', '4', '智能停车库测试3', '3', '2');
INSERT INTO `tb_garage_car` VALUES ('352', 'C3', '0', '4', '智能停车库测试3', '3', '3');
INSERT INTO `tb_garage_car` VALUES ('353', 'D1', '0', '4', '智能停车库测试3', '4', '1');
INSERT INTO `tb_garage_car` VALUES ('354', 'D2', '0', '4', '智能停车库测试3', '4', '2');
INSERT INTO `tb_garage_car` VALUES ('355', 'D3', '0', '4', '智能停车库测试3', '4', '3');
INSERT INTO `tb_garage_car` VALUES ('356', 'E1', '0', '4', '智能停车库测试3', '5', '1');
INSERT INTO `tb_garage_car` VALUES ('357', 'E2', '0', '4', '智能停车库测试3', '5', '2');
INSERT INTO `tb_garage_car` VALUES ('358', 'E3', '0', '4', '智能停车库测试3', '5', '3');
INSERT INTO `tb_garage_car` VALUES ('359', 'A1', '0', '5', '智能停车库测试4', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('360', 'A2', '0', '5', '智能停车库测试4', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('361', 'A3', '0', '5', '智能停车库测试4', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('362', 'A4', '0', '5', '智能停车库测试4', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('363', 'A5', '0', '5', '智能停车库测试4', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('364', 'A6', '0', '5', '智能停车库测试4', '1', '6');
INSERT INTO `tb_garage_car` VALUES ('365', 'A7', '0', '5', '智能停车库测试4', '1', '7');
INSERT INTO `tb_garage_car` VALUES ('366', 'A8', '0', '5', '智能停车库测试4', '1', '8');
INSERT INTO `tb_garage_car` VALUES ('367', 'B1', '0', '5', '智能停车库测试4', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('368', 'B2', '0', '5', '智能停车库测试4', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('369', 'B3', '0', '5', '智能停车库测试4', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('370', 'B4', '0', '5', '智能停车库测试4', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('371', 'B5', '0', '5', '智能停车库测试4', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('372', 'B6', '0', '5', '智能停车库测试4', '2', '6');
INSERT INTO `tb_garage_car` VALUES ('373', 'B7', '0', '5', '智能停车库测试4', '2', '7');
INSERT INTO `tb_garage_car` VALUES ('374', 'B8', '0', '5', '智能停车库测试4', '2', '8');
INSERT INTO `tb_garage_car` VALUES ('375', 'C1', '0', '5', '智能停车库测试4', '3', '1');
INSERT INTO `tb_garage_car` VALUES ('376', 'C2', '0', '5', '智能停车库测试4', '3', '2');
INSERT INTO `tb_garage_car` VALUES ('377', 'C3', '0', '5', '智能停车库测试4', '3', '3');
INSERT INTO `tb_garage_car` VALUES ('378', 'C4', '0', '5', '智能停车库测试4', '3', '4');
INSERT INTO `tb_garage_car` VALUES ('379', 'C5', '0', '5', '智能停车库测试4', '3', '5');
INSERT INTO `tb_garage_car` VALUES ('380', 'C6', '0', '5', '智能停车库测试4', '3', '6');
INSERT INTO `tb_garage_car` VALUES ('381', 'C7', '0', '5', '智能停车库测试4', '3', '7');
INSERT INTO `tb_garage_car` VALUES ('382', 'C8', '0', '5', '智能停车库测试4', '3', '8');
INSERT INTO `tb_garage_car` VALUES ('383', 'D1', '0', '5', '智能停车库测试4', '4', '1');
INSERT INTO `tb_garage_car` VALUES ('384', 'D2', '0', '5', '智能停车库测试4', '4', '2');
INSERT INTO `tb_garage_car` VALUES ('385', 'D3', '0', '5', '智能停车库测试4', '4', '3');
INSERT INTO `tb_garage_car` VALUES ('386', 'D4', '0', '5', '智能停车库测试4', '4', '4');
INSERT INTO `tb_garage_car` VALUES ('387', 'D5', '0', '5', '智能停车库测试4', '4', '5');
INSERT INTO `tb_garage_car` VALUES ('388', 'D6', '0', '5', '智能停车库测试4', '4', '6');
INSERT INTO `tb_garage_car` VALUES ('389', 'D7', '0', '5', '智能停车库测试4', '4', '7');
INSERT INTO `tb_garage_car` VALUES ('390', 'D8', '0', '5', '智能停车库测试4', '4', '8');
INSERT INTO `tb_garage_car` VALUES ('391', 'E1', '0', '5', '智能停车库测试4', '5', '1');
INSERT INTO `tb_garage_car` VALUES ('392', 'E2', '0', '5', '智能停车库测试4', '5', '2');
INSERT INTO `tb_garage_car` VALUES ('393', 'E3', '0', '5', '智能停车库测试4', '5', '3');
INSERT INTO `tb_garage_car` VALUES ('394', 'E4', '0', '5', '智能停车库测试4', '5', '4');
INSERT INTO `tb_garage_car` VALUES ('395', 'E5', '0', '5', '智能停车库测试4', '5', '5');
INSERT INTO `tb_garage_car` VALUES ('396', 'E6', '0', '5', '智能停车库测试4', '5', '6');
INSERT INTO `tb_garage_car` VALUES ('397', 'E7', '0', '5', '智能停车库测试4', '5', '7');
INSERT INTO `tb_garage_car` VALUES ('398', 'E8', '0', '5', '智能停车库测试4', '5', '8');
INSERT INTO `tb_garage_car` VALUES ('399', 'F1', '0', '5', '智能停车库测试4', '6', '1');
INSERT INTO `tb_garage_car` VALUES ('400', 'F2', '0', '5', '智能停车库测试4', '6', '2');
INSERT INTO `tb_garage_car` VALUES ('401', 'F3', '0', '5', '智能停车库测试4', '6', '3');
INSERT INTO `tb_garage_car` VALUES ('402', 'F4', '0', '5', '智能停车库测试4', '6', '4');
INSERT INTO `tb_garage_car` VALUES ('403', 'F5', '0', '5', '智能停车库测试4', '6', '5');
INSERT INTO `tb_garage_car` VALUES ('404', 'F6', '0', '5', '智能停车库测试4', '6', '6');
INSERT INTO `tb_garage_car` VALUES ('405', 'F7', '0', '5', '智能停车库测试4', '6', '7');
INSERT INTO `tb_garage_car` VALUES ('406', 'F8', '0', '5', '智能停车库测试4', '6', '8');
INSERT INTO `tb_garage_car` VALUES ('407', 'A1', '0', '6', '智能停车库测试5', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('408', 'A2', '0', '6', '智能停车库测试5', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('409', 'A3', '0', '6', '智能停车库测试5', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('410', 'A4', '0', '6', '智能停车库测试5', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('411', 'A5', '0', '6', '智能停车库测试5', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('412', 'A6', '0', '6', '智能停车库测试5', '1', '6');
INSERT INTO `tb_garage_car` VALUES ('413', 'B1', '0', '6', '智能停车库测试5', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('414', 'B2', '0', '6', '智能停车库测试5', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('415', 'B3', '0', '6', '智能停车库测试5', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('416', 'B4', '0', '6', '智能停车库测试5', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('417', 'B5', '0', '6', '智能停车库测试5', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('418', 'B6', '0', '6', '智能停车库测试5', '2', '6');
INSERT INTO `tb_garage_car` VALUES ('419', 'C1', '0', '6', '智能停车库测试5', '3', '1');
INSERT INTO `tb_garage_car` VALUES ('420', 'C2', '0', '6', '智能停车库测试5', '3', '2');
INSERT INTO `tb_garage_car` VALUES ('421', 'C3', '0', '6', '智能停车库测试5', '3', '3');
INSERT INTO `tb_garage_car` VALUES ('422', 'C4', '0', '6', '智能停车库测试5', '3', '4');
INSERT INTO `tb_garage_car` VALUES ('423', 'C5', '0', '6', '智能停车库测试5', '3', '5');
INSERT INTO `tb_garage_car` VALUES ('424', 'C6', '0', '6', '智能停车库测试5', '3', '6');
INSERT INTO `tb_garage_car` VALUES ('425', 'D1', '0', '6', '智能停车库测试5', '4', '1');
INSERT INTO `tb_garage_car` VALUES ('426', 'D2', '0', '6', '智能停车库测试5', '4', '2');
INSERT INTO `tb_garage_car` VALUES ('427', 'D3', '0', '6', '智能停车库测试5', '4', '3');
INSERT INTO `tb_garage_car` VALUES ('428', 'D4', '0', '6', '智能停车库测试5', '4', '4');
INSERT INTO `tb_garage_car` VALUES ('429', 'D5', '0', '6', '智能停车库测试5', '4', '5');
INSERT INTO `tb_garage_car` VALUES ('430', 'D6', '0', '6', '智能停车库测试5', '4', '6');
INSERT INTO `tb_garage_car` VALUES ('431', 'E1', '0', '6', '智能停车库测试5', '5', '1');
INSERT INTO `tb_garage_car` VALUES ('432', 'E2', '0', '6', '智能停车库测试5', '5', '2');
INSERT INTO `tb_garage_car` VALUES ('433', 'E3', '0', '6', '智能停车库测试5', '5', '3');
INSERT INTO `tb_garage_car` VALUES ('434', 'E4', '0', '6', '智能停车库测试5', '5', '4');
INSERT INTO `tb_garage_car` VALUES ('435', 'E5', '0', '6', '智能停车库测试5', '5', '5');
INSERT INTO `tb_garage_car` VALUES ('436', 'E6', '0', '6', '智能停车库测试5', '5', '6');
INSERT INTO `tb_garage_car` VALUES ('437', 'F1', '0', '6', '智能停车库测试5', '6', '1');
INSERT INTO `tb_garage_car` VALUES ('438', 'F2', '0', '6', '智能停车库测试5', '6', '2');
INSERT INTO `tb_garage_car` VALUES ('439', 'F3', '0', '6', '智能停车库测试5', '6', '3');
INSERT INTO `tb_garage_car` VALUES ('440', 'F4', '0', '6', '智能停车库测试5', '6', '4');
INSERT INTO `tb_garage_car` VALUES ('441', 'F5', '0', '6', '智能停车库测试5', '6', '5');
INSERT INTO `tb_garage_car` VALUES ('442', 'F6', '0', '6', '智能停车库测试5', '6', '6');
INSERT INTO `tb_garage_car` VALUES ('443', 'G1', '0', '6', '智能停车库测试5', '7', '1');
INSERT INTO `tb_garage_car` VALUES ('444', 'G2', '0', '6', '智能停车库测试5', '7', '2');
INSERT INTO `tb_garage_car` VALUES ('445', 'G3', '0', '6', '智能停车库测试5', '7', '3');
INSERT INTO `tb_garage_car` VALUES ('446', 'G4', '0', '6', '智能停车库测试5', '7', '4');
INSERT INTO `tb_garage_car` VALUES ('447', 'G5', '0', '6', '智能停车库测试5', '7', '5');
INSERT INTO `tb_garage_car` VALUES ('448', 'G6', '0', '6', '智能停车库测试5', '7', '6');
INSERT INTO `tb_garage_car` VALUES ('449', 'A1', '0', '7', '智能停车库测试6', '1', '1');
INSERT INTO `tb_garage_car` VALUES ('450', 'A2', '0', '7', '智能停车库测试6', '1', '2');
INSERT INTO `tb_garage_car` VALUES ('451', 'A3', '0', '7', '智能停车库测试6', '1', '3');
INSERT INTO `tb_garage_car` VALUES ('452', 'A4', '0', '7', '智能停车库测试6', '1', '4');
INSERT INTO `tb_garage_car` VALUES ('453', 'A5', '0', '7', '智能停车库测试6', '1', '5');
INSERT INTO `tb_garage_car` VALUES ('454', 'A6', '0', '7', '智能停车库测试6', '1', '6');
INSERT INTO `tb_garage_car` VALUES ('455', 'A7', '0', '7', '智能停车库测试6', '1', '7');
INSERT INTO `tb_garage_car` VALUES ('456', 'A8', '0', '7', '智能停车库测试6', '1', '8');
INSERT INTO `tb_garage_car` VALUES ('457', 'B1', '0', '7', '智能停车库测试6', '2', '1');
INSERT INTO `tb_garage_car` VALUES ('458', 'B2', '0', '7', '智能停车库测试6', '2', '2');
INSERT INTO `tb_garage_car` VALUES ('459', 'B3', '0', '7', '智能停车库测试6', '2', '3');
INSERT INTO `tb_garage_car` VALUES ('460', 'B4', '0', '7', '智能停车库测试6', '2', '4');
INSERT INTO `tb_garage_car` VALUES ('461', 'B5', '0', '7', '智能停车库测试6', '2', '5');
INSERT INTO `tb_garage_car` VALUES ('462', 'B6', '0', '7', '智能停车库测试6', '2', '6');
INSERT INTO `tb_garage_car` VALUES ('463', 'B7', '0', '7', '智能停车库测试6', '2', '7');
INSERT INTO `tb_garage_car` VALUES ('464', 'B8', '0', '7', '智能停车库测试6', '2', '8');

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `log_type` varchar(20) DEFAULT NULL,
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(5000) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES ('1', '0', '', '登录日志', '账号密码登录', '2662', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:22:02');
INSERT INTO `tb_log` VALUES ('2', '0', '', '登录日志', '账号密码登录', '7', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:26:31');
INSERT INTO `tb_log` VALUES ('3', '0', '', '登录日志', '账号密码登录', '5', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:32:58');
INSERT INTO `tb_log` VALUES ('4', '0', '', '登录日志', '账号密码登录', '3', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:33:20');
INSERT INTO `tb_log` VALUES ('5', '0', '', '登录日志', '账号密码登录', '469', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:36:13');
INSERT INTO `tb_log` VALUES ('6', '0', '', '登录日志', '账号密码登录', '221', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:40:53');
INSERT INTO `tb_log` VALUES ('7', '0', '', '登录日志', '账号密码登录', '228', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:44:14');
INSERT INTO `tb_log` VALUES ('8', '0', '', '登录日志', '账号密码登录', '224', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 17:52:19');
INSERT INTO `tb_log` VALUES ('9', '1', 'admin', '登录日志', '账号密码登录', '209', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-05 18:00:34');
INSERT INTO `tb_log` VALUES ('10', '1', 'admin', '登录日志', '账号密码登录', '22', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-05 18:01:36');
INSERT INTO `tb_log` VALUES ('11', '1', 'admin', '登录日志', '账号密码登录', '214', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:12:21');
INSERT INTO `tb_log` VALUES ('12', '1', 'admin', '登录日志', '账号密码登录', '16', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:14:34');
INSERT INTO `tb_log` VALUES ('13', '1', 'admin', '登录日志', '账号密码登录', '28', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:17:23');
INSERT INTO `tb_log` VALUES ('14', '1', 'admin', '登录日志', '账号密码登录', '7', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:19:32');
INSERT INTO `tb_log` VALUES ('15', '1', 'admin', '登录日志', '账号密码登录', '121', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:24:15');
INSERT INTO `tb_log` VALUES ('16', '1', 'admin', '登录日志', '账号密码登录', '10', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:24:35');
INSERT INTO `tb_log` VALUES ('17', '1', 'admin', '登录日志', '账号密码登录', '77', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:26:08');
INSERT INTO `tb_log` VALUES ('18', '1', 'admin', '登录日志', '账号密码登录', '106', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-06 09:54:18');
INSERT INTO `tb_log` VALUES ('19', '1', 'admin', '登录日志', '账号密码登录', '389', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-06 15:29:56');
INSERT INTO `tb_log` VALUES ('20', '1', 'admin', '登录日志', '账号密码登录', '18', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-06 15:35:49');
INSERT INTO `tb_log` VALUES ('21', '1', 'admin', '登录日志', '账号密码登录', '762', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-09 10:09:30');
INSERT INTO `tb_log` VALUES ('22', '1', 'admin', '登录日志', '账号密码登录', '221', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-09 11:37:15');
INSERT INTO `tb_log` VALUES ('23', '1', 'admin', '登录日志', '账号密码登录', '91', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-09 13:56:55');
INSERT INTO `tb_log` VALUES ('24', '1', 'admin', '登录日志', '账号密码登录', '249', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:25:18');
INSERT INTO `tb_log` VALUES ('25', '1', 'admin', '业务日志', '修改车库信息', '71', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:25:59');
INSERT INTO `tb_log` VALUES ('26', '1', 'admin', '业务日志', '修改车库信息', '404', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:26:33');
INSERT INTO `tb_log` VALUES ('27', '1', 'admin', '业务日志', '修改车库信息', '86', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:27:05');
INSERT INTO `tb_log` VALUES ('28', '1', 'admin', '业务日志', '修改车库信息', '140', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:27:32');
INSERT INTO `tb_log` VALUES ('29', '1', 'admin', '业务日志', '修改车库信息', '132', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:28:02');
INSERT INTO `tb_log` VALUES ('30', '1', 'admin', '业务日志', '修改车库信息', '106', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-09 14:28:28');
INSERT INTO `tb_log` VALUES ('31', '1', 'admin', '登录日志', '账号密码登录', '679', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-12 15:09:16');
INSERT INTO `tb_log` VALUES ('32', '1', 'admin', '登录日志', '账号密码登录', '329', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-18 09:29:11');
INSERT INTO `tb_log` VALUES ('33', '1', 'admin', '业务日志', '添加车库信息', '70', 'com.park.admin.controller.GarageController.addGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-18 09:31:22');
INSERT INTO `tb_log` VALUES ('34', '1', 'admin', '业务日志', '添加车库信息', '216', 'com.park.admin.controller.GarageController.addGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-18 09:33:21');
INSERT INTO `tb_log` VALUES ('35', '1', 'admin', '业务日志', '修改车库信息', '71', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-18 09:39:40');
INSERT INTO `tb_log` VALUES ('36', '1', 'admin', '业务日志', '修改会员状态', '56', 'com.park.admin.controller.MemberController.editMemberStatus()', null, '0:0:0:0:0:0:0:1', '2020-03-18 10:17:52');
INSERT INTO `tb_log` VALUES ('37', '1', 'admin', '登录日志', '账号密码登录', '896', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-19 11:34:55');
INSERT INTO `tb_log` VALUES ('38', '1', 'admin', '登录日志', '账号密码登录', '24', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-19 13:26:47');
INSERT INTO `tb_log` VALUES ('39', '1', 'admin', '登录日志', '账号密码登录', '60', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-19 14:06:28');
INSERT INTO `tb_log` VALUES ('40', '1', 'admin', '登录日志', '账号密码登录', '21', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-19 14:19:48');
INSERT INTO `tb_log` VALUES ('41', '1', 'admin', '业务日志', '添加维修记录', '64', 'com.park.admin.controller.RepairController.addRepair()', null, '127.0.0.1', '2020-03-19 14:26:43');
INSERT INTO `tb_log` VALUES ('42', '1', 'admin', '业务日志', '添加维修记录', '53', 'com.park.admin.controller.RepairController.addRepair()', null, '127.0.0.1', '2020-03-19 14:27:11');
INSERT INTO `tb_log` VALUES ('43', '1', 'admin', '业务日志', '添加维修记录', '42', 'com.park.admin.controller.RepairController.addRepair()', null, '127.0.0.1', '2020-03-19 14:28:11');
INSERT INTO `tb_log` VALUES ('44', '1', 'admin', '业务日志', '添加维修记录', '96', 'com.park.admin.controller.RepairController.addRepair()', null, '127.0.0.1', '2020-03-19 14:30:19');
INSERT INTO `tb_log` VALUES ('45', '1', 'admin', '业务日志', '添加维修记录', '39', 'com.park.admin.controller.RepairController.addRepair()', null, '127.0.0.1', '2020-03-19 14:30:37');
INSERT INTO `tb_log` VALUES ('46', '1', 'admin', '登录日志', '账号密码登录', '31', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-19 14:37:29');
INSERT INTO `tb_log` VALUES ('47', '1', 'admin', '业务日志', '修改车库信息', '58', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:05');
INSERT INTO `tb_log` VALUES ('48', '1', 'admin', '业务日志', '修改车库信息', '48', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:16');
INSERT INTO `tb_log` VALUES ('49', '1', 'admin', '业务日志', '修改车库信息', '44', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:23');
INSERT INTO `tb_log` VALUES ('50', '1', 'admin', '业务日志', '修改车库信息', '41', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:30');
INSERT INTO `tb_log` VALUES ('51', '1', 'admin', '业务日志', '修改车库信息', '39', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:40');
INSERT INTO `tb_log` VALUES ('52', '1', 'admin', '业务日志', '修改车库信息', '45', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:46');
INSERT INTO `tb_log` VALUES ('53', '1', 'admin', '业务日志', '修改车库信息', '40', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:52');
INSERT INTO `tb_log` VALUES ('54', '1', 'admin', '业务日志', '修改车库信息', '39', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:55:58');
INSERT INTO `tb_log` VALUES ('55', '1', 'admin', '业务日志', '修改车库信息', '42', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:56:07');
INSERT INTO `tb_log` VALUES ('56', '1', 'admin', '业务日志', '修改车库信息', '36', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:56:14');
INSERT INTO `tb_log` VALUES ('57', '1', 'admin', '业务日志', '修改车库信息', '42', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:56:20');
INSERT INTO `tb_log` VALUES ('58', '1', 'admin', '业务日志', '修改车库信息', '43', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 14:56:35');
INSERT INTO `tb_log` VALUES ('59', '1', 'admin', '登录日志', '账号密码登录', '253', 'com.park.admin.controller.LoginController.accountLogin()', null, '127.0.0.1', '2020-03-19 15:12:15');
INSERT INTO `tb_log` VALUES ('60', '1', 'admin', '业务日志', '修改车库信息', '102', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:12:48');
INSERT INTO `tb_log` VALUES ('61', '1', 'admin', '业务日志', '修改车库信息', '85', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:13:09');
INSERT INTO `tb_log` VALUES ('62', '1', 'admin', '业务日志', '修改车库信息', '101', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:13:36');
INSERT INTO `tb_log` VALUES ('63', '1', 'admin', '业务日志', '修改车库信息', '121', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:13:54');
INSERT INTO `tb_log` VALUES ('64', '1', 'admin', '业务日志', '修改车库信息', '96', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:14:10');
INSERT INTO `tb_log` VALUES ('65', '1', 'admin', '业务日志', '修改车库信息', '58', 'com.park.admin.controller.GarageController.editGarage()', null, '127.0.0.1', '2020-03-19 15:14:22');
INSERT INTO `tb_log` VALUES ('66', '1', 'admin', '登录日志', '账号密码登录', '758', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-19 17:30:47');
INSERT INTO `tb_log` VALUES ('67', '1', 'admin', '业务日志', '修改车库信息', '55', 'com.park.admin.controller.GarageController.editGarage()', null, '0:0:0:0:0:0:0:1', '2020-03-19 17:31:23');
INSERT INTO `tb_log` VALUES ('68', '1', 'admin', '登录日志', '账号密码登录', '90', 'com.park.admin.controller.LoginController.accountLogin()', null, '0:0:0:0:0:0:0:1', '2020-03-19 17:37:00');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信标识openId',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `license` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` int(2) DEFAULT '0' COMMENT '性别(0：未知；1：男；2：女)',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `status` int(1) DEFAULT '0' COMMENT '状态(0：冻结；1：正常)',
  `level` int(11) DEFAULT '0' COMMENT '会员等级(0：普通会员；1：黄金会员；2：铂金会员；3：钻石会员)',
  `points` int(11) DEFAULT '0' COMMENT '积分',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `avatar_url` varchar(200) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('1', 'o9OFC1b9PpyvB2hFwSOJrDYFMiKQ', 'Pierre', '粤A00000', '11111111111', '1991-12-26', '2', 'Guangdong', 'Guangzhou', '0', '0', '0', '0.00', 'https://wx.qlogo.cn/mmopen/vi_32/jDwTqZkwWiceNaeh7cdbIN0pr2p31Lsb3TdYib95Tm7xee2OnpGvHbX7iapibKUgHhuzKu4c2j6dIRwGhpnnLDv86Q/132', '2019-12-26 14:02:14', '2019-12-26 14:10:49');
INSERT INTO `tb_member` VALUES ('2', 'o9OFC1b9PpyvB2hFwSOJrDYFMrKg', 'Monroe', '粤A00000', '11111111111', '2019-12-23', '1', 'Guangdong', 'Guangzhou', '0', '0', '0', '0.00', 'https://wx.qlogo.cn/mmopen/vi_32/jDwTqZkwWiceNaeh7cdbIN0pr2p31Lsb3TdYib95Tm7xee2OnpGvHbX7iapibKUgHhuzKu4c2j6dIRwGhpnnLDv86Q/132', '2019-12-26 16:43:57', '2019-12-26 17:00:16');
INSERT INTO `tb_member` VALUES ('3', 'o9OFC1b9PpyvB2hFwSOJrDYFMrKo', 'Immanuel', '粤A00000', '11111111111', '2006-09-19', '2', 'Guangdong', 'Guangzhou', '0', '0', '0', '0.00', 'https://wx.qlogo.cn/mmopen/vi_32/jDwTqZkwWiceNaeh7cdbIN0pr2p31Lsb3TdYib95Tm7xee2OnpGvHbX7iapibKUgHhuzKu4c2j6dIRwGhpnnLDv86Q/132', '2019-12-26 16:19:03', '2019-12-26 16:23:04');
INSERT INTO `tb_member` VALUES ('4', 'o9OFC1b9PpyvB2hFwSOJrDYFMrKQ', 'Christy', '粤A00000', '11111111111', '1992-12-18', '2', 'Guangdong', 'Guangzhou', '1', '0', '10', '0.00', 'https://wx.qlogo.cn/mmopen/vi_32/jDwTqZkwWiceNaeh7cdbIN0pr2p31Lsb3TdYib95Tm7xee2OnpGvHbX7iapibKUgHhuzKu4c2j6dIRwGhpnnLDv86Q/132', '2019-12-26 17:01:15', '2020-03-12 17:19:34');
INSERT INTO `tb_member` VALUES ('5', 'o9OFC1b9PpyvB2hFwSOJrDYFMxKQ', 'Joanne', '粤A00000', '11111111111', '1995-06-25', '1', 'Guangdong', 'Guangzhou', '0', '0', '0', '0.00', 'https://wx.qlogo.cn/mmopen/vi_32/jDwTqZkwWiceNaeh7cdbIN0pr2p31Lsb3TdYib95Tm7xee2OnpGvHbX7iapibKUgHhuzKu4c2j6dIRwGhpnnLDv86Q/132', '2019-12-26 14:20:38', '2019-12-26 14:56:55');
INSERT INTO `tb_member` VALUES ('6', 'oJNzy5DlWs6Tzbtqec8__g3QP4Hc', '测试号', '粤A00000', '11111111111', '1992-03-16', '2', 'Guangdong', 'Guangzhou', '1', '1', '26', '320.00', 'https://wx.qlogo.cn/mmopen/vi_32/MyZNlsg81ZYUQZ8xFuNB35OIk3SpclnJpoTuB6oZMGSrFWI2EqFqF2PbUhiafsnXmFWYOwvibbvgR5325scw0uiaw/132', '2020-03-17 09:35:38', '2020-03-25 10:16:10');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `parent_id` int(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `leaf` int(2) DEFAULT NULL,
  `menu_show` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '系统管理', 'admin:manager', null, 'fa fa-cogs', '2', '0', '0', '0', '1', '2017-08-09 23:06:55', '2019-04-23 13:55:38');
INSERT INTO `tb_menu` VALUES ('2', '用户管理', 'admin:user:user', '/admin/user', null, '2', '1', '1', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('3', '角色管理', 'admin:role:role', '/admin/role', null, '3', '1', '1', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('4', '新增', 'admin:user:add', '/user/add', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('5', '编辑', 'admin:user:edit', '/user/edit', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('6', '删除', 'admin:user:delete', '/user/remove', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('7', '新增', 'admin:role:add', '/role/add', null, '0', '2', '3', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('8', '新增', 'admin:menu:add', '/menu/add', null, '0', '2', '33', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('9', '编辑', 'admin:menu:edit', '/menu/edit', null, '0', '2', '33', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('10', '删除', 'admin:menu:delete', '/menu/remove', null, '0', '2', '33', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('11', '批量删除', 'admin:user:batchDelete', '/user/remove', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('12', '停用', 'admin:user:stop', '/user/stop', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('13', '重置密码', 'admin:user:resetPwd', '/user/resetPwd', null, '0', '2', '2', '1', '0', '2017-08-14 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('14', '编辑', 'admin:role:edit', '/role/edit', null, null, '2', '3', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('15', '删除', 'admin:role:delete', '/role/remove', null, null, '2', '3', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('16', '批量删除', 'admin:menu:batchDelete', '/menu/remove', null, null, '2', '33', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('17', '批量删除', 'admin:role:batchDelete', '/role/remove', null, null, '2', '3', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('18', '清除缓存', 'admin:tool:clear', '/tool/clearCache', null, '1', '1', '32', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('19', '编辑', 'admin:user:info', '/user/currentUser', null, '3', '2', '2', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('20', '列表', 'admin:menu:list', '/menu/list', null, null, '2', '33', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('22', '数据字典', 'admin:tool:dictionary', '/tool/dictionary', null, null, '1', '32', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('26', '异常页面', 'admin:base', null, 'fa fa-bug', '7', '0', '0', '0', '1', '2017-08-10 00:00:00', '2019-12-17 14:03:38');
INSERT INTO `tb_menu` VALUES ('27', '系统日志', 'admin:monitor:log', '/monitor/log', null, null, '1', '30', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('28', '列表', 'admin:tool:list', '/log/list', null, null, '2', '27', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('29', '上传', 'admin:tool:upload', '/upload/file', null, null, '2', '32', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('30', '日志管理', 'admin:monitor', null, 'fa fa-video-camera', '6', '0', '0', '0', '1', '2017-08-10 00:00:00', '2019-12-17 14:03:33');
INSERT INTO `tb_menu` VALUES ('32', '系统工具', 'admin:tool', null, 'fa fa-wrench', '5', '0', '0', '0', '1', '2017-08-10 00:00:00', '2019-12-17 14:03:28');
INSERT INTO `tb_menu` VALUES ('33', '菜单管理', 'admin:menu:menu', '/admin/menu', null, '1', '1', '1', '1', '1', '2018-06-06 10:33:21', '2019-04-02 16:26:40');
INSERT INTO `tb_menu` VALUES ('34', '部门管理', 'admin:dept:dept', '/admin/dept', null, '4', '1', '1', '1', '1', '2018-06-07 11:43:49', null);
INSERT INTO `tb_menu` VALUES ('35', '新增', 'admin:dept:add', '/dept/add', null, '1', '2', '34', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('36', '编辑', 'admin:dept:edit', '/dept/edit', null, '2', '2', '34', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('37', '删除', 'admin:dept:delete', '/dept/remove', null, '3', '2', '34', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('38', '批量删除', 'admin:dept:batchDelete', '/dept/remove', null, '4', '2', '34', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('39', 'dashboard', 'admin:dashdoard', '', 'fa fa-tachometer', '1', '0', '0', '0', '1', '2017-08-10 00:00:00', '2019-04-01 11:25:29');
INSERT INTO `tb_menu` VALUES ('40', 'Redis日志', 'admin:monitor:redis', '/monitor/redis', '', '2', '0', '30', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('41', '首页', 'admin:dashboard:home', '/dashboard', '', '1', '0', '39', '1', '1', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('42', '批量删除', 'admin:user:clearLogs', '/redis/clearLogs', '', '1', '2', '40', '1', '0', '2017-08-10 00:00:00', null);
INSERT INTO `tb_menu` VALUES ('43', '404', '', '/notfound', '', '1', '0', '26', '0', '1', '2019-04-03 11:08:10', '2019-04-23 13:40:33');
INSERT INTO `tb_menu` VALUES ('44', '车库管理', 'admin:garage', '', 'fa fa-car', '3', '0', '0', '0', '1', '2019-12-16 15:48:43', '2019-12-17 14:02:04');
INSERT INTO `tb_menu` VALUES ('45', '车库列表', 'admin:garage:list', '/garage/list', '', '1', '1', '44', '1', '1', '2019-12-16 15:51:32', '2019-12-16 16:20:05');
INSERT INTO `tb_menu` VALUES ('46', '维修记录', 'admin:garage:repair', '/garage/repair', '', '3', '1', '44', '1', '1', '2019-12-16 15:52:20', '2019-12-18 16:57:55');
INSERT INTO `tb_menu` VALUES ('47', '会员管理', 'admin:member', '', 'fa fa-user', '4', '0', '0', '0', '1', '2019-12-16 15:53:04', '2019-12-17 14:02:09');
INSERT INTO `tb_menu` VALUES ('48', '会员列表', 'admin:member:list', '/member/list', '', '1', '1', '47', '1', '1', '2019-12-16 15:53:42', '2019-12-16 16:20:27');
INSERT INTO `tb_menu` VALUES ('49', '充值记录', 'admin:member:recharge', '/member/recharge', '', '2', '1', '47', '1', '1', '2019-12-16 15:54:17', '2019-12-18 16:58:10');
INSERT INTO `tb_menu` VALUES ('50', '车位管理', 'admin:garage:car', '/garage/car', '', '2', '1', '44', '1', '1', '2019-12-16 15:55:03', '2019-12-18 16:58:02');
INSERT INTO `tb_menu` VALUES ('51', '新增', 'admin:garage:add', '/garage/add', '', '1', '2', '45', '1', '0', '2019-12-16 16:22:02', '2019-12-16 16:22:22');
INSERT INTO `tb_menu` VALUES ('52', '删除', 'admin:garage:delete', '/garage/remove', '', '1', '2', '45', '1', '0', '2019-12-16 16:23:48', null);
INSERT INTO `tb_menu` VALUES ('53', '批量删除', 'admin:garage:batchDelete', '/garage/remove', '', '1', '2', '45', '1', '0', '2019-12-16 16:24:38', null);
INSERT INTO `tb_menu` VALUES ('54', '新增', 'admin:repair:add', '/repair/add', '', '1', '2', '46', '1', '0', '2019-12-16 16:25:41', null);
INSERT INTO `tb_menu` VALUES ('55', '删除', 'admin:repair:delete', '/repair/remove', '', '1', '2', '46', '1', '0', '2019-12-16 16:26:35', null);
INSERT INTO `tb_menu` VALUES ('56', '批量删除', 'admin:repair:batchDelete', '/repair/remove', '', '1', '2', '46', '1', '0', '2019-12-16 16:27:54', null);

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `member_id` bigint(20) DEFAULT NULL COMMENT '会员ID',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `license` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `garage_id` bigint(20) DEFAULT NULL COMMENT '车库ID',
  `garage_name` varchar(50) DEFAULT NULL COMMENT '车库名称',
  `car_id` varchar(20) DEFAULT NULL COMMENT '车位编码',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '单价',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '合计',
  `status` int(11) DEFAULT '0' COMMENT '交易状态(0：未付款；1：已付款；2：交易关闭)',
  `pay_type` int(11) DEFAULT '0' COMMENT '支付方式(0：微信；1：钱包)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `start_time` datetime DEFAULT NULL COMMENT '停车时间',
  `end_time` datetime DEFAULT NULL COMMENT '取车时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '158382128628044', '6', '测试号', '粤A00000', '1', '智汇Park立体停车库', 'A1', '5.00', '100.00', '1', '0', null, '2020-03-16 14:21:26', '2020-03-17 10:52:29');
INSERT INTO `tb_order` VALUES ('2', '158399651789849', '6', '测试号', '粤A00000', '2', '智能停车库测试1', 'A1', '6.00', '12.00', '1', '0', null, '2020-03-16 15:01:58', '2020-03-16 17:01:58');
INSERT INTO `tb_order` VALUES ('3', '158441168071474', '6', '测试号', '粤A00000', '3', '智能停车库测试2', 'A1', '5.00', '15.00', '1', '0', null, '2020-03-17 10:21:21', '2020-03-17 14:07:58');
INSERT INTO `tb_order` VALUES ('4', '158442529674361', '6', '测试号', '粤A00000', '4', '智能停车库测试3', 'A1', '8.00', '8.00', '1', '0', null, '2020-03-17 13:08:17', '2020-03-17 14:50:21');
INSERT INTO `tb_order` VALUES ('5', '158442782912177', '6', '测试号', '粤A00000', '5', '智能停车库测试4', 'A1', '7.00', '21.00', '1', '0', null, '2020-03-17 14:50:29', '2020-03-17 17:57:36');
INSERT INTO `tb_order` VALUES ('6', '158449576437867', '6', '测试号', '粤A00000', '1', '智汇Park立体停车库', 'A1', '5.00', '25.00', '1', '0', null, '2020-03-18 09:42:44', '2020-03-18 14:48:54');
INSERT INTO `tb_order` VALUES ('7', '158460054231939', '6', '测试号', '粤A00000', '1', '智汇Park立体停车库', 'A1', '5.00', '30.00', '1', '0', null, '2020-03-19 08:49:02', '2020-03-19 15:17:07');
INSERT INTO `tb_order` VALUES ('8', '158460224553397', '6', '测试号', '粤A00000', '3', '智能停车库测试2', 'A1', '5.00', '25.00', '1', '0', null, '2020-03-19 10:17:26', '2020-03-19 15:20:33');
INSERT INTO `tb_order` VALUES ('9', '158460283506957', '6', '测试号', '粤A00000', '1', '智汇Park立体停车库', 'A1', '5.00', '20.00', '1', '0', null, '2020-03-19 11:27:15', '2020-03-19 15:28:31');
INSERT INTO `tb_order` VALUES ('10', '158468424591483', '6', '测试号', '粤A00000', '6', '智能停车库测试5', 'A1', '6.00', '12.00', '1', '1', null, '2020-03-20 14:04:06', '2020-03-20 16:04:06');
INSERT INTO `tb_order` VALUES ('11', '158495598312314', '6', '测试号', '粤A00000', '6', '智能停车库测试5', 'A1', '6.00', '18.00', '1', '1', null, '2020-03-23 14:33:03', '2020-03-23 17:33:35');

-- ----------------------------
-- Table structure for tb_recharge
-- ----------------------------
DROP TABLE IF EXISTS `tb_recharge`;
CREATE TABLE `tb_recharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) DEFAULT NULL COMMENT '交易编号',
  `member_id` bigint(20) DEFAULT NULL COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `money` decimal(10,2) DEFAULT '0.00' COMMENT '充值金额',
  `status` int(11) DEFAULT '0' COMMENT '交易状态(0：未付款；1：已付款；2：交易关闭)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_recharge
-- ----------------------------
INSERT INTO `tb_recharge` VALUES ('2', '158468544781189', '6', '测试号', '100.00', '1', null, '2020-03-20 14:24:08');
INSERT INTO `tb_recharge` VALUES ('3', '158468565064573', '6', '测试号', '50.00', '1', null, '2020-03-20 14:27:31');
INSERT INTO `tb_recharge` VALUES ('4', '158468574070264', '6', '测试号', '60.00', '1', null, '2020-03-20 14:29:01');
INSERT INTO `tb_recharge` VALUES ('5', '158468603238402', '6', '测试号', '30.00', '1', null, '2020-03-20 14:33:52');
INSERT INTO `tb_recharge` VALUES ('6', '158468610497254', '6', '测试号', '70.00', '1', null, '2020-03-20 14:35:05');
INSERT INTO `tb_recharge` VALUES ('7', '158468622273256', '6', '测试号', '40.00', '1', null, '2020-03-20 14:37:03');

-- ----------------------------
-- Table structure for tb_repair
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair`;
CREATE TABLE `tb_repair` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT '0' COMMENT '故障类型(0：机械故障，1：电气故障)',
  `name` varchar(100) DEFAULT NULL COMMENT '故障名',
  `error_time` datetime DEFAULT NULL COMMENT '故障时间',
  `garage_id` bigint(20) DEFAULT NULL COMMENT '车库ID',
  `garage_name` varchar(50) DEFAULT NULL COMMENT '车库名称',
  `repairer` varchar(50) DEFAULT NULL COMMENT '维修员',
  `phone` varchar(50) DEFAULT NULL COMMENT '维修员手机号',
  `status` int(11) DEFAULT '0' COMMENT '状态(0：待处理；1：已报修；2：维修中；3：恢复运行)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_repair
-- ----------------------------
INSERT INTO `tb_repair` VALUES ('1', '0', '未知', '2020-03-19 14:26:30', '1', '智汇Park立体停车库', '未知', '11111111', '0', '', '2020-03-19 14:26:43');
INSERT INTO `tb_repair` VALUES ('2', '0', '未知', '2020-03-19 14:26:42', '2', '智能停车库测试1', '未知', '11111111', '0', '', '2020-03-19 14:27:11');
INSERT INTO `tb_repair` VALUES ('3', '1', '未知', '2020-03-19 14:28:00', '3', '智能停车库测试2', '未知', '11111111', '0', '', '2020-03-19 14:28:10');
INSERT INTO `tb_repair` VALUES ('4', '1', '未知', '2020-03-19 14:30:11', '4', '智能停车库测试3', '未知', '1111111', '0', '', '2020-03-19 14:30:19');
INSERT INTO `tb_repair` VALUES ('5', '0', '未知', '2020-03-19 14:30:18', '5', '智能停车库测试4', '未知', '111111', '0', '', '2020-03-19 14:30:37');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '超级管理员', '1', 'admin');
INSERT INTO `tb_role` VALUES ('2', '普通用户', '2', 'user');
INSERT INTO `tb_role` VALUES ('3', '游客', '4', 'visitor');
INSERT INTO `tb_role` VALUES ('4', '运行维护', '3', 'maintain');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('239', '1', '1');
INSERT INTO `tb_role_menu` VALUES ('240', '2', '1');
INSERT INTO `tb_role_menu` VALUES ('241', '4', '1');
INSERT INTO `tb_role_menu` VALUES ('242', '5', '1');
INSERT INTO `tb_role_menu` VALUES ('243', '6', '1');
INSERT INTO `tb_role_menu` VALUES ('244', '11', '1');
INSERT INTO `tb_role_menu` VALUES ('245', '12', '1');
INSERT INTO `tb_role_menu` VALUES ('246', '13', '1');
INSERT INTO `tb_role_menu` VALUES ('247', '19', '1');
INSERT INTO `tb_role_menu` VALUES ('248', '3', '1');
INSERT INTO `tb_role_menu` VALUES ('249', '7', '1');
INSERT INTO `tb_role_menu` VALUES ('250', '14', '1');
INSERT INTO `tb_role_menu` VALUES ('251', '15', '1');
INSERT INTO `tb_role_menu` VALUES ('252', '17', '1');
INSERT INTO `tb_role_menu` VALUES ('253', '33', '1');
INSERT INTO `tb_role_menu` VALUES ('254', '8', '1');
INSERT INTO `tb_role_menu` VALUES ('255', '9', '1');
INSERT INTO `tb_role_menu` VALUES ('256', '10', '1');
INSERT INTO `tb_role_menu` VALUES ('257', '16', '1');
INSERT INTO `tb_role_menu` VALUES ('258', '20', '1');
INSERT INTO `tb_role_menu` VALUES ('259', '34', '1');
INSERT INTO `tb_role_menu` VALUES ('260', '35', '1');
INSERT INTO `tb_role_menu` VALUES ('261', '36', '1');
INSERT INTO `tb_role_menu` VALUES ('262', '37', '1');
INSERT INTO `tb_role_menu` VALUES ('263', '38', '1');
INSERT INTO `tb_role_menu` VALUES ('264', '26', '1');
INSERT INTO `tb_role_menu` VALUES ('265', '43', '1');
INSERT INTO `tb_role_menu` VALUES ('266', '30', '1');
INSERT INTO `tb_role_menu` VALUES ('267', '27', '1');
INSERT INTO `tb_role_menu` VALUES ('268', '28', '1');
INSERT INTO `tb_role_menu` VALUES ('269', '40', '1');
INSERT INTO `tb_role_menu` VALUES ('270', '42', '1');
INSERT INTO `tb_role_menu` VALUES ('271', '32', '1');
INSERT INTO `tb_role_menu` VALUES ('272', '18', '1');
INSERT INTO `tb_role_menu` VALUES ('273', '22', '1');
INSERT INTO `tb_role_menu` VALUES ('274', '29', '1');
INSERT INTO `tb_role_menu` VALUES ('275', '39', '1');
INSERT INTO `tb_role_menu` VALUES ('276', '41', '1');
INSERT INTO `tb_role_menu` VALUES ('277', '44', '1');
INSERT INTO `tb_role_menu` VALUES ('278', '45', '1');
INSERT INTO `tb_role_menu` VALUES ('279', '51', '1');
INSERT INTO `tb_role_menu` VALUES ('280', '52', '1');
INSERT INTO `tb_role_menu` VALUES ('281', '53', '1');
INSERT INTO `tb_role_menu` VALUES ('282', '46', '1');
INSERT INTO `tb_role_menu` VALUES ('283', '54', '1');
INSERT INTO `tb_role_menu` VALUES ('284', '55', '1');
INSERT INTO `tb_role_menu` VALUES ('285', '56', '1');
INSERT INTO `tb_role_menu` VALUES ('286', '50', '1');
INSERT INTO `tb_role_menu` VALUES ('287', '47', '1');
INSERT INTO `tb_role_menu` VALUES ('288', '48', '1');
INSERT INTO `tb_role_menu` VALUES ('289', '49', '1');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` int(4) DEFAULT NULL COMMENT '性别（0：女, 1：男）',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(4) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '超级管理员', '66bafb9fb704934fd46fdd25d1d38326', '1999-12-28', '0', '18594069681', 'admin@163.com', '5', '1', '广州', 'http://192.168.229.128/images/2019/04/3998a7da487d481a8ba438e1d089a7d6.png', '2018-06-01 16:47:30');
INSERT INTO `tb_user` VALUES ('2', 'sunny', '向日葵', 'd126ac77903c9c2021327a77a00b0022', '2011-01-26', '0', '12345678901', 'sunny@163.com', '3', '1', null, 'http://192.168.229.128/images/2019/04/b524937a7d1a459db201567ac25b15ac.png', '2018-06-12 17:18:09');
INSERT INTO `tb_user` VALUES ('3', 'lian', '连先生', '53f79b7b9b48b1c37ce9730feecd0bdb', '2010-04-30', '1', '12345678901', 'lian@qq.com', '1', '1', null, 'http://192.168.229.128/images/2019/04/96af958b13bf4fa59e1fa11fbf2a7291.png', '2018-06-12 17:19:11');
INSERT INTO `tb_user` VALUES ('4', 'lucy', '陆茜', 'ee1b3692585f4a553fc0c35288f49123', '2010-01-31', '0', '45646546', 'lucy@163.com', '3', '2', null, 'http://192.168.229.128/images/2019/04/258b5f91065341e8a66a2f3f092c743f.png', '2019-04-02 14:05:24');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('5', '1', '1');
INSERT INTO `tb_user_role` VALUES ('6', '2', '3');
INSERT INTO `tb_user_role` VALUES ('7', '3', '2');
INSERT INTO `tb_user_role` VALUES ('8', '4', '2');
