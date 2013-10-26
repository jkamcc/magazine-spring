package org.jks.service;

import org.jks.domain.Profile;
import org.jks.domain.User;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author juancarrillo
 */
@ContextConfiguration(locations = "classpath:hibernate.xml" )
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    private final String createScript = "src/main/resources/sql/insert-data.sql";
    private final String deleteScript = "src/main/resources/sql/delete-data.sql";

    @Before
    public void insertData() {
        SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(createScript), false);
    }

    @After
    public void deleteData() {
        SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(deleteScript), false);
    }

    @Test
    public void testFindUserById() {
        User user = userService.getUserById(2);

        assertEquals("test", user.getUsername());
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userService.getUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    public void testFindUserByName() {
        User user = userService.getUserByUsername("test");
        assertNotNull(user);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("test2");
        user.setEmail("test2@test.com");
        user.setProfile(Profile.ADMINISTRATOR.toString());
        user.setProfileid(Profile.ADMINISTRATOR.getValue());
        userService.addUser(user);
        User user2 = userService.getUserByUsername("test2");
        assertEquals(user.getUsername(), user2.getUsername());
    }

}
