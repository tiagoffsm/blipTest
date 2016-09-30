package com.blipTest.restControlers;

import com.blipTest.entities.Details;
import com.blipTest.services.DetailsService;
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
public class DetailsRestController {

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    CompletionStage<ResponseEntity<Collection<Details>>> details() {
        return this.detailsService.getAllDetails().thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    CompletionStage<ResponseEntity<Void>> storeDetails(Details newDetails) {
        return detailsService.updateDetails(newDetails).thenApply(ResponseEntity::ok);
    }

    @Autowired
    DetailsService detailsService;


}
