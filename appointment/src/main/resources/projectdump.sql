--
-- Table structure for table `AppointmentTable`
--

DROP TABLE IF EXISTS `AppointmentTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AppointmentTable` (
  `appointmentId` int NOT NULL AUTO_INCREMENT,
  `patientId` int NOT NULL,
  `doctorId` int NOT NULL,
  `diseaseId` int DEFAULT NULL,
  `appointmentTime` time DEFAULT NULL,
  `appointmentDate` date DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(20) NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`appointmentId`),
  KEY `patientId` (`patientId`),
  KEY `doctorId` (`doctorId`),
  KEY `diseaseId` (`diseaseId`),
  CONSTRAINT `AppointmentTable_ibfk_1` FOREIGN KEY (`patientId`) REFERENCES `Patient` (`patientId`),
  CONSTRAINT `AppointmentTable_ibfk_2` FOREIGN KEY (`doctorId`) REFERENCES `Doctor` (`doctorId`),
  CONSTRAINT `AppointmentTable_ibfk_3` FOREIGN KEY (`diseaseId`) REFERENCES `Disease` (`diseaseId`),
  CONSTRAINT `status_enum` CHECK ((`status` in (_utf8mb4'Pending',_utf8mb4'Cancelled By User',_utf8mb4'Cancelled By Doctor',_utf8mb4'Rejected',_utf8mb4'Resheduled',_utf8mb4'Completed')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AppointmentTable`
--

LOCK TABLES `AppointmentTable` WRITE;
/*!40000 ALTER TABLE `AppointmentTable` DISABLE KEYS */;
/*!40000 ALTER TABLE `AppointmentTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Diagnosis`
--

DROP TABLE IF EXISTS `Diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Diagnosis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doctorId` int NOT NULL,
  `patientId` int NOT NULL,
  `diagnosisDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` varchar(1000) NOT NULL,
  `diseaseId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `diseaseId` (`diseaseId`),
  KEY `fk_diagnosis_doctor` (`doctorId`),
  KEY `fk_diagnosis_patient` (`patientId`),
  CONSTRAINT `Diagnosis_ibfk_1` FOREIGN KEY (`diseaseId`) REFERENCES `Disease` (`diseaseId`),
  CONSTRAINT `Diagnosis_ibfk_2` FOREIGN KEY (`doctorId`) REFERENCES `Doctor` (`doctorId`),
  CONSTRAINT `Diagnosis_ibfk_3` FOREIGN KEY (`patientId`) REFERENCES `Patient` (`patientId`),
  CONSTRAINT `fk_diagnosis_doctor` FOREIGN KEY (`doctorId`) REFERENCES `Doctor` (`doctorId`),
  CONSTRAINT `fk_diagnosis_patient` FOREIGN KEY (`patientId`) REFERENCES `Patient` (`patientId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Diagnosis`
--

LOCK TABLES `Diagnosis` WRITE;
/*!40000 ALTER TABLE `Diagnosis` DISABLE KEYS */;
INSERT INTO `Diagnosis` VALUES (1,22,4,'2023-04-14 12:53:04','Nothing Serious',1),(2,22,4,'2023-04-14 12:58:11','Jalsa Karo',2);
/*!40000 ALTER TABLE `Diagnosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Disease`
--

DROP TABLE IF EXISTS `Disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Disease` (
  `diseaseId` int NOT NULL AUTO_INCREMENT,
  `diseaseName` varchar(255) NOT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`diseaseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Disease`
--

LOCK TABLES `Disease` WRITE;
/*!40000 ALTER TABLE `Disease` DISABLE KEYS */;
INSERT INTO `Disease` VALUES (1,'fever','2023-04-11 05:01:04','2023-04-11 05:01:04'),(2,'cold','2023-04-11 05:01:04','2023-04-11 05:01:04'),(3,'headache','2023-04-11 05:01:04','2023-04-11 05:01:04');
/*!40000 ALTER TABLE `Disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Doctor`
--

DROP TABLE IF EXISTS `Doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Doctor` (
  `doctorId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `hospitalId` int NOT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `slotDuration` int NOT NULL,
  `bufferTime` int NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `recessEndTime` time DEFAULT NULL,
  `recessStartTime` time DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL,
  `qualification` varchar(60) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `userId` int NOT NULL,
  PRIMARY KEY (`doctorId`),
  KEY `hospitalId` (`hospitalId`),
  KEY `fk_doctor_user` (`userId`),
  CONSTRAINT `Doctor_ibfk_1` FOREIGN KEY (`hospitalId`) REFERENCES `Hospital` (`hospitalId`),
  CONSTRAINT `fk_doctor_user` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
  CONSTRAINT `Doctor_chk_1` CHECK ((`gender` in (_utf8mb4'Male',_utf8mb4'Female',_utf8mb4'Other')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Doctor`
--

LOCK TABLES `Doctor` WRITE;
/*!40000 ALTER TABLE `Doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DoctorSpecializationMap`
--

DROP TABLE IF EXISTS `DoctorSpecializationMap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DoctorSpecializationMap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doctorId` int NOT NULL,
  `specializationId` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doctorId` (`doctorId`,`specializationId`),
  KEY `qualificationId` (`specializationId`),
  CONSTRAINT `DoctorSpecializationMap_ibfk_1` FOREIGN KEY (`doctorId`) REFERENCES `Doctor` (`doctorId`),
  CONSTRAINT `DoctorSpecializationMap_ibfk_2` FOREIGN KEY (`specializationId`) REFERENCES `Specialization` (`specializationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DoctorSpecializationMap`
--

LOCK TABLES `DoctorSpecializationMap` WRITE;
/*!40000 ALTER TABLE `DoctorSpecializationMap` DISABLE KEYS */;
INSERT INTO `DoctorSpecializationMap` VALUES (1,1,1),(2,22,1);
/*!40000 ALTER TABLE `DoctorSpecializationMap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hospital`
--

DROP TABLE IF EXISTS `Hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Hospital` (
  `hospitalId` int NOT NULL AUTO_INCREMENT,
  `hospitalName` varchar(255) NOT NULL,
  `hospitalAddress` varchar(255) NOT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` int NOT NULL,
  PRIMARY KEY (`hospitalId`),
  KEY `fk_hospital_user` (`userId`),
  CONSTRAINT `fk_hospital_user` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hospital`
--

LOCK TABLES `Hospital` WRITE;
/*!40000 ALTER TABLE `Hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `Hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `patientId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `contactNo` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(50) DEFAULT NULL,
  `personId` int NOT NULL,
  PRIMARY KEY (`patientId`),
  UNIQUE KEY `patientEmail` (`email`),
  KEY `consumerId` (`personId`),
  CONSTRAINT `Patient_ibfk_1` FOREIGN KEY (`personId`) REFERENCES `Person` (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (1,'Arpit','Bhavsar','7836337909','1986-04-30','2023-04-14 05:11:23','2023-04-14 05:11:23','arpitbhavar@gmail.com',1),(4,'Jas','Bhavsar','7936337949','1986-04-30','2023-04-14 12:51:14','2023-04-14 12:51:14','rohiybhavasr@gmail.com',3),(5,'Taryn','cs','9392192923','2023-04-04','2023-04-19 04:46:40','2023-04-19 04:46:40','tmulchandani@argusoft.com',4),(6,'Pratham','cs','9392192922','2023-04-04','2023-04-19 04:49:57','2023-04-19 04:49:57','tulchandani@argusoft.com',5),(7,'Virat','kohli','9733181881','1986-05-11','2023-04-19 06:56:17','2023-04-19 06:56:17','virat@bcci.com',7);
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PatientDiseaseMap`
--

DROP TABLE IF EXISTS `PatientDiseaseMap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PatientDiseaseMap` (
  `patientId` int NOT NULL,
  `diseaseId` int NOT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`patientId`,`diseaseId`),
  KEY `diseaseId` (`diseaseId`),
  CONSTRAINT `PatientDiseaseMap_ibfk_1` FOREIGN KEY (`patientId`) REFERENCES `Patient` (`patientId`),
  CONSTRAINT `PatientDiseaseMap_ibfk_2` FOREIGN KEY (`diseaseId`) REFERENCES `Disease` (`diseaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PatientDiseaseMap`
--

LOCK TABLES `PatientDiseaseMap` WRITE;
/*!40000 ALTER TABLE `PatientDiseaseMap` DISABLE KEYS */;
INSERT INTO `PatientDiseaseMap` VALUES (4,1,'2023-04-14 12:53:04','2023-04-14 12:53:04'),(4,2,'2023-04-14 12:58:11','2023-04-14 12:58:11');
/*!40000 ALTER TABLE `PatientDiseaseMap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Person` (
  `personId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` int NOT NULL,
  PRIMARY KEY (`personId`),
  KEY `fk_person_user` (`userId`),
  CONSTRAINT `fk_person_user` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `roleId` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(100) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleName` (`roleName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (2,'Doctor'),(1,'HospitalAdmin'),(3,'SystemUser');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Specialization`
--

DROP TABLE IF EXISTS `Specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Specialization` (
  `specializationId` int NOT NULL AUTO_INCREMENT,
  `specializationName` varchar(50) NOT NULL,
  PRIMARY KEY (`specializationId`),
  UNIQUE KEY `qualificationName` (`specializationName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Specialization`
--

LOCK TABLES `Specialization` WRITE;
/*!40000 ALTER TABLE `Specialization` DISABLE KEYS */;
INSERT INTO `Specialization` VALUES (4,'Dentist'),(1,'Dermitologist'),(2,'MBBS'),(3,'MD');
/*!40000 ALTER TABLE `Specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `roleId` int DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `contactNo` varchar(15) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userEmail` (`email`),
  UNIQUE KEY `contactNo` (`contactNo`),
  KEY `fk_user_role` (`roleId`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`roleId`) REFERENCES `Role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRolesMap`
--

DROP TABLE IF EXISTS `UserRolesMap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserRolesMap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `roleId` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `UserRolesMap_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
  CONSTRAINT `UserRolesMap_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `Role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRolesMap`
--

LOCK TABLES `UserRolesMap` WRITE;
/*!40000 ALTER TABLE `UserRolesMap` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserRolesMap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'0','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'tarun','2023-04-20 04:08:41',0,1),(2,'1','create','SQL','V1__create.sql',-1855708450,'tarun','2023-04-20 04:08:43',2089,1),(3,'2','alterTables','SQL','V2__alterTables.sql',1802099113,'tarun','2023-04-20 04:08:44',715,1),(4,'3','alterTable2','SQL','V3__alterTable2.sql',-1437490634,'tarun','2023-04-20 04:08:44',518,1),(5,'4','foreignKeyRefrences','SQL','V4__foreignKeyRefrences.sql',-1821026987,'tarun','2023-04-20 04:08:44',129,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

