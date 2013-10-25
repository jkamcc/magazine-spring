package org.jks.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 19/10/13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SectionArticle", schema = "", catalog = "magazine")
@Entity
public class Section {
    private int sectionid;
    private String sectionArticle;

    @javax.persistence.Column(name = "sectionid")
    @Id
    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    @javax.persistence.Column(name = "sectionArticle")
    @Basic
    public String getSectionArticle() {
        return sectionArticle;
    }

    public void setSectionArticle(String sectionArticle) {
        this.sectionArticle = sectionArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (sectionid != section.sectionid) return false;
        if (sectionArticle != null ? !sectionArticle.equals(section.sectionArticle) : section.sectionArticle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sectionid;
        result = 31 * result + (sectionArticle != null ? sectionArticle.hashCode() : 0);
        return result;
    }
}
