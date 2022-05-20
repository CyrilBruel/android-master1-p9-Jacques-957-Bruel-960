ALTER TABLE upload ADD date_insertion date;

ALTER TABLE upload ADD volume double;

alter table upload add annee_exp double;

alter table coin_paiement add devise varchar(100);

alter table coin_paiement add montant_coin double;