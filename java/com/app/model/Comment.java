package com.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CommentArticle")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
    @Column(name="commentid")
    private long commentId;

	@Column(name="commentdate")
	private Timestamp date;
	
    @ManyToOne
    @JoinColumn (name="articleid" )
    private int articleId;
    
    @ManyToOne
    @JoinColumn (name="userid" )
    private int userid;
    

	public Comment(){}

	public Comment(long commentId, Timestamp date, int articleId) {
		this.commentId = commentId;
		this.date = date;
		this.articleId = articleId;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

}

