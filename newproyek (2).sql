-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2021 at 01:56 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newproyek`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `IDBARANG` int(50) NOT NULL,
  `NAMABARANG` varchar(100) NOT NULL,
  `HARGANORMAL` int(11) NOT NULL,
  `FK_JENIS` int(11) NOT NULL,
  `STOK` int(11) NOT NULL,
  `HARGAGROSIR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`IDBARANG`, `NAMABARANG`, `HARGANORMAL`, `FK_JENIS`, `STOK`, `HARGAGROSIR`) VALUES
(1, 'Five Feet Apart by Rachael Lippincott', 75000, 7, 10, 70000),
(2, 'Buku Big Boss', 4500, 6, 100, 4250),
(3, 'Bupena', 50000, 5, 50, 48500),
(4, 'Pensil 2B', 3000, 1, 200, 2300),
(5, 'Pensil Warna 24', 25000, 2, 30, 23000),
(6, 'Bolpen parkour', 25000, 1, 40, 23000),
(7, 'Cat air 12', 12000, 2, 20, 10000),
(8, 'Spidol Warna 12', 15000, 2, 20, 13000),
(9, 'Bolpen Manusia Salju', 3000, 1, 200, 2500),
(10, 'Bolpen Parkour', 25000, 1, 41, 25000),
(11, 'Amplop Pepperline 100', 20000, 3, 20, 18000),
(12, 'Kertas SUDI A4', 60000, 3, 25, 55000),
(13, 'Kabel USB', 15000, 4, 30, 12500),
(14, 'Mouse wireless', 45000, 4, 10, 40000),
(15, 'Detik-detik USBN', 50000, 5, 50, 48500),
(16, 'Flashdisk Toshiba 16GB', 30000, 4, 20, 28000),
(17, 'Novel Dilan ', 60000, 7, 10, 60000),
(18, 'Buku Tulis A5', 2500, 6, 300, 2250),
(19, 'Kokoro', 5500, 1, 200, 4800),
(20, 'Buku Kotak', 4500, 6, 100, 4250),
(21, 'Standart', 3000, 1, 0, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `dtrans`
--

CREATE TABLE `dtrans` (
  `H_NOMORNOTA` varchar(100) NOT NULL,
  `FK_BARANG` int(11) NOT NULL,
  `QTY` int(11) NOT NULL,
  `SUBTOTAL` int(11) NOT NULL,
  `HARGA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtrans`
--

INSERT INTO `dtrans` (`H_NOMORNOTA`, `FK_BARANG`, `QTY`, `SUBTOTAL`, `HARGA`) VALUES
('20211021001', 1, 2, 6000, 0),
('20211021001', 7, 1, 20000, 0),
('20211021001', 9, 1, 15000, 0),
('20210930001', 5, 12, 30000, 0),
('20211225001', 6, 2, 50000, 0),
('20211225001', 8, 1, 60000, 0),
('20211225001', 2, 2, 50000, 0),
('20210817001', 3, 2, 24000, 0),
('20210817001', 10, 1, 45000, 0),
('20210511001', 4, 2, 30000, 0),
('20210511001', 6, 3, 75000, 0),
('20210511001', 8, 1, 60000, 0),
('20210511001', 1, 12, 27600, 0),
('20210930002', 9, 1, 15000, 0),
('20210930002', 6, 1, 25000, 0),
('20210930002', 8, 2, 120000, 0),
('20211213001', 7, 10, 100000, 10000),
('20211213001', 13, 10, 125000, 12500),
('20211213002', 5, 1, 25000, 25000),
('20211213003', 15, 10, 485000, 48500),
('20211213004', 14, 5, 225000, 45000),
('20211214001', 14, 2, 90000, 45000),
('20211214002', 16, 10, 280000, 28000),
('20211214003', 20, 10, 42500, 4250);

-- --------------------------------------------------------

--
-- Table structure for table `htrans`
--

CREATE TABLE `htrans` (
  `NOMORNOTA` varchar(100) NOT NULL,
  `TANGGALNOTA` varchar(100) NOT NULL,
  `GRANDTOTAL` int(100) NOT NULL,
  `FK_VOUCHER` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `htrans`
--

INSERT INTO `htrans` (`NOMORNOTA`, `TANGGALNOTA`, `GRANDTOTAL`, `FK_VOUCHER`) VALUES
('20210511001', '11/05/2021', 172600, 4),
('20210817001', '17/08/2021', 57270, 5),
('20210930001', '30/09/2021', 30000, 0),
('20210930002', '30/09/2021', 16000, 0),
('20211021001', '21/10/2021', 38000, 0),
('20211213001', '13/12/2021', 168750, 1),
('20211213002', '13/12/2021', 18750, 1),
('20211213003', '13/12/2021', 363750, 1),
('20211213004', '13/12/2021', 225000, 0),
('20211214001', '14/12/2021', 90000, 0),
('20211214002', '14/12/2021', 280000, 0),
('20211214003', '14/12/2021', 42500, 0),
('20211225001', '25/12/2021', 120000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `jenisbarang`
--

CREATE TABLE `jenisbarang` (
  `IDJENIS` int(50) NOT NULL,
  `NAMAJENIS` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenisbarang`
--

INSERT INTO `jenisbarang` (`IDJENIS`, `NAMAJENIS`) VALUES
(1, 'Bolpen dan Pensil'),
(2, 'Alat lukis dan Warna'),
(3, 'Kertas dan Amplop'),
(4, 'Aksesoris Komputer dan HP'),
(5, 'Buku Ilmu Pengetahuan'),
(6, 'Buku Tulis'),
(7, 'Novel dan Fiksi');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `IDKARYAWAN` int(11) NOT NULL,
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `ALAMAT` varchar(100) NOT NULL,
  `NOMORTELP` varchar(100) NOT NULL,
  `JABATAN` int(10) NOT NULL,
  `STATUS` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`IDKARYAWAN`, `USERNAME`, `PASSWORD`, `NAMA`, `EMAIL`, `ALAMAT`, `NOMORTELP`, `JABATAN`, `STATUS`) VALUES
(1, 'AndyR', 'AndyR', 'Andy Rivaldo', 'andyrivaldo@gmail.com', 'JL. Jend. Sudirman No. 9, Jakarta', '082191323309', 1, 0),
(2, 'SuhartoYS', 'SuhartoYS', 'Suharto Yandi Sasmita', 'suhartoyandi@gmail.com', 'Jl H Soleh I/1 M, Dki Jakarta', '081992419759', 1, 0),
(3, 'LimXiu', 'LimXiu', 'Limijanti Xiu', 'limxiu1999@gmail.com', 'Jl Dermaga Raya XI 8,Duren Sawit', '085215227911', 0, 0),
(4, 'IndahU', 'IndahU', 'Indah Utami', 'indahutami@gmail.com', 'Jl Lanto Dg Pasewang 25-A 90182', '081285539295', 2, 0),
(5, 'ImanSgr', 'ImanSgr', 'Iman Sugiarto', 'imansugiarto88@gmail.com', 'Jl Hang Tuah 8 A, Jakarta', '085338534457', 2, 0),
(6, 'FannyS', 'FannyS', 'Fanny Shinta Rachman', 'fannyshinta123@gmail.com', 'Jl Pd Bambu Asri Raya 50, Jakarta', '085811392984', 1, 0),
(7, 'AriS', 'AriS', 'Ari Suhendra Tan', 'tansuhendra@gmail.com', 'Jl Kalibaru Brt IV 52 RT 003/012 Kalibaru, Dki Jakarta', '085877081464', 2, 1),
(8, 'JaneG', 'JaneG', 'Jane Gybran', 'janeG123@gmail.com', 'Jl. KH Agus Salim 16, Sabang, Menteng Jakarta Pusat', '081731909015', 0, 0),
(9, 'Ester', 'asd', 'Ester', 'hais@gmail.com', 'asd', '123', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `IDVOUCHER` int(11) NOT NULL,
  `NAMAVOUCHER` varchar(100) NOT NULL,
  `TIPEPOTONGAN` int(11) NOT NULL,
  `JUMLAH` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voucher`
--

INSERT INTO `voucher` (`IDVOUCHER`, `NAMAVOUCHER`, `TIPEPOTONGAN`, `JUMLAH`) VALUES
(0, 'NORMAL', 0, 0),
(1, 'CHRISTMASTEVE', 0, 25),
(2, 'HAPPYCNY', 1, 50000),
(3, 'VALDAYSPECIAL', 0, 14),
(4, 'MAAFLAHIRBATIN', 1, 75000),
(5, 'MERDEKA17', 0, 17),
(6, 'BIRTHDAYSALE', 1, 30000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`IDBARANG`),
  ADD KEY `FK_JENIS` (`FK_JENIS`);

--
-- Indexes for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD KEY `FK_NOTA` (`H_NOMORNOTA`),
  ADD KEY `FK_BARANG` (`FK_BARANG`);

--
-- Indexes for table `htrans`
--
ALTER TABLE `htrans`
  ADD PRIMARY KEY (`NOMORNOTA`),
  ADD KEY `FK_VOUCHER` (`FK_VOUCHER`);

--
-- Indexes for table `jenisbarang`
--
ALTER TABLE `jenisbarang`
  ADD PRIMARY KEY (`IDJENIS`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`IDKARYAWAN`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`IDVOUCHER`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `IDBARANG` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `jenisbarang`
--
ALTER TABLE `jenisbarang`
  MODIFY `IDJENIS` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `IDKARYAWAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `voucher`
--
ALTER TABLE `voucher`
  MODIFY `IDVOUCHER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `FK_JENIS` FOREIGN KEY (`FK_JENIS`) REFERENCES `jenisbarang` (`IDJENIS`);

--
-- Constraints for table `dtrans`
--
ALTER TABLE `dtrans`
  ADD CONSTRAINT `FK_BARANG` FOREIGN KEY (`FK_BARANG`) REFERENCES `barang` (`IDBARANG`),
  ADD CONSTRAINT `FK_NOTA` FOREIGN KEY (`H_NOMORNOTA`) REFERENCES `htrans` (`NOMORNOTA`);

--
-- Constraints for table `htrans`
--
ALTER TABLE `htrans`
  ADD CONSTRAINT `FK_VOUCHER` FOREIGN KEY (`FK_VOUCHER`) REFERENCES `voucher` (`IDVOUCHER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
