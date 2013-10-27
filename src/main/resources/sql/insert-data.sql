--User
INSERT INTO UserArticle (userid, username, email,profile,profileid)
values (2, "test","test@example.com","test",0);
 
--Article
INSERT INTO Article (datearticle,subject,article,author,sectionid)
values (NOW(),"Primera Prueba","Este es el articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);

INSERT INTO Article (datearticle,subject,article,author,sectionid)
values (CURRENT_TIMESTAMP,"Segunda Prueba","Este es el segundo articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);

INSERT INTO Article (datearticle,subject,article,author,sectionid)
values ('2013-10-26 15:30:00',"Tercera Prueba Prueba","Este es el tercer articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.","Todos",1);


-- Section
INSERT INTO SectionArticle (sectionArticle) values ("Sección Principal");




-- Para Reiniciar el autoincrement de las tablas
-- ALTER TABLE Aticle AUTO_INCREMENT = 1
