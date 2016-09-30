package com.blipTest.services;

/**
 * Created by Tiago Matos on 28/09/2016.
 */

import com.blipTest.entities.Details;
import com.blipTest.entities.Purchase;
import com.blipTest.metrics.MetricUtils;
import com.blipTest.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


@Service
public class PurchaseService implements MetricUtils {

    private PurchaseRepository purchaseRepository;
    private final CounterService counterService;
    private final GaugeService gaugeService;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, CounterService counterService, GaugeService gaugeService) {
        this.purchaseRepository = purchaseRepository;
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    public CompletionStage<List<Purchase>> getAllPurchases() {
        counterService.increment("counter.calls.getAllPurchases");
        return CompletableFuture.supplyAsync(() -> {
            Timestamp initTime = Timestamp.from(Instant.now());
            List<Purchase> all = purchaseRepository.findAll();
            gaugeService.submit("gauge.response.getAllPurchases", timeCalc(initTime, Timestamp.from(Instant.now())));
            return all;
        });
    }

    public CompletionStage<List<Details>> getAllValidPurchaseDetails() {
        counterService.increment("counter.calls.getAllValidPurchaseDetails");
        return CompletableFuture.supplyAsync(() -> {
            Timestamp initTime = Timestamp.from(Instant.now());
            List<Details> details = this.purchaseRepository.findAllByExpiresGreaterThanEqual(Timestamp.from(Instant.now()))
                    .stream()
                    .map(Purchase::getPurchaseDetails)
                    .collect(Collectors.toList());
            gaugeService.submit("gauge.response.getAllPurchases", timeCalc(initTime, Timestamp.from(Instant.now())));
            return details;
        });
    }

    public CompletionStage<Void> updatePurchase(Purchase newPurchase) {
        counterService.increment("counter.calls.updatePurchase");
        return CompletableFuture.runAsync(() -> {
            Timestamp initTime = Timestamp.from(Instant.now());
            purchaseRepository.save(newPurchase);
            gaugeService.submit("gauge.response.updatePurchase", timeCalc(initTime, Timestamp.from(Instant.now())));
        });
    }


}
