-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th12 05, 2022 lúc 11:42 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 5.6.40
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `market3`
--
CREATE DATABASE IF NOT EXISTS `market3` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
# drop database  market3;
-- --------------------------------------------------------
--
-- Cấu trúc bảng cho bảng `Category`
--
use market3;
CREATE TABLE `Category`
(
    `CatagoryID`  int(10)     NOT NULL primary key auto_increment,
    `Name`        varchar(30) NOT NULL,
    `Description` varchar(50) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Đang đổ dữ liệu cho bảng `Category`
--


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Customers`
--

CREATE TABLE `Customers`
(
    `CustomerID` int(11)     NOT NULL primary key auto_increment,
    `Password`   varchar(20) NOT NULL,
    `Fullname`   varchar(40) NOT NULL,
    `Address`    varchar(50) DEFAULT NULL,
    `City`       varchar(20) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint(20) DEFAULT NULL
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`)
VALUES (9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Order`
--

CREATE TABLE `Order`
(
    `OrderID`    int(10) NOT NULL primary key auto_increment,
    `CustomerID` int(10) NOT NULL,
    `Date`       date    NOT NULL,
    `Total`      float   NOT NULL,
    `Note`       text    NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `OrderDetail`
--

CREATE TABLE `OrderDetail`
(
    `OrderID`     int(10)    NOT NULL,
    `VegetableID` int(10)    NOT NULL,
    `Quantity`    tinyint(4) NOT NULL,
    `Price`       float      NOT NULL,
    primary key (OrderID, VegetableID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Đang đổ dữ liệu cho bảng `OrderDetail`
--


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Vegetable`
--

CREATE TABLE `Vegetable`
(
    `VegetableID`    int(11)     NOT NULL primary key auto_increment,
    `CatagoryID`     int(10)     NOT NULL,
    `Vegetable_Name` varchar(50) DEFAULT NULL,
    `Unit`           varchar(20) NOT NULL,
    `Amount`         int(10)     NOT NULL,
    `Image`          varchar(50) NOT NULL,
    `Price`          float       NOT NULL,
    `CustomerID`     int(11)     NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

alter table `Vegetable`
    add constraint fk_1 foreign key (CatagoryID) references `Category` (CatagoryID);
alter table `Order`
    add constraint fk_2 foreign key (CustomerID) references `Customers` (CustomerID);
alter table `OrderDetail`
    add constraint fk_3 foreign key (OrderID) references `Order` (OrderID);
alter table `OrderDetail`
    add constraint fk_4 foreign key (VegetableID) references `Vegetable` (VegetableID);
--
-- Đang đổ dữ liệu cho bảng `Vegetable`
--

INSERT INTO `Category` (`CatagoryID`, `Name`, `Description`)
VALUES (1, 'Fruit', 'The kind that can be eaten without cooking'),
       (2, 'Green Vegetables', 'The kind used to make salads or soups'),
       (3, 'Spices', 'The kind used to enhance the taste of food');
INSERT INTO `Vegetable` (`CatagoryID`, `Vegetable_Name`, `Unit`, `Amount`, `Image`, `Price`)
VALUES (1, 'Tomato', 'kg', 100, 'images/tomato.jpg', 30000),
       (1, 'potato', 'kg', 150, 'images/potato.jpg', 35000),
       (1, 'Apple', 'bag', 50, 'images/apple.jpg', 150000),
       (1, 'Water melon', 'per fruit', 20, 'images/watermelon.jpg', 80000),
       (2, ' broccoli', 'kg', 50, 'images/broccoli.jpg', 35000),
       (2, 'celery', 'kg', 80, 'images/celery.jpg', 40000),
       (3, ' spring onion', 'bunch', 50, 'images/springonion.jpg', 15000),
       (3, 'garlic', 'kg', 30, 'images/garlic.jpg', 120000);


--
-- Đang đổ dữ liệu cho bảng `Customers`
--

INSERT INTO `Customers` (`Password`, `Fullname`, `Address`, `City`)
VALUES ('Abcd1234', 'John Smith', '30 Broadway', 'London'),
       ('Abcd1234', 'Jonny English', '99 River View', 'Reading'),
       ('Abcd1234', 'Elizabeth', '23 Buckinghamshire', 'York'),
       ('Abcd1234', 'Beatrix', '66 Royal Crescent', 'Bath'),
       ('123', 'Huong', 'Thu Duc', 'HCM'),
       ('passwwwww', 'John Smith', '30 Broadway 1111', 'London 1111'),
       ('123', 'thanh', 'q5', 'binh duong');
--
-- Đang đổ dữ liệu cho bảng `Order`
--

INSERT INTO `Order` (`CustomerID`, `Date`, `Total`, `Note`)
VALUES (1, '2021-08-15', 150000, 'Use environmental protection bags'),
       (2, '2021-08-16', 235000, ''),
       (3, '2021-08-16', 65000, 'Need fast delivery'),
       (3, '2021-08-17', 80000, '');

INSERT INTO `OrderDetail` (`OrderID`, `VegetableID`, `Quantity`, `Price`)
VALUES (1, 1, 1, 30000),
       (1, 8, 1, 120000),
       (1, 4, 1, 80000),
       (1, 2, 1, 35000),
       (1, 3, 1, 150000),
       (2, 5, 1, 35000),
       (2, 7, 2, 30000),
       (3, 6, 2, 80000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;