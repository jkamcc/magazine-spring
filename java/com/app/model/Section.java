package com.app.model;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	public Set<Article> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Article> articulos) {
		this.articulos = articulos;
	}
	
	@Id
	@GeneratedValue
    @Column(name="sectionid")
    private long sectionId;

	@Column (name="section" )
    private String section;
	
	@OneToMany (mappedBy="articleid")
    private Set<Article> articulos;
   
}