package com.jjdev.JJE_commerce.repositories;

import com.jjdev.JJE_commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
