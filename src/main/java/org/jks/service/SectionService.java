package org.jks.service;
import java.util.List;
import org.jks.domain.Section;

public interface SectionService {

	public void addSection(Section section);
	
    public Section getSectionById(int sectionId);

    public List<Section> getSections();
    
    public Section getSectionByName(String subject);
}
