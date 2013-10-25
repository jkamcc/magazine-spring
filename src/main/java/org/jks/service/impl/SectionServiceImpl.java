package org.jks.service.impl;
import java.util.List;

import org.jks.model.Section;
import org.jks.persistence.UserDao;
import org.jks.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

	 @Autowired
	 Section sectionDao;
	 
	@Override
	public List<Section> getSecciones(){
		return null;
	}
	
	@Override
	public void agregarSeccion(String nuevaSeccion){}
	
}
