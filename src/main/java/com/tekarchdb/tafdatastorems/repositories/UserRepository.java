package com.tekarchdb.tafdatastorems.repositories;

import com.tekarchdb.tafdatastorems.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
