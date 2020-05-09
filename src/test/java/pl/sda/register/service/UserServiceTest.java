package pl.sda.register.service;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.sda.register.config.AppConfig;
import pl.sda.register.config.WebAppInitializer;
import pl.sda.register.config.WebConfig;
import pl.sda.register.model.User;

import java.util.HashSet;
import java.util.Set;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void testFindAllUserNames() {

    }

    @Test
    public void whenUserNameIsProvided_thenRetrievedUserIsCorrect() {
        //given
        String username = "login";
        User expected = new User("login", "Captain", "Jack");
        Mockito.when(userService.findUserByUserName(username)).thenReturn(new User("login", "Captain", "Jack"));

        //when
        User actual = userService.findUserByUserName(username);

        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addUser() {
        //given
        //Set<User> users = new HashSet<>();
//        User expected = new User("login", "Captain", "Jack");
//        Mockito.doNothing().when(userService).addUser(expected);
//        Mockito.verify(userService,Mockito.times(1)).addUser(expected);

//        doNothing().when(myList).add(isA(Integer.class), isA(String.class));
//        myList.add(0, "");
//
//        verify(myList, times(1)).add(0, "");



//        //when
//        User actual = userService.findUserByUserName(username);
//
//        //then
//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeUser() {
    }

    @Test
    public void updateUser() {
    }
}