
-- Create Admin
INSERT INTO `rostam`.`user`
(`user_id`,`username`,`password`,`status`)
VALUES
(1,'mosi','1234',1);

INSERT INTO `rostam`.`role`
(`role_id`,`role`,`user_user_id`)
VALUES
(1,'admin',1);
--------------------------------------------