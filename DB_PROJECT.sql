CREATE DATABASE GAED;
USE GAED;

CREATE TABLE PRODUCTO(
Id varchar(10) primary key not null,
Nombre varchar(100) not null,
Tipo varchar(50)not null,
Estado varchar(50)null,
Precio numeric not null,
Consumo int not null,    
Fecha date null,
Descripcion text null,
Version varchar(10) not null
);

CREATE TABLE USUARIO(
Id int AUTO_INCREMENT primary key not null,
UserName varchar(50)null,
UserPassword varchar(10)not null
);

CREATE TABLE CLIENTE(
Id int AUTO_INCREMENT PRIMARY KEY not null,
Nombre varchar(50) not null,
Apellidos varchar(100) not null,
eMail text not null,
ClavePais varchar(5) not null,
Telefono varchar(50) not null,
NoCompras int not null,
Direccion text not null,
IdUser int  not null,
CONSTRAINT fk_iduser_cli foreign key (IdUser) references USUARIO(Id)
);

CREATE TABLE TRABAJADOR(
Id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
Nombre varchar(50) not null,
Apellidos varchar(100) not null,
Telefono varchar(50),
eMail text not null,
IdUser int not null,
CONSTRAINT fk_iduser_trab foreign key (IdUser) references USUARIO(Id)
);

CREATE TABLE REUNION(
Id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
Descripcion text not null,
Fecha date,
Hora Time,
IdCli int not null,
NombreCli varchar(150) not null,
Tipo varchar(50) null,
CONSTRAINT fk_idcli_reu foreign key (IdCli) references CLIENTE(Id)
);

CREATE TABLE VENTA(
Id int auto_increment primary key not null,
IdCLI int not null,
NombreCli varchar(150) not null,
DireccionCli text not null,
Total numeric not null,
Fecha datetime null,
IdTRAB int null,
NombreTrab varchar(150) null,
CONSTRAINT fk_idcli_ven foreign key (IdCli) references CLIENTE(Id),
CONSTRAINT fk_idtrab_ven foreign key (IdTrab) references TRABAJADOR(Id)
);

CREATE TABLE DET_VENTA(
Id int auto_increment primary key not null,
IdVENT int not null,
IdPROD VARCHAR(10) not null,
NombreProd varchar(100) not null,
Precio numeric not null,
descuento numeric null,
Fecha datetime null,
CONSTRAINT fk_idprod_dvent foreign key (IdPROD) references PRODUCTO(Id),
CONSTRAINT fk_idven_dven foreign key (IdVENT) references VENTA(Id)
);



