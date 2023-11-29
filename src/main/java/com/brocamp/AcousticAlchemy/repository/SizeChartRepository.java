package com.brocamp.AcousticAlchemy.repository;

import com.brocamp.AcousticAlchemy.model.SizeChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeChartRepository extends JpaRepository<SizeChart,Long> {
}
