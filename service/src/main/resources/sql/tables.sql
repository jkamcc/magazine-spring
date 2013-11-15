CREATE TABLE UserArticle(
  userid bigint AUTO_INCREMENT,
  username varchar(20) unique,
  email varchar(50) unique,
  password varchar(40) not null,
  name varchar(100),
  profile varchar(30),
  profileid tinyint,
  CONSTRAINT pk_user PRIMARY KEY (userid)
);

CREATE TABLE SectionArticle (
	sectionid bigint AUTO_INCREMENT,
	sectionArticle varchar(50),
	CONSTRAINT pk_section PRIMARY KEY (sectionid)
);

CREATE TABLE Article(
	articleid bigint AUTO_INCREMENT,
	datearticle datetime,
	subject varchar (50),
	article longtext,
	author varchar(100),
	sectionid bigint,

	CONSTRAINT pk_article PRIMARY KEY (articleid),
	CONSTRAINT fk_section_article FOREIGN KEY
	(sectionid) REFERENCES SectionArticle(sectionid)
);

CREATE TABLE CommentArticle(
	commentid bigint AUTO_INCREMENT,
	dateComment datetime,
	commentarticle longtext,
	articleid bigint,
  author bigint,

	CONSTRAINT pk_comment PRIMARY KEY (commentid),
	CONSTRAINT fk_comment_article FOREIGN KEY
	(articleid) REFERENCES Article(articleid) ,
  CONSTRAINT fk_author FOREIGN KEY
  (author) REFERENCES UserArticle(userid)
);

INSERT INTO UserArticle (userid, username, email,profile,profileid, password, name)
values (1, "jks","jks@example.com","admin",0, "d033e22ae348aeb5660fc2140aec35850c4da997","jks");

