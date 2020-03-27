/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.34-community : Database - team
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`team` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `team`;

/*Table structure for table `annex` */

DROP TABLE IF EXISTS `annex`;

CREATE TABLE `annex` (
  `annex_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `link` varchar(255) DEFAULT NULL COMMENT '附件链接',
  PRIMARY KEY (`annex_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

/*Data for the table `annex` */

insert  into `annex`(`annex_id`,`user_id`,`link`) values (1,12,'xxx'),(2,12,'xxx'),(3,12,'xxx');

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `apply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `team_id` bigint(20) DEFAULT NULL COMMENT '团队ID号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请人ID号',
  `user_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '申请人',
  `apply_date` date DEFAULT NULL COMMENT '申请时间',
  `decribe` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '申请描述',
  `phone` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(4) DEFAULT NULL COMMENT '申请状态',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `apply` */

insert  into `apply`(`apply_id`,`team_id`,`user_id`,`user_name`,`apply_date`,`decribe`,`phone`,`status`) values (1,1,111,'crw','2019-12-26','apply_info','12345678',0),(2,1,111,'crw','2019-12-26','apply_info','12345678',0),(3,1,111,'crw','2019-12-26','apply_info','12345678',0),(4,1,111,'crw','2019-12-26','apply_info','12345678',0),(5,1,111,'crw','2019-12-26','apply_info','12345678',0),(6,1,111,'crw','2019-12-26','apply_info','12345678',0),(7,1,111,'crw','2019-12-26','apply_info','12345678',0),(8,1,111,'crw','2019-12-26','apply_info','12345678',0),(9,1,111,'crw','2019-12-26','apply_info','12345678',0),(10,1,111,'crw','2019-12-26','apply_info','12345678',0),(11,1,111,'crw','2019-12-26','apply_info','12345678',0),(12,1,111,'crw','2019-12-26','apply_info','12345678',0),(13,1,111,'crw','2019-12-26','apply_info','12345678',0),(14,1,111,'crw','2019-12-26','apply_info','12345678',0),(15,1,111,'crw','2019-12-26','apply_info','12345678',0),(16,1,111,'crw','2019-12-26','apply_info','12345678',0),(17,1,111,'crw','2019-12-26','apply_info','12345678',0),(18,1,111,'crw','2019-12-26','apply_info','12345678',0),(19,1,111,'crw','2019-12-26','apply_info','12345678',0),(20,1,111,'crw','2019-12-26','apply_info','12345678',0),(21,1,111,'crw','2019-12-26','apply_info','12345678',0),(22,1,111,'crw','2019-12-26','apply_info','12345678',0),(23,1,111,'crw','2019-12-26','apply_info','12345678',0),(24,1,111,'crw','2019-12-26','apply_info','12345678',0),(25,1,111,'crw','2019-12-26','apply_info','12345678',0),(26,1,111,'crw','2019-12-26','apply_info','12345678',0);

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `pro_type` varchar(255) DEFAULT NULL COMMENT '项目类型',
  `university` varchar(255) DEFAULT NULL COMMENT '学校',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `dictionary` */

insert  into `dictionary`(`dict_id`,`pro_type`,`university`) values (1,'技术类,业余类','广东金融学院,广东工业大学');

/*Table structure for table `invite` */

DROP TABLE IF EXISTS `invite`;

CREATE TABLE `invite` (
  `invite_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '队长ID',
  `team_id` bigint(20) DEFAULT NULL COMMENT '团队ID',
  `date` date DEFAULT NULL COMMENT '邀请时间',
  `status` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '邀请状态',
  PRIMARY KEY (`invite_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `invite` */

insert  into `invite`(`invite_id`,`user_id`,`team_id`,`date`,`status`) values (1,1,11,'2019-12-26','1'),(2,1,11,'2019-12-26','1'),(3,1,11,'2019-12-26','1'),(4,1,11,'2019-12-26','1'),(5,1,11,'2019-12-26','1'),(6,1,11,'2019-12-26','1'),(7,1,11,'2019-12-26','1'),(8,1,11,'2019-12-26','1'),(9,1,11,'2019-12-26','1'),(10,1,11,'2019-12-26','1'),(11,1,11,'2019-12-26','1'),(12,1,11,'2019-12-26','1'),(13,1,11,'2019-12-26','1'),(14,1,11,'2019-12-26','1'),(15,1,11,'2019-12-26','1'),(16,1,11,'2019-12-26','1'),(17,1,11,'2019-12-26','1'),(18,1,11,'2019-12-26','1'),(19,1,11,'2019-12-26','1'),(20,1,11,'2019-12-26','1'),(21,1,11,'2019-12-26','1'),(22,1,11,'2019-12-26','1'),(23,1,11,'2019-12-26','1'),(24,1,11,'2019-12-26','1'),(25,1,11,'2019-12-26','1'),(26,1,11,'2019-12-26','1');

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '用户',
  `type` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '操作类型',
  `time` date DEFAULT NULL COMMENT '操作时间',
  `result` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '操作结果',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `log` */

insert  into `log`(`log_id`,`user_id`,`user_name`,`type`,`time`,`result`) values (1,11,'crw','0','2020-01-20',NULL),(2,11,'crw','0','2020-01-20',NULL),(3,11,'crw','0','2020-01-20',NULL),(4,11,'crw','0','2020-01-20',NULL),(5,11,'crw','0','2020-01-20',NULL),(6,11,'crw','0','2020-01-20',NULL),(7,11,'crw','0','2020-01-20',NULL),(8,11,'crw','0','2020-01-20',NULL),(9,11,'crw','0','2020-01-20',NULL),(10,11,'crw','0','2020-01-20',NULL),(11,11,'crw','0','2020-01-20',NULL),(12,11,'crw','0','2020-01-20',NULL),(13,11,'crw','0','2020-01-20',NULL),(14,11,'crw','0','2020-01-20',NULL),(15,11,'crw','0','2020-01-20',NULL),(16,11,'crw','0','2020-01-20',NULL),(17,11,'crw','0','2020-01-20',NULL),(18,11,'crw','0','2020-01-20',NULL);

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `pro_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pro_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '项目名称',
  `leader_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '队长名称',
  `pro_describe` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '项目描述',
  `pro_date` date DEFAULT NULL COMMENT '项目创建时间',
  `pro_start_time` date DEFAULT NULL COMMENT '项目开始时间',
  `pro_end_time` date DEFAULT NULL COMMENT '项目结束时间',
  `pro_status` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '项目当前状态',
  `team_id` bigint(20) DEFAULT NULL COMMENT '所属团队id号',
  `pro_type` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '项目类型',
  `pro_current_num` int(11) DEFAULT NULL COMMENT '项目当前人数',
  `pro_limied_num` int(11) DEFAULT NULL COMMENT '项目限制人数',
  `number` int(11) DEFAULT NULL COMMENT '项目人数',
  `see_num` int(11) DEFAULT NULL COMMENT '查看人数',
  `staff_list` varchar(255) DEFAULT NULL COMMENT '技术类型',
  `staff` varchar(255) DEFAULT NULL COMMENT '人员类型',
  PRIMARY KEY (`pro_id`),
  KEY `PK_team_id` (`team_id`),
  CONSTRAINT `PK_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`pro_id`,`pro_name`,`leader_name`,`pro_describe`,`pro_date`,`pro_start_time`,`pro_end_time`,`pro_status`,`team_id`,`pro_type`,`pro_current_num`,`pro_limied_num`,`number`,`see_num`,`staff_list`,`staff`) values (1,'组队系统设计','曹荣武','毕业设计，组队系统设计','2020-01-20','2020-01-20','2020-01-20','未完成',1,'技术类',12,50,13,25,'1','staff'),(2,'毕业就业管理系统设计','豪宗超','毕业设计，毕业就业管理系统设计','2020-01-20','2020-01-20','2020-01-20','未完成',2,'技术类',21,50,21,22,'1','staff'),(3,'淘宝系统设计','马云','网上商城购物系统','2020-01-20','2020-01-20','2020-01-20','已完成',3,'技术类',22,50,23,22,'1','staff'),(4,'京东商城',NULL,'强哥','2020-03-24','2020-03-24','2020-03-24','未完成',1,'销售类',23,50,12,23,'销售能力','staff');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID号',
  `role_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`role_id`,`role_name`) values (1,1,'ADMIN'),(2,2,'USER'),(3,2,'USER'),(4,2,'USER'),(5,2,'USER'),(6,2,'USER'),(7,2,'USER'),(8,2,'USER'),(9,2,'USER'),(10,2,'USER'),(11,2,'USER'),(12,2,'USER'),(13,2,'USER'),(14,2,'USER'),(15,2,'USER');

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staff_id` bigint(20) DEFAULT NULL COMMENT '人员类型ID',
  `staff_name` varchar(255) DEFAULT NULL COMMENT '需要人员描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `staff` */

/*Table structure for table `sub_task` */

DROP TABLE IF EXISTS `sub_task`;

CREATE TABLE `sub_task` (
  `sub_task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子任务ID',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务id',
  `sub_task_content` varchar(255) DEFAULT NULL COMMENT '子任务内容',
  `sub_task_charger` varchar(255) DEFAULT NULL COMMENT '子任务负责人',
  `sub_task_status` tinyint(4) DEFAULT NULL COMMENT '子任务状态',
  PRIMARY KEY (`sub_task_id`),
  KEY `task_id` (`task_id`),
  CONSTRAINT `sub_task_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `sub_task` */

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `team_id` bigint(20) DEFAULT NULL COMMENT '团队ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `task_create_time` date DEFAULT NULL COMMENT '任务创建时间',
  `task_start_time` date DEFAULT NULL COMMENT '任务开始时间',
  `task_end_time` date DEFAULT NULL COMMENT '任务结束时间',
  `task_content` varchar(255) DEFAULT NULL COMMENT '任务内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '任务负责人ID',
  `task_status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `task_mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`task_id`),
  KEY `team_id` (`team_id`),
  KEY `pro_id` (`pro_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`pro_id`) REFERENCES `project` (`pro_id`),
  CONSTRAINT `task_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`task_id`,`team_id`,`pro_id`,`task_create_time`,`task_start_time`,`task_end_time`,`task_content`,`user_id`,`task_status`,`task_mark`) values (1,1,1,'2020-02-02','2020-01-20','2020-01-20','任务内容',1,1,NULL),(2,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(3,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(4,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(5,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(6,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(7,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(8,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(9,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL),(10,1,1,'2020-01-20','2020-01-20','2020-01-20','任务内容',1,1,NULL);

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `team_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '团队名称',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '队长ID',
  `team_describe` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '团队描述',
  `team_type` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '团队类型',
  `team_scope` varchar(255) DEFAULT NULL COMMENT '团队范围（校内、校外）',
  `team_number` int(11) DEFAULT NULL COMMENT '团队人数',
  `team_date` date DEFAULT NULL COMMENT '团队创建日期',
  `status` tinyint(4) DEFAULT NULL COMMENT '团队状态',
  `staff` varchar(200) CHARACTER SET gb2312 DEFAULT NULL COMMENT '人员类型',
  `team_nature` varchar(255) DEFAULT NULL COMMENT '团队性质',
  `team_label` varchar(255) DEFAULT NULL COMMENT '团队标签',
  `see_num` int(11) DEFAULT NULL COMMENT '查看人数',
  PRIMARY KEY (`team_id`),
  KEY `PK_user_id` (`leader_id`),
  CONSTRAINT `PK_user_id` FOREIGN KEY (`leader_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `team` */

insert  into `team`(`team_id`,`team_name`,`leader_id`,`team_describe`,`team_type`,`team_scope`,`team_number`,`team_date`,`status`,`staff`,`team_nature`,`team_label`,`see_num`) values (1,'废铁团队',1,'废铁团队的团队描述','技术类','广东金融学院',33,'2020-01-20',1,'需要员工类型','个人项目','angular,springboot',21),(2,'HOWE团队',2,'HOWE团队描述','技术类','广东金融学院',33,'2020-02-02',1,'需要员工类型','个人项目','VUE,java,springboot',32),(3,'阿里团队',3,'阿里团队描述','技术类','所有学校',33,'2020-02-02',1,'需要员工类型','企业项目','java',43),(4,'百度团队',1,'百度团队描述','业余类','广东工业大学',21,'2020-03-24',0,'需要员工类型','班级项目','销售能力',54);

/*Table structure for table `team_type` */

DROP TABLE IF EXISTS `team_type`;

CREATE TABLE `team_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(255) CHARACTER SET gb2312 DEFAULT NULL,
  `value` varchar(255) CHARACTER SET gb2312 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `team_type` */

insert  into `team_type`(`id`,`key`,`value`) values (0,'0','技术类'),(1,'1','业余类'),(2,'2','金融类'),(3,'3','兴趣类'),(4,'4','社团类');

/*Table structure for table `university` */

DROP TABLE IF EXISTS `university`;

CREATE TABLE `university` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `university` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '学校名称',
  `college` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '学院名称',
  `profession` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

/*Data for the table `university` */

insert  into `university`(`id`,`university`,`college`,`profession`) values (1,'广东金融学院','互联网','计科'),(2,'广东工业大学','互联网','计科'),(3,'广东外语外贸大学','互联网','计科'),(4,'中南大学','互联网','计科'),(5,'华南理工大学','互联网','计科');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `user_name` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '用户名称',
  `user_avatar` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '头像',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `university` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '学校',
  `college` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '学院',
  `profession` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '专业',
  `grade` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '年级',
  `user_class` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '班级',
  `user_no` int(11) DEFAULT NULL COMMENT '学号',
  `user_tel` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '邮箱',
  `ability` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '掌握技能、能力',
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`role_id`,`user_name`,`user_avatar`,`gender`,`university`,`college`,`profession`,`grade`,`user_class`,`user_no`,`user_tel`,`email`,`ability`) values (1,1,'crw','xxx',1,'广东金融学院','互联网','计科','1','1',123456,'123456789','22233','no'),(2,2,'hzc','xxx',1,'广东金融学院','互联网','计科','1','1',123456,'123456789','22233','no'),(3,3,'admin','xxx',1,'广东工业大学','互联网','计科','1','1',123456,'123456789','22233','no');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET gb2312 DEFAULT NULL COMMENT '密码',
  `auth` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

insert  into `user_roles`(`id`,`username`,`password`,`auth`) values (1,'crw','$2a$10$KDGdMrFQXVON.j1r2m/GQ.Wgs5i9a1yUvgqZG3Yup2fRL7HAfubyS','USER'),(2,'hzc','$2a$10$4l9cT7zhe5EflasmBn47F.ScZxkaCZii3L30.oHFZK.TxMiGfqQjy','USER'),(3,'admin','$2a$10$XJhL3MwQYQjkgU0N0F1KKeLrBltLBDA2GezenpbGbQ3gMLukOcQLm','ADMIN');

/*Table structure for table `user_team` */

DROP TABLE IF EXISTS `user_team`;

CREATE TABLE `user_team` (
  `ut_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `team_id` bigint(20) DEFAULT NULL COMMENT '团队ID',
  `is_leader` tinyint(4) DEFAULT NULL COMMENT '是否是队长',
  PRIMARY KEY (`ut_id`),
  KEY `team_fk` (`team_id`),
  KEY `user_fk` (`user_id`),
  CONSTRAINT `team_fk` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user_team` */

insert  into `user_team`(`ut_id`,`user_id`,`team_id`,`is_leader`) values (1,1,1,1),(11,3,3,1),(12,2,2,1),(13,1,2,0),(14,2,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
