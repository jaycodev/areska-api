SET search_path TO public;

BEGIN;

INSERT INTO categories (name, description) VALUES
('Ratones Gaming', 'Ratones de alta precisión y respuesta rápida para juegos.'),
('Teclados Mecánicos', 'Teclados con interruptores mecánicos para una respuesta táctil y sonora.'),
('Auriculares Gaming', 'Auriculares con sonido envolvente y micrófono de calidad para la comunicación en equipo.'),
('Mousepads Extensos', 'Alfombrillas de gran tamaño con superficies optimizadas para la precisión del ratón.'),
('Controles y Gamepads', 'Mandos de juego para PC y consolas.'),
('Webcams Gaming', 'Cámaras de alta definición para streaming y videollamadas.'),
('Micrófonos USB', 'Micrófonos de condensador o dinámicos para streaming y grabación.'),
('Accesorios de Teclado', 'Keycaps, switches y herramientas de mantenimiento para teclados.'),
('Sillas Gaming', 'Sillas ergonómicas diseñadas para largas sesiones de juego.'),
('Monitores Gaming', 'Monitores con altas tasas de refresco y bajos tiempos de respuesta.'),
('Teclados TKL', 'Teclados sin la sección numérica (Tenkeyless).'),
('Ratones Inalámbricos', 'Ratones sin cable con baja latencia.'),
('Auriculares Inalámbricos', 'Headsets sin cables para mayor libertad de movimiento.'),
('Alfombrillas de Control', 'Mousepads enfocados en la precisión y el control.'),
('Alfombrillas de Velocidad', 'Mousepads con superficies lisas para movimientos rápidos.'),
('Switches Mecánicos', 'Interruptores individuales para personalización de teclados.'),
('Keycaps Personalizadas', 'Juegos de tapas de teclas con diseños únicos.'),
('Estaciones de Carga', 'Bases de carga para periféricos inalámbricos.'),
('Bungees para Ratón', 'Soportes de cable para ratones con cable.'),
('Streaming Decks', 'Controladores de botones programables para streamers.');

INSERT INTO users (first_name, last_name, email, password, phone, address) VALUES
('Alejandro', 'Vargas', 'alejandro.vargas@mail.com', 'hashedpass1', '555-1001', 'Av. Gamer 123, Ciudad A'),
('Belen', 'Quiroga', 'belen.quiroga@mail.com', 'hashedpass2', '555-1002', 'Calle RGB 45, Ciudad B'),
('Carlos', 'Molina', 'carlos.molina@mail.com', 'hashedpass3', '555-1003', 'Jirón Pixel 678, Ciudad C'),
('Daniela', 'Flores', 'daniela.flores@mail.com', 'hashedpass4', '555-1004', 'Pasaje E-Sports 90, Ciudad D'),
('Emilio', 'Gutiérrez', 'emilio.gutierrez@mail.com', 'hashedpass5', '555-1005', 'Av. Latencia 101, Ciudad A'),
('Fernanda', 'Herrera', 'fernanda.herrera@mail.com', 'hashedpass6', '555-1006', 'Calle Overclock 202, Ciudad B'),
('Gabriel', 'Ibarra', 'gabriel.ibarra@mail.com', 'hashedpass7', '555-1007', 'Jirón FPS 303, Ciudad C'),
('Hilda', 'Jara', 'hilda.jara@mail.com', 'hashedpass8', '555-1008', 'Pasaje Headshot 404, Ciudad D'),
('Ignacio', 'Kozak', 'ignacio.kozak@mail.com', 'hashedpass9', '555-1009', 'Av. Píxeles 505, Ciudad A'),
('Julieta', 'López', 'julieta.lopez@mail.com', 'hashedpass10', '555-1010', 'Calle Comandos 606, Ciudad B'),
('Kevin', 'Mendoza', 'kevin.mendoza@mail.com', 'hashedpass11', '555-1011', 'Jirón Táctico 707, Ciudad C'),
('Laura', 'Núñez', 'laura.nunez@mail.com', 'hashedpass12', '555-1012', 'Pasaje Estrategia 808, Ciudad D'),
('Mario', 'Ortiz', 'mario.ortiz@mail.com', 'hashedpass13', '555-1013', 'Av. Vsync 909, Ciudad A'),
('Natalia', 'Pérez', 'natalia.perez@mail.com', 'hashedpass14', '555-1014', 'Calle 4K 1010, Ciudad B'),
('Óscar', 'Quispe', 'oscar.quispe@mail.com', 'hashedpass15', '555-1015', 'Jirón RayTracing 111, Ciudad C'),
('Patricia', 'Ramírez', 'patricia.ramirez@mail.com', 'hashedpass16', '555-1016', 'Pasaje LatenciaCero 1212, Ciudad D'),
('Ricardo', 'Soto', 'ricardo.soto@mail.com', 'hashedpass17', '555-1017', 'Av. Streamer 1313, Ciudad A'),
('Sofía', 'Torres', 'sofia.torres@mail.com', 'hashedpass18', '555-1018', 'Calle Console 1414, Ciudad B'),
('Tomas', 'Urbina', 'tomas.urbina@mail.com', 'hashedpass19', '555-1019', 'Jirón Multiplayer 1515, Ciudad C'),
('Valeria', 'Vidal', 'valeria.vidal@mail.com', 'hashedpass20', '555-1020', 'Pasaje Coop 1616, Ciudad D');

INSERT INTO products (name, description, price, stock, category_id) VALUES
('Mouse Razer DeathAdder V3 Pro', 'Ratón inalámbrico ultraligero, sensor Focus Pro 30K.', 149.99, 50, 1),
('Mouse Logitech G502 X Plus', 'Ratón inalámbrico LIGHTSPEED, sensor HERO 25K, 13 botones.', 159.99, 45, 1),
('Mouse SteelSeries Aerox 3 Wireless', 'Ratón inalámbrico súper ligero (68g) con protección AquaBarrier.', 79.99, 60, 1),
('Teclado Corsair K100 RGB', 'Teclado óptico-mecánico, switches OPX, reposamuñecas de espuma.', 229.99, 30, 2),
('Teclado Razer Huntsman Mini', 'Teclado 60% óptico, switches Razer Clicky.', 119.99, 55, 2),
('Teclado Logitech G Pro X TKL', 'Teclado TKL, switches intercambiables GX, sin sección numérica.', 179.99, 40, 2),
('Auriculares HyperX Cloud Alpha S', 'Headset con sonido envolvente 7.1, control de bajos ajustable.', 99.99, 70, 3),
('Auriculares SteelSeries Arctis Nova Pro', 'Headset inalámbrico Multi-Sistema, Cancelación de ruido activa.', 349.99, 25, 3),
('Auriculares Razer BlackShark V2 Pro', 'Headset inalámbrico de esports, micrófono cardioide HyperClear.', 179.99, 35, 3),
('Mousepad Glorious XXXL', 'Alfombrilla extra grande (120x60cm), superficie de tela.', 49.99, 80, 4),
('Mousepad Artisan Hayate Otsu XL', 'Alfombrilla híbrida de velocidad y control, base de Poron.', 79.99, 20, 4),
('Control Xbox Elite Series 2', 'Controlador profesional inalámbrico con componentes intercambiables.', 179.99, 30, 5),
('Webcam Logitech StreamCam', 'Webcam Full HD 1080p a 60 fps, enfoque automático.', 149.99, 40, 6),
('Micrófono Blue Yeti X', 'Micrófono USB de condensador con cuatro patrones polares.', 169.99, 35, 7),
('Teclado HyperX Alloy Origins Core', 'Teclado TKL, switches mecánicos HyperX Red.', 99.99, 50, 11),
('Mouse Glorious Model O Wireless', 'Ratón inalámbrico honeycomb ultraligero (69g).', 79.99, 60, 12),
('Auriculares Astro A50 Wireless + Base', 'Headset inalámbrico con estación base MixAmp, sonido envolvente.', 299.99, 20, 13),
('Mousepad ZOWIE G-SR-SE DEEP BLUE', 'Alfombrilla de control, superficie suave, base de goma.', 39.99, 75, 14),
('Switches Cherry MX Red (Pack x100)', 'Switches lineales y silenciosos, para teclados mecánicos.', 49.99, 90, 16),
('Elgato Stream Deck MK.2', 'Controlador de 15 teclas LCD programables para streaming.', 149.99, 30, 20);

INSERT INTO orders (user_id, order_date, status, total, pickup_method) VALUES
(1, '2024-09-01 10:00:00', 'completed', 379.97, 'shipping'), -- Alejandro: Mouse + Teclado Razer
(2, '2024-09-02 11:30:00', 'completed', 99.99, 'store'),    -- Belen: Auriculares HyperX
(3, '2024-09-03 14:45:00', 'pending', 389.98, 'shipping'), -- Carlos: Teclado Corsair + Mousepad Glorious
(4, '2024-09-04 16:00:00', 'completed', 159.99, 'store'),    -- Daniela: Mouse Logitech
(5, '2024-09-05 09:15:00', 'completed', 179.99, 'shipping'), -- Emilio: Auriculares Razer
(6, '2024-09-06 12:00:00', 'completed', 229.99, 'store'),    -- Fernanda: Teclado Corsair
(7, '2024-09-07 15:30:00', 'pending', 79.99, 'shipping'), -- Gabriel: Mouse SteelSeries
(8, '2024-09-08 17:00:00', 'completed', 179.99, 'store'),    -- Hilda: Control Xbox
(9, '2024-09-09 10:45:00', 'completed', 149.99, 'shipping'), -- Ignacio: Webcam Logitech
(10, '2024-09-10 13:00:00', 'completed', 169.99, 'store'),    -- Julieta: Micrófono Blue Yeti
(11, '2024-09-11 15:15:00', 'shipped', 99.99, 'shipping'), -- Kevin: Teclado HyperX TKL
(12, '2024-09-12 11:00:00', 'completed', 79.99, 'store'),    -- Laura: Mouse Glorious
(13, '2024-09-13 14:00:00', 'completed', 299.99, 'shipping'), -- Mario: Auriculares Astro
(14, '2024-09-14 16:30:00', 'completed', 39.99, 'store'),    -- Natalia: Mousepad ZOWIE
(15, '2024-09-15 10:00:00', 'completed', 49.99, 'shipping'), -- Óscar: Switches Cherry
(16, '2024-09-16 11:45:00', 'pending', 149.99, 'store'),    -- Patricia: Elgato Stream Deck
(17, '2024-09-17 13:30:00', 'completed', 119.99, 'shipping'), -- Ricardo: Teclado Razer Mini
(18, '2024-09-18 15:00:00', 'shipped', 349.99, 'store'),    -- Sofía: Auriculares SteelSeries Nova Pro
(19, '2024-09-19 16:45:00', 'completed', 149.99, 'shipping'), -- Tomas: Mouse Razer DeathAdder
(20, '2024-09-20 18:00:00', 'completed', 79.99, 'store');    -- Valeria: Mousepad Artisan

INSERT INTO order_details (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 149.99),  -- Alejandro: Mouse Razer DeathAdder
(1, 5, 1, 229.99),  -- Alejandro: Teclado Razer Huntsman Mini
(2, 7, 1, 99.99),   -- Belen: Auriculares HyperX Cloud Alpha S
(3, 4, 1, 229.99),  -- Carlos: Teclado Corsair K100 RGB
(3, 10, 1, 49.99),  -- Carlos: Mousepad Glorious XXXL
(3, 16, 2, 59.50),  -- Carlos: Elgato Stream Deck x 2 (Precio del detalle 119.00)
(4, 2, 1, 159.99),  -- Daniela: Mouse Logitech G502 X Plus
(5, 9, 1, 179.99),  -- Emilio: Auriculares Razer BlackShark V2 Pro
(6, 4, 1, 229.99),  -- Fernanda: Teclado Corsair K100 RGB
(7, 3, 1, 79.99),   -- Gabriel: Mouse SteelSeries Aerox 3 Wireless
(8, 12, 1, 179.99), -- Hilda: Control Xbox Elite Series 2
(9, 13, 1, 149.99), -- Ignacio: Webcam Logitech StreamCam
(10, 14, 1, 169.99),-- Julieta: Micrófono Blue Yeti X
(11, 15, 1, 99.99), -- Kevin: Teclado HyperX Alloy Origins Core
(12, 16, 1, 79.99), -- Laura: Mouse Glorious Model O Wireless
(13, 17, 1, 299.99),-- Mario: Auriculares Astro A50 Wireless + Base
(14, 18, 1, 39.99), -- Natalia: Mousepad ZOWIE G-SR-SE DEEP BLUE
(15, 19, 1, 49.99), -- Óscar: Switches Cherry MX Red
(16, 20, 1, 149.99),-- Patricia: Elgato Stream Deck MK.2
(17, 5, 1, 119.99), -- Ricardo: Teclado Razer Huntsman Mini
(18, 8, 1, 349.99), -- Sofía: Auriculares SteelSeries Arctis Nova Pro
(19, 1, 1, 149.99), -- Tomas: Mouse Razer DeathAdder V3 Pro
(20, 11, 1, 79.99), -- Valeria: Mousepad Artisan Hayate Otsu XL
(1, 16, 1, 79.99),  -- Alejandro: Mouse Glorious Model O Wireless
(6, 1, 1, 149.99),  -- Fernanda: Mouse Razer DeathAdder V3 Pro
(6, 10, 2, 49.99),  -- Fernanda: Mousepad Glorious XXXL x 2
(8, 16, 1, 79.99),  -- Hilda: Mouse Glorious Model O Wireless
(9, 7, 1, 99.99),   -- Ignacio: Auriculares HyperX Cloud Alpha S
(10, 18, 1, 39.99), -- Julieta: Mousepad ZOWIE G-SR-SE DEEP BLUE
(13, 15, 1, 99.99); -- Mario: Teclado HyperX Alloy Origins Core

INSERT INTO payments (order_id, method, amount, payment_date) VALUES
(1, 'Credit Card', 379.97, '2024-09-01 10:05:00'),
(2, 'Debit Card', 99.99, '2024-09-02 11:35:00'),
(4, 'Credit Card', 159.99, '2024-09-04 16:05:00'),
(5, 'PayPal', 179.99, '2024-09-05 09:20:00'),
(6, 'Credit Card', 229.99, '2024-09-06 12:05:00'),
(8, 'Debit Card', 179.99, '2024-09-08 17:05:00'),
(9, 'PayPal', 149.99, '2024-09-09 10:50:00'),
(10, 'Transfer', 169.99, '2024-09-10 13:05:00'),
(12, 'Credit Card', 79.99, '2024-09-12 11:05:00'),
(13, 'Credit Card', 299.99, '2024-09-13 14:05:00'),
(14, 'Debit Card', 39.99, '2024-09-14 16:35:00'),
(15, 'PayPal', 49.99, '2024-09-15 10:05:00'),
(17, 'Credit Card', 119.99, '2024-09-17 13:35:00'),
(18, 'Transfer', 349.99, '2024-09-18 15:05:00'),
(19, 'Credit Card', 149.99, '2024-09-19 16:50:00'),
(20, 'Debit Card', 79.99, '2024-09-20 18:05:00'),
(11, 'Credit Card', 99.99, '2024-09-11 15:20:00'),
(7, 'PayPal', 79.99, '2024-09-07 15:35:00'),
(1, 'Transfer', 79.99, '2024-09-01 10:10:00'), -- Pago adicional para el pedido 1 (Ajuste del total del pedido 1)
(6, 'Debit Card', 149.99, '2024-09-06 12:10:00'); -- Pago adicional para el pedido 6 (Ajuste del total del pedido 6)

INSERT INTO reviews (user_id, product_id, rating, comment) VALUES
(1, 1, 5, 'El mejor ratón que he tenido, súper ligero y preciso.'),
(2, 7, 4, 'Excelente calidad de sonido para el precio. Muy cómodos.'),
(3, 4, 5, 'Una maravilla de teclado, los switches OPX son increíbles. Un poco caro, eso sí.'),
(4, 2, 5, 'Perfecto para mi mano, la carga inalámbrica es muy cómoda. Gran sensor.'),
(5, 9, 4, 'Micrófono muy claro y el sonido envolvente es genial para FPS.'),
(6, 4, 5, 'La respuesta es instantánea. El mejor teclado para juegos competitivos.'),
(7, 3, 3, 'Es ligero, pero el software es un poco molesto.'),
(8, 12, 5, 'El control Elite 2 es un cambio total en los juegos de PC. Excelente construcción.'),
(9, 13, 4, 'Buena calidad de imagen, 60fps es un must para streaming.'),
(10, 14, 5, 'El Blue Yeti X suena profesional. Perfecto para mis directos.'),
(11, 15, 4, 'Un TKL sólido. Switches HyperX Red muy suaves.'),
(12, 16, 5, 'Ultra ligero y el sensor va de maravilla. Lo recomiendo para juegos rápidos.'),
(13, 17, 5, 'Los Astro A50 son caros, pero la comodidad y el sonido valen cada centavo.'),
(14, 18, 4, 'Mousepad de control ideal para juegos de precisión. Muy buena base.'),
(15, 19, 5, 'Switches de repuesto excelentes. Fáciles de instalar.'),
(16, 20, 5, 'El Stream Deck me ha simplificado el streaming. Es un accesorio esencial.'),
(17, 5, 4, 'El 60% es compacto y genial, pero extrañé el pad numérico al inicio.'),
(18, 8, 5, 'Los Nova Pro son los mejores auriculares que existen, ANC y audio inmersivo.'),
(19, 1, 5, 'El DeathAdder V3 es pura velocidad. Imbatible.'),
(20, 11, 4, 'El mousepad Artisan es caro, pero el deslizamiento es el mejor que probé.'),
(1, 10, 3, 'Gigante. Cubre todo mi escritorio, un poco de fricción inicial.'),
(2, 6, 4, 'Teclado TKL de Logitech de gran calidad, buen desempeño en juegos.');

COMMIT;