-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2019 at 07:58 AM
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

--
-- Dumping data for table `murid`
--

INSERT INTO `murid` (`id_murid`, `nis`, `nama`, `id_kelas`, `id_peminjaman`) VALUES
(1, 171665, 'Sukijam', 1, 1);

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

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nis`, `tgl_meminjam`, `id_barang`, `waktu_peminjaman`, `status`) VALUES
(1, 171665, '2019-05-01', 5, '06:00:00', NULL);

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

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` int(11) NOT NULL,
  `id_barcode_admin` int(20) DEFAULT NULL,
  `nama_admin` varchar(128) DEFAULT NULL,
  `level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `id_barang` int(11) NOT NULL,
  `id_barcode` varchar(128) DEFAULT NULL,
  `nama_barang` varchar(128) DEFAULT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  `image` mediumblob,
  `umur_barang` time DEFAULT NULL,
  `jenis_barang` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`id_barang`, `id_barcode`, `nama_barang`, `tanggal_masuk`, `status`, `image`, `umur_barang`, `jenis_barang`) VALUES
(1, 'aa1166', 'StopKontak', '2019-05-08', 'Baik', 0x89504e470d0a1a0a0000000d49484452000000c60000003008030000007d8ef56b00000300504c54450000000000330000660000990000cc0000ff0033000033330033660033990033cc0033ff0066000066330066660066990066cc0066ff0099000099330099660099990099cc0099ff00cc0000cc3300cc6600cc9900cccc00ccff00ff0000ff3300ff6600ff9900ffcc00ffff3300003300333300663300993300cc3300ff3333003333333333663333993333cc3333ff3366003366333366663366993366cc3366ff3399003399333399663399993399cc3399ff33cc0033cc3333cc6633cc9933cccc33ccff33ff0033ff3333ff6633ff9933ffcc33ffff6600006600336600666600996600cc6600ff6633006633336633666633996633cc6633ff6666006666336666666666996666cc6666ff6699006699336699666699996699cc6699ff66cc0066cc3366cc6666cc9966cccc66ccff66ff0066ff3366ff6666ff9966ffcc66ffff9900009900339900669900999900cc9900ff9933009933339933669933999933cc9933ff9966009966339966669966999966cc9966ff9999009999339999669999999999cc9999ff99cc0099cc3399cc6699cc9999cccc99ccff99ff0099ff3399ff6699ff9999ffcc99ffffcc0000cc0033cc0066cc0099cc00cccc00ffcc3300cc3333cc3366cc3399cc33cccc33ffcc6600cc6633cc6666cc6699cc66cccc66ffcc9900cc9933cc9966cc9999cc99cccc99ffcccc00cccc33cccc66cccc99ccccccccccffccff00ccff33ccff66ccff99ccffccccffffff0000ff0033ff0066ff0099ff00ccff00ffff3300ff3333ff3366ff3399ff33ccff33ffff6600ff6633ff6666ff6699ff66ccff66ffff9900ff9933ff9966ff9999ff99ccff99ffffcc00ffcc33ffcc66ffcc99ffccccffccffffff00ffff33ffff66ffff99ffffccffffff1212121818181e1e1e2424242a2a2a3030303636363c3c3c4242424848484e4e4e5454545a5a5a6060606666666c6c6c7272727878787e7e7e8484848a8a8a9090909696969c9c9ca2a2a2a8a8a8aeaeaeb4b4b4bababac0c0c0c6c6c6ccccccd2d2d2d8d8d8dededee4e4e4eaeaeaf0f0f0f6f6f6fcfcfc202962c3000001ab4944415478daed9a6d8ec42008869da69779ef7f98f73a3bdbfa0116d166ba7f76309946ab853e80d88479315d1bde3fbeafccfd247a6506b5df66e5a8dd2ba3d43d03214d4a4f557eff94bcabdb96fe450b8cc0088cc0088cc0088cc0088cc0088cc0088cc0088cc0f85e8c17c31b81111881111881f17518fb6802b576520ec85c6cc1da8189444fb258d754c0ea76376db1db94a2d68172233e331c8c91b89e1774e3cbda356f8812162eeac1c728a40a9cdd53fa61451c5532e69b4872c19a375ac9ee2cb8016aeaa9265534e12a20d93472a87d5f33990e26690f51a6d455cc32cb3a330c09b999ba57e5b3998a7462c40ef054e24005b9f75e00e05915433becf7b24cf60b74f6428d67a0db4e54f13fa1d09e464b50cce1304c55fb1311cecbf542b12ac7dec19889f8f8f8031ce3f29e9715715bccd399bff246b1bd7dee07b824360500e7312b5b354efc41506543d19c828d858528c3bdbcbe3fb1339c2c4a6f372d502ce26cd3f77305f981411d563c9a4ade4285d406b547dae7dcbd84db322a260e27e01977e5fb0be6f950feb653b2ec24e16eab89d45bc2b5b79ca8a0298bbd1a53d90f0ee1a92843c215420000000049454e44ae426082, '06:00:00', 'Asset');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detail_peminjaman`
--

CREATE TABLE `tbl_detail_peminjaman` (
  `id_detail_peminjaman` int(11) NOT NULL,
  `id_peminjaman` int(20) DEFAULT NULL,
  `id_barang` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jurusan`
--

CREATE TABLE `tbl_jurusan` (
  `id_jurusan` int(11) NOT NULL,
  `nama_jurusan` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_jurusan`
--

INSERT INTO `tbl_jurusan` (`id_jurusan`, `nama_jurusan`) VALUES
(1, 'Rekayasa Perangkat Lunak'),
(2, 'Teknik Komputer Dan Jaringan'),
(3, 'Multimedia');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kelas`
--

CREATE TABLE `tbl_kelas` (
  `id_kelas` int(11) NOT NULL,
  `nama_kelas` varbinary(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_level`
--

CREATE TABLE `tbl_level` (
  `id_level` int(11) NOT NULL,
  `nama_level` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_murid`
--

CREATE TABLE `tbl_murid` (
  `id_murid` int(11) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `nama` varchar(128) DEFAULT NULL,
  `id_kelas` int(20) DEFAULT NULL,
  `id_jurusan` int(11) NOT NULL,
  `id_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_murid`
--

INSERT INTO `tbl_murid` (`id_murid`, `nis`, `nama`, `id_kelas`, `id_jurusan`, `id_level`) VALUES
(1, 1718117213, 'VIko', 1, 1, 1),
(2, 1718112114, 'Samsul', 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_peminjaman`
--

CREATE TABLE `tbl_peminjaman` (
  `id_peminjaman` int(20) NOT NULL,
  `nis` int(20) DEFAULT NULL,
  `tgl_meminjam` date DEFAULT NULL,
  `waktu_peminjaman` time DEFAULT NULL,
  `status` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pengembalian`
--

CREATE TABLE `tbl_pengembalian` (
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
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tbl_jurusan`
--
ALTER TABLE `tbl_jurusan`
  ADD PRIMARY KEY (`id_jurusan`);

--
-- Indexes for table `tbl_kelas`
--
ALTER TABLE `tbl_kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `tbl_level`
--
ALTER TABLE `tbl_level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `tbl_murid`
--
ALTER TABLE `tbl_murid`
  ADD PRIMARY KEY (`id_murid`),
  ADD KEY `id_jurusan` (`id_jurusan`);

--
-- Indexes for table `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indexes for table `tbl_pengembalian`
--
ALTER TABLE `tbl_pengembalian`
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
  MODIFY `id_murid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_jurusan`
--
ALTER TABLE `tbl_jurusan`
  MODIFY `id_jurusan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_kelas`
--
ALTER TABLE `tbl_kelas`
  MODIFY `id_kelas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_murid`
--
ALTER TABLE `tbl_murid`
  MODIFY `id_murid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  MODIFY `id_peminjaman` int(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_murid`
--
ALTER TABLE `tbl_murid`
  ADD CONSTRAINT `tbl_murid_ibfk_1` FOREIGN KEY (`id_jurusan`) REFERENCES `tbl_jurusan` (`id_jurusan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
