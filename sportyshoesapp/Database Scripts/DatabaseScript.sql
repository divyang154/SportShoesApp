CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `product_tb` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` bigint(20) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKlk6cb61ugnvhh88nbdj9eodus` (`category_id`),
  CONSTRAINT `FKlk6cb61ugnvhh88nbdj9eodus` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user_tb` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `purchase_tb` (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `date_of_purchase` date DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  PRIMARY KEY (`purchase_id`),
  KEY `FKfkg44avrionh3abcyj8au9h1m` (`user_id`),
  CONSTRAINT `FKfkg44avrionh3abcyj8au9h1m` FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `product_tb_purchase` (
  `products_product_id` int(11) NOT NULL,
  `purchase_purchase_id` int(11) NOT NULL,
  PRIMARY KEY (`products_product_id`,`purchase_purchase_id`),
  KEY `FK1art154rx18i739x4sbpsd7c5` (`purchase_purchase_id`),
  CONSTRAINT `FK1art154rx18i739x4sbpsd7c5` FOREIGN KEY (`purchase_purchase_id`) REFERENCES `purchase_tb` (`purchase_id`),
  CONSTRAINT `FKi3qnk97fcqo96tdweh67r2402` FOREIGN KEY (`products_product_id`) REFERENCES `product_tb` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `purchase_tb_product` (
  `purchase_purchase_id` int(11) NOT NULL,
  `product_product_id` int(11) NOT NULL,
  PRIMARY KEY (`purchase_purchase_id`,`product_product_id`),
  KEY `FKe79p7l88k3xsxfhp0rf95xqd1` (`product_product_id`),
  CONSTRAINT `FK28e59jvnyslxjntkxy8ibdm0k` FOREIGN KEY (`purchase_purchase_id`) REFERENCES `purchase_tb` (`purchase_id`),
  CONSTRAINT `FKe79p7l88k3xsxfhp0rf95xqd1` FOREIGN KEY (`product_product_id`) REFERENCES `product_tb` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_tb_purchase_list` (
  `user_user_id` int(11) NOT NULL,
  `purchase_list_purchase_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_id`,`purchase_list_purchase_id`),
  UNIQUE KEY `UK_b729102p2w0k59llw8d5a4o2a` (`purchase_list_purchase_id`),
  CONSTRAINT `FKhtcd9uvku4855euwoojsvpb` FOREIGN KEY (`purchase_list_purchase_id`) REFERENCES `purchase_tb` (`purchase_id`),
  CONSTRAINT `FKlwlm4umnkanevcnu4cdmxa6rm` FOREIGN KEY (`user_user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user_tb` (`user_id`,`created_by`,`created_on`,`password`,`updated_by`,`updated_on`,`user_email`,`user_role`,`username`) VALUES (9,NULL,'2020-12-17 13:15:38','admission',NULL,'2020-12-17 13:15:38','acharyadivyang789@gmail.com','Administrator','flyadmin');


