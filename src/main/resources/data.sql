--admin: Admin123##
--user: User123##
--Ana: Ana123##
--Maria: Maria123##
--Luisa: Luisa123##
--Loli: Loli123##

-- USERS
INSERT INTO users (id, username, email, password, role) VALUES
  (1, 'admin', 'admin@admin.com', '$2a$10$bJLFDW.zD83bQDb4mM3kB.U3fu9kK74kUP5SxPUsxH1PDAH6MBJne', 'ADMIN'),
  (2, 'user', 'user@user.com', '$2a$10$zFZshAO0itrG/5cFJXVCue78PjD7dywTdOVFgZYW2cklZkef03pea', 'USER'),
  (3, 'Ana', 'ana@email.com', '$2a$10$GMWMPYxj2.DmdHB4g59a.uPtVtF3nDnSJb1dd7CqIAEkcQ9smDKvu', 'USER'),
  (4, 'Maria', 'mgitaria@email.com', '$2a$10$2A5IZUcAoxCdnzz6xOmZTejUTfPC6CijZH8R71cPUrnUxXQihdKbK', 'USER'),
  (5, 'Luisa', 'luisa@email.com', '$2a$10$Wjj1kpvVg.nrh4BLW.BEwO/pDqCvSe0j9zmrDOw1l8swZYaC4/Zca', 'USER'),
  (6, 'Loli', 'loli@email.com', '$2a$10$vXH79Eyg1uJfrsOHF4cg1u/b.jbC7MaBvpnhrW5kwbboGg9ZNBhAa', 'USER');

-- WINES
INSERT INTO wines (id, wine_name, alcohol_content, wine_type, year, grape_variety, region, wine_producer, url_producer, user_id) VALUES
-- 2 (user)
(1, 'Rioja Reserva', 14.5, 'Tinto', 2018, 'Tempranillo', 'Rioja', 'Bodegas Muga', 'https://www.bodegasmuga.com', 2),
(2, 'Albariño Rías Baixas', 12.5, 'Blanco', 2022, 'Albariño', 'Rías Baixas', 'Pazo de Señorans', 'https://www.pazodesenorans.com', 2),
(3, 'Chianti Classico', 13.5, 'Tinto', 2019, 'Sangiovese', 'Toscana', 'Castello di Ama', 'https://www.castellodiama.com', 2),
-- 3 (Ana)
(4, 'Champagne Brut', 12.0, 'Espumoso', 2018, 'Chardonnay, Pinot Noir, Pinot Meunier', 'Champagne', 'Moët & Chandon', 'https://www.moet.com', 3),
(5, 'Malbec Reserva', 14.0, 'Tinto', 2020, 'Malbec', 'Mendoza', 'Catena Zapata', 'https://www.catenawines.com', 3),
-- 4 (Maria)
(6, 'Sauvignon Blanc', 13.0, 'Blanco', 2022, 'Sauvignon Blanc', 'Marlborough', 'Cloudy Bay', 'https://www.cloudybay.com', 4),
(7, 'Barolo', 14.5, 'Tinto', 2017, 'Nebbiolo', 'Piamonte', 'Gaja', 'https://www.gaja.it', 4),
-- 5 (Luisa)
(8, 'Ribera del Duero', 14.5, 'Tinto', 2019, 'Tempranillo', 'Ribera del Duero', 'Vega Sicilia', 'https://www.vegasicilia.es', 5),
(9, 'Riesling', 12.0, 'Blanco', 2021, 'Riesling', 'Mosela', 'Dr. Loosen', 'https://www.drloosen.com', 5),
-- 6 (Loli)
(10, 'Pinot Noir', 13.5, 'Tinto', 2020, 'Pinot Noir', 'Borgoña', 'Domaine de la Romanée-Conti', 'https://www.romanee-conti.fr', 6),
(11, 'Cava Brut Nature', 11.5, 'Espumoso', 2021, 'Macabeo, Xarel·lo, Parellada', 'Penedés', 'Codorníu', 'https://www.codorniu.com', 6);

-- TASTINGS
INSERT INTO tastings (id, tasting_date, aroma_description, color_description, taste_description, emotions_evoked, pairing, image_tasting, user_id, wine_id) VALUES
-- Catas para el vino 1 (Rioja Reserva)
(1, '2023-10-15', 'Aromas a frutos rojos maduros, vainilla y especias', 'Rojo cereza intenso con ribetes teja', 'Potente en boca, tanos redondos, buena acidez y largo final', 'Elegancia, tradición, complejidad', 'Cordero asado, quesos curados', 'https://example.com/images/rioja_tasting.jpg', 2, 1),
(2, '2023-11-05', 'Notas de cereza negra, regaliz y tostados', 'Rojo granate con reflejos rubí', 'Estructurado, con tanos sedosos y final persistente', 'Profundidad, sofisticación', 'Chuletón a la parrilla', 'https://example.com/images/rioja_tasting2.jpg', 3, 1),
-- Catas para el vino 2 (Albariño Rías Baixas)
(3, '2023-09-20', 'Aromas cítricos, manzana verde y hierbas frescas', 'Amarillo pajizo con reflejos verdosos', 'Fresco, mineral, con buena acidez y final largo', 'Frescura, vitalidad', 'Mariscos, pescados al vapor', 'https://example.com/images/albariño_tasting.jpg', 2, 2),
-- Catas para el vino 4 (Champagne Brut)
(4, '2023-12-10', 'Notas de manzana verde, pan tostado y almendras', 'Amarillo dorado con burbuja fina y persistente', 'Cremoso, con buena acidez y final largo', 'Celebración, elegancia', 'Ostras, sushi, foie gras', 'https://example.com/images/champagne_tasting.jpg', 3, 4),
-- Catas para el vino 6 (Sauvignon Blanc)
(5, '2023-11-15', 'Intensos aromas a grosella, pomelo y hierba recién cortada', 'Amarillo verdoso pálido', 'Fresco, vibrante, con acidez marcada y final cítrico', 'Frescura, vitalidad, juventud', 'Ensalada de cabra, pescado a la plancha', 'https://example.com/images/sauvignon_tasting.jpg', 4, 6),
-- Catas para el vino 8 (Ribera del Duero)
(6, '2023-10-28', 'Notas de mora, ciruela, cacao y especias dulces', 'Rojo picota intenso con ribetes violáceos', 'Potente, con tanos maduros, buena estructura y final largo', 'Potencia, elegancia, complejidad', 'Carnes rojas, quesos curados', 'https://example.com/images/ribera_tasting.jpg', 5, 8),
-- Catas para el vino 10 (Pinot Noir)
(7, '2023-12-05', 'Aromas a fresa silvestre, cereza y notas terrosas', 'Rojo rubí pálido', 'Elegante, sedoso, con acidez vibrante y final persistente', 'Delicadeza, elegancia, complejidad', 'Pato asado, champiñones', 'https://example.com/images/pinot_tasting.jpg', 6, 10);

