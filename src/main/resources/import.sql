-- Por defecto Spring data jpa o mejor Hibernate lo ejecuta
-- INSERT INTO clientes (nombre, apellido, email, fecha) VALUES('santiago1', 'betancur','santiago1@hotmail.com', NOW());

INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(1, 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(4, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(4, 'Erich', 'Gamma', 'erich.gamma@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(3, 'John', 'Vlissides', 'john.vlissides@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(3, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(5, 'Magma', 'Lee', 'magma.lee@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(6, 'Tornado', 'Roe', 'tornado.roe@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, fecha) VALUES(7, 'Jade', 'Doe', 'jane.doe@gmail.com', NOW());
