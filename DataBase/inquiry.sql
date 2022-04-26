-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 05:33 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inquiry`
--

-- --------------------------------------------------------

--
-- Table structure for table `inquiry`
--

CREATE TABLE `inquiry` (
  `inquiry_id` int(11) NOT NULL,
  `account_no` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `message` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inquiry`
--

INSERT INTO `inquiry` (`inquiry_id`, `account_no`, `address`, `phone`, `subject`, `message`) VALUES
(4, 'A03', 'Jaffna', '0789652317', 'trip failure', 'dvnvchxwhnf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inquiry`
--
ALTER TABLE `inquiry`
  ADD PRIMARY KEY (`inquiry_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inquiry`
--
ALTER TABLE `inquiry`
  MODIFY `inquiry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
