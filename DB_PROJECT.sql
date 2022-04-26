CREATE DATABASE GAED;
USE GAED;

CREATE TABLE producto (
    Id VARCHAR(10) PRIMARY KEY NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Tipo VARCHAR(50) NOT NULL,
    Estado VARCHAR(50) NULL,
    Imagen VARCHAR(50) NULL,
    Precio DOUBLE NOT NULL,
    Consumo INT NOT NULL,
    Fecha VARCHAR(50) NULL,
    Descripcion TEXT NULL,
    Version VARCHAR(10) NOT NULL
);

CREATE TABLE usuario (
    Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    User_Name VARCHAR(50) NULL,
    User_Password VARCHAR(10) NOT NULL,
    Tipo varchar(50) NUll
);

CREATE TABLE cliente (
    Id INT  PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    Email TEXT NOT NULL,
    Clave_Pais VARCHAR(5) NOT NULL,
    Telefono VARCHAR(50) NOT NULL,
    No_Compras INT NOT NULL,
    Direccion TEXT NOT NULL,
    Id_User INT NOT NULL,
    CONSTRAINT fk_iduser_cli FOREIGN KEY (Id_User)
        REFERENCES usuario(Id)
);

CREATE TABLE trabajador(
    Id INT  PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    Telefono VARCHAR(50),
    Email TEXT NOT NULL,
    Id_User INT NOT NULL,
    CONSTRAINT fk_iduser_trab FOREIGN KEY (Id_User)
        REFERENCES usuario (Id)
);

CREATE TABLE reunion (
    Id INT  PRIMARY KEY NOT NULL,
    Descripcion TEXT NOT NULL,
    Fecha VARCHAR(50),
    Hora VARCHAR(20),
    Id_Cli INT NOT NULL,
    Nombre_Cli VARCHAR(150) NOT NULL,
    Tipo VARCHAR(50) NULL,
    CONSTRAINT fk_idcli_reu FOREIGN KEY (Id_Cli)
        REFERENCES cliente (Id)
);

CREATE TABLE venta (
    Id INT  PRIMARY KEY NOT NULL,
    Id_CLI INT NOT NULL,
    Nombre_Cli VARCHAR(150) NOT NULL,
    Direccion_Cli TEXT NOT NULL,
    Total DOUBLE NOT NULL,
    Fecha TEXT NULL,
    Id_TRAB INT NULL,
    Nombre_Trab VARCHAR(150) NULL,
    CONSTRAINT fk_idcli_ven FOREIGN KEY (Id_Cli)
        REFERENCES cliente (Id),
    CONSTRAINT fk_idtrab_ven FOREIGN KEY (Id_Trab)
        REFERENCES trabajador (Id)
);

CREATE TABLE det_venta (
    Id INT  PRIMARY KEY NOT NULL,
    Id_Vent INT NOT NULL,
    Id_Prod VARCHAR(10) NOT NULL,
    Nombre_Prod VARCHAR(100) NOT NULL,
    Precio DOUBLE NOT NULL,
    Descuento DOUBLE NULL,
    Fecha TEXT NULL,
    CONSTRAINT fk_idprod_dvent FOREIGN KEY (Id_Prod)
        REFERENCES producto (Id),
    CONSTRAINT fk_idven_dven FOREIGN KEY (Id_Vent)
        REFERENCES venta (Id)
);

