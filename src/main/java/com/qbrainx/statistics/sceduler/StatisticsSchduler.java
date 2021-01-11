package com.qbrainx.statistics.sceduler;

import com.qbrainx.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StatisticsSchduler {
    @Autowired
    StatisticsService statisticsService;

    @Scheduled(fixedRate = 1000)
    public void houseKeeping() {
        statisticsService.calculateStatisticsForLastMin();
    }
}
