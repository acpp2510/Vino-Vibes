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
