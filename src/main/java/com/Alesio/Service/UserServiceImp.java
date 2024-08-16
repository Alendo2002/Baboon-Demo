package com.Alesio.Service;

import com.Alesio.config.JwtProvider;
import com.Alesio.model.User;
import com.Alesio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        // Remove "Bearer " prefix and trim whitespace
        jwt = jwt.replace("Bearer ", "").trim();

        // Decode JWT token and retrieve email
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        // Find user by email
        User user = findUserByEmail(email);

        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new Exception("user not found");
        }

        return user;
    }
}
