package com.brocamp.AcousticAlchemy.serviceimpl;

import com.brocamp.AcousticAlchemy.model.SizeChart;
import com.brocamp.AcousticAlchemy.repository.SizeChartRepository;
import com.brocamp.AcousticAlchemy.service.SizeChartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SizeChartServiceImpl implements SizeChartService {
    private SizeChartRepository sizeChartRepository;

    public SizeChartServiceImpl(SizeChartRepository sizeChartRepository) {
        this.sizeChartRepository = sizeChartRepository;
    }

    @Override
    public void saveOrUpdate(SizeChart sizeChart) {
        sizeChartRepository.save(sizeChart);
    }

    @Override
    public List<SizeChart> findAll() {
        Optional<List<SizeChart>> optionalSizeChartList = Optional.ofNullable(sizeChartRepository.findAll());
        return optionalSizeChartList.orElse(new ArrayList<SizeChart>());
    }
}
