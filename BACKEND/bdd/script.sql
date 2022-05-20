create database tsangana_webcup2022;
use tsangana_webcup2022;

DROP TABLE user_offre;
DROP TABLE upload;
DROP TABLE user;
DROP TABLE offre;
DROP TABLE emplacement;
DROP TABLE coin_paiement;
DROP TABLE devise;

create table user(
    id integer not null AUTO_INCREMENT,
    nom varchar(100) not null,
    prenom varchar(100),
    age integer,
    sexe varchar(20),
    mot_de_passe varchar(100) not null,
    username varchar(50),
    profil varchar(50), 
    constraint user_pk primary key (id)
)engine=innodb;
-- 
-- create table offre(
--    id integer not null AUTO_INCREMENT,	
--    nom varchar(100) not null,	
--    duree int not null,	
--    jetons int not null,
--    quantite_fichier int not null,
--    constraint offre_pk primary key (id)
-- )engine=innodb;


-- 
create table emplacement(
   id integer not null AUTO_INCREMENT,	
   nom varchar(100) not null,	
   image varchar(200),
   constraint emplacement_pk primary key (id)
)engine=innodb;
-- 
create table user_offre(
   id integer not null AUTO_INCREMENT,	
   id_user integer not null,	
   volume double,
   duree double,
   date_achat date,
   constraint user_offre_pk primary key (id),
   constraint user_fk foreign key (id_user) references user(id)
)engine=innodb;
-- 
create table upload(
   id integer not null AUTO_INCREMENT,	
   id_user integer not null,	
   lien_fichier varchar(500),
   id_emplacement integer not null,
   code_access varchar(100),
   is_visible int default 0,
   type varchar(100),
   message text,
   constraint upload_pk primary key (id),
   constraint user_fk1 foreign key (id_user) references user(id),
   constraint emplacement_fk foreign key (id_emplacement) references emplacement(id)
)engine=innodb;

create table coin_paiement(
   id integer not null AUTO_INCREMENT,	
   numero_compte varchar(100) not null,	
   montant double,
   etat int,
   constraint coin_paiement_pk primary key (id)
)engine=innodb;

create table devise(
   id integer not null AUTO_INCREMENT,
   description varchar(50),
   valeur double not null,
   date_change date,
   constraint devise_pk primary key (id)
)engine=innodb;

create table offre(
   id integer not null AUTO_INCREMENT,	
   nom varchar(100) not null,	
   duree_min double,
   duree_max double,
   volume_min double,
   volume_max double,
   valeur_coin double,
   constraint offre_pk primary key (id)
)engine=innodb;



