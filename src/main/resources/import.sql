INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (id, username, password) VALUES (1, 'user1','$2a$12$1k34YdrmxBkVborQvZLh2OUvX1S80GVVQjZJ5H55y1eez7XV.nV06'), (2, 'admin','$2a$12$1k34YdrmxBkVborQvZLh2OUvX1S80GVVQjZJ5H55y1eez7XV.nV06');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1), (2, 2); -- admin with ROLE_ADMIN


INSERT INTO usuario (id, dni, nombre, apellidos, direccion, ciudad, telefono) VALUES (1, 12345678, 'Carlos', 'Soto', 'Av. Viva 123', 'Lima', '987654321'), (2, 87654321, 'Maria', 'Leon', 'Jr. Las Rosas 456', 'Lima', '987987987'), (3, 456789132, 'Rodrigo', 'Rodriguez', 'Av. Callao 15', 'Lima', '99955511');

INSERT INTO cine (id, nombre, direccion, distrito, provincia, region, telefono, id_usuario) VALUES (1, 'Cinepolis', 'Av. La Marina 245', 'San Miguel', 'Lima', 'Lima', '987111222', 2), (2, 'Cinemark', 'Av. Independencia 532', 'Miraflores', 'Lima', 'Lima', '987222333', 3);

INSERT INTO pelicula (id, titulo, genero, fecha_estreno, idioma) VALUES (1, 'Avatar 2', 'Ciencia Ficción', '2022-12-16', 'Español'), (2, 'John Wick 4', 'Acción', '2023-03-24', 'Inglés'), (3, 'Encanto', 'Animación', '2021-11-24', 'Español');

INSERT INTO pelicula_cine (pelicula_id, cine_id) VALUES (1, 1), (1, 2), (2, 1), (3, 2);

INSERT INTO sala (id, numero_sala, tipo, capacidad, id_cine) VALUES (1, 1, '2D', 100, 1), (2, 2, '3D', 80, 1), (3, 1, '2D', 120, 2);

INSERT INTO funcion (id, fecha_funcion, hora_salida, id_sala, id_pelicula) VALUES (1, '2025-05-12', '18:00', 1, 1), (2, '2025-05-12', '20:30', 2, 2), (3, '2025-05-13', '17:00', 3, 3);

INSERT INTO entrada (id, precio, num_asiento, id_funcion) VALUES (1, 18.00, 10, 1), (2, 18.00, 11, 1), (3, 20.00, 5, 2), (4, 15.00, 1, 3);
