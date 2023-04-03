-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: coop
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `coop`
--

/*!40000 DROP DATABASE IF EXISTS `coop`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `coop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `coop`;

--
-- Table structure for table `account_sequence`
--

DROP TABLE IF EXISTS `account_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_sequence`
--

LOCK TABLES `account_sequence` WRITE;
/*!40000 ALTER TABLE `account_sequence` DISABLE KEYS */;
INSERT INTO `account_sequence` VALUES (2022251);
/*!40000 ALTER TABLE `account_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `account_id` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `username` varchar(255) DEFAULT NULL,
  `emp_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FKdsgm49cy5qpyc18eg3upcr6by` (`emp_id`),
  CONSTRAINT `FKdsgm49cy5qpyc18eg3upcr6by` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','admin',1,'admin',NULL),(2022152,'jude123','admin',1,'jude',552);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` bigint NOT NULL,
  `absent` varchar(255) DEFAULT NULL,
  `regular` varchar(255) DEFAULT NULL,
  `sick_leave` varchar(255) DEFAULT NULL,
  `tardiness` varchar(255) DEFAULT NULL,
  `time_in` datetime DEFAULT NULL,
  `time_out` datetime DEFAULT NULL,
  `emp_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3ntb14aq9d2e83ox1drpxsry7` (`emp_id`),
  CONSTRAINT `FK3ntb14aq9d2e83ox1drpxsry7` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backup`
--

DROP TABLE IF EXISTS `backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backup` (
  `backup_id` bigint NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`backup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup`
--

LOCK TABLES `backup` WRITE;
/*!40000 ALTER TABLE `backup` DISABLE KEYS */;
INSERT INTO `backup` VALUES (1,'.\\backup\\Database_Backup_07-03-2023.sql','2023-03-07 15:30:07'),(2,'.\\backup\\Database_Backup_07-03-2023.sql','2023-03-07 15:33:26'),(5,'.\\backup\\Database_Backup_24-03-2023.sql','2023-03-24 13:13:56');
/*!40000 ALTER TABLE `backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `id` bigint NOT NULL,
  `due_date` varchar(255) DEFAULT NULL,
  `import_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `reference_code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (101,'2023/03/10','2023-03-11 07:08:56','101','asd','101','asd'),(102,'2023-03-30T16:00:00.000Z','2023-03-11 07:32:33','waw','2023-03-29T16:00:00.000Z','222','sda'),(103,NULL,'2023-03-11 07:36:03','sdsa','2023-03-08T16:00:00.000Z','2255','water'),(104,'','2023-03-11 07:41:49','ghgh','','231','awee'),(152,'2023-04-04T16:00:00.000Z','2023-04-01 12:24:51','Water','2023-03-30T16:00:00.000Z','251486925','Water Bill');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills_item_transaction`
--

DROP TABLE IF EXISTS `bills_item_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills_item_transaction` (
  `item_id` bigint NOT NULL,
  `amount` double NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `bills_tran_id` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKepxa6jm4umhurhkc4rua1awcg` (`bills_tran_id`),
  CONSTRAINT `FKepxa6jm4umhurhkc4rua1awcg` FOREIGN KEY (`bills_tran_id`) REFERENCES `bills_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_item_transaction`
--

LOCK TABLES `bills_item_transaction` WRITE;
/*!40000 ALTER TABLE `bills_item_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `bills_item_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills_sequence`
--

DROP TABLE IF EXISTS `bills_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_sequence`
--

LOCK TABLES `bills_sequence` WRITE;
/*!40000 ALTER TABLE `bills_sequence` DISABLE KEYS */;
INSERT INTO `bills_sequence` VALUES (251);
/*!40000 ALTER TABLE `bills_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills_trans_item_sequence`
--

DROP TABLE IF EXISTS `bills_trans_item_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills_trans_item_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_trans_item_sequence`
--

LOCK TABLES `bills_trans_item_sequence` WRITE;
/*!40000 ALTER TABLE `bills_trans_item_sequence` DISABLE KEYS */;
INSERT INTO `bills_trans_item_sequence` VALUES (800);
/*!40000 ALTER TABLE `bills_trans_item_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills_trans_sequence`
--

DROP TABLE IF EXISTS `bills_trans_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills_trans_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_trans_sequence`
--

LOCK TABLES `bills_trans_sequence` WRITE;
/*!40000 ALTER TABLE `bills_trans_sequence` DISABLE KEYS */;
INSERT INTO `bills_trans_sequence` VALUES (201);
/*!40000 ALTER TABLE `bills_trans_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills_transaction`
--

DROP TABLE IF EXISTS `bills_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills_transaction` (
  `id` bigint NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `month_year` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills_transaction`
--

LOCK TABLES `bills_transaction` WRITE;
/*!40000 ALTER TABLE `bills_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `bills_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bir_tax`
--

DROP TABLE IF EXISTS `bir_tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bir_tax` (
  `tax_id` bigint NOT NULL AUTO_INCREMENT,
  `fix_tax` double NOT NULL,
  `maximum` double NOT NULL,
  `minimum` double NOT NULL,
  `tax_rate_on_excess` double NOT NULL,
  PRIMARY KEY (`tax_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bir_tax`
--

LOCK TABLES `bir_tax` WRITE;
/*!40000 ALTER TABLE `bir_tax` DISABLE KEYS */;
/*!40000 ALTER TABLE `bir_tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashier`
--

DROP TABLE IF EXISTS `cashier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashier` (
  `cashier_id` bigint NOT NULL,
  `cashier_date` datetime DEFAULT NULL,
  `cashier_total` double NOT NULL,
  `farmer_id` bigint NOT NULL,
  `merchandise_price` double NOT NULL,
  `transaction_id` bigint NOT NULL,
  PRIMARY KEY (`cashier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashier`
--

LOCK TABLES `cashier` WRITE;
/*!40000 ALTER TABLE `cashier` DISABLE KEYS */;
INSERT INTO `cashier` VALUES (101,'2023-04-01 07:29:48',24969,101,500,111);
/*!40000 ALTER TABLE `cashier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashier_sequence`
--

DROP TABLE IF EXISTS `cashier_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashier_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashier_sequence`
--

LOCK TABLES `cashier_sequence` WRITE;
/*!40000 ALTER TABLE `cashier_sequence` DISABLE KEYS */;
INSERT INTO `cashier_sequence` VALUES (151);
/*!40000 ALTER TABLE `cashier_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit` (
  `balance_id` bigint NOT NULL,
  `balance` double NOT NULL,
  `cashier_id` bigint DEFAULT NULL,
  `cashier_name` varchar(255) DEFAULT NULL,
  `credit` double NOT NULL,
  `insert_balance_date` datetime DEFAULT NULL,
  PRIMARY KEY (`balance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--

LOCK TABLES `credit` WRITE;
/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_sequence`
--

DROP TABLE IF EXISTS `credit_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_sequence`
--

LOCK TABLES `credit_sequence` WRITE;
/*!40000 ALTER TABLE `credit_sequence` DISABLE KEYS */;
INSERT INTO `credit_sequence` VALUES (101);
/*!40000 ALTER TABLE `credit_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_salary` (
  `salary_id` bigint NOT NULL AUTO_INCREMENT,
  `bank_account_info` varchar(255) DEFAULT NULL,
  `daily_basic` double NOT NULL,
  `eff_date` date DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `tax_info` varchar(255) DEFAULT NULL,
  `emp_id` bigint NOT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `FK1ldssf2ky0bjfrq4vvwlfudhh` (`emp_id`),
  CONSTRAINT `FK1ldssf2ky0bjfrq4vvwlfudhh` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_salary`
--

LOCK TABLES `employee_salary` WRITE;
/*!40000 ALTER TABLE `employee_salary` DISABLE KEYS */;
INSERT INTO `employee_salary` VALUES (1,'222',255,'2023-02-01','2023-12-31','Cashier','555',352),(2,'425619557',500,'2023-03-05','2023-03-25','Sanitary Engineer','4859658432',402),(3,'25415263',5000,'2023-01-01','2023-12-31','HR','32145632',452),(4,'11122',31213,'2023-03-15','2030-01-24','Admin','33321',453),(5,'8745154',2314,'2023-02-01','2024-03-01','HR','8542642',602);
/*!40000 ALTER TABLE `employee_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_sequence`
--

DROP TABLE IF EXISTS `employee_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_sequence`
--

LOCK TABLES `employee_sequence` WRITE;
/*!40000 ALTER TABLE `employee_sequence` DISABLE KEYS */;
INSERT INTO `employee_sequence` VALUES (701);
/*!40000 ALTER TABLE `employee_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `emp_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image_location` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `postal_code` bigint NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `update_date` datetime DEFAULT NULL,
  `date_hired` date DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (352,'321/123/112/223/123','1990-09-12','2023-03-16 16:08:17','jude@jude','Jude','http://localhost:8080/upload/Employee_1.png','Bautista','Hennieh','9365595212',4441,'Male',1,'2023-03-24 08:50:21','2023-01-01'),(402,'321/123/222/333/111','2000-01-05','2023-03-17 06:43:23','mark@mark','Mark','http://localhost:8080/upload/Employee_2.png','Salem','Joseph','9365252212',4111,'Male',1,'2023-03-24 08:50:36','2023-02-27'),(452,'312/123/231/233/331','2023-02-28','2023-03-19 07:06:38','asd','asd','http://localhost:8080/upload/Employee_3.png','asd','asd','3213321451',4111,'Male',1,NULL,NULL),(453,'231/122/224/333/123','2023-03-06','2023-03-19 11:48:42','ddd@ddd','ddd','http://localhost:8080/upload/Employee_4.png','ddd','ddd','321',4224,'Male',1,NULL,NULL),(502,'231/123/231/211/111','2005-03-08','2023-03-23 04:46:05','Sample@Sample','Sample','http://localhost:8080/upload/Employee_5.png','Sample','Sample','9925685623',2444,'Male',1,'2023-03-24 08:16:09','2023-03-02'),(552,'231/111/222/333/221','2001-02-28','2023-03-24 08:14:20','pato@pato','pato','http://localhost:8080/upload/Employee_6.png','pato','pato','9385251212',4112,'Male',1,'2023-03-24 08:48:04','2023-03-01'),(602,'321/111/223/423/221','1999-03-01','2023-04-01 12:36:50','John','John','http://localhost:8080/upload/Employee_7.png','Dallego','Vincent','93854251658',5441,'Male',1,NULL,'2023-01-11');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farm_sequence`
--

DROP TABLE IF EXISTS `farm_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farm_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm_sequence`
--

LOCK TABLES `farm_sequence` WRITE;
/*!40000 ALTER TABLE `farm_sequence` DISABLE KEYS */;
INSERT INTO `farm_sequence` VALUES (201);
/*!40000 ALTER TABLE `farm_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmers`
--

DROP TABLE IF EXISTS `farmers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmers` (
  `farmer_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `affiliation` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `civil_status` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `educational_attainment` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estimated_annual_income` varchar(255) DEFAULT NULL,
  `facebook_account` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image_location` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `no_of_dependents` varchar(255) DEFAULT NULL,
  `postal_code` bigint NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `spouse` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `update_date` datetime DEFAULT NULL,
  `viber_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`farmer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmers`
--

LOCK TABLES `farmers` WRITE;
/*!40000 ALTER TABLE `farmers` DISABLE KEYS */;
INSERT INTO `farmers` VALUES (101,'233/331/111/123/231','Jude','1994-07-12','Jude','2023-03-08 13:58:32','Jude','jude@jude','5222','Jude','Jude','http://localhost:8080/upload/Farmer_1.png','Bautista','Hennieh','933863526','2',4331,'Male','Jude',1,NULL,'Jude'),(102,'231/111/3342/2321/1232','Raymond','1993-01-13','Raymond','2023-04-01 12:15:49','Raymond','raymond@yahoo.com','231','Raymond','Raymond','http://localhost:8080/upload/Farmer_2.png','Hernandez','Raymond','9224516845','2',4111,'Male','Raymonda',1,NULL,'Raymond');
/*!40000 ALTER TABLE `farmers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiber_items`
--

DROP TABLE IF EXISTS `fiber_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiber_items` (
  `fiber_item_id` bigint NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `knife_used` double NOT NULL,
  `price` double NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `stripping_cleaning` varchar(255) DEFAULT NULL,
  `fiber_id` bigint DEFAULT NULL,
  PRIMARY KEY (`fiber_item_id`),
  KEY `FKrh36fv58imt35pjl7balhtobr` (`fiber_id`),
  CONSTRAINT `FKrh36fv58imt35pjl7balhtobr` FOREIGN KEY (`fiber_id`) REFERENCES `fibers` (`fiber_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiber_items`
--

LOCK TABLES `fiber_items` WRITE;
/*!40000 ALTER TABLE `fiber_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `fiber_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiber_price`
--

DROP TABLE IF EXISTS `fiber_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiber_price` (
  `fiber_price_id` bigint NOT NULL AUTO_INCREMENT,
  `excellent_fiber_price` double NOT NULL,
  `good_fiber_price` double NOT NULL,
  `reseco_fiber_price` double NOT NULL,
  PRIMARY KEY (`fiber_price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiber_price`
--

LOCK TABLES `fiber_price` WRITE;
/*!40000 ALTER TABLE `fiber_price` DISABLE KEYS */;
INSERT INTO `fiber_price` VALUES (1,0,0,0),(2,0,0,0),(3,0,0,0),(4,0,0,0),(5,0,0,0),(6,0,0,0),(7,0,0,0),(8,0,0,0),(9,0,0,0),(10,0,0,0),(11,0,0,0),(12,0,0,0),(13,0,0,0),(14,0,0,0),(15,0,0,0),(16,0,0,0),(17,0,0,0),(18,0,0,0);
/*!40000 ALTER TABLE `fiber_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiber_sequence`
--

DROP TABLE IF EXISTS `fiber_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiber_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiber_sequence`
--

LOCK TABLES `fiber_sequence` WRITE;
/*!40000 ALTER TABLE `fiber_sequence` DISABLE KEYS */;
INSERT INTO `fiber_sequence` VALUES (201);
/*!40000 ALTER TABLE `fiber_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fibernew`
--

DROP TABLE IF EXISTS `fibernew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fibernew` (
  `fiber_id` bigint NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `excellent_fiber_amount` double NOT NULL,
  `excellent_fiber_kg` double NOT NULL,
  `excellent_or_code` double NOT NULL,
  `fiber_total_amount` double NOT NULL,
  `good_fiber_amount` double NOT NULL,
  `good_fiber_kg` double NOT NULL,
  `good_or_code` double NOT NULL,
  `reference_code` varchar(255) DEFAULT NULL,
  `reseco_fiber_amount` double NOT NULL,
  `reseco_fiber_kg` double NOT NULL,
  `reseco_or_code` double NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`fiber_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fibernew`
--

LOCK TABLES `fibernew` WRITE;
/*!40000 ALTER TABLE `fibernew` DISABLE KEYS */;
INSERT INTO `fibernew` VALUES (702,'2023-03-30 12:19:49',252,12,878456981,1242,264,22,548784541,'2023033099',726,33,874589645,1),(752,'2023-04-01 12:11:24',40000,400,4875964,106000,36000,300,7887458,'20230401702',30000,200,9854612,1);
/*!40000 ALTER TABLE `fibernew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fibernew_sequence`
--

DROP TABLE IF EXISTS `fibernew_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fibernew_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fibernew_sequence`
--

LOCK TABLES `fibernew_sequence` WRITE;
/*!40000 ALTER TABLE `fibernew_sequence` DISABLE KEYS */;
INSERT INTO `fibernew_sequence` VALUES (851);
/*!40000 ALTER TABLE `fibernew_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fibers`
--

DROP TABLE IF EXISTS `fibers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fibers` (
  `fiber_id` bigint NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`fiber_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fibers`
--

LOCK TABLES `fibers` WRITE;
/*!40000 ALTER TABLE `fibers` DISABLE KEYS */;
INSERT INTO `fibers` VALUES (101,'2023-03-07 15:27:30','Abaca',1),(102,'2023-03-10 08:46:17','Pineapple',1);
/*!40000 ALTER TABLE `fibers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (10);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holiday` (
  `holiday_id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` VALUES (2,'2023-04-02','ss',1),(3,'2023-03-24','Reg Holiday',0),(5,'2023-03-30','Regular Holiday',0),(6,'2023-03-31','Special Holiday',1);
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_sequence`
--

DROP TABLE IF EXISTS `item_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_sequence`
--

LOCK TABLES `item_sequence` WRITE;
/*!40000 ALTER TABLE `item_sequence` DISABLE KEYS */;
INSERT INTO `item_sequence` VALUES (500);
/*!40000 ALTER TABLE `item_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mandatory_deduction`
--

DROP TABLE IF EXISTS `mandatory_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mandatory_deduction` (
  `mandatory_deduction_id` bigint NOT NULL AUTO_INCREMENT,
  `contribution_amount` double NOT NULL,
  `payroll_id` bigint NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mandatory_deduction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mandatory_deduction`
--

LOCK TABLES `mandatory_deduction` WRITE;
/*!40000 ALTER TABLE `mandatory_deduction` DISABLE KEYS */;
INSERT INTO `mandatory_deduction` VALUES (1,500,101,'SSS'),(2,250,152,'SSS'),(3,100,152,'HDMF'),(4,500,152,'PhilHealth'),(5,321,102,'Kahitano'),(6,322,254,'SSS'),(7,222,254,'HDMF'),(8,111,254,'PhilHealth'),(9,500,302,'SSS'),(10,251,302,'HDMF'),(11,400,302,'PhilHealth'),(12,231,303,'HDMF'),(13,11,303,'SSS'),(14,222,303,'PhilHealth'),(15,321,304,'SSS'),(16,231,305,'sdaw'),(17,400,352,'SSS'),(18,200,352,'HDMF'),(19,300,352,'PhilHealth');
/*!40000 ALTER TABLE `mandatory_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_item_sequence`
--

DROP TABLE IF EXISTS `merchant_item_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_item_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_item_sequence`
--

LOCK TABLES `merchant_item_sequence` WRITE;
/*!40000 ALTER TABLE `merchant_item_sequence` DISABLE KEYS */;
INSERT INTO `merchant_item_sequence` VALUES (500);
/*!40000 ALTER TABLE `merchant_item_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_product`
--

DROP TABLE IF EXISTS `merchant_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_product` (
  `product_id` bigint NOT NULL,
  `import_date` datetime DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `original_price` double NOT NULL,
  `price` double NOT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_product`
--

LOCK TABLES `merchant_product` WRITE;
/*!40000 ALTER TABLE `merchant_product` DISABLE KEYS */;
INSERT INTO `merchant_product` VALUES (101,'2023-03-07 15:30:41','Toothbrush',0,20,'100',1),(102,'2023-04-01 12:28:39','Soap',0,50,'800',1);
/*!40000 ALTER TABLE `merchant_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mrc_sequence`
--

DROP TABLE IF EXISTS `mrc_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mrc_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mrc_sequence`
--

LOCK TABLES `mrc_sequence` WRITE;
/*!40000 ALTER TABLE `mrc_sequence` DISABLE KEYS */;
INSERT INTO `mrc_sequence` VALUES (201);
/*!40000 ALTER TABLE `mrc_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_deduction`
--

DROP TABLE IF EXISTS `other_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_deduction` (
  `other_deduction_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `payroll_id` bigint NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`other_deduction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_deduction`
--

LOCK TABLES `other_deduction` WRITE;
/*!40000 ALTER TABLE `other_deduction` DISABLE KEYS */;
INSERT INTO `other_deduction` VALUES (1,'Damage of Property',101,250),(2,'Cash Advance',152,500),(3,'asds',302,231),(4,'Others',352,500);
/*!40000 ALTER TABLE `other_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll` (
  `payroll_id` bigint NOT NULL,
  `gross_pay` double NOT NULL,
  `mandatory_deductions` double NOT NULL,
  `net_pay` double NOT NULL,
  `other_deductions` double NOT NULL,
  `over_time_pay` double NOT NULL,
  `over_time_rate` double NOT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `period_end` date DEFAULT NULL,
  `period_start` date DEFAULT NULL,
  `regular_pay` double NOT NULL,
  `sick_pay` double NOT NULL,
  `tardiness_deduction` double NOT NULL,
  `taxable_income` double NOT NULL,
  `total_benefit` double NOT NULL,
  `total_deductions` double NOT NULL,
  `total_ot_hours` double NOT NULL,
  `total_sick_days` double NOT NULL,
  `total_tardiness_hours` double NOT NULL,
  `total_vacation_days` double NOT NULL,
  `total_work_hours` double NOT NULL,
  `vacation_pay` double NOT NULL,
  `withholding_tax` double NOT NULL,
  `emp_id` bigint NOT NULL,
  PRIMARY KEY (`payroll_id`),
  KEY `FKopgbic0e7nefmvp7aw0kuragk` (`emp_id`),
  CONSTRAINT `FKopgbic0e7nefmvp7aw0kuragk` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES (302,1647.5,1151,265.5,231,0,7.96875,'2023-04-01','Cash','2023-04-08','2023-04-02',1861.5,0,714,496.5,500,2096,0,0,28,0,56,0,0,352),(303,32606.5,464,32142.5,0,0,7.96875,'2023-04-01','Remitance','2023-04-30','2023-04-01',586.5,0,102,32142.5,32122,566,0,0,4,0,16,0,0,352),(304,1181,321,860,0,0,15.625,'2023-04-01','Cash','2023-04-08','2023-04-02',1150,0,200,860,231,521,0,0,4,0,16,0,0,402),(305,2722,231,2491,0,0,156.25,'2023-04-01','Cash','2023-04-30','2023-04-01',5000,0,2500,2491,222,2731,0,0,5,0,8,0,0,452),(352,37858.8,900,36458.8,500,0,72.3125,'2023-04-01','Cash','2023-04-15','2023-04-01',35404.2,0,2545.4,36958.8,5000,3945.4,0,0,11,0,120,0,0,602);
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_benefit`
--

DROP TABLE IF EXISTS `payroll_benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll_benefit` (
  `payroll_benefit_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `payroll_id` bigint NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`payroll_benefit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_benefit`
--

LOCK TABLES `payroll_benefit` WRITE;
/*!40000 ALTER TABLE `payroll_benefit` DISABLE KEYS */;
INSERT INTO `payroll_benefit` VALUES (1,'Meal Allowance',101,1500),(2,'Incentives',102,250),(3,'Incentives',152,500),(4,'Incentives',252,321),(5,'Incentives',253,321),(6,'dasd',254,231),(7,'sad',255,2311),(8,'sad',256,2311),(9,'HDMF',257,240),(10,'PhilHealth',257,240),(11,'SSS',257,210),(12,'incentives',258,312),(13,'incentives',257,500),(14,'incentives',302,500),(15,'axsd',303,32122),(16,'sad',304,231),(17,'ddg',305,222),(18,'Incentives',352,5000);
/*!40000 ALTER TABLE `payroll_benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_detail`
--

DROP TABLE IF EXISTS `payroll_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll_detail` (
  `payroll_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `ot` double NOT NULL,
  `payroll_id` bigint NOT NULL,
  `regular` double NOT NULL,
  `sick` double NOT NULL,
  `tardiness` double NOT NULL,
  `vacation` double NOT NULL,
  PRIMARY KEY (`payroll_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_detail`
--

LOCK TABLES `payroll_detail` WRITE;
/*!40000 ALTER TABLE `payroll_detail` DISABLE KEYS */;
INSERT INTO `payroll_detail` VALUES (1,'2023-03-16',0,101,8,0,0,0),(2,'2023-03-17',0,101,8,0,0,0),(3,'2023-03-18',0,101,0,0,0,0),(4,'2023-03-19',0,101,0,0,0,0),(5,'2023-03-20',0,101,0,0,0,0),(6,'2023-03-21',0,101,0,0,0,0),(7,'2023-03-22',0,101,0,0,0,0),(8,'2023-03-23',0,101,0,0,0,0),(9,'2023-03-24',0,101,0,0,0,0),(10,'2023-03-25',0,101,0,0,0,0),(11,'2023-03-26',0,101,0,0,0,0),(12,'2023-03-27',0,101,0,0,0,0),(13,'2023-03-28',0,101,0,0,0,0),(14,'2023-03-29',0,101,0,0,0,0),(15,'2023-03-30',0,101,0,0,0,0),(16,'2023-03-31',0,101,0,0,0,0),(17,'2023-03-16',0,102,8,0,0,0),(18,'2023-03-17',0,102,8,0,0,0),(19,'2023-03-18',0,102,8,0,0,0),(20,'2023-03-19',0,102,8,0,0,0),(21,'2023-03-20',0,102,0,0,0,1),(22,'2023-03-21',0,102,8,0,0,0),(23,'2023-03-22',0,102,0,0,0,0),(24,'2023-03-23',0,102,0,0,0,0),(25,'2023-03-24',0,102,0,0,0,0),(26,'2023-03-25',0,102,0,0,0,0),(27,'2023-03-26',0,102,0,0,0,0),(28,'2023-03-27',0,102,0,0,0,0),(29,'2023-03-28',0,102,0,0,0,0),(30,'2023-03-29',0,102,0,0,0,0),(31,'2023-03-30',0,102,0,0,0,0),(32,'2023-03-31',0,102,0,0,0,0),(33,'2023-03-16',0,152,8,0,0,0),(34,'2023-03-17',0,152,8,0,0,0),(35,'2023-03-18',0,152,8,0,0,0),(36,'2023-03-19',0,152,8,0,0,0),(37,'2023-03-20',0,152,0,0,0,1),(38,'2023-03-21',2,152,0,0,1,0),(39,'2023-03-22',0,152,8,0,0,0),(40,'2023-03-23',0,152,8,0,0,0),(41,'2023-03-24',0,152,8,0,0,0),(42,'2023-03-25',0,152,8,0,0,0),(43,'2023-03-26',0,152,8,0,0,0),(44,'2023-03-27',0,152,8,0,0,0),(45,'2023-03-28',0,152,8,0,0,0),(46,'2023-03-29',0,152,8,0,0,0),(47,'2023-03-30',0,152,8,0,0,0),(48,'2023-03-31',0,152,8,0,0,0),(49,'2023-03-16',0,202,8,0,0,0),(50,'2023-03-17',0,202,8,0,0,0),(51,'2023-03-18',0,202,8,0,0,0),(52,'2023-03-19',0,202,0,0,0,0),(53,'2023-03-20',0,202,0,0,0,0),(54,'2023-03-21',0,202,0,0,0,0),(55,'2023-03-22',0,202,0,0,0,0),(56,'2023-03-23',0,202,0,0,0,0),(57,'2023-03-24',0,202,0,0,0,0),(58,'2023-03-25',0,202,0,0,0,0),(59,'2023-03-26',0,202,0,0,0,0),(60,'2023-03-27',0,202,0,0,0,0),(61,'2023-03-28',0,202,0,0,0,0),(62,'2023-03-29',0,202,0,0,0,0),(63,'2023-03-30',0,202,0,0,0,0),(64,'2023-03-31',0,202,0,0,0,0),(65,'2023-03-31',0,252,8,0,0,0),(66,'2023-04-01',0,252,8,0,0,0),(67,'2023-04-02',0,252,8,0,0,0),(68,'2023-04-03',0,252,0,0,0,0),(69,'2023-04-04',0,252,0,0,0,0),(70,'2023-04-05',0,252,0,0,0,0),(71,'2023-04-06',0,252,0,0,0,0),(72,'2023-04-07',0,252,0,0,0,0),(73,'2023-04-08',0,252,0,0,0,0),(74,'2023-04-09',0,252,0,0,0,0),(75,'2023-04-10',0,252,0,0,0,0),(76,'2023-04-11',0,252,0,0,0,0),(77,'2023-04-12',0,252,0,0,0,0),(78,'2023-04-13',0,252,0,0,0,0),(79,'2023-04-14',0,252,0,0,0,0),(80,'2023-04-15',0,252,0,0,0,0),(81,'2023-04-16',0,252,0,0,0,0),(82,'2023-04-17',0,252,0,0,0,0),(83,'2023-04-18',0,252,0,0,0,0),(84,'2023-04-19',0,252,0,0,0,0),(85,'2023-04-20',0,252,0,0,0,0),(86,'2023-04-21',0,252,0,0,0,0),(87,'2023-04-22',0,252,0,0,0,0),(88,'2023-04-23',0,252,0,0,0,0),(89,'2023-04-24',0,252,0,0,0,0),(90,'2023-04-25',0,252,0,0,0,0),(91,'2023-04-26',0,252,0,0,0,0),(92,'2023-04-27',0,252,0,0,0,0),(93,'2023-04-28',0,252,0,0,0,0),(94,'2023-04-29',0,252,0,0,0,0),(95,'2023-03-31',0,253,8,0,0,0),(96,'2023-04-01',0,253,8,0,0,0),(97,'2023-04-02',0,253,8,0,0,0),(98,'2023-04-03',0,253,0,0,0,0),(99,'2023-04-04',0,253,0,0,0,0),(100,'2023-04-05',0,253,0,0,0,0),(101,'2023-04-06',0,253,0,0,0,0),(102,'2023-04-07',0,253,0,0,0,0),(103,'2023-04-08',0,253,0,0,0,0),(104,'2023-04-09',0,253,0,0,0,0),(105,'2023-04-10',0,253,0,0,0,0),(106,'2023-04-11',0,253,0,0,0,0),(107,'2023-04-12',0,253,0,0,0,0),(108,'2023-04-13',0,253,0,0,0,0),(109,'2023-04-14',0,253,0,0,0,0),(110,'2023-04-15',0,253,0,0,0,0),(111,'2023-04-16',0,253,0,0,0,0),(112,'2023-04-17',0,253,0,0,0,0),(113,'2023-04-18',0,253,0,0,0,0),(114,'2023-04-19',0,253,0,0,0,0),(115,'2023-04-20',0,253,0,0,0,0),(116,'2023-04-21',0,253,0,0,0,0),(117,'2023-04-22',0,253,0,0,0,0),(118,'2023-04-23',0,253,0,0,0,0),(119,'2023-04-24',0,253,0,0,0,0),(120,'2023-04-25',0,253,0,0,0,0),(121,'2023-04-26',0,253,0,0,0,0),(122,'2023-04-27',0,253,0,0,0,0),(123,'2023-04-28',0,253,0,0,0,0),(124,'2023-04-29',0,253,0,0,0,0),(125,'2023-04-01',0,254,8,0,0,0),(126,'2023-04-02',0,254,8,0,0,0),(127,'2023-04-03',0,254,0,0,0,0),(128,'2023-04-04',0,254,0,0,0,0),(129,'2023-04-05',0,254,0,0,0,0),(130,'2023-04-06',0,254,0,0,0,0),(131,'2023-04-07',0,254,0,0,0,0),(132,'2023-04-08',0,254,0,0,0,0),(133,'2023-04-09',0,254,0,0,0,0),(134,'2023-04-10',0,254,0,0,0,0),(135,'2023-04-11',0,254,0,0,0,0),(136,'2023-04-12',0,254,0,0,0,0),(137,'2023-04-13',0,254,0,0,0,0),(138,'2023-04-14',0,254,0,0,0,0),(139,'2023-04-15',0,254,0,0,0,0),(140,'2023-04-02',0,255,8,0,0,0),(141,'2023-04-03',0,255,8,0,0,0),(142,'2023-04-04',0,255,0,0,1,0),(143,'2023-04-05',0,255,0,0,0,0),(144,'2023-04-06',0,255,0,0,0,0),(145,'2023-04-07',0,255,0,0,0,0),(146,'2023-04-08',0,255,0,0,0,0),(147,'2023-04-02',0,256,8,0,0,0),(148,'2023-04-03',0,256,8,0,0,0),(149,'2023-04-04',0,256,0,0,3,0),(150,'2023-04-05',0,256,0,0,0,0),(151,'2023-04-06',0,256,0,0,0,0),(152,'2023-04-07',0,256,0,0,0,0),(153,'2023-04-08',0,256,0,0,0,0),(154,'2023-04-02',0,257,8,0,2,0),(155,'2023-04-03',0,257,8,0,2,0),(156,'2023-04-04',0,257,0,0,0,0),(157,'2023-04-05',0,257,0,0,0,0),(158,'2023-04-06',0,257,0,0,0,0),(159,'2023-04-07',0,257,0,0,0,0),(160,'2023-04-08',0,257,0,0,0,0),(161,'2023-04-03',0,258,8,0,3,0),(162,'2023-04-04',0,258,8,0,3,0),(163,'2023-04-05',0,258,0,0,3,0),(164,'2023-04-06',0,258,0,0,0,0),(165,'2023-04-07',0,258,0,0,0,0),(166,'2023-04-08',0,258,0,0,0,0),(167,'2023-04-09',0,258,0,0,0,0),(168,'2023-04-02',0,302,8,0,4,0),(169,'2023-04-03',0,302,8,0,4,0),(170,'2023-04-04',0,302,8,0,4,0),(171,'2023-04-05',0,302,8,0,4,0),(172,'2023-04-06',0,302,8,0,4,0),(173,'2023-04-07',0,302,8,0,4,0),(174,'2023-04-08',0,302,8,0,4,0),(175,'2023-03-31',0,303,8,0,2,0),(176,'2023-04-01',0,303,8,0,2,0),(177,'2023-04-02',0,303,8,0,2,0),(178,'2023-04-03',0,303,0,0,0,0),(179,'2023-04-04',0,303,0,0,0,0),(180,'2023-04-05',0,303,0,0,0,0),(181,'2023-04-06',0,303,0,0,0,0),(182,'2023-04-07',0,303,0,0,0,0),(183,'2023-04-08',0,303,0,0,0,0),(184,'2023-04-09',0,303,0,0,0,0),(185,'2023-04-10',0,303,0,0,0,0),(186,'2023-04-11',0,303,0,0,0,0),(187,'2023-04-12',0,303,0,0,0,0),(188,'2023-04-13',0,303,0,0,0,0),(189,'2023-04-14',0,303,0,0,0,0),(190,'2023-04-15',0,303,0,0,0,0),(191,'2023-04-16',0,303,0,0,0,0),(192,'2023-04-17',0,303,0,0,0,0),(193,'2023-04-18',0,303,0,0,0,0),(194,'2023-04-19',0,303,0,0,0,0),(195,'2023-04-20',0,303,0,0,0,0),(196,'2023-04-21',0,303,0,0,0,0),(197,'2023-04-22',0,303,0,0,0,0),(198,'2023-04-23',0,303,0,0,0,0),(199,'2023-04-24',0,303,0,0,0,0),(200,'2023-04-25',0,303,0,0,0,0),(201,'2023-04-26',0,303,0,0,0,0),(202,'2023-04-27',0,303,0,0,0,0),(203,'2023-04-28',0,303,0,0,0,0),(204,'2023-04-29',0,303,0,0,0,0),(205,'2023-04-02',0,304,8,0,2,0),(206,'2023-04-03',0,304,8,0,2,0),(207,'2023-04-04',0,304,0,0,0,0),(208,'2023-04-05',0,304,0,0,0,0),(209,'2023-04-06',0,304,0,0,0,0),(210,'2023-04-07',0,304,0,0,0,0),(211,'2023-04-08',0,304,0,0,0,0),(212,'2023-03-31',0,305,8,0,3,0),(213,'2023-04-01',0,305,8,0,5,0),(214,'2023-04-02',0,305,0,0,0,0),(215,'2023-04-03',0,305,0,0,0,0),(216,'2023-04-04',0,305,0,0,0,0),(217,'2023-04-05',0,305,0,0,0,0),(218,'2023-04-06',0,305,0,0,0,0),(219,'2023-04-07',0,305,0,0,0,0),(220,'2023-04-08',0,305,0,0,0,0),(221,'2023-04-09',0,305,0,0,0,0),(222,'2023-04-10',0,305,0,0,0,0),(223,'2023-04-11',0,305,0,0,0,0),(224,'2023-04-12',0,305,0,0,0,0),(225,'2023-04-13',0,305,0,0,0,0),(226,'2023-04-14',0,305,0,0,0,0),(227,'2023-04-15',0,305,0,0,0,0),(228,'2023-04-16',0,305,0,0,0,0),(229,'2023-04-17',0,305,0,0,0,0),(230,'2023-04-18',0,305,0,0,0,0),(231,'2023-04-19',0,305,0,0,0,0),(232,'2023-04-20',0,305,0,0,0,0),(233,'2023-04-21',0,305,0,0,0,0),(234,'2023-04-22',0,305,0,0,0,0),(235,'2023-04-23',0,305,0,0,0,0),(236,'2023-04-24',0,305,0,0,0,0),(237,'2023-04-25',0,305,0,0,0,0),(238,'2023-04-26',0,305,0,0,0,0),(239,'2023-04-27',0,305,0,0,0,0),(240,'2023-04-28',0,305,0,0,0,0),(241,'2023-04-29',0,305,0,0,0,0),(242,'2023-04-01',0,352,8,0,4,0),(243,'2023-04-02',0,352,8,0,5,0),(244,'2023-04-03',0,352,8,0,2,0),(245,'2023-04-04',0,352,8,0,0,0),(246,'2023-04-05',0,352,8,0,0,0),(247,'2023-04-06',0,352,8,0,0,0),(248,'2023-04-07',0,352,8,0,0,0),(249,'2023-04-08',0,352,8,0,0,0),(250,'2023-04-09',0,352,8,0,0,0),(251,'2023-04-10',0,352,8,0,0,0),(252,'2023-04-11',0,352,8,0,0,0),(253,'2023-04-12',0,352,8,0,0,0),(254,'2023-04-13',0,352,8,0,0,0),(255,'2023-04-14',0,352,8,0,0,0),(256,'2023-04-15',0,352,8,0,0,0);
/*!40000 ALTER TABLE `payroll_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_sequence`
--

DROP TABLE IF EXISTS `payroll_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_sequence`
--

LOCK TABLES `payroll_sequence` WRITE;
/*!40000 ALTER TABLE `payroll_sequence` DISABLE KEYS */;
INSERT INTO `payroll_sequence` VALUES (451);
/*!40000 ALTER TABLE `payroll_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pos_sequence`
--

DROP TABLE IF EXISTS `pos_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pos_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pos_sequence`
--

LOCK TABLES `pos_sequence` WRITE;
/*!40000 ALTER TABLE `pos_sequence` DISABLE KEYS */;
INSERT INTO `pos_sequence` VALUES (101);
/*!40000 ALTER TABLE `pos_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `release_transaction_sequence`
--

DROP TABLE IF EXISTS `release_transaction_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `release_transaction_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `release_transaction_sequence`
--

LOCK TABLES `release_transaction_sequence` WRITE;
/*!40000 ALTER TABLE `release_transaction_sequence` DISABLE KEYS */;
INSERT INTO `release_transaction_sequence` VALUES (101);
/*!40000 ALTER TABLE `release_transaction_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `releasetransaction`
--

DROP TABLE IF EXISTS `releasetransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `releasetransaction` (
  `release_transaction_id` bigint NOT NULL,
  `farmer_id` bigint NOT NULL,
  `merchandise_price` double NOT NULL,
  `release_date` datetime DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `total_price` double NOT NULL,
  `transaction_id` bigint NOT NULL,
  PRIMARY KEY (`release_transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `releasetransaction`
--

LOCK TABLES `releasetransaction` WRITE;
/*!40000 ALTER TABLE `releasetransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `releasetransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_item`
--

DROP TABLE IF EXISTS `transaction_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_item` (
  `item_id` bigint NOT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `tuxy_id` bigint NOT NULL,
  `tuxy_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` double NOT NULL,
  `transactions_id` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKlq6x9kuugtxi1u2v7w9xdrvn3` (`transactions_id`),
  CONSTRAINT `FKlq6x9kuugtxi1u2v7w9xdrvn3` FOREIGN KEY (`transactions_id`) REFERENCES `transactions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_item`
--

LOCK TABLES `transaction_item` WRITE;
/*!40000 ALTER TABLE `transaction_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_merchant`
--

DROP TABLE IF EXISTS `transaction_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_merchant` (
  `id` bigint NOT NULL,
  `cashier_id` bigint NOT NULL,
  `changed` double NOT NULL,
  `farmer_id` bigint NOT NULL,
  `paid` double NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `total_amount` double NOT NULL,
  `total_item` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_merchant`
--

LOCK TABLES `transaction_merchant` WRITE;
/*!40000 ALTER TABLE `transaction_merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_merchant_item`
--

DROP TABLE IF EXISTS `transaction_merchant_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_merchant_item` (
  `item_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` bigint NOT NULL,
  `quantity` double NOT NULL,
  `sub_amount` double NOT NULL,
  `trans_merchant_id` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK58fc6nxk99umwyrmb83rblniw` (`trans_merchant_id`),
  CONSTRAINT `FK58fc6nxk99umwyrmb83rblniw` FOREIGN KEY (`trans_merchant_id`) REFERENCES `transaction_merchant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_merchant_item`
--

LOCK TABLES `transaction_merchant_item` WRITE;
/*!40000 ALTER TABLE `transaction_merchant_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_merchant_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` bigint NOT NULL,
  `farmer_id` bigint NOT NULL,
  `merchant_payment` double NOT NULL,
  `release_date` datetime DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `total_amount` double NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionss`
--

DROP TABLE IF EXISTS `transactionss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactionss` (
  `transactions_id` bigint NOT NULL,
  `farmer_id` varchar(255) DEFAULT NULL,
  `plant_grade` varchar(255) DEFAULT NULL,
  `plant_kilogram` double NOT NULL,
  `plant_name` varchar(255) DEFAULT NULL,
  `plant_price` double NOT NULL,
  `plant_total` double NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`transactions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionss`
--

LOCK TABLES `transactionss` WRITE;
/*!40000 ALTER TABLE `transactionss` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactionss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuxy`
--

DROP TABLE IF EXISTS `tuxy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuxy` (
  `id` bigint NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `discarte_price` double NOT NULL,
  `good_price` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reseco_price` double NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy`
--

LOCK TABLES `tuxy` WRITE;
/*!40000 ALTER TABLE `tuxy` DISABLE KEYS */;
INSERT INTO `tuxy` VALUES (3,'2023-03-10 16:26:50',123,32,'HSD',333,1),(6,'2023-04-01 12:21:13',90,80,'Abaca',150,1);
/*!40000 ALTER TABLE `tuxy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuxy_log`
--

DROP TABLE IF EXISTS `tuxy_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuxy_log` (
  `id` bigint NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `tuxy_id` bigint NOT NULL,
  `tuxy_name` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy_log`
--

LOCK TABLES `tuxy_log` WRITE;
/*!40000 ALTER TABLE `tuxy_log` DISABLE KEYS */;
INSERT INTO `tuxy_log` VALUES (4,'Reseco price updated from 32.0 to 333.0.','2023-03-10 16:27:00',1,3,'HSD','User full name'),(7,'Good price updated from 50.0 to 80.0.','2023-04-01 12:22:07',1,6,'Abaca','User full name'),(8,'Discarted price updated from 80.0 to 90.0.','2023-04-01 12:22:07',1,6,'Abaca','User full name'),(9,'Reseco price updated from 100.0 to 150.0.','2023-04-01 12:22:07',1,6,'Abaca','User full name');
/*!40000 ALTER TABLE `tuxy_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuxy_price`
--

DROP TABLE IF EXISTS `tuxy_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuxy_price` (
  `price_id` bigint NOT NULL,
  `price` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy_price`
--

LOCK TABLES `tuxy_price` WRITE;
/*!40000 ALTER TABLE `tuxy_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `tuxy_price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-01 20:48:56
