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
public class TestServices extends AbstractJUnit4SpringContextTests {

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

    @Test(expected=NullPointerException.class)
    public void testFindUserNullId() {
        Integer id = null;
        User user = userService.getUserById(id);
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
    public void testFindUserByEmail() {
        User user = userService.getUserByEmail("test@example.com");
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

    @Test
    public void testUpdateUser() {
        User user = userService.getUserById(2);
        user.setEmail("testUpdate@example.com");
        userService.updateUser(user);
        User user2 = userService.getUserById(2);
        assertEquals(user.getEmail(), user2.getEmail());
    }

    @Test
    public void testDeleteUser() {
        User user = userService.getUserById(2);
        userService.deleteUser(user);
        user = userService.getUserById(2);
        assertNull(user);
    }

    @Test
    public void deleteNonExistentUser() {
        User user = userService.getUserByUsername("test");
        userService.deleteUser(user);
        //userService.deleteUser(user);
        //userService.deleteUserById(2);
    }

}
