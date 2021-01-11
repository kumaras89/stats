package com.qbrainx.statistics.service;

import com.qbrainx.statistics.model.Statistics;
import com.qbrainx.statistics.model.Transaction;

import java.util.DoubleSummaryStatistics;

public interface StatisticsService {

    void addTransaction(Transaction transaction);
    Statistics getStatistics();
    DoubleSummaryStatistics calculateStatisticsForLastMin();
}
