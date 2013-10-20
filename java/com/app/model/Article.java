package com.app.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column (name="sectionid" )
	@ManyToOne 
	@JoinColumn (name="sectionid")
	private int sectionid;
	
	
	public Article(){ };
	
	public Article (Timestamp datearticle, String subject, String article, String author, int sectionid){
		this.datearticle= datearticle;
		this.subject= subject;
		this.article= article;
		this.author= author;
		this.sectionid= sectionid;
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
