-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 25 Feb 2018 pada 07.21
-- Versi Server: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbshowroom`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `idCustomer` varchar(25) NOT NULL,
  `namaCustomer` varchar(25) NOT NULL,
  `tempatLahir` varchar(25) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`idCustomer`, `namaCustomer`, `tempatLahir`, `tanggalLahir`, `pekerjaan`, `alamat`) VALUES
('C100', 'WIWIT SETYO PUTRO', 'JAKARTA', '1980-07-17', 'SWASTA', 'PERUM MUSTIKA WANASARI BL'),
('C101', 'IRNAWATI', 'PADANG', '1985-04-14', 'SWASTA', 'SODONG I RT.09/12 KEL. CI'),
('C102', 'BUDI SUTRISNO', 'JAKARTA', '1985-01-02', 'TEKNISI', 'KP. PONCOL RT.01/06 KEL. '),
('C103', 'RAGIL', 'JAKARTA', '1987-05-12', 'TELLER', 'ASRAMA HAJI RT. 09/06 KEL'),
('C104', 'SUPRIYADI', 'MALANG', '1974-06-12', 'SURVEYOR', 'PONDOK  MELATI 4 RT.08/02'),
('C105', 'DEWI', 'PURWOKERTO', '1992-06-27', 'WIRAUSAHA', 'TANJUNG KELILING RT.07/04'),
('C106', 'GITO', 'PURWOREJO', '0000-00-00', 'PEDAGANG', 'KP. BULAK RT.05/03 KEL. J'),
('C107', 'KRISTIANTO', 'GOMBONG', '1971-12-13', 'BURUH', 'KP. BOJONG KONENG RT.04/1'),
('C108', 'SAIFUL BAHRI', 'BEKASI', '1983-05-18', 'KURIR', 'KP. PONDOK BENDA RT. 05/0'),
('C109', 'HERI TRIYOGO', 'SEMARANG', '1993-11-30', 'PROGRAMMER', 'MAMPANG PRAPATAN RT. 09/0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kendaraan`
--

CREATE TABLE IF NOT EXISTS `kendaraan` (
  `kdKendaraan` varchar(10) NOT NULL,
  `merek` varchar(20) NOT NULL,
  `stok` int(3) NOT NULL,
  `hargaJual` varchar(15) NOT NULL,
  PRIMARY KEY (`kdKendaraan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kendaraan`
--

INSERT INTO `kendaraan` (`kdKendaraan`, `merek`, `stok`, `hargaJual`) VALUES
('MB201', 'TOYOTA', 125, 'RP. 145.000.000'),
('MB202', 'HONDA', 100, 'RP. 450.000.000'),
('MB203', 'DAIHATSU', 200, 'RP. 150.000.000'),
('MB204', 'ISUZU', 120, 'RP. 200.000.000'),
('MB205', 'MITSUBISHI', 85, 'RP. 175.000.000'),
('MT302', 'HONDA', 400, 'RP. 20.000.000'),
('MT303', 'SUZUKI', 50, 'RP. 15.000.000'),
('MT304', 'KAWASAKI', 75, 'RP. 50.000.000'),
('MT305', 'YAMAHA', 250, 'RP. 25.000.000'),
('MT306', 'VESPA', 160, 'RP. 23.000.000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `idCustomer` varchar(15) NOT NULL,
  `kdKendaraan` varchar(15) NOT NULL,
  `diskon` varchar(15) NOT NULL,
  `bonus` varchar(15) NOT NULL,
  KEY `idCustomer` (`idCustomer`),
  KEY `kdKendaraan` (`kdKendaraan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE IF NOT EXISTS `penjualan` (
  `kdSales` varchar(15) NOT NULL,
  `kdKendaraan` varchar(15) NOT NULL,
  `jumlah` int(2) NOT NULL,
  KEY `kdSales` (`kdSales`),
  KEY `kdKendaraan` (`kdKendaraan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `kdSales` varchar(15) NOT NULL,
  `namaSales` varchar(20) NOT NULL,
  `usia` int(2) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  PRIMARY KEY (`kdSales`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `sales`
--

INSERT INTO `sales` (`kdSales`, `namaSales`, `usia`, `alamat`) VALUES
('S10', 'RIDWAN', 32, 'PONDOK INDAH BLOK C2/34 BEKASI'),
('S11', 'ARI', 45, 'MARGAHAYU RT.02/01 KEL. MARGAH'),
('S12', 'ANTON', 26, 'KAYU RINGIN RT. 04/03 KEL. KAY'),
('S13', 'YANTI', 31, 'JL. KOMPAS RT.08/03 KEL. TAMBU'),
('S14', 'ASWA', 40, 'PERUM. PURI ASIH SEJAHTERA BLO'),
('S15', 'AGUS', 24, 'PERUM. BUMI MUTIARA 7/34 BEKAS'),
('S16', 'AGUSTIN', 29, 'PONDOK MITRA TIMUR BLO 5/4 BEK'),
('S17', 'RIZAL', 25, 'PONDOK UNGU PERMAI RT. 02/02 B'),
('S18', 'ANTO', 30, 'BULAK KAPAL RT.08/02 KEC. BEKA'),
('S19', 'MIRA', 25, 'RAWA LUMBU PERMAI BLOK 5/23 KE');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `kdSales` varchar(10) NOT NULL,
  `idCustomer` varchar(10) NOT NULL,
  `noFaktur` varchar(10) NOT NULL,
  `tanggalFaktur` date NOT NULL,
  KEY `kdSales` (`kdSales`),
  KEY `idCustomer` (`idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`),
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`kdKendaraan`) REFERENCES `kendaraan` (`kdKendaraan`);

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kdSales`) REFERENCES `sales` (`kdSales`),
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kdKendaraan`) REFERENCES `kendaraan` (`kdKendaraan`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`kdSales`) REFERENCES `sales` (`kdSales`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
