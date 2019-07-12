USE `fest_db`;
INSERT INTO `user_info`(
`id`,
`name`,
`surname`,
`birth_date`,
`email`,
`phone`
)VALUES (
	1,
	"admin",
    "admin",
    "1980-01-01",
    "festival@gmail.com",
	"+375 (29) 456-78-90"
);
INSERT INTO `user` (
	`id`,
	`info_id`,
	`login`,
	`password`,
	`role`
) VALUES (
	1,
	1,
	"admin",
	"adminadmin", 
	0
);