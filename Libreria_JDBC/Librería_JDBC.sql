CREATE DATABASE libreria_JDBC;

USE libreria_JDBC;

CREATE TABLE autor(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    nombre varchar(45) NOT NULL, 
    nacionalidad varchar(45) NOT NULL
);

CREATE TABLE libros(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titulo varchar(45) NOT NULL, 
    año_publicacion DATE, 
    precio DOUBLE, 
    id_autor INT, 
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

SELECT * FROM libros;