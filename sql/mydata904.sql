# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: mydata
# ------------------------------------------------------
# Server version 5.0.45-community-nt

#
# Source for table books
#

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `isbn` varchar(20) NOT NULL,
  `bookName` varchar(150) NOT NULL,
  `publisherID` int(11) default '0' COMMENT '1:人民邮电出版社2:清华大学出版社3:电子工业出版社',
  `price` decimal(10,2) NOT NULL default '0.00',
  `count` int(11) default '0',
  `description` varchar(1000) default 'null',
  `pic` varchar(50) default 'null',
  PRIMARY KEY  (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='6';

#
# Dumping data for table books
#
LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;

INSERT INTO `books` VALUES ('8996733','C++ Primer Plus',3,23,30,'专业课','8996733.jpg');
INSERT INTO `books` VALUES ('9011122','C#设计模式',1,55,100,'专业课','9011122.jpg');
INSERT INTO `books` VALUES ('9025178','C++程序设计教程',2,32,90,'专业课','9025178.jpg');
INSERT INTO `books` VALUES ('9150365','C语言程序设计（第三版）',1,18,100,'基础课','9150365.jpg');
INSERT INTO `books` VALUES ('9157098','C++ prince 中文',2,33,100,'专业课','9157098.jpg');
INSERT INTO `books` VALUES ('9171366','C#入门经典',3,23,10,'基础课','9171366.jpg');
INSERT INTO `books` VALUES ('9191389','C#Objects',3,35,10,'专业课','9191389.jpg');
INSERT INTO `books` VALUES ('9221944','精通CSS',2,58,10,'专业课','9221944.jpg');
INSERT INTO `books` VALUES ('9222502','C#高级编程',2,13,60,'基础课','9222502.jpg');
INSERT INTO `books` VALUES ('9226773','框架设计',2,45,10,'专业课','9226773.jpg');
INSERT INTO `books` VALUES ('9241052','C++习题解答',2,29,10,'习题课','9241052.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table userdetail
#

DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `username` varchar(20) NOT NULL,
  `userpass` varchar(20) NOT NULL,
  `role` int(4) default '0' COMMENT '0：普通用户1：管理员',
  `regtime` varchar(50) default '0000-00-00 00:00:00',
  `lognum` int(11) default '0',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table userdetail
#
LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;

INSERT INTO `userdetail` VALUES ('hhh','123',0,'2011-05-08 10:36:12',21);
INSERT INTO `userdetail` VALUES ('jjj','123',1,'2011-05-08 10:34:26',0);
INSERT INTO `userdetail` VALUES ('lili','123',0,'2011-03-20 00:00:00',0);
INSERT INTO `userdetail` VALUES ('lilk','123',1,'2011-03-20 00:00:00',0);
INSERT INTO `userdetail` VALUES ('lily','123',0,'2011-03-20 00:00:00',0);
INSERT INTO `userdetail` VALUES ('opop','123',0,'2011-05-22 10:48:13',0);
INSERT INTO `userdetail` VALUES ('opop1','123',1,'2011-05-22 10:49:35',0);
INSERT INTO `userdetail` VALUES ('opop2','123',1,'2011-05-22 10:50:41',0);
INSERT INTO `userdetail` VALUES ('roo1','123',1,'2011-02-18 00:00:00',47);
INSERT INTO `userdetail` VALUES ('roo2','123',1,'2011-02-18 00:00:00',4);
INSERT INTO `userdetail` VALUES ('roo3','123',1,'2011-02-18 00:00:00',2);
INSERT INTO `userdetail` VALUES ('root','123',0,'2011-02-18 00:00:00',26);
INSERT INTO `userdetail` VALUES ('root1','123',1,'2011-02-18 00:00:00',16);
INSERT INTO `userdetail` VALUES ('root2','123',1,'2011-02-18 00:00:00',3);
INSERT INTO `userdetail` VALUES ('root6','123',1,'2011-02-18 00:00:00',7);
INSERT INTO `userdetail` VALUES ('root8','123',0,'2011-02-18 00:00:00',9);
INSERT INTO `userdetail` VALUES ('root9','123',0,'2011-02-18 00:00:00',4);
INSERT INTO `userdetail` VALUES ('user','123',0,'2011-02-26 00:00:00',6);
INSERT INTO `userdetail` VALUES ('xcx','123',0,'2017-03-14 02:12:19',0);
INSERT INTO `userdetail` VALUES ('yul','123',0,'2011-05-08 08:13:50',2);
INSERT INTO `userdetail` VALUES ('yulian','123',1,'2011-05-08 09:48:12',0);
INSERT INTO `userdetail` VALUES ('刘雅梦','123',0,'2011-03-04 00:00:00',0);
INSERT INTO `userdetail` VALUES ('宋红萍','123',0,'2011-03-17 00:00:00',1);
INSERT INTO `userdetail` VALUES ('小红鱼','123',0,'2011-06-07 11:37:15',2);
INSERT INTO `userdetail` VALUES ('徐翠霞','123',1,'2011-03-04 00:00:00',66);
INSERT INTO `userdetail` VALUES ('杨彬','123',1,'2011-03-20 00:00:00',0);
INSERT INTO `userdetail` VALUES ('杨泽宇','123',0,'2011-03-20 00:00:00',0);
INSERT INTO `userdetail` VALUES ('胥宗辉','123',1,'2011-03-04 00:00:00',40);
INSERT INTO `userdetail` VALUES ('胥拥军','123',1,'2011-03-04 00:00:00',11);
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
