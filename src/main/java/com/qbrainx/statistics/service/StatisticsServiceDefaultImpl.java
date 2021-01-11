package com.qbrainx.statistics.service;

import com.qbrainx.statistics.model.Statistics;
import com.qbrainx.statistics.model.Transaction;
import com.qbrainx.statistics.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class StatisticsServiceDefaultImpl implements StatisticsService {
    List<Transaction> list = new CopyOnWriteArrayList();
    DoubleSummaryStatistics statistics = null;
    @Override
    public void addTransaction(Transaction transaction) {
        list.add(transaction);
    }

    @Override
    public Statistics getStatistics() {
        Statistics stats = null;
        if(statistics!=null && statistics.getCount()>0) {
            stats = new Statistics();
            stats.setCount(statistics.getCount());
            stats.setSum(statistics.getSum());
            stats.setAvg(statistics.getAverage());
            stats.setMin(statistics.getMin());
            stats.setMax(statistics.getMax());
        }
        return stats;
    }

    @Override
    public DoubleSummaryStatistics calculateStatisticsForLastMin() {
        list.removeIf(t -> !(DateUtil.isTimestampInMinute(t.getTimestamp())));
        this.statistics = list.stream()
                .mapToDouble(a -> a.getAmount())
                .summaryStatistics();
        return statistics;
    }
}
