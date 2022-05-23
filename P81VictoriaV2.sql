-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema p81victoriav2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema p81victoriav2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `p81victoriav2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `p81victoriav2` ;

-- -----------------------------------------------------
-- Table `p81victoriav2`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `p81victoriav2`.`hospital` (
  `codhospi` INT NOT NULL AUTO_INCREMENT,
  `nomhospi` VARCHAR(60) NOT NULL,
  `cifhospi` VARCHAR(6) NOT NULL DEFAULT '000000',
  `dirhospi` VARCHAR(60) NOT NULL,
  `codpostal` VARCHAR(5) NOT NULL DEFAULT '00000',
  PRIMARY KEY (`codhospi`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `p81victoriav2`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `p81victoriav2`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombreperson` VARCHAR(20) NOT NULL,
  `apelpersona` VARCHAR(50) NOT NULL,
  `dni` VARCHAR(10) NOT NULL,
  `sexo` ENUM('hombre', 'mujer', 'otro') NULL DEFAULT NULL,
  `dirUsuario` VARCHAR(100) NULL DEFAULT NULL,
  `fecnacim` DATE NOT NULL,
  `hospital_codhospi` INT NOT NULL,
  PRIMARY KEY (`idpersona`),
  INDEX `fk_persona_hospital1_idx` (`hospital_codhospi` ASC) VISIBLE,
  CONSTRAINT `fk_persona_hospital1`
    FOREIGN KEY (`hospital_codhospi`)
    REFERENCES `p81victoriav2`.`hospital` (`codhospi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `p81victoriav2`.`tarjetasanitaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `p81victoriav2`.`tarjetasanitaria` (
  `numtarjeta` VARCHAR(10) NOT NULL,
  `feccaduca` DATE NOT NULL,
  `persona_idpersona` INT NOT NULL,
  PRIMARY KEY (`numtarjeta`),
  INDEX `fk_tarjetasanitaria_persona1_idx` (`persona_idpersona` ASC) VISIBLE,
  CONSTRAINT `fk_tarjetasanitaria_persona1`
    FOREIGN KEY (`persona_idpersona`)
    REFERENCES `p81victoriav2`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
