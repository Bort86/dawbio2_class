-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2019 a las 16:19:01
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--
DROP DATABASE IF EXISTS `hospital`;
CREATE DATABASE IF NOT EXISTS `hospital` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `hospital`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctores`
--

CREATE TABLE `doctores` (
  `idDoctor` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nom` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `especialitat` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `doctores`
--

INSERT INTO `doctores` (`idDoctor`, `nom`, `especialitat`) VALUES
('doc1', 'Luis Gonzalez', 'general'),
('doc2', 'isabel esteban', 'general'),
('doc3', 'Anna Serra', 'cardiologia'),
('doc4', 'Lluc Sales', 'cardiologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `idPaciente` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nom` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `cognoms` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `edat` int(11) NOT NULL,
  `idDoctor` varchar(9) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`idPaciente`, `nom`, `cognoms`, `edat`, `idDoctor`) VALUES
('111', 'Joan', 'Subirats Danur', 18, 'doc1'),
('222', 'Sara', 'Espinosa Saran', 43, 'doc1'),
('333', 'Iliana', 'Gonsales Martin', 25, 'doc3'),
('444', 'Raimundo', 'Amador Gozalo', 56, 'doc4'),
('555', 'Lara', 'Croft Ryder', 23, 'doc2'),
('666', 'Leonardo', 'Da Vinci Records', 89, 'doc4'),
('777', 'Alejandro', 'Torrente Vallester', 40, 'doc4'),
('888', 'Laia', 'Rialta Perez', 37, 'doc1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`idPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
