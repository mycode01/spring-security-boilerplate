select 1;

insert into member
(ID, IS_ENABLED, ROLES, UID, UPW, USERNAME)
values
(null, 'Y', 'USER', 'user', '{noop}123', '테스터')
;
insert into member
(ID, IS_ENABLED, ROLES, UID, UPW, USERNAME)
values
(null, 'Y', 'USER;ADMIN', 'admin', '{noop}123', '어드민')
;