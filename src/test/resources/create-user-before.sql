delete
from user_role;
delete
from usr;

insert into usr(id, active, password, username)
values (1, true, '$2a$08$01csGQpHxu5V2Eh0XWyERugc4ld0nOsTuJsfNUcYoTJ8DKJg6FsD6', 'admin'),
       (2, true, '$2a$08$Suxbi6/5ncvv/1Q7bsY62O4QRA4dskUOsFDnwxYSe.ZjkZ.DmVQKy', 'roller');

insert into user_role(user_id, role)
values (1, 'USER'),
       (1, 'ADMIN'),
       (2, 'USER');