-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2018 at 01:05 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeelogindatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `employeelogintable`
--

CREATE TABLE `employeelogintable` (
  `EmployeeID` int(100) NOT NULL,
  `EmployeeUsername` varchar(15) NOT NULL,
  `EmployeePassword` varchar(10) NOT NULL,
  `EmployeeCategory` varchar(25) NOT NULL,
  `EmployeeName` longtext NOT NULL,
  `EmployeeAddress` mediumtext NOT NULL,
  `EmployeeContactNum` longtext NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeelogintable`
--

INSERT INTO `employeelogintable` (`EmployeeID`, `EmployeeUsername`, `EmployeePassword`, `EmployeeCategory`, `EmployeeName`, `EmployeeAddress`, `EmployeeContactNum`) VALUES
(1, 'admin', 'admin', 'admin', 'admin admin', 'admin', '999999999'),
(2, 'bsoftmahesh', 'mahesh123', 'Manager', 'Mahesh Shakya', 'Lamachour', '9846055555'),
(3, 'bsoftsahil', 'sahil123', 'Teller', 'Sahil KC', 'Lamachour', '9866007680'),
(4, 'bsoftsitaram', 'sitaram123', 'Customer Service', 'Sitaram Paudel', 'Batulechour', '9814108575'),
(5, 'bsoftadarsha', 'adarsha123', 'System Admin', 'Adarsha Dhakal', 'Batulechour', '9846066666'),
(6, 'bsoftroshan', 'roshan123', 'Manager', 'Roshan Adhikari', 'Nadipur', '9846078795');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employeelogintable`
--
ALTER TABLE `employeelogintable`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employeelogintable`
--
ALTER TABLE `employeelogintable`
  MODIFY `EmployeeID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
