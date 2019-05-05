-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `directories`
--

DROP TABLE IF EXISTS `directories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directories` (
  `name` varchar(10) NOT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `permission` varchar(10) DEFAULT NULL,
  `restriction` tinyint(1) DEFAULT NULL,
  `parent` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='																																																																																					';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directories`
--

LOCK TABLES `directories` WRITE;
/*!40000 ALTER TABLE `directories` DISABLE KEYS */;
INSERT INTO `directories` VALUES ('1','1','public',0,'0'),('2','1','public',0,'0'),('3','1','public',0,'0'),('22','2','public',0,'1'),('kkkl','5','protected',0,'22'),('k','5','private',1,'22'),('k2','5','protected',1,'22'),('k22','5','protected',0,'22'),('chk','5','public',0,'22');
/*!40000 ALTER TABLE `directories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_leave`
--

DROP TABLE IF EXISTS `emp_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_leave` (
  `managerID` varchar(10) DEFAULT NULL,
  `empID` varchar(10) DEFAULT NULL,
  `start_date` varchar(10) DEFAULT NULL,
  `end_date` varchar(10) DEFAULT NULL,
  `leave_count` int(2) DEFAULT NULL,
  `leave_type` varchar(10) DEFAULT NULL,
  `leave_status` tinyint(1) DEFAULT NULL,
  `manager_response` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_leave`
--

LOCK TABLES `emp_leave` WRITE;
/*!40000 ALTER TABLE `emp_leave` DISABLE KEYS */;
INSERT INTO `emp_leave` VALUES ('1','2','2011-11-11','2011-11-11',1,NULL,1,1),('1','2','2011-11-11','2011-11-11',1,NULL,0,1),('1','2','2011-11-11','2011-11-11',1,NULL,0,1),('1','3','2011-11-11','2011-11-13',3,NULL,0,1),('1','2','2011-11-11','2011-11-11',1,NULL,1,1),('e2345','e3456','2011-12-12','2011-12-12',1,NULL,1,1),('e2345','e3456','2011-12-12','2011-12-12',1,NULL,1,1),('e2345','e3456','2011-11-12','2011-11-12',1,NULL,1,1);
/*!40000 ALTER TABLE `emp_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_tracker`
--

DROP TABLE IF EXISTS `leave_tracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_tracker` (
  `empID` varchar(10) NOT NULL,
  `leave_count` int(2) DEFAULT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_tracker`
--

LOCK TABLES `leave_tracker` WRITE;
/*!40000 ALTER TABLE `leave_tracker` DISABLE KEYS */;
INSERT INTO `leave_tracker` VALUES ('1',1),('2',4),('3',3),('e1234',4),('e234',4),('e3456',4),('f4567',4);
/*!40000 ALTER TABLE `leave_tracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_table`
--

DROP TABLE IF EXISTS `login_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_table` (
  `username` varchar(14) DEFAULT NULL,
  `password` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_table`
--

LOCK TABLES `login_table` WRITE;
/*!40000 ALTER TABLE `login_table` DISABLE KEYS */;
INSERT INTO `login_table` VALUES ('111','111'),('222','222');
/*!40000 ALTER TABLE `login_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `empID` varchar(10) NOT NULL,
  `managerID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthly`
--

DROP TABLE IF EXISTS `monthly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthly` (
  `empID` varchar(10) DEFAULT NULL,
  `pay` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly`
--

LOCK TABLES `monthly` WRITE;
/*!40000 ALTER TABLE `monthly` DISABLE KEYS */;
INSERT INTO `monthly` VALUES ('1','1010.0'),('2','2020.0'),('3','2020.0'),('9','0.0'),('11','0.0'),('88','0.0'),('99','0.0'),('22','0.0'),('33','0.0'),('0','0');
/*!40000 ALTER TABLE `monthly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll` (
  `userID` varchar(10) DEFAULT NULL,
  `wage` float DEFAULT NULL,
  `bonus` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES ('1',1000,10),('2',2000,20),('3',2000,20),('9',8000,NULL),('11',10000,NULL),('88',0,NULL),('99',0,NULL),('22',0,NULL),('33',0,NULL),('ii',NULL,NULL),('8888',NULL,NULL),('e',100,NULL),('e1',0,NULL),('e2',0,NULL),('e3',0,NULL),('e4',0,NULL),('e1234',0,NULL),('e2345',0,NULL),('e3456',0,NULL),('f4567',0,NULL),('0',0,NULL);
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `fname` varchar(10) DEFAULT NULL,
  `lname` varchar(10) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `phoneNo` varchar(10) DEFAULT NULL,
  `emailID` varchar(20) DEFAULT NULL,
  `userID` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `manager` varchar(10) DEFAULT NULL,
  `department` varchar(10) DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('0','0','0','0','0','0','0','null','null','null','1'),('ggg','1','1','1','1','1','1','0','null','null','1'),('11','11','11','11','11','11','11','null','null','null','1'),('2','2','2','2','2','2','2','1','1','1','1'),('22','22','22','22','22','22','22','7','null','null','1'),('3','3','3','3','3','3','3','1','1','1','1'),('33','33','33','33','33','33','33','22','null','null','1'),('4','4','4','4','4','4','4','1','23','34','1'),('5','5','5','5','5','5','5','2','23','24','1'),('6','6','6','6','6','6','6','3','3','3','1'),('7','7','7','7','7','7','7','4','4','88','1'),('88','88','88','88','88','88','88','33','null','null','1'),('we','qq','qq','qq','qq','8888','eee',NULL,NULL,NULL,'0'),('9','9','9','9','9','9','9','4','ww','iii','1'),('99','99','99','99','99','99','99','5','null','null','1'),('a','sd','.xc,ma,.sdm','897897','dfdsf','a','1','1','tt','jkhgj','1'),('1','1','1','1','1','e','0','null','null','null','1'),('1','1','1','1','1','e1','1','e','null','null','1'),('qq','qq','qq','qq','qq','e1234','1','e','null','null','1'),('1','1','1','1','1','e2','2','e1','null','null','1'),('qq','qq','qq','qq','qq','e2345','2','e1234','null','null','1'),('1','1','1','1','1','e3','3','e2','null','null','1'),('qq','qq','qq','qq','qq','e3456','3','e2345','null','null','1'),('1','1','1','1','1','e4','4','e','null','null','1'),('qq','qq','qq','qq','qq','f4567','4','e','null','null','1'),('ii','ii','ii','ii','ii','ii','ii',NULL,NULL,NULL,'0');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-12  3:59:41
