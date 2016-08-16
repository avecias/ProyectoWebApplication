CREATE DATABASE  IF NOT EXISTS `agencia` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `agencia`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agencia
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `precioCompra` float NOT NULL,
  `idDistribuidor` int(11) NOT NULL,
  `matricula` varchar(6) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_compra_distribuidor1_idx` (`idDistribuidor`),
  KEY `fk_compra_auto1_idx` (`matricula`),
  CONSTRAINT `fk_compra_auto1` FOREIGN KEY (`matricula`) REFERENCES `auto` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_distribuidor1` FOREIGN KEY (`idDistribuidor`) REFERENCES `distribuidor` (`idDistribuidor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2016-01-05',705000,1,'cxr722'),(2,'2016-01-06',365000,1,'eya624'),(3,'2016-01-07',405000,1,'sxn587'),(4,'2016-01-08',265000,1,'dfh235'),(5,'2016-01-09',465000,1,'tmc456'),(6,'2016-01-10',465000,2,'ebp365'),(7,'2016-01-11',875000,2,'dyy293'),(8,'2016-01-12',755000,2,'nrc472'),(9,'2016-01-13',515000,2,'gmc775'),(10,'2016-01-14',465000,2,'rbz229'),(11,'2016-01-15',295000,3,'gxn882'),(12,'2016-01-16',755000,3,'gpb799'),(13,'2016-01-17',285000,3,'dee558'),(14,'2016-01-18',560000,3,'cxb636'),(15,'2016-01-19',535000,3,'dwb369'),(16,'2016-01-20',265000,3,'ahd793'),(17,'2016-01-21',285000,3,'rsh845'),(18,'2016-01-22',165000,3,'fsa276'),(19,'2016-01-23',265000,3,'caf475'),(20,'2016-01-24',265000,3,'fan355');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-03  0:04:17
