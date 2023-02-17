-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: coop
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `account_images`
--

DROP TABLE IF EXISTS `account_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_images` (
  `account_id` bigint NOT NULL,
  `image_id` bigint NOT NULL,
  PRIMARY KEY (`account_id`,`image_id`),
  KEY `FK8cski7v7ke1gj4wgrgv0ymtbx` (`image_id`),
  CONSTRAINT `FK8cski7v7ke1gj4wgrgv0ymtbx` FOREIGN KEY (`image_id`) REFERENCES `image_model` (`image_id`),
  CONSTRAINT `FKplmu2qk7minyn3q2p99umy2s9` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_images`
--

LOCK TABLES `account_images` WRITE;
/*!40000 ALTER TABLE `account_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_images` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','admin',1,'admin');
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
INSERT INTO `backup` VALUES (1,'C:\\Users\\Lester\\Documents\\demo\\backup\\Daily_DB_Backup_05-12-2022.sql','2022-12-05 11:42:01'),(2,'C:\\Users\\Lester\\Documents\\demo\\backup\\Daily_DB_Backup_05-12-2022.sql','2022-12-05 11:46:18'),(3,'C:\\Users\\Lester\\Documents\\demo\\backup\\Database_Backup_05-12-2022.sql','2022-12-05 11:47:21'),(4,'.\\backup\\Database_Backup_05-12-2022.sql','2022-12-05 12:22:12'),(33,'.\\backup\\Database_Backup_08-12-2022.sql','2022-12-08 07:12:53'),(35,'.\\backup\\Database_Backup_11-12-2022.sql','2022-12-11 12:40:06');
/*!40000 ALTER TABLE `backup` ENABLE KEYS */;
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
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `e_photo` varchar(255) DEFAULT NULL,
  `image_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
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
INSERT INTO `farm_sequence` VALUES (130100001);
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
  `birthday` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `update_date` datetime DEFAULT NULL,
  `f_photo` varchar(255) DEFAULT NULL,
  `image_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`farmer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmers`
--

LOCK TABLES `farmers` WRITE;
/*!40000 ALTER TABLE `farmers` DISABLE KEYS */;
INSERT INTO `farmers` VALUES (100001,NULL,NULL,'2022-12-07 13:16:38',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(100002,NULL,NULL,'2022-12-07 13:18:08',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(10100002,NULL,NULL,'2022-12-07 13:20:48',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(20100002,NULL,NULL,'2022-12-07 13:28:38',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(30100002,NULL,NULL,'2022-12-07 13:34:49',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(40100002,NULL,NULL,'2022-12-07 13:36:07',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(50100002,NULL,NULL,'2022-12-07 13:36:38',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(60100002,NULL,NULL,'2022-12-07 13:38:10',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(70100002,NULL,NULL,'2022-12-07 13:41:08',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(70100003,NULL,NULL,'2022-12-07 13:41:31',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(70100004,NULL,NULL,'2022-12-07 14:00:30',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(80100002,NULL,NULL,'2022-12-07 14:02:16',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(80100003,NULL,NULL,'2022-12-07 14:04:23',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(90100002,NULL,NULL,'2022-12-07 14:09:44',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(90100003,NULL,NULL,'2022-12-07 14:10:32',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(100100002,NULL,NULL,'2022-12-07 14:23:48',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(110100002,NULL,NULL,'2022-12-08 12:35:12',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL);
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
  `fiber_id` bigint DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `knife_used` double NOT NULL,
  `price` double NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `stripping_cleaning` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
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
INSERT INTO `fiber_items` VALUES (20,101,'EF',0,120,1,'Excellent','2022-12-06 02:57:19'),(21,101,'S-EF',0,110,1,'Excellent','2022-12-06 02:57:19'),(22,104,'S2',0,70,1,'Excellent','2022-12-06 03:04:19'),(23,104,'S-S2',0,60,1,'Excellent','2022-12-06 03:04:19'),(24,152,'S3',0,50,1,'Excellent','2022-12-06 03:10:56'),(25,152,'S-S3',0,30,1,'Excellent','2022-12-06 03:10:56'),(26,202,'I',24,50,1,'Good','2022-12-06 13:51:51'),(27,202,'SI',24,30,1,'Good','2022-12-06 13:51:51');
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
INSERT INTO `fiber_sequence` VALUES (301);
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
INSERT INTO `fibers` VALUES (101,'2022-12-06 02:57:19','Mid Current',1),(104,'2022-12-06 03:04:19','Streaky two',1),(152,'2022-12-06 03:10:56','Streaky three',1),(202,'2022-12-06 13:51:51','Current',1);
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
INSERT INTO `hibernate_sequence` VALUES (36);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_model`
--

DROP TABLE IF EXISTS `image_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_model` (
  `image_id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pic_byte` longblob,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_model`
--

LOCK TABLES `image_model` WRITE;
/*!40000 ALTER TABLE `image_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_sequence`
--

DROP TABLE IF EXISTS `image_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_sequence`
--

LOCK TABLES `image_sequence` WRITE;
/*!40000 ALTER TABLE `image_sequence` DISABLE KEYS */;
INSERT INTO `image_sequence` VALUES (101);
/*!40000 ALTER TABLE `image_sequence` ENABLE KEYS */;
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
  `plant_grade` varchar(255) DEFAULT NULL,
  `plant_kilogram` double NOT NULL,
  `plant_name` varchar(255) DEFAULT NULL,
  `plant_price` double NOT NULL,
  `transactions_id` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKk2luy5yce6vq1q3on26dl6d6a` (`transactions_id`),
  CONSTRAINT `FKk2luy5yce6vq1q3on26dl6d6a` FOREIGN KEY (`transactions_id`) REFERENCES `transactionss` (`id`)
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
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
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
  `id` bigint NOT NULL,
  `farmer_id` varchar(255) DEFAULT NULL,
  `plant_total` double NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `name` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `discarte_price` double NOT NULL,
  `good_price` double NOT NULL,
  `reseco_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy`
--

LOCK TABLES `tuxy` WRITE;
/*!40000 ALTER TABLE `tuxy` DISABLE KEYS */;
INSERT INTO `tuxy` VALUES (12,'2022-12-05 15:26:18','tuxy_sample',1,60,60,60),(16,'2022-12-05 15:34:42','tuxy_sample_1',1,0,0,0);
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
  `updated_by` varchar(255) DEFAULT NULL,
  `tuxy_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy_log`
--

LOCK TABLES `tuxy_log` WRITE;
/*!40000 ALTER TABLE `tuxy_log` DISABLE KEYS */;
INSERT INTO `tuxy_log` VALUES (32,'Successfully update Good  10.0 into new 60.0','2022-12-07 06:48:34',1,'User full name',13),(34,'Successfully update Good  10.0 into new 60.0','2022-12-09 17:13:36',1,'User full name',13);
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
  `tuxy_id` bigint DEFAULT NULL,
  PRIMARY KEY (`price_id`),
  KEY `FK1qwbqsc0qun5d8shqp7qj0xqv` (`tuxy_id`),
  CONSTRAINT `FK1qwbqsc0qun5d8shqp7qj0xqv` FOREIGN KEY (`tuxy_id`) REFERENCES `tuxy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuxy_price`
--

LOCK TABLES `tuxy_price` WRITE;
/*!40000 ALTER TABLE `tuxy_price` DISABLE KEYS */;
INSERT INTO `tuxy_price` VALUES (13,100,'Good',12),(14,70,'Discarte',12),(15,10,'Reseco',12),(17,120,'Good',16),(18,75,'Discarte',16),(19,10,'Reseco',16);
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

-- Dump completed on 2022-12-11 20:56:04
