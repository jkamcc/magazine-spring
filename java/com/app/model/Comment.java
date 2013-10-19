package com.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CommentArticle")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
    @Column(name="commentid")
    private long commentId;

	@Column(name="commentdate")
	private Timestamp date;
	
    @Column(name="articleid")
    private String articleId;
    
	public Comment(){}

	
	public Comment(long commentId, Timestamp date, String articleId) {
		this.commentId = commentId;
		this.date = date;
		this.articleId = articleId;
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

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

}

