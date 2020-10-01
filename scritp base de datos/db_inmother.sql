/*
Navicat MySQL Data Transfer

Source Server         : Server_Mysql
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : db_inmother

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-09-30 09:21:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for arrendatarios
-- ----------------------------
DROP TABLE IF EXISTS `arrendatarios`;
CREATE TABLE `arrendatarios` (
  `codigo_arrendatario` int(11) NOT NULL AUTO_INCREMENT,
  `correo_electronico` varchar(60) DEFAULT NULL,
  `numero_documento` varchar(15) NOT NULL,
  `primer_apellido` varchar(60) DEFAULT NULL,
  `primer_nombre` varchar(60) DEFAULT NULL,
  `razon_social` varchar(160) DEFAULT NULL,
  `segundo_apellido` varchar(60) DEFAULT NULL,
  `segundo_nombre` varchar(60) DEFAULT NULL,
  `tipo_documento` varchar(60) DEFAULT NULL,
  `tipo_persona` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo_arrendatario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of arrendatarios
-- ----------------------------

-- ----------------------------
-- Table structure for contratos
-- ----------------------------
DROP TABLE IF EXISTS `contratos`;
CREATE TABLE `contratos` (
  `codigo_contrato` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_condiciones` varchar(255) DEFAULT NULL,
  `fecha_final` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_pagos` date NOT NULL,
  `pago_mensual` bigint(20) NOT NULL,
  `codigo_arrendatario` int(11) NOT NULL,
  `codigo_predio` int(11) NOT NULL,
  `codigo_propietario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_contrato`),
  UNIQUE KEY `UK_a6ceom1rfsl9k8h8w6ocxbobn` (`codigo_arrendatario`),
  UNIQUE KEY `UK_qx5qagxn3te8vybhmtl335l6h` (`codigo_predio`),
  UNIQUE KEY `UK_nhxtkx3bvhxb8fslp7uesjq2t` (`codigo_propietario`),
  CONSTRAINT `FK_CONTRATO_ARRENDATARIO` FOREIGN KEY (`codigo_arrendatario`) REFERENCES `arrendatarios` (`codigo_arrendatario`),
  CONSTRAINT `FK_CONTRATO_PREDIO` FOREIGN KEY (`codigo_predio`) REFERENCES `predios_propietario` (`codigo_predio_propietario`),
  CONSTRAINT `FK_CONTRATO_PROPIETARIO` FOREIGN KEY (`codigo_propietario`) REFERENCES `propietarios` (`codigo_propietario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of contratos
-- ----------------------------

-- ----------------------------
-- Table structure for direcciones_arrendatario
-- ----------------------------
DROP TABLE IF EXISTS `direcciones_arrendatario`;
CREATE TABLE `direcciones_arrendatario` (
  `codigo_direcccion` int(11) NOT NULL AUTO_INCREMENT,
  `nomenclatura` varchar(100) NOT NULL,
  `codigo_arrendatario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_direcccion`),
  KEY `FK_DIRECCION_ARRENDATARIO` (`codigo_arrendatario`),
  CONSTRAINT `FK_DIRECCION_ARRENDATARIO` FOREIGN KEY (`codigo_arrendatario`) REFERENCES `arrendatarios` (`codigo_arrendatario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of direcciones_arrendatario
-- ----------------------------

-- ----------------------------
-- Table structure for direcciones_propietario
-- ----------------------------
DROP TABLE IF EXISTS `direcciones_propietario`;
CREATE TABLE `direcciones_propietario` (
  `codigo_direcccion` int(11) NOT NULL AUTO_INCREMENT,
  `nomenclatura` varchar(100) NOT NULL,
  `codigo_propietario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_direcccion`),
  KEY `FK_DIRECCION_PROPIETARIO` (`codigo_propietario`),
  CONSTRAINT `FK_DIRECCION_PROPIETARIO` FOREIGN KEY (`codigo_propietario`) REFERENCES `propietarios` (`codigo_propietario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of direcciones_propietario
-- ----------------------------

-- ----------------------------
-- Table structure for gastos_contrato
-- ----------------------------
DROP TABLE IF EXISTS `gastos_contrato`;
CREATE TABLE `gastos_contrato` (
  `codigo_gasto` int(11) NOT NULL AUTO_INCREMENT,
  `concepto` varchar(255) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `soporte` varchar(255) DEFAULT NULL,
  `valor_gasto` bigint(20) DEFAULT NULL,
  `codigo_contrato` int(11) NOT NULL,
  PRIMARY KEY (`codigo_gasto`),
  KEY `FK_GASTO_CONTRATO` (`codigo_contrato`),
  CONSTRAINT `FK_GASTO_CONTRATO` FOREIGN KEY (`codigo_contrato`) REFERENCES `contratos` (`codigo_contrato`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of gastos_contrato
-- ----------------------------

-- ----------------------------
-- Table structure for pagos_contrato
-- ----------------------------
DROP TABLE IF EXISTS `pagos_contrato`;
CREATE TABLE `pagos_contrato` (
  `codigo_pago` int(11) NOT NULL AUTO_INCREMENT,
  `concepto` varchar(255) DEFAULT NULL,
  `fecha_hora_registro` datetime DEFAULT NULL,
  `valor_pagado` bigint(20) NOT NULL,
  `codigo_contrato` int(11) NOT NULL,
  PRIMARY KEY (`codigo_pago`),
  KEY `FK_PAGO_CONTRATO` (`codigo_contrato`),
  CONSTRAINT `FK_PAGO_CONTRATO` FOREIGN KEY (`codigo_contrato`) REFERENCES `contratos` (`codigo_contrato`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of pagos_contrato
-- ----------------------------

-- ----------------------------
-- Table structure for predios_propietario
-- ----------------------------
DROP TABLE IF EXISTS `predios_propietario`;
CREATE TABLE `predios_propietario` (
  `codigo_predio_propietario` int(11) NOT NULL AUTO_INCREMENT,
  `area_construida` varchar(10) DEFAULT NULL,
  `cantidad_baños` int(11) DEFAULT NULL,
  `cantidad_habitaciones` int(11) DEFAULT NULL,
  `cantidad_parqueadero` int(11) DEFAULT NULL,
  `descripcion_estado` varchar(255) DEFAULT NULL,
  `direccion` varchar(180) NOT NULL,
  `estrato` int(11) DEFAULT NULL,
  `tipo_predio` varchar(15) NOT NULL,
  `ubicacion` varchar(30) DEFAULT NULL,
  `codigo_propietario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_predio_propietario`),
  KEY `FK_PREDIO_PROPIETARIO` (`codigo_propietario`),
  CONSTRAINT `FK_PREDIO_PROPIETARIO` FOREIGN KEY (`codigo_propietario`) REFERENCES `propietarios` (`codigo_propietario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of predios_propietario
-- ----------------------------

-- ----------------------------
-- Table structure for propietarios
-- ----------------------------
DROP TABLE IF EXISTS `propietarios`;
CREATE TABLE `propietarios` (
  `codigo_propietario` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(60) DEFAULT NULL,
  `correo` varchar(80) DEFAULT NULL,
  `nombres` varchar(60) NOT NULL,
  `numero_identificacion` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_propietario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of propietarios
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `codigo_role` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_role`),
  UNIQUE KEY `UK_tnbsugwi510vyht57lpdexekp` (`nombre_role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 ;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `roles` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for telefonos_arrendatario
-- ----------------------------
DROP TABLE IF EXISTS `telefonos_arrendatario`;
CREATE TABLE `telefonos_arrendatario` (
  `codigo_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `nota` varchar(15) DEFAULT NULL,
  `numero_telefono` int(11) DEFAULT NULL,
  `codigo_arrendatario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_telefono`),
  KEY `FK_TELEFONO_ARRENDATARIO` (`codigo_arrendatario`),
  CONSTRAINT `FK_TELEFONO_ARRENDATARIO` FOREIGN KEY (`codigo_arrendatario`) REFERENCES `arrendatarios` (`codigo_arrendatario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of telefonos_arrendatario
-- ----------------------------

-- ----------------------------
-- Table structure for telefonos_propietario
-- ----------------------------
DROP TABLE IF EXISTS `telefonos_propietario`;
CREATE TABLE `telefonos_propietario` (
  `codigo_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `nota` varchar(15) DEFAULT NULL,
  `numero_telefono` int(11) DEFAULT NULL,
  `codigo_propietario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_telefono`),
  KEY `FK_TELEFONO_PROPIETARIO` (`codigo_propietario`),
  CONSTRAINT `FK_TELEFONO_PROPIETARIO` FOREIGN KEY (`codigo_propietario`) REFERENCES `propietarios` (`codigo_propietario`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of telefonos_propietario
-- ----------------------------

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `codigo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`),
  UNIQUE KEY `UK_r9ksbmgwvokav9vgydstfdmws` (`user_name`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 ;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1', '', '$2a$10$DV.V2nPxy8Ue0T5wvQvBXOit8toB7ail7wilFeDPCv3Ppe5Zq9Uru', 'josefelix', 'curiel', 'jose@thalisoft.co', 'felix');
INSERT INTO `usuarios` VALUES ('2', '', '$2a$10$DV.V2nPxy8Ue0T5wvQvBXOit8toB7ail7wilFeDPCv3Ppe5Zq9Uru', 'fanny', 'gomez', 'fanny.gomez@gmail.com', 'fanny leonor');

-- ----------------------------
-- Table structure for usuarios_roles
-- ----------------------------
DROP TABLE IF EXISTS `usuarios_roles`;
CREATE TABLE `usuarios_roles` (
  `usuario_codigo_usuario` int(11) NOT NULL,
  `roles_codigo_role` int(11) NOT NULL,
  KEY `FKnvgkc3sfuuvntubso4iip9xgh` (`roles_codigo_role`),
  KEY `FKeejyenim6p35f2r6nivmpbypt` (`usuario_codigo_usuario`),
  CONSTRAINT `FKeejyenim6p35f2r6nivmpbypt` FOREIGN KEY (`usuario_codigo_usuario`) REFERENCES `usuarios` (`codigo_usuario`),
  CONSTRAINT `FKnvgkc3sfuuvntubso4iip9xgh` FOREIGN KEY (`roles_codigo_role`) REFERENCES `roles` (`codigo_role`)
) ENGINE=InnoDB ;

-- ----------------------------
-- Records of usuarios_roles
-- ----------------------------
INSERT INTO `usuarios_roles` VALUES ('1', '1');
INSERT INTO `usuarios_roles` VALUES ('2', '2');
INSERT INTO `usuarios_roles` VALUES ('1', '2');
