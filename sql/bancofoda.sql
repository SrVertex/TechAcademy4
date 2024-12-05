-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bancotechacademy4_2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `auditoria_item`
--

DROP TABLE IF EXISTS `auditoria_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria_item`
--

LOCK TABLES `auditoria_item` WRITE;
/*!40000 ALTER TABLE `auditoria_item` DISABLE KEYS */;
INSERT INTO `auditoria_item` VALUES (1,'2024-12-05 21:20:17',7845.00,7355.00,'Alteracao de preco',1),(2,'2024-12-05 21:20:42',2467.00,1886.00,'Alteracao de preco',5);
/*!40000 ALTER TABLE `auditoria_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `descricao` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Notebook','Os Podutos dessa categoria seram Notebook'),(2,'Smartphones','Os Podutos dessa categoria seram Smartphones'),(3,'Acessorios','Os Podutos dessa categoria seram Acessorios'),(4,'Monitor','Os Podutos dessa categoria seram Monitor'),(5,'Hardware','Os Podutos dessa categoria seram Hardware'),(6,'Games','Os Podutos dessa categoria seram Games');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,87355000,'Juranda','PR','Centro','Rua Tupinanbas',2246,'44999927372',1,'LUCAS CARVALHO PEDROZO');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(500) NOT NULL,
  `descricao` varchar(3000) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Apple iPhone 16 Pro Max (512 GB / 8 GB Ram) Titânio natural','O iPhone 16 Pro Max Titânio Natural impressiona com sua estrutura leve e resistente em titânio. A tela Super Retina XDR de 6,9 polegadas oferece imagens vibrantes e nítidas, enquanto o chip A18 Pro garante desempenho excepcional em multitarefas e jogos. A câmera Pro Fusion de 48 MP captura fotos e vídeos de alta qualidade, com recursos avançados de fotografia noturna e estabilização óptica. Resistente à água e poeira (IP68), combina durabilidade, elegância e tecnologia de ponta em um só dispositivo. Ideal para quem busca sofisticação e performance.',7355.00,'uploads/iphone16promax.png','Marca: Apple','Modelo: iPhone 16 pro max','Cor: Titânio Natural','Memorias: 512Gb / 8 Gb de Ram ','Tela: 6.9 Super Retina XDR de 6,9 polegadas','Proteção: IP68 ',1000,2),(2,'Samsung Galaxy S24 Ultra Titanio de 512GB e 12Gb de Ram - tela 6.8','O Samsung Galaxy S24 Ultra redefine a inovação com sua tela de 6,8 polegadas QHD+ Dynamic AMOLED 2X, oferecendo cores vibrantes e brilho impressionante. Equipado com o Snapdragon 8 Gen 3, garante desempenho ultrarrápido em qualquer tarefa, seja edição de vídeos ou jogos pesados2. A câmera principal de 200 MP, com zoom óptico de até 10x, captura detalhes incríveis. Resistente à água e poeira (IP68), o Galaxy S24 Ultra é ideal para aventuras ao ar livre3. Com a S Pen integrada e a Galaxy AI.',6484.00,'uploads/s24ultra.png','Marca: Samsung','Modelo: Samsung Galaxy S24 Ultra','Cor: Titânio Natural','Memorias: 512Gb / 12 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,8 polegadas','Proteção: IP68  / Span',1000,2),(3,'Samsung Galaxy Zfold 6 Black de 512GB e 12Gb de Ram - tela 6.7','\"O Samsung Galaxy Z Fold 6 é um smartphone dobrável avançado com uma tela principal de 7,6 polegadas e resolução de 2160x1856 pixels. Ele possui um processador Snapdragon 8 Gen 3, 12 GB de RAM e armazenamento interno de até 1 TB. O design fino e leve, com apenas 5,6 mm de espessura, torna o uso mais confortável. A câmera traseira de 50 MP e a câmera frontal interna com estabilizador óptico garantem fotos e vídeos de alta qualidade.',14679.00,'uploads/galaxyzfold6.png','Marca: Samsung','Modelo: Samsung Galaxy ZFold 6','Cor: Black Testure','Memorias: 512Gb / 12 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,8 polegadas','Proteção: IPX48',1000,2),(4,'Apple MacBook pro 2024 M4 pro (1TB 24 GB de Ram) Prata Apple','O MacBook Pro 4 é uma combinação de potência e elegância. Equipado com um armazenamento de 1TB, ele oferece espaço abundante para seus arquivos e projetos. Os 24GB de RAM garantem um desempenho ágil, mesmo nas tarefas mais exigentes. Com tela Retina de alta resolução, gráficos impressionantes e design sofisticado, ele é ideal para profissionais que buscam desempenho e estilo em um único dispositivo.',44778.00,'uploads/macBook4pRO.png','Marca: Apple','Modelo: MacBook Pro M4 pro','Cor: Prata Apple','Memorias: 1Tb / 24Gb de Ram ','Tela: Super Retina XDR de 16 polegadas','Hardawe: Apple Celican M4 pro',1000,1),(5,'Samsung Galaxy A55 Branco de 256Gb e 8Gb de Ram - tela 6.6','O Samsung Galaxy A55 é um smartphone Android de alto desempenho com uma tela Super AMOLED de 6,6 polegadas e resolução Full HD+. Equipado com o processador Exynos 1480, 8 GB de RAM e 256 GB de armazenamento interno, este dispositivo oferece velocidade e eficiência. A câmera principal de 50 MP e a câmera frontal de 32 MP garantem fotos e vídeos de alta qualidade. Com resistência a água e poeira (IP67), bateria de 5000 mAh e carregamento rápido, o Galaxy A55 é ideal para uso diário e entretenimento.',1886.00,'uploads/galaxya55.png','Marca: Samsung','Modelo: Samsung Galaxy A55','Cor: Branco','Memorias: 256Gb / 8 Gb de Ram ','Tela: 6.9 Super Retina XDR de 6,9 polegadas','Proteção: IP67',1000,2),(6,'Samsung Galaxy Buds 3 Pro - ANC - Galaxy AI / Bluetooth 5.3.',' Os Buds 3 Pro são fones de ouvido sem fio de alta tecnologia, projetados para oferecer uma experiência sonora imersiva. Eles têm cancelamento de ruído ativo, som de alta fidelidade e uma bateria de longa duração que garante horas de música sem interrupções. Além disso, são confortáveis e têm um design elegante que se ajusta perfeitamente ao ouvido.',1789.00,'uploads/galaxyBuds.png','Marca: Samsung','Modelo: Samsung Galaxy Buds 3 Pro','Cor: Cinza','Tecnologias: Galaxy AI / Bluetooth 5.3','ANC: Sim','Proteção: IPX48',1000,3),(7,'Samsung Galaxy Zfold 6 Cinza de 512GB e 12Gb de Ram - tela 6.7','\"O Samsung Galaxy Z Fold 6 é um smartphone dobrável avançado com uma tela principal de 7,6 polegadas e resolução de 2160x1856 pixels. Ele possui um processador Snapdragon 8 Gen 3, 12 GB de RAM e armazenamento interno de até 1 TB. O design fino e leve, com apenas 5,6 mm de espessura, torna o uso mais confortável. A câmera traseira de 50 MP e a câmera frontal interna com estabilizador óptico garantem fotos e vídeos de alta qualidade.',12857.00,'uploads/galaxyzfold6Cinza.png','Marca: Samsung','Modelo: Samsung Galaxy ZFold 6','Cor: Cinza','Memorias: 512Gb / 12 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,8 polegadas','Proteção: IPX48',1000,2),(8,'Samsung Galaxy M55 Azul de 128GB 8Gb de Ram - tela 6.7','O Samsung Galaxy M55 é um smartphone Android avançado com uma tela Super AMOLED de 6,7 polegadas e resolução Full HD+. Equipado com o processador Snapdragon 7 Gen 1, 8 GB de RAM e 256 GB de armazenamento interno, este dispositivo oferece desempenho rápido e eficiente. A câmera principal de 50 MP e a câmera frontal de 50 MP garantem fotos e vídeos de alta qualidade. Com bateria de 5000 mAh e carregamento rápido de 45W, o Galaxy M55 é ideal para uso diário e entretenimento.',2546.00,'uploads/galaxym55.png','Marca: Samsung','Modelo: Samsung Galaxy M55','Cor: Branco','Memorias: 256Gb / 8 Gb de Ram ','Tela:   Full HD Plus - Super Amoled Plus  ,de 6,7 polegadas','Proteção: IP67',1000,2),(9,'Samsung Odyssey G8 - OLED 24 polegadas - WQHD - (175Hz)','O Samsung Odyssey OLED G8 é um monitor gamer de 34 polegadas com painel OLED curvo. Ele oferece uma resolução Ultra-WQHD (3440x1440) e uma taxa de atualização de 175Hz2. Com um tempo de resposta de apenas 0,03ms, proporciona imagens nítidas e reações rápidas.',8678.00,'uploads/SamsungMOniG8Oled.png','Marca: Samsung','Modelo: Samsung Odyssey G8','Tela: Oled /  175Hz (120% DcpiP3) 3440 por 1400','Tecnologias: G-sync/ V-sync','Conectividade: Display port (2) / HDMI (2) / Ubs 3.0 (3)','Cor: Preto',1000,4),(10,'Dell XPS 13 Intel Core Ultra 7 - 13,4 polegadas - OLED 3K de Resolusão','dell XPS 13 O Dell XPS 13 é um laptop ultraleve e elegante, conhecido por seu design fino e desempenho robusto. Ele vem com várias opções de processador, incluindo o Intel Core Ultra 7 e o Qualcomm Snapdragon X Elite1. A tela de 13,4 polegadas pode ser configurada em FHD+ ou OLED. O XPS 13 também possui uma excelente duração de bateria e uma variedade de portas Thunderbolt 4',40907.00,'uploads/dellXPS13.png','Marca: Dell','Modelo: Dell XPS 13 ','Processador: Intel Core Ultra 7 172','Tela: 13,4 polegadas OLED (3K) touch Screen','Conectividade: Thunderbolt 4 (2)','Cor: Grafite',999,1),(11,'Samsung Odyssey G3 -  24 polegadas - Full HD, 180Hz','O Samsung Odyssey G3 é um monitor gamer de 27 polegadas que oferece uma experiência imersiva com seu design sem bordas em três lados. Conta com resolução Full HD (1920x1080), taxa de atualização de até 180Hz e tempo de resposta de 1ms (MPRT), ideal para jogos rápidos e dinâmicos. Possui também tecnologia AMD FreeSync para evitar cortes na imagem e modos que reduzem o cansaço visual.',4798.00,'uploads/SamsungMOniG3.png','Marca: Samsung','Modelo: Samsung Odyssey G3','Tela: Ips /  180(100% SRGB) Full HD','Tecnologias: G-sync/ V-sync / Freesync','Conectividade: Display port (2) / HDMI (2) / Ubs 3.0 (3)','Cor: Preto',1000,4),(12,'Asus Zenbook S14 Intel Core Ultra 7 - 3K OLED - 1Tb / 32Gb de Ram','faça doii asus zenbook s14 Claro! Aqui está uma descrição do Asus ZenBook S14:  O Asus ZenBook S14 é um notebook ultrabook de 14 polegadas com design elegante e ultrafino, feito de Ceraluminum, uma cerâmica de alta tecnologia que combina beleza e resistência. Ele possui uma tela OLED 2.8K de 120Hz, oferecendo visuais impressionantes e uma experiência visual rica.',8324.00,'uploads/asusS14.png','Marca: Asus','Modelo: Asus Zenbook S14','Processador: Intel Core Ultra 7','Memorias: 1Tb / 32Gb de Ram ','Tela:   3K OLED - 14 polegadas (100% do DciP3)','Cor: Banco',1000,1),(13,'Apple iPhone 16 Pro (256 GB / 8 GB Ram) Titânio natural','O iPhone 16 Pro Max Titânio Natural impressiona com sua estrutura leve e resistente em titânio. A tela Super Retina XDR de 6,9 polegadas oferece imagens vibrantes e nítidas, enquanto o chip A18 Pro garante desempenho excepcional em multitarefas e jogos. A câmera Pro Fusion de 48 MP captura fotos e vídeos de alta qualidade, com recursos avançados de fotografia noturna e estabilização óptica. Resistente à água e poeira (IP68), combina durabilidade, elegância e tecnologia de ponta em um só dispositivo. Ideal para quem busca sofisticação e performance.',6786.00,'uploads/iphone16promax.png','Marca: Apple','Modelo: iPhone 16 pro ','Cor: Titânio Natural','Memorias: 512Gb / 8 Gb de Ram ','Tela: 6.9 Super Retina XDR de 6,9 polegadas','Proteção: IP68 ',1000,2),(14,'Samsung Galaxy S23Ultra Titanio de 512GB e 12Gb de Ram - tela 6.8','O Samsung Galaxy S23 Ultra redefine a inovação com sua tela de 6,8 polegadas QHD+ Dynamic AMOLED 2X, oferecendo cores vibrantes e brilho impressionante. Equipado com o Snapdragon 8 Gen 2, garante desempenho ultrarrápido em qualquer tarefa, seja edição de vídeos ou jogos pesados2. A câmera principal de 200 MP, com zoom óptico de até 10x, captura detalhes incríveis. Resistente à água e poeira (IP68), o Galaxy S24 Ultra é ideal para aventuras ao ar livre3. Com a S Pen integrada e a Galaxy AI.',4675.00,'uploads/s23ultra.png','Marca: Samsung','Modelo: Samsung Galaxy S23 Ultra','Cor: Black ','Memorias: 512Gb / 12 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,8 polegadas','Proteção: IP68  / Span',1000,2),(15,'Samsung Galaxy S23 FE 6 Rose de 256GB e 8Gb de Ram - tela 6.6','uma descrição de 400 caractere O Samsung Galaxy S23 FE Rose é um smartphone esperado com alto desempenho e um design elegante. Ele deve contar com uma tela AMOLED dinâmica de alta resolução, proporcionando imagens vibrantes e nítidas. O dispositivo pode ser equipado com um processador avançado, garantindo uma experiência rápida e suave, além de um sistema de câmera versátil, ideal para fotos em diversas situações. A bateria de longa duração com capacidade de carregamento rápido mantém você conectado o dia todo.',2579.00,'uploads/s23feRose.png','Marca: Samsung','Modelo: Samsung Galaxy S23 FE','Cor: Rose','Memorias: 256Gb / 8 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,6 polegadas','Proteção: IP68 ',1000,2),(17,'QCY HT08 Pro Gold ANC - Bluetooth 5.3 IPX48  (drives de 12 MM)','QCY HT08 Pro Gold de 400 caractere O QCY HT08 Pro Gold é um fone de ouvido Bluetooth com cancelamento ativo de ruído (ANC), conectividade Bluetooth 5.3, e design sofisticado. Ele oferece som Hi-Res com graves profundos e agudos cristalinos, além de ser resistente à água (IPX5)',354.00,'uploads/qcyht08proGold.png','Marca: QCY','Modelo: QCY HT08 Pro','Cor: Gold','Tecnologias: Bluetooth 5.3','ANC: Sim','Proteção: IPX5',1000,3),(19,'Samsung Galaxy watch6 Classic IP68 / 5ATM - Eletro Cardiograma','O Samsung Galaxy Watch6 Classic combina design elegante e funções avançadas. Com uma tela Super AMOLED de 1,5 polegadas, oferece imagens nítidas. Possui monitoramento de saúde, incluindo ECG e frequência cardíaca, além de resistência à água IP68/5ATM. Conectividade Bluetooth 5.3, Wi-Fi e NFC completam as funcionalidades.',1564.00,'uploads/galaxywatch6Class.png','Marca: Samsung','Modelo: Samsung Galaxy watch6 Classic','Cor: Branco','Tecnologias: Samsung Saude / Bluetooth 5.3 / NFC / GPS','Tela Super AMOLED de 1,5 polegadas','Proteção: IP68 / 5ATM',1000,3),(20,'QCY HT08 Pro Branco ANC - Bluetooth 5.3 IPX48  (drives de 12 MM)','QCY HT08 Pro branco de 400 caractere O QCY HT08 Pro Gold é um fone de ouvido Bluetooth com cancelamento ativo de ruído (ANC), conectividade Bluetooth 5.3, e design sofisticado. Ele oferece som Hi-Res com graves profundos e agudos cristalinos, além de ser resistente à água (IPX5)',312.00,'uploads/qcyht08prowhite.png','Marca: QCY','Modelo: QCY HT08 Pro','Cor: Branco','Tecnologias: Bluetooth 5.3 /drives de 12 MM','ANC: Sim','Proteção: IPX48',999,3),(21,'SSD Externo de 1Tb da Sandisk Usb tipo c de alta performace - Para PC e Smartphones','SSD Externo de 1Tb da Sandisk de alta performace - Para PC e Smartphones, com um velocidade de leitura de 7000 Mbs e de Gravação 6500 Mbs',535.00,'uploads/ssdExterno.png','Marca: Sandisk','Modelo: top 1','Cor: azul','Capacidade: 1Tb','Conectividade: Usb tipo c','Material: Metal',1000,5),(22,'Ssd nvme da Kingston de 1tb O SSD Kingston NV2 de 1TB','ssd nvme da Kingston de 1tb O SSD Kingston NV2 de 1TB é uma excelente escolha para quem busca um armazenamento rápido e eficiente. Ele oferece velocidades de leitura de até 3.500 MB/s e velocidades de escrita de até 2.100 MB/s, proporcionando um desempenho superior para tarefas como inicialização rápida do sistema operacional, carregamento de jogos e edição de vídeos.',456.00,'uploads/ssd.png','Marca: Kingston','Modelo:Kingston ','Tipo: Nvme Nv2 ','Memoria: 1TB Leitura de até 3.500 MB/s - escrita de até 2.100 MB/s.','Cor: azul','ssd: para alta veloicidade ',1000,5),(23,'Call of Duty Modern Warfare PS4 Call of Duty: Modern Warfare for PS4 is a thrilling ','Call of Duty Modern Warfare PS4 Call of Duty: Modern Warfare for PS4 is a thrilling first-person shooter game developed by Infinity Ward. It was released on October 25, 20191. The game offers a visceral single-player campaign, intense multiplayer modes, and special operations',234.00,'uploads/callMW.png','> Jogabilidade Imersiva: Multijogador Competitivo','Modelo: Call of Duty','> Realismo Gráfico','> Personalização de Armas','> Operações Especiais','> Atualizações Frequentes',1000,6),(24,'Apple iPhone 16 (256 GB / 8 GB Ram) Rosa-Apple tela 60hzt','O iPhone 16 Rose impressiona com sua estrutura leve e resistente em titânio. A tela Super Retina XDR de 6,9 polegadas oferece imagens vibrantes e nítidas, enquanto o chip A18 Pro garante desempenho excepcional em multitarefas e jogos. A câmera Pro Fusion de 48 MP captura fotos e vídeos de alta qualidade, com recursos avançados de fotografia noturna e estabilização óptica. Resistente à água e poeira (IP68), combina durabilidade, elegância e tecnologia de ponta em um só dispositivo. Ideal para quem busca sofisticação e performance.',6578.00,'uploads/iphone16Roes.png','Marca: Apple','Modelo: iPhone 16 ','Cor: ROSA','Memorias: 256Gb / 8 Gb de Ram ','Tela: Super Retina XDR de 6,9 polegadas','Proteção: IP68 ',1000,2),(25,'Samsung Galaxy S23   Rose de 256GB e 8Gb de Ram - tela 6.6','O Samsung Galaxy S23  redefine a inovação com sua tela de 6,8 polegadas QHD+ Dynamic AMOLED 2X, oferecendo cores vibrantes e brilho impressionante. Equipado com o Snapdragon 8 Gen 2, garante desempenho ultrarrápido em qualquer tarefa, seja edição de vídeos ou jogos pesados2. A câmera principal de 200 MP, com zoom óptico de até 10x, captura detalhes incríveis. Resistente à água e poeira (IP68), o Galaxy S24 Ultra é ideal para aventuras ao ar livre3. Com a S Pen integrada e a Galaxy AI.',3264.00,'uploads/galaxys23Rose.png','Marca: samsung','Modelo: Samsung Galaxy S23','Cor: Rosa','Memorias: 256Gb / 8 Gb de Ram ','Tela:   QHD+ Dynamic AMOLED 2X ,de 6,4 polegadas','Proteção: IP68 ',1000,2),(28,'Asus Zenbook S14  Snapdragon X Elite com  1Tb / 32Gb de Ram  Prata','O Asus ZenBook S14 é um notebook ultrabook de 14 polegadas com design elegante e ultrafino, feito de Ceraluminum, uma cerâmica de alta tecnologia que combina beleza e resistência. Ele possui uma tela OLED 2.8K de 120Hz, oferecendo visuais impressionantes e uma experiência visual rica.',9243.00,'uploads/asusS14.png','Marca: Asus','Modelo: Asus Zenbook S14 ','Cor: Prata ','Memorias: 1Tb / 32Gb de Ram ','Tela: Oled (100% DciP3) - 120Htz  de 14 Polegadasd','Hardawe: Snapdragon X Elite - Copilot+PC',1000,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger trg_audit_item
	after update on item
	for each row
	begin 
		if old.preco != new.preco then 
			insert into auditoria_item(item_id, data, preco_antigo, preco_novo, motivo)
			values(old.id_item, now(), old.preco, new.preco, 'Alteracao de preco');
		end if;
	end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_pedido` (
  `item_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  PRIMARY KEY (`item_id`,`pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `item_pedido_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id_item`),
  CONSTRAINT `item_pedido_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (19,3),(20,1),(20,4),(24,2);
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger att_estoque_produto
	before insert on item_pedido
	for each row 
	begin 
	    UPDATE item
	    SET estoque = estoque - 1
	    WHERE id_item = NEW.item_id;
	end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double DEFAULT NULL,
  `data_pedido` date DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,312,'2024-12-04','Concluído',1),(2,6578,'2024-12-04','Concluído',1),(3,1564,'2024-12-04','Concluído',1),(4,312,'2024-12-05','Concluído',1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'lucas carvalho pedrozo','lucaspedroozoo@hotmail.com','12345678','2024-12-04',NULL),(2,'Usuario_43','usuario943@exemplo.com','senha5845','2023-12-26',1),(3,'Usuario_318','usuario428@exemplo.com','senha1832','2018-08-05',1);
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
/*!50003 DROP PROCEDURE IF EXISTS `consultaPedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultaPedido`(in produto_idItem int)
begin 
		select u.nome, p.id_pedido, p.valor, i.nome, p.status from pedido p
		join usuario u on u.id_usuario = p.usuario_id
		join item_pedido ip on ip.pedido_id = p.id_pedido
		join item i on i.id_item = ip.item_id
		where p.id_pedido = produto_idItem;
	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `injecao_de_usuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `injecao_de_usuarios`(IN qtd_insert INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE nome_usuario VARCHAR(100);
    DECLARE email_usuario VARCHAR(100);
    DECLARE senha_usuario VARCHAR(100);
    DECLARE data_usuario DATE;
    DECLARE admin_usuario TINYINT;

    WHILE i <= qtd_insert DO  

        SET nome_usuario = CONCAT('Usuario_', FLOOR(1 + RAND() * 1000));	
        SET email_usuario = CONCAT('usuario', FLOOR(1 + RAND() * 1000), '@exemplo.com');
        SET senha_usuario = CONCAT('senha', FLOOR(1 + RAND() * 10000));
        SET data_usuario = DATE_ADD(CURDATE(), INTERVAL -FLOOR(RAND() * 3650) DAY); -- Gera uma data nos últimos 10 anos
        SET admin_usuario = FLOOR(RAND() * 2); -- Gera 0 ou 1 aleatoriamente

        INSERT INTO usuario (nome, email, senha, data, admin)
        VALUES (nome_usuario, email_usuario, senha_usuario, data_usuario, admin_usuario);

        SET i = i + 1;
    END WHILE;
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

-- Dump completed on 2024-12-05 19:36:30
