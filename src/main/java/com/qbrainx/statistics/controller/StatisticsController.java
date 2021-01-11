package com.qbrainx.statistics.controller;

import com.qbrainx.statistics.model.Statistics;
import com.qbrainx.statistics.model.Transaction;
import com.qbrainx.statistics.service.StatisticsService;
import com.qbrainx.statistics.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @PostMapping("/transactions")
    public ResponseEntity createTransaction(@RequestBody Transaction transaction) {
        ResponseEntity responseEntity = null;
        if (DateUtil.isTimestampInMinute(transaction.getTimestamp())) {
            statisticsService.addTransaction(transaction);
            responseEntity = new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping("/statistics")
    public ResponseEntity getStatistics() {
        Statistics statistics = statisticsService.getStatistics();
        ResponseEntity response = new ResponseEntity(statistics,HttpStatus.OK);
        return response;
    }
}
