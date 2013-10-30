package org.jks.persistence;
import org.jks.domain.Section;
import org.jks.domain.User;
import org.jks.persistence.common.GenericDao;

public interface SectionDao extends GenericDao<Section, Long>  {

	public Section getSectionByName(String sectionArticle);
	
}
