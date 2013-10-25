package org.jks.persistence;
import org.jks.model.Section;


/**
 * @author scorrales
 *         Date: 25/10/13
 */
public interface SectionDao {
	
	void addSection(Section section);

	Section getSectionByName(String name);

	void updateSection(Section section);

	void deleteSection(Section section);
}
