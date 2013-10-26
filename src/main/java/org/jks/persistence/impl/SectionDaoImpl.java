package org.jks.persistence.impl;

import java.util.List;

import org.jks.domain.Section;
import org.jks.persistence.SectionDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

/**
 * @author scorrales
 * Date: 25/10/13
 */
@Repository("sectionDao")
public class SectionDaoImpl extends AbstractHibernateDAO<Section> implements SectionDao {


	    public SectionDaoImpl() {
	        setClazz(Section.class);
	    }

	    @Override
	    public void addSection(Section section) {
	    	this.getCurrentSession().saveOrUpdate(section);
	    }


	    @Override
	    public void updateSection(Section section) {
	    	this.getCurrentSession().update(section);
	    }

	    @Override
	    public void deleteSection(Section section) {
	        this.getCurrentSession().delete(section);
	    }
	    
	    @Override
	    public Section getSectionByName (String name){
	    	return null;
	    }
	    
	    @Override
	    public List<Section> getSections(){
	    	return this.findAll();
	    }
	    
}
