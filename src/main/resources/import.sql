-- Archivo: src/test/resources/import.sql
INSERT INTO categoria (nombre, descripcion) VALUES
    ('Tecnología', 'Dispositivos electrónicos y equipos de computación'),
    ('Hogar', 'Electrodomésticos y artículos para el hogar'),
    ('Deportes', 'Artículos deportivos y calzado para actividad física'),
    ('Libros', 'Libros físicos y digitales de diversos géneros'),
    ('Belleza', 'Productos de cuidado personal y cosméticos');

INSERT INTO producto (nombre, precio, stock, descripcion, categoria_id,deleted) VALUES
    ('Laptop HP Pavilion', 899.99, 15, 'Laptop con 8GB RAM y SSD 256GB', 1,true),
    ('Smartphone Samsung Galaxy S21', 749.50, 30, 'Pantalla AMOLED 6.2 pulgadas', 1,false),
    ('Auriculares Sony WH-1000XM4', 349.99, 25, 'Cancelación de ruido premium',1,false),
    ('Libro Cien años de soledad', 19.99, 50, 'Edición especial tapa dura', 4,false),
    ('Zapatillas Nike Air Max', 129.95, 40, 'Talla 42, color blanco', 3,false),
    ('Cafetera Nespresso Essenza', 99.00, 20, 'Compacta y automática', 2,false),
    ('Mochila The North Face', 79.99, 35, 'Resistente al agua, 30L', 3,false),
    ('Teclado Mecánico Logitech G Pro', 149.99, 18, 'Switches Cherry MX Red', 1,false),
    ('Set de Lego Star Wars', 59.95, 12, 'Millennium Falcon edición coleccionista', 1,false),
    ('Crema Hidratante Cerave', 12.49, 60, 'Para pieles sensibles, 473ml', 5,false);

INSERT INTO usuario (username, pass, mail) VALUES
    ('jperez', '$2a$10$xJwL5vGZ/5UeB7zq5WQY.e5z4dLk9Xb0rJ3Vc2sQhYbW1nKvLmNOP', 'juan.perez@example.com'),
    ('mgomez', '$2a$10$YH6Zc7r8q9S0T1uV2w3Xe.y4z5A6B7C8D9E0F1G2H3I4J5K6L7M', 'maria.gomez@correo.com'),
    ('admin', '$2a$10$ZzYyXxWwVvUuTtSsRrQqP.OsNlMkIjOhPpQqRrSsTtUuVvWwXxYyZ', 'admin@sistema.com'),
    ('lrodriguez', '$2a$10$AaBbCcDdEeFfGgHhIiJjKk.LlMmNnOoPpQqRrSsTtUuVvWwXxYyZ', 'laura.rodri@mail.org'),
    ('tester1', '$2a$10$1q2w3e4r5t6y7u8i9o0pA.BcDeFgHiJkLmNoPqRsTuVwXyZzAaBbC', 'tester@qa.test');

INSERT INTO carrito (FECHA_CREACION , estado,usuario_id) VALUES
    ('2024-06-01 10:00:00',0,1),
    ('2024-06-02 15:30:00',0,2),
    ('2024-06-03 09:15:00',0,3);

INSERT INTO item(cantidad ,precio, carrito_id,producto_id,tipo) VALUES
    (10,100,1,1,'carrito'),
    (10,100,2,2,'carrito'),
    (10,100,1,3,'carrito');
INSERT INTO pedido (FECHA_CREACION , estado,usuario_id) VALUES
    ('2024-06-01 10:00:00',0,1),
    ('2024-06-02 15:30:00',1,1),
    ('2024-06-03 09:15:00',2,1);
INSERT INTO item(cantidad,precio , pedido_id,producto_id,tipo) VALUES
    (20,100,1,1,'pedido'),
    (20,100,2,2,'pedido'),
    (20,100,1,3,'pedido');