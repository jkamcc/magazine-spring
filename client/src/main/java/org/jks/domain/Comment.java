package org.jks.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.sql.Timestamp;

/**
 * @author juancarrillo
 */
@javax.persistence.Table(name = "CommentArticle", schema = "", catalog = "magazine")
@Entity
public class Comment {
    private long commentid;
    private Timestamp dateComment;
    private String commentarticle;
    private Long articleid;
    private Long author;
    private String auhtorName;

    @javax.persistence.Column(name = "commentid", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    @javax.persistence.Column(name = "dateComment", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getDateComment() {
        return dateComment;
    }

    public void setDateComment(Timestamp dateComment) {
        this.dateComment = dateComment;
    }

    @javax.persistence.Column(name = "commentarticle", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getCommentarticle() {
        return commentarticle;
    }

    public void setCommentarticle(String commentarticle) {
        this.commentarticle = commentarticle;
    }

    @javax.persistence.Column(name = "articleid", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    @javax.persistence.Column(name = "author", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentid != comment.commentid) return false;
        if (articleid != null ? !articleid.equals(comment.articleid) : comment.articleid != null) return false;
        if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
        if (commentarticle != null ? !commentarticle.equals(comment.commentarticle) : comment.commentarticle != null)
            return false;
        if (dateComment != null ? !dateComment.equals(comment.dateComment) : comment.dateComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentid ^ (commentid >>> 32));
        result = 31 * result + (dateComment != null ? dateComment.hashCode() : 0);
        result = 31 * result + (commentarticle != null ? commentarticle.hashCode() : 0);
        result = 31 * result + (articleid != null ? articleid.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
    
    @Transient
    public String getAuthorName() {
        return auhtorName;
    }

    @Transient
    public void setAuthorName(String auhtorName) {
        this.auhtorName = auhtorName;
    }
}
