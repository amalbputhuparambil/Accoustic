package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.dto.AddressDTO;
import com.brocamp.AcousticAlchemy.model.Address;
import com.brocamp.AcousticAlchemy.model.Users;

import java.util.List;

public interface AddressService {
    List<Address> findAllByUsersId(long usersId);

    void saveAddress(AddressDTO addressDTO, Users users);

    void deleteById(long id);

    AddressDTO findById(long id);

    void updateAddress(AddressDTO addressDTO);
}
