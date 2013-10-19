package com.app.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SectionArticle")
public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Section(){}
	
	public Section(long sectionId, String section) {
		this.sectionId = sectionId;
		this.section = section;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	
	@Id
    @Column(name="sectionid")
    private long sectionId;

    @Column(name="sectionarticle")
    private String section;
}