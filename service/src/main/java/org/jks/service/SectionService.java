package org.jks.service;
import java.util.List;
import org.jks.domain.Section;

public interface SectionService {

	public void addSection(Section section);
	
    public Section getSectionById(long sectionId);

    public List<Section> getSections();
    
    public Section getSectionByName(String subject);

    public void updateSection(Section section);

    public void deleteSection(Section section);

    public void deleteSectionById(long sectionId);

}
