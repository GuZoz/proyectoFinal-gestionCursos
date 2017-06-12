-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para gestion_cursos
DROP DATABASE IF EXISTS `gestion_cursos`;
CREATE DATABASE IF NOT EXISTS `gestion_cursos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gestion_cursos`;

-- Volcando estructura para tabla gestion_cursos.curso
DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_curso` varchar(255) NOT NULL DEFAULT 'NomCurso a insertar',
  `cod_curso` varchar(50) NOT NULL DEFAULT 'CodCurso a insertar',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla gestion_cursos.curso: 10 rows
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
REPLACE INTO `curso` (`id`, `nom_curso`, `cod_curso`) VALUES
	(1, 'PROGRAMACIÓN PARA PDAs', 'EMIN3004'),
	(2, 'SEGURIDAD DE LA INFORMACIÓN', 'ER523'),
	(3, 'GESTIÓN Y DESARROLLO DE APLICACIONES WIRELESS', 'CI03'),
	(4, 'SMS 2003', 'CI04'),
	(5, 'INTRODUCCIÓN A VISUAL BASIC .NET', 'CI05'),
	(6, 'GESTIÓN DE SISTEMAS CON PATROL', 'CI06'),
	(7, 'TÉCNICAS DE DESARROLLO ESTRUCTURADO', 'CI07'),
	(8, 'UML – TÉCNICAS DE DESARROLLO ORIENTADAS A OBJETOS', 'CI08'),
	(9, 'GESTIÓN DE PROYECTOS. ESTIMACIÓN MEDIANTE PUNTOS DE FUNCIÓN', 'CI09'),
	(10, 'MICROSOFT WINDOWS MILLENIUM', 'IU105'),
	(11, 'WINDOWS NT 4.0: WORKSTATION: USUARIO', 'IU106'),
	(12, 'WINDOWS 2000 PROFESSIONAL: USUARIO', 'IU107'),
	(13, 'MICROSOFT WORD 97: INICIACIÓN', 'IU200'),
	(14, 'MICROSOFT WORD 97: AVANZADO', 'IU201'),
	(15, 'MICROSOFT WORD 2000: INICIACIÓN', 'IU202');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
