-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2023 a las 15:25:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemaventa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `dni` int(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `dni`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(2, 12, 'fe', 12, 'ca', 'ni', '2023-12-03 03:16:51'),
(5, 123, 'felipe', 243242, 'lima', 'ninguna', '2023-12-03 04:27:19'),
(6, 2345, 'gonza', 2342, 'lim', 'ningun', '2023-12-03 04:31:04'),
(8, 12, 'felwsd', 123, 'cal', 'ning', '2023-12-03 04:58:53'),
(9, 2345234, 'gonzalo', 234234, 'lima', 'ninguna', '2023-12-03 04:58:57'),
(10, 3452, 'dfgbd', 234, 'drg', 'erg', '2023-12-03 05:18:07'),
(11, 12345, 'principe', 234, 'dfvdf', 'dfs', '2023-12-03 09:09:04'),
(12, 234, 'sfsdf', 3445, 'wsrfw', 'wfwf', '2023-12-03 21:46:35'),
(13, 2345234, 'edfgd', 3453, 'dfgd', 'dgferg', '2023-12-15 09:14:47'),
(14, 234234, 'felip\'eeeeeee', 124234, 'sdfsdf', 'sfwef', '2023-12-15 09:14:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `cod_pro` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `local`
--

CREATE TABLE `local` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `ruc` varchar(20) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id` int(11) NOT NULL,
  `codigo` int(200) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `sexo` varchar(100) NOT NULL,
  `stock` int(200) NOT NULL,
  `tamaño` int(200) NOT NULL,
  `peso` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `nombre`, `proveedor`, `stock`, `precio`, `fecha`) VALUES
(2, '234', 'degf', 'ddfvsd', 2, 23.00, '2023-12-03 09:56:56'),
(3, '12', 'nueva', 'ddfvsd', 1, 12.00, '2023-12-03 09:57:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `ruc` int(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `razon` varchar(200) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `ruc`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(3, 242423, 'sfsvdf', 45345, 'sdfbfvgb', 'sfsff', '2023-12-03 06:51:12'),
(4, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:32'),
(5, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:33'),
(6, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:34'),
(7, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:35'),
(8, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:35'),
(9, 2424, 'sfsv', 345, 'sdfbf', 'sff', '2023-12-03 06:51:35'),
(11, 23, 'sfs', 24, 'sfsf', 'sff', '2023-12-03 07:12:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`) VALUES
(1, 'felipe', 'felipe@gmail.com', '123'),
(2, 'carlos', 'carlos@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `vendedor` varchar(100) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `local`
--
ALTER TABLE `local`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
