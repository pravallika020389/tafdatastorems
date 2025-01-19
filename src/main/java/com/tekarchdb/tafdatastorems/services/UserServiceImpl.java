package com.tekarchdb.tafdatastorems.services;


import com.tekarchdb.tafdatastorems.models.Users;
import com.tekarchdb.tafdatastorems.repositories.UserRepository;
import com.tekarchdb.tafdatastorems.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public Users registerUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<Users> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Users updateUser(Long id, Users userDetails) {
        Optional<Users> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
//            Users existingUser = optionalUser.get();
//            existingUser.setUsername(userDetails.getUsername());
//            existingUser.setEmail(userDetails.getEmail());
//            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
//            existingUser.setUpdatedAt(LocalDateTime.now());
//            return userRepository.save(existingUser);
            return userRepository.save(userDetails);

        } else {
            return null;
        }
    }

}
