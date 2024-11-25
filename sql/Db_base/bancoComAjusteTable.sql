-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: bancotechacademy4_2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `auditoria_item`
--

DROP TABLE IF EXISTS `auditoria_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditoria_item` (
  `id_auditoria` int(11) NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT current_timestamp(),
  `preco_antigo` decimal(10,2) DEFAULT NULL,
  `preco_novo` decimal(10,2) DEFAULT NULL,
  `motivo` varchar(1000) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_auditoria`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `auditoria_item_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_item`
--

LOCK TABLES `auditoria_item` WRITE;
/*!40000 ALTER TABLE `auditoria_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `descricao` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Notebook','Os dispositivos dessa categoria seram Notebook'),(2,'SmartPhone','Os dispositivos dessa categoria seram Smartphone'),(3,'Acessorios','Os dispositivos dessa categoria seram Acessorios'),(4,'Monitor','Os dispositivos dessa categoria seram Monitor'),(5,'Hardware','Os dispositivos dessa categoria seram Hardware');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `cep` int(11) DEFAULT NULL,
  `cidade` varchar(200) DEFAULT NULL,
  `UF` varchar(50) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `rua` varchar(200) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `contato` varchar(15) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `nome_destinatario` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (6,87355000,'Juranda','PR','Centro','Rua tupinabas',2246,'44-999927372',3,'Lucas Carvalho pedrozo');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2024-11-17 19:59:48',0,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formapgto`
--

DROP TABLE IF EXISTS `formapgto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formapgto` (
  `id_forma` int(11) NOT NULL,
  `tipo` varchar(200) DEFAULT NULL,
  `parcela` int(11) DEFAULT NULL,
  `juros` double DEFAULT NULL,
  PRIMARY KEY (`id_forma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formapgto`
--

LOCK TABLES `formapgto` WRITE;
/*!40000 ALTER TABLE `formapgto` DISABLE KEYS */;
/*!40000 ALTER TABLE `formapgto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(500) DEFAULT NULL,
  `descricao` varchar(3000) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `foto` varchar(1000) DEFAULT NULL,
  `atributo_1` varchar(500) DEFAULT NULL,
  `atributo_2` varchar(500) DEFAULT NULL,
  `atributo_3` varchar(500) DEFAULT NULL,
  `atributo_4` varchar(500) DEFAULT NULL,
  `atributo_5` varchar(500) DEFAULT NULL,
  `atributo_6` varchar(500) DEFAULT NULL,
  `estoque` int(11) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'iPhone 16 Pro Max Apple 512GB, Câmera Tripla de 48MP, Tela 6,9\", Titânio Natural.','iPhone 16 Pro Max. Com estrutura em titânio, Controle da Câmera, 4K Dolby Vision a 120 qps e o chip A18 Pro. Avisos legais *As telas têm bordas arredondadas. Quando medida como um retângulo, a tela tem 6,12 polegadas (iPhone 16), 6,69 polegadas (iPhone 16 Plus), 6,27 polegadas (iPhone 16 Pro) ou 6,86 polegadas (iPhone 16 Pro Max) na diagonal. A área real de visualização é menor.',12570.00,'imagens/produtos/0_AEMYWY3BEAPTA_PRD_1500_1 2.png','Marca: Apple','Modelo: Iphone 16 Pro Max','Cor: Títanio','Memorias: 512GB/8GB de Ram','Tela: Super Retina XDR OLED de 6.7 polegadas FHD+ (2560x1600)','Proteção: IP68',100,2),(2,'Smartphone Samsung Galaxy S24 Ultra, Galaxy AI, Selfie de 12MP, Tela de 6.8\" 1-120Hz, 512GB, 12GB RAM - Titânio Cinza','O Samsung Galaxy S24 Ultra Titanio Cinza é um smartphone de alta performance que combina elegância e robustez. Ele possui um design sofisticado com acabamento em titânio, oferecendo resistência a arranhões e um acabamento acetinado suave1. A tela Dynamic LTPO AMOLED de 6,8 polegadas proporciona uma experiência visual incrível com resolução de 1440 x 3088 pixels e taxa de atualização de 120Hz',6659.00,'imagens/produtos/s24ultra.png','Marca: Samsung','Modelo: Samsung Galaxy S24 Ultra','Cor: Titânio Cinza','Memoria: 512Gb, 12Gb de Ram','Tela: Tela Infinita de 6.8 1-120Hz, Dynamic amoled 2x','Proteção: IP68',100,2),(3,'Smartphone Samsung Galaxy Z Fold6 512GB Cinza 5G - Tela dobrável de 7.6\" e 12GB de RAM','Celular samsung galaxy z fold6 com tela dobrável de 7.6” amoled dinâmico 2x (aberto) e 6.3” amoled dinâmico (fechado), 512 gb, 12gb de ram, câmera tripla traseira de 50mp (dual pixel, ois) + 12mp (ultra wide) + 10mp (telefoto, ois) frontal de 4mp (sob display) (aberto), câmera frontal de 10mp (dual pixel) (fechado), bateria de 4400mah com carregamento super-rápido de 45w, dual chip, android 14 o novo galaxy z fold6, é o smartphone ideal para você que gosta de design premium, moderno e elegante e que procura uma portabilidade otimizada para seu dia a dia.',9214.00,'imagens/produtos/galaxZfold6Cinza.png','Marca: Samsung','Modelo: Samsung Galaxy Zfold 6','Cor: Cinza','Memoria: 512Gb, 12Gb de Ram','Tela: Tela Infinita de 6.8 1-120Hz, Dynamic amoled 2x','Proteção: IP48',100,2),(4,'Celular Samsung Galaxy M54 5g 8gb Ram 128gb Tela 6.7','O Samsung Galaxy M54 5G é um smartphone poderoso, ideal para quem busca desempenho e qualidade de câmera. Ele possui uma tela Super AMOLED Plus de 6,7 polegadas com resolução FHD+ e taxa de atualização de 120Hz, garantindo uma experiência visual incrível.Equipado com uma câmera principal de 108MP com estabilização óptica, permite capturar fotos detalhadas e vídeos estáveis. Seu processador Exynos 1380 Octa-Core e 8GB de RAM.',1400.00,'imagens/produtos/galaxym54.png','Marca: Samsung','Modelo: Samsung Galaxy M54','Cor: Azul','Memoria: 128Gb, 8Gb de Ram','Tela: Tela Infinita de 6.8 120Hz Super Amoled Plus','Conecxão: 5G',100,2),(5,'Smartphone Samsung Galaxy A55 5g 128gb 8gb Ram Tela 6,6 Câmera Tripla 50mp Frontal 32mp white','O Samsung Galaxy A55 5G é um smartphone versátil e elegante, ideal para quem busca um dispositivo com bom desempenho e câmeras de alta qualidade. Ele possui uma tela Super AMOLED de 6,6 polegadas com resolução FHD+ e taxa de atualização de 120Hz, proporcionando uma experiência visual incrível.',1600.00,'imagens/produtos/galaxya55.png','Marca: Samsung','Modelo: Samsung Galaxy A55','Cor: White','Memoria: 256Gb, 8Gb de Ram','Tela: Tela Infinita de 6.8 120Hz Super Amoled Plus','Proteção: IP67',100,2),(6,'Smartphone Samsung Galaxy Z Fold6 512GB black 5G - Tela dobrável de 7.6\" e 12GB de RAM','Celular samsung galaxy z fold6 com tela dobrável de 7.6” amoled dinâmico 2x (aberto) e 6.3” amoled dinâmico (fechado), 512 gb, 12gb de ram, câmera tripla traseira de 50mp (dual pixel, ois) + 12mp (ultra wide) + 10mp (telefoto, ois) frontal de 4mp (sob display) (aberto), câmera frontal de 10mp (dual pixel) (fechado), bateria de 4400mah com carregamento super-rápido de 45w, dual chip, android 14 o novo galaxy z fold6, é o smartphone ideal para você que gosta de design premium, moderno e elegante e que procura uma portabilidade otimizada para seu dia a dia.',9214.00,'imagens/produtos/galaxZfold6.png','Marca: Samsung','Modelo: Samsung Galaxy Zfold 6','Cor: Black','Memoria: 512Gb, 12Gb de Ram','Tela: Tela Infinita de 6.8 1-120Hz, Dynamic amoled 2x','Proteção: IP48',100,2);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double DEFAULT NULL,
  `data_pedido` date DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `usuario_id` (`usuario_id`),
  KEY `fk_item_id` (`item_id`),
  CONSTRAINT `fk_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (5,6659,'2024-11-25','em pagamento',3,3),(7,12570,'2024-11-25','em pagamento',3,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_forma`
--

DROP TABLE IF EXISTS `pedido_forma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_forma` (
  `status` varchar(100) DEFAULT NULL,
  `pedido_id` int(11) NOT NULL,
  `forma_id` int(11) NOT NULL,
  PRIMARY KEY (`pedido_id`,`forma_id`),
  KEY `forma_id` (`forma_id`),
  CONSTRAINT `pedido_forma_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id_pedido`),
  CONSTRAINT `pedido_forma_ibfk_2` FOREIGN KEY (`forma_id`) REFERENCES `formapgto` (`id_forma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_forma`
--

LOCK TABLES `pedido_forma` WRITE;
/*!40000 ALTER TABLE `pedido_forma` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_forma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (3,'Lucas Carvalho Pedrozo','LucasPedrozoMD@hotmail.com','12345678',NULL,1),(5,'Bia','Bia@hotmail.com','12456789','2024-11-23',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bancotechacademy4_2'
--
/*!50003 DROP FUNCTION IF EXISTS `pagamento_maior_que_salario_da_data` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `pagamento_maior_que_salario_da_data`(id_funcionario INT, data_pagamento DATE) RETURNS tinyint(1)
    DETERMINISTIC
begin 
	declare salario_base decimal(10,2);
	declare valor_pagamento decimal(10,2)default 0;
	
	select f.salario_base into salario_base from funcionario f
	where f.id_funcionario = id_funcionario;
	
	select coalesce (p.vl_pagamento, 0) into valor_pagamento from pagamento p
	where p.id_funcionario = id_funcionario
	and p.id_pagamento = data_pagamento
	limit 1;
	
	return if(valor_pagamento>salario_base, 1,0);

 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-25 15:31:06
