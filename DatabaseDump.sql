CREATE DATABASE  IF NOT EXISTS `inventory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `inventory`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bathroom'),(2,'Dining'),(3,'Cooking'),(4,'Decoration'),(5,'Laundry'),(6,'Lighting'),(7,'Textiles and Rugs'),(8,'Leisure'),(9,'Pets'),(10,'Outdoors'),(12,'Test2'),(13,'Test');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) NOT NULL,
  `idcountry` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkcitycountry_idx` (`idcountry`) /*!80000 INVISIBLE */,
  CONSTRAINT `fkcitycountry` FOREIGN KEY (`idcountry`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Tokyo',1),(2,'Shanghai',2),(3,'Bangkok',3),(4,'Sydney',4),(5,'Dublin',5),(6,'Cape Town',6),(7,'Buenos Aires',7),(8,'Munich',8),(9,'Moscow',9),(10,'Cairo',10);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Japan'),(2,'China'),(3,'Thailand'),(4,'Australia'),(5,'Ireland'),(6,'South Africa'),(7,'Argentina'),(8,'Germany'),(9,'Russia'),(10,'Egypt');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(25) NOT NULL,
  `description` varchar(150) NOT NULL,
  `cost` double NOT NULL,
  `price` double NOT NULL,
  `idcategory` int(11) NOT NULL,
  `idsupplier` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkproductcategory_idx` (`idcategory`),
  KEY `fkproductsupplier_idx` (`idsupplier`),
  CONSTRAINT `fkproductcategory` FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`),
  CONSTRAINT `fkproductsupplier` FOREIGN KEY (`idsupplier`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'N9TTONI6','Magazine file',37.68,59.7,1,10),(2,'9G0AS89U','Bowl',31.83,78.74,2,9),(3,'B7FQXNSS','Storage box with lid',32.32,66.25,3,8),(4,'RANCHSJW','Table with 2 chairs',30.95,61.03,4,7),(5,'QK6A3NGU','Frame',40.46,70.12,5,6),(6,'JI6S8XTJ','Armchair',42.61,70.05,6,5),(7,'7ETRNHLE','Cushion cover',28.7,66.82,7,4),(8,'0A6CL6MI','4 outler power strip',25.21,74.38,8,3),(9,'SXFP4GE4','Desk organizer',25,73.51,9,2),(10,'CHYKETEV','Soap dispenser',23.39,78.87,10,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `product_view`
--

DROP TABLE IF EXISTS `product_view`;
/*!50001 DROP VIEW IF EXISTS `product_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `product_view` AS SELECT 
 1 AS `id`,
 1 AS `code`,
 1 AS `description`,
 1 AS `cost`,
 1 AS `price`,
 1 AS `category`,
 1 AS `supplier`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `zipcode` varchar(25) NOT NULL,
  `coordinates` varchar(150) NOT NULL,
  `idcity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkstorecity_idx` (`idcity`),
  CONSTRAINT `fkstorecity` FOREIGN KEY (`idcity`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'Aventura Mall','(347) 874-9940','677 Miles St.','20705','7.85534, 107.15854',1),(2,'Westfield Shopping Centre','(988) 686-5167','29 S. Cactus Ave.','11001','46.36302, 26.96867',2),(3,'Cambridge Galleria','(471) 866-3104','904 North Dr.','50010','-20.54704, -160.51124',3),(4,'Eatons Center','(551) 444-4211','9081 Oak Valley Ave.','28752','9.08587, -156.26780',4),(5,'Forum Mall','(591) 508-7384','56 Cherry St.','19401','-63.94046, 49.08883',5),(6,'Ambience Mall','(227) 634-5934','843 Livingston Rd.','46530','9.56326, -164.13302',6),(7,'Zhengjia Plaza','(675) 914-7906','9932 Valley St.','13440','7.10204, 64.64505',7),(8,'Wynn Esplanade','(221) 317-4212','873 Parker Ln.','28078','-15.56444, -75.74442',8),(9,'Bawadi Mall','(789) 377-9980','956 Arlington St.','59715',' -70.26254, 135.60802',9),(10,'South Coast Plaza','(330) 432-8141','677 Miles St.','20705','-22.46108, -9.74072',10);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `store_view`
--

DROP TABLE IF EXISTS `store_view`;
/*!50001 DROP VIEW IF EXISTS `store_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `store_view` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `telephone`,
 1 AS `address`,
 1 AS `zipcode`,
 1 AS `coordinates`,
 1 AS `city`,
 1 AS `country`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `contactname` varchar(100) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'StrimpMetrics','Félix Küchler','(914) 792-3341'),(2,'Computer.ly','Silvester Villanueva','(874) 530-4890'),(3,'Processorr','Naia Alscher','(460) 752-4743'),(4,'DeskM','Helga Bambach','(300) 633-5801'),(5,'MFirmware','Rúna Milne','(249) 832-5902'),(6,'Virtuary','Anna Bosque','(619) 836-8183'),(7,'Nextstep','Hilario Van Ogtrop','(872) 861-0228'),(8,'Servert','Esther De Cloet','(316) 995-5662'),(9,'Taskdesk','Rokuro Östberg','(444) 480-4415'),(10,'Pomechip','Mai Fredriksen','(650) 974-8730');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  `type` int(11) NOT NULL,
  `idwarehouseproduct` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fktransactionwarehouseproduct_idx` (`idwarehouseproduct`),
  CONSTRAINT `fktransactionwarehouseproduct` FOREIGN KEY (`idwarehouseproduct`) REFERENCES `warehouse_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,9,'2019-01-17',1,1),(2,5,'2019-01-19',1,2),(3,7,'2019-01-24',0,3),(4,8,'2019-01-25',1,4),(5,1,'2019-01-30',0,5),(6,8,'2019-02-05',0,6),(7,1,'2019-02-08',0,7),(8,2,'2019-02-16',1,8),(9,8,'2019-02-17',1,9),(10,10,'2019-02-22',0,10),(12,5,'2019-01-01',0,1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `transaction_view`
--

DROP TABLE IF EXISTS `transaction_view`;
/*!50001 DROP VIEW IF EXISTS `transaction_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `transaction_view` AS SELECT 
 1 AS `id`,
 1 AS `quantity`,
 1 AS `date`,
 1 AS `type`,
 1 AS `product`,
 1 AS `warehouse`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `idstore` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkwarehousestore_idx` (`idstore`),
  CONSTRAINT `fkwarehousestore` FOREIGN KEY (`idstore`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,'Cold Storage',1),(2,'Field Warehouse',2),(3,'Agricultural Warehouse',3),(4,'Parcel Delivery Center',4),(5,'Return Processing Center',5),(6,'Sorting Center',6),(7,'Pink Warehouse',7),(8,'Urban Logistics Depot',8),(9,'Parcel Hub',9),(10,'Green Storage',10);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_product`
--

DROP TABLE IF EXISTS `warehouse_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `idwarehouse` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkwarehouse_idx` (`idwarehouse`),
  KEY `fkproduct_idx` (`idproduct`),
  CONSTRAINT `fkproduct` FOREIGN KEY (`idproduct`) REFERENCES `product` (`id`),
  CONSTRAINT `fkwarehouse` FOREIGN KEY (`idwarehouse`) REFERENCES `warehouse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_product`
--

LOCK TABLES `warehouse_product` WRITE;
/*!40000 ALTER TABLE `warehouse_product` DISABLE KEYS */;
INSERT INTO `warehouse_product` VALUES (1,5,1,10),(2,0,2,9),(3,0,3,8),(4,0,4,7),(5,0,5,6),(6,0,6,5),(7,0,7,4),(8,0,8,3),(9,0,9,2),(10,0,10,1);
/*!40000 ALTER TABLE `warehouse_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `warehouse_view`
--

DROP TABLE IF EXISTS `warehouse_view`;
/*!50001 DROP VIEW IF EXISTS `warehouse_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `warehouse_view` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `store`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `warehouseproduct_view`
--

DROP TABLE IF EXISTS `warehouseproduct_view`;
/*!50001 DROP VIEW IF EXISTS `warehouseproduct_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `warehouseproduct_view` AS SELECT 
 1 AS `id`,
 1 AS `stock`,
 1 AS `product`,
 1 AS `warehouse`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `product_view`
--

/*!50001 DROP VIEW IF EXISTS `product_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `product_view` AS select `product`.`id` AS `id`,`product`.`code` AS `code`,`product`.`description` AS `description`,`product`.`cost` AS `cost`,`product`.`price` AS `price`,`category`.`name` AS `category`,`supplier`.`name` AS `supplier` from ((`product` join `category` on((`product`.`idcategory` = `category`.`id`))) join `supplier` on((`product`.`idsupplier` = `supplier`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `store_view`
--

/*!50001 DROP VIEW IF EXISTS `store_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `store_view` AS select `store`.`id` AS `id`,`store`.`name` AS `name`,`store`.`telephone` AS `telephone`,`store`.`address` AS `address`,`store`.`zipcode` AS `zipcode`,`store`.`coordinates` AS `coordinates`,`city`.`name` AS `city`,`country`.`name` AS `country` from ((`store` join `city` on((`store`.`idcity` = `city`.`id`))) join `country` on((`city`.`idcountry` = `country`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `transaction_view`
--

/*!50001 DROP VIEW IF EXISTS `transaction_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `transaction_view` AS select `transaction`.`id` AS `id`,`transaction`.`quantity` AS `quantity`,`transaction`.`date` AS `date`,`transaction`.`type` AS `type`,`product`.`description` AS `product`,`warehouse`.`name` AS `warehouse` from (((`transaction` join `warehouse_product` on((`transaction`.`idwarehouseproduct` = `warehouse_product`.`id`))) join `product` on((`warehouse_product`.`idproduct` = `product`.`id`))) join `warehouse` on((`warehouse_product`.`idwarehouse` = `warehouse`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `warehouse_view`
--

/*!50001 DROP VIEW IF EXISTS `warehouse_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `warehouse_view` AS select `warehouse`.`id` AS `id`,`warehouse`.`name` AS `name`,`store`.`name` AS `store` from (`warehouse` join `store` on((`warehouse`.`idstore` = `store`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `warehouseproduct_view`
--

/*!50001 DROP VIEW IF EXISTS `warehouseproduct_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `warehouseproduct_view` AS select `warehouse_product`.`id` AS `id`,`warehouse_product`.`stock` AS `stock`,`product`.`description` AS `product`,`warehouse`.`name` AS `warehouse` from ((`warehouse_product` join `product` on((`warehouse_product`.`idproduct` = `product`.`id`))) join `warehouse` on((`warehouse_product`.`idwarehouse` = `warehouse`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-22 21:29:28
