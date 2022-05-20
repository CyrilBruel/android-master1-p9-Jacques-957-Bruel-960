create database tsangana_webcup2022;
use tsangana_webcup2022;

DROP TABLE token;
DROP TABLE user;
DROP TABLE profile;

create table profile(
    id integer not null,
    description varchar(200),
    constraint profile_pk primary key (id)
)engine=innodb;

INSERT INTO PROFILE VALUES ('1', 'Administrator');
INSERT INTO PROFILE VALUES ('2', 'User');

create table user(
    id integer not null AUTO_INCREMENT,
    name varchar(100) not null,
    firstname varchar(100),
    username varchar(100) not null,
    password varchar(100) not null,
    constraint user_pk primary key (id)
)engine=innodb;

create table token(
    id integer not null AUTO_INCREMENT,
    id_user integer not null,
    token varchar(100) not null,
    expiration timestamp not null,
    constraint token_pk primary key (id),
    constraint token_user_fk foreign key (id_user) references user(id)
)engine=innodb;