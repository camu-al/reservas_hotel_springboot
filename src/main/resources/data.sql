-- Clientes
INSERT INTO cliente (nombre, email) VALUES ('Juan Perez', 'juan@gmail.com');
INSERT INTO cliente (nombre, email) VALUES ('Maria Lopez', 'maria@gmail.com');
INSERT INTO cliente (nombre, email) VALUES ('Carlos Ruiz', 'carlos@gmail.com');

-- Reservas
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-10', '2026-03-15', 150, true, 1);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-20', '2026-03-22', 100, false, 1);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-04-01', '2026-04-05', 200, true, 2);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-12', '2026-03-16', 120, false, 3);