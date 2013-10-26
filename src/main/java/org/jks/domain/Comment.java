package org.jks.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 19/10/13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "CommentArticle", schema = "", catalog = "magazine")
@Entity
public class Comment {
    private int commentid;
    private Timestamp dateComment;
    private String commentarticle;
    private Integer articleid;

    @javax.persistence.Column(name = "commentid")
    @Id
    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    @javax.persistence.Column(name = "dateComment")
    @Basic
    public Timestamp getDateComment() {
        return dateComment;
    }

    public void setDateComment(Timestamp dateComment) {
        this.dateComment = dateComment;
    }

    @javax.persistence.Column(name = "commentarticle")
    @Basic
    public String getCommentarticle() {
        return commentarticle;
    }

    public void setCommentarticle(String commentarticle) {
        this.commentarticle = commentarticle;
    }

    @javax.persistence.Column(name = "articleid")
    @Basic
    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentid != comment.commentid) return false;
        if (articleid != null ? !articleid.equals(comment.articleid) : comment.articleid != null) return false;
        if (commentarticle != null ? !commentarticle.equals(comment.commentarticle) : comment.commentarticle != null)
            return false;
        if (dateComment != null ? !dateComment.equals(comment.dateComment) : comment.dateComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentid;
        result = 31 * result + (dateComment != null ? dateComment.hashCode() : 0);
        result = 31 * result + (commentarticle != null ? commentarticle.hashCode() : 0);
        result = 31 * result + (articleid != null ? articleid.hashCode() : 0);
        return result;
    }
}
