package com.brocamp.AcousticAlchemy.repository;

import com.brocamp.AcousticAlchemy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);

    Users findByEmail(String username);

    Users findById(long userId);
}
