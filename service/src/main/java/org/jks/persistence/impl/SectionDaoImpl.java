package org.jks.persistence.impl;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.Section;
import org.jks.persistence.SectionDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sectionDao")
public class SectionDaoImpl  extends AbstractHibernateDAO<Section, Long> implements SectionDao{

	public SectionDaoImpl() {
        setClazz(Section.class);
    }

	@Override
	public Section getSectionByName(String sectionArticle){
		return (Section) getCurrentSession().createCriteria(Section.class).add(Restrictions.eq("sectionArticle", sectionArticle)).uniqueResult();
	}

    @Override
    public List<Section> find(int start, int end) {

        String hsql = "FROM " + Section.class.getName() + " as a ORDER BY a.sectionarticle asc ";
        Query q = getCurrentSession().createQuery(hsql);

        if (start > 0) {
            q.setFirstResult(start);
        }

        if (end > 0) {
            q.setMaxResults(end);
        }

        return q.list();
    }
	
}
