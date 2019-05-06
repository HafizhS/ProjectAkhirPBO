-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2019 at 04:09 PM
-- Server version: 5.7.21-log
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `id_barcode` varchar(128) DEFAULT NULL,
  `nama_barang` varchar(128) DEFAULT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `kondisi_barang` enum('baik','normal','hampir rusak','rusak') DEFAULT NULL,
  `image` varchar(128) DEFAULT NULL,
  `umur_barang` time DEFAULT NULL,
  `type_barang` enum('asset','sekali pakai') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `id_barcode`, `nama_barang`, `tanggal_masuk`, `kondisi_barang`, `image`, `umur_barang`, `type_barang`) VALUES
(4, 's10002', 'MOBIL', '2019-05-15', 'baik', 'null', '06:00:00', 'asset'),
(5, 's10002', 'ssss', '2019-05-15', 'normal', 'E:FotoStock33f737772973fdb2a6fee6857ea2acc5.jpg', '06:00:00', 'sekali pakai'),
(6, 's10002', 'RJ45', '2019-05-15', 'normal', NULL, '06:00:00', NULL),
(7, 's101010', 'PENCIL', '2019-07-10', 'normal', 'E:\\Foto\\62049_sci_fi_cyberpunk.jpg', NULL, NULL),
(8, 'hffs00', 'Super Dummy', '2019-05-02', 'normal', 'E:\\Foto\\50e.png', NULL, NULL),
(9, 'dsdaa01', 'ANOTHER DUMMY', '2019-05-05', 'normal', NULL, NULL, NULL),
(10, 'stt', 'sttHHH92', '2019-05-03', 'hampir rusak', 'E:\\\\Foto\\\\62049_sci_fi_cyberpunk.jpg', NULL, NULL),
(11, 'Kucing>Tikus', 'MAGIC CREATURE', '2019-05-01', 'baik', 'E:\\\\Foto\\\\throwupcat_meme.jpg', NULL, NULL),
(12, 'COMMUNISM', 'Mother Russia', '2019-05-29', 'baik', 'E:\\\\Foto\\\\putin-ride-shark.jpg', NULL, NULL),
(13, 'SAD PEPE IS EXPIRED MEME', 'SAD PEPE', '2019-05-06', 'hampir rusak', 'E:\\\\Foto\\\\sad-pepe1.jpg', NULL, NULL),
(14, 'barangDummy', 'sttsDumi', '2018-05-03', 'normal', 'null', NULL, 'sekali pakai'),
(15, 'test!!33))', 'VurVurVur', '2019-06-05', 'hampir rusak', '', NULL, NULL),
(17, 'TEST!', 'HHHH345', '2019-05-02', 'rusak', 'null', NULL, 'sekali pakai');

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `id_detail_peminjaman` int(11) NOT NULL,
  `id_peminjaman` int(20) DEFAULT NULL,
  `id_barang` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` int(11) NOT NULL,
  `nama_level` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `murid`
--

CREATE TABLE `murid` (
  `id_murid` int(11) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `nama` varchar(128) DEFAULT NULL,
  `id_kelas` int(20) DEFAULT NULL,
  `id_peminjaman` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int(20) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `tgl_meminjam` date DEFAULT NULL,
  `id_barang` int(11) DEFAULT NULL,
  `waktu_peminjaman` time DEFAULT NULL,
  `status` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` int(20) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `waktu_pengembalian` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD PRIMARY KEY (`id_detail_peminjaman`);

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `murid`
--
ALTER TABLE `murid`
  ADD PRIMARY KEY (`id_murid`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  MODIFY `id_detail_peminjaman` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `murid`
--
ALTER TABLE `murid`
  MODIFY `id_murid` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
