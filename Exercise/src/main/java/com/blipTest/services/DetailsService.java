package com.blipTest.services;

/**
 * Created by Tiago Matos on 28/09/2016.
 */

import com.blipTest.entities.Details;
import com.blipTest.metrics.MetricUtils;
import com.blipTest.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Service
public class DetailsService implements MetricUtils {

    private DetailsRepository detailsRepository;
    private final CounterService counterService;
    private final GaugeService gaugeService;


    @Autowired
    public DetailsService(DetailsRepository detailsRepository, CounterService counterService, GaugeService gaugeService) {
        this.detailsRepository = detailsRepository;
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    public CompletionStage<List<Details>> getAllDetails() {
        counterService.increment("counter.calls.getAllDetails");
        return CompletableFuture.supplyAsync(() -> {
            Timestamp initTime = Timestamp.from(Instant.now());
            List<Details> all = detailsRepository.findAll();
            gaugeService.submit("gauge.response.getAllDetails", timeCalc(initTime, Timestamp.from(Instant.now())));
            return all;
        });
    }

    public CompletionStage<Void> updateDetails(Details newDetails) {
        counterService.increment("counter.calls.newDetails");
        return CompletableFuture.runAsync(() -> {
            Timestamp initTime = Timestamp.from(Instant.now());
            detailsRepository.save(newDetails);
            gaugeService.submit("gauge.response.updateDetails", timeCalc(initTime, Timestamp.from(Instant.now())));
        });
    }



}
