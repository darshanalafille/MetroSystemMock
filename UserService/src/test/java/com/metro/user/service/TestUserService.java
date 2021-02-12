package com.metro.user.service;


import com.metro.user.StartUserService;
import com.metro.util.dto.UserCreationReq;
import com.metro.user.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUserService.class)
public class TestUserService {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    @DirtiesContext
    public void testCreateUser(){
        UserCreationReq req = new UserCreationReq();
        req.setIdNumber("XXXX777");
        req.setName("Jhone Wal Jhone");
        req.setPin("78985");
        var x = userService.createUser(req);
        assertTrue(x.isPresent());
        assertEquals(userRepository.findById(x.get().getUserId()).get().getIdNumber(),req.getIdNumber());
    }

}
