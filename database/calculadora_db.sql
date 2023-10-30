-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 23:25:08
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `calculadora_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operaciones`
--

CREATE TABLE `operaciones` (
  `id` int(11) NOT NULL,
  `operacion` varchar(255) DEFAULT NULL,
  `resultado` double DEFAULT NULL,
  `fechahora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `operaciones`
--

INSERT INTO `operaciones` (`id`, `operacion`, `resultado`, `fechahora`) VALUES
(1, '3-6', -3, '2023-10-29 21:26:12'),
(2, '7/9*6-3+0', 1.666666666666667, '2023-10-29 21:53:59'),
(3, '50)atanr(57atanr((!cosr(sen(7//sqrt%sqrt%', 105684.40585973195, '2023-10-29 22:06:16');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `operaciones`
--
ALTER TABLE `operaciones`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `operaciones`
--
ALTER TABLE `operaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
