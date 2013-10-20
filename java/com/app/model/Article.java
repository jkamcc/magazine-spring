package com.app.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Article")
public class Article {
	

	@Id
	@GeneratedValue
	@Column (name="articleid")
	private int articleid;
	
	@Column (name="datearticle")
	private Timestamp datearticle;

	@Column (name="subject")
	private String subject;
	
	@Column (name="article")
	private String article;
	
	@Column (name= "author" )
	private String author;
	
	@ManyToOne 
	@JoinColumn (name="sectionid")
	private int sectionid;
	
	@OneToMany (mappedBy="commentId")
	private Set<Comment> comentarios;
	
	

	public Article(){ };
	
	public Article (Timestamp datearticle, String subject, String article, String author, int sectionid){
		this.datearticle= datearticle;
		this.subject= subject;
		this.article= article;
		this.author= author;
		this.sectionid= sectionid;
	}
	
	public Set<Comment> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comment> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void setSubject(String subject){
		this.subject= subject;
	}
	
	public void setAuthor (String author){
		this.author= author;
	}
	
	public void setArticle (String article){
		this.article= article;
	}
	
	public void setSectionId(int sectionid){
		this.sectionid=sectionid;
	}
	
	public void setDateArticle(Timestamp date){
		this.datearticle= date;
	}
	
	public String getSubject (){
		return this.subject;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getArticle(){
		return this.article;
	}
	
	public Timestamp getDateArticle(){
		return this.datearticle;
	}
	
	public int getSectionId(){
		return this.sectionid;
	}
	
}
