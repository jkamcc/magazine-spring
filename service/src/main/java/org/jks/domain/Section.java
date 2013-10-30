package org.jks.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author juancarrillo
 */
@javax.persistence.Table(name = "SectionArticle", schema = "", catalog = "magazine")
@Entity
public class Section {
    private long sectionid;

    @javax.persistence.Column(name = "sectionid", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    private String sectionArticle;

    @javax.persistence.Column(name = "sectionArticle", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
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
        int result = (int) (sectionid ^ (sectionid >>> 32));
        result = 31 * result + (sectionArticle != null ? sectionArticle.hashCode() : 0);
        return result;
    }
}
