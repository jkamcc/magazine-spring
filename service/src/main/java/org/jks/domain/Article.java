package org.jks.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author juancarrillo
 */
@Entity
public class Article {
    private long articleid;
    private Timestamp datearticle;
    private String subject;
    private String article;
    private String author;
    private Long sectionid;
    private String sectionName;
    private List<Comment> comments;

    @javax.persistence.Column(name = "articleid", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public long getArticleid() {
        return articleid;
    }

    public void setArticleid(long articleid) {
        this.articleid = articleid;
    }

    @javax.persistence.Column(name = "datearticle", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getDatearticle() {
        return datearticle;
    }

    public void setDatearticle(Timestamp datearticle) {
        this.datearticle = datearticle;
    }

    @javax.persistence.Column(name = "subject", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @javax.persistence.Column(name = "article", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @javax.persistence.Column(name = "author", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @javax.persistence.Column(name = "sectionid", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Long getSectionid() {
        return sectionid;
    }

    public void setSectionid(Long sectionid) {
        this.sectionid = sectionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article1 = (Article) o;

        if (articleid != article1.articleid) return false;
        if (article != null ? !article.equals(article1.article) : article1.article != null) return false;
        if (author != null ? !author.equals(article1.author) : article1.author != null) return false;
        if (datearticle != null ? !datearticle.equals(article1.datearticle) : article1.datearticle != null)
            return false;
        if (sectionid != null ? !sectionid.equals(article1.sectionid) : article1.sectionid != null) return false;
        if (subject != null ? !subject.equals(article1.subject) : article1.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (articleid ^ (articleid >>> 32));
        result = 31 * result + (datearticle != null ? datearticle.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (sectionid != null ? sectionid.hashCode() : 0);
        return result;
    }

    @Transient
    public String getSectionName() {
        return sectionName;
    }
    @Transient
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Transient
    public List<Comment> getComments() {
        return comments;
    }

    @Transient
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
