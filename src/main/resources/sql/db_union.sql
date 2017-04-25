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
  `advice_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `advice_content` text,
  `advice_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `advice_state` tinyint(1) unsigned zerofill DEFAULT '0',
  `count` tinyint(3) unsigned zerofill DEFAULT '000',
  `user_id` varchar(7) DEFAULT NULL,
  `department_id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`advice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `tb_advice` */

insert  into `tb_advice`(`advice_id`,`title`,`advice_content`,`advice_time`,`advice_state`,`count`,`user_id`,`department_id`) values (1,'你好',NULL,'2017-04-12 19:01:56',4,003,'test','5'),(2,'title',NULL,'2017-04-12 20:35:14',2,000,'test','23'),(3,'title',NULL,'2017-04-12 18:58:49',4,012,'test','6'),(24,'title',NULL,'2017-04-10 17:46:58',5,005,'test','2'),(25,'title',NULL,'2017-04-12 19:01:10',5,004,'test','3'),(28,'title',NULL,'2017-04-10 17:47:05',2,022,'test','1'),(29,'1111','2222222222222222','2017-04-12 20:38:33',0,000,'test','6');

/*Table structure for table `tb_committee` */

DROP TABLE IF EXISTS `tb_committee`;

CREATE TABLE `tb_committee` (
  `committee_id` varchar(5) NOT NULL,
  `committee_pass` varchar(10) DEFAULT NULL,
  `committee_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`committee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_committee` */

insert  into `tb_committee`(`committee_id`,`committee_pass`,`committee_name`) values ('test','test','test'),('test_','test','test');

/*Table structure for table `tb_department` */

DROP TABLE IF EXISTS `tb_department`;

CREATE TABLE `tb_department` (
  `department_id` varchar(5) NOT NULL,
  `department_password` varchar(10) DEFAULT NULL,
  `department_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_department` */

insert  into `tb_department`(`department_id`,`department_password`,`department_name`) values ('1','test','test'),('10','test','test'),('11','test','test'),('12','test','test'),('13','test','test'),('14','test','test'),('15','test','test'),('16','test','test'),('17','test','test'),('18','test','test'),('19','test','test'),('2','test','test'),('20','test','test'),('21','test','test'),('22','test','test'),('23','test','test'),('24','test','test'),('25','test','test'),('26','test','test'),('27','test','test'),('28','test','test'),('29','test','test'),('3','test','test'),('30','test','test'),('4','test','test'),('5','test','test'),('6','test','test'),('7','test','test'),('8','test','test'),('9','test','test');

/*Table structure for table `tb_manage` */

DROP TABLE IF EXISTS `tb_manage`;

CREATE TABLE `tb_manage` (
  `manage_id` varchar(5) NOT NULL,
  `manage_pass` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`manage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_manage` */

insert  into `tb_manage`(`manage_id`,`manage_pass`) values ('test','test');

/*Table structure for table `tb_news` */

DROP TABLE IF EXISTS `tb_news`;

CREATE TABLE `tb_news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(50) DEFAULT NULL,
  `news_content` varchar(1000) DEFAULT NULL,
  `news_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_news` */

insert  into `tb_news`(`news_id`,`news_title`,`news_content`,`news_time`) values (1,'标题1','内容1','2017-04-08 11:26:58'),(2,'标题2','内容2','2017-04-08 11:27:14'),(3,'标题3','内容3 ','2017-04-08 11:27:30'),(4,'标题4 ','内容4','2017-04-08 11:27:43'),(5,'标题5 ','内容5','2017-04-08 11:27:54'),(6,'标题6','内容6','2017-04-08 11:28:08'),(7,'标题7','内容7','2017-04-08 11:28:24'),(8,'标题8','内容8','2017-04-08 11:28:35');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_reply` */

insert  into `tb_reply`(`reply_id`,`reply_content`,`reply_time`,`reply_state`,`department_id`,`advice_id`) values (2,'3','2017-04-08 18:01:27',1,'1',28),(3,'4','2017-04-08 12:50:19',1,'2',24),(4,'4','2017-04-08 12:50:24',1,'3',25),(5,'498聚会就很难 ','2017-04-10 21:17:26',1,'5',1),(6,'444','2017-04-10 21:18:45',1,'3',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
