package moon.restapi.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import moon.restapi.common.entity.JwtToken;
import moon.restapi.common.util.JwtUtil;
import moon.restapi.dao.UserDAO;

@Service
public class UserService {
    
    private final BCryptPasswordEncoder encoder;
    private final UserDAO userDao;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtUtil jwtUtil;

    public UserService(BCryptPasswordEncoder encoder, UserDAO userDao, AuthenticationManagerBuilder authenticationManagerBuilder, JwtUtil jwtUtil) {
        this.encoder = encoder;
        this.userDao = userDao;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtUtil = jwtUtil;
    }

    public JwtToken login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        JwtToken token = jwtUtil.generateToken(authentication);
        
        return token;
    }

}
