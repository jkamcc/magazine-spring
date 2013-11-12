package org.jks.service.impl;
import java.io.Console;
import java.util.List;

import org.apache.velocity.runtime.log.Log;
import org.jks.domain.Section;
import org.jks.persistence.SectionDao;
import org.jks.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionDao sectionDao;
    
    @Override
	public void addSection(Section section){
    	sectionDao.create(section);
    }
	
    @Override
    public Section getSectionById(long sectionId){
    	return sectionDao.findOne(sectionId);
    }

    @Override
    public List<Section> getSections(){
    	return sectionDao.findAll();
    }
    
    @Override
    public Section getSectionByName(String subject){
    	return sectionDao.getSectionByName(subject);
    }

    @Override
    public void updateSection(Section section) {
        sectionDao.update(section);
    }

    @Override
    public void deleteSection(Section section) {
        sectionDao.delete(section);
    }

    @Override
    public void deleteSectionById(long sectionId) {
        sectionDao.delete(getSectionById(sectionId));
    }

}
