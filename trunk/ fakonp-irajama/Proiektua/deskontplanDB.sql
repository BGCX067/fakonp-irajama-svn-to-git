-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (i486)
--
-- Host: localhost    Database: deskontplan
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10

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
-- Current Database: `deskontplan`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `deskontplan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `deskontplan`;

--
-- Table structure for table `Administratzailea`
--

DROP TABLE IF EXISTS `Administratzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administratzailea` (
  `idErabiltzailea` int(11) NOT NULL AUTO_INCREMENT,
  `izena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idErabiltzailea`),
  KEY `fk_Administratzailea_1` (`idErabiltzailea`),
  CONSTRAINT `fk_Administratzailea_1` FOREIGN KEY (`idErabiltzailea`) REFERENCES `Erabiltzailea` (`idErabiltzailea`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administratzailea`
--

LOCK TABLES `Administratzailea` WRITE;
/*!40000 ALTER TABLE `Administratzailea` DISABLE KEYS */;
/*!40000 ALTER TABLE `Administratzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bezeroa`
--

DROP TABLE IF EXISTS `Bezeroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bezeroa` (
  `idErabiltzailea` int(11) NOT NULL AUTO_INCREMENT,
  `izena` varchar(45) DEFAULT NULL,
  `abizena` varchar(45) DEFAULT NULL,
  `hiria` varchar(45) DEFAULT NULL,
  `postakodea` int(11) DEFAULT NULL,
  `visaZb` varchar(45) DEFAULT NULL,
  `ezizena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idErabiltzailea`),
  KEY `fk_Bezeroa_1` (`idErabiltzailea`),
  CONSTRAINT `fk_Bezeroa_1` FOREIGN KEY (`idErabiltzailea`) REFERENCES `Erabiltzailea` (`idErabiltzailea`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bezeroa`
--

LOCK TABLES `Bezeroa` WRITE;
/*!40000 ALTER TABLE `Bezeroa` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bezeroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enpresa`
--

DROP TABLE IF EXISTS `Enpresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Enpresa` (
  `idErabiltzailea` int(11) NOT NULL AUTO_INCREMENT,
  `enpresaIzena` varchar(45) DEFAULT NULL,
  `kontaktuIzena` varchar(45) DEFAULT NULL,
  `telefonoa` varchar(45) DEFAULT NULL,
  `helbidea` varchar(45) DEFAULT NULL,
  `hiria` varchar(45) DEFAULT NULL,
  `postaKodea` int(11) DEFAULT NULL,
  `kontuKorronteZb` int(11) DEFAULT NULL,
  `idJarduera` int(11) NOT NULL,
  PRIMARY KEY (`idErabiltzailea`),
  KEY `fk_Enpresa_1` (`idErabiltzailea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enpresa`
--

LOCK TABLES `Enpresa` WRITE;
/*!40000 ALTER TABLE `Enpresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `Enpresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Erabiltzailea`
--

DROP TABLE IF EXISTS `Erabiltzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Erabiltzailea` (
  `idErabiltzailea` int(11) NOT NULL,
  `emaila` varchar(45) DEFAULT NULL,
  `pasahitza` varchar(45) DEFAULT NULL,
  `profila` char(1) DEFAULT NULL,
  PRIMARY KEY (`idErabiltzailea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Erabiltzailea`
--

LOCK TABLES `Erabiltzailea` WRITE;
/*!40000 ALTER TABLE `Erabiltzailea` DISABLE KEYS */;
INSERT INTO `Erabiltzailea` VALUES (1,'iuhi','fd',NULL);
/*!40000 ALTER TABLE `Erabiltzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Eskaintza`
--

DROP TABLE IF EXISTS `Eskaintza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Eskaintza` (
  `idEskaintza` int(11) NOT NULL AUTO_INCREMENT,
  `izenburua` varchar(45) DEFAULT NULL,
  `deskribapena` varchar(45) DEFAULT NULL,
  `argazkia` varchar(45) DEFAULT NULL,
  `erabilDataHasiera` date DEFAULT NULL,
  `erabilDataAmaiera` date DEFAULT NULL,
  `txartelKopuruMax` int(11) DEFAULT NULL,
  `txartelKopuruMaxPertsona` int(11) DEFAULT NULL,
  `jatorrizkoPrezioa` float DEFAULT NULL,
  `salmentaPrezioa` float DEFAULT NULL,
  `egoera` char(1) DEFAULT NULL,
  `salduDataHasiera` date DEFAULT NULL,
  `salduDataAmaiera` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEskaintza`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Eskaintza`
--

LOCK TABLES `Eskaintza` WRITE;
/*!40000 ALTER TABLE `Eskaintza` DISABLE KEYS */;
/*!40000 ALTER TABLE `Eskaintza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jarduera`
--

DROP TABLE IF EXISTS `Jarduera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jarduera` (
  `idJarduera` int(11) NOT NULL AUTO_INCREMENT,
  `Jardueracol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idJarduera`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jarduera`
--

LOCK TABLES `Jarduera` WRITE;
/*!40000 ALTER TABLE `Jarduera` DISABLE KEYS */;
/*!40000 ALTER TABLE `Jarduera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Kategoria`
--

DROP TABLE IF EXISTS `Kategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kategoria` (
  `idKategoria` int(11) NOT NULL AUTO_INCREMENT,
  `deskribapena` varchar(45) DEFAULT NULL,
  `deskontuMinPortzentaia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idKategoria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kategoria`
--

LOCK TABLES `Kategoria` WRITE;
/*!40000 ALTER TABLE `Kategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `Kategoria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-03 17:42:54
