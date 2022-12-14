-- MySQL Script generated by MySQL Workbench
-- Sat Aug 13 13:17:34 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clinicamedica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clinicamedica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinicamedica` DEFAULT CHARACTER SET utf8 ;
USE `clinicamedica` ;

-- -----------------------------------------------------
-- Table `clinicamedica`.`dados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`dados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicamedica`.`especialidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`especialidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicamedica`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`medico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `CRM` INT NOT NULL,
  `dados_id` INT NOT NULL,
  `especialidade_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_medico_dados1`
    FOREIGN KEY (`dados_id`)
    REFERENCES `clinicamedica`.`dados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medico_especialidade1`
    FOREIGN KEY (`especialidade_id`)
    REFERENCES `clinicamedica`.`especialidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_medico_dados1_idx` ON `clinicamedica`.`medico` (`dados_id` ASC);

CREATE INDEX `fk_medico_especialidade1_idx` ON `clinicamedica`.`medico` (`especialidade_id` ASC);


-- -----------------------------------------------------
-- Table `clinicamedica`.`plano_saude`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`plano_saude` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicamedica`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_nascimento` DATETIME NOT NULL,
  `dados_id` INT NOT NULL,
  `plano_saude_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_paciente_dados1`
    FOREIGN KEY (`dados_id`)
    REFERENCES `clinicamedica`.`dados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_plano_saude1`
    FOREIGN KEY (`plano_saude_id`)
    REFERENCES `clinicamedica`.`plano_saude` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_paciente_dados1_idx` ON `clinicamedica`.`paciente` (`dados_id` ASC);

CREATE INDEX `fk_paciente_plano_saude1_idx` ON `clinicamedica`.`paciente` (`plano_saude_id` ASC);


-- -----------------------------------------------------
-- Table `clinicamedica`.`exames`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`exames` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicamedica`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicamedica`.`consulta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `horario` INT NOT NULL,
  `prescricao` VARCHAR(200) NOT NULL,
  `medico_id` INT NOT NULL,
  `paciente_id` INT NOT NULL,
  `exames_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_consulta_medico`
    FOREIGN KEY (`medico_id`)
    REFERENCES `clinicamedica`.`medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_paciente1`
    FOREIGN KEY (`paciente_id`)
    REFERENCES `clinicamedica`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_exames1`
    FOREIGN KEY (`exames_id`)
    REFERENCES `clinicamedica`.`exames` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_consulta_medico_idx` ON `clinicamedica`.`consulta` (`medico_id` ASC);

CREATE INDEX `fk_consulta_paciente1_idx` ON `clinicamedica`.`consulta` (`paciente_id` ASC);

CREATE INDEX `fk_consulta_exames1_idx` ON `clinicamedica`.`consulta` (`exames_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
