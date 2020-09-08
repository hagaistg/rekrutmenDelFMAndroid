-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2019 at 06:46 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyekpam`
--

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id` int(11) NOT NULL,
  `namalengkap` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `umur` varchar(200) NOT NULL,
  `tgllahir` varchar(200) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `notlp` varchar(200) NOT NULL,
  `jeniskelamin` varchar(200) NOT NULL,
  `pendidikan` varchar(200) NOT NULL,
  `pengalaman` varchar(200) NOT NULL,
  `posisi` varchar(200) NOT NULL,
  `motivasi` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendaftaran`
--

INSERT INTO `pendaftaran` (`id`, `namalengkap`, `email`, `umur`, `tgllahir`, `alamat`, `notlp`, `jeniskelamin`, `pendidikan`, `pengalaman`, `posisi`, `motivasi`) VALUES
(1, 'wenny', 'wenny@gmail.com', '20 tahun', '26-01-99', 'silaen', '082304060846', 'perempuan', 'D3', 'bagus', 'produser', 'saya ingin menambah pengalaman'),
(2, 'jsjaja', 'aban', 'ajja', 'anaj', '', '', 'ffg', 'ff', 'vg', 'ggh', ''),
(3, 'Amri', 'amri.gmail@.com', '20', '03-02-90', 'silaen', '', 'lakilaki', 'S1', 'baik', 'penyiar', ''),
(4, 'sondang', 'baja@gmail.com', '19', '12-04-02', 'silaen', '', 'cewek', 'd3', 'frontend developer', 'frontend developer', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
