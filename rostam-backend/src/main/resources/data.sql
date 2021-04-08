

INSERT INTO `rostam`.`user`(`user_id`,`password`,`status`,`username`)
VALUES
(1,'$2a$10$tYFV51dGOa.9di6b4kMyq.nDhKx5E21UthK.DOKwkoI48o6qKphsG',1,'mosi');

INSERT INTO `rostam`.`role`(`role_id`,`role`,`user_user_id`)
VALUES
(1,'role_admin',1);

INSERT INTO `rostam`.`user`(`user_id`,`password`,`status`,`username`)
VALUES
(2,'$2a$10$tYFV51dGOa.9di6b4kMyq.nDhKx5E21UthK.DOKwkoI48o6qKphsG',1,'mamad');

INSERT INTO `rostam`.`role`(`role_id`,`role`,`user_user_id`)
VALUES
(2,'role_user',2);
