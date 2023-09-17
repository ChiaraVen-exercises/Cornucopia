CREATE DATABASE  IF NOT EXISTS `cornucopia`;
USE `cornucopia`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `role` int NOT NULL

  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
