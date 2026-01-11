package com.project.Microbussiness.repository;

import com.project.Microbussiness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This MUST be an interface
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring will automatically generate the SQL for this based on the method name!
    Optional<User> findByEmail(String email);
}