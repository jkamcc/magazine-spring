package org.jks.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/appServlet/servlet-context.xml", "classpath:spring/root-context.xml"} )
@WebAppConfiguration
public class TestsRest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {

        String createScript = "src/main/resources/sql/insert-data.sql";
        JdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(createScript), false);

        jdbcTemplate.execute("INSERT INTO UserArticle (userid, username, email,profile,profileid, name, password)\n" +
                "values (2, \"test\",\"test@example.com\",\"admin\",0, \"test user user\", SHA1('admin'));");
        jdbcTemplate.execute("INSERT INTO Article (articleid, datearticle,subject,article,author,sectionid)\n" +
                "values (0, CURRENT_TIMESTAMP,\"Primera Prueba\",\"Este es el articulo de prueba de la aplicación de Juan Camilo Carrillo, Sharon Corrales, Karen Miranda.\",\"Todos\",1);");

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
        String deleteScript = "src/main/resources/sql/delete-data.sql";

        JdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(deleteScript), false);
    }

    @Test
    public void getUserById() throws Exception {
           mockMvc.perform(get("/user/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.username", is("test")));
    }
}
