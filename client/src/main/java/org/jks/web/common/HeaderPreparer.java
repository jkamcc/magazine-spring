package org.jks.web.common;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.Attribute;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.jks.domain.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * @author juancarrillo
 */
public class HeaderPreparer implements ViewPreparer {

    private static final Logger logger = LoggerFactory.getLogger(HeaderPreparer.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void execute(TilesRequestContext tilesRequestContext, AttributeContext attributeContext) {
        logger.info("Header Preparer");

//        String user = addCurrentUserInfo();
//        Section[] sections = loadSections();
//
//        attributeContext.putAttribute("currentUser", new Attribute(user));
//        attributeContext.putAttribute("sectionList", new Attribute(sections));

    }

    private String addCurrentUserInfo() {
        String toReturn = "";

        String currentUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug("Current user", currentUser);

        if (!currentUser.equals("anonymousUser")) {
            toReturn = currentUser;
        }

        return toReturn;
    }

    private Section[] loadSections() {

        Section[] sections = null;

        try {
           sections = restTemplate.getForObject("http://localhost:8080/service/section/all", Section[].class);


        } catch (RestClientException e) {
            logger.error("Failed loading sections for the header", e);
        }

        return sections;
    }
}
