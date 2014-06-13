CREATE DATABASE  IF NOT EXISTS `cellphone` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cellphone`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: localhost    Database: cellphone
-- ------------------------------------------------------
-- Server version	5.5.37-0+wheezy1

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
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing` (
  `billingID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cardHolderName` varchar(45) DEFAULT NULL,
  `cardNumber` varchar(45) DEFAULT NULL,
  `expirationMonth` varchar(45) DEFAULT NULL,
  `expirationYear` varchar(45) DEFAULT NULL,
  `secureCode` char(3) DEFAULT NULL,
  PRIMARY KEY (`billingID`),
  KEY `orderID_idx` (`orderID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `specification` text,
  `photoName` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`itemID`, `name`, `description`, `specification`, `photoName`, `price`) VALUES (1,'Galaxy S4','The Galaxy S4 does what you want and what you didn\'t know was even possible','5 inch screen\n13 megapixel camera','galaxys4.jpg',99.99),(2,'Nokia Lumia 520','Stay connected with this AT&T Nokia Lumia 520 mobile phone, which features 4G speed for rapid data transfer','4 inch screen\nQuad-band\n800 x 480','nokialumia520.jpg',65.99),(3,'Apple iPhone 5s','No matter what its orientation - portrait, landscape, or anything in between - your iPhone reads your fingerprint and knows who you are','4 inch screen\n8 megapixel camera\nQuad-band','iphone5s.jpg',99.99),(4,'Motorola Droid Razr M','The big 4.3-inch display spans edge-to-edge, yet RAZR M still fits perfectly in the palm of your hand','4.3 inch screen\n8 megapixel camera\nQuad-band','razrm.jpg',89.99),(12,'Motorola Moto E','Featuring the sharpest display in its class, Corning® Gorilla® Glass protection, and a water-repellent splash guard for lasting durability, and an all-day battery','Android 4.4, KitKat\nQualcomm® Snapdragon 200 with 1.2GHz dual-core A7 CPU\nAdreno 302 400MHz single-core GPU','moto-e.jpg',129.99),(5,'Galaxy Note 2','Looking for the smartphone that can do it all? The Galaxy Note II is a powerhouse of productivity','4G LTE\n5.5 inch screen\n8 megapixel camera','galaxynote2.jpg',49.99),(6,'Apple iPhone 4s','iPhone 4S picks up where amazing left off. It\'s the fastest, most powerful iPhone ever','3.5 inch screen\n8 megapixel camera\nQuad-band','iphone4s.jpg',120.99),(7,'Nokia Lumia 521','The Nokia Lumia 521 for T-Mobile. Monthly. 4G is a fast smartphone with the flexibility of no-contract plan options','4 inch screen\n5 megapixel camera\n9 hour talk time','nokialumia521.jpg',89.99),(8,'Galaxy S3','Optimized for peak performance, the Android-powered Samsung Galaxy S III from Sprint is just ok','4.8 inch screen\n8 megapixel camera\nDual-band','galaxys3.jpg',56.99),(9,'Google Nexus 5','It\'s a 5\" phone, and so much more and built with precision','4.9 inch screen\n8 megapixel camera\nQuad-band','googlenexus5.jpg',99.99),(10,'Galaxy Note 3','An elegant new design with a larger, more vibrant HD display and incredible performance','4G LTE\n5.7 inch screen\n13 megapixel camera','galaxynote3.jpg',109.99),(13,'Motorola Moto G','The sharpest 4.5\" HD display in its class, all-day battery, quad-core speed, Android 4.4, KitKat, and colorful backs to customize your phone.','4.5 inches diagonal (11.3 cm)\n1280 x 720 HD, 329 ppi\nCorning® Gorilla Glass ','moto-g.jpg',199.99),(14,'Motorola Moto X','Moto X is ready when you are. It responds to your voice—no touching necessary.','2200 mAh. Mixed usage up to 24 hours\nBluetooth 4.0 LE + EDR','moto-x.jpg',349.99),(15,'HTC One M8','Crafted to perform','146.36 x 70.6 x 9.35 mm\n160g\n5.0 inch, Full HD 1080p','m8.jpg',639.99),(16,'OPPO N1','Return to Innovation','1.7 GHz Qualcomm Snapdragon 600 Quad Core\nAdreno 320\n2GB RAM','n1.jpg',599.99),(17,'LG P970','Come out and play','Bar phone\n850/900/1800/1900 – Edge 900/1700/2100 – HSPA 7.2/5.76\nTFT LCD WVGA 4.0 Capacitive Touchscreen (Nova Display)','p970.jpg',139.99),(18,'Sony Xperia Z1S','The best of Sony for the best of you','20.7 megapixel camera with Sony Exmor RS for mobile image sensor\n2.2 GHz Qualcomm MSM8974 Quad Core','anzu.jpg',461.39),(19,'LG CU500','Mobile Phone with Video Camera and Music Player','Music Player with External Controls, Customizable Equalizer & Visualization (supports MP3, WMA, AAC, AAC+)\nInstant Messaging – AOL® Instant Messenger, MSN Messenger, Yahoo! Messenger, & ICQ','cu500.jpg',20),(20,'Motorola Atrix HD','The MOTOROLA ATRIX HD is incredibly thin and made KEVLAR strong and splash resistant','8MP with autofocus and flash \n1780mAh battery (embedded) \nQualcomm MSM8960 processor','mb886.jpg',148),(11,'Nokia 3310','The OG cell phone','Monochrome graphic\nGSM 900 / 1800 \n113 x 48 x 22 mm, 97 cc (4.45 x 1.89 x 0.87 in)','nokia-3310-old-gold.jpg',580000);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderline` (
  `orderlineID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) DEFAULT NULL,
  `itemID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  PRIMARY KEY (`orderlineID`),
  KEY `orderID_idx` (`orderID`),
  KEY `itemID_idx` (`itemID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping`
--

DROP TABLE IF EXISTS `shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping` (
  `shippingID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  PRIMARY KEY (`shippingID`),
  KEY `orderID_idx` (`orderID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping`
--

LOCK TABLES `shipping` WRITE;
/*!40000 ALTER TABLE `shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-12 17:26:57
