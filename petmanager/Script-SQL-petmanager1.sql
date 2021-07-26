CREATE DATABASE administracionmascotasbd;

CREATE TABLE tb_doctor(
	id int AUTO_INCREMENT primary key,
	name varchar(150) not null,
	phone varchar(20) not null,
	address varchar(100) not null
)

CREATE TABLE tb_pet(
	id int AUTO_INCREMENT primary key,
	code varchar(3) not null,
	name varchar(50) not null,
	born_year int not null,
	color varchar(20) not null,
	health_status int not null
)

CREATE TABLE tb_cat(
	id int AUTO_INCREMENT primary key,
	breed varchar(30) not null,
	id_pet int not null,
	foreign KEY (id_pet) REFERENCES tb_pet(id)
)

CREATE TABLE tb_dog(
	id int AUTO_INCREMENT primary key,
	breed varchar(30) not null,
	pedigree boolean not null default 0,
	id_pet int not null,
	foreign KEY (id_pet) REFERENCES tb_pet(id)
)

CREATE TABLE tb_hospital(
	id int AUTO_INCREMENT primary key,
	name varchar(50) not null,
	phone varchar(20) not null default 0,
	address varchar(100) not null,
	patien_type int not null,
	id_doctor int not null,
	FOREIGN KEY (id_doctor) REFERENCES tb_doctor(id)
)

CREATE TABLE tb_pet_hospital(
	id int AUTO_INCREMENT primary key,
	id_pet int not null,
	id_hospital int not null,
	FOREIGN KEY (id_pet) REFERENCES tb_pet(id),
	FOREIGN KEY (id_hospital) REFERENCES tb_hospital(id)
)

** PARA REALIZAR OPERACIONES CRUD EN LA BASE DE DATOS
*INSERCION

INSERT INTO tb_doctor (name, phone, address) VALUES ('Jhon Smith','8754848','Transv 34 N 12-34')

INSERT INTO tb_doctor (name, phone, address) VALUES ('Cristina Adams','12345676','Diagonal 78 N 12-09')

INSERT INTO tb_hospital (name, phone, address, patien_type, id_doctor) VALUES ('Hospital Veterinario','6897584','Calle San Juan 12-45',1,2)

INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES ('001','Firulais',2015,'Amarillo','Saludable')

INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES ('002','Tobby',2018,'Negro','Saludable')

INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES ('003','Minino',2020,'Negro y Blanco','Enfermo')


**ahora a insertar los pets como gatos o perros
La mascota con id 1, va a ser un perro con estos datos adicionales

INSERT INTO tb_dog (breed, pedigree, id_pet) VALUES ('Criollo',0,1)

INSERT INTO tb_dog (breed, pedigree, id_pet) VALUES ('Pincher',1,2)

INSERT INTO tb_cat (breed, id_pet) VALUES ('Angora',3)



*SELECCION

SELECT * from tb_pet

SELECT * from tb_doctor

SELECT * from tb_doctor WHERE name = 'Jhon Smith'

SELECT * from tb_hospital


* UPDATE  - acutalizar datos
 
UPDATE tb_doctor set phone = '3158974536', address = 'Carrera 24 N 78-12' WHERE id = 2


* BORRAR DATOS 

DELETE FROM tb_doctor WHERE id = 1



** VER DESDE DOS TABLAS EN CASO UNA MASCOTA COMPLETA

SELECT *
FROM tb_pet as p 
INNER JOIN tb_dog as d on p.id = d.id_pet 

SELECT p.code, p.name, p.born_year, p.color, p.health_status, d.breed, d.pedigree
FROM tb_pet as p 
INNER JOIN tb_dog as d on p.id = d.id_pet 
