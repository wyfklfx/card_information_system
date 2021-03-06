-- MySQL Script generated by MySQL Workbench
-- 07/03/16 11:35:40
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema StudentCardSystemDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `StudentCardSystemDB` ;

-- -----------------------------------------------------
-- Schema StudentCardSystemDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `StudentCardSystemDB` DEFAULT CHARACTER SET utf8 ;
USE `StudentCardSystemDB` ;

-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`Student` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`Student` (
  `StudentID` INT NOT NULL COMMENT '',
  `Password` VARCHAR(20) NOT NULL COMMENT '',
  `Name` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`StudentID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`Admin` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`Admin` (
  `AdminID` INT NOT NULL COMMENT '',
  `Password` VARCHAR(20) NOT NULL COMMENT '',
  `Name` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`AdminID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`Seller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`Seller` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`Seller` (
  `SellerID` INT NOT NULL COMMENT '',
  `Password` VARCHAR(20) NOT NULL COMMENT '',
  `Name` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`SellerID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`StudentCard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`StudentCard` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`StudentCard` (
  `StudentID` INT NOT NULL COMMENT '',
  `StudentCardID` VARCHAR(30) NOT NULL COMMENT '',
  `Balance` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`StudentID`)  COMMENT '',
  UNIQUE INDEX `StudentCardID_UNIQUE` (`StudentCardID` ASC)  COMMENT '',
  CONSTRAINT `StudentCardStudentIDFK`
    FOREIGN KEY (`StudentID`)
    REFERENCES `StudentCardSystemDB`.`Student` (`StudentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`ShopInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`ShopInfo` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`ShopInfo` (
  `OwnerID` INT NOT NULL COMMENT '',
  `ShopName` VARCHAR(30) NOT NULL COMMENT '',
  `ShopID` INT NOT NULL COMMENT '',
  PRIMARY KEY (`ShopID`)  COMMENT '',
  INDEX `ShopInfoOwnerIDFK_idx` (`OwnerID` ASC)  COMMENT '',
  CONSTRAINT `ShopInfoOwnerIDFK`
    FOREIGN KEY (`OwnerID`)
    REFERENCES `StudentCardSystemDB`.`Seller` (`SellerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`ConsumeRecord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`ConsumeRecord` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`ConsumeRecord` (
  `StudentID` INT NOT NULL COMMENT '',
  `ConsumeTime` DATETIME NOT NULL COMMENT '',
  `Balance` FLOAT NOT NULL COMMENT '',
  `ConsumeInfo` TEXT NULL COMMENT '',
  `ShopID` INT NULL COMMENT '',
  INDEX `ConsumeRecordStudentIDFK_idx` (`StudentID` ASC)  COMMENT '',
  PRIMARY KEY (`StudentID`, `ConsumeTime`)  COMMENT '',
  INDEX `ConsumeRecordShopIDFK_idx` (`ShopID` ASC)  COMMENT '',
  CONSTRAINT `ConsumeRecordStudentIDFK`
    FOREIGN KEY (`StudentID`)
    REFERENCES `StudentCardSystemDB`.`Student` (`StudentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ConsumeRecordShopIDFK`
    FOREIGN KEY (`ShopID`)
    REFERENCES `StudentCardSystemDB`.`ShopInfo` (`ShopID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`TopUpRecord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`TopUpRecord` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`TopUpRecord` (
  `StudentID` INT NOT NULL COMMENT '',
  `TopUpTime` DATETIME NOT NULL COMMENT '',
  `Balance` FLOAT NOT NULL COMMENT '',
  `TopUpInfo` TEXT NULL COMMENT '',
  PRIMARY KEY (`StudentID`, `TopUpTime`)  COMMENT '',
  CONSTRAINT `TopUpRecordStudentIDFK`
    FOREIGN KEY (`StudentID`)
    REFERENCES `StudentCardSystemDB`.`Student` (`StudentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`LossReportRecord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`LossReportRecord` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`LossReportRecord` (
  `StudentID` INT NOT NULL COMMENT '',
  `LossReportTime` DATETIME NOT NULL COMMENT '',
  `PrevStudentCardID` VARCHAR(30) NOT NULL COMMENT '',
  `LaterStudentCardID` VARCHAR(30) NOT NULL COMMENT '',
  PRIMARY KEY (`StudentID`, `LossReportTime`)  COMMENT '',
  CONSTRAINT `LossReportRecordStudentIDFK`
    FOREIGN KEY (`StudentID`)
    REFERENCES `StudentCardSystemDB`.`Student` (`StudentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentCardSystemDB`.`RefundRecord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentCardSystemDB`.`RefundRecord` ;

CREATE TABLE IF NOT EXISTS `StudentCardSystemDB`.`RefundRecord` (
  `StudentID` INT NOT NULL COMMENT '',
  `RefundTime` DATETIME NOT NULL COMMENT '',
  `RefundInfo` TEXT NULL COMMENT '',
  PRIMARY KEY (`StudentID`, `RefundTime`)  COMMENT '',
  CONSTRAINT `RefundRecordStudentIDFK`
    FOREIGN KEY (`StudentID`)
    REFERENCES `StudentCardSystemDB`.`Student` (`StudentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
