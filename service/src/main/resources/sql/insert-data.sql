-- User
INSERT INTO UserArticle (userid, username, email,profile,profileid, name, password)
values (2, "test","test@example.com","admin",0, "test user user", "d033e22ae348aeb5660fc2140aec35850c4da997");

-- INSERT INTO UserArticle (username, email,profile,profileid, name, password)
-- values ("username","test2@example.com","admin",0, "test user", SHA1('admin'));

-- Section
INSERT INTO SectionArticle (sectionId, sectionArticle) values (1, "Sección Principal");

-- Article
INSERT INTO Article (datearticle,subject,article,author,sectionid)
values ('2013-10-26 15:30:00',"Primera Prueba","Este es el articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);

INSERT INTO Article (datearticle,subject,article,author,sectionid)
values ('2013-11-14 15:30:00',"Segunda Prueba","Este es el segundo articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);

INSERT INTO Article (datearticle,subject,article,author,sectionid)
values ('2013-10-26 15:30:00',"Tercera Prueba Prueba","Este es el tercer articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);

-- Comments
INSERT INTO CommentArticle (dateComment, commentArticle, articleid, author)
VALUES ('2013-11-03 06:25:07', "Comentario 1", 0, 1);
INSERT INTO CommentArticle (dateComment, commentArticle, articleid, author)
VALUES ('2013-11-03 06:24:07', "Comentario 2", 0, 1);
INSERT INTO CommentArticle (dateComment, commentArticle, articleid, author)
VALUES (CURRENT_TIMESTAMP, "Comentario 3", 0, 1);


-- Para Reiniciar el autoincrement de las tablas
-- ALTER TABLE Aticle AUTO_INCREMENT = 1
