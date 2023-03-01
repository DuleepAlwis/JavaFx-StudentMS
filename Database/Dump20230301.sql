-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: studentms_javafx_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `student_tb`
--

DROP TABLE IF EXISTS `student_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admissionno` varchar(255) DEFAULT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `degree` int DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `doj` datetime(6) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `indexno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `student_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK10of8c4hx30yk3fvkixepm4al` (`student_user_id`),
  CONSTRAINT `FK10of8c4hx30yk3fvkixepm4al` FOREIGN KEY (`student_user_id`) REFERENCES `user_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_tb`
--

LOCK TABLES `student_tb` WRITE;
/*!40000 ALTER TABLE `student_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_student_tb`
--

DROP TABLE IF EXISTS `subject_student_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_student_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attempt` int DEFAULT NULL,
  `creditsEarned` int DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `marks` double DEFAULT NULL,
  `student_id` bigint NOT NULL,
  `subject_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg8xc6vl6noevhs6inl9v97lfb` (`student_id`),
  KEY `FKon7hkjistugi2ty69spvw6nea` (`subject_id`),
  CONSTRAINT `FKg8xc6vl6noevhs6inl9v97lfb` FOREIGN KEY (`student_id`) REFERENCES `student_tb` (`id`),
  CONSTRAINT `FKon7hkjistugi2ty69spvw6nea` FOREIGN KEY (`subject_id`) REFERENCES `subject_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_student_tb`
--

LOCK TABLES `subject_student_tb` WRITE;
/*!40000 ALTER TABLE `subject_student_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_student_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_tb`
--

DROP TABLE IF EXISTS `subject_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `academicYear` varchar(255) DEFAULT NULL,
  `credits` int DEFAULT NULL,
  `degree` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_tb`
--

LOCK TABLES `subject_tb` WRITE;
/*!40000 ALTER TABLE `subject_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_tutor_tb`
--

DROP TABLE IF EXISTS `subject_tutor_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_tutor_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `semester` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `subject_id` bigint NOT NULL,
  `tutor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7q0jd0ulumuqosb3j1sjf2kx` (`subject_id`),
  KEY `FKbhox1fmq0bw5o8vwjsx0y80ry` (`tutor_id`),
  CONSTRAINT `FK7q0jd0ulumuqosb3j1sjf2kx` FOREIGN KEY (`subject_id`) REFERENCES `subject_tb` (`id`),
  CONSTRAINT `FKbhox1fmq0bw5o8vwjsx0y80ry` FOREIGN KEY (`tutor_id`) REFERENCES `tutor_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_tutor_tb`
--

LOCK TABLES `subject_tutor_tb` WRITE;
/*!40000 ALTER TABLE `subject_tutor_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_tutor_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_tb`
--

DROP TABLE IF EXISTS `tutor_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dob` datetime(6) DEFAULT NULL,
  `doj` datetime(6) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nic` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `tutor_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK56pkry5bpo8b02nwn9uvpt8v1` (`tutor_user_id`),
  CONSTRAINT `FK56pkry5bpo8b02nwn9uvpt8v1` FOREIGN KEY (`tutor_user_id`) REFERENCES `user_tb` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_tb`
--

LOCK TABLES `tutor_tb` WRITE;
/*!40000 ALTER TABLE `tutor_tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutor_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb`
--

DROP TABLE IF EXISTS `user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tb` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `Role` int DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2dlfg6wvnxboknkp9d1h75icb` (`email`),
  UNIQUE KEY `UK_lvx22t2upvjxxc86vf5daxc71` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'user1@gmail.com','0712365478',NULL,'24c9e15e52afc47c225b757e7bee1f9d',0,'user1'),(4,'user2@gmail.com','0712345678',NULL,'user2',1,'user2'),(9,'user3@gmail.com','0712365489',NULL,'user3',1,'user3'),(10,'user4@gmail.com','0715236984',NULL,'user4',0,'user4'),(11,'user5@gmail.com','0714569873',NULL,'user5',2,'user5'),(14,'user6@gmail.com','0715698321',NULL,'user6',0,'user6'),(15,'user7@gmail.com','0712348953',NULL,'3e0469fb134991f8f75a2760e409c6ed',0,'user7');
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-01 12:35:52
