USE `fest_db`;

CREATE TABLE `avatar`(
`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
`path` VARCHAR(100) NOT NULL UNIQUE
)ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `user_info`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(70) NOT NULL,
	`surname` VARCHAR(100) NOT NULL,
	`birth_date` DATE NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`phone` VARCHAR(70) NOT NULL
)ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `user` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`info_id` INTEGER ,
	`login` VARCHAR(255) NOT NULL UNIQUE,
	`password` CHAR(10) NOT NULL,
	/*
	 * 0 - (Role.ADMINISTRATOR)
	 * 1 - (Role.MUSICIAN)
	 * 2 - (Role.USER)
	 */
	`role` TINYINT NOT NULL CHECK (`role` IN (0, 1, 2)),
  `avatar_id` INTEGER,
    FOREIGN KEY (`info_id`) REFERENCES `user_info` (`id`)
        ON UPDATE CASCADE
		    ON DELETE CASCADE,
    FOREIGN KEY (`avatar_id`) REFERENCES `avatar`(`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `day` (
`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
`date` DATE NOT NULL UNIQUE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `musician` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`user_id` INTEGER NOT NULL,
	`day_id` INTEGER NOT NULL,
	FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,
    FOREIGN KEY (`day_id`) REFERENCES `day` (`id`)
    ON UPDATE CASCADE
		ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `song` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `musician_id` INTEGER NOT NULL,
	`name` VARCHAR(100) NOT NULL UNIQUE ,
	FOREIGN KEY (`musician_id`) REFERENCES `musician` (`id`)
	ON UPDATE CASCADE
		ON DELETE CASCADE
)ENGINE=INNODB DEFAULT CHARACTER SET utf8;       

CREATE TABLE `ticket` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    /*
 * 0 - (TicketType.VIP)
 * 1 - (TicketType.FAN_ZONE)
 * 2 - (TicketType.DANCE_FLOOR)
 */
    `type` TINYINT NOT NULL CHECK (`type` IN (0, 1, 2)),
	`day_id` INTEGER NOT NULL,
	`price` DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (`day_id`) REFERENCES `day` (`id`)
  ON UPDATE CASCADE
	ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `ticket_user` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`ticket_id` INTEGER NOT NULL,
	`count` TINYINT UNSIGNED NOT NULL,
	`user_id` INTEGER NOT NULL,
	FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;