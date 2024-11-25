package com.mail.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mail.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
