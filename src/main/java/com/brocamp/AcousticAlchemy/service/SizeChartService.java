package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.SizeChart;

import java.util.List;

public interface SizeChartService {
    void saveOrUpdate(SizeChart sizeChart);

    List<SizeChart> findAll();
}
