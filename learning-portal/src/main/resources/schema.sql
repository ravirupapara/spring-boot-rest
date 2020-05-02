--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Java','java',1),(2,'Spring','spring',2),(3,'SpringBoot','spring-boot',3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_price`
--

LOCK TABLES `course_price` WRITE;
/*!40000 ALTER TABLE `course_price` DISABLE KEYS */;
INSERT INTO `course_price` VALUES (1,0,91,0,0,1),(2,2000,91,0,0,2),(3,0,1,0,0,1),(4,300,1,0,0,2),(5,1000,91,12,6,3),(6,200,1,12,6,3),(7,1800,91,13,1,3),(8,350,1,13,1,3);
/*!40000 ALTER TABLE `course_price` ENABLE KEYS */;
UNLOCK TABLES;
