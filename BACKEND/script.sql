create database tsangana_p9AndroidBruel960Jacques987;

use tsangana_p9AndroidBruel960Jacques987;

create table educ_user(
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

create table educ_categorie(
    id integer not null,
    desce varchar(200),
    constraint educ_categorie_pk primary key (id)
);

create table educ_cours(
    id integer not null,
    desce varchar(200),
    datepublication timestamp,
    agemin integer not null,
    agemax integer not null,
    idcategorie integer,
    constraint educ_cours_pk primary key (id),
    constraint educ_cours_categ_fk foreign key (idcategorie) references educ_categorie(id)
);

create table educ_coursfille(
    id integer not null,
    desce varchar(200),
    content text,
    idcours integer not null,
    constraint educ_coursfille_pk primary key (id),
    constraint educ_coursfilletype_fk foreign key (idtypecoursfille) references educ_typecoursfille(id)
    constraint educ_fillescours_fk foreign key (idcours) references educ_cours(id)
);

create table educ_etatcours_user(
    id integer not null primary key,
    idcours integer not null,
    isuser integer not null
);


create or replace view educ_coursfille_lib as
select ecf.*, ec.desce as coursdescription, ec.datepublication, ec.agemin, ec.agemax, ec.idcategorie, ect.desce as categoriedescription from educ_coursfille as ecf 
    JOIN educ_cours ec on ecf.idcours = ec.id
    JOIN educ_categorie ect on ec.idcategorie = ect.id
    --LEFT JOIN educ_etatcours_user eeu on eeu.idcours
    ;