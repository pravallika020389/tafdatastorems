package com.tekarchdb.tafdatastorems.services.interfaces;

import com.tekarchdb.tafdatastorems.models.Users;

import java.util.Optional;

public interface UserService {
    Users registerUser(Users user);
    Optional<Users> getUserById(Long userId);
    Users updateUser(Long id, Users userDetails);
}
