-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: auction_house
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` VALUES (1,8000.00,500.00,0,111223333,1,10000.00,0.00),(19,5000.00,200.00,1,111223333,2,7000.00,0.00),(34,5.00,1.00,23,111223333,3,10.00,0.00),(39,600.00,100.00,1,111223333,5,500.00,0.00);
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bid`
--

LOCK TABLES `bid` WRITE;
/*!40000 ALTER TABLE `bid` DISABLE KEYS */;
/*!40000 ALTER TABLE `bid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (23512547,'1111111111111111',5),(123123123,'1111111111111111',2),(123456788,'1111112111111111',10);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (111223333,'20171204',375.85,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Car is good','camry','Car',10),(2,'Car is excellent','Nissan Sentra','Car',1),(3,'Movie disc good','Titanic','DVD',40),(4,'System','Xbox One','Game',20),(5,'Great laptop','MSI GX63VR','Laptop',5),(10,'phone','Iphone X','Phone',8),(15,'Car is excellent','BMW-725 2018','Car',1),(18,'TV 60\'','Samsung TV','tv',13),(19,'PS4','PS4','Game',20),(20,'Nitendo','Nitendo','Game',20),(21,'Fifa 2019','Fifa 19','Game',50),(22,'Battlefield 1','Battlefield 1','Game',50),(23,'Call of duty','Call of duty','Game',50);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (305305,'Kapur','Hridesh','123 College road','Stony Brook','NY','11790','(516) 215-2345','hridesh@gmail.com','hridesh@gmail.com','1234','manager'),(23512547,'Ab','Khaleed','A','A','NY','15515','51632','abcd@gmail.com','abcd@gmail.com','1234','customer'),(111223333,'D','Daniel','D','D','CA','11510','515','daniel2018@gmail.com','daniel2018@gmail.com','1234','customerRepresentative'),(123123123,'H','H','H','H','NY','51515','515155','h@gmail.com','h@gmail.com','1','customer'),(123456788,'Khan','Jay','J','Stony','CA','11510','515424','janmejay@gmail.com','janmejay@gmail.com','1234','customer');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('2018-12-10 20:35:00','2018-12-10 20:00:00',123123123,19);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `salehistory`
--

LOCK TABLES `salehistory` WRITE;
/*!40000 ALTER TABLE `salehistory` DISABLE KEYS */;
INSERT INTO `salehistory` VALUES (123456788,123123123,6500.00,'2018-21-11 01:21:40',1,1),(123456788,123123123,1000.00,'2018-18-11 04:18:25',1,1),(123123123,123456788,10000.00,'2018-21-11 06:32:59',2,19);
/*!40000 ALTER TABLE `salehistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-11 14:40:41
