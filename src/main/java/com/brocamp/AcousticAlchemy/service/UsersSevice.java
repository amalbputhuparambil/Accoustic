package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.dto.PasswordDTO;
import com.brocamp.AcousticAlchemy.dto.UsersDTO;
import com.brocamp.AcousticAlchemy.model.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsersSevice {
    public boolean findAlreadyExistUserByEmail(String email);

    void saveOrUpdate(Users newUser);

    boolean existsByEmail(String email);

    List<Users> findAll();

    boolean existById(long id);

    Users findById(long id);

    void updateUserProfile(UsersDTO usersDTO);

    void changePassword(PasswordDTO passwordDTO);

    Page<Users> findPaginated(int pageNo, int pageSize);
}
