package org.jks.service;
import org.jks.domain.Section;
import org.jks.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author scorrales
 * Date: 25/10/2013
 */

public interface SectionService {

	public List<Section> getSecciones();
	
	public void agregarSeccion(String nuevaSeccion);
	
}
