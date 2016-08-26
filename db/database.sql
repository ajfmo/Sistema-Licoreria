-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-08-2016 a las 17:22:19
-- Versión del servidor: 5.6.26-log
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sil`
--
CREATE DATABASE IF NOT EXISTS `sil` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sil`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `NombreEmpleado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena los datos de los empleados.';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE `gastos` (
  `idGasto` int(11) NOT NULL,
  `fechaGasto` date NOT NULL,
  `facturaGasto` int(11) NOT NULL,
  `descripcionGasto` varchar(45) NOT NULL,
  `montoGasto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licorerias`
--

CREATE TABLE `licorerias` (
  `idLicoreria` int(10) UNSIGNED NOT NULL,
  `nombreLicoreria` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `licorerias`
--

INSERT INTO `licorerias` (`idLicoreria`, `nombreLicoreria`) VALUES
(27, 'Altos de Jalisco'),
(16, 'El Mojan'),
(18, 'La 12'),
(10, 'Limazuca'),
(28, 'Mi negrito'),
(22, 'Milagro Norte'),
(17, 'Santa Lucia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `idMovimientos` int(11) NOT NULL,
  `codLicoreria` int(11) NOT NULL,
  `fechaInicial` date NOT NULL,
  `fechaFinal` date NOT NULL,
  `descripcionProducto` varchar(45) NOT NULL,
  `inventarioAnterior` int(11) NOT NULL,
  `entrada` int(11) NOT NULL,
  `salida` int(11) NOT NULL,
  `inventarioEntrante` int(11) NOT NULL,
  `existencia` int(11) NOT NULL,
  `diferencia` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `Ztotal` int(11) NOT NULL,
  `tipoProducto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `codProducto` varchar(45) NOT NULL,
  `descripcionProducto` varchar(45) NOT NULL,
  `tipoProducto` varchar(45) NOT NULL,
  `existenciaProducto` int(11) DEFAULT NULL,
  `costoProducto` int(11) DEFAULT NULL,
  `precioProducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `codProducto`, `descripcionProducto`, `tipoProducto`, `existenciaProducto`, `costoProducto`, `precioProducto`) VALUES
(3, 'CC-Zulia', 'Caja de Cerveza Zulia', 'Cervezas', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproductos`
--

CREATE TABLE `tipoproductos` (
  `idTipo` int(11) NOT NULL,
  `descripcionTipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoproductos`
--

INSERT INTO `tipoproductos` (`idTipo`, `descripcionTipo`) VALUES
(1, 'Cervezas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuarios` int(11) NOT NULL,
  `nombreUsuarios` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `clave` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuarios`, `nombreUsuarios`, `login`, `clave`) VALUES
(1, 'Adrian', 'admin', 0x32333734),
(2, 'Ventas', 'Ventas', 0x32333734),
(3, 'Gerencia', 'Gerencia', 0x32333734),
(4, 'caja', 'caja', 0x32333734);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`idGasto`);

--
-- Indices de la tabla `licorerias`
--
ALTER TABLE `licorerias`
  ADD PRIMARY KEY (`idLicoreria`),
  ADD UNIQUE KEY `nombreLicoreria_UNIQUE` (`nombreLicoreria`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`idMovimientos`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD UNIQUE KEY `tipoProd_idx` (`tipoProducto`);

--
-- Indices de la tabla `tipoproductos`
--
ALTER TABLE `tipoproductos`
  ADD PRIMARY KEY (`idTipo`),
  ADD UNIQUE KEY `tipoProd_idx` (`descripcionTipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuarios`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `licorerias`
--
ALTER TABLE `licorerias`
  MODIFY `idLicoreria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `idMovimientos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipoproductos`
--
ALTER TABLE `tipoproductos`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `tipoProd_fk` FOREIGN KEY (`tipoProducto`) REFERENCES `tipoproductos` (`descripcionTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
