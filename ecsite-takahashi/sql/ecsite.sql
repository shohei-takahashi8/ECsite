-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ecsite_takahashi
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart_info`
--

set names utf8;
set foreign_key_checks = 0;

drop database if exists ecsite_takahashi;
create database ecsite_takahashi;
use ecsite_takahashi;

DROP TABLE IF EXISTS `cart_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_info`
--



--
-- Table structure for table `destination_info`
--

DROP TABLE IF EXISTS `destination_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destination_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `family_name` varchar(32) DEFAULT NULL,
  `first_name` varchar(32) DEFAULT NULL,
  `family_name_kana` varchar(32) DEFAULT NULL,
  `first_name_kana` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `tel_number` varchar(13) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination_info`
--



--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_name_kana` varchar(100) NOT NULL,
  `product_description` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `image_file_path` varchar(100) NOT NULL,
  `image_file_name` varchar(50) NOT NULL,
  `release_date` datetime NOT NULL,
  `release_company` varchar(50) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1,
  `regist_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (1,1,'野球ボール','やきゅうぼーる','野球用のボールです。',1,500,'./image/baseball.jpg','baseball','2019-11-06 00:00:00','Baseball.Co.,Ltd',1,'2019-11-06 00:00:00','2019-11-06 00:00:00'),(2,2,'バット','ばっと','野球用のバットです。',1,8000,'./image/bat.jpg','bat','2019-11-06 00:00:00','Baseball.Co.,Ltd',1,'2019-11-06 00:00:00','2019-11-06 00:00:00'),(3,3,'スパイク（野球）','すぱいく（やきゅう）','野球用のスパイクです。',1,10000,'./image/spike.jpg','baseballSpike','2019-11-08 00:00:00','Baseball.Co.,Ltd',1,'2019-11-08 00:00:00','2019-11-20 16:46:50'),(4,4,'グローブ','ぐろーぶ','野球用のグローブです。',1,12000,'./image/glove.jpg','glove','2019-11-20 00:00:00','Baseball.Co.,Ltd',1,'2019-11-20 00:00:00','2019-11-20 00:00:00');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_history_info`
--

DROP TABLE IF EXISTS `purchase_history_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_history_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `destination_id` int(11) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_history_info`
--



--
-- Table structure for table `review_info`
--

DROP TABLE IF EXISTS `review_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_info`
--



--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `family_name` varchar(32) NOT NULL,
  `first_name` varchar(32) NOT NULL,
  `family_name_kana` varchar(32) NOT NULL,
  `first_name_kana` varchar(32) NOT NULL,
  `sex` tinyint(4) DEFAULT 0,
  `email` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT 0,
  `logined` tinyint(4) NOT NULL DEFAULT 0,
  `regist_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'Test','123','Test','Test','てすと','てすと',0,'test@test.com',0,0,'2019-11-05 14:41:31','2019-11-05 14:41:31');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29 10:40:34
