######### 创建表的sql语句 #####
######### 2020-01-14 #######
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `username` varchar(40) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;