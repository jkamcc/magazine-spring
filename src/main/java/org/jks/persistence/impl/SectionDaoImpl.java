package org.jks.persistence.impl;

import org.jks.model.Section;
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

	    }


	    @Override
	    public void updateSection(Section section) {
	        //To change body of implemented methods use File | Settings | File Templates.
	    }

	    @Override
	    public void deleteSection(Section section) {
	        //To change body of implemented methods use File | Settings | File Templates.
	    }
	    
	    @Override
	    public Section getSectionByName (String name){
	    	return null;
	    }

}
