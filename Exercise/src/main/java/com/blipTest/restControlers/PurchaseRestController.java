package com.blipTest.restControlers;

import com.blipTest.entities.Details;
import com.blipTest.entities.Purchase;
import com.blipTest.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

/**
 * Created by Tiago Matos on 28/09/2016.
 */

@RestController
public class PurchaseRestController {

    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    CompletionStage<ResponseEntity<Collection<Purchase>>> purchases() {
        return this.purchaseService.getAllPurchases().thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "/validDetails", method = RequestMethod.GET)
    CompletionStage<ResponseEntity<Collection<Details>>> validPurchaseDetais() {
        return purchaseService.getAllValidPurchaseDetails().thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.PUT)
    CompletionStage<ResponseEntity<Void>> storePurchase(Purchase newPurchase) {
        return purchaseService.updatePurchase(newPurchase).thenApply(ResponseEntity::ok);
    }

    @Autowired
    PurchaseService purchaseService;


}
