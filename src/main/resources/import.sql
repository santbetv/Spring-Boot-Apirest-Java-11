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

/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('santiago','$2a$10$HImHMwqG0i37e8wa0aueA.lQfQmUR7x7gvZ7K5Ev0ajTOuhL7rQtq',1, 'santiago', 'betancur', 'santi@hotmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$8fm0xn/rTxCkd4DejTkZLeFECHGcAoMWqLoV7zDLucSQPI.XPoVd.',1, 'Dr. James', 'Gosling', 'james.gosling@gmail.com' );

-- siempre colocar el prefijo ROLE_
INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);



/* Populate tabla productos */
INSERT INTO productos (nombre, precio, fecha) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, fecha) VALUES('Mica Comoda 5 Cajones', 299990, NOW());


/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, fecha) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, fecha) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
