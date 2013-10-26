CREATE TABLE SectionArticle (
	sectionid int AUTO_INCREMENT,
	sectionArticle varchar(30),
	CONSTRAINT pk_section PRIMARY KEY (sectionid)
);

CREATE TABLE Article(
	articleid int AUTO_INCREMENT,
	datearticle timestamp,
	subject varchar (50),
	article varchar(50000),
	author varchar(50),
	sectionid int,

	CONSTRAINT pk_article PRIMARY KEY (articleid),
	CONSTRAINT fk_section_article FOREIGN KEY
	(sectionid) REFERENCES SectionArticle(sectionid)
);

CREATE TABLE CommentArticle(
	commentid int AUTO_INCREMENT,
	dateComment timestamp,
	commentarticle varchar(5000),
	articleid int,
	CONSTRAINT pk_comment PRIMARY KEY (commentid),
	CONSTRAINT fk_comment_article FOREIGN KEY
	(articleid) REFERENCES Article(articleid)
);

CREATE TABLE UserArticle(
	userid int AUTO_INCREMENT,
	username varchar(20) unique,
	email varchar(50) unique,
	profile varchar(30),
	profileid int,
	CONSTRAINT pk_user PRIMARY KEY (userid)
);

