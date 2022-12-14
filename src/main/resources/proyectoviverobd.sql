-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyectoviverobd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyectoviverobd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyectoviverobd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `proyectoviverobd` ;

-- -----------------------------------------------------
-- Table `proyectoviverobd`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectoviverobd`.`roles` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `proyectoviverobd`.`roles`
--

INSERT INTO `proyectoviverobd`.`roles` VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');
'


-- -----------------------------------------------------
-- Table `proyectoviverobd`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectoviverobd`.`usuarios` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `password` VARCHAR(150) NULL DEFAULT NULL,
  `username` VARCHAR(50) NULL DEFAULT NULL,
  `rol_idrol` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `FKjrft28f2r3sdt50girys0akpa`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `proyectoviverobd`.`roles` (`idrol`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyectoviverobd`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectoviverobd`.`pedidos` (
  `idpedido` INT NOT NULL AUTO_INCREMENT,
  `fecha_pedido` DATE NOT NULL,
  `precio` FLOAT NULL DEFAULT '0',
  `idusuario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT `FK93mauwrmfe5j3vjerdojcuvrm`
    FOREIGN KEY (`idusuario`)
    REFERENCES `proyectoviverobd`.`usuarios` (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proyectoviverobd`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectoviverobd`.`productos` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `caracteristicas` VARCHAR(255) NULL DEFAULT NULL,
  `categoria` VARCHAR(255) NULL DEFAULT NULL,
  `imagen` VARCHAR(255) NULL DEFAULT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `precio` FLOAT NULL DEFAULT '0',
  `stock` INT NULL DEFAULT '0',
  `pedido_idpedido` INT NULL DEFAULT NULL,
  `propietario_idusuario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  CONSTRAINT `FKlihvpano1ctbj5kh1x4yt2k65`
    FOREIGN KEY (`pedido_idpedido`)
    REFERENCES `proyectoviverobd`.`pedidos` (`idpedido`),
  CONSTRAINT `FKr9thjwq5nsp7seebh6qnj8cr4`
    FOREIGN KEY (`propietario_idusuario`)
    REFERENCES `proyectoviverobd`.`usuarios` (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `proyectoviverobd`.`productos`
--

INSERT INTO `proyectoviverobd`.`productos` (idproducto,caracteristicas,categoria,imagen,nombre,precio,stock) VALUES
(1,'Fruto de tama??o mediano, de forma redonda a troncoc??nica bastante aplanada, epidermis rayada de color rojo,con tonalidades naranja-marr??n sobre fondo verde o amarillo verdoso.Variedad ??cida','EN MACETA','raxao.png','Raxao',8.95f,60),
(2,'Fruto de tama??o mediano o peque??o en situaciones de sobrecarga de producci??n, de forma redondeada aplanada, color verde o amarillo-verdoso. Variedad ??cido-amarga.','EN MACETA','regona.png','Regona',8.95,120),
(3,'Fruto de tama??o mediano o algo peque??o de forma c??nica oblonga a c??nica globulosa y epidermis amarilla manchada de marr??n anaranjado y estr??as rosadas.Variedad semi??cida','DE TEMPORADA','delariega.png','De la Riega',8.95,150);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
