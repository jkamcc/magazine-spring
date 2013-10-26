package org.jks.persistence;
import java.util.List;

import org.jks.domain.Section;


/**
 * @author scorrales
 *         Date: 25/10/13
 */
public interface SectionDao {
	
	void addSection(Section section);

	Section getSectionByName(String name);

	void updateSection(Section section);

	void deleteSection(Section section);
	
	List<Section> getSections();
}
