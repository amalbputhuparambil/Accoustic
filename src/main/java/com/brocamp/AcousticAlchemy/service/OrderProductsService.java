package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.dto.OrderProductsDTO;
import com.brocamp.AcousticAlchemy.model.OrderProducts;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface OrderProductsService {
    List<OrderProducts> findAllByUsersId(long usersId);

    List<OrderProducts> findByOrderDetailsId(long id);

    Page<OrderProducts> findAllByUsersIdPaginated(long userId,int pageNo, int pageSize);

    List<OrderProductsDTO> getAllProductSalesByDate(String status, Date date);

    List<OrderProductsDTO> getAllProductSalesByMonthwise(String status, int month, int year);

    List<OrderProductsDTO> getAllProductSalesByYearwise(String status, int selectedYear);

    OrderProducts findByOrderProductId(long id);
}
