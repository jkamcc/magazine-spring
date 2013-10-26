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
@Entity
public class Article {
    private int articleid;
    private Timestamp datearticle;
    private String subject;
    private String article;
    private String author;
    private Integer sectionid;

    @javax.persistence.Column(name = "articleid")
    @Id
    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    @javax.persistence.Column(name = "datearticle")
    @Basic
    public Timestamp getDatearticle() {
        return datearticle;
    }

    public void setDatearticle(Timestamp datearticle) {
        this.datearticle = datearticle;
    }

    @javax.persistence.Column(name = "subject")
    @Basic
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @javax.persistence.Column(name = "article")
    @Basic
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @javax.persistence.Column(name = "author")
    @Basic
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @javax.persistence.Column(name = "sectionid")
    @Basic
    public Integer getSectionid() {
        return sectionid;
    }

    public void setSectionid(Integer sectionid) {
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
        int result = articleid;
        result = 31 * result + (datearticle != null ? datearticle.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (sectionid != null ? sectionid.hashCode() : 0);
        return result;
    }
}
