Magazine Web Application
==============================

Web Site developped using Spring Framework.
It is a magazine where Administrators can manage content, and users can see posts and comment them. 
The application has a Control Panel for the Administrators to add Users, Sections and Articles.
Normal users can comment posts, and guest users are only able to see the content.

The web app uses REST services for the service layer, and Hibernate for persistence layer. All the services uses Dependency Injection with their own Interface and implementation. Database errors are handled at most.

The look and feel of the application was developped using Bootstrap, for JSP it is used Apache Tiles for theme change when Administrators log in, also for dividing the header, footer and the content that changes.

Used Technologies
------------------
- Spring MVC 3.2
- Spring Security
- Spring REST Services
- Hibernate 4.1
- Apache Maven
- Apache Tiles 2
- Apache Tomcat 7
- SASS
- JQuery
- Ajax
- Bootstrap 2.3
- MySql
