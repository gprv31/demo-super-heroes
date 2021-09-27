-- User: admin , pass: admin
insert into Usuario(user_name, encrypted_password)
values ('admin','$2a$10$wgSabwrLSluanBZNCiXZZ.IMKCtm5PddsIwL9evYqDEdYm/LyBwlS');


insert into Hero(nickname, enabled, creation_date)
values
('SUPERMAN',0, CURRENT_TIMESTAMP()),
('SPIDERMAN',0, CURRENT_TIMESTAMP()),
('THOR',1, CURRENT_TIMESTAMP()),
('IRON MAN',1, CURRENT_TIMESTAMP()),
('lololo',1, CURRENT_TIMESTAMP());
