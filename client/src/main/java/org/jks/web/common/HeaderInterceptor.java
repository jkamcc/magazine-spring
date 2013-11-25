package org.jks.web.common;

import org.jks.domain.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author juancarrillo
 */
public class HeaderInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(HeaderInterceptor.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("Header interceptor");

        String user = addCurrentUserInfo();
        Section[] sections = loadSections();

        request.setAttribute("currentUser", user);
        request.setAttribute("sectionList", sections);
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
