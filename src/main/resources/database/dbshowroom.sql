/*
SQLyog Community v12.2.1 (32 bit)
MySQL - 5.0.77-community-nt : Database - dbshowroom
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbshowroom` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dbshowroom`;

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `id_customer` bigint(20) NOT NULL auto_increment,
  `nama_customer` varchar(30) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_by` varchar(30) default NULL,
  `updated_at` datetime default NULL,
  PRIMARY KEY  (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tb_customer` */

insert  into `tb_customer`(`id_customer`,`nama_customer`,`tempat_lahir`,`tanggal_lahir`,`pekerjaan`,`alamat`,`created_by`,`created_at`,`updated_by`,`updated_at`) values 
(1,'Wiwit Setyo Putro','Jakarta','1980-07-17','Swasta','Perum Mustika Wanasari','USER','2018-03-30 14:50:37',NULL,NULL);

/*Table structure for table `tb_harga` */

DROP TABLE IF EXISTS `tb_harga`;

CREATE TABLE `tb_harga` (
  `id_motor` bigint(30) NOT NULL COMMENT 'foreign key ke tabel tb_motor',
  `harga_otr` int(30) NOT NULL,
  `diskon` int(30) default NULL,
  `stok` int(30) NOT NULL default '0',
  `harga_netcash` int(30) NOT NULL,
  `simulasi_kredit` int(30) default NULL,
  PRIMARY KEY  (`id_motor`),
  CONSTRAINT `tb_harga_fk1` FOREIGN KEY (`id_motor`) REFERENCES `tb_motor` (`id_motor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_harga` */

insert  into `tb_harga`(`id_motor`,`harga_otr`,`diskon`,`stok`,`harga_netcash`,`simulasi_kredit`) values 
(3,15205000,NULL,30,14000000,NULL),
(4,15960000,NULL,10,15000000,NULL),
(5,17500000,NULL,10,17000000,NULL),
(6,18900000,NULL,20,18000000,NULL),
(7,24000000,NULL,50,23500000,NULL),
(8,33500000,NULL,70,33000000,NULL),
(9,43600000,NULL,32,43000000,NULL),
(10,36700000,NULL,49,36000000,NULL),
(11,47800000,NULL,19,47000000,NULL),
(12,44300000,NULL,11,42000000,NULL);

/*Table structure for table `tb_motor` */

DROP TABLE IF EXISTS `tb_motor`;

CREATE TABLE `tb_motor` (
  `id_motor` bigint(30) NOT NULL auto_increment COMMENT 'primary key',
  `jenis_motor` varchar(20) NOT NULL COMMENT 'jenis dari motor(bebek, sport, matic)',
  `merek_motor` varchar(50) NOT NULL COMMENT 'merek motor honda',
  `tipe_motor` varchar(50) NOT NULL,
  `url_gambar` varchar(255) default NULL COMMENT 'url untuk gambar motor',
  `deskripsi_motor` varchar(255) default NULL COMMENT 'deskripsi dari motor',
  `transmisi_motor` varchar(10) NOT NULL COMMENT 'automatic atau manual',
  `cc` varchar(10) NOT NULL COMMENT 'jumlah cc motor',
  `tahun` varchar(4) NOT NULL COMMENT 'tahun terbit motor',
  `warna_motor` varchar(20) NOT NULL COMMENT 'warna motor',
  `created_by` varchar(30) NOT NULL COMMENT 'si pembuat',
  `created_at` datetime NOT NULL COMMENT 'tanggal pembuat',
  `updated_by` varchar(30) default NULL COMMENT 'si pengubah',
  `updated_at` datetime default NULL COMMENT 'tanggal diubah',
  PRIMARY KEY  (`id_motor`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `tb_motor` */

insert  into `tb_motor`(`id_motor`,`jenis_motor`,`merek_motor`,`tipe_motor`,`url_gambar`,`deskripsi_motor`,`transmisi_motor`,`cc`,`tahun`,`warna_motor`,`created_by`,`created_at`,`updated_by`,`updated_at`) values 
(3,'MATIC','HONDA','Honda BeAT Streat eSP',NULL,NULL,'AUTOMATIC','110','2017','PUTIH','USER','2018-03-30 17:46:22',NULL,NULL),
(4,'MATIC','HONDA','Honda BeAT Sporty CW',NULL,NULL,'AUTOMATIC','110','2017','PINK','USER','2018-03-30 17:46:22',NULL,NULL),
(5,'MATIC','HONDA','Honda BeAT Sporty CBS',NULL,NULL,'AUTOMATIC','110','2017','HITAM','USER','2018-03-30 17:46:22',NULL,NULL),
(6,'MATIC','HONDA','Honda BeAT Sporty CBS ISS',NULL,NULL,'AUTOMATIC','110','2017','HITAM','USER','2018-03-30 17:46:22',NULL,NULL),
(7,'MATIC','HONDA','Honda BeAT Pop CW Pixel',NULL,NULL,'AUTOMATIC','110','2017','HITAM','USER','2018-03-30 17:46:22',NULL,NULL),
(8,'SPORT','HONDA','Honda CB150R Streetfire',NULL,NULL,'MANUAL','150','2017','MERAH','USER','2018-03-30 17:58:35',NULL,NULL),
(9,'SPORT','HONDA','Honda CB150R Streetfire Special Edition',NULL,NULL,'MANUAL','150','2017','MERAH','USER','2018-03-30 17:58:35',NULL,NULL),
(10,'SPORT','HONDA','All New Honda CB150R Streetfire SRD Red',NULL,NULL,'MANUAL','150','2017','HITAM','USER','2018-03-30 17:58:35',NULL,NULL),
(11,'SPORT','HONDA','All New Honda CBR 150R Facelift 2016 Repsol',NULL,NULL,'MANUAL','150','2017','MERAH','USER','2018-03-30 17:58:35',NULL,NULL),
(12,'SPORT','HONDA','Honda CBR 150R Tri Color',NULL,NULL,'MANUAL','150','2017','MERAH','USER','2018-03-30 17:58:35',NULL,NULL);

/*Table structure for table `tb_register` */

DROP TABLE IF EXISTS `tb_register`;

CREATE TABLE `tb_register` (
  `id_register` bigint(30) NOT NULL auto_increment,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`id_register`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_register` */

/*Table structure for table `tb_sales` */

DROP TABLE IF EXISTS `tb_sales`;

CREATE TABLE `tb_sales` (
  `id_sales` varchar(15) NOT NULL,
  `nama_sales` varchar(30) NOT NULL,
  `usia` int(2) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_by` varchar(30) default NULL,
  `updated_at` datetime default NULL,
  PRIMARY KEY  (`id_sales`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_sales` */

/*Table structure for table `tb_transaksi` */

DROP TABLE IF EXISTS `tb_transaksi`;

CREATE TABLE `tb_transaksi` (
  `id_faktur` varchar(30) NOT NULL,
  `id_sales` varchar(15) default NULL,
  `id_customer` bigint(20) default NULL,
  `id_motor` bigint(30) default NULL,
  `jumlah` int(12) unsigned NOT NULL,
  `total` int(12) unsigned NOT NULL,
  `dibayar` int(12) unsigned NOT NULL,
  `kembali` int(12) NOT NULL default '0',
  `created_by` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_by` varchar(30) default NULL,
  `updated_at` datetime default NULL,
  PRIMARY KEY  (`id_faktur`),
  KEY `id_sales` (`id_sales`),
  KEY `id_customer` (`id_customer`),
  KEY `id_motor` (`id_motor`),
  CONSTRAINT `tb_transaksi_fk2` FOREIGN KEY (`id_sales`) REFERENCES `tb_sales` (`id_sales`),
  CONSTRAINT `tb_transaksi_fk3` FOREIGN KEY (`id_customer`) REFERENCES `tb_customer` (`id_customer`),
  CONSTRAINT `tb_transaksi_fk1` FOREIGN KEY (`id_motor`) REFERENCES `tb_motor` (`id_motor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_transaksi` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
