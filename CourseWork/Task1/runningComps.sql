DROP DATABASE IF EXISTS runningcomps;
CREATE DATABASE IF NOT EXISTS runningcomps DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE runningcomps;

DROP TABLE IF EXISTS RUNNINGCOMP;
CREATE TABLE IF NOT EXISTS RUNNINGCOMP (
  RUNNINGCOMPID int(11) NOT NULL AUTO_INCREMENT,
  SEASON varchar(8) NOT NULL,
  COMPETITION varchar(30) NOT NULL,
  VENUE varchar(30) NOT NULL,
  RANK int(1),
  PRIMARY KEY (RUNNINGCOMPID)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

INSERT INTO RUNNINGCOMP (RUNNINGCOMPID, SEASON, COMPETITION, VENUE, RANK) VALUES
(24, '2023', 'Berlin Marathon', 'Berlin, Germany', 4),
(22, '2023', 'London Marathon', 'London, UK', 2),
(21, '2023', 'Boston Marathon', 'Boston, USA', 1),
(26, '2023', 'Tokyo Marathon', 'Tokyo, Japan', 6),
(25, '2023', 'Chicago Marathon', 'Chicago, USA', 5);

DROP TABLE IF EXISTS RUNNER;
CREATE TABLE IF NOT EXISTS RUNNER (
  RUNNERID int(11) NOT NULL AUTO_INCREMENT,
  RUNNERNUMBER int NOT NULL,
  RUNNERNAME varchar(30) NOT NULL,
  RUNNINGCOMPID int(11) NOT NULL,
  GENDER varchar(1) NOT NULL,
  PRIMARY KEY (RUNNERID)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

INSERT INTO RUNNER (RUNNERID, RUNNERNUMBER, RUNNERNAME, GENDER, RUNNINGCOMPID) VALUES
(1,24,"Fiona O'KEEFFE","F",21),
(2,143,"Atalel ANMUT","F",21),
(3,66,"Addisu GOBENA","M",24),
(4,26,"Morhad AMDOUNI","M",22),
(5,144,"Melat Yisak KEJETA","F",25),
(6,71,"Tigist KETEMA","F",26),
(7,120,"Antenayeh DAGNACHEW","M",22),
(8,80,"Shitaye ESHETE","F",25),
(9,82,"Josephine CHEPKOECH","F",25),
(10,38,"Vicoty CHEPNGENO","F",26),
(11,11,"Honami MAEDA","F",22),
(12,132,"Gashau AYALE","M",22),
(13,59,"Abdi FUFA","M",24),
(14,148,"Azmera GEBRU","F",26),
(15,18,"Zouhair TALBI","M",21),
(16,146,"Lemi DUMECHA","M",24),
(17,144,"Ghirmay GHEBRESLASSIE","M",22),
(18,33,"Emily SISSON","F",22),
(19,40,"Workenesh EDESA","F",25),
(20,135,"Deresa GELETA","M",26),
(21,16,"Ruti AGA","F",24),
(22,27,"Asefa BOKI","M",21),
(23,125,"Rahma TUSA","F",24),
(24,108,"Yemaneberhan CRIPPA","M",25),
(25,19,"Dera DIDA","F",26),
(26,130,"Amid Fozya JEMAL","F",26),
(27,50,"Felix KIRWA","M",26),
(28,69,"Samuel FITWI SIBHATU","M",26),
(29,79,"Dejane MEGERSA","M",22),
(30,11,"Tafese DELELEGN","M",25);

ALTER TABLE RUNNER
  ADD CONSTRAINT RUNNER_ibfk_1 FOREIGN KEY (RUNNINGCOMPID) REFERENCES RUNNINGCOMP (RUNNINGCOMPID);
  
DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `AddRunningComp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddRunningComp` (IN `inSeason` TEXT, IN `inCompetition` TEXT, IN `inVenue` TEXT, IN `inRank` INT)  BEGIN
 INSERT INTO RUNNINGCOMP (SEASON, COMPETITION, VENUE, RANK)
        VALUES (inSeason, inCompetition, inVenue, inRank);
END$$

DROP PROCEDURE IF EXISTS `AddRunner`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddRunner` (IN `inRunnerNumber` TEXT, IN `inRunnerName` TEXT, IN `inGender` VARCHAR(1), IN `inRunningCompId` INT)  BEGIN
 INSERT INTO RUNNER (RUNNERNUMBER, RUNNERNAME, GENDER, RUNNINGCOMPID)
        VALUES (inRunnerNumber, inRunnerName, inGender, inRunningCompId);
END$$

DROP PROCEDURE IF EXISTS `GetRunningComp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRunnerComp` (IN `inRunningCompId` INT)  BEGIN
 SELECT *
 FROM     RUNNINGCOMP
 WHERE  RUNNINGCOMPID = inRunningCompId ;
END$$

DROP PROCEDURE IF EXISTS `GetRunningComps`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRunnerComps` ()  READS SQL DATA
BEGIN
  Select RUNNINGCOMPID, SEASON, COMPETITION, VENUE, RANK From RUNNINGCOMP Order By RUNNINGCOMPID;
END$$

DROP PROCEDURE IF EXISTS `GetRunningCompRunners`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetRunningCompRunners` (IN `inRunningCompId` INT)  NO SQL
BEGIN
  SELECT RUNNERID, RUNNERNUMBER, RUNNERNAME, GENDER FROM RUNNER
  WHERE RUNNINGCOMPID = inRunningCompId
  Order By RUNNERNUMBER;
End$$

DELIMITER ;  

