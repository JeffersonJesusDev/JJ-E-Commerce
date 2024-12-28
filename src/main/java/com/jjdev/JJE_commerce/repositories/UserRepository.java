package com.jjdev.JJE_commerce.repositories;

import com.jjdev.JJE_commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
