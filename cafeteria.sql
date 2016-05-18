-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2016 a las 10:13:31
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cafeteria`
--
CREATE DATABASE IF NOT EXISTS `cafeteria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cafeteria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
`id` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idOrden` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id`, `idMenu`, `idOrden`) VALUES
(31, 1, 20),
(43, 1, 22),
(34, 4, 21),
(53, 5, 24),
(57, 7, 25),
(48, 8, 23),
(36, 10, 21),
(58, 10, 25),
(33, 12, 20),
(47, 12, 22),
(35, 14, 21),
(32, 15, 20),
(45, 15, 22),
(54, 15, 24),
(44, 16, 22),
(37, 17, 21),
(46, 17, 22),
(38, 27, 21),
(39, 28, 21),
(40, 38, 21),
(41, 42, 21),
(55, 43, 24),
(42, 52, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
`id` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `clasificacion` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `nombre`, `clasificacion`, `precio`) VALUES
(1, 'Espresso', 'Cafés', 20),
(2, 'Americano', 'Cafés', 18),
(3, 'Frapuccino', 'Frappés', 30),
(4, 'Botella de Agua', 'Bebidas', 12),
(5, 'Americano con nieve', 'Cafés', 25),
(6, 'Capuccino', 'Cafés', 33),
(7, 'Mocachino', 'Cafés', 33),
(8, 'Moca', 'Cafés', 28),
(9, 'Moca blanco', 'Cafés', 30),
(10, 'Latte', 'Cafés', 30),
(11, 'Moca', 'Frappés', 30),
(12, 'Moca blanco', 'Frappés', 32),
(13, 'Chai', 'Frappés', 24),
(14, 'Latte', 'Frappés', 25),
(15, 'Cookies and Cream', 'Frappés', 38),
(16, 'Funky Monkey', 'Frappés', 28),
(17, 'Moca Cherry', 'Frappés', 35),
(18, 'Kongo(menta y chocolate)', 'Frappés', 28),
(19, 'Smoothies(con crema batida)', 'Smoothies', 45),
(20, 'Smoothies(con nieve de vainilla)', 'Smoothies', 50),
(21, 'Mezcla de moras', 'Smoothies', 46),
(22, 'Piña Colada', 'Smoothies', 48),
(23, 'Durazno', 'Smoothies', 40),
(24, 'Plátano', 'Smoothies', 48),
(25, 'Mango', 'Smoothies', 40),
(26, 'Fresa', 'Smoothies', 48),
(27, 'Piña', 'Smoothies', 43),
(28, 'Té Verde', 'Smoothies', 30),
(29, 'Té Verde con moras', 'Smoothies', 32),
(30, 'Manzana con canela', 'Tés', 32),
(31, 'Mango', 'Tés', 32),
(32, 'Manzanilla', 'Tés', 28),
(33, 'Té negro', 'Tés', 30),
(34, 'Canela', 'Tés', 30),
(35, 'Naranja', 'Tés', 30),
(36, 'Té verde', 'Tés', 28),
(37, 'Hierbabuena', 'Tés', 30),
(38, 'Té chai', 'Tés', 28),
(39, 'Cereza', 'Tés', 25),
(40, 'Té de limón', 'Tés', 28),
(41, 'Fresa', 'Malteadas', 38),
(42, 'Plátano', 'Malteadas', 38),
(43, 'Durazno', 'Malteadas', 38),
(44, 'Mango', 'Malteadas', 38),
(45, 'Piña', 'Malteadas', 38),
(46, 'Piña Colada', 'Malteadas', 38),
(47, 'Chocolate', 'Malteadas', 38),
(48, 'Galleta Óreo', 'Malteadas', 38),
(49, 'Soda', 'Bebidas', 15),
(50, 'Agua mineral', 'Bebidas', 15),
(51, 'Aguas Naturales(Horchata, Jamaica, Limonada, Naranjada)', 'Bebidas', 14),
(52, 'Zafari(cajeta y nieve)', 'Especialidades', 40),
(53, 'Milano(amareto y vainilla)', 'Especialidades', 40),
(54, 'Malba(frambuesa y vainilla)', 'Especialidades', 40),
(55, 'Napolitano (fresa, vainilla y chocolate)', 'Especialidades', 40),
(56, 'Kikongo (chocolate y coco)', 'Especialidades', 40),
(57, 'Moca marfil', 'Especialidades', 40),
(58, 'ZAFARI(pollo,jamon,cebolla en salsa de cilantro)', 'Crepas', 42),
(59, 'ZAMBIA(cajeta con nuez y moras en salsa de cajeta)', 'Crepas', 45),
(60, 'MALAWI(jamon con queso)', 'Crepas', 42),
(61, 'KILONGO(nutella con nuez)', 'Crepas', 42),
(62, 'AFRICA(nutella,nuez, plátano en salsa de chocolate)', 'Crepas', 45),
(63, 'MOCABANANA(platano con chocolate)', 'Crepas', 42),
(64, 'KENYA(platano, fresa y queso philadelphia)', 'Crepas', 42),
(65, 'FRUTONGO(fresa,plátano,durazno y mango)', 'Crepas', 45),
(66, 'César', 'Ensaladas', 30),
(67, 'Frutal', 'Ensaladas', 28),
(68, 'Griega', 'Ensaladas', 29),
(69, 'Rusa', 'Ensaladas', 28),
(70, 'Campera', 'Ensaladas', 30),
(71, 'Waldorf', 'Ensaladas', 30),
(72, 'Croissant (atún o jamón)', 'Botanas', 15),
(73, 'Croissant dulce', 'Botanas', 15),
(74, 'Sandwich (atún o jamón)', 'Botanas', 25),
(75, 'Papas a la francesa', 'Botanas', 25),
(76, 'Nachos con queso', 'Botanas', 25),
(77, 'Nachos con carne', 'Botanas', 30),
(78, 'Chocoflan', 'Postres', 20),
(79, 'Paster de chocolate', 'Postres', 20),
(80, 'Pay de queso', 'Postres', 20),
(81, 'Pay de Manzana', 'Postres', 20),
(82, 'Pay de limón', 'Postres', 20),
(83, 'Hojaldras', 'Postres', 15),
(84, 'Merengue', 'Postres', 15),
(85, 'Gelatinas (fresa, uva, limón o piña)', 'Postres', 15),
(86, 'Gelatina mosaico', 'Postres', 20),
(87, 'Helado (chocolate, vainilla, bubulubu, limón, zarzamora con queso o coco)', 'Postres', 20),
(88, 'Flan napolitano', 'Postres', 20),
(89, 'Besitos', 'Postres', 10),
(90, 'Cremitas', 'Postres', 15),
(91, 'Nutella', 'Ingredientes dulces', 5),
(92, 'Nuez', 'Ingredientes dulces', 5),
(93, 'Mermelada de moras', 'Ingredientes dulces', 5),
(94, 'Mermelada de blueberry', 'Ingredientes dulces', 5),
(95, 'Fresa', 'Ingredientes dulces', 5),
(96, 'Crema de cacahuate', 'Ingredientes dulces', 5),
(97, 'Plátano', 'Ingredientes dulces', 5),
(98, 'Cajeta', 'Ingredientes dulces', 5),
(99, 'Jamón', 'Ingredientes Salados', 5),
(100, 'Pollo', 'Ingredientes Salados', 5),
(101, 'Atún', 'Ingredientes Salados', 5),
(102, 'Camarón', 'Ingredientes Salados', 5),
(103, 'Queso', 'Ingredientes Salados', 5),
(104, 'Philadelphia', 'Ingredientes Salados', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE IF NOT EXISTS `orden` (
`id` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `estado` varchar(20) NOT NULL,
  `precioTotal` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`id`, `fechaCompra`, `estado`, `precioTotal`) VALUES
(20, '2016-05-18', 'PAGADO', 90),
(21, '2016-05-18', 'CANCELADO', 281),
(22, '2016-05-18', 'PAGADA', 153),
(23, '2016-05-18', 'PAGADA', 28),
(24, '2016-05-18', 'PAGADA', 101),
(25, '2016-05-18', 'CANCELADA', 63);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
 ADD PRIMARY KEY (`id`), ADD KEY `idMenu` (`idMenu`,`idOrden`), ADD KEY `idMenu_2` (`idMenu`), ADD KEY `idOrden` (`idOrden`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=105;
--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`idOrden`) REFERENCES `orden` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
