package org.jks.service.impl;
import java.util.List;

import org.jks.model.Section;
import org.jks.persistence.SectionDao;
import org.jks.persistence.UserDao;
import org.jks.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

	 @Autowired
	 Section section;
	 
	 @Autowired
	 SectionDao sectionDao;
	 
	@Override
	public List<Section> getSecciones(){
		return sectionDao.getSections();
	}
	
	@Override
	public void agregarSeccion(String nuevaSeccion){
		section.setSectionArticle(nuevaSeccion);
		sectionDao.addSection(section);
	}
	
}
