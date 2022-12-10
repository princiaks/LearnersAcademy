-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: learnersacademy
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblclassdetails`
--

DROP TABLE IF EXISTS `tblclassdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblclassdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classname` varchar(60) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblclassdetails`
--

LOCK TABLES `tblclassdetails` WRITE;
/*!40000 ALTER TABLE `tblclassdetails` DISABLE KEYS */;
INSERT INTO `tblclassdetails` VALUES (4,'MCA','Active');
/*!40000 ALTER TABLE `tblclassdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbldesignationmaster`
--

DROP TABLE IF EXISTS `tbldesignationmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldesignationmaster` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(60) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldesignationmaster`
--

LOCK TABLES `tbldesignationmaster` WRITE;
/*!40000 ALTER TABLE `tbldesignationmaster` DISABLE KEYS */;
INSERT INTO `tbldesignationmaster` VALUES (9,'Guest Lecturer','Active'),(10,'Department Administrator','Active');
/*!40000 ALTER TABLE `tbldesignationmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsubjectdetails`
--

DROP TABLE IF EXISTS `tblsubjectdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblsubjectdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `subject` varchar(60) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `tblsubjectdetails_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `tblclassdetails` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsubjectdetails`
--

LOCK TABLES `tblsubjectdetails` WRITE;
/*!40000 ALTER TABLE `tblsubjectdetails` DISABLE KEYS */;
INSERT INTO `tblsubjectdetails` VALUES (4,4,'C++','Active'),(5,4,'Java','Active');
/*!40000 ALTER TABLE `tblsubjectdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbluser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `sclass` int DEFAULT NULL,
  `designation` int DEFAULT NULL,
  `subject` int DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` VALUES (1,'Admin','@learners','admin@learners','123456',NULL,NULL,NULL,NULL,NULL,NULL,'admin',NULL),(2,'a','bcd',NULL,NULL,'1992-05-05','asdsdf','123456789',NULL,NULL,NULL,'',NULL),(3,'Princia','KS',NULL,NULL,'1992-05-05','asdsdf','08943800347',0,0,0,'',NULL),(4,'fff','dsds',NULL,NULL,'1992-05-05','test@gmail.com','8945685214',0,0,0,'',NULL),(5,'fdsf','fdsfs',NULL,NULL,'2000-12-14','dsad@fdfdf.cdsfcd','5454656',0,0,0,'',NULL),(16,'Alex','Xaviour',NULL,NULL,'1992-05-05','india','9878457845',4,0,0,'student',NULL),(17,'Krithi','Sooraj',NULL,NULL,'1990-06-05','india','8975465874',4,0,0,'student',NULL),(18,'Anitha','PK',NULL,NULL,'1989-04-05','inda ','8975452547',0,9,4,'teacher',NULL),(19,'Binitha','Viswan',NULL,NULL,'1980-02-04','india ','7845154875',0,10,5,'teacher',NULL);
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-10  8:48:31
