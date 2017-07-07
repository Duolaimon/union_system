/*
SQLyog v10.2 
MySQL - 5.5.19 : Database - db_union
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_union` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_union`;

/*Table structure for table `tb_advice` */

DROP TABLE IF EXISTS `tb_advice`;

CREATE TABLE `tb_advice` (
  `advice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `advice_num` varchar(20) DEFAULT NULL COMMENT '提案编号',
  `title` varchar(40) DEFAULT NULL COMMENT '标题',
  `advice_content` varchar(500) DEFAULT NULL COMMENT '内容',
  `advice_do` varchar(500) DEFAULT NULL COMMENT '建议措施',
  `advice_state` int(11) DEFAULT '0' COMMENT '提案状态',
  `count` int(11) DEFAULT '0' COMMENT '点赞数',
  `advice_agree` varchar(40) DEFAULT NULL COMMENT '点赞人',
  `advice_name` varchar(10) DEFAULT NULL COMMENT '提案人姓名',
  `advice_workspace` varchar(20) DEFAULT NULL COMMENT '提案人单位',
  `advice_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提案时间',
  `contactway` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `user_id` varchar(20) DEFAULT NULL COMMENT '提案人id',
  `department_id` varchar(20) DEFAULT NULL COMMENT '被提案部门id',
  PRIMARY KEY (`advice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_advice` */

insert  into `tb_advice`(`advice_id`,`advice_num`,`title`,`advice_content`,`advice_do`,`advice_state`,`count`,`advice_agree`,`advice_name`,`advice_workspace`,`advice_time`,`contactway`,`user_id`,`department_id`) values (1,'123','测试','测试','测试',3,4,'测试','测试','测试','2017-07-04 19:55:33','11','54321','4');

/*Table structure for table `tb_committee` */

DROP TABLE IF EXISTS `tb_committee`;

CREATE TABLE `tb_committee` (
  `committee_id` varchar(5) NOT NULL,
  `committee_pass` varchar(10) DEFAULT NULL,
  `committee_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`committee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_committee` */

insert  into `tb_committee`(`committee_id`,`committee_pass`,`committee_name`) values ('20145','20145425','测试'),('54321','20145408','测试');

/*Table structure for table `tb_department` */

DROP TABLE IF EXISTS `tb_department`;

CREATE TABLE `tb_department` (
  `department_id` varchar(5) NOT NULL,
  `department_password` varchar(10) DEFAULT NULL,
  `department_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_department` */

insert  into `tb_department`(`department_id`,`department_password`,`department_name`) values ('1','test','测试'),('2','test','测试'),('3','test','测试'),('4','test','测试'),('5','test','测试'),('6','test','测试'),('7','test','测试');

/*Table structure for table `tb_event` */

DROP TABLE IF EXISTS `tb_event`;

CREATE TABLE `tb_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_title` varchar(50) DEFAULT NULL,
  `event_content` varchar(1000) DEFAULT NULL,
  `event_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tb_event` */

insert  into `tb_event`(`event_id`,`event_title`,`event_content`,`event_time`) values (1,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:19'),(2,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:24'),(3,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:27'),(4,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:44'),(5,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:47'),(6,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:50'),(7,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:55'),(8,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:45:58'),(9,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:46:01'),(10,'校领导视察我校期末考试工作','严明副校长先后走访检查了信息管理学院、政府管理学院、教育科学研究院等相关考试教室，详细了解了学生考试情况，对考场秩序、考场纪律、试卷命题、出题情况、监考情况等方面进行了全面的巡视。','2017-07-05 21:46:06');

/*Table structure for table `tb_leader` */

DROP TABLE IF EXISTS `tb_leader`;

CREATE TABLE `tb_leader` (
  `leader_id` int(11) NOT NULL AUTO_INCREMENT,
  `leader_password` varchar(40) DEFAULT NULL,
  `leader_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`leader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20145426 DEFAULT CHARSET=utf8;

/*Data for the table `tb_leader` */

insert  into `tb_leader`(`leader_id`,`leader_password`,`leader_name`) values (20145425,'20145425','测试');

/*Table structure for table `tb_manage` */

DROP TABLE IF EXISTS `tb_manage`;

CREATE TABLE `tb_manage` (
  `manage_id` varchar(15) NOT NULL,
  `manage_pass` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`manage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_manage` */

insert  into `tb_manage`(`manage_id`,`manage_pass`) values ('20145408','20145408'),('20145425','20145425');

/*Table structure for table `tb_meeting` */

DROP TABLE IF EXISTS `tb_meeting`;

CREATE TABLE `tb_meeting` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_title` varchar(50) DEFAULT NULL,
  `meeting_content` varchar(1000) DEFAULT NULL,
  `meeting_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_meeting` */

/*Table structure for table `tb_news` */

DROP TABLE IF EXISTS `tb_news`;

CREATE TABLE `tb_news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(50) DEFAULT NULL,
  `news_content` varchar(1000) DEFAULT NULL,
  `news_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_news` */

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT,
  `eorganization_name` varchar(50) DEFAULT NULL,
  `organization_content` varchar(1000) DEFAULT NULL,
  `organization_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_organization` */

insert  into `tb_organization`(`organization_id`,eorganization_name,`organization_content`,`organization_time`) values (1,'组织机构','组织机构内容','2017-07-05 18:14:53');

/*Table structure for table `tb_question` */

DROP TABLE IF EXISTS `tb_question`;

CREATE TABLE `tb_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(50) DEFAULT NULL,
  `question_content` varchar(1000) DEFAULT NULL,
  `question_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_question` */

insert  into `tb_question`(`question_id`,`question_name`,`question_content`,`question_time`) values (1,'你以为是问题','其实是提案须知哒','2017-07-05 18:09:26');

/*Table structure for table `tb_reply` */

DROP TABLE IF EXISTS `tb_reply`;

CREATE TABLE `tb_reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_content` varchar(1000) DEFAULT NULL,
  `reply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reply_state` smallint(11) DEFAULT '0',
  `department_id` varchar(5) DEFAULT NULL,
  `advice_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_reply` */

/*Table structure for table `tb_rule` */

DROP TABLE IF EXISTS `tb_rule`;

CREATE TABLE `tb_rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(50) DEFAULT NULL,
  `rule_content` varchar(1000) DEFAULT NULL,
  `rule_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_rule` */

insert  into `tb_rule`(`rule_id`,`rule_name`,`rule_content`,`rule_time`) values (1,'规则','规则内容','2017-07-05 21:14:30');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
