package com.sunesoft.ecloud.auth.security.controller;

import com.sunesoft.ecloud.adminclient.clientService.UserServiceClient;
import com.sunesoft.ecloud.auth.rest.Person;
import com.sunesoft.ecloud.auth.security.JwtTokenUtil;
import com.sunesoft.ecloud.auth.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;


    @Autowired
    UserServiceClient userServiceClient;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getStr(){
     List<Person> persons = new ArrayList<>();
        persons.add(new Person("Hello", userServiceClient.getString()));
        persons.add(new Person("Foo", userServiceClient.getString()));
        return persons;
    }

}
