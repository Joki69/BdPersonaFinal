CREATE TABLE arcana (
id_arcana serial,
nombre varchar(1000),
PRIMARY KEY(id_arcana));


CREATE TABLE persona (
id_persona serial,
id_arcana integer,
nombre_arcana varchar(1000),
nombre_persona text,
historia text,
PRIMARY KEY(id_persona),
   CONSTRAINT fk_arcana
      FOREIGN KEY(id_arcana) 
	  REFERENCES arcana(id_arcana)
);

