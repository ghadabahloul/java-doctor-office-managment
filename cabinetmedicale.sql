-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2015 at 03:24 AM
-- Server version: 5.5.37-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cabinetmedicale`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

CREATE TABLE IF NOT EXISTS `consultation` (
  `codeConsultation` int(11) NOT NULL AUTO_INCREMENT,
  `dateConsultation` timestamp NULL DEFAULT NULL,
  `motif` varchar(45) DEFAULT NULL,
  `resultExamClinique` varchar(45) DEFAULT NULL,
  `diagnostic` varchar(45) DEFAULT NULL,
  `traitementPatient` varchar(45) DEFAULT NULL,
  `resultExamParaclinique` varchar(45) DEFAULT NULL,
  `codeRDV` int(11) DEFAULT NULL,
  `codePatient` int(11) DEFAULT NULL,
  `idEtab` int(11) DEFAULT NULL,
  PRIMARY KEY (`codeConsultation`),
  KEY `fk_consultation_1_idx` (`idEtab`),
  KEY `fk_consultation_2_idx` (`codePatient`),
  KEY `fk_consultation_3_idx` (`codeRDV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `etablissement`
--

CREATE TABLE IF NOT EXISTS `etablissement` (
  `idEtab` int(11) NOT NULL AUTO_INCREMENT,
  `nomEtab` varchar(45) DEFAULT NULL,
  `adresseEtab` varchar(45) DEFAULT NULL,
  `telEtab` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEtab`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `etablissement`
--

INSERT INTO `etablissement` (`idEtab`, `nomEtab`, `adresseEtab`, `telEtab`) VALUES
(1, 'etab1', 'sousse', '73333333'),
(2, 'etab2', 'sousse', '21585642'),
(3, 'etab0', 'sousse', '21564852');

-- --------------------------------------------------------

--
-- Table structure for table `medecin`
--

CREATE TABLE IF NOT EXISTS `medecin` (
  `idMedecin` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nomMedecin` varchar(45) DEFAULT NULL,
  `prenomMedecin` varchar(45) DEFAULT NULL,
  `specialite` varchar(45) DEFAULT NULL,
  `telMedecin` int(11) DEFAULT NULL,
  `idEtab` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMedecin`),
  KEY `fk_medecin_1_idx` (`idEtab`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `medecin`
--

INSERT INTO `medecin` (`idMedecin`, `login`, `password`, `nomMedecin`, `prenomMedecin`, `specialite`, `telMedecin`, `idEtab`) VALUES
(11, 'ghada', 'ghada', 'bahloul', 'ghada', 'medecin general', 23831077, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Ordonnance`
--

CREATE TABLE IF NOT EXISTS `Ordonnance` (
  `codeOrdonnance` int(11) NOT NULL AUTO_INCREMENT,
  `dateOrdonnance` date DEFAULT NULL,
  `contenuOrdonnance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codeOrdonnance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `codePatient` int(11) NOT NULL AUTO_INCREMENT,
  `nomPatient` varchar(45) DEFAULT NULL,
  `prenomPatient` varchar(45) DEFAULT NULL,
  `dateNaissance` timestamp NULL DEFAULT NULL,
  `telPatient` int(11) DEFAULT NULL,
  `Sexe` varchar(45) DEFAULT NULL,
  `situationFamiliale` varchar(45) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `assure` tinyint(1) DEFAULT NULL,
  `adressePatient` varchar(45) DEFAULT NULL,
  `idMedecin` int(11) DEFAULT NULL,
  PRIMARY KEY (`codePatient`),
  KEY `fk_patient_1_idx` (`idMedecin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`codePatient`, `nomPatient`, `prenomPatient`, `dateNaissance`, `telPatient`, `Sexe`, `situationFamiliale`, `profession`, `assure`, `adressePatient`, `idMedecin`) VALUES
(8, 'bahloul', 'maha', '1999-12-11 23:00:00', 21369258, 'Féminin', 'Célibataire', 'etudiante', 1, 'msaken', 11);

-- --------------------------------------------------------

--
-- Table structure for table `rdv`
--

CREATE TABLE IF NOT EXISTS `rdv` (
  `codeRDV` int(11) NOT NULL AUTO_INCREMENT,
  `numRDV` int(11) DEFAULT NULL,
  `dateRDV` timestamp NULL DEFAULT NULL,
  `idEtab` int(11) DEFAULT NULL,
  `codePatient` int(11) DEFAULT NULL,
  `idMedecin` int(11) DEFAULT NULL,
  PRIMARY KEY (`codeRDV`),
  KEY `fk_rdv_1_idx` (`codePatient`),
  KEY `fk_rdv_2_idx` (`idMedecin`),
  KEY `fk_rdv_3_idx` (`idEtab`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `fk_consultation_1` FOREIGN KEY (`idEtab`) REFERENCES `etablissement` (`idEtab`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_consultation_2` FOREIGN KEY (`codePatient`) REFERENCES `patient` (`codePatient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_consultation_3` FOREIGN KEY (`codeRDV`) REFERENCES `rdv` (`codeRDV`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_medecin_1` FOREIGN KEY (`idEtab`) REFERENCES `etablissement` (`idEtab`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `fk_patient_1` FOREIGN KEY (`idMedecin`) REFERENCES `medecin` (`idMedecin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `fk_rdv_1` FOREIGN KEY (`codePatient`) REFERENCES `patient` (`codePatient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rdv_2` FOREIGN KEY (`idMedecin`) REFERENCES `medecin` (`idMedecin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rdv_3` FOREIGN KEY (`idEtab`) REFERENCES `etablissement` (`idEtab`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
