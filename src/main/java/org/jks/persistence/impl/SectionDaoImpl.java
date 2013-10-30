package org.jks.persistence.impl;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.Section;
import org.jks.persistence.SectionDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

@Repository("sectionDao")
public class SectionDaoImpl  extends AbstractHibernateDAO<Section, Integer> implements SectionDao{

	public SectionDaoImpl() {
        setClazz(Section.class);
    }

	@Override
	public Section getSectionByName(String sectionArticle){
		return (Section) getCurrentSession().createCriteria(Section.class).add(Restrictions.eq("sectionArticle", sectionArticle)).uniqueResult();
	}
	
}
