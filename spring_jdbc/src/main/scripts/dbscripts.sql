--mysql
use customerdb;

CREATE TABLE `Consumer` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `Address` (
  `id` int(11) unsigned NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);