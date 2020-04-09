create Database if not exists TorneoMotos;
use TorneoMotos;

CREATE USER if not exists 'proyectofinal'@'%' IDENTIFIED BY 'Ageofempires2';
GRANT ALL ON TorneoMotos.* TO 'proyectofinal'@'%';

create table if not exists piloto ( 
DNI varchar(32) not null , 
nombre varchar(32) not null,
apellido varchar(32) not null,
edad int,
peso float,
sexo varchar(32),
altura float,

primary key (DNI)
);

create table if not exists multimedia_piloto ( 
piloto varchar(32) not null,
fotoPerfil varchar(100),
fotoGeneral varchar(100),

primary key (piloto),
foreign key (piloto) references piloto(DNI)
);

INSERT INTO piloto VALUES ( '43473749T', 'Alvaro', 'DelCampo', 20, 115.4, 'Hombre', 1.95);

create table if not exists motocicleta ( 
MATRICULA varchar(32) not null , 
marca varchar(32) not null,
tuboEscape varchar(32) not null,

primary key (MATRICULA)
);

create table if not exists multimedia_motocicleta ( 
motocicleta varchar(32) not null ,
fotoFrente varchar(100),
fotoPerfil varchar(100),
fotoTrasera varchar(100),

primary key (motocicleta),
foreign key (motocicleta) references motocicleta(MATRICULA)
);

INSERT INTO motocicleta VALUES ( '8565BVV', 'Cagiva', 'Mivv');

create table if not exists circuito ( 
ID int not null auto_increment, 
localidad varchar(32) not null,
distancia int not null,
recta int,

primary key (ID)
);

create table if not exists multimedia_circuito ( 
circuito int not null auto_increment,
fotoZenital varchar(100),

primary key (circuito),
foreign key (circuito) references circuito(ID)
);

INSERT INTO circuito (localidad,distancia,recta) VALUES ( 'Llucamajor', 3200, 623);

create table if not exists torneo ( 
ID int not null auto_increment, 
rondas int not null,
id_circuito int not null,
nombre varchar(32) not null,

primary key (ID),
foreign key (id_circuito) references circuito(ID)
);

INSERT INTO torneo (rondas,id_circuito,nombre) VALUES ( 8, 1,'prueba');

create table if not exists carrera ( 
ID int not null auto_increment, 
id_torneo int not null,
nivel varchar(32) not null,
posicion varchar(32) not null,

primary key (ID),
foreign key (id_torneo) references torneo(ID)
);

INSERT INTO carrera (id_torneo,nivel,posicion) VALUES (1,'final', 'primera');

create table if not exists participacion (
ID int not null auto_increment,
id_moto varchar(32) not null,
id_piloto varchar(32) not null,
id_carrera int not null,
mejorVuelta float not null,

primary key (ID),
foreign key (id_moto) references motocicleta(MATRICULA),
foreign key (id_piloto) references piloto(DNI),
foreign key (id_carrera) references carrera(ID)
);

INSERT INTO participacion (id_moto,id_piloto,id_carrera,mejorVuelta) VALUES ("8565BVV",'43473749T',1,58.57);














/*funcionalidad:
una pagina con los records de cada circuito con su piloto
una pagina con los 3 que mantien el mejor record que se tenga en la base de datos, con que motos y que tiempoos*/