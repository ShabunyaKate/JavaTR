USE `fest_db`;

INSERT INTO `user_info`
( `id`,  `name`, `surname`, `birth_date`,`email`, `phone`)
VALUES 
(2,"group","LB","2000-02-15","littlebig@gmail.com","+375 (29) 123-45-67"),
(3,"Liza","Monetochka","1998-04-16","monetochka@gmail.com"," +375 (29) 234-56-78"),
(4,"Ivan","Ivanov","1997-01-01","ivanov@gmail.com"," +375 (29) 111-11-11"),
(5,"Misha","Sidorov","1995-11-12","msidorov@gmail.com"," +375 (29) 222-22-22"),
(6,"Liza","Luna","1995-10-13","luna13@gmail.com"," +375 (29) 333-33-33"),
(7,"Sara","Pizza","1995-05-01","sarapizza@gmail.com"," +375 (29) 444-44-44");

INSERT INTO `user` 
(`id`,`info_id`,`login`,`password`,`role`,`avatar_id`)
VALUES
(2,       NULL,    "Little_Big",   "1234567890",   1,1),
(3,       NULL,     "Монеточка",   "2345678901",   1,2),
(4,       4,     "IVAN",   "3456789012",       2,3),
(5,       5,     "Misha_Sidor",   "4567890123",2,4),
(6,       6,      "Luna1",   "5678901234",    2,5),
(7,       7,      "Pizza",   "6789012345",    2,2);
INSERT INTO `day`
(`id`, `date`)
VALUES
(1,"2019-08-01"),
(2,"2019-08-02");

INSERT INTO `musician`
(`id`, `user_id`,`day_id`)
VALUES
(1,  2  , 1),
(2,  3  , 2);

INSERT INTO `song`
(`id`, `musician_id`,  `name`)
VALUES
(1,  1  , "Hateful love"),
(2,  1  , "ToParty"),
(3,  1  , "LollyBomb"),
(4,  2  , "Каждый раз"),
(5,  2  , "90"),
(6,  2  , "Последняя дискотека");

INSERT INTO `ticket`
 (`id`, `type`,`day_id`, `price`)
VALUES
(1,0,1,900.00),
(2,1,1,500.00),
(3,2,1,299.99),
(4,0,2,800.00),
(5,1,2,400.00),
(6,2,2,159.99);

INSERT INTO `ticket_user`
 (`id`,`ticket_id`,`count`,`user_id`)
VALUES
(1,3,1,4),
(2,6,3,5),
(3,1,2,6),
(4,4,2,6),
(5,2,3,7);
