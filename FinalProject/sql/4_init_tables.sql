USE `fest_db`;
INSERT INTO `avatar`
(`id`,`path`)
VALUES
(1,"img/avatar/boy.jpg"),
(2,"img/avatar/girl.jpg"),
(3,"img/avatar/bird.jpg"),
(4,"img/avatar/cat.jpg"),
(5,"img/avatar/dog.jpg");


INSERT INTO `user` (
	`id`,
	`info_id`,
	`login`,
	`password`,
	`role`,
   `avatar_id`
) VALUES (
	1,
	NULL,
	"admin",
	"admin",
	0,
   1
);