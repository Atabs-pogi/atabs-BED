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
INSERT INTO `account_sequence` VALUES (2022101);
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
INSERT INTO `accounts` VALUES (1,'admin','admin',1,'admin',NULL);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
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
INSERT INTO `backup` VALUES (4,'.\\backup\\Database_Backup_02-03-2023.sql','2023-03-02 14:13:19'),(5,'.\\backup\\Database_Backup_02-03-2023.sql','2023-03-02 14:15:28'),(6,'.\\backup\\Database_Backup_02-03-2023.sql','2023-03-02 14:24:56'),(7,'.\\backup\\Database_Backup_02-03-2023.sql','2023-03-02 14:25:06');
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
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
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
INSERT INTO `bills_sequence` VALUES (101);
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
INSERT INTO `cashier_sequence` VALUES (101);
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
INSERT INTO `employee_sequence` VALUES (201);
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
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (101,'332/221/231/212/121','1992-10-14','2023-03-02 11:05:55','Jude@Jude','Jude','http://localhost:8080/upload/Employee_1.png','Bautista','Hennieh','9255219565',4221,'Male',NULL),(102,'231/null/211/321/123','1993-07-10','2023-03-02 11:06:41','emp@emp','emp','http://localhost:8080/upload/Employee_2.png','emp','emp','9859586235',4212,'Male',NULL),(103,'555/null/321/321/541','1995-02-19','2023-03-02 11:07:53','empsamp@empsamp','empsamp','http://localhost:8080/upload/Employee_3.png','empsamp','empsamp','9965212563',4541,'Male','2023-03-02 11:08:01');
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
INSERT INTO `farmers` VALUES (101,'231/123/231/123/213','sample','1980-07-15','sample','2023-03-02 10:41:05','sample','sample@sample','231','sample','sample','http://localhost:8080/upload/Farmer_1.png','sample','sample','9335852565','2',4323,'Male','sample',1,NULL,'sample'),(102,'232/123/321/231/122','user','1995-02-28','user','2023-03-02 10:52:17','user','user@user','123123','user','user','http://localhost:8080/upload/Farmer_2.png','user','user','9585862142','2',4232,'Male','user',1,NULL,'user'),(103,'231/112/234/231/442','three','1980-09-16','three','2023-03-02 10:53:45','three','three@three','4444','three','three','http://localhost:8080/upload/Farmer_3.png','three','three','95231452313','2',4223,'Male','three',1,NULL,'three');
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
INSERT INTO `fibers` VALUES (101,'2023-03-02 10:56:42','Wheat',1),(102,'2023-03-02 10:57:02','Pineapple',1),(103,'2023-03-02 10:58:22','Rice',1);
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
INSERT INTO `hibernate_sequence` VALUES (8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
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
INSERT INTO `mrc_sequence` VALUES (101);
/*!40000 ALTER TABLE `mrc_sequence` ENABLE KEYS */;
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
INSERT INTO `tuxy` VALUES (1,'2023-03-02 10:58:52',50,20,'Abaca',100,1),(2,'2023-03-02 10:59:51',40,10,'Tuxy',90,1),(3,'2023-03-02 11:00:10',45,15,'sample',95,1);
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

-- Dump completed on 2023-03-02 22:30:06
