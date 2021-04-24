-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.89-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema institutemanagement
--

CREATE DATABASE IF NOT EXISTS institutemanagement;
USE institutemanagement;

--
-- Definition of table `branchinfo`
--

DROP TABLE IF EXISTS `branchinfo`;
CREATE TABLE `branchinfo` (
  `branchid` varchar(20) NOT NULL,
  `branchname` varchar(100) default NULL,
  PRIMARY KEY  (`branchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchinfo`
--

/*!40000 ALTER TABLE `branchinfo` DISABLE KEYS */;
INSERT INTO `branchinfo` (`branchid`,`branchname`) VALUES 
 ('AEI','Applied'),
 ('Civil','civil'),
 ('cse','Computer Science'),
 ('ECE','Electronics & Communication'),
 ('EE','electrical engg'),
 ('IT','Information Technology'),
 ('ME','mechanical');
/*!40000 ALTER TABLE `branchinfo` ENABLE KEYS */;


--
-- Definition of table `collegeinfo`
--

DROP TABLE IF EXISTS `collegeinfo`;
CREATE TABLE `collegeinfo` (
  `collegeid` varchar(20) NOT NULL,
  `collegename` varchar(100) default NULL,
  PRIMARY KEY  (`collegeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `collegeinfo`
--

/*!40000 ALTER TABLE `collegeinfo` DISABLE KEYS */;
INSERT INTO `collegeinfo` (`collegeid`,`collegename`) VALUES 
 ('Dev polytechnic','Dev polytechnic collage'),
 ('HITM','hindustan institute of technology and management'),
 ('JMIETI','Seth Jai Prakash Mukand lal Innovative Engineering And Technology Institue'),
 ('JMIT','Seth Jai Prakash Mukand Lal Institute of Technology'),
 ('MLN','Mukand Lal National College');
/*!40000 ALTER TABLE `collegeinfo` ENABLE KEYS */;


--
-- Definition of table `courseinfo`
--

DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo` (
  `courseid` varchar(100) NOT NULL,
  `coursename` varchar(100) default NULL,
  `coursefee` int(11) default NULL,
  PRIMARY KEY  (`courseid`),
  UNIQUE KEY `coursename` (`coursename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courseinfo`
--

/*!40000 ALTER TABLE `courseinfo` DISABLE KEYS */;
INSERT INTO `courseinfo` (`courseid`,`coursename`,`coursefee`) VALUES 
 ('adca','advance diploma',12000),
 ('AJ','Advance Java',8000),
 ('C','Programmin in C',2000),
 ('CAD','computer added desing',3000),
 ('CJ','Core Java',8000),
 ('CPP','Programming in C++',4000),
 ('ME','machine engineering',5000);
/*!40000 ALTER TABLE `courseinfo` ENABLE KEYS */;


--
-- Definition of table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) default NULL,
  `rolename` varchar(100) default NULL,
  `lastlogin` datetime default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

/*!40000 ALTER TABLE `logininfo` DISABLE KEYS */;
INSERT INTO `logininfo` (`username`,`password`,`rolename`,`lastlogin`) VALUES 
 ('admin','admin','Admin','2017-11-16 13:36:53'),
 ('hitm','hitm','User','2017-10-06 12:51:25');
/*!40000 ALTER TABLE `logininfo` ENABLE KEYS */;


--
-- Definition of table `studentcourse`
--

DROP TABLE IF EXISTS `studentcourse`;
CREATE TABLE `studentcourse` (
  `srno` int(11) NOT NULL auto_increment,
  `studentid` int(11) default NULL,
  `courseid` varchar(20) default NULL,
  `coursefee` int(11) default NULL,
  `startdate` date default NULL,
  `enddate` date default NULL,
  PRIMARY KEY  (`srno`),
  UNIQUE KEY `studentid` (`studentid`,`courseid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `studentcourse_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `studentinfo` (`studentid`),
  CONSTRAINT `studentcourse_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentcourse`
--

/*!40000 ALTER TABLE `studentcourse` DISABLE KEYS */;
INSERT INTO `studentcourse` (`srno`,`studentid`,`courseid`,`coursefee`,`startdate`,`enddate`) VALUES 
 (5,7,'AJ',0,'2014-02-02','2015-08-13'),
 (7,2,'AJ',0,'2013-01-02','2015-08-13'),
 (9,7,'CJ',6000,'2013-03-03','2015-08-14'),
 (10,2,'CPP',4000,'2013-10-03','2015-08-13'),
 (12,9,'AJ',8000,'2013-09-03','2015-08-13'),
 (13,2,'CJ',6000,'2012-02-03','2016-11-11'),
 (14,7,'CPP',4000,'2013-02-03','2016-11-11'),
 (15,19,'CJ',8000,'1996-06-05','2016-11-11'),
 (16,20,'ME',65000,'1996-10-25',NULL),
 (17,17,'CJ',8000,'2013-04-04',NULL),
 (18,23,'C',2000,'2016-08-01',NULL),
 (19,24,'C',2000,'2016-08-01',NULL),
 (20,25,'AJ',8000,'2016-08-01',NULL),
 (21,21,'CAD',3000,'2016-08-01',NULL),
 (22,23,'CJ',8000,'2015-02-01',NULL),
 (23,23,'AJ',8000,'2014-08-01','2016-11-21'),
 (24,26,'adca',12000,'2016-05-01',NULL),
 (25,21,'C',2000,'2015-02-01',NULL),
 (26,22,'AJ',8000,'2016-03-02',NULL),
 (27,19,'AJ',8000,'2016-01-03',NULL),
 (28,19,'C',2000,'2016-01-01',NULL);
/*!40000 ALTER TABLE `studentcourse` ENABLE KEYS */;


--
-- Definition of table `studentfee`
--

DROP TABLE IF EXISTS `studentfee`;
CREATE TABLE `studentfee` (
  `srno` int(11) NOT NULL auto_increment,
  `studentid` int(11) default NULL,
  `courseid` varchar(20) default NULL,
  `feeamount` int(11) default NULL,
  `feedate` date default NULL,
  PRIMARY KEY  (`srno`),
  KEY `studentid` (`studentid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `studentfee_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `studentinfo` (`studentid`),
  CONSTRAINT `studentfee_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentfee`
--

/*!40000 ALTER TABLE `studentfee` DISABLE KEYS */;
INSERT INTO `studentfee` (`srno`,`studentid`,`courseid`,`feeamount`,`feedate`) VALUES 
 (1,2,'AJ',8000,'2016-11-11'),
 (2,7,'CJ',6000,'2016-11-11'),
 (3,19,'CJ',8000,'2016-11-11'),
 (4,20,'ME',65000,'2016-11-11'),
 (5,19,'CJ',8000,'2016-11-21'),
 (6,19,'CJ',6000,'2016-11-21'),
 (7,19,'CJ',6000,'2016-11-21');
/*!40000 ALTER TABLE `studentfee` ENABLE KEYS */;


--
-- Definition of table `studentinfo`
--

DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `studentid` int(11) NOT NULL auto_increment,
  `studentname` varchar(100) default NULL,
  `fathername` varchar(100) default NULL,
  `contactno` varchar(50) default NULL,
  `collegeid` varchar(20) default NULL,
  `branchid` varchar(20) default NULL,
  PRIMARY KEY  (`studentid`),
  KEY `collegeid` (`collegeid`),
  KEY `branchid` (`branchid`),
  CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`collegeid`) REFERENCES `collegeinfo` (`collegeid`),
  CONSTRAINT `studentinfo_ibfk_2` FOREIGN KEY (`branchid`) REFERENCES `branchinfo` (`branchid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentinfo`
--

/*!40000 ALTER TABLE `studentinfo` DISABLE KEYS */;
INSERT INTO `studentinfo` (`studentid`,`studentname`,`fathername`,`contactno`,`collegeid`,`branchid`) VALUES 
 (2,'Srishti MIttal','Sanjay MIttal','79173628','JMIT','cse'),
 (7,'Palak','Ajit','76578','JMIT','ECE'),
 (9,'savi','rameshgg','12434647','JMIT','ECE'),
 (17,'krishna','Sanjay','843673','JMIT','cse'),
 (19,'gouri shankar','rajesh kumar','9896643375','HITM','cse'),
 (20,'Ajay kumar','Daroga yadav','8950720645','HITM','ME'),
 (21,'Krishna kumar raj','pravindra kumar ram','7206271427','Dev polytechnic','Civil'),
 (22,'mahindar kumar gond','jhaman gond','7206271476','Dev polytechnic','Civil'),
 (23,'Sanajiv kumar','umesh prasad yadav','9525285764','Dev polytechnic','cse'),
 (24,'sivani','krishna prasad yadav','9525285764','Dev polytechnic','cse'),
 (25,'nitu shingh','jasvindar singh','9525285769','Dev polytechnic','cse'),
 (26,'Sarvesh kumar','Nagendara ram','8684015224','Dev polytechnic','EE'),
 (27,'Sujeet','mohan','7587072087','HITM','cse'),
 (28,'Sujeet','mohan','9973666476','HITM','cse'),
 (29,'Sujeet','mohan','9973666476','HITM','cse'),
 (30,'Sandeep','Brahmjit','8930929730','HITM','cse');
/*!40000 ALTER TABLE `studentinfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
